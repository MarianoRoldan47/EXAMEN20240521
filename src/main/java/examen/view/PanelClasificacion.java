package examen.view;

import javax.swing.JPanel;

import examen.controller.ControladorEquipo;
import examen.model.Equipo;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClasificacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private DefaultListModel<Equipo> listaEquipos = new DefaultListModel<Equipo>();
	private JList<Equipo> lista;

	/**
	 * Create the panel.
	 */
	public PanelClasificacion() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Clasificacion");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
//		gbl_panel_1.columnWidths = new int[]{0, 0};
//		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JButton jbtnReset = new JButton("Reset");
		jbtnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEquipos();
			}
		});
		GridBagConstraints gbc_jbtnReset = new GridBagConstraints();
		gbc_jbtnReset.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnReset.gridx = 0;
		gbc_jbtnReset.gridy = 0;
		panel_1.add(jbtnReset, gbc_jbtnReset);

		JButton jbtnArriba = new JButton("Arriba");
		jbtnArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subir();
			}
		});
		GridBagConstraints gbc_jbtnArriba = new GridBagConstraints();
		gbc_jbtnArriba.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnArriba.gridx = 0;
		gbc_jbtnArriba.gridy = 1;
		panel_1.add(jbtnArriba, gbc_jbtnArriba);

		JButton jbtnAbajo = new JButton("Abajo");
		jbtnAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bajar();
			}
		});
		GridBagConstraints gbc_jbtnAbajo = new GridBagConstraints();
		gbc_jbtnAbajo.insets = new Insets(0, 0, 5, 0);
		gbc_jbtnAbajo.gridx = 0;
		gbc_jbtnAbajo.gridy = 2;
		panel_1.add(jbtnAbajo, gbc_jbtnAbajo);

		JButton jbtnEliminar = new JButton("Eliminar");
		jbtnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		GridBagConstraints gbc_jbtnEliminar = new GridBagConstraints();
		gbc_jbtnEliminar.gridx = 0;
		gbc_jbtnEliminar.gridy = 3;
		panel_1.add(jbtnEliminar, gbc_jbtnEliminar);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		lista = cargarEquipos();

		scrollPane.setViewportView(lista);

	}

	private void subir() {
		int seleccion = lista.getSelectedIndex();
		if (seleccion - 1 > -1) {
			Equipo aux = lista.getSelectedValue();
			lista.getSelectedValue();
			listaEquipos.remove(seleccion);
			listaEquipos.add(seleccion - 1, aux);
			lista.setSelectedIndex(seleccion - 1);
		}
	}
	
	private void bajar() {
		int seleccion = lista.getSelectedIndex();
		if (seleccion + 1 < listaEquipos.getSize()) {
			Equipo aux = lista.getSelectedValue();
			lista.getSelectedValue();
			listaEquipos.remove(seleccion);
			listaEquipos.add(seleccion + 1, aux);
			lista.setSelectedIndex(seleccion + 1);
		}
	}
	
	private void eliminar() {
		int seleccion = lista.getSelectedIndex();
		listaEquipos.remove(seleccion);
	}

	@SuppressWarnings("unchecked")
	private JList<Equipo> cargarEquipos() {

		List<Equipo> Equipos = (List<Equipo>) ControladorEquipo.getInstance().findAll();
		listaEquipos.removeAllElements();
		
		for (Equipo equipo : Equipos) {
			listaEquipos.addElement(equipo);
		}

		JList<Equipo> lista = new JList<Equipo>(getDefaultListModelNoSeleccionados());

		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		return lista;
	}

	@SuppressWarnings("rawtypes")
	private DefaultListModel getDefaultListModelNoSeleccionados() {
		return this.listaEquipos;
	}

}
