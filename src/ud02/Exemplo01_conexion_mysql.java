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
 * Exemplo que mostra o funcionamento de JDBC que accede á base de datos ud02bd01Empregados
 */
public class Exemplo01_conexion_mysql {
	public static void main(String[] args) {
		// CONFIGURAR OS PARÁMETROS DA CONEXIÓN 
		// Connection crea unha conexión cunha base de datos
		Connection connection = null;
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "randulfolupe";
		// Dirección da base de datos
		// conector, bd, host, porto, uri
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		// Driver
		String driver = "com.mysql.jdbc.Driver";
		
		
		try {
			// 2.- CARGAR O DRIVER
			// Código para carga o Driver da base de datos do conector MySQL 6
			// Recibe o driver 
			Class.forName(driver).newInstance();

			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PARÁMETROS DE CONEXIÓN
			// Establecemos a conexión

			// 4.- CREAR A CONEXIÓN
			// Úsase a clase DriverManager (o servizo básico para a xestión
			// dun conxunto de controladores JDBC)
			// que recibe como parámetros url, usuario e contrasinal
			connection = DriverManager.getConnection(url, user, password);

			// Isto só se debería usar para os erros, pero queda bonito
			System.err.println("Conexión establecida");

			// 5.- CREAR A SENTENZA 
			// Chámase o método createStatement() da clase Statement 
			Statement instructionSQL = connection.createStatement();
			
			
			// 6.- EXECÚTASE A SENTENZA
			// Chámase o método executeQuey da clase Statement
			// e devolve un conxunto de resultados
			ResultSet resultado = instructionSQL.executeQuery("SELECT DepNome, localidade FROM Departamentos");

			// 7.- RECUPERAR OS DATOS DO RESULTSET
			// Percorremos o resultado da consulta visualizando os rexistros
			// usase o metodo next() de ResulSet
			// mentres houber resultado seguinte...
			while (resultado.next()) {
				// ... imprime por consola
				System.out.println(resultado.getString("Depnome") + "\t" + resultado.getString("Localidade"));
			} // fin while

			// 8.- LIBERAR RECURSOS
			// ResultSet, Statement, Connection
			resultado.close(); 
			instructionSQL.close();
			connection.close();
			// Lanzada por forName()
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
