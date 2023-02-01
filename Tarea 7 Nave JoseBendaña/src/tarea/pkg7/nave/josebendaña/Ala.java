package tarea.pkg7.nave.josebendaña;

import java.util.Scanner;

public class Ala {
    private double peso;
    private double longitud;
    private Armamento armamento;

    public Ala() {
    }

    public Ala(double peso, double longitud, Armamento armamento) {
        this.peso = peso;
        this.longitud = longitud;
        this.armamento = armamento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso, double armamento) {
        Scanner sc = new Scanner(System.in);
        if(peso + armamento<=200){
            this.peso = peso;
        }else{
            System.out.println("El ala no tiene tanto aguante para sostener "+(peso + armamento)+"Lbs");
            System.out.println("Ingrese nuevamente los pesos");
            System.out.print("Ingrese el peso de la ala: ");
            peso = sc.nextInt();
            this.peso=peso;
            System.out.print("Ingrese el peso del armamento: ");
            armamento = sc.nextInt();
            this.armamento.setPeso(peso);
            setPeso(peso, armamento);
        }
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Armamento getArmamento() {
        return armamento;
    }

    public void setArmamento(Armamento armamento) {
        this.armamento = armamento;
    }

    @Override
    public String toString() {
        return "Ala{" + "peso=" + peso + ", longitud=" + longitud + ", armamento=" + armamento + '}';
    }
    
    
}
