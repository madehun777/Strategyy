package juegomovimiento;

// 1. Importamos la clase Scanner para leer la entrada del usuario
import java.util.Scanner;

public class DemoJuego {

    public static void main(String[] args) {
        
        // 2. Creamos un Scanner para leer de la consola
        Scanner scanner = new Scanner(System.in);
        
        // Creamos nuestro personaje
        Personaje miGuerrero = new Personaje();
        
        // --- Para ser más eficientes, creamos las estrategias una sola vez ---
        // El juego sigue controlando la velocidad y los detalles.
        EstrategiaMovimiento estrategiaCaminar = new CaminarEstrategia();
        EstrategiaMovimiento estrategiaCorrer = new CorrerEstrategia();
        EstrategiaMovimiento estrategiaVolar = new VolarEstrategia();

        System.out.println("--- Personaje creado. Estrategia inicial: ---");
        miGuerrero.ejecutarMovimiento(); // Muestra el estado inicial (Caminar)

        boolean seguirJugando = true;
        
        // 3. Creamos un bucle (loop) para que el juego siga corriendo
        while (seguirJugando) {
            
            // 4. Mostramos el menú de opciones al usuario
            System.out.println("\n===== Elige el próximo movimiento =====");
            System.out.println("1. Caminar");
            System.out.println("2. Correr");
            System.out.println("3. Volar");
            System.out.println("4. Salir del juego");
            System.out.print("Tu opción: ");

            // 5. Leemos el número que el usuario ingrese
            int opcion = scanner.nextInt();

            // 6. Usamos un 'switch' para decidir qué estrategia poner
            switch (opcion) {
                case 1:
                    miGuerrero.setEstrategia(estrategiaCaminar);
                    break;
                case 2:
                    miGuerrero.setEstrategia(estrategiaCorrer);
                    break;
                case 3:
                    miGuerrero.setEstrategia(estrategiaVolar);
                    break;
                case 4:
                    seguirJugando = false; // Terminamos el bucle 'while'
                    System.out.println("¡Adiós! Has salido del juego.");
                    break;
                default:
                    System.out.println("¡Opción no válida! El personaje se queda quieto.");
                    // Usamos 'continue' para saltar al inicio del bucle sin ejecutar el movimiento
                    continue; 
            }

            // 7. Si no salimos, ejecutamos el movimiento elegido
            if (seguirJugando) {
                miGuerrero.ejecutarMovimiento();
            }
        }
        
        // 8. Cerramos el scanner al final (buena práctica)
        scanner.close();
    }
}