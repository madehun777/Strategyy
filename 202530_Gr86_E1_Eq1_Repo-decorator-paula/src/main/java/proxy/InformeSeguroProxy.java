package proxy;

import bridge.Exportador;
import bridge.Informe;
import java.util.function.Function;

/**
 * Proxy que implementa la interfaz Informe para controlar el acceso a la decoración.
 * Esta clase es la que contiene la lógica de seguridad.
 */
public class InformeSeguroProxy implements Informe {

    private Informe informeReal; // Referencia al informe que estamos protegiendo
    private final User usuario;

    /**
     * ESTE ES EL CONSTRUCTOR QUE FALTABA
     * Acepta el informe base y el usuario que realiza la operación.
     */
    public InformeSeguroProxy(Informe informeBase, User usuario) {
        this.informeReal = informeBase;
        this.usuario = usuario;
    }

    /**
     * MÉTODO PROTEGIDO: Permite aplicar un decorador solo si el usuario es "Administrador".
     */
    public void decorarCon(Function<Informe, Informe> fabricaDecorador) throws IllegalAccessException {
        if ("Administrador".equalsIgnoreCase(usuario.getRole())) {
            // Si tiene permiso, aplica el decorador
            this.informeReal = fabricaDecorador.apply(this.informeReal);
        } else {
            // Si no, lanza una excepción para denegar la operación
            throw new IllegalAccessException("Acceso denegado. Se requiere el rol 'Administrador'.");
        }
    }

    /**
     * ESTOS MÉTODOS AHORA EXISTEN
     * Implementan los métodos de la interfaz Informe, delegando la llamada al objeto real.
     */
    @Override
    public void generar() {
        this.informeReal.generar();
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        this.informeReal.establecerExportador(exportador);
    }
}