package entrega3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import juegosOlimpicos.Pais;

public class PaisDAOjdbc implements PaisDAO {

	@Override // TE DEVUELVE UNA LISTA DE TODOS LOS PAISES
	public List<Pais> getList() {
		try {

			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();

			List<Pais> l = new LinkedList<Pais>();
			ResultSet result = sent.executeQuery("select * from pais");
			while (result.next()) {
				l.add(new Pais(result.getString("nombre"), result.getInt("id")));
			}
			return l;

		} catch (SQLException e) {
			System.out.println("Error SQL");
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override // TE GUARDA UN NUEVO PAIS EN LA BASE DE DATOS
	public void guardar(Pais d) {
		try {
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();

			sent.executeUpdate("INSERT INTO `pais` (nombre) VALUES ('" + d.getNombre() + "')");
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getFilas() {
		try {
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			ResultSet result = sent.executeQuery("select count(1) from pais");
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public void eliminar(int id) {
		try {
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			sent.execute("DELETE FROM pais where id=" + id);
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void editar(Pais p) {
		try {
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			sent.execute("Update pais set nombre= '" + p.getNombre() + "' where id= '" + p.getId() + "'");
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
