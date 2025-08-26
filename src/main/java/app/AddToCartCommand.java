package app;

public class AddToCartCommand implements Command {
    private final Cart cart;
    private final Component item;

    public AddToCartCommand(Cart cart, Component item) {
        this.cart = cart;
        this.item = item;
    }

    public void ejecutar() {
        cart.add(item);
    }
}
