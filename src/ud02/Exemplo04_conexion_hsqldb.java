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
 * Exemplo que mostra o funcionamento de conexion a unha base de datos HSQLDB.
 * A bd creada é exemploHSQLDB
 */

public class Exemplo04_conexion_hsqldb {
	public static void main(String[] args) {

		// Configurar parametros de conexion, usuario e password.
		// (Bea non estable usuario e password para facilitarnos a vida)
		Connection conexion = null;
		String url = "jdbc:hsqldb:file:C:\\Users\\Alexandre\\Documents\\DAM\\hsqldb\\data\\exemplo, \"segundodam\", \"segundodam\"";
		Statement stm = null;
		ResultSet result = null;

		try {
			// 2.- CARGAR O DRIVER
			// Codigo para cargar el Driver de la Base de Datos
			Class.forName("org.hsqldb.jdbcDriver").newInstance();

			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PARÁMETROS DE CONEXIÓN
			// Establecemos la conexión

			// 4.- CREAR A CONEXIÓN
			// Úsase a clase DriverManager (o servizo básico para a xestión
			// dun conxunto de controladores JDBC)
			// que recibe como parámetros url, usuario e contrasinal
			conexion = DriverManager.getConnection(url);
			System.err.println("Conexion establecida");

			// 5.- CREAR A SENTENZA
			// Chámase o método createStatement() da clase Statement
			stm = conexion.createStatement();

			// 6.- EXECÚTASE A SENTENZA
			// Chámase o método executeQuey da clase Statement
			// e devolve un conxunto de resultado
			result = stm.executeQuery("SELECT * FROM Departamentos");
			System.out.println("Listado HSQLDB");
			
			// 7.- RECUPERAR OS DATOS DO RESULTSET
			// Percorremos o resultado da consulta visualizando os rexistros
			// usase o metodo next() de ResulSet
			// mentres houber resultado seguinte...
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
			} // fin while
			
			// 8.- LIBERAR RECURSOS
			// ResultSet, Statement, Connection
			result.close();
			stm.close();
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
