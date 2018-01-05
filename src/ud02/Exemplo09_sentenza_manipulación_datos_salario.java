package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Exemplo que actualiza rexistros da base de datos dun departamento 
 * Sentenza non preparada
 */
public class Exemplo09_sentenza_manipulación_datos_salario {

	public static void main(String[] args) {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		// Datos para actualizar
		String codigo = "10";
		String suba = "100";

		try {
			// Cargar o Driver
			Class.forName(driver).newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Construimos a sentenza UPDATE
			// usa sentenza
			String sql = "UPDATE Empregados SET salario = salario +" + suba + " WHERE CodDepartamento = " + codigo;
			System.out.println(sql);
			// Preparamos a consulta
			Statement sentencia = conexion.createStatement();
			// Control: devolve o número de filas modificadas
			int filas = sentencia.executeUpdate(sql);
			System.out.println("Filas modificadas: " + filas);
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
}// fin clase
