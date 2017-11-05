package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Crea unha vista (Totais) que contén cada departamento, o código, o nome, o número de empregados e a suma de salarios.
 */
public class Exemplo09_crea_vista {
	public static void main(String[] args) {
		// Parámetros da conexión

		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		try {
			// cargar o Driver
			Class.forName(driver).newInstance();
			// Establecemos a conexion
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("CONEXIÓN ESTABLECIDA CON ÉXITO");
			String sql = "CREATE OR REPLACE VIEW 	Totais (CodDep, NmDpar, NumEmp, TotSal) AS SELECT CodDepartamento, "
					+ "DepNome, COUNT(CodEmpregado), SUM(salario) FROM Departamentos JOIN Empregados USING (CodDepartamento)"
					+ "GROUP By CodDepartamento ";
			System.out.println(sql);
			// Creamos a sentenza
			Statement sentenza = conexion.createStatement();
			int filas = sentenza.executeUpdate(sql);
			System.out.println("Filas modificadas: " + filas);
			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// fin main
}// fin clase