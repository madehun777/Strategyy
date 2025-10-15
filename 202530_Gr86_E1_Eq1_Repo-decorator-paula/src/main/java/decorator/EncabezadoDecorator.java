package decorator;

import bridge.Informe;
import bridge.Exportador;

public class EncabezadoDecorator extends DecoradorInforme {

    private String tituloEncabezado;

    public EncabezadoDecorator(Informe informeDecorado, String tituloEncabezado) {
        super(informeDecorado);
        this.tituloEncabezado = tituloEncabezado;
    }

    @Override
    public void generar() {
        System.out.println("=== " + tituloEncabezado + " ===");
        informeDecorado.generar();
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeDecorado.establecerExportador(exportador);
    }
}

