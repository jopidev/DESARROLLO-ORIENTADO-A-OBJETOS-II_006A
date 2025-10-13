package computec.models;

public class Laptop extends Equipo {
    private double pantalla;
    private boolean touch;
    private int puertosUsb;

    public Laptop(int id, String descripcion, String cpu, int disco, int ram, double precio,
                  double pantalla, boolean touch, int puertosUsb) {
        super(id, descripcion, cpu, disco, ram, precio, "Laptop");
        this.pantalla = pantalla;
        this.touch = touch;
        this.puertosUsb = puertosUsb;
    }

    public Laptop() {}

    public double getPantalla() { return pantalla; }
    public boolean isTouch() { return touch; }
    public int getPuertosUsb() { return puertosUsb; }

    public void setPantalla(double pantalla) { this.pantalla = pantalla; }
    public void setTouch(boolean touch) { this.touch = touch; }
    public void setPuertosUsb(int puertosUsb) { this.puertosUsb = puertosUsb; }
}
