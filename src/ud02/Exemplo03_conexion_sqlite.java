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

public class Exemplo03_conexion_sqlite {
	public static void main(String[] args) {
		// Preparar a conexi�n
		Connection conection = null;
		String url = "jdbc:sqlite:C:/Users/Alexandre/Documents/DAM/sqlite/exemplo.db";

		// Prepararmos a declaraci�n
		Statement statement = null;
		ResultSet resultado = null;

		try {
			// 2.- CARGAR O DRIVER
			// Cargamos o driver
			Class.forName("org.sqlite.JDBC").newInstance();

			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PAR�METROS DE CONEXI�N
			
			// 4.- CREAR A CONEXI�N
			// �sase a clase DriverManager (o servizo b�sico para a xesti�n
			// dun conxunto de controladores JDBC)
			// que recibe como par�metro a url
			// Establecemos a conexi�n
			conection = DriverManager.getConnection(url);

			// 5.- CREAR A SENTENZA 
			// Ch�mase o m�todo createStatement() da clase Statement 
			statement = conection.createStatement();

			// 6.- EXEC�TASE A SENTENZA
			// Ch�mase o m�todo executeQuey da clase Statement
			// e devolve un conxunto de resultado
			resultado = statement.executeQuery("SELECT * FROM Departamentos");
			
			// 7.- RECUPERAR OS DATOS DO RESULTSET
			// Percorremos o resultado da consulta visualizando os rexistros
			// usase o metodo next() de ResulSet
			// mentres houber resultado seguinte...
			while (resultado.next()) {
				System.out.println(resultado.getInt(1) + "\t" + resultado.getString(2) + "\t\t" + resultado.getString(3));
			} // Fin do while

			// 8.- LIBERAR RECURSOS
			// ResultSet, Statement, Connection
			resultado.close();
			statement.close();
			conection.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
