package app.controller;

import app.model.Producto;
import app.view.ProductoView;

public class ProductoController {
    private final Producto producto;
    private final ProductoView view;

    public ProductoController(Producto producto, ProductoView view) {
        this.producto = producto;
        this.view = view;
    }

    public void mostrar() {
        view.mostrar(producto);
    }
}
