package app;

public class RemoveFromCartCommand implements Command {
    private final Cart cart;
    private final String itemName;

    public RemoveFromCartCommand(Cart cart, String itemName) {
        this.cart = cart;
        this.itemName = itemName;
    }

    public void ejecutar() {
        cart.removeByName(itemName);
    }
}
