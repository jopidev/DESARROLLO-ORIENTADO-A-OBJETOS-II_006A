package app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DiscountManagerTest {
    @Test
    void aplicaPorcentaje() {
        DiscountManager dm = DiscountManager.getInstance();
        assertEquals(90.0, dm.apply("SALE10", 100.0));
    }

    @Test
    void aplicaFijo() {
        DiscountManager dm = DiscountManager.getInstance();
        assertEquals(95.0, dm.apply("OFF5", 100.0));
    }

    @Test
    void codigoDesconocido() {
        DiscountManager dm = DiscountManager.getInstance();
        assertEquals(100.0, dm.apply("XYZ", 100.0));
    }

    @Test
    void sinCodigo() {
        DiscountManager dm = DiscountManager.getInstance();
        assertEquals(100.0, dm.apply("", 100.0));
    }
}

