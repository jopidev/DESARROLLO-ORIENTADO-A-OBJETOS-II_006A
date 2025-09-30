package app;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class EliminarPeliculaFrame extends JFrame {
    private JTextField txtId;
    private JButton btnEliminar, btnLimpiar;

    public EliminarPeliculaFrame() {
        setTitle("Eliminar Película");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");

        add(btnEliminar);
        add(btnLimpiar);

        btnEliminar.addActionListener(e -> eliminarPelicula());
        btnLimpiar.addActionListener(e -> txtId.setText(""));
    }

    private void eliminarPelicula() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta película?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Cartelera WHERE id=?")) {
            stmt.setInt(1, Integer.parseInt(txtId.getText()));
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Película eliminada");
            } else {
                JOptionPane.showMessageDialog(this, "No existe película con ese ID");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
