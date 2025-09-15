package app;

import java.util.*;
import java.util.stream.Collectors;

public class Inventario {
    private final Map<String, Producto> productos = new HashMap<>();

    public void agregarProducto(Producto producto) {
        if (producto == null) throw new IllegalArgumentException("producto");
        if (productos.containsKey(producto.getCodigo())) throw new IllegalStateException("duplicado");
        productos.put(producto.getCodigo(), producto);
    }

    public boolean actualizarProducto(String codigo, String nombre, String descripcion, Double precio, Integer cantidad) {
        Producto p = productos.get(codigo);
        if (p == null) return false;
        if (nombre != null && !nombre.isBlank()) p.setNombre(nombre);
        if (descripcion != null) p.setDescripcion(descripcion);
        if (precio != null) p.actualizarPrecio(precio);
        if (cantidad != null) p.setCantidad(cantidad);
        return true;
    }

    public boolean eliminarPorCodigo(String codigo) {
        return productos.remove(codigo) != null;
    }

    public Producto buscarPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        if (nombre == null) nombre = "";
        String q = nombre.trim().toLowerCase();
        return productos.values().stream()
                .filter(p -> p.getNombre().toLowerCase().contains(q))
                .sorted(Comparator.comparing(Producto::getCodigo))
                .collect(Collectors.toList());
    }

    public List<Producto> listar() {
        return productos.values().stream()
                .sorted(Comparator.comparing(Producto::getCodigo))
                .collect(Collectors.toList());
    }

    public String generarInforme() {
        int totalItems = productos.values().stream().mapToInt(Producto::getCantidad).sum();
        double valorInventario = productos.values().stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
        valorInventario = Math.round(valorInventario * 100.0) / 100.0;
        return "Productos: " + productos.size() + ", Items: " + totalItems + ", Valor: " + valorInventario;
    }

    public int totalItems() {
        return productos.values().stream().mapToInt(Producto::getCantidad).sum();
    }

    public double valorInventario() {
        double v = productos.values().stream().mapToDouble(p -> p.getPrecio() * p.getCantidad()).sum();
        return Math.round(v * 100.0) / 100.0;
    }
}
