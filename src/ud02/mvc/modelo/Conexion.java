package ud02.mvc.modelo;

import java.sql.*;

public class Conexion {

	/**
	 * Clase que permite conectar con la base de datos
	 */

	static String bd = "EjemploMVC";
	static String login = "SegundoDAM";

	static String password = "SegundoDAM";
	static String url = "jdbc:mysql://localhost/" + bd;
	Connection conn = null;

	/** Constructor de DbConnection */
	public Conexion() {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			// obtenemos la conexión
			conn = DriverManager.getConnection(url, login, password);
			if (conn != null) {
				System.out.println("Conexión a base de datos " + bd + " OK");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Permite retornar la conexión */
	public Connection getConnection() {
		return conn;
	}

	public void desconectar() {
		conn = null;
	}
}
