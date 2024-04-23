package sistemaCarcelario.Actividad;

import sistemaCarcelario.CRUD;
import sistemaCarcelario.Personal.Personal;
import sistemaCarcelario.Reclusos.Recluso;
import sistemaCarcelario.Reclusos.ReclusoSeguridadMaxima;
import sistemaCarcelario.Reclusos.ReclusoSeguridadMedia;
import sistemaCarcelario.Reclusos.ReclusoSeguridadMinima;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorActividad {
    List<Actividad> actividadList;

    public GestorActividad() {
        this.actividadList = new ArrayList<>();
    }

    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public void crear(Recluso recluso, Actividades actividadElegida, Personal personal) {
        if (recluso instanceof ReclusoSeguridadMinima) {
            if (actividadElegida == Actividades.MANTENIMIENTO_SUPERVISION || actividadElegida == Actividades.PATIO_SUPERVISION || actividadElegida == Actividades.VISITA_FAMILIAR_SUPERVISION) {

                Actividad actividad = new ActividadSupervisable(recluso, actividadElegida, personal);

                actividadList.add(actividad);
                System.out.println("Actividad creada con exito");
            } else {
                Actividad actividad = new Actividad(recluso, actividadElegida);
                actividadList.add(actividad);
                System.out.println("Actividad creada con exito");
            }
        } else if (recluso instanceof ReclusoSeguridadMedia reclusoSeguridadMedia) {
            if (reclusoSeguridadMedia.actividadPermitida(actividadElegida)) {
                if (actividadElegida == Actividades.MANTENIMIENTO_SUPERVISION) {
                    Actividad actividad = new ActividadSupervisable(reclusoSeguridadMedia, actividadElegida, personal);
                    actividadList.add(actividad);
                    System.out.println("Actividad creada con exito");

                } else if (actividadElegida == Actividades.REHABILITACION) {
                    Actividad actividad = new Actividad(reclusoSeguridadMedia, actividadElegida);
                    actividadList.add(actividad);
                    System.out.println("Actividad creada con exito");
                } else System.out.println("Actividad no permitida error al crear");
            } else System.out.println("Actividad no permitida error al crear funcion ActividadPermitida");
        } else if (recluso instanceof ReclusoSeguridadMaxima reclusoSeguridadMaxima) {
            if (reclusoSeguridadMaxima.actividadPermitida(actividadElegida)) {
                if (actividadElegida == Actividades.REHABILITACION) {
                    Actividad actividad = new Actividad(reclusoSeguridadMaxima, actividadElegida);
                    actividadList.add(actividad);
                    System.out.println("Actividad creada con exito");
                } else System.out.println("Actividad no permitida error al crear");

            }
        }
    }


    public void editar() {
        System.out.println("No se puede editar la actividad asignada");
    }

    public Actividad buscar() {
        Scanner scanner = new Scanner(System.in);
        Actividad actividadABuscar = null;

        String nombreRecluso = scanner.nextLine();
        String actividad1 = scanner.nextLine();
        for (Actividad actividad : actividadList) {
            if (actividad.getRecluso().getNombreYApellido().equals(nombreRecluso) && actividad.getActividadElegida().name().equals(actividad1)) {
                return actividadABuscar = actividad;
            }

        }
        return actividadABuscar;
    }

    public void eliminar() {
        System.out.println("Ingrese nombre de recluso  y actividad para eliminar actividad asignada");
        Actividad actividadAEliminar = buscar();
        if (actividadAEliminar != null) {
            actividadList.remove(actividadAEliminar);
        }
    }

    public void mostrar() {
        for (Actividad actividad : actividadList) {
            if (actividad instanceof ActividadSupervisable actividadSupervisable)
                System.out.println(actividadSupervisable.toString());
            else System.out.println(actividad.toString());
        }

    }

}
