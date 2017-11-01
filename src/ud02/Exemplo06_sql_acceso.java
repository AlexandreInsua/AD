package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Mostra o funcionamento de JDBC accedendo � base de datos
 */
public class Exemplo06_sql_acceso {
	public static void main(String[] args) {
		// 1� Configurar par�metros de conexion
		// Connection crea unha conexi�n cunha base de datos
		Connection conexion = null;
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "SegundoDAM";
		// Localizaci�n (no localhost)
		String url = "jdbc:mysql://localhost:3306/UD02BD01Empregados?serverTimezone=Europe/Madrid";

		try {
			// Codigo para cargar el Driver de la Base de Datos Conector MySQL 6
			// 			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Codigo para cargar el Driver de la Base de Datos Conector MySQL 5
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establecemos la conexi�n
			// DriverManger El servicio b�sico para la gesti�n de un conjunto de
			// controladores JDBC.
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Preparamos la consulta
			Statement instruccionSQL = conexion.createStatement();
			ResultSet result = instruccionSQL.executeQuery("SELECT DepNome, Localidade FROM Departamentos");
			// Recorremos el resultado de la consulta visualizando los registros
			while (result.next()) {
				// System.out.println(result.getInt(1) +"\t"
				// +result.getString(2) +"\t"
				// +result.getString(3));
				// //System.out.println(result.getString(1) +"\t"
				// +result.getString(2));
				System.out.println(result.getString("DepNome") + "\t" + result.getString("Localidade"));
			} // fin while
				// Liberar recursos
			result.close(); // cerrar ResultSet
			instruccionSQL.close();// cerrar Statement
			conexion.close();// cerrar conexi�n
		} catch (ClassNotFoundException cnf) {
			System.out.println("Clase");
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			System.out.println("Sql");
			sqle.printStackTrace();
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}
	}
}
