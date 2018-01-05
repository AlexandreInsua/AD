package ud02;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Exemplo que actualiza o salario dun departamento que se lle pasa como variable
 * non preparada
 */
public class Exemplo09_sentenzas_manipulacion_dato_modificacion {

	public static void main(String[] args) {

		// Configurar parmetros de conexion
		java.sql.Connection conexion = null;
		String user = "SegundoDAM";

		String password = "randulfolupe";
		String url = "jdbc:mysql://localhost:3306/ud02bd01empleados";

		// Datos para actualizar
		String codigo = "10";
		String subida = "100";
		try {
			// Codigo para cargar o driver 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// construimos a orde UPDATE
			String sql = "UPDATE Empleados SET salario = salario 	+" + subida + " WHERE CodDepartamento = " + codigo;
			System.out.println(sql);
			// Preparamosla consulta
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.println("Filas modificadas: " + filas);
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
}// fin clase
