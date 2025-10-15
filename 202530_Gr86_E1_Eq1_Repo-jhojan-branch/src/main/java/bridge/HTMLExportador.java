package bridge;

import java.util.List;

/**
 * Exportador que "genera" HTML (simulado por consola).
 */
public class HTMLExportador implements Exportador {

    @Override
    public void exportar(String titulo, List<String> cuerpo, List<String> extras) {
        System.out.println("<html>");
        System.out.println("<head><title>" + titulo + "</title></head>");
        System.out.println("<body>");
        System.out.println("<h1>" + titulo + "</h1>");
        for (String linea : cuerpo) {
            System.out.println("<p>" + linea + "</p>");
        }
        if (!extras.isEmpty()) {
            System.out.println("<hr/>");
            for (String e : extras) {
                System.out.println("<div class='extra'>" + e + "</div>");
            }
        }
        System.out.println("</body></html>");
    }
}
