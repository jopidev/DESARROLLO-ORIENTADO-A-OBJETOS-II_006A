package app;

import java.util.ArrayList;
import java.util.List;

public class ApplyDiscountCommand implements Command {
    private final Cart cart;
    private final String code;

    public ApplyDiscountCommand(Cart cart, String code) {
        this.cart = cart;
        this.code = code;
    }

    public void ejecutar() {
        DiscountManager dm = DiscountManager.getInstance();
        List<Component> replaced = new ArrayList<>();
        for (Component c : cart.items()) {
            double price = c.getFinalPrice();
            double discounted = dm.apply(code, price);
            double fraction = price == 0 ? 0 : 1.0 - (discounted / price);
            Component decorated = new PercentageDiscount(c, Math.max(0, Math.min(1, fraction)));
            replaced.add(decorated);
        }
        cart.replaceAll(replaced);
    }
}
