package entrega3;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import entrega3.FramePais.ModeloPaises;
import juegosOlimpicos.Deportista;
import juegosOlimpicos.Pais;

public class FrameDeportista extends JFrame {

	JButton buttonVolver = new JButton("Volver");
	JButton buttonNuevo = new JButton("+Nuevo");
	JButton buttonExportar = new JButton("Exportar CSV");
	JTable table;
	Object [][] data= {{"Nombre","Arg","Tiro","",""}};

	public FrameDeportista() {
		super("Gestor de olimpiadas - Deportista");
		
		
		// BOTON NUEVO
				buttonNuevo = new JButton("Nuevo");
				buttonNuevo.addMouseListener(new MouseAdapter() { // REGRESA AL MENU
					public void mouseClicked(MouseEvent e) {
						dispose();
						new FrameNuevoDeportista();
					}
				});
				
				
		// BOTON VOLVER
		buttonVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // REGRESA AL MENU
				dispose();
				new FrameMenu();
			}
		});
		
		
		String[] columnNames = { "Nombre", "Pais", "Disciplina", "Editar","Eliminar" };
		
		DeportistaDAO conex = new DeportistaDAOjdbc(); // USO ESTA CONEXION PARA SABER EL TAMAÑO DE LA TABLA

		data = new Object[conex.getFilas()][];
		int i = 0;
		for (Deportista d : new DeportistaDAOjdbc().getList()) {
			Object[] f = { d.getNombre(),d.getPais().getNombre(),d.getDisciplina().getNombre(),"","",d.getId()};//en la ultima pos guardo el id pero no lo muestra
			data[i] = f;
			i++;
		}
		
		table = new JTable(data, columnNames);
		
		
		Container pane = this.getContentPane();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		
		JPanel botones = new JPanel(new FlowLayout());
		botones.add(buttonNuevo);
		botones.add(buttonExportar);
		botones.add(buttonVolver);
		pane.add(botones);
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                "Deportistas", TitledBorder.CENTER, TitledBorder.TOP));
		panelTable.add(new JScrollPane(table));
		pane.add(panelTable);
		
		this.setPreferredSize(new Dimension(800, 200));
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
