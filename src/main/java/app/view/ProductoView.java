package app.view;

import app.model.Producto;

public class ProductoView {
    public void mostrar(Producto p) {
        System.out.println("Producto: " + p.getNombre() + " | " + p.getCategoria() + " | $" + p.getPrecioFinal());
    }
}
