package ud02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exemplo10_sentenzas_preparadas_posto_concreto {
	public static void main(String[] args) throws IOException {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";
		String depar = null;
		String oficio = null;
		// MÉTODO PARA INTRODUCIR DATOS
		// Como lanza una posible excepción hai que engadir a throws IOException
		depar = IntroducirDatos("Introducir o departamento: ");
		oficio = IntroducirDatos("Introducir o posto de traballo: ");
		try {
			// Codigo para cargar o Driver da BD
			Class.forName(driver).newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Construimos a orden UPDATE
			String sql = "SELECT Nome, Salario FROM Empregados	WHERE CodDepartamento = ? AND" + " Posto = ?";
			System.out.println(sql);
			// Preparamos o PreparedStatement
			PreparedStatement sentenza = conexion.prepareStatement(sql);
			// Pasamos os valores
			sentenza.setInt(1, Integer.parseInt(depar));
			sentenza.setString(2, oficio);
			// Preparamos el ResultSet
			ResultSet result = sentenza.executeQuery();
			// Percorremos as filas obtenidas
			while (result.next()) {
				System.out.println(result.getString(1) + "\t" + result.getFloat(2));
			}
			result.close();
			sentenza.close();
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main

	// Método para introducir datos desde o teclado

	public static String IntroducirDatos(final String cad) throws IOException {
		// Introducindo unha cadea de caracteres
		String cadena = null;
		// 1º. Crea un obxecto InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in);
		// 2º. Crea un obxecto BufferedReader
		BufferedReader br = new BufferedReader(isr);
		System.out.println(cad);
		return br.readLine();
	}// fin introducirDatos()
}// fin clase