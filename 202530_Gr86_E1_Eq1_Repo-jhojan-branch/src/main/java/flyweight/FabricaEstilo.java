package flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Fabrica que reusa objetos EstiloTexto.
 */
public class FabricaEstilo {
    private final Map<String, EstiloTexto> memoriaTextos = new HashMap<>();

    public EstiloTexto obtenerEstilo(String tipoLetra, int tamano, String color) {
        String clave = tipoLetra + "-" + tamano + "-" + color;
        EstiloTexto estilo = memoriaTextos.get(clave);

        if (estilo == null) {
            estilo = new EstiloTexto(tipoLetra, tamano, color);
            memoriaTextos.put(clave, estilo);
        }

        return estilo;
    }
}
