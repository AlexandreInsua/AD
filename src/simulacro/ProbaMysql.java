package simulacro;


import java.sql.*;

public class ProbaMysql {
	public static void main(String[] args) {
	Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		// Dirección da base de datos
		// conector, bd, host, porto, uri
		String url = "jdbc:mysql://localhost:3306/numeros?serverTimezone=Europe/Madrid";
		// Driver
		String driver = "com.mysql.jdbc.Driver";
		
		
		try {
			Class.forName(driver).newInstance();

			conexion = DriverManager.getConnection(url, user, password);

			System.err.println("Conexión establecida");

			// 5.- CREAR A SENTENZA 
			// Chámase o método createStatement() da clase Statement 
			/*Statement instructionSQL = conexion.createStatement();
			
			
			ResultSet resultado = instructionSQL.executeQuery("SELECT DepNome, localidade FROM Departamentos");
			while (resultado.next()) {
				System.out.println(resultado.getString("Depnome") + "\t" + resultado.getString("Localidade"));
			}*/ // fin while

			//resultado.close(); 
			//instructionSQL.close();
			conexion.close();
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
