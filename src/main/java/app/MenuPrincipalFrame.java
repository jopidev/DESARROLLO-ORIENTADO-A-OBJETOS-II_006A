
package app;

import javax.swing.*;
import java.awt.*;



public class MenuPrincipalFrame extends JFrame {
    public MenuPrincipalFrame() {
        setTitle("Gestión de Películas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnListar = new JButton("Listar/Buscar");
        JPanel p = new JPanel(new GridLayout(3,1,8,8));
        p.add(btnModificar);
        p.add(btnEliminar);
        p.add(btnListar);
        add(p, BorderLayout.CENTER);
        btnModificar.addActionListener(e -> new ModificarPeliculaFrame().setVisible(true));
        btnEliminar.addActionListener(e -> new EliminarPeliculaFrame().setVisible(true));
        btnListar.addActionListener(e -> new ListarPeliculasFrame().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipalFrame().setVisible(true));
    }

    
}



