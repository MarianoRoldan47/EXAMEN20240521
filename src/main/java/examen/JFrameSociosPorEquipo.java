package examen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import examen.view.PanelSociosDeEquipo;

public class JFrameSociosPorEquipo extends JFrame {

	private static final long serialVersionUID = 1L;

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

                frame.add(new PanelSociosDeEquipo());

                // Hacer el JFrame visible
                frame.setVisible(true);
            }
        });
	}

}
