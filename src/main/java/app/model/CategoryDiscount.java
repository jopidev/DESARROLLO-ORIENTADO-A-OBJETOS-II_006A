package app.model;

public class CategoryDiscount extends Decorator {
    private final String categoria;
    private final double fraction;

    public CategoryDiscount(Component c, String categoria, double fraction) {
        super(c);
        this.categoria = categoria;
        this.fraction = fraction;
    }

    public double getPrecioFinal() {
        double p = component.getPrecioFinal();
        if (component.getCategoria().equalsIgnoreCase(categoria)) {
            return Math.round((p - p * fraction) * 100.0) / 100.0;
        }
        return p;
    }
}
