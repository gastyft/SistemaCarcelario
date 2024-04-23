package sistemaCarcelario.Actividad;

import sistemaCarcelario.Personal.Personal;
import sistemaCarcelario.Reclusos.Recluso;

public class ActividadSupervisable extends Actividad{

    Personal personalAsignado;

    public ActividadSupervisable(Recluso recluso, Actividades actividadElegida, Personal personalAsignado) {
        super(recluso, actividadElegida);
        this.personalAsignado = personalAsignado;
    }

    public Personal getPersonalAsignado() {
        return personalAsignado;
    }

    public void setPersonalAsignado(Personal personalAsignado) {
        this.personalAsignado = personalAsignado;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\npersonalAsignado:" + personalAsignado;
    }
}
