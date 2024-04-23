package sistemaCarcelario.Reclusos;

import sistemaCarcelario.Actividad.Actividades;

public class ReclusoSeguridadMedia extends  Recluso{
    public ReclusoSeguridadMedia(String nombreYApellido) {
        super(nombreYApellido);
    }
    public boolean actividadPermitida(Actividades actividadElegida){
        boolean aDevolver;
        if(actividadElegida ==Actividades.REHABILITACION || actividadElegida == Actividades.MANTENIMIENTO_SUPERVISION)
            aDevolver =true;
        else
            aDevolver =false;
        return aDevolver;
    }
}
