package entrega3;

import javax.swing.*;

import juegosOlimpicos.Pais;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameNuevoPais extends FrameAgregarPais {

	JButton buttonGuardar = new JButton("Guardar");

	public FrameNuevoPais() {
		super("Gestor de olimpiadas - NUEVO PAIS");		
		buttonGuardar.addActionListener(new GuardarListener());
		this.add(buttonGuardar);
	}

	private class GuardarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String elTexto = nombre.getText();
			// System.out.println(elTexto);
			elTexto = elTexto.replaceAll(" ", "");
			boolean estaBien = true;
			char[] chars = elTexto.toCharArray();

			// Verifica que solo contenga letras
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
				conex.guardar(new Pais(elTexto));
			}
			dispose();
			new FramePais();
		}
	}

}
