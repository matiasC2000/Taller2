package entrega3;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import juegosOlimpicos.Deportista;
import juegosOlimpicos.Disciplina;
import juegosOlimpicos.Pais;

public class FrameNuevoDeportista extends JFrame {
	JButton buttonVolver = new JButton("Volver");
	JButton buttonGuardar = new JButton("Guardar");
	JTextField nombre = new JTextField("");
	JTextField apellido = new JTextField("");
	JTextField email = new JTextField("");
	//JTextField telefono = new JTextField("");
	JComboBox<Pais> paises;
	JComboBox<Disciplina> disciplinas;

	public FrameNuevoDeportista() {

		// BOTON VOLVER
		buttonVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // REGRESA AL MENU
				dispose();
				new FrameMenu();
			}
		});

		Container pane = this.getContentPane();
		pane.setLayout(new GridBagLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));

		JTextField texto = new JTextField("nombre");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(nombre);

		texto = new JTextField("e-mail");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(email);

		texto = new JTextField("Apellido");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(apellido);

		texto = new JTextField("pais");
		texto.setEditable(false);
		panel.add(texto);

		paises = new JComboBox<Pais>();
		PaisComboRender renderPais = new PaisComboRender();
		paises.setRenderer(renderPais);

		actualizarComboPais(paises);
		panel.add(paises);

		texto = new JTextField("disciplina");
		texto.setEditable(false);
		panel.add(texto);
		
		disciplinas = new JComboBox<Disciplina>();
		DisciplinaComboRender renderDisciplina = new DisciplinaComboRender();
		disciplinas.setRenderer(renderDisciplina);
		
		actualizarComboDisciplina(disciplinas);
		panel.add(disciplinas);
		
		GridBagConstraints c = new GridBagConstraints();
		
		

		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(panel, c);
		
		buttonGuardar.addActionListener(new GuardarListener());
		this.add(buttonGuardar);
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(buttonGuardar, c);

		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		pane.add(buttonVolver, c);

		this.setPreferredSize(new Dimension(800, 200));
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void actualizarComboDisciplina(JComboBox<Disciplina> disciplinas) {
		List<Disciplina> lista = new DisciplinaDAOjdbc().getList();
		for (Disciplina e : lista) {
			disciplinas.addItem(e);
		}
	}

	private void actualizarComboPais(JComboBox<Pais> paises) {
		List<Pais> lista = new PaisDAOjdbc().getList();
		for (Pais e : lista) {
			paises.addItem(e);
		}
	}
	
	private class GuardarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String elNombre = nombre.getText();
			// System.out.println(elTexto);
			
			elNombre = elNombre.replaceAll(" ", "");
			boolean estaBien = true;
			
			estaBien = contieneLetras(elNombre);
			
			String elemail = email.getText();
			elemail.replaceAll(" ", "");
			
			String elApellido = apellido.getText();
			// System.out.println(elTexto);
			elApellido = elApellido.replaceAll(" ", "");

			estaBien = contieneLetras(elApellido);
			
			String elDisciplina = ((Disciplina)disciplinas.getSelectedItem()).getNombre();
			//long elTelefono = Long.parseLong(telefono.getText());
			
			// Verifica que no se repita
			for (Deportista d : new DeportistaDAOjdbc().getList()) {
				// System.out.println(p.getNombre() +"-"+ elTexto);
				if ( (d.getNombre().equals(elNombre)) && (d.getApellido().equals(elApellido))) { //Falta Comparar mas campos
					System.out.println("Error");
					estaBien = false;
				}
			}
			// System.out.println(elTexto);
			if (estaBien) {
				DeportistaDAO conex = new DeportistaDAOjdbc();
				Pais p = (Pais) paises.getSelectedItem();
				Disciplina d = (Disciplina) disciplinas.getSelectedItem();
				Deportista nuevo = new Deportista(elNombre,elApellido,elemail,p,d);
				System.out.print(conex.guardar(nuevo));
			}
			dispose();
			new FrameDeportista();
		}
		
		private boolean contieneLetras(String palabra) {
			char[] chars = palabra.toCharArray();
			boolean estaBien = true;
			for (char c : chars) {
				if (!Character.isLetter(c)) {
					System.out.println("Error");
					estaBien = false;
				}
			}
			return estaBien;
		}
	}

	class PaisComboRender extends JLabel implements ListCellRenderer<Pais> {
		public PaisComboRender() {
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Pais> list, Pais value, int index,
				boolean isSelected, boolean cellHasFocus) {
			// Get the selected index. (The index parameter isn't
			// always valid, so just use the value.)

			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}

			setText(value.getNombre());

			return this;
		}
	}

	class DisciplinaComboRender extends JLabel implements ListCellRenderer<Disciplina> {
		public DisciplinaComboRender() {
			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList<? extends Disciplina> list, Disciplina value, int index,
				boolean isSelected, boolean cellHasFocus) {
			// Get the selected index. (The index parameter isn't
			// always valid, so just use the value.)

			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}

			setText(value.getNombre());

			return this;
		}
	}

}
