package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplo02_conexion_ApacheDerby {
	public static void main(String[] args) {
		// Configurar parametros de conexion
		Connection conexion = null;
		String url = "jdbc:derby:C:\\Users\\Alexandre\\Documents\\DAM\\derby\\db\\EjemploDerby";
		Statement stm = null;
		ResultSet result = null;
		try {
			// Codigo para cargar el Driver de la Base de Datos
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			// Establecemos la conexión
			conexion = DriverManager.getConnection(url);
			System.err.println("Conexion establecida");
			// Preparamos la consulta
			stm = conexion.createStatement();
			result = stm.executeQuery("SELECT * FROM Departamentos");
			System.out.println("Listado Apache Derby");
			// Recorremos el resultado de la consulta visualizando los registros
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
			} // fin while
			result.close();
			stm.close();
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
}
