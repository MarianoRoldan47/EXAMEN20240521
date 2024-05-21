package examen.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import examen.Utils.UtilsBBDD;
import examen.controller.ControladorEquipo;
import examen.controller.ControladorSocio;
import examen.model.Equipo;
import examen.model.Socio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSociosDeEquipo extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JRadioButton jrdbOrderNombre;
	private JRadioButton jrdbOrderPrimerapellido;
	private JRadioButton jrdbOrderSegundoApellido;
	private JRadioButton jrdbOrderFechaNacimiento;
	private JComboBox<Equipo> jcbEquipo;
	private JScrollPane scrollPane;
	private ButtonGroup bg = new ButtonGroup();
	

	/**
	 * Create the panel.
	 */
	public PanelSociosDeEquipo() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{57, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Socios de equipo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Equipo: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbEquipo = new JComboBox<Equipo>();
		jcbEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaSocios();
			}
		});
		GridBagConstraints gbc_jcbEquipo = new GridBagConstraints();
		gbc_jcbEquipo.gridwidth = 2;
		gbc_jcbEquipo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEquipo.gridx = 1;
		gbc_jcbEquipo.gridy = 1;
		panel.add(jcbEquipo, gbc_jcbEquipo);
		
		jrdbOrderNombre = new JRadioButton("Ordenar por nombre");
		jrdbOrderNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaSocios();
			}
		});
		GridBagConstraints gbc_jrdbOrderNombre = new GridBagConstraints();
		gbc_jrdbOrderNombre.anchor = GridBagConstraints.WEST;
		gbc_jrdbOrderNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jrdbOrderNombre.gridx = 1;
		gbc_jrdbOrderNombre.gridy = 2;
		panel.add(jrdbOrderNombre, gbc_jrdbOrderNombre);
		
		jrdbOrderPrimerapellido = new JRadioButton("Ordenar por Primer Apellido");
		jrdbOrderPrimerapellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaSocios();
			}
		});
		GridBagConstraints gbc_jrdbOrderPrimerapellido = new GridBagConstraints();
		gbc_jrdbOrderPrimerapellido.insets = new Insets(0, 0, 5, 0);
		gbc_jrdbOrderPrimerapellido.anchor = GridBagConstraints.WEST;
		gbc_jrdbOrderPrimerapellido.gridx = 2;
		gbc_jrdbOrderPrimerapellido.gridy = 2;
		panel.add(jrdbOrderPrimerapellido, gbc_jrdbOrderPrimerapellido);
		
		jrdbOrderSegundoApellido = new JRadioButton("Ordenar por Segundo Apellido");
		jrdbOrderSegundoApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaSocios();
			}
		});
		GridBagConstraints gbc_jrdbOrderSegundoApellido = new GridBagConstraints();
		gbc_jrdbOrderSegundoApellido.anchor = GridBagConstraints.WEST;
		gbc_jrdbOrderSegundoApellido.insets = new Insets(0, 0, 0, 5);
		gbc_jrdbOrderSegundoApellido.gridx = 1;
		gbc_jrdbOrderSegundoApellido.gridy = 3;
		panel.add(jrdbOrderSegundoApellido, gbc_jrdbOrderSegundoApellido);
		
		jrdbOrderFechaNacimiento = new JRadioButton("Ordenar por fecha nacimiento");
		jrdbOrderFechaNacimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busquedaSocios();
			}
		});
		GridBagConstraints gbc_jrdbOrderFechaNacimiento = new GridBagConstraints();
		gbc_jrdbOrderFechaNacimiento.anchor = GridBagConstraints.WEST;
		gbc_jrdbOrderFechaNacimiento.gridx = 2;
		gbc_jrdbOrderFechaNacimiento.gridy = 3;
		panel.add(jrdbOrderFechaNacimiento, gbc_jrdbOrderFechaNacimiento);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		bg.add(jrdbOrderNombre);
		bg.add(jrdbOrderPrimerapellido);
		bg.add(jrdbOrderSegundoApellido);
		bg.add(jrdbOrderFechaNacimiento);
		jrdbOrderNombre.setSelected(true);
		
		
		cargarEquipos();
		
		busquedaSocios();

	}
	
	@SuppressWarnings("unchecked")
	private void cargarEquipos() {
		List<Equipo> equipos = (List<Equipo>) ControladorEquipo.getInstance().findAll();
		jcbEquipo.removeAllItems();
		for (Equipo equipo : equipos) {
			jcbEquipo.addItem(equipo);
		}
	}
	
	@SuppressWarnings({ "unchecked", "serial" })
	private void busquedaSocios() {
		
		List<Socio> sociosOrdenados = null;
		if(jrdbOrderNombre.isSelected()) {
			sociosOrdenados = (List<Socio>) ControladorSocio.getInstance().findAllOrderAndEquipo("nombre", ((Equipo)jcbEquipo.getSelectedItem()).getId());
		}
		
		if(jrdbOrderPrimerapellido.isSelected()) {
			sociosOrdenados = (List<Socio>) ControladorSocio.getInstance().findAllOrderAndEquipo("apellido1", ((Equipo)jcbEquipo.getSelectedItem()).getId());
		}
		
		if(jrdbOrderSegundoApellido.isSelected()) {
			sociosOrdenados = (List<Socio>) ControladorSocio.getInstance().findAllOrderAndEquipo("apellido2", ((Equipo)jcbEquipo.getSelectedItem()).getId());
		}
		
		if(jrdbOrderFechaNacimiento.isSelected()) {
			sociosOrdenados = (List<Socio>) ControladorSocio.getInstance().findAllOrderAndEquipo("fechaNacimiento", ((Equipo)jcbEquipo.getSelectedItem()).getId());
		}
		
		
		
		// Convierto datos de lista a matriz
		Object m[][] = new Object[sociosOrdenados.size()][4];
		for (int i = 0; i < m.length; i++) {
			m[i][0] = sociosOrdenados.get(i).getNombre();
			m[i][1] = sociosOrdenados.get(i).getApellido1();
			m[i][2] = sociosOrdenados.get(i).getApellido2();
			m[i][3] = UtilsBBDD.getStringFromDate("dd/MM/yyyy", sociosOrdenados.get(i).getFechaNacimiento());
		}
		
		// Creo una tabla con los datos anteriores, con un DefaultTableModel que no permita editar filas
		DefaultTableModel dtm = new DefaultTableModel(m, 
				new String[] {"Nombre", "Primer apellido","Segundo apellido", "Fecha nacimiento"}) {			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		JTable table = new JTable(dtm);
		
		
		
		// Determino el mecanismo de doble clic de seleccion del tipo de contrato sobre la tabla
		final List<Socio> sociosOrdenadosFinal = sociosOrdenados;
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				// Compruebo el doble clic
				if (e.getClickCount() > 1) {
					if (table.getSelectedRow() > -1) {
						Socio s = sociosOrdenadosFinal.get(table.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Has seleccionado a " + s.getNombre() + " con id: " + s.getId());
					}
				}
			}
			
		});
		
		// Muestro la JTable construida
		scrollPane.setViewportView(table);
	}

}
