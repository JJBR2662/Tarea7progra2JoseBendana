package tarea.pkg7.nave.josebendaña;

public class Propulsor {
    private double peso;
    private String material;
    private double velocidad;

    public Propulsor() {
    }

    public Propulsor(double peso, String material, double velocidad) {
        this.peso = peso;
        this.material = material;
        this.velocidad = velocidad;
    }

    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Propulsor{" + "peso=" + peso + ", material=" + material + ", velocidad=" + velocidad + '}';
    }
    
    
}
