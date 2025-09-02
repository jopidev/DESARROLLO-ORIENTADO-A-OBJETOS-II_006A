package app.model;

public class Producto implements Component {
    private final String nombre;
    private final String categoria;
    private final double precio;

    public Producto(String nombre, String categoria, double precio) {
        if (precio < 0) throw new IllegalArgumentException("precio inválido");
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecioBase() {
        return precio;
    }

    public double getPrecioFinal() {
        return precio;
    }
}
