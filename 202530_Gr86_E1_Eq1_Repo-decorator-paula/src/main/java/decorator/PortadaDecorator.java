package decorator;

import bridge.Informe;
import bridge.Exportador;

public class PortadaDecorator extends DecoradorInforme {
    
    private String titulo;
    private String autor;

    public PortadaDecorator(Informe informeDecorado, String titulo, String autor) {
        super(informeDecorado);
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public void generar() {
        System.out.println("=== PORTADA ===");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println();
        informeDecorado.generar(); // sigue con el informe normal
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeDecorado.establecerExportador(exportador);
    }
}

