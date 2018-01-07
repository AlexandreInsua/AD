package ud02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * O PROCEDEMENTO ESTÁ CARGADO NA BASE DE DATOS
 * Exemplo que executa o procedemento PrsubidaSal que ten dous parámetros na BD
 * 
 delimiter $
CREATE PROCEDURE PrSubidaSal (cod INT, subida INT)
BEGIN
UPDATE Empleados SET Salario = Salario + subida WHERE
CodDepartamento = cod;
END $
delimiter ;
 */
public class Exemplo11_procedementos_almacenados_execucion {

	public static void main(String[] args) throws IOException {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "randulfolupe";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		String depar = null;
		String subida = null;
		try {
			// O método pode lanzar a excepción IOException
			// AQUÍ RECIBE OS PARÁMETROS QUE LLE VAI PASAR AO PROCEDEMENTO
			depar = IntroducirDatos("Introduza o código de departamento: ");
			subida = IntroducirDatos("Introduce o aumento do salario: ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Cargar o Driver da BD
			Class.forName(driver).newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Construimos a orden de chamada
			// NB.- A sintaxe da chamada do procedemento almacenado
			String sql = "{CALL PrSubidaSal (?, ?)}";
			// Preparamos a chamada ao procedemento
			CallableStatement chamada = conexion.prepareCall(sql);

			// Dámoslle valor aos argumentos
			chamada.setInt(1, Integer.parseInt(depar));
			chamada.setInt(2, Integer.parseInt(subida));
			// executamos o procedemento
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
