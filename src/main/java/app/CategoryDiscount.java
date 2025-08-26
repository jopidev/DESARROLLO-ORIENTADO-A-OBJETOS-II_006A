package app;

public class CategoryDiscount extends Decorator {
    private final String category;
    private final double fraction;

    public CategoryDiscount(Component component, String category, double fraction) {
        super(component);
        if (fraction < 0 || fraction > 1) throw new IllegalArgumentException("fracción inválida");
        this.category = category;
        this.fraction = fraction;
    }

    public double getFinalPrice() {
        double p = component.getFinalPrice();
        if (component.getCategory().equalsIgnoreCase(category)) {
            return Math.round((p - p * fraction) * 100.0) / 100.0;
        }
        return p;
    }
}
