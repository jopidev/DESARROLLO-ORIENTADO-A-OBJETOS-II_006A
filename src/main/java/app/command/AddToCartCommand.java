package app.command;

import app.model.Pedido;
import app.model.Component;

public class AddToCartCommand implements Command {
    private final Pedido pedido;
    private final Component item;

    public AddToCartCommand(Pedido pedido, Component item) {
        this.pedido = pedido;
        this.item = item;
    }

    public void ejecutar() {
        pedido.agregar(item);
    }
}
