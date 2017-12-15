package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Actualiza o salario dos traballadores dun departamento
 */
public class Exemplo10_sentenzas_preparadas_modifica_salario {
	public static void main(String[] args) {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		// Datos para actualizar
		int codigo = 10; // Codigo de departamento 
		int suba = 155; // Cantidade a subir 

		try {
			// Cargar o Driver
			Class.forName(driver).newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Construimos a sentenza UPDATE
			// repara como se contrúe a sentenza
			String sql = "UPDATE Empregados SET salario = salario + ? WHERE CodDepartamento = ?";
			System.out.println(sql);
			// Preparamos a consulta
			PreparedStatement sentenza = conexion.prepareStatement(sql);
			// pasamos os valores (dá igual a orde)
			// o primeiro parámetro é a orde de ?
			sentenza.setInt(2, codigo);
			sentenza.setInt(1, suba);

			// Control
			int filas = sentenza.executeUpdate();
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
