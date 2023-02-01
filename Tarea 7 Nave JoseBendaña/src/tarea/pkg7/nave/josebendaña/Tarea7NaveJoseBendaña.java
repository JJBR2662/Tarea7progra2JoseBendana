package tarea.pkg7.nave.josebendaña;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JColorChooser;

public class Tarea7NaveJoseBendaña {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        boolean bandera = false;
        int opcion;
        Nave nave = new Nave();
        do{
            System.out.println("""
                               1- Crear nave
                               2- Modificar la cantidad de tripulantes
                               3- Modificar el color de la nave
                               4- Modificar el material de un propulsor
                               5- Salir
                               """);
            System.out.print("Ingrese la opcion a evaluar: ");
            opcion = menu.nextInt();
            switch(opcion){
                case 1:
                    nave  = crearnave();
                    bandera = true;
                    break;
                case 2:
                    if (bandera) {
                        System.out.println("La cantidad de tripulantes es: "+nave.getCabina().getTripulantes());
                        System.out.print("Ingrese la nueva cantidad (no mas de 4 ni menos de 0): ");
                        int nuevo = menu.nextInt();
                        nave.getCabina().setTripulantes(nuevo);
                        System.out.println("Se ha cambiado el numero de tripulantes perfectamente");
                    }else{
                        System.out.println("Aun no se ha creado ni una nave");
                    }
                    break;
                case 3:
                    if (bandera) {
                        nave.setColor(JColorChooser.showDialog(null, "Eliga el nuevo color", nave.getColor()));
                        System.out.println("Se ha pintado la nave perfectamente");
                    }else{
                        System.out.println("Aun no se ha creado ni una nave");
                    }
                    break;
                case 4:
                    Scanner orac = new Scanner(System.in);
                    int cual;
                    if (bandera) {
                        do{
                            for (Propulsor f : nave.getPropulsor()) {
                                System.out.println(nave.getPropulsor().indexOf(f)+"- "+f);
                            }
                            System.out.print("Ingrese un propulsor: ");
                            cual = menu.nextInt();
                        }while(cual>=nave.getPropulsor().size()||cual<0);
                        System.out.println("El material actual del propulsor es: "+nave.getPropulsor().get(cual).getMaterial());
                        System.out.print("Ingrese el nuevo material: ");
                        String mat = orac.nextLine();
                        nave.getPropulsor().get(cual).setMaterial(mat);
                        System.out.println("Se ha cambiado el material perfectamente");
                        
                    }else{
                        System.out.println("Aun no se ha creado ni una nave");
                    }
                    break;
                case 5:
                    System.out.println("Saliendooooooo..........");
                    break;
                default:
                    System.out.println("Se ha escogido una opcion no valida");
                    break;
            }
        }while(opcion!=5);
        System.out.println("Se ha salido perfectamente");
    }
    
    public static Nave crearnave(){
        Scanner enteros = new Scanner(System.in);
        Scanner orac = new Scanner(System.in);
        Scanner doble  = new Scanner(System.in);
        Nave nave = new Nave();
        System.out.print("Ingrese el numero de serie de la nave: ");
        int serie = enteros.nextInt();
        nave.setSerie(serie);
        System.out.print("Ingrese el nombre de la nave: ");
        String name = orac.nextLine();
        nave.setNombre(name);
        Cabina cabina = new Cabina();
        System.out.print("Ingrese el peso de la cabina: ");
        double pesocabina = doble.nextDouble();
        cabina.setPeso(pesocabina);
        System.out.print("Ingrese el numero de tripulantes en la cabina (Maximo 4): ");
        int tripulantes = enteros.nextInt();
        cabina.setTripulantes(tripulantes);
        nave.setCabina(cabina);
        int resp;
        boolean salir;
        ArrayList<Ala> alas = new ArrayList();
        do{
            System.out.println("""
                               1- Anadir un Ala
                               2- Salir""");
            System.out.print("Ingrese una opcion: ");
            resp = enteros.nextInt();
            switch(resp){
                case 1:
                    
                    System.out.println("(En caso de que el peso del ala y el armamento es mayor de 200 se le pediran de nuevo los pesajes al final)");
                    System.out.println();
                    Ala ala = new Ala();
                    System.out.print("Ingrese el peso del ala en Lbs: ");
                    double pesoala = doble.nextDouble();
                    ala.setPeso(pesoala, 0);
                    System.out.print("Ingrese la longitud del ala: ");
                    double longi = doble.nextDouble();
                    ala.setLongitud(longi);
                    
                    Armamento armamento = new Armamento();
                    System.out.print("Ingrese el nombre del armamento: ");
                    String nombrearmamento = orac.nextLine();
                    armamento.setNombre(nombrearmamento);
                    System.out.print("Ingrese el peso del armamento: ");
                    double pesoarm = doble.nextDouble();
                    armamento.setPeso(pesoarm);
                    System.out.print("Ingrese el poder del armamento [1-10]: ");
                    int poder = enteros.nextInt();
                    armamento.setPoder(poder);
                    ala.setArmamento(armamento);
                    ala.setPeso(pesoala, pesoarm);
                    alas.add(ala);
                    boolean termino;
                    termino = nave.setAla(alas);
                    if(termino){
                        salir=true;  
                    }else{
                        salir=false;
                        System.out.println("Ya no se pueden anadir mas alas");
                    }
                    break;
                case 2:
                    if(nave.getAla().isEmpty()){
                        System.out.println("Debe haber al menos un ala para crear la nave");
                        salir=true;
                    }else{
                        System.out.println("Saliendo...");
                        salir=false;
                    }
                    break;
                default:
                    System.out.println("Opcion no valida, ingrese de nuevo");
                    salir = true;
                    break;
            }
        }while(salir);
        
        int resp2;
        boolean salir2;
        ArrayList<Propulsor> propulsores = new ArrayList();
        do{
            System.out.println("""
                               1- Anadir Propulsor
                               2- Salir""");
            System.out.print("Ingrese que quiere hacer: ");
            resp2 = enteros.nextInt();
            switch(resp2){
                case 1:
                    Propulsor propulsor = new Propulsor();
                    System.out.print("Ingrese el peso del propulsor: ");
                    double pesopro = doble.nextDouble();
                    propulsor.setPeso(pesopro);
                    System.out.print("Ingrese el material de que esta hecho el propulsor: ");
                    String material = orac.nextLine();
                    propulsor.setMaterial(material);
                    System.out.println("Ingrese la velocidad del propulsor que aporta a la aeronave: ");
                    double velocidad = doble.nextDouble();
                    propulsor.setVelocidad(velocidad);
                    propulsores.add(propulsor);
                    boolean termino2;
                    termino2 = nave.setPropulsor(propulsores);
                    if (termino2) {
                        salir2 = true;
                    }else{
                        salir2 = false;
                        System.out.println("Ya no se pueden anadir mas propulsores");
                    }
                    break;
                case 2:
                    if (nave.getPropulsor().isEmpty()) {
                        System.out.println("Debe haber almenos 1 propulsor para crear la nave");
                        salir2 = true;
                    }else{
                        System.out.println("Saliendo...");
                        salir2=false;
                    }
                    break;
                default:
                    System.out.println("Opcion no valida, ingrese de nuevo");
                    salir2 = true;
                    break;
            }
        }while(salir2);
        
        System.out.print("Ingrese el numero de la nave: ");
        int numeronave = enteros.nextInt();
        nave.setNumero(numeronave);
        nave.setColor(JColorChooser.showDialog(null, "Eliga el color de la nave", Color.WHITE));
        System.out.print("Ingrese el dia en numero de creacion de la nave: ");
        int dia = enteros.nextInt();
        System.out.print("Ingrese el mes en numero de creacion de la nave: ");
        int mes = enteros.nextInt();
        System.out.print("Ingrese el anio de creacion de la nave: ");
        int year = enteros.nextInt();
        Date fecha = new Date(year, mes, dia);
        nave.setFecha(fecha);
        System.out.println("Se ha creado la nave perfectamente");
        System.out.println("Aqui veras como ha quedado");
        System.out.println(nave);
        System.out.println("El indice de destruccion es: "+nave.Choque());
        return nave;
    }
}
