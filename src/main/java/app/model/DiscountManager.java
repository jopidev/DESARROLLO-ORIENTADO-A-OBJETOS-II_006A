package app.model;

import java.util.HashMap;
import java.util.Map;

public final class DiscountManager {
    private static final DiscountManager INSTANCE = new DiscountManager();
    private final Map<String, Double> percentagePromos = new HashMap<>();

    private DiscountManager() {
        percentagePromos.put("SALE10", 0.10);
        percentagePromos.put("VIP20", 0.20);
    }

    public static DiscountManager getInstance() {
        return INSTANCE;
    }

    public double aplicar(String code, double precio) {
        if (code == null || code.isEmpty()) return precio;
        String k = code.toUpperCase();
        if (percentagePromos.containsKey(k)) {
            double pct = percentagePromos.get(k);
            return Math.round((precio - precio * pct) * 100.0) / 100.0;
        }
        return precio;
    }
}
