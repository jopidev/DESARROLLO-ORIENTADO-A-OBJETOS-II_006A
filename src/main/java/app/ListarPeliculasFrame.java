package app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class ListarPeliculasFrame extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private JComboBox<String> cboGenero;
    private JSpinner spAnioIni;
    private JSpinner spAnioFin;
    private JButton btnBuscar;
    private JButton btnTodas;
    private JButton btnLimpiar;

    public ListarPeliculasFrame() {
        setTitle("Listado y Búsqueda de Películas");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel filtros = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cboGenero = new JComboBox<>();
        spAnioIni = new JSpinner(new SpinnerNumberModel(1990, 1900, 2100, 1));
        spAnioFin = new JSpinner(new SpinnerNumberModel(2025, 1900, 2100, 1));
        btnBuscar = new JButton("Buscar");
        btnTodas = new JButton("Mostrar todas");
        btnLimpiar = new JButton("Limpiar");

        filtros.add(new JLabel("Género:"));
        filtros.add(cboGenero);
        filtros.add(new JLabel("Año desde:"));
        filtros.add(spAnioIni);
        filtros.add(new JLabel("hasta:"));
        filtros.add(spAnioFin);
        filtros.add(btnBuscar);
        filtros.add(btnTodas);
        filtros.add(btnLimpiar);

        String[] cols = {"ID","Título","Director","Año","Duración","Género"};
        modelo = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        setLayout(new BorderLayout());
        add(filtros, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        cargarGeneros();
        cargarTodas();

        btnBuscar.addActionListener(e -> buscar());
        btnTodas.addActionListener(e -> cargarTodas());
        btnLimpiar.addActionListener(e -> limpiar());
    }

    private void cargarGeneros() {
        cboGenero.removeAllItems();
        cboGenero.addItem("Todos");
        String sql = "SELECT DISTINCT genero FROM Cartelera ORDER BY genero";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) cboGenero.addItem(rs.getString(1));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error cargando géneros: " + ex.getMessage());
        }
    }

    private void cargarTodas() {
        modelo.setRowCount(0);
        String sql = "SELECT id,titulo,director,anio,duracion,genero FROM Cartelera ORDER BY id";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Vector<Object> v = new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getString("titulo"));
                v.add(rs.getString("director"));
                v.add(rs.getInt("anio"));
                v.add(rs.getInt("duracion"));
                v.add(rs.getString("genero"));
                modelo.addRow(v);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error cargando datos: " + ex.getMessage());
        }
    }

    private void buscar() {
        modelo.setRowCount(0);
        String base = "SELECT id,titulo,director,anio,duracion,genero FROM Cartelera WHERE 1=1";
        StringBuilder sb = new StringBuilder(base);
        boolean filtraGenero = cboGenero.getSelectedItem() != null && !"Todos".equals(cboGenero.getSelectedItem().toString());
        boolean filtraAnio = true;
        int ini = (Integer) spAnioIni.getValue();
        int fin = (Integer) spAnioFin.getValue();
        if (ini > fin) {
            JOptionPane.showMessageDialog(this, "Rango de años inválido");
            return;
        }
        if (filtraGenero) sb.append(" AND genero = ?");
        if (filtraAnio) sb.append(" AND anio BETWEEN ? AND ?");
        sb.append(" ORDER BY id");
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sb.toString())) {
            int idx = 1;
            if (filtraGenero) {
                ps.setString(idx++, cboGenero.getSelectedItem().toString());
            }
            if (filtraAnio) {
                ps.setInt(idx++, ini);
                ps.setInt(idx, fin);
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Vector<Object> v = new Vector<>();
                    v.add(rs.getInt("id"));
                    v.add(rs.getString("titulo"));
                    v.add(rs.getString("director"));
                    v.add(rs.getInt("anio"));
                    v.add(rs.getInt("duracion"));
                    v.add(rs.getString("genero"));
                    modelo.addRow(v);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en búsqueda: " + ex.getMessage());
        }
    }

    private void limpiar() {
        cboGenero.setSelectedIndex(0);
        spAnioIni.setValue(1990);
        spAnioFin.setValue(2025);
        cargarTodas();
    }
}
