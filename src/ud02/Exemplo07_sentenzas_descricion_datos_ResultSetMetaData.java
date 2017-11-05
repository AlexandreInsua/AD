package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * O seguinte exemplo conecta coa base da datos MySQL de nome 
	UD02BD01Empregados e executa unha sentenza SELECT e devólvenos a información sobre as columnas devoltas

	*/
public class Exemplo07_sentenzas_descricion_datos_ResultSetMetaData {

	public static void main(String[] args) {
		// Configurar parametros de conexion
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/UD02BD01Empregados?serverTimezone=Europe/Madrid";
		try {
			// Codigo para cargar el Driver de la Base de Datos
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establecemos a conexión
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Preparamos a consulta
			Statement instruccionSQL = conexion.createStatement();
			ResultSet result = instruccionSQL.executeQuery("SELECT * FROM Departamentos");
			ResultSetMetaData rsmd = result.getMetaData();
			int numCol = rsmd.getColumnCount();
			String nula;
			System.out.println("Número de columnas recuperadas: 	" + numCol);
			for (int i = 1; i <= numCol; i++) {
				System.out.println("Columna: " + i);
				System.out.println("Nombre: " + rsmd.getColumnName(i));
				System.out.println("Tipo: " + rsmd.getColumnType(i));
				if (rsmd.isNullable(i) == 0)
					nula = "No";
				else
					nula = "Si";
				System.out.println("¿Puede ser nula?: " + nula);
				System.out.println("Máximo ancho de la columna: 	" + rsmd.getColumnDisplaySize(i));
			}
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
