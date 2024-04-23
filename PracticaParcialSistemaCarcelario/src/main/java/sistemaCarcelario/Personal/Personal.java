package sistemaCarcelario.Personal;

import sistemaCarcelario.Supervisable;

public class Personal implements Supervisable {
    private final int id;
    private static int autoid = 0;
    private String nombreYApellido;
    private final String legajo;
    private boolean isDisponible;

    public Personal(String nombreYApellido, String legajo) {
        this.id = autoid++;
        this.nombreYApellido = nombreYApellido;
        this.legajo = "PNA" + legajo;
        this.isDisponible = true;
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

    public String getLegajo() {
        return legajo;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    @Override
    public String toString() {
        return "Personal:" +
                "\nid: " + id +
                "\nnombreYApellido:" + nombreYApellido +
                "\nlegajo: " + legajo +
                "\nisDisponible:" + isDisponible;
    }

    @Override
    public void iniciarActividad() {
        if (isDisponible == true)
            this.isDisponible = false;
        else System.out.println("El personal ya esta asignado a otra actividad");
    }

public void finalizarActividad(){
        this.isDisponible =true;
    System.out.println("El personal asignado ha dejado de ejercer actividad supervisable");
}
}
