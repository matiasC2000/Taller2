package entrega3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class FrameCredenciales extends JFrame {

	JButton buttonVolver = new JButton("Volver");
	JButton buttonGuardar = new JButton("Guardar");
	static JTextField usuario = new JTextField("root");
	static JTextField contraseña = new JTextField("1234");

	public FrameCredenciales() {
		super("Gestor de olimpiadas - CONFIGURACION");
		this.setLayout(new FlowLayout());
		buttonVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // REGRESA AL MENU
				dispose();
				new FrameMenu();
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		
		JTextField texto = new JTextField("Usuario");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(usuario);
		
		texto = new JTextField("Contraseña");
		texto.setEditable(false);
		panel.add(texto);
		panel.add(contraseña);
		
		
		panel.setPreferredSize(new Dimension(320, 30));
		buttonGuardar.addActionListener(new GuardarListener());
		this.add(panel);
		this.add(buttonGuardar);
		this.add(buttonVolver);
		this.setPreferredSize(new Dimension(400, 200));
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class GuardarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			MiConnection.realizarConexion(usuario.getText(), contraseña.getText());
			dispose();
			new FrameMenu();
		}
	}

}
