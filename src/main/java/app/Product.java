package app;

public class Product implements Component {
    private final String name;
    private final String category;
    private final double basePrice;

    public Product(String name, String category, double basePrice) {
        if (basePrice < 0) throw new IllegalArgumentException("precio inválido");
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getFinalPrice() {
        return basePrice;
    }
}
