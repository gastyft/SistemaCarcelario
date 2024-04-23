package sistemaCarcelario.Actividad;

import sistemaCarcelario.Personal.Personal;
import sistemaCarcelario.Reclusos.Recluso;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Actividad {
    private static int autoId = 0;
    private final int id;

    private Recluso recluso;
    private Actividades actividadElegida;
    private LocalDateTime inicioActividad;
    private LocalDateTime finalizacionActividad;

    public Actividad(Recluso recluso, Actividades actividadElegida) {
        this.recluso = recluso;
        this.actividadElegida = actividadElegida;
        this.inicioActividad = LocalDateTime.now();
        this.id = autoId++;
    }

    public int getId() {
        return id;
    }

    public Recluso getRecluso() {
        return recluso;
    }

    public void setRecluso(Recluso recluso) {
        this.recluso = recluso;
    }

    public Actividades getActividadElegida() {
        return actividadElegida;
    }

    public void setActividadElegida(Actividades actividadElegida) {
        this.actividadElegida = actividadElegida;
    }

    public LocalDateTime getInicioActividad() {
        return inicioActividad;
    }

    public void setInicioActividad(LocalDateTime inicioActividad) {
        this.inicioActividad = inicioActividad;
    }

    public LocalDateTime getFinalizacionActividad() {
        return finalizacionActividad;
    }

    public void setFinalizacionActividad(LocalDateTime finalizacionActividad) {
        this.finalizacionActividad = finalizacionActividad;
    }

    @Override
    public String toString() {
        return "\nActividad" +
                "\nid: " + id +
                "\nrecluso: " + recluso +
                "\nactividadElegida: " + actividadElegida +
                "\ninicioActividad: " + inicioActividad +
                "\nfinalizacionActividad: " + finalizacionActividad;
    }

    //Funcion finalizar que asigna un valor para finalizar actividad elegida;
    public void finalizarActividad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese año, mes, dia, hora y minutos para dar una fecha de finalizacion a esta actividad\n");
        LocalDateTime fechafinalizacion = LocalDateTime.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 00);
        this.finalizacionActividad = fechafinalizacion;
    }
}
