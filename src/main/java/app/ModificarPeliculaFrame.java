package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ModificarPeliculaFrame extends JFrame {
    private JTextField txtId, txtTitulo, txtDirector, txtAnio, txtDuracion, txtGenero;
    private JButton btnBuscar, btnActualizar, btnLimpiar;

    public ModificarPeliculaFrame() {
        setTitle("Modificar Película");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Director:"));
        txtDirector = new JTextField();
        add(txtDirector);

        add(new JLabel("Año:"));
        txtAnio = new JTextField();
        add(txtAnio);

        add(new JLabel("Duración (min):"));
        txtDuracion = new JTextField();
        add(txtDuracion);

        add(new JLabel("Género:"));
        txtGenero = new JTextField();
        add(txtGenero);

        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnLimpiar = new JButton("Limpiar");

        add(btnBuscar);
        add(btnActualizar);
        add(btnLimpiar);

        btnBuscar.addActionListener(e -> buscarPelicula());
        btnActualizar.addActionListener(e -> actualizarPelicula());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void buscarPelicula() {
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID");
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Cartelera WHERE id=?")) {
            stmt.setInt(1, Integer.parseInt(txtId.getText()));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                txtTitulo.setText(rs.getString("titulo"));
                txtDirector.setText(rs.getString("director"));
                txtAnio.setText(String.valueOf(rs.getInt("anio")));
                txtDuracion.setText(String.valueOf(rs.getInt("duracion")));
                txtGenero.setText(rs.getString("genero"));
            } else {
                JOptionPane.showMessageDialog(this, "No existe película con ese ID");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void actualizarPelicula() {
        if (txtId.getText().isEmpty() || txtTitulo.getText().isEmpty() || txtDirector.getText().isEmpty() ||
            txtAnio.getText().isEmpty() || txtGenero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos obligatorios");
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE Cartelera SET titulo=?, director=?, anio=?, duracion=?, genero=? WHERE id=?")) {
            stmt.setString(1, txtTitulo.getText());
            stmt.setString(2, txtDirector.getText());
            stmt.setInt(3, Integer.parseInt(txtAnio.getText()));
            stmt.setInt(4, txtDuracion.getText().isEmpty() ? 0 : Integer.parseInt(txtDuracion.getText()));
            stmt.setString(5, txtGenero.getText());
            stmt.setInt(6, Integer.parseInt(txtId.getText()));

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Película actualizada");
            } else {
                JOptionPane.showMessageDialog(this, "No existe película con ese ID");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTitulo.setText("");
        txtDirector.setText("");
        txtAnio.setText("");
        txtDuracion.setText("");
        txtGenero.setText("");
    }
}

