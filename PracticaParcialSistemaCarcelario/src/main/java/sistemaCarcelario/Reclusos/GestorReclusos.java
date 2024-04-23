package sistemaCarcelario.Reclusos;

import sistemaCarcelario.CRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorReclusos implements CRUD {
    List<Recluso> reclusoList;

    public GestorReclusos( ) {
        this.reclusoList = new ArrayList<>();
    }

    public List<Recluso> getReclusoList() {
        return reclusoList;
    }

    public void setReclusoList(List<Recluso> reclusoList) {
        this.reclusoList = reclusoList;
    }

    @Override
    public void crear() {
        Recluso recluso = new ReclusoSeguridadMinima("Tiziano");
        reclusoList.add(recluso);
        Recluso recluso1 = new ReclusoSeguridadMaxima("El piojo");
        reclusoList.add(recluso1);
        Recluso recluso2 = new ReclusoSeguridadMedia("Radio");
        reclusoList.add(recluso2);
    }
    public Recluso buscar(){
Recluso reclusoABuscar=null;

        System.out.println("Ingrese nombre del Recluso");
        Scanner scanner = new Scanner(System.in);
        String nombreRecluso = scanner.nextLine();
    for(Recluso recluso : reclusoList){
        if(recluso.getNombreYApellido().equals(nombreRecluso)){
            reclusoABuscar= recluso;
        }
    }
        return reclusoABuscar;
    }

    @Override
    public void eliminar() {
        Recluso reclusoAEliminar=buscar();
        if(reclusoAEliminar!= null){
            reclusoList.remove(reclusoAEliminar);
        }
        else System.out.println("No se encontro el recluso o no se pudo eliminar");
    }
    public void editar(){

        Recluso reclusoAEditar= buscar();
        Scanner scanner = new Scanner(System.in);


        if(reclusoAEditar != null){
            System.out.println("Ingrese nuevo nombre");
            String nuevoNombre = scanner.nextLine();
            reclusoAEditar.setNombreYApellido(nuevoNombre);
        }
        else System.out.println("No se encontro el recluso que queria editar");

    }
    public void mostrar(){
        for(Recluso recluso : reclusoList){
            System.out.println(recluso.toString());
        }
    }
}

