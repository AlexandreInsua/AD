package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exemplo02_conexion_sqlite {
	public static void main(String[] args) {
		// Preparar a conexión
		Connection conection = null;
		String url = "jdbc:sqlite:C:/Users/Alexandre/Documents/DAM/sqlite/exemplo.db";

		// Prepararmos a declaración
		Statement statement = null;
		ResultSet result = null;

		try {
			// Cargamos o driver
			Class.forName("org.sqlite.JDBC").newInstance();
			// Establecemos a conexión
			conection = DriverManager.getConnection(url);
			// Preparamos a consulta
			statement = conection.createStatement();
			// gardamos o resultado
			result = statement.executeQuery("SELECT * FROM Departamentos");
			// Bucle para percorrer a consulta
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getInt(2) + "\t" + result.getInt(3));
			} // Fin do while

			// Liberarmos recursos
			result.close();
			statement.close();
			conection.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
