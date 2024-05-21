package examen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import examen.view.PanelClasificacion;

public class JFramePanelClasificacion {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Crear y configurar el JFrame
                JFrame frame = new JFrame("Ventana Principal");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 400);

                frame.add(new PanelClasificacion());

                // Hacer el JFrame visible
                frame.setVisible(true);
            }
        });
	}

}
