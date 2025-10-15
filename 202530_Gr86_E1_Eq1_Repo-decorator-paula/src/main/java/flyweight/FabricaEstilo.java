/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flyweight;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author manos
 */
 



public class FabricaEstilo {
    private Map<String, EstiloTexto> memoriaTextos = new HashMap<>();

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

