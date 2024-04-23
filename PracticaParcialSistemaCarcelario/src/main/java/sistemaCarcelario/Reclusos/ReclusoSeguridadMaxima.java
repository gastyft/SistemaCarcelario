package sistemaCarcelario.Reclusos;

import sistemaCarcelario.Actividad.Actividades;

public class ReclusoSeguridadMaxima extends Recluso {

    public ReclusoSeguridadMaxima(String nombreYApellido) {
        super(nombreYApellido);
    }

    public boolean actividadPermitida(Actividades actividadElegida) {
        boolean aDevolver;
        if (actividadElegida == Actividades.REHABILITACION) {
            aDevolver = true;
        } else aDevolver = false;
        return aDevolver;
    }

}
