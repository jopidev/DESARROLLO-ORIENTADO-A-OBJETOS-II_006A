package app;

import app.model.*;
import app.view.*;
import app.controller.*;
import app.command.*;

public class Main {
    public static void main(String[] args) {
        Producto camisa = new Producto("Camisa Oxford", "ropa", 29990);
        Producto jeans = new Producto("Jeans Slim", "ropa", 39990);
        Producto cinturon = new Producto("Cinturón Cuero", "accesorio", 14990);

        Component camisaPromo = new CategoryDiscount(camisa, "ropa", 0.10);
        Component jeansPromo = new PercentageDiscount(jeans, 0.20);

        Pedido pedido = new Pedido();

        Command add1 = new AddToCartCommand(pedido, camisaPromo);
        Command add2 = new AddToCartCommand(pedido, jeansPromo);
        Command add3 = new AddToCartCommand(pedido, cinturon);

        add1.ejecutar();
        add2.ejecutar();
        add3.ejecutar();

        CarritoView carritoView = new CarritoView();
        CarritoController carritoController = new CarritoController(pedido, carritoView);
        carritoController.mostrar();

        DiscountManager manager = DiscountManager.getInstance();
        DescuentoView descuentoView = new DescuentoView();
        DescuentoController descuentoController = new DescuentoController(manager, descuentoView);

        double totalConCodigo = 0;
        for (Component c : pedido.getItems()) {
            totalConCodigo += descuentoController.aplicar("SALE10", c.getPrecioFinal());
        }
        System.out.println("Total con código: $" + totalConCodigo);

        Command remove = new RemoveFromCartCommand(pedido, "Cinturón Cuero");
        remove.ejecutar();
        carritoController.mostrar();
    }
}
