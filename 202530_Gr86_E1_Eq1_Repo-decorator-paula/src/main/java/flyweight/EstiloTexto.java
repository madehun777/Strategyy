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
 

public class EstiloTexto {
    private String tipoLetra;
    private int tamano;
    private String color;

    public EstiloTexto(String tipoLetra, int tamano, String color) {
        this.tipoLetra = tipoLetra;
        this.tamano = tamano;
        this.color = color;
    }

    public void aplicar(String texto) {
        System.out.println("[Estilo: " + tipoLetra + ", " + tamano + "pt, " + color + "] " + texto);
    }
}



