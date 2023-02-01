package tarea.pkg7.nave.josebendaña;

import java.util.Scanner;

public class Cabina {
    private double peso;
    private int tripulantes;

    public Cabina() {
    }

    public Cabina(double peso, int tripulantes) {
        this.peso = peso;
        this.tripulantes = tripulantes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(int tripulantes) {
        Scanner sc = new Scanner(System.in);
        if(tripulantes<=4 && tripulantes>=0){
            this.tripulantes = tripulantes;
        }else{
            System.out.println("No se puede mas de 4 ni menos de 0");
            System.out.print("Ingrese un numero de tripulantes correcto: ");
            int tripu = sc.nextInt();
            setTripulantes(tripu);
        }
    }

    @Override
    public String toString() {
        return "Cabina{" + "peso=" + peso + ", tripulantes=" + tripulantes + '}';
    }
    
    
}
