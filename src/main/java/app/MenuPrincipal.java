package app;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private final Inventario inventario = new Inventario();
    private final CsvAdapter csv = new CsvAdapter();
    private final Ui ui = new Ui();

    public static void main(String[] args) {
        new MenuPrincipal().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            ui.header("Menú Principal");
            System.out.println("1) Agregar producto");
            System.out.println("2) Actualizar producto");
            System.out.println("3) Eliminar producto");
            System.out.println("4) Buscar por código");
            System.out.println("5) Buscar por nombre");
            System.out.println("6) Listar productos");
            System.out.println("7) Informe de inventario");
            System.out.println("8) Importar CSV");
            System.out.println("9) Exportar CSV");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();
            try {
                switch (op) {
                    case "1": agregar(sc); break;
                    case "2": actualizar(sc); break;
                    case "3": eliminar(sc); break;
                    case "4": buscarCodigo(sc); break;
                    case "5": buscarNombre(sc); break;
                    case "6": listar(sc); break;
                    case "7": informe(sc); break;
                    case "8": importar(sc); break;
                    case "9": exportar(sc); break;
                    case "0": loop = false; break;
                    default: ui.warn("Opción inválida"); ui.pause(sc);
                }
            } catch (Exception e) {
                ui.error(e.getMessage()); ui.pause(sc);
            }
        }
        sc.close();
    }

    private void agregar(Scanner sc) {
        ui.header("Agregar producto");
        String codigo = ui.readNonEmpty(sc, "Código");
        String nombre = ui.readNonEmpty(sc, "Nombre");
        String desc = ui.readOptional(sc, "Descripción");
        double precio = ui.readDouble(sc, "Precio");
        Integer cantidad = ui.readIntOptional(sc, "Cantidad");
        if (cantidad == null) cantidad = 0;
        inventario.agregarProducto(new Producto(codigo, nombre, desc, precio, cantidad));
        ui.success("Producto agregado");
        ui.pause(sc);
    }

    private void actualizar(Scanner sc) {
        ui.header("Actualizar producto");
        String codigo = ui.readNonEmpty(sc, "Código a actualizar");
        String nombre = ui.readOptional(sc, "Nuevo nombre");
        String desc = ui.readOptional(sc, "Nueva descripción");
        System.out.print("Nuevo precio (Enter para omitir): ");
        String sp = sc.nextLine().trim();
        Double precio = sp.isBlank() ? null : Double.parseDouble(sp.replace(",", "."));
        Integer cantidad = ui.readIntOptional(sc, "Nueva cantidad");
        boolean ok = inventario.actualizarProducto(codigo, nombre.isBlank()?null:nombre, desc.isBlank()?null:desc, precio, cantidad);
        if (ok) ui.success("Actualizado"); else ui.warn("No existe");
        ui.pause(sc);
    }

    private void eliminar(Scanner sc) {
        ui.header("Eliminar producto");
        String codigo = ui.readNonEmpty(sc, "Código a eliminar");
        if (!inventario.eliminarPorCodigo(codigo)) { ui.warn("No existe"); ui.pause(sc); return; }
        ui.success("Eliminado");
        ui.pause(sc);
    }

    private void buscarCodigo(Scanner sc) {
        ui.header("Buscar por código");
        String codigo = ui.readNonEmpty(sc, "Código");
        Producto p = inventario.buscarPorCodigo(codigo);
        if (p == null) ui.warn("No existe");
        else {
            System.out.println();
            System.out.println(p.toStringDetallado());
        }
        ui.pause(sc);
    }

    private void buscarNombre(Scanner sc) {
        ui.header("Buscar por nombre");
        String q = ui.readNonEmpty(sc, "Nombre contiene");
        List<Producto> r = inventario.buscarPorNombre(q);
        if (r.isEmpty()) ui.warn("Sin resultados");
        else ui.table(r);
        ui.pause(sc);
    }

    private void listar(Scanner sc) {
        ui.header("Listado de productos");
        List<Producto> r = inventario.listar();
        if (r.isEmpty()) ui.warn("Inventario vacío");
        else ui.table(r);
        ui.pause(sc);
    }

    private void informe(Scanner sc) {
        ui.header("Informe");
        String info = inventario.generarInforme();
        System.out.println();
        System.out.println(info);
        ui.pause(sc);
    }

    private void importar(Scanner sc) {
        ui.header("Importar CSV");
        String path = ui.readNonEmpty(sc, "Ruta CSV");
        int n = csv.importar(path, inventario);
        ui.success("Importados: " + n);
        ui.pause(sc);
    }

    private void exportar(Scanner sc) {
        ui.header("Exportar CSV");
        String path = ui.readNonEmpty(sc, "Ruta destino CSV");
        int n = csv.exportar(path, inventario.listar());
        ui.success("Exportados: " + n);
        ui.pause(sc);
    }
}

