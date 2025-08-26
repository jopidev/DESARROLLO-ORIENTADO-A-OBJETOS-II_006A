package app;

public class PercentageDiscount extends Decorator {
    private final double fraction;

    public PercentageDiscount(Component component, double fraction) {
        super(component);
        if (fraction < 0 || fraction > 1) throw new IllegalArgumentException("fracción inválida");
        this.fraction = fraction;
    }

    public double getFinalPrice() {
        double p = component.getFinalPrice();
        return Math.round((p - p * fraction) * 100.0) / 100.0;
    }
}
