package entrega3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import juegosOlimpicos.Deportista;
import juegosOlimpicos.Disciplina;
import juegosOlimpicos.Pais;

public class DeportistaDAOjdbc implements DeportistaDAO {

	@Override // TE DEVUELVE UNA LISTA DE TODOS LOS DEPORTISTAS
	public List<Deportista> getList() {
		try {

			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			
			Pais p;
			Disciplina d;
			PaisDAO conPais = new PaisDAOjdbc();
			DisciplinaDAO conDisciplina = new DisciplinaDAOjdbc();
			List<Deportista> l = new LinkedList<Deportista>();
			ResultSet result = sent.executeQuery("select * from deportista");
			while (result.next()) {
				p = conPais.getPais(result.getInt("id_pais"));
				//d = conDisciplina.getDisciplina();
				l.add(new Deportista(result.getInt("id"),result.getString("apellidos"), result.getString("nombres"), result.getString("email"), p,new Disciplina(-1, "Falta hacer")));
			}
			return l;

		} catch (SQLException e) {
			System.out.println("Error SQL");
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int getFilas() {
		try {
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			ResultSet result = sent.executeQuery("select count(1) from deportista");
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	@Override // TE GUARDA UN NUEVO DEPORTISTA EN LA BASE DE DATOS
	public int guardar(Deportista d) {
		try {
			
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			ResultSet result = sent.executeQuery("select max(id) from deportista");
			result.next();
			int id = result.getInt(1)+1;
			sent.executeUpdate(
					"INSERT INTO `deportista` (apellidos, nombres, email, telefono,id_pais) VALUES ('" + d.getApellido()
							+ "', '" + d.getNombre() + "','" + d.getEmail() + "', '" + d.getTelefono() +"' , '"+d.getPais().getId()+ "')");

			con.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}