package app;

import java.util.HashMap;
import java.util.Map;

public final class DiscountManager {
    private static final DiscountManager INSTANCE = new DiscountManager();
    private final Map<String, Double> percentagePromos = new HashMap<>();
    private final Map<String, Double> fixedPromos = new HashMap<>();

    private DiscountManager() {
        percentagePromos.put("SALE10", 0.10);
        percentagePromos.put("VIP20", 0.20);
        fixedPromos.put("OFF5", 5.0);
    }

    public static DiscountManager getInstance() {
        return INSTANCE;
    }

    public double apply(String code, double price) {
        if (price < 0) throw new IllegalArgumentException("precio inválido");
        if (code == null || code.isEmpty()) return round(price);
        String key = code.toUpperCase();
        if (percentagePromos.containsKey(key)) {
            double pct = percentagePromos.get(key);
            return round(price - price * pct);
        }
        if (fixedPromos.containsKey(key)) {
            double amount = fixedPromos.get(key);
            return round(Math.max(0.0, price - amount));
        }
        return round(price);
    }

    public void addPercentagePromo(String code, double fraction) {
        if (fraction < 0 || fraction > 1) throw new IllegalArgumentException("fracción inválida");
        if (code == null || code.isBlank()) throw new IllegalArgumentException("código inválido");
        percentagePromos.put(code.toUpperCase(), fraction);
    }

    public void addFixedPromo(String code, double amount) {
        if (amount < 0) throw new IllegalArgumentException("monto inválido");
        if (code == null || code.isBlank()) throw new IllegalArgumentException("código inválido");
        fixedPromos.put(code.toUpperCase(), amount);
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
