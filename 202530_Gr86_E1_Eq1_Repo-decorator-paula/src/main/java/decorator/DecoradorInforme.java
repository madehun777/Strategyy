/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;
import bridge.Exportador;
import bridge.Informe;
/**
 *
 * @author manos
 */
 
    


public abstract class DecoradorInforme implements Informe {
    protected Informe informeDecorado;

    public DecoradorInforme(Informe informeDecorado) {
        this.informeDecorado = informeDecorado;
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeDecorado.establecerExportador(exportador);
    }
}


