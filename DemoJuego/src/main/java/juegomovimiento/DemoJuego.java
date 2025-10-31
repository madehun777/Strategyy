package juegomovimiento;

public class DemoJuego {

    public static void main(String[] args) {
        
        System.out.println("--- Creando nuevo personaje (Guerrero) ---");
        Personaje miGuerrero = new Personaje();

        // 1. El personaje usa la estrategia por defecto (Caminar)
        System.out.print("Primer movimiento: ");
        miGuerrero.ejecutarMovimiento(); // Salida: Caminando...

        System.out.println("\n--- El jugador presiona el botón de correr ---");
        
        // 2. Cambiamos la estrategia a Correr
        // Creamos un objeto de la nueva estrategia
        EstrategiaMovimiento estrategiaCorrer = new CorrerEstrategia();
        // Se la asignamos al personaje
        miGuerrero.setEstrategia(estrategiaCorrer);
        
        System.out.print("Segundo movimiento: ");
        miGuerrero.ejecutarMovimiento(); // Salida: Corriendo...

        System.out.println("\n--- El jugador encuentra un 'power-up' de vuelo ---");
        
        // 3. Cambiamos la estrategia a Volar (creándola directamente)
        miGuerrero.setEstrategia(new VolarEstrategia());
        
        System.out.print("Tercer movimiento: ");
        miGuerrero.ejecutarMovimiento(); // Salida: Volando...
    }
}