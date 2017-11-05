package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

/*
 * O seguinte exemplo conecta coa base de datos MySQL do exemplo e mostra a informaci�n sobre a bd, a url para acceder, o nome de usuario e as t�boas e vistas dos esqumema.
 */

public class Exemplo07_sentenzas_descricion_datos {

	public static void main(String[] args) {
		Connection conexion = null;
		
		// Usuario
		String user = "SegundoDAM";
		// Password
		String password = "SegundoDAM";
		// Direcci�n da base de datos
		// conector, bd, host, porto, uri
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
			try {
			// Cargar o driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Establecer a conexi�n
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexi�n establecida con �xito");
			// Creamos o obxecto DatabaseMetaData
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet result = null;
			// Recuperamos a informaci�n da base de datos
			String name = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String driverVersion = dbmd.getDriverVersion();
			String url1 = dbmd.getURL();
			String user1 = dbmd.getUserName();
			System.out.println("Informaci�n sobre a base de datos");
			System.out.println("----------------------------------");
			System.out.println("Nome da base de datos: " + name);
			System.out.println("Driver: " + driver + " " + driverVersion);
			System.out.println("URL: " + url1);
			System.out.println("Usuario: " + user1);

			// Obter informaici�n das t�boas e vistas da bd
			// O m�todo getTables() devolve un ResultSet e necesita como par�metros o cat�logo da bd, o esquema, o nome das taboas e o tipo que pode ser TABLE ou VIEW
			result = dbmd.getTables(null, "ud0201Empregado", null, null);
			// Obter informaci�n dunha t�boa determinada
			// result = dbmd.getTables(null, "ud0201Empregado", "nome da t�boa",
			// null);
			while (result.next()) {
				String catalogo = result.getString(1);
				String esquema = result.getString(2);
				String taboa = result.getString(3);
				String tipo = result.getString(4);
				System.out.println(tipo + " - Cat�logo: " + catalogo + " Esquema: " + esquema + " Nome: " + taboa);
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
}
