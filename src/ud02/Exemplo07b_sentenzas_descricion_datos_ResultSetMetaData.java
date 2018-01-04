package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * O seguinte exemplo conecta coa base da datos MySQL de nome 
	UD02BD01Empregados e executa unha sentenza SELECT e dev�lvenos a informaci�n sobre as columnas devoltas

	*/
public class Exemplo07b_sentenzas_descricion_datos_ResultSetMetaData {

	public static void main(String[] args) {
		// Configurar parametros de conexion
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "randulfolupe";
		String url = "jdbc:mysql://localhost:3306/UD02BD01Empregados?serverTimezone=Europe/Madrid";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexi�n establecida");
			Statement instruccionSQL = conexion.createStatement();
			ResultSet result = instruccionSQL.executeQuery("SELECT * FROM Departamentos");
			ResultSetMetaData rsmd = result.getMetaData();

			// Recuperamos o n�mero de columnas
			int numCol = rsmd.getColumnCount();

			// prepara a visualizaci�n de isNullable()
			String nula;

			System.out.println("N�mero de columnas recuperadas: 	" + numCol);
			System.out.println("Columna" + "\tNombre" + "\t\tTipo" + "\tNula" + "\tAncho M�ximo");
			for (int i = 1; i <= numCol; i++) {

				if (rsmd.isNullable(i) == 0)
					nula = "No";
				else
					nula = "Si";

				// Mostra os resultados, nome, tipo nula, ancho m�ximo
				System.out.println(i + "\t" + rsmd.getColumnName(i) + "\t\t" + rsmd.getColumnType(i) + "\t" + nula
						+ "\t" + rsmd.getColumnDisplaySize(i));
				
				
				
			}
			conexion.close();
			System.err.println("CERRANDO CONEXI�N A BD");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
