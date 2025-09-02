package app.model;

public class PercentageDiscount extends Decorator {
    private final double fraction;

    public PercentageDiscount(Component c, double fraction) {
        super(c);
        this.fraction = fraction;
    }

    public double getPrecioFinal() {
        double p = component.getPrecioFinal();
        return Math.round((p - p * fraction) * 100.0) / 100.0;
    }
}
