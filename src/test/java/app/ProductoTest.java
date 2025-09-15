package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {
    @Test
    void creaYActualiza() {
        Producto p = new Producto("A1","Mouse","optico",9990,10);
        assertEquals("A1", p.getCodigo());
        assertEquals("Mouse", p.getNombre());
        assertEquals(9990.00, p.getPrecio());
        assertEquals(10, p.getCantidad());
        p.actualizarPrecio(10990.5);
        assertEquals(10990.5, p.getPrecio());
        p.setCantidad(5);
        assertEquals(5, p.getCantidad());
    }

    @Test
    void validaEntradas() {
        assertThrows(IllegalArgumentException.class, () -> new Producto("", "x", "", 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "", "", 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "x", "", -1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Producto("A", "x", "", 1, -1));
    }

    @Test
    void noPermitePrecioNegativo() {
        Producto p = new Producto("X","Y","",1000,1);
        assertThrows(IllegalArgumentException.class, () -> p.actualizarPrecio(-5));
    }
}

