package flyweight;

/**
 * Flyweight que representa el estado intrínseco de un estilo de texto.
 */
public class EstiloTexto {
    private final String tipoLetra;
    private final int tamano;
    private final String color;

    public EstiloTexto(String tipoLetra, int tamano, String color) {
        this.tipoLetra = tipoLetra;
        this.tamano = tamano;
        this.color = color;
    }

    public String getTipoLetra() { return tipoLetra; }
    public int getTamano() { return tamano; }
    public String getColor() { return color; }

    @Override
    public String toString() {
        return "Estilo[" + tipoLetra + "," + tamano + "," + color + "]";
    }
}
