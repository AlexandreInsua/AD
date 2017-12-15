package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Insire rexistros na base de datos usando a clase PreparedStatement
 * Crea un departamento
 */
public class Exemplo10_sentenzas_preparadas_inserta_departamento
{
	public static void main(String[] args) {

		// Configuración da conexión:
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		try {
			// Cargar driver
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("CONEXIÓN ESTABLECIDA CON ÉXITO");

			// Crear a sentenza SQL
			// A interrogación deixa pendente os parámetro
			String sql = "INSERT INTO Departamentos VALUES (?,?,?)";

			// Çonstruimos a PreparedStatement cos índices
			// Sentenza
			PreparedStatement sentenza = conexion.prepareStatement(sql);
			// Construímos os índices e os seus valores
			sentenza.setInt(1, 55);
			sentenza.setString(2, "Produción");
			sentenza.setString(3, "Lugo");

			// Executamso a sentenza
			int filas = sentenza.executeUpdate();
			System.out.println("Filas afectadas: " + filas);
			conexion.close();

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
}// fin clase
