package ud02;

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
		// Configurar os par�metros da conexi�n
		// Connection crea unha conexi�n cunha base de datos
		Connection connection = null;
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "SegundoDAM";
		// Direcci�n da base de datos
		// conector, bd, host, porto, uri
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		try {
			// C�digo para carga o Driver da base de datos do conector MySQL 6
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Establecemos a conexi�n
			// DriverManager: o servi<o b�sico para a xesti�n dun conxunto de
			// controladores JDBC.
			// enderezo, usuario e contrasinal
			connection = DriverManager.getConnection(url, user, password);

			// TODO
			System.err.println("Conexi�n establecida");

			// Preparamos a consulta
			// Establecemos a declaraci�n 
			Statement instructionSQL = connection.createStatement();
			// Cando a declaraci�n executa unha Consulta devolve un conxunto de resultados
			ResultSet result = instructionSQL.executeQuery("SELECT DepNome, localidade FROM Departamentos");

			// Percorremos o resultado da consulta visualizando os rexistros
			// mentres houber resultado seguinte...
			while (result.next()) {
				// ... imprime por consola
				System.out.println(result.getString("Depnome") + "\t" + result.getString("Localidade"));
			} // fin while

			// Liberar recursos
			result.close();
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
