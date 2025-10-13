package computec.models;

public abstract class Equipo {
    protected int id;
    protected String descripcion;
    protected String cpu;
    protected int disco;
    protected int ram;
    protected double precio;
    protected String tipo;

    public Equipo(int id, String descripcion, String cpu, int disco, int ram, double precio, String tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.cpu = cpu;
        this.disco = disco;
        this.ram = ram;
        this.precio = precio;
        this.tipo = tipo;
    }

    public Equipo() {}

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getCpu() { return cpu; }
    public int getDisco() { return disco; }
    public int getRam() { return ram; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }

    public void setId(int id) { this.id = id; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setDisco(int disco) { this.disco = disco; }
    public void setRam(int ram) { this.ram = ram; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
