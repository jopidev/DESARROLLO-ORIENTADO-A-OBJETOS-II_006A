package app;

public class Main {
    public static void main(String[] args) {
        DiscountManager dm = DiscountManager.getInstance();
        double precio = 49990.0;
        System.out.println("Precio base: " + precio);
        System.out.println("SALE10: " + dm.apply("SALE10", precio));
        System.out.println("VIP20: " + dm.apply("VIP20", precio));
        System.out.println("OFF5: " + dm.apply("OFF5", precio));
        System.out.println("NADA: " + dm.apply("NADA", precio));
    }
}

