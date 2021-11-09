package entrega3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import juegosOlimpicos.Deportista;

public class DeportistaDAOjdbc implements DeportistaDAO {

	@Override // TE DEVUELVE UNA LISTA DE TODOS LOS DEPORTISTAS
	public List<Deportista> getList() {
		try {

			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();

			List<Deportista> l = new LinkedList<Deportista>();
			ResultSet result = sent.executeQuery("select * from deportista");
			while (result.next()) {
				l.add(new Deportista(result.getString("apellidos"), result.getString("nombres"), result.getInt("id")));
			}
			return l;

		} catch (SQLException e) {
			System.out.println("Error SQL");
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override // TE GUARDA UN NUEVO DEPORTISTA EN LA BASE DE DATOS
	public void guardar(Deportista d) {
		try {

			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();

			sent.executeUpdate(
					"INSERT INTO `deportista` (apellidos, nombres, email, telefono) VALUES ('" + d.getApellido()
							+ "', '" + d.getNombre() + "','" + d.getEmail() + "', '" + d.getTelefono() + "')");

			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}