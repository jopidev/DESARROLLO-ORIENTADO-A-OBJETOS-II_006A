package app;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class CsvAdapter {
    public int importar(String path, Inventario inventario) {
        if (inventario == null) throw new IllegalArgumentException("inventario");
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path), StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] a = parse(line);
                if (a.length < 5) continue;
                String codigo = a[0];
                String nombre = a[1];
                String descripcion = a[2];
                double precio = Double.parseDouble(a[3]);
                int cantidad = Integer.parseInt(a[4]);
                inventario.agregarProducto(new Producto(codigo, nombre, descripcion, precio, cantidad));
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int exportar(String path, List<Producto> productos) {
        int count = 0;
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(path), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Producto p : productos) {
                String line = toCsv(p.getCodigo()) + "," + toCsv(p.getNombre()) + "," + toCsv(p.getDescripcion()) + "," + p.getPrecio() + "," + p.getCantidad();
                bw.write(line);
                bw.newLine();
                count++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    private String[] parse(String line) {
        List<String> out = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQ = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                if (inQ && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    cur.append('"');
                    i++;
                } else {
                    inQ = !inQ;
                }
            } else if (c == ',' && !inQ) {
                out.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(c);
            }
        }
        out.add(cur.toString());
        return out.toArray(new String[0]);
    }

    private String toCsv(String s) {
        if (s == null) s = "";
        boolean needQ = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
        String v = s.replace("\"", "\"\"");
        return needQ ? "\"" + v + "\"" : v;
    }
}
