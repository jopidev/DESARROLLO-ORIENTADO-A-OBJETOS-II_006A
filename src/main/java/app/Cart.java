package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private final List<Component> items = new ArrayList<>();

    public void add(Component c) {
        items.add(c);
    }

    public void removeByName(String name) {
        Iterator<Component> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(name)) {
                it.remove();
                break;
            }
        }
    }

    public double total() {
        double sum = 0.0;
        for (Component c : items) sum += c.getFinalPrice();
        return Math.round(sum * 100.0) / 100.0;
    }

    public List<Component> items() {
        return new ArrayList<>(items);
    }

    public void replaceAll(List<Component> newItems) {
        items.clear();
        items.addAll(newItems);
    }
}
