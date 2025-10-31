package juegomovimiento;

import java.util.Scanner;

public class DemoJuego {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        Personaje miGuerrero = new Personaje();
        
        EstrategiaMovimiento estrategiaCaminar = new CaminarEstrategia();
        EstrategiaMovimiento estrategiaCorrer = new CorrerEstrategia();
        EstrategiaMovimiento estrategiaVolar = new VolarEstrategia();

        System.out.println("--- Personaje creado. Estrategia inicial: ---");
        miGuerrero.ejecutarMovimiento();

        boolean seguirJugando = true;
        
        while (seguirJugando) {
            
            System.out.println("\n===== Elige el próximo movimiento =====");
            System.out.println("1. Caminar");
            System.out.println("2. Correr");
            System.out.println("3. Volar");
            System.out.println("4. Salir del juego");
            System.out.print("Tu opción: ");

            int opcion = scanner.nextInt();
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
                    seguirJugando = false;
                    System.out.println("¡Adiós! Has salido del juego.");
                    break;
                default:
                    System.out.println("¡Opción no válida! El personaje se queda quieto.");
                    continue; 
            }

            if (seguirJugando) {
                miGuerrero.ejecutarMovimiento();
            }
        }
        scanner.close();
    }
}