package app.model;

public abstract class Decorator implements Component {
    protected final Component component;

    protected Decorator(Component component) {
        this.component = component;
    }

    public String getNombre() {
        return component.getNombre();
    }

    public String getCategoria() {
        return component.getCategoria();
    }

    public double getPrecioBase() {
        return component.getPrecioBase();
    }
}
