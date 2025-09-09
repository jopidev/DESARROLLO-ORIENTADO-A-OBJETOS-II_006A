package app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InventarioTest {
    @Test
    void agregarYListar() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto("P1","Teclado","mecanico",19990,3));
        inv.agregarProducto(new Producto("P2","Mouse","optico",9990,5));
        List<Producto> all = inv.listar();
        assertEquals(2, all.size());
    }

    @Test
    void buscarYEliminar() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto("P1","Teclado","mecanico",19990,3));
        inv.agregarProducto(new Producto("P2","Mouse","optico",9990,5));
        assertNotNull(inv.buscarPorCodigo("P2"));
        assertTrue(inv.eliminarPorCodigo("P2"));
        assertNull(inv.buscarPorCodigo("P2"));
        assertFalse(inv.eliminarPorCodigo("Z"));
    }

    @Test
    void actualizarYBuscarPorNombre() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto("P1","Teclado","mecanico",19990,3));
        assertTrue(inv.actualizarProducto("P1","Teclado Gamer",null,24990.0,4));
        List<Producto> r = inv.buscarPorNombre("gamer");
        assertEquals(1, r.size());
        assertEquals("P1", r.get(0).getCodigo());
    }

    @Test
    void informe() {
        Inventario inv = new Inventario();
        inv.agregarProducto(new Producto("P1","A","",1000,2));
        inv.agregarProducto(new Producto("P2","B","",500,1));
        String info = inv.generarInforme();
        assertTrue(info.contains("Productos: 2"));
    }
}
