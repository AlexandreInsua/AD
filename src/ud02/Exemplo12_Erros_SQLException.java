package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplo12_Erros_SQLException {
	/*
	 * Ejemplo que produce un erro porque a táboa non existe na bd lanza a
	 * excepción SQLException
	 */

	public static void main(String[] args) {
		// Configurar parametros de conexion
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		// Dá acceso aos procedementos
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid&noAccessToProcedureBodies=true";
		String driver = "com.mysql.jdbc.Driver";

		try {
			// Codigo para cargar o Driver da BDatos
			Class.forName(driver).newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Preparamos a consulta
			Statement instruccionSQL = conexion.createStatement();
			ResultSet result = instruccionSQL.executeQuery("SELECT * FROM Departamentas");
			// Percorremos o resultado da consulta visualizando os rexistros
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
			} // fin while
			result.close();
			instruccionSQL.close();
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			// sqle.printStackTrace();
			System.out.println("OCORREU UN ERRO");
			System.out.println("Mensaxe: " + sqle.getMessage());
			System.out.println("SQL estado: " + sqle.getSQLState());
			System.out.println("Cod. error: " + sqle.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
} // fin clase
