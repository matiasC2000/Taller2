package entrega3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import juegosOlimpicos.Pais;

public class FrameNuevoDeportista extends JFrame {
	JButton buttonVolver = new JButton("Volver");
	JTextField nombre = new JTextField("");
	JTextField apellido = new JTextField("");
	JTextField email = new JTextField("");
	JTextField telefono = new JTextField("");
	JComboBox<Pais> pais;
	JTextField desciplina = new JTextField("");
	
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
		
		texto = new JTextField("telefono");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(telefono);
		
		texto = new JTextField("pais");
		texto.setEditable(false);
		panel.add(texto);
		pais = new JComboBox<Pais>();
		Pais p = new Pais("Argentina");
		pais.addItem(p);
		p = new Pais("Peru");
		pais.addItem(p);
		p = new Pais("Chile");
		pais.addItem(p);
		
		panel.add(pais);
		
		texto = new JTextField("desciplina");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(desciplina);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(panel,c);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		pane.add(buttonVolver,c);

		this.setPreferredSize(new Dimension(800, 200));
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
