package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Exemplo de execución dunha función de usuario mysql desde un programa java.
 * Executa a funcion FuAnhosTrabajados da bd.
 * A función calcula o número dos anos traballdos na empresa dun determinado traballador,
 * cuxo código é pasado como parámetro á función que se executa na sentenza SELECT 
 */
public class Exemplo11_procedementos_chamada_desde_sentenza {
	public static void main(String[] args) {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		// Dá acceso aos procedementos
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid&noAccessToProcedureBodies=true";
		String driver = "com.mysql.jdbc.Driver";

		PreparedStatement pstm = null;

		// En condicións normais, teríamos un conxunto de resultados
		ResultSet result = null;

		try {
			// Codigo para cargar o driver
			Class.forName(driver).newInstance();

			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");

			// sentenza en SQL podería ser
			// SELECT Empleados.nombre, FuAnhoTrabajo(CodEmpregado) FROM
			// empregados ;
			// creamos a sentencia SQL
			String sql = "SELECT Empregados.nome, FuAnhoTrabajo(CodEmpregado) FROM empregados ;";

			// Construimos o PreparedStatement
			pstm = conexion.prepareStatement(sql);

			// Creamos o resultado da consulta
			result = pstm.executeQuery();
			
			// Percorremos o resultado da consulta visualizando os rexistros

			while (result.next()) {
				System.out.println(result.getString("Nome") + "\t" + result.getInt(2));
			} // fin while
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} // fin main