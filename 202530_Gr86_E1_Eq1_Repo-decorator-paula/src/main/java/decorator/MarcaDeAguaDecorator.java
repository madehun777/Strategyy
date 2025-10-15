package decorator;

import bridge.Informe;
import bridge.Exportador;

public class MarcaDeAguaDecorator extends DecoradorInforme {

    private String textoMarca;

    public MarcaDeAguaDecorator(Informe informeDecorado, String textoMarca) {
        super(informeDecorado);
        this.textoMarca = textoMarca;
    }

    @Override
    public void generar() {
        // Simula la marca de agua mostrando un texto entre paréntesis
        System.out.println("[Marca de agua: " + textoMarca + "]");
        informeDecorado.generar();
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeDecorado.establecerExportador(exportador);
    }
}
