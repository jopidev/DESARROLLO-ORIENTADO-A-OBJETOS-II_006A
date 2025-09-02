package app.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<Component> items = new ArrayList<>();

    public void agregar(Component c) {
        items.add(c);
    }

    public void quitar(String nombre) {
        items.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Component> getItems() {
        return new ArrayList<>(items);
    }

    public double total() {
        double suma = 0;
        for (Component c : items) suma += c.getPrecioFinal();
        return Math.round(suma * 100.0) / 100.0;
    }
}
