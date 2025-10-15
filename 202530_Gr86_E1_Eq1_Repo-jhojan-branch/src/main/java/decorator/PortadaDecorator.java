package decorator;

import bridge.Exportador;
import bridge.Informe;

/**
 * Añade una portada al inicio del informe.
 */
public class PortadaDecorator extends DecoradorInforme {

    private String tituloPortada;
    private String autor;

    public PortadaDecorator(Informe informeDecorado, String tituloPortada, String autor) {
        super(informeDecorado);
        this.tituloPortada = tituloPortada;
        this.autor = autor;
    }

    @Override
    public void generar() {
        System.out.println("=== PORTADA ===");
        System.out.println("Título: " + tituloPortada);
        System.out.println("Autor: " + autor);
        System.out.println();
        informeDecorado.generar();
    }
}
