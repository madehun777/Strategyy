package bridge;

import java.util.List;

/**
 * Exportador Markdown (simulado).
 */
public class MarkdownExportador implements Exportador {

    @Override
    public void exportar(String titulo, List<String> cuerpo, List<String> extras) {
        System.out.println("# " + titulo);
        for (String linea : cuerpo) {
            System.out.println("- " + linea);
        }
        if (!extras.isEmpty()) {
            System.out.println("## Extras");
            for (String e : extras) {
                System.out.println("- " + e);
            }
        }
    }
}
