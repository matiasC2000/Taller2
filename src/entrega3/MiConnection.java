package entrega3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConnection {
	private static Connection con = null;
	private static boolean seHizoConexion = false;
	// private static String usuario = "root";
	// private static String contrase�a = "1234";

	// ESTABLECE LA CONEXION A LA BASE DE DATOS
	public static void realizarConexion(String usuario, String contrase�a) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokyo2021_e3", usuario, contrase�a);
			con.setAutoCommit(false);
			seHizoConexion = true;
		} catch (SQLException e) {
			System.out.println("Error SQL");
			System.out.println(e.getMessage());
		}
	}

	public static Connection getCon() {
		return con;
	}

	public static boolean isSeHizoConexion() {
		return seHizoConexion;
	}

}
