package entrega3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import juegosOlimpicos.Disciplina;
import juegosOlimpicos.Pais;

public class DisciplinaDAOjdbc implements DisciplinaDAO {

	@Override
	public List<Disciplina> getList() {
		try {

			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();

			List<Disciplina> l = new LinkedList<Disciplina>();
			ResultSet result = sent.executeQuery("select * from disciplina");
			while (result.next()) {
				l.add(new Disciplina(result.getInt("id"), result.getString("nombre")));
			}
			return l;

		} catch (SQLException e) {
			System.out.println("Error SQL");
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Disciplina getDisciplina(int id) {
		try {
			Connection con = MiConnection.getCon();
			Statement sent = con.createStatement();
			ResultSet result = sent.executeQuery("Select * FROM disciplina where id=" + id);
			result.next();
			Disciplina d = new Disciplina(result.getInt("id"),result.getString("nombre"));
			con.commit();
			return d;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
