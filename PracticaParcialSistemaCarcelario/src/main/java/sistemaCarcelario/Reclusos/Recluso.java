package sistemaCarcelario.Reclusos;

import sistemaCarcelario.Actividad.Actividades;

public abstract  class Recluso {

    private  final int id;
    private static  int autoId=2300;
    private String nombreYApellido;
    private Actividades actividadAsignada;


    public Recluso(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
        this.id= autoId++;
        this.actividadAsignada= Actividades.SIN_ACTIVIDAD;
    }

    public int getId() {
        return id;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public Actividades getActividadAsignada() {
        return actividadAsignada;
    }

    public void setActividadAsignada(Actividades actividadAsignada) {
        this.actividadAsignada = actividadAsignada;
    }

    @Override
    public String toString() {
        return "Recluso: " +
                "\nid: " + id +
                "\nnombreYApellido:" + nombreYApellido +
                "\n Actividad Asignada: "+actividadAsignada;
    }

    abstract public boolean actividadPermitida(Actividades actividadElegida);
}
