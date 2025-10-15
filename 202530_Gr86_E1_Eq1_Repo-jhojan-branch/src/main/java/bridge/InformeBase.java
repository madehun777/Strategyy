package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación base de Informe que contiene la lógica común.
 */
public abstract class InformeBase implements Informe {
    protected String titulo;
    protected List<String> cuerpo;
    protected List<String> extras;
    protected Exportador exportador;

    public InformeBase(String titulo) {
        this.titulo = titulo;
        this.cuerpo = new ArrayList<>();
        this.extras = new ArrayList<>();
    }

    public void agregarLinea(String linea) {
        this.cuerpo.add(linea);
    }

    public void agregarExtra(String extra) {
        this.extras.add(extra);
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        this.exportador = exportador;
    }

    @Override
    public void generar() {
        if (this.exportador != null) {
            this.exportador.exportar(titulo, cuerpo, extras);
        } else {
            // Modo consola: imprime el informe
            System.out.println("=== INFORME: " + titulo + " ===");
            for (String linea : cuerpo) {
                System.out.println(linea);
            }
            if (!extras.isEmpty()) {
                System.out.println("--- EXTRAS ---");
                for (String e : extras) {
                    System.out.println(e);
                }
            }
        }
    }
}
