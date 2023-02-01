package tarea.pkg7.nave.josebendaña;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

public class Nave {

    private int serie;
    private String nombre;
    private Cabina cabina;
    private ArrayList<Ala> ala = new ArrayList();
    private ArrayList<Propulsor> propulsor = new ArrayList();
    private int numero;
    private Color color;
    private Date fecha;

    public Nave() {
    }

    public Nave(int serie, String nombre, Cabina cabina, ArrayList<Ala> ala, ArrayList<Propulsor> propulsor, int numero, Color color, Date fecha) {
        this.serie = serie;
        this.nombre = nombre;
        this.cabina = cabina;
        this.ala = ala;
        this.cabina = cabina;
        this.numero = numero;
        this.color = color;
        this.fecha = fecha;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public void setCabina(Cabina cabina) {
        this.cabina = cabina;
    }

    public ArrayList<Ala> getAla() {
        return ala;
    }

    public boolean setAla(ArrayList<Ala> ala) {
        if (ala.size() < 4) {
            this.ala = ala;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Propulsor> getPropulsor() {
        return propulsor;
    }

    public boolean setPropulsor(ArrayList<Propulsor> propulsor) {
        if (propulsor.size() < 4) {
            this.propulsor = propulsor;
            return true;
        } else {
            return false;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double Choque() {
        double peso;
        double pesoalas = 0;
        double pesopropulsores = 0;
        double velo = 0;
        double arma = 0;

        for (Ala d : ala) {
            pesoalas += d.getPeso();
        }
        for (Propulsor f : propulsor) {
            pesopropulsores += f.getPeso();
        }

        for (Propulsor e : propulsor) {
            velo += e.getVelocidad();
        }
        for (Ala r : ala) {
            arma += r.getArmamento().getPeso();
        }
        peso = cabina.getPeso() + pesoalas + pesopropulsores + arma;
        return peso * velo;
    }

    @Override
    public String toString() {
        return "Nave "+ nombre + ": SERIE:" + serie +  ", CABINA:" + cabina + ", ALA:" + ala + ", PROPULSOR:" + propulsor + ", NUMERO:" + numero + ", COLOR:" + color + ", FECHA:" + fecha;
    }

}
