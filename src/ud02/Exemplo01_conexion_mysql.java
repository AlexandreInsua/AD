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
 * Exemplo que mostra o funcionamento de JDBC que accede � base de datos ud02bd01Empregados
 */
public class Exemplo01_conexion_mysql {
	public static void main(String[] args) {
		// CONFIGURAR OS PAR�METROS DA CONEXI�N 
		// Connection crea unha conexi�n cunha base de datos
		Connection connection = null;
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "randulfolupe";
		// Direcci�n da base de datos
		// conector, bd, host, porto, uri
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		// Driver
		String driver = "com.mysql.jdbc.Driver";
		
		
		try {
			// 2.- CARGAR O DRIVER
			// C�digo para carga o Driver da base de datos do conector MySQL 6
			// Recibe o driver 
			Class.forName(driver).newInstance();

			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PAR�METROS DE CONEXI�N
			// Establecemos a conexi�n

			// 4.- CREAR A CONEXI�N
			// �sase a clase DriverManager (o servizo b�sico para a xesti�n
			// dun conxunto de controladores JDBC)
			// que recibe como par�metros url, usuario e contrasinal
			connection = DriverManager.getConnection(url, user, password);

			// Isto s� se deber�a usar para os erros, pero queda bonito
			System.err.println("Conexi�n establecida");

			// 5.- CREAR A SENTENZA 
			// Ch�mase o m�todo createStatement() da clase Statement 
			Statement instructionSQL = connection.createStatement();
			
			
			// 6.- EXEC�TASE A SENTENZA
			// Ch�mase o m�todo executeQuey da clase Statement
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
