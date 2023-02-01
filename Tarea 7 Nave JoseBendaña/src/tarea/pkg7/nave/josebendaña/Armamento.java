package tarea.pkg7.nave.josebendaña;

import java.util.Scanner;

public class Armamento {
    private String nombre;
    private double peso;
    private int poder;

    public Armamento() {
    }

    public Armamento(String nombre, double peso, int poder) {
        this.nombre = nombre;
        this.peso = peso;
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        Scanner sc= new Scanner(System.in);
        if(poder>=1&&poder<=10){
            this.poder = poder;
        }else{
            System.out.println("Lo siento el poder no puede ser menor que 1 ni mayor que 10");
            System.out.print("Ingrese un poder nuevo: ");
            int pod = sc.nextInt();
            setPoder(pod);
        }
    }

    @Override
    public String toString() {
        return "Armamento{" + "nombre=" + nombre + ", peso=" + peso + ", poder=" + poder + '}';
    }
    
    
}
