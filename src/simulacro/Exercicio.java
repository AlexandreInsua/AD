package simulacro;

import java.sql.*;

public class Exercicio {

	public static void main(String[] args) {
		Connection conexion = null;
	String url = "jdbc:hsqldb:file:C:\\Users\\Alexandre\\Documents\\WorkspaceEspace\\AccesoADatos\\HSQLDB\\coches, \"SA\", \"SA\""; 

		try {
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			conexion = DriverManager.getConnection(url);
			System.out.println("Con est");
					
					Statement stm = conexion.createStatement();
			
			ResultSet result = stm.executeQuery("Select * from cliente");
			
			while (result.next()){
				System.out.println(result.getInt(1));
			}
			
			conexion.close();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally  {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
