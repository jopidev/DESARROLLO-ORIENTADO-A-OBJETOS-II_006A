package app;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Ui {
    private static final String SEP = "────────────────────────────────────────────────────────";
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final Locale CL = new Locale("es","CL");
    private static final NumberFormat CLP = NumberFormat.getCurrencyInstance(CL);
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public void header(String titulo) {
        System.out.print("\u001B[2J\u001B[H");
        System.out.println(BOLD + CYAN + "Inventario - " + titulo + RESET);
        System.out.println(SEP + "  " + LocalDateTime.now().format(TS));
    }

    public void success(String msg) { System.out.println(GREEN + "✔ " + msg + RESET); }
    public void warn(String msg) { System.out.println(YELLOW + "• " + msg + RESET); }
    public void error(String msg) { System.out.println(RED + "✖ " + msg + RESET); }

    public String money(double v) { return CLP.format(v); }

    public void pause(Scanner sc) {
        System.out.println();
        System.out.print("Presiona Enter para continuar...");
        sc.nextLine();
    }

    public String readNonEmpty(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String s = sc.nextLine();
            if (s != null && !s.isBlank()) return s.trim();
            warn("Entrada vacía");
        }
    }

    public String readOptional(Scanner sc, String label) {
        System.out.print(label + " (Enter para omitir): ");
        String s = sc.nextLine();
        return s == null ? "" : s.trim();
    }

    public double readDouble(Scanner sc, String label) {
        while (true) {
            System.out.print(label + ": ");
            String s = sc.nextLine();
            try {
                return Double.parseDouble(s.replace(",", "."));
            } catch (Exception e) {
                warn("Número inválido");
            }
        }
    }

    public Integer readIntOptional(Scanner sc, String label) {
        System.out.print(label + " (Enter para omitir): ");
        String s = sc.nextLine();
        if (s == null || s.isBlank()) return null;
        try { return Integer.parseInt(s); } catch (Exception e) { return null; }
    }

    public boolean confirm(Scanner sc, String pregunta) {
        System.out.print(pregunta + " (s/n): ");
        String s = sc.nextLine().trim().toLowerCase();
        return s.equals("s") || s.equals("si") || s.equals("sí");
    }

    public void table(List<Producto> items) {
        String h = String.format("%-10s %-22s %14s %10s", "Código", "Nombre", "Precio", "Cantidad");
        System.out.println(SEP);
        System.out.println(BOLD + h + RESET);
        System.out.println(SEP);
        for (Producto p : items) {
            String row = String.format("%-10s %-22s %14s %10d",
                    p.getCodigo(),
                    p.getNombre().length()>22? p.getNombre().substring(0,22) : p.getNombre(),
                    money(p.getPrecio()),
                    p.getCantidad());
            System.out.println(row);
        }
        System.out.println(SEP);
    }
}
