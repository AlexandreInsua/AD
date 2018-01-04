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
 * Mostra o funcionamento de JDBC accedendo � base de datos
 */
public class Exemplo06_sql_acceso {
	public static void main(String[] args) {
		
		// CONFIGURAR OS PAR�METROS DA CONEXI�N 
		// Connection crea unha conexi�n cunha base de datos
		Connection conexion = null;
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "randulfolupe";
		// Localizaci�n (no localhost)
		String url = "jdbc:mysql://localhost:3306/UD02BD01Empregados?serverTimezone=Europe/Madrid";

		try {
			
			// 2.- CARGAR O DRIVER
			// Codigo para cargar el Driver de la Base de Datos Conector MySQL 6
			// Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Codigo para cargar el Driver de la Base de Datos Conector MySQL 5
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PAR�METROS DE CONEXI�N
			// Establecemos a conexi�n

			// 4.- CREAR A CONEXI�N
			// �sase a clase DriverManager (o servizo b�sico para a xesti�n
			// dun conxunto de controladores JDBC)
			// que recibe como par�metros url, usuario e contrasinal
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");

			// 5.- CREAR A SENTENZA 
			// Ch�mase o m�todo createStatement() da clase Statement 
			Statement instruccionSQL = conexion.createStatement();
			
			// 6.- EXEC�TASE A SENTENZA
			// Ch�mase o m�todo executeQuey da clase Statement
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
