package app.view;

import app.model.Pedido;

public class CarritoView {
    public void mostrar(Pedido pedido) {
        System.out.println("Carrito:");
        pedido.getItems().forEach(p -> System.out.println("- " + p.getNombre() + " $" + p.getPrecioFinal()));
        System.out.println("Total: $" + pedido.total());
    }
}

