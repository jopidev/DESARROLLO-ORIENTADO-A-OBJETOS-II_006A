package app;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Component camisa = new Product("Camisa Oxford", "ropa", 29990.0);
        Component jeans = new Product("Jeans Slim", "ropa", 39990.0);
        Component cinturon = new Product("Cinturón Cuero", "accesorio", 14990.0);

        Component camisaPromo = new CategoryDiscount(camisa, "ropa", 0.10);
        Component jeansPromo = new PercentageDiscount(jeans, 0.20);

        Command add1 = new AddToCartCommand(cart, camisaPromo);
        Command add2 = new AddToCartCommand(cart, jeansPromo);
        Command add3 = new AddToCartCommand(cart, cinturon);

        add1.ejecutar();
        add2.ejecutar();
        add3.ejecutar();

        System.out.println("Total antes de código: " + cart.total());

        Command applyCode = new ApplyDiscountCommand(cart, "OFF5");
        applyCode.ejecutar();

        System.out.println("Total después de código: " + cart.total());

        Command remove = new RemoveFromCartCommand(cart, "Cinturón Cuero");
        remove.ejecutar();

        System.out.println("Total final: " + cart.total());
    }
}
