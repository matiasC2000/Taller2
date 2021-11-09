package entrega3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import juegosOlimpicos.Pais;

public class FrameEditarPais extends FrameAgregarPais {

	JButton buttonEditar = new JButton("Editar");
	int id;

	public FrameEditarPais(int id, String nom) {
		super("Gestor de olimpiadas - NUEVO PAIS");
		this.id = id;
		nombre.setText(nom);
		
		buttonEditar.addActionListener(new GuardarListener());
		this.add(buttonEditar);
		
	}

	private class GuardarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String elTexto = nombre.getText();
			// System.out.println(elTexto);
			elTexto = elTexto.replaceAll(" ", "");
			boolean estaBien = true;
			char[] chars = elTexto.toCharArray();

			// Verifica que tiene solo letras
			for (char c : chars) {
				if (!Character.isLetter(c)) {
					System.out.println("Error");
					estaBien = false;
				}
			}

			// Verifica que no se repita
			for (Pais p : new PaisDAOjdbc().getList()) {
				// System.out.println(p.getNombre() +"-"+ elTexto);
				if (p.getNombre().equals(elTexto)) {
					System.out.println("Error");
					estaBien = false;
				}
			}
			// System.out.println(elTexto);
			if (estaBien) {
				PaisDAO conex = new PaisDAOjdbc();
				conex.editar(new Pais(elTexto, id));
			}
			dispose();
			new FramePais();
		}
	}

}
