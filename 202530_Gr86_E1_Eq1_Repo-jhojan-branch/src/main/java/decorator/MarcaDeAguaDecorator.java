package decorator;

import bridge.Exportador;
import bridge.Informe;

/**
 * Simula una marca de agua al generar.
 */
public class MarcaDeAguaDecorator extends DecoradorInforme {

    private String textoMarca;

    public MarcaDeAguaDecorator(Informe informeDecorado, String textoMarca) {
        super(informeDecorado);
        this.textoMarca = textoMarca;
    }

    @Override
    public void generar() {
        System.out.println("[Marca de agua: " + textoMarca + "]");
        informeDecorado.generar();
    }
}
