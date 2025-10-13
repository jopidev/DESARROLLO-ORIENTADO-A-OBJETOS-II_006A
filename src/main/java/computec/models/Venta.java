package computec.models;

import java.time.LocalDateTime;

public class Venta {
    private int id;
    private String rutCliente;
    private int idEquipo;
    private LocalDateTime fechaHora;
    private double total;

    public Venta(int id, String rutCliente, int idEquipo, LocalDateTime fechaHora, double total) {
        this.id = id;
        this.rutCliente = rutCliente;
        this.idEquipo = idEquipo;
        this.fechaHora = fechaHora;
        this.total = total;
    }

    public Venta() {}

    public int getId() { return id; }
    public String getRutCliente() { return rutCliente; }
    public int getIdEquipo() { return idEquipo; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public double getTotal() { return total; }

    public void setId(int id) { this.id = id; }
    public void setRutCliente(String rutCliente) { this.rutCliente = rutCliente; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public void setTotal(double total) { this.total = total; }
}
