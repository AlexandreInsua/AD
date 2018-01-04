package ud02;

/*
 * ORDE DE TRABALLOS
 */

// 1.- IMPORTAR CLASES

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Mostra o funcionamento de JDBC accedendo á base de datos
 */
public class Exemplo06_sql_acceso {
	public static void main(String[] args) {
		
		// CONFIGURAR OS PARÁMETROS DA CONEXIÓN 
		// Connection crea unha conexión cunha base de datos
		Connection conexion = null;
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "randulfolupe";
		// Localización (no localhost)
		String url = "jdbc:mysql://localhost:3306/UD02BD01Empregados?serverTimezone=Europe/Madrid";

		try {
			
			// 2.- CARGAR O DRIVER
			// Codigo para cargar el Driver de la Base de Datos Conector MySQL 6
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Codigo para cargar el Driver de la Base de Datos Conector MySQL 5
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PARÁMETROS DE CONEXIÓN
			// Establecemos a conexión

			// 4.- CREAR A CONEXIÓN
			// Úsase a clase DriverManager (o servizo básico para a xestión
			// dun conxunto de controladores JDBC)
			// que recibe como parámetros url, usuario e contrasinal
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");

			// 5.- CREAR A SENTENZA 
			// Chámase o método createStatement() da clase Statement 
			Statement instruccionSQL = conexion.createStatement();
			
			// 6.- EXECÚTASE A SENTENZA
			// Chámase o método executeQuey da clase Statement
			// e devolve un conxunto de resultados
			ResultSet result = instruccionSQL.executeQuery("SELECT DepNome, Localidade FROM Departamentos");

			// 7.- RECUPERAR OS DATOS DO RESULTSET
			// Percorremos o resultado da consulta visualizando os rexistros
			// usase o metodo next() de ResulSet
			// mentres houber resultado seguinte...
			while (result.next()) {
				System.out.println(result.getString(1) + "\t" + result.getString(2));

				System.out.println(result.getString("DepNome") + "\t" + result.getString("Localidade"));
			} // fin while

			// 8.- LIBERAR RECURSOS
			// ResultSet, Statement, Connection
			result.close(); 
			instruccionSQL.close();
			conexion.close();
			
		} catch (ClassNotFoundException cnf) { // Lanzada por Class.forName(driver).getConnection(url, user, password);
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
