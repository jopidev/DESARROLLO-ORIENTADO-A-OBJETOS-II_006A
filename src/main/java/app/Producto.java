package app;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, String descripcion, double precio, int cantidad) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("codigo");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre");
        if (precio < 0) throw new IllegalArgumentException("precio");
        if (cantidad < 0) throw new IllegalArgumentException("cantidad");
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
        this.descripcion = descripcion == null ? "" : descripcion.trim();
        this.precio = Math.round(precio * 100.0) / 100.0;
        this.cantidad = cantidad;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("nombre");
        this.nombre = nombre.trim();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion == null ? "" : descripcion.trim();
    }

    public void actualizarPrecio(double nuevoPrecio) {
        if (nuevoPrecio < 0) throw new IllegalArgumentException("precio");
        this.precio = Math.round(nuevoPrecio * 100.0) / 100.0;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) throw new IllegalArgumentException("cantidad");
        this.cantidad = cantidad;
    }

    public String toStringDetallado() {
        return "Producto{codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + "}";
    }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + precio + " | " + cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return Objects.equals(codigo, p.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}

