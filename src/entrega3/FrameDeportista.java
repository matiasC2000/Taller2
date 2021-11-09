package entrega3;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class FrameDeportista extends JFrame {

	JButton buttonVolver = new JButton("Volver");

	public FrameDeportista() {
		super("Gestor de olimpiadas - Deportista");
		this.setLayout(new FlowLayout());
		buttonVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // REGRESA AL MENU
				dispose();
				new FrameMenu();
			}
		});
		this.add(buttonVolver);
		this.setPreferredSize(new Dimension(400, 200));
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
