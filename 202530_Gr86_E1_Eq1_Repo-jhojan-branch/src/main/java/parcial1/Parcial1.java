package parcial1;

import bridge.Informe;
import bridge.InformeDetallado;
import bridge.InformeEjecutivo;
import bridge.HTMLExportador;
import bridge.MarkdownExportador;
import decorator.PortadaDecorator;
import decorator.EncabezadoDecorator;
import decorator.MarcaDeAguaDecorator;
import decorator.PiePaginaDecorator;
import proxy.InformeSeguroProxy; // <-- Importamos las clases del proxy
import proxy.User;
import flyweight.FabricaEstilo;

/**
 * Ejemplo de uso combinando Bridge, Decorator, Flyweight y Proxy.
 */
public class Parcial1 {

    public static void main(String[] args) {

        // --- CREAR INFORMES (abstracción) ---
        Informe detalle = new InformeDetallado("Informe de Ventas - Octubre");
        Informe ejecutivo = new InformeEjecutivo("Resumen Ejecutivo - Octubre");

        // Añadimos contenido al informe detallado
        if (detalle instanceof bridge.InformeBase) {
            bridge.InformeBase ib = (bridge.InformeBase) detalle;
            ib.agregarLinea("Venta total: $12.000");
            ib.agregarLinea("Incremento vs mes anterior: 8%");
            ib.agregarLinea("Productos top: A, B, C");
        }

        if (ejecutivo instanceof bridge.InformeBase) {
            bridge.InformeBase ib2 = (bridge.InformeBase) ejecutivo;
            ib2.agregarLinea("Venta total: $12.000");
            ib2.agregarLinea("Incremento: 8%");
            ib2.agregarLinea("Recomendación: mantener oferta");
            ib2.agregarExtra("Nota: cifras preliminares");
        }

        // --- EXPORTADORES (implementaciones del bridge) ---
        HTMLExportador html = new HTMLExportador();
        MarkdownExportador md = new MarkdownExportador();

        detalle.establecerExportador(html);
        ejecutivo.establecerExportador(md);

        // --- FLYWEIGHT: reutilización de estilos ---
        FabricaEstilo fabrica = new FabricaEstilo();
        var estilo1 = fabrica.obtenerEstilo("Arial", 12, "negro");
        var estilo2 = fabrica.obtenerEstilo("Arial", 12, "negro");
        var estilo3 = fabrica.obtenerEstilo("Times New Roman", 14, "azul");

        System.out.println("Estilos creados/reusados:");
        System.out.println(estilo1);
        System.out.println(estilo2);
        System.out.println(estilo3);
        System.out.println("estilo1 == estilo2 ? " + (estilo1 == estilo2));

        // --- PROXY: control de acceso para decorar ---
        User admin = new User("Administrador");
        User visualizador = new User("Visualizador");

        InformeSeguroProxy proxyAdmin = new InformeSeguroProxy(detalle, admin);
        InformeSeguroProxy proxyVisualizador = new InformeSeguroProxy(ejecutivo, visualizador);

        try {
            // El admin aplica varios decoradores (permitido)
            proxyAdmin.decorarCon(inf -> new PortadaDecorator(inf, "Portada Oficial", "Equipo"));
            proxyAdmin.decorarCon(inf -> new EncabezadoDecorator(inf, "Confidencial"));
            proxyAdmin.decorarCon(inf -> new MarcaDeAguaDecorator(inf, "TOP SECRET"));
            proxyAdmin.decorarCon(inf -> new PiePaginaDecorator(inf, "Página 1"));

            System.out.println("Informe detallado con decoradores (exportando):");
            proxyAdmin.generar(); // utilizará el exportador HTML
        } catch (IllegalAccessException e) {
            System.err.println("ERROR permisos admin: " + e.getMessage());
        }

        try {
            // El visualizador INTENTA aplicar un decorador. Esta línea fallará.
            System.out.println("\nEl Visualizador intenta aplicar un decorador...");
            proxyVisualizador.decorarCon(inf -> new PortadaDecorator(inf, "Intento Fallido", "Usuario"));
        } catch (IllegalAccessException e) {
            System.err.println("✅ ÉXITO: La operación fue bloqueada como se esperaba. Causa: " + e.getMessage());
        }

        System.out.println("\nInforme final para el Visualizador (sin decorar):");
        proxyVisualizador.generar();

    }
}
