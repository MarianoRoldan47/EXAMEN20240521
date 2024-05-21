package examen;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import examen.view.PanelClasificacion;
import examen.view.PanelGestionSocios;

public class JFrameDatosDelSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear y configurar el JFrame
                JFrame frame = new JFrame("Ventana Principal");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 400);

                frame.add(new PanelGestionSocios());

                // Hacer el JFrame visible
                frame.setVisible(true);
            }
        });
	}

}
