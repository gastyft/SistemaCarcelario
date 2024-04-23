package sistemaCarcelario.Actividad;

import javax.swing.plaf.PanelUI;

public enum Actividades {

    PATIO_SUPERVISION("Actividad con Supervision"),
    EDUCACION("Sin supervision"),
    BIBLIOTECA("Sin Supervision"),
    VISITA_FAMILIAR_SUPERVISION("Actividad con Supervision"),
    REHABILITACION("Sin Supervision"),
    MANTENIMIENTO_SUPERVISION("Actividad con Supervision"),
    SIN_ACTIVIDAD("Sin Actividad Asignada");
    private String decrip;

    Actividades(String decrip) {
        this.decrip = decrip;
    }

    public String getDecrip() {
        return decrip;
    }

}
