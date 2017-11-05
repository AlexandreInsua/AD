package ud02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Utilizamos os m�todos do obxecto Statement:
 * executeQuery(SELECT)
 * executeUpdate(INSERT, UPDATE, DELETE)
 * execute( procedementos almacenados )
 */

/*
 * O seguinte exemplo insire un departamento na exemplo 
 */
public class Exemplo08_sentanzas_manipulacion_datos {

	public static void main(String[] args) {
		
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";
		
		// datos para inserir
		String codigo = "50";
		String nome = "I+D";
		String localidade = "Redondela";
		try{
			// C�digo para cargar o Driver da bd
			Class.forName(driver).newInstance();
			// Establecemos a conexi�n
			conexion = DriverManager.getConnection(url,user, password);
			// Contruipmos a sentenza
			// � importante coidar onde van as comi�as simples '' !!!
			String sql = "INSERT INTO departamentos VALUES ('"+codigo+"','"+
			nome +"','"+ localidade+"');";
			
			System.out.println(sql);
			// preparamos a consulta
			Statement sentenza = conexion.createStatement();
			
			// Executamos a sentenza
			int filas = sentenza.executeUpdate(sql);
			System.out.println("filas insertadas: " + filas);
			// cerramos a conexi�n
			conexion.close();
		}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}catch(SQLException sqle){
		sqle.printStackTrace();
		}catch(Exception e){
		e.printStackTrace();
		}
	
	}
}
