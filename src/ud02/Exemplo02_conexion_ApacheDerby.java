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

public class Exemplo02_conexion_ApacheDerby {
	public static void main(String[] args) {
		// Configurar parametros de conexion
		Connection conexion = null;
		String url = "jdbc:derby:C:\\Users\\Alexandre\\Documents\\DAM\\derby\\db\\EjemploDerby";
		Statement stm = null;
		ResultSet result = null;
		try {
			// 2.- CARGAR O DRIVER
			// Codigo para cargar el Driver de la Base de Datos
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();

			// 3.- IDENTIFICAR A ORIXE DOS DATOS : PAR�METROS DE CONEXI�N
			// Establecemos la conexi�n
			
			// 4.- CREAR A CONEXI�N
			// �sase a clase DriverManager (o servizo b�sico para a xesti�n
			// dun conxunto de controladores JDBC)
			// que recibe como par�metro a url
			conexion = DriverManager.getConnection(url);
			System.err.println("Conexion establecida");

			// 5.- CREAR A SENTENZA 
			// Ch�mase o m�todo createStatement() da clase Statement 
			stm = conexion.createStatement();
			
			// 6.- EXEC�TASE A SENTENZA
			// Ch�mase o m�todo executeQuey da clase Statement
			// e devolve un conxunto de resultado
			result = stm.executeQuery("SELECT * FROM Departamentos");
			System.out.println("Listado Apache Derby");
			
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
	}// fin main
}
