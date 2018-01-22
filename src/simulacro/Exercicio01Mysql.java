package simulacro;

import java.sql.*;

public class Exercicio01Mysql {
	public static void main(String[] args) {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		String url = "jdbc:mysql://localhost:3306/bd01alquilervehiculos?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver).newInstance();

			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexión con éxito");

			Statement sentenza = conexion.createStatement();
			String sql = "select ofOficina, veMatricula, veMarca, veModelo, fuAnhosAntiguedad(veMatricula) , vePrecio, "
					+ "if(fuAnhosAntiguedad(veMatricula)>3,0.10,0), veDisponible from vehiculo join oficina on veCodOficina = ofOficina WHERE veDisponible = true";

			ResultSet r = sentenza.executeQuery(sql);

			while (r.next()) {
				System.out.println(r.getString("ofOficina") + "\t" + r.getString("veMatricula") + "\t"
						+ r.getString("veMarca") + "\t" + r.getString("veModelo") + "\t"
						+ r.getInt("fuAnhosAntiguedad(veMatricula)") + "\t" + r.getDouble("vePrecio") + "\t"
						+ r.getInt("if(fuAnhosAntiguedad(veMatricula)>3,0.10,0)") + "\t"
						+ r.getBoolean("veDisponible"));
			}
			conexion.close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
