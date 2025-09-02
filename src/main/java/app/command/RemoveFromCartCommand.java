package app.command;

import app.model.Pedido;

public class RemoveFromCartCommand implements Command {
    private final Pedido pedido;
    private final String nombre;

    public RemoveFromCartCommand(Pedido pedido, String nombre) {
        this.pedido = pedido;
        this.nombre = nombre;
    }

    public void ejecutar() {
        pedido.quitar(nombre);
    }
}
