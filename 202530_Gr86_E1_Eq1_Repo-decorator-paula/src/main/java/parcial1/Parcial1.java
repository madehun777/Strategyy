package parcial1;

import bridge.Informe;
import decorator.PortadaDecorator;
import decorator.EncabezadoDecorator;
import decorator.MarcaDeAguaDecorator;
import decorator.PiePaginaDecorator;
import proxy.InformeSeguroProxy; // <-- Importamos las clases del proxy
import proxy.User;

public class Parcial1 {

    public static void main(String[] args) {

        // --- CONFIGURACIÓN INICIAL (se mantiene igual) ---
        Informe informeBase = new Informe() {
            @Override
            public void generar() {
                System.out.println("Contenido principal del informe...");
            }

            @Override
            public void establecerExportador(bridge.Exportador exportador) {
                // No hace nada en este ejemplo sencillo
            }
        };

        // --- CREAMOS USUARIOS PARA LA DEMOSTRACIÓN ---
        User admin = new User("Administrador");
        User visualizador = new User("Visualizador");

        System.out.println("--- 👨‍💼 PRUEBA CON USUARIO ADMINISTRADOR (DEBE FUNCIONAR) ---");
        
        // 1. Creamos un PROXY para el administrador, pasándole el informe base.
        InformeSeguroProxy proxyAdmin = new InformeSeguroProxy(informeBase, admin);

        try {
            // 2. En lugar de crear variables intermedias, aplicamos cada decorador
            // usando el método protegido del proxy.
            System.out.println("El Administrador está aplicando decoradores...");
            proxyAdmin.decorarCon(inf -> new PortadaDecorator(inf, "Informe Final", "Paula"));
            proxyAdmin.decorarCon(inf -> new EncabezadoDecorator(inf, "Universidad Distrital - Ingeniería de Sistemas"));
            proxyAdmin.decorarCon(inf -> new MarcaDeAguaDecorator(inf, "Confidencial - Uso Interno"));
            proxyAdmin.decorarCon(inf -> new PiePaginaDecorator(inf, "Página 1 - Reporte 2025"));

            // 3. Generamos el informe completo a través del proxy.
            System.out.println("\n✅ Informe final para el Administrador:");
            proxyAdmin.generar();

        } catch (IllegalAccessException e) {
            System.err.println("❌ Error inesperado para el admin: " + e.getMessage());
        }

        System.out.println("\n" + "=".repeat(60) + "\n");

        System.out.println("--- 👤 PRUEBA CON USUARIO VISUALIZADOR (DEBE FALLAR) ---");
        
        // 1. Creamos OTRO PROXY para el visualizador.
        InformeSeguroProxy proxyVisualizador = new InformeSeguroProxy(informeBase, visualizador);

        try {
            // 2. El visualizador INTENTA aplicar un decorador. Esta línea fallará.
            System.out.println("El Visualizador intenta aplicar un decorador...");
            proxyVisualizador.decorarCon(inf -> new PortadaDecorator(inf, "Intento Fallido", "Usuario"));
            
        } catch (IllegalAccessException e) {
            // 3. La excepción es capturada, demostrando que el proxy funcionó.
            System.err.println("✅ ÉXITO: La operación fue bloqueada como se esperaba. Causa: " + e.getMessage());
        }

        // 4. El informe del visualizador sigue siendo el original.
        System.out.println("\nInforme final para el Visualizador (sin decorar):");
        proxyVisualizador.generar();
    }
}