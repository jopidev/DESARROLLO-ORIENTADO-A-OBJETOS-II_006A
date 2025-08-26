package app;

public abstract class Decorator implements Component {
    protected final Component component;

    protected Decorator(Component component) {
        this.component = component;
    }

    public String getName() {
        return component.getName();
    }

    public String getCategory() {
        return component.getCategory();
    }

    public double getBasePrice() {
        return component.getBasePrice();
    }
}
