package ud02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Exemplo que executa o procedemento PrsubidaSal que ten dous par�metros na BD
 */
public class Exemplo11_procedementos_almacenados {

	public static void main(String[] args) throws IOException {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		String depar = null;
		String subida = null;
		try {
			// O m�todo pode lanzar a excepci�n IOException
			depar = IntroducirDatos("Introduza o c�digo de departamento: ");
			subida = IntroducirDatos("Introduce o aumento do salario: ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Cargar o Driver da BD
			Class.forName(driver).newInstance();
			// Establecemos a conexi�n
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Construimos a orden de chamada
			// NB.- A sintaxe da chamada do procedemento almacenado
			String sql = "{CALL PrSubidaSal (?, ?)}";
			// Preparamos a chamada ao procedemento
			CallableStatement chamada = conexion.prepareCall(sql);

			// Damos valor aos argumentos
			chamada.setInt(1, Integer.parseInt(depar));
			chamada.setInt(2, Integer.parseInt(subida));
			// ejecutamos el procedimiento
			chamada.execute();
			System.out.println("Suba de salario realizada.....");
			// liberar recursos
			chamada.close();
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			System.out.println("Error: " + cnf.getMessage());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (InstantiationException ie) {
			System.out.println("Error: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error: " + iae.getMessage());
		}
	}// fin main

	// M�todo para introducir datos desde o teclado
	public static String IntroducirDatos(final String cad) throws IOException {
		// Introducindo unha cadea de caracteres
		String cadena = null;
		// 1�. Crea un obxecto InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in);
		// 2�. Crea un obxecto BufferedReader
		BufferedReader br = new BufferedReader(isr);
		System.out.println(cad);
		return br.readLine();

	}// fin introducirDatos()
}// fin clase