package entrega3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import juegosOlimpicos.Pais;

public class FramePais extends JFrame {

	private static final long serialVersionUID = 1L;

	// private FramePrincipal pane;

	private JButton buttonNuevo;
	private JButton buttonVolver;
	private JTable table;

	Object[][] data;

	public FramePais() {
		super("Gestor de olimpiadas - PAIS");
		this.setLayout(new FlowLayout());
		// BOTON NUEVO
		buttonNuevo = new JButton("Nuevo");
		buttonNuevo.addMouseListener(new MouseAdapter() { // REGRESA AL MENU
			public void mouseClicked(MouseEvent e) {
				dispose();
				new FrameNuevoPais();
			}
		});
		// BOTON VOLVER
		buttonVolver = new JButton("Volver");
		buttonVolver.addMouseListener(new MouseAdapter() { // REGRESA AL MENU
			public void mouseClicked(MouseEvent e) {
				dispose();
				new FrameMenu();
			}
		});
		
		// TABLA
		String[] columnNames = { "Id", "Pais", "Editar", "Eliminar" };

		PaisDAO conex = new PaisDAOjdbc(); // USO ESTA CONEXION PARA SABER EL TAMAÑO DE LA TABLA

		data = new Object[conex.getFilas()][];
		int i = 0;
		for (Pais e : new PaisDAOjdbc().getList()) {
			Object[] f = { e.getId(), e.getNombre() };
			data[i] = f;
			i++;
		}

		table = new JTable(new ModeloPaises(data, columnNames));
		
		ButtonEliminar buttonEliminar = new ButtonEliminar(table, 4);

		//ButtonEditar buttonEditar = new ButtonEditar(table, 3);

		this.add(new JScrollPane(table));

		this.add(buttonNuevo, BorderLayout.NORTH);
		this.add(buttonVolver, BorderLayout.NORTH);
		this.setPreferredSize(new Dimension(650, 500));
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class ModeloPaises extends DefaultTableModel {
		private static final long serialVersionUID = 8164505737793198161L;

		public ModeloPaises(final Object[][] datos, final String[] titulos) {
			super(datos, titulos);
		}

		public Class<?> getColumnClass(final int column) {
			return this.getValueAt(0, column).getClass();
		}
	}
	
	
	class ButtonEliminar extends AbstractCellEditor
    implements TableCellRenderer, TableCellEditor, ActionListener
{
    JTable table;
    JButton renderButton;
    JButton editButton;
    String text;

    public ButtonEliminar(JTable table, int column)
    {
        super();
        this.table = table;
        renderButton = new JButton();

        editButton = new JButton();
        editButton.setFocusPainted( false );
        editButton.addActionListener( this );

        table.getColumn("Eliminar").setCellRenderer( this );
        table.getColumn("Eliminar").setCellEditor( this );
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (hasFocus)
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }
        else if (isSelected)
        {
            renderButton.setForeground(table.getSelectionForeground());
             renderButton.setBackground(table.getSelectionBackground());
        }
        else
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText( (value == null) ? "Eliminar" : value.toString() );
        return renderButton;
    }

    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        text = (value == null) ? "Eliminar" : value.toString();
        editButton.setText( text );
        return editButton;
    }

    public Object getCellEditorValue()
    {
        return text;
    }

    public void actionPerformed(ActionEvent e)
    {
        fireEditingStopped();
        System.out.println("HOLA");
		PaisDAOjdbc conex = new PaisDAOjdbc();
		int row = table.getSelectedRow();
		System.out.print(row);
		if(row != -1) {
			//Busca el id de la fila y lo elimina de la base de datos
			conex.eliminar((int)((DefaultTableModel)table.getModel()).getValueAt(row, 0));
			((DefaultTableModel)table.getModel()).removeRow(row); //elimina la fila
		}
		System.out.print("fila" + row);
    }
}
	

	class ButtonEditar extends AbstractCellEditor
    implements TableCellRenderer, TableCellEditor, ActionListener
{
    JTable table;
    JButton renderButton;
    JButton editButton;
    String text;

    public ButtonEditar(JTable table, int column)
    {
        super();
        this.table = table;
        renderButton = new JButton();

        editButton = new JButton();
        editButton.setFocusPainted( false );
        editButton.addActionListener( this );

        table.getColumn("Eliminar").setCellRenderer( this );
        table.getColumn("Eliminar").setCellEditor( this );
    }

    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (hasFocus)
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }
        else if (isSelected)
        {
            renderButton.setForeground(table.getSelectionForeground());
             renderButton.setBackground(table.getSelectionBackground());
        }
        else
        {
            renderButton.setForeground(table.getForeground());
            renderButton.setBackground(UIManager.getColor("Button.background"));
        }

        renderButton.setText( (value == null) ? "Eliminar" : value.toString() );
        return renderButton;
    }

    public Component getTableCellEditorComponent(
        JTable table, Object value, boolean isSelected, int row, int column)
    {
        text = (value == null) ? "Eliminar" : value.toString();
        editButton.setText( text );
        return editButton;
    }

    public Object getCellEditorValue()
    {
        return text;
    }

    public void actionPerformed(ActionEvent e)
    {
        fireEditingStopped();
		// System.out.print("fila" + row);
		//PaisDAO conex = new PaisDAOjdbc();
		dispose();
		int row = table.getSelectedRow();
		new FrameEditarPais((int) data[row][0], (String) data[row][1]);
    }
}
	
	
	
	
	

}
