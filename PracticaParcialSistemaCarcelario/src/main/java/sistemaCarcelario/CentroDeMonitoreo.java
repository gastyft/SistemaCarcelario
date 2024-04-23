package sistemaCarcelario;

import sistemaCarcelario.Actividad.Actividad;
import sistemaCarcelario.Actividad.ActividadSupervisable;
import sistemaCarcelario.Actividad.Actividades;
import sistemaCarcelario.Actividad.GestorActividad;
import sistemaCarcelario.Personal.GestorPersonal;
import sistemaCarcelario.Personal.Personal;
import sistemaCarcelario.Reclusos.GestorReclusos;
import sistemaCarcelario.Reclusos.Recluso;
import sistemaCarcelario.Reclusos.ReclusoSeguridadMinima;

import java.util.List;
import java.util.Scanner;

public class CentroDeMonitoreo {
    GestorPersonal gestorPersonal = new GestorPersonal();
    GestorReclusos gestorReclusos = new GestorReclusos();
    GestorActividad gestorActividad = new GestorActividad();

    Actividades[] actividadesList = Actividades.values();

    public void crearPersonalYReclusos(){
        gestorPersonal.crear();
        gestorReclusos.crear();

    }
    public void crearActividad(){
        gestorReclusos.mostrar();
        System.out.println(" \n\nCREAR ACTIVIDAD PARA RECLUSO");
        Recluso recluso =gestorReclusos.buscar();
        Scanner scanner = new Scanner(System.in);
        if(recluso!=null) {
            for (Actividades actividades : actividadesList) {
                System.out.println("Actividad: " + actividades.name() + "  Descripcion: " + actividades.getDecrip());
            }
            System.out.println("Elija una actividad");
            String actividadaElegir = scanner.nextLine().toUpperCase();
            Actividades actividadElegida = null;
            for (Actividades actividad : Actividades.values()) {
                if (actividad.name().equals(actividadaElegir)) {
                    // Si el nombre de la actividad coincide con la cadena ingresada
                    actividadElegida = actividad;
                    break;
                }
            }
            if(actividadElegida!= null && recluso.actividadPermitida(actividadElegida)){
                gestorPersonal.mostrar();

                System.out.println("\n\nINGRESE NOMBRE DEL PERSONAL A ASIGNAR");
                Personal personalELegido = gestorPersonal.buscar();
                if (personalELegido != null )
                    if(personalELegido.isDisponible()) {
                        gestorActividad.crear(recluso, actividadElegida, personalELegido);
                        personalELegido.iniciarActividad();
                        recluso.setActividadAsignada(actividadElegida);
                    }
                else System.out.println("No se encontro el personal a asignar actividad");
            }
            else System.out.println("Actividad mal tipeada o no existe o no esta permitido por nivel de seguridad");
        }
        else System.out.println("No se encontro el recluso para asignarle actividad nueva");
    }

    public void eliminarRecluso(){
        gestorReclusos.eliminar();
    }
    public void mostrarTodo(){
        gestorReclusos.mostrar();
        gestorPersonal.mostrar();
        gestorActividad.mostrar();
    }
    public void finalizarActividad(){

        gestorActividad.mostrar();
        System.out.println("Elija nombre de recluso y nombre de actividad a finalizar");
        Actividad actividadAFinalizar = gestorActividad.buscar();
        actividadAFinalizar.finalizarActividad();
        if(actividadAFinalizar instanceof ActividadSupervisable actividadSupervisable){
            Personal personalAFinalizar = actividadSupervisable.getPersonalAsignado();
            Recluso reclusoAFinalizar = actividadAFinalizar.getRecluso();
            reclusoAFinalizar.setActividadAsignada(Actividades.SIN_ACTIVIDAD);
            personalAFinalizar.finalizarActividad();
            gestorPersonal.getPersonalList().set(gestorPersonal.getPersonalList().indexOf(personalAFinalizar),personalAFinalizar);
            gestorReclusos.getReclusoList().set(gestorReclusos.getReclusoList().indexOf(reclusoAFinalizar),reclusoAFinalizar);
        }

    }
    public void iniciar(){
       crearPersonalYReclusos();
        mostrarTodo();
        System.out.println("\n\n\nINGRESE NOMBRE RECLUSO A EDITAR");
        gestorReclusos.editar();
     gestorReclusos.mostrar();
        System.out.println("\n\n\nINGRESE NOMBRE RECLUSO A BORRAR");
        eliminarRecluso();
        mostrarTodo();
        crearActividad();
        System.out.println("-------------------------------------------------\n\n\n");
        mostrarTodo();
    }



}
