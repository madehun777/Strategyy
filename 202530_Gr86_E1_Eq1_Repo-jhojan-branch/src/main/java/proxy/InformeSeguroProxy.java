//Paquete
package proxy;

import bridge.Exportador;
import bridge.Informe;
import java.util.function.Function;

/**
 * Proxy que controla quién puede aplicar decoradores (sólo Administrador).
 */
public class InformeSeguroProxy implements Informe {

    private Informe informeReal;
    private final User usuario;

    public InformeSeguroProxy(Informe informeReal, User usuario) {
        this.informeReal = informeReal;
        this.usuario = usuario;
    }

    @Override
    public void generar() {
        informeReal.generar();
    }

    @Override
    public void establecerExportador(Exportador exportador) {
        informeReal.establecerExportador(exportador);
    }

    /**
     * Permite aplicar un decorador sobre el informe si el usuario tiene permisos.
     * @param decorador función que transforma el informe
     * @throws IllegalAccessException si el usuario no tiene rol Administrador
     */
    public void decorarCon(Function<Informe, Informe> decorador) throws IllegalAccessException {
        if (!"Administrador".equalsIgnoreCase(usuario.getRole())) {
            throw new IllegalAccessException("El usuario no tiene permiso para decorar (se requiere Administrador).");
        }
        this.informeReal = decorador.apply(this.informeReal);
    }
}
