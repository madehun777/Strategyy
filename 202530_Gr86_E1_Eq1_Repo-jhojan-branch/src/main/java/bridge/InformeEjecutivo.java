package bridge;

/**
 * Informe ejecutivo (resumen).
 */
public class InformeEjecutivo extends InformeBase {
    public InformeEjecutivo(String titulo) {
        super(titulo);
    }

    @Override
    public void generar() {
        // Ejemplo: muestra sólo las primeras líneas como resumen
        if (exportador != null) {
            exportador.exportar(titulo, cuerpo, extras);
            return;
        }
        System.out.println("=== INFORME EJECUTIVO: " + titulo + " ===");
        int limit = Math.min(3, cuerpo.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(cuerpo.get(i));
        }
        if (cuerpo.size() > limit) {
            System.out.println("... (resumen, hay más contenido) ...");
        }
        if (!extras.isEmpty()) {
            System.out.println("--- EXTRAS ---");
            for (String e : extras) {
                System.out.println(e);
            }
        }
    }
}
