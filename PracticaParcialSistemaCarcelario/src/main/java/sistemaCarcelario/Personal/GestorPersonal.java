package sistemaCarcelario.Personal;

import sistemaCarcelario.CRUD;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPersonal implements CRUD {

    List<Personal> personalList;

    public GestorPersonal() {
        this.personalList = new ArrayList<>();
    }

    public List<Personal> getPersonalList() {
        return personalList;
    }

    public void setPersonalList(List<Personal> personalList) {
        this.personalList = personalList;
    }

    public void crear() {
        Personal personal = new Personal("Sargento García", "123532");
        personalList.add(personal);
        Personal personal1 = new Personal("Teniente Lopez", "97265");
        personalList.add(personal1);
        Personal personal2 = new Personal("Cabo Gutierrez", "837285");
        personalList.add(personal2);

    }

    public void editar() {
        System.out.println("Ingrese nombre a editar");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        boolean flag = false;
        for (Personal personal : personalList) {
            if (personal.getNombreYApellido().equals(nombre)) {
                System.out.println("Ingrese nuevo nombre:");
                personal.setNombreYApellido(scanner.nextLine());
                flag = true;
            }
        }
        if (flag == false) System.out.println("No se encontro el personal");
    }

    public Personal buscar() {


        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        Personal personalABuscar = null;
        for (Personal personal : personalList) {
            if (personal.getNombreYApellido().equals(nombre)) {
                personalABuscar =personal;

            }
        }
        return  personalABuscar;
    }
public void eliminar(){
    System.out.println("Ingrese nombre a eliminar");
        Personal personalAEliminar=buscar();
        if(personalAEliminar!= null){
            personalList.remove(personalAEliminar);
        }
        else System.out.println("No se encontro el personal");
}
public void mostrar(){
        for(Personal personal : personalList){
            System.out.println(personal.toString());
        }
}
}
