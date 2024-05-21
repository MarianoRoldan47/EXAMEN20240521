package examen.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.event.ChangeEvent;

import examen.Utils.UtilsBBDD;
import examen.controller.ControladorEquipo;
import examen.controller.ControladorSocio;
import examen.model.Equipo;
import examen.model.Socio;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class PanelGestionSocios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSegundoApellido;
	private JTextField jtfPrimerApellido;
	private JTextField jtfNombre;
	private JComboBox<Equipo> jcbEquipo;
	private JLabel jlabelAntiguedad;
	private JCheckBox jchkSocioActivo;
	private JSlider jsliderAntiguedad;
	private Socio actual;
	private JFormattedTextField jtfFechaNacimiento;

	/**
	 * Create the panel.
	 */
	public PanelGestionSocios() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton jbtnPrimero = new JButton("");
		jbtnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		jbtnPrimero.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/gotostart.png")));
		toolBar.add(jbtnPrimero);

		JButton jbtnAnterior = new JButton("");
		jbtnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		jbtnAnterior.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/previous.png")));
		toolBar.add(jbtnAnterior);

		JButton jbtnSiguiente = new JButton("");
		jbtnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		jbtnSiguiente.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/next.png")));
		toolBar.add(jbtnSiguiente);

		JButton jbtnUltimo = new JButton("");
		jbtnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		jbtnUltimo.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/gotoend.png")));
		toolBar.add(jbtnUltimo);

		JButton jbtnNuevo = new JButton("");
		jbtnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		jbtnNuevo.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/nuevo.png")));
		toolBar.add(jbtnNuevo);

		JButton jbtnGuardar = new JButton("");
		jbtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		jbtnGuardar.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/guardar.png")));
		toolBar.add(jbtnGuardar);

		JButton jbtnEliminar = new JButton("");
		jbtnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		jbtnEliminar.setIcon(new ImageIcon(PanelGestionSocios.class.getResource("/res/eliminar.png")));
		toolBar.add(jbtnEliminar);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 108, 287, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Gestión de socios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Primer Apellido: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfPrimerApellido = new JTextField();
		GridBagConstraints gbc_jtfPrimerApellido = new GridBagConstraints();
		gbc_jtfPrimerApellido.gridwidth = 2;
		gbc_jtfPrimerApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrimerApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrimerApellido.gridx = 1;
		gbc_jtfPrimerApellido.gridy = 2;
		panel.add(jtfPrimerApellido, gbc_jtfPrimerApellido);
		jtfPrimerApellido.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Segundo Apellido: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.gridwidth = 2;
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 1;
		gbc_jtfSegundoApellido.gridy = 3;
		panel.add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Fecha nacimiento: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfFechaNacimiento = new JFormattedTextField();
		GridBagConstraints gbc_jtfFechaNacimiento = new GridBagConstraints();
		gbc_jtfFechaNacimiento.gridwidth = 2;
		gbc_jtfFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNacimiento.gridx = 1;
		gbc_jtfFechaNacimiento.gridy = 4;
		panel.add(jtfFechaNacimiento, gbc_jtfFechaNacimiento);

		JLabel lblNewLabel_5 = new JLabel("Antigüedad: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jsliderAntiguedad = new JSlider();
		jsliderAntiguedad.setMaximum(200);
		GridBagConstraints gbc_jsliderAntiguedad = new GridBagConstraints();
		gbc_jsliderAntiguedad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jsliderAntiguedad.insets = new Insets(0, 0, 5, 5);
		gbc_jsliderAntiguedad.gridx = 1;
		gbc_jsliderAntiguedad.gridy = 5;
		panel.add(jsliderAntiguedad, gbc_jsliderAntiguedad);

		jlabelAntiguedad = new JLabel("4 años");
		GridBagConstraints gbc_jlabelAntiguedad = new GridBagConstraints();
		gbc_jlabelAntiguedad.insets = new Insets(0, 0, 5, 0);
		gbc_jlabelAntiguedad.gridx = 2;
		gbc_jlabelAntiguedad.gridy = 5;
		panel.add(jlabelAntiguedad, gbc_jlabelAntiguedad);

		jchkSocioActivo = new JCheckBox("Socio en activo");
		GridBagConstraints gbc_jchkSocioActivo = new GridBagConstraints();
		gbc_jchkSocioActivo.anchor = GridBagConstraints.WEST;
		gbc_jchkSocioActivo.insets = new Insets(0, 0, 5, 5);
		gbc_jchkSocioActivo.gridx = 1;
		gbc_jchkSocioActivo.gridy = 6;
		panel.add(jchkSocioActivo, gbc_jchkSocioActivo);

		JLabel lblNewLabel_6 = new JLabel("Equipo: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jcbEquipo = new JComboBox<Equipo>();
		GridBagConstraints gbc_jcbEquipo = new GridBagConstraints();
		gbc_jcbEquipo.gridwidth = 2;
		gbc_jcbEquipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEquipo.gridx = 1;
		gbc_jcbEquipo.gridy = 7;
		panel.add(jcbEquipo, gbc_jcbEquipo);

		addControlCustomizableBehaviours();

		cargarEquipos();

		cargarPrimero();

	}
	
	private void eliminar() {
		ControladorSocio.getInstance().remove(actual);
		cargarPrimero();
	}
	
	
	private void nuevo() {
		Socio s = new Socio();
		
		s.setId(0);
		s.setNombre("");
		s.setApellido1("");
		s.setApellido2("");
		s.setActivo(false);
		s.setAntiguedadAnios(0);
		s.setEquipo(null);
		s.setFechaNacimiento(null);
		
		mostrarEntidad(s);
	}
	
	private void guardar() {		
		actual.setNombre(jtfNombre.getText());
		actual.setActivo(jchkSocioActivo.isSelected());
		actual.setAntiguedadAnios(jsliderAntiguedad.getValue());
		actual.setApellido1(jtfPrimerApellido.getText());
		actual.setApellido2(jtfSegundoApellido.getText());
		actual.setEquipo(((Equipo)jcbEquipo.getSelectedItem()));
		actual.setFechaNacimiento(UtilsBBDD.getDateFromString("dd/MM/yyyy",jtfFechaNacimiento.getText()));
		
		ControladorSocio.getInstance().save(actual);
	}

	private void addControlCustomizableBehaviours() {

		// JFormattedTextfield para la fecha de firma, si el valor no es correcto se
		// pone fondo en rojo
		this.jtfFechaNacimiento.setFormatterFactory(new AbstractFormatterFactory() {
			@SuppressWarnings("serial")
			@Override
			public AbstractFormatter getFormatter(JFormattedTextField tf) {
				return new JFormattedTextField.AbstractFormatter() {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					@Override
					public String valueToString(Object value) throws ParseException {
						if (value != null && value instanceof Date) {
							jtfFechaNacimiento.setBackground(Color.WHITE);
							return sdf.format(((Date) value));
						}
						return "";
					}

					@Override
					public Object stringToValue(String text) throws ParseException {
						try {
							return sdf.parse(text);
						} catch (Exception e) {
							jtfFechaNacimiento.setBackground(Color.RED);
							JOptionPane.showMessageDialog(null, "Error en la fecha");
							return null;
						}
					}
				};
			}
		});

		// JSpinner, al cambiar de valor modifica el máximo del JSlider
		this.jsliderAntiguedad.addChangeListener(new javax.swing.event.ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				jlabelAntiguedad.setText(jsliderAntiguedad.getValue() + " años");
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void cargarEquipos() {
		List<Equipo> equipos = (List<Equipo>) ControladorEquipo.getInstance().findAll();
		jcbEquipo.removeAllItems();
		for (Equipo equipo : equipos) {
			jcbEquipo.addItem(equipo);
		}
	}

	private void cargarPrimero() {
		mostrarEntidad(ControladorSocio.getInstance().findPrimero());
	}

	private void cargarAnterior() {
		mostrarEntidad(ControladorSocio.getInstance().findAnterior(actual.getId()));
	}

	private void cargarSiguiente() {
		mostrarEntidad(ControladorSocio.getInstance().findSiguiente(actual.getId()));
	}

	private void cargarUltimo() {
		mostrarEntidad(ControladorSocio.getInstance().findUltimo());
	}

	private void mostrarEntidad(Socio s) {
		if (s != null) {
			actual = s;
			jtfNombre.setText(s.getNombre());
			jtfPrimerApellido.setText(s.getApellido1());
			jtfSegundoApellido.setText(s.getApellido2());
			jtfFechaNacimiento.setText((s.getFechaNacimiento()!=null)? UtilsBBDD.getStringFromDate("dd/MM/yyyy", s.getFechaNacimiento()) : "");
			jchkSocioActivo.setSelected(s.getActivo());

			jsliderAntiguedad.setValue(s.getAntiguedadAnios());
			jlabelAntiguedad.setText(s.getAntiguedadAnios() + " años");

			jtfFechaNacimiento.setBackground(Color.WHITE);
			
			if (s.getEquipo() != null) {
				for (int i = 0; i < jcbEquipo.getItemCount(); i++) {
					if (jcbEquipo.getItemAt(i).getId() == s.getEquipo().getId()) {
						jcbEquipo.setSelectedIndex(i);
					}
				}
			}
			
			
		}
	}

}
