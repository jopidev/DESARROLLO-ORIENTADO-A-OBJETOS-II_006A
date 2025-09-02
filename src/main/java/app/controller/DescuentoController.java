package app.controller;

import app.model.DiscountManager;
import app.view.DescuentoView;

public class DescuentoController {
    private final DiscountManager manager;
    private final DescuentoView view;

    public DescuentoController(DiscountManager manager, DescuentoView view) {
        this.manager = manager;
        this.view = view;
    }

    public double aplicar(String code, double precio) {
        double nuevo = manager.aplicar(code, precio);
        view.mostrar(code);
        return nuevo;
    }
}
