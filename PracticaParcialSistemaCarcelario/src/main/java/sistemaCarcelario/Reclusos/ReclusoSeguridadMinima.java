package sistemaCarcelario.Reclusos;

import sistemaCarcelario.Actividad.Actividades;

public class ReclusoSeguridadMinima extends Recluso {

    public ReclusoSeguridadMinima(String nombreYApellido) {
        super(nombreYApellido);
    }

    public boolean actividadPermitida(Actividades actividadElegida) {
        //Funcion actividad permitida que valida si puede realizarla o no por cada subclase

        return true; //Todas actividades disponibles
    }

}
