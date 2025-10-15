/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package parcial1;

import bridge.Informe;
import decorator.PortadaDecorator;
import decorator.EncabezadoDecorator;
import decorator.MarcaDeAguaDecorator;
import decorator.PiePaginaDecorator;

/**
 *
 * @author manos
 */

public class Parcial1 {

    public static void main(String[] args) {
       
        // Informe base (sencillo)
        Informe informeBase = new Informe() {
            @Override
            public void generar() {
                System.out.println("Contenido principal del informe...");
            }

            @Override
            public void establecerExportador(bridge.Exportador exportador) {
                
            }
        };

         // Aplicación de decoradores 
        Informe informeConPortada = new PortadaDecorator(informeBase, "Informe Final", "Paula");
        Informe informeConEncabezado = new EncabezadoDecorator(informeConPortada, "Universidad Distrital - Ingeniería de Sistemas");
        Informe informeConMarca = new MarcaDeAguaDecorator(informeConEncabezado, "Confidencial - Uso Interno");
        Informe informeCompleto = new PiePaginaDecorator(informeConMarca, "Página 1 - Reporte 2025");

        
        informeCompleto.generar();
    }
}
