package app.controller;

import app.model.Pedido;
import app.view.CarritoView;

public class CarritoController {
    private final Pedido pedido;
    private final CarritoView view;

    public CarritoController(Pedido pedido, CarritoView view) {
        this.pedido = pedido;
        this.view = view;
    }

    public void mostrar() {
        view.mostrar(pedido);
    }
}
