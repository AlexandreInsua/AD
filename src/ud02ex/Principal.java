package ud02ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	static String opcion = "0";

	public static void main(String[] args) throws IOException {

		System.err.println("CONSULTA DE BASE DE DATOS");

		opcion = introducirDatos(
				"Seleccione oparacion que desexa realizar\n1.- Introducir datos\n2.- Consultar datos\n0.- Saír");

		while (!opcion.equals("0")) {
			switch (opcion) {
			case "1":
				introducirDatosBD();
				break;
			case "2":
				consultarDatosBD();
				break;
			default:
				System.out.println("Debe introducir unha opción válida");
			}

			System.out.println("Programa finalizado");
		}
	}

	private static void introducirMysql() throws IOException {

		Connection conexionsql = null;
		String user = "SegundoDAM";
		String password = "randulfolupe";
		String url = "jdbc:mysql://localhost:3306/ud02bdmysql?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		System.out.println("INTRODUCIR DATOS MYSQL");
		opcion = introducirDatos(
				"Seleccione o dato que desexa introducir.\n1.- Produtos\n2.- Clientes\n3.- Ventas\n0.- Saír");

		while (!opcion.equals("0")) {
			switch (opcion) {
			case "1":
				while (!opcion.equals("0")) {
					System.out.println("Inserir producto");
					inserirProducto(conexionsql, user, password, url, driver);

					opcion = introducirDatos("Desexa introducir outro producto?\n1.- Si\n0.- Non");
				}
				break;
			case "2":
				while (!opcion.equals("0")) {
					System.out.println("Inserir Cliente");
					inserirClienteMySQL(conexionsql, user, password, url, driver);

					opcion = introducirDatos("Desexa introducir outro cliente?\n1.- Si\n0.- Non");
				}
				break;
			case "3":
				while (!opcion.equals("0")) {
					System.out.println("Inserir Venta");
					inserirVenta(conexionsql, user, password, url, driver);

					opcion = introducirDatos("Desexa introducir outra venta?\n1.- Si\n0.- Non");
				}
				break;
			default:
				System.out.println("Debe introducir unha opción válida");
			}

			opcion = introducirDatos("Desexa introducir máis datos?\n1.- Si\n0.- Non");
			if (opcion.equals("1")) {
				opcion = introducirDatos(
						"Seleccione o dato que desexa introducir.\n1.- Produtos\n2.- Clientes\n3.- Ventas\n0.- Saír");
			} else {
				System.out.println("Programa finalizado");
				System.exit(0);
			}
		}

	}

	private static void introducirSQLite() throws IOException {
		Connection conexionsql = null;
		String user = null;
		String password = null;
		String url = "jdbc:sqlite:dbExercicioTema2/UD02BDSQLite.db";
		String driver = "org.sqlite.JDBC";

		System.out.println("INTRODUCIR DATOS SQLite");
		opcion = introducirDatos(
				"Seleccione o dato que desexa introducir.\n1.- Produtos\n2.- Clientes\n3.- Ventas\n0.- Saír");

		while (!opcion.equals("0")) {	
			switch (opcion) {
			case "1":
				while (!opcion.equals("0")) {
					System.out.println("Inserir producto");
					inserirProducto(conexionsql, user, password, url, driver);

					opcion = introducirDatos("Desexa introducir outro producto?\n1.- Si\n0.- Non");
				}
				break;
			case "2":
				while (!opcion.equals("0")) {
					System.out.println("Inserir Cliente");
					inserirClienteSQLite(conexionsql, user, password, url, driver);

					opcion = introducirDatos("Desexa introducir outro cliente?\n1.- Si\n0.- Non");
				}
				break;
			case "3":
				while (!opcion.equals("0")) {
					System.out.println("Inserir Venta");
					inserirVenta(conexionsql, user, password, url, driver);

					opcion = introducirDatos("Desexa introducir outro cliente?\n1.- Si\n0.- Non");
				}
				break;
			default:
				System.out.println("Debe introducir unha opción válida");
			}

			opcion = introducirDatos("Desexa introducir máis datos?\n1.- Si\n2.- Non");
			if (opcion.equals("1")) {
				opcion = introducirDatos(
						"Seleccione o dato que desexa introducir.\n1.- Produtos\n2.- Clientes\n3.- Ventas\n0.- Saír");
			} else {
				System.out.println("Programa finalizado");
				System.exit(0);
			}
		}

	}

	private static void introducirDatosBD() throws IOException {
		System.out.println("INTRODUCIÓN DE DATOS");
		opcion = introducirDatos(
				"Seleccione a base de datos onde desexa introducir os datos.\n1.- MySQL\n2.- SQLite\n3.- Apache Derby\n0.- Saír");

		while (!opcion.equals("0")) {
			switch (opcion) {
			case "1":
				introducirMysql();
				break;
			case "2":
				introducirSQLite();
				break;
			case "3":
				System.out.println("Introducindo datos en Apache Derby...");
				break;
			default:
				System.out.println("Debe introducir unha opción válida");
			}

			opcion = introducirDatos("Desexa intruducir máis datos?\n1.- Si\n2.- Non");
			if (opcion.equals("1")) {
				opcion = introducirDatos(
						"Seleccione a base de datos onde desexa introducir os datos.\n1.- MySQL\n2.- SQLite\n3.- Apache Derby\n0.- Saír");
			} else {
				System.out.println("Programa finalizado");
				System.exit(0);
			}
		}
	}

	private static void inserirClienteMySQL(Connection conexion, String user, String password, String url, String driver)
			throws IOException {

				
		String nombre = introducirDatos("Introducir o nome do cliente:");
		if (nombre.length() > 50) {
			nombre = nombre.substring(0, 51);
		}
		String direccion = introducirDatos("Introducir o enderezo do cliente: ");
		if (direccion.length() > 50) {
			direccion = direccion.substring(0, 51);
		}
		String poblacion = introducirDatos("Introducir a poboación do cliente: ");
		if (poblacion.length() > 30) {
			poblacion = direccion.substring(0, 31);
		}
		String telefono = introducirDatos("Introducir o telefono do cliente: ");
		if (telefono.length() > 9) {
			telefono = telefono.substring(0, 10);
		}

		String nif = introducirDatos("Introducir o nif do cliente: ");
		if (nif.length() > 10) {
			nif = nif.substring(0, 11);
		}

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO clientes(nombre, direccion, poblacion, telefono, nif) VALUES (?, ?, ?, ?, ?)";
			System.out.println(sql);
			
			PreparedStatement sentenza = conexion.prepareStatement(sql);
			
			sentenza.setString(1, nombre);
			sentenza.setString(2, direccion);
			sentenza.setString(3, poblacion);
			sentenza.setString(4, telefono);
			sentenza.setString(5, nif);
			
			sentenza.executeUpdate(sql);

			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void inserirClienteSQLite(Connection conexion, String user, String password, String url, String driver)
			throws IOException {

		int idCliente = Integer.parseInt(introducirDatos("Introduza o código do cliente: "));
		
		String nombre = introducirDatos("Introducir o nome do cliente:");
		if (nombre.length() > 50) {
			nombre = nombre.substring(0, 51);
		}
		String direccion = introducirDatos("Introducir o enderezo do cliente: ");
		if (direccion.length() > 50) {
			direccion = direccion.substring(0, 51);
		}
		String poblacion = introducirDatos("Introducir a poboación do cliente: ");
		if (poblacion.length() > 30) {
			poblacion = direccion.substring(0, 31);
		}
		String telefono = introducirDatos("Introducir o telefono do cliente: ");
		if (telefono.length() > 9) {
			telefono = telefono.substring(0, 10);
		}

		String nif = introducirDatos("Introducir o nif do cliente: ");
		if (nif.length() > 10) {
			nif = nif.substring(0, 11);
		}

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO clientes(idCliente, nombre, direccion, poblacion, telefono, nif) VALUES (?, ?, ?, ?, ?, ?)";
			System.out.println(sql);
			
			PreparedStatement sentenza = conexion.prepareStatement(sql);
			sentenza.setInt(1, idCliente);
			sentenza.setString(2, nombre);
			sentenza.setString(3, direccion);
			sentenza.setString(4, poblacion);
			sentenza.setString(5, telefono);
			sentenza.setString(6, nif);
			
			sentenza.executeUpdate(sql);

			conexion.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void inserirProducto(Connection conexion, String user, String password, String url, String driver)
			throws NumberFormatException, IOException {

		int idNumerico = Integer.parseInt(introducirDatos("Introduza o idNumerico: "));
		String descricion = introducirDatos("introducir a descripción: ");
		if (descricion.length() > 50) {
			descricion = descricion.substring(0, 50);
		}
		int stockActual = Integer.parseInt(introducirDatos("Introduza stock actual: "));
		int stockMimimo = Integer.parseInt(introducirDatos("Introduza stock mínimo:"));
		double precio = Double.parseDouble(introducirDatos("Introduza prezo"));

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO productos VALUES ('" + idNumerico + "','" + descricion + "','" + stockActual
					+ "','" + stockMimimo + "','" + precio + "');";
			System.out.println(sql);

			Statement sentenza = conexion.createStatement();

			sentenza.executeUpdate(sql);

			conexion.close();

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void inserirVenta(Connection conexion, String user, String password, String url, String driver)
			throws IOException {

		int codigoVenta = Integer.parseInt(introducirDatos("Introduza o código da venta"));
		
		String fechaVenta = introducirDatos("Introduza a data de venta (formato aaaa-mm-dd).");

		int idCliente = Integer.parseInt(introducirDatos("Introduza o id do cliente:"));

		verificarIdCliente(idCliente, conexion, user, password, url, driver);

		int idProducto = Integer.parseInt(introducirDatos("Introduza o id do produto:"));
		verificarIdProducto(idProducto, conexion, user, password, url, driver);

		int cantidad = Integer.parseInt(introducirDatos("Introduza a cantidade vendida:"));

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO Ventas(idVenta, fechaVenta, idCliente, idProducto, cantidad) VALUES (?,?,?,?,?)";
			System.out.println(sql);
			
			PreparedStatement sentenza = conexion.prepareStatement(sql);
			sentenza.setInt(1, codigoVenta);
			sentenza.setString(2, fechaVenta);
			sentenza.setInt(3, idCliente);
			sentenza.setInt(4, idProducto);
			sentenza.setInt(5, cantidad);

			sentenza.executeUpdate(sql);

			conexion.close();
			sentenza.close();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void verificarIdProducto(int idProducto, Connection conexion, String user, String password,
			String url, String driver) {
		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);

			String sql = "SELECT idNumerico FROM Productos WHERE idNumerico = ?";

			PreparedStatement sentenza = (PreparedStatement) conexion.prepareStatement(sql);
			sentenza.setInt(1, idProducto);

			ResultSet resultado = sentenza.executeQuery();
			if (!resultado.next()) {
				System.out.println("O cliente non existe, debe crealo antes.");
			}
			resultado.close();
			conexion.close();

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void verificarIdCliente(int idCliente, Connection conexion, String user, String password, String url,
			String driver) {

		try {
			Class.forName(driver).newInstance();
			conexion = DriverManager.getConnection(url, user, password);

			String sql = "SELECT idCliente FROM Clientes WHERE idCliente = ?";

			PreparedStatement sentenza = (PreparedStatement) conexion.prepareStatement(sql);
			sentenza.setInt(1, idCliente);

			ResultSet resultado = sentenza.executeQuery();
			if (!resultado.next()) {
				System.out.println("O cliente non existe, debe crealo antes.");
			}
			resultado.close();
			conexion.close();

		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void consultarDatosBD() throws IOException {

		System.out.println("MOSTRAR LISTAXE");

		opcion = introducirDatos(
				"Seleccione a base de datos que desexa listar\n1.- MySQL\n2.- SQLite\n3.- Apache Derby\n0.- Saír");

		while (!opcion.equals("0")) {
			switch (opcion) {
			case "1":
				String idCliente = introducirDatos("Introduza o código de cliente: ");
				listarDatosMySQL(idCliente);
				break;
			case "2":
				idCliente = introducirDatos("Introduza o código de cliente: ");
				listarDatosSQLite(idCliente);
				break;
			case "3":
				System.out.println("Listando Apache Derby...");
				break;
			default:
				System.out.println("Debe introducir unha opción válida");
			}

			opcion = introducirDatos("Desexa listar máis datos?\n1.- Si\n2.- Non");
			if (opcion.equals("1")) {
				opcion = introducirDatos(
						"Seleccione a base de datos.\n1.- MySQL\n2.- SQLite\n3.- Apache Derby\n0.- Saír");
			} else {
				System.out.println("Programa finalizado");
				System.exit(0);
			}
		}
	}

	private static void listarDatosSQLite(String idCliente) {
		Connection conexionsql = null;
		String url = "jdbc:sqlite:C:\\Users\\Alexandre\\Documents\\WorkspaceEspace\\AccesoADatos\\dbExercicioTema2/UD02BDSQLite.db";
		String driver = "org.sqlite.JDBC";

		try {

			Class.forName(driver).newInstance();
			conexionsql = DriverManager.getConnection(url);
			System.out.println("Conexión establecida");

			String sql = "SELECT idCliente, idVenta, nombre, descripcion, cantidad, precio, cantidad*precio 'Importe' FROM (ventas INNER JOIN productos ON(idProducto = IdNumerico) ) INNER JOIN Clientes USING(idCliente) WHERE IdCliente = ? ";

			PreparedStatement sentenza = conexionsql.prepareStatement(sql);
			sentenza.setInt(1, Integer.parseInt(idCliente));
			ResultSet resultado = sentenza.executeQuery();

			while (resultado.next()) {
				int idventa = resultado.getInt("idVenta");

				String cliente = resultado.getString("nombre");
				int cantidad = resultado.getInt("cantidad");
				double precio = resultado.getDouble("precio");
				double importe = resultado.getDouble("Importe");
				String descripcion = resultado.getString("descripcion");

				System.out.println("Ventas de cliente: " + cliente);
				System.out.println("\tVentas: " + idventa);
				System.out.println("\tProducto: " + descripcion + "\tPVP: " + precio);
				System.out.println("\tCantidad: " + cantidad);
				System.out.println("\tImporte: " + importe);
			}

			sql = "SELECT count(*) AS 'Ventas totales', SUM(cantidad*precio) as'Importe total' FROM (ventas INNER JOIN productos ON(idProducto = IdNumerico) ) INNER JOIN Clientes USING(idCliente) WHERE idCliente = ?";
			sentenza = conexionsql.prepareStatement(sql);
			sentenza.setInt(1, Integer.parseInt(idCliente));

			resultado = sentenza.executeQuery();

			while (resultado.next()) {
				int ventasTotales = resultado.getInt("Ventas totales");
				double importeTotal = resultado.getDouble("Importe total");

				System.out.println("Ventas totales: " + ventasTotales);
				System.out.println("Importe total: " + importeTotal);
			}

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

	private static void listarDatosMySQL(String IdCliente) {

		Connection conexionsql = null;
		String user = "SegundoDAM";
		String password = "randulfolupe";
		String url = "jdbc:mysql://localhost:3306/ud02bdmysql?serverTimezone=Europe/Madrid";
		String driver = "com.mysql.jdbc.Driver";

		try {

			Class.forName(driver).newInstance();
			conexionsql = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión establecida");

			String sql = "SELECT idCliente, idVenta, nombre, descripcion, cantidad, precio, cantidad*precio 'Importe' FROM (ventas INNER JOIN productos ON(idProducto = IdNumerico) ) INNER JOIN Clientes USING(idCliente) WHERE IdCliente = ? ";

			PreparedStatement sentenza = conexionsql.prepareStatement(sql);
			sentenza.setInt(1, Integer.parseInt(IdCliente));
			ResultSet resultado = sentenza.executeQuery();

			while (resultado.next()) {
				int idventa = resultado.getInt("idVenta");

				String cliente = resultado.getString("nombre");
				int cantidad = resultado.getInt("cantidad");
				double precio = resultado.getDouble("precio");
				double importe = resultado.getDouble("Importe");
				String descripcion = resultado.getString("descripcion");

				System.out.println("Ventas de cliente: " + cliente);
				System.out.println("\tVentas: " + idventa);
				System.out.println("\tProducto: " + descripcion + "\tPVP: " + precio);
				System.out.println("\tCantidad: " + cantidad);
				System.out.println("\tImporte: " + importe);
			}

			sql = "SELECT count(*) AS 'Ventas totales', SUM(cantidad*precio) as'Importe total' FROM (ventas INNER JOIN productos ON(idProducto = IdNumerico) ) INNER JOIN Clientes USING(idCliente) WHERE idCliente = ?";
			sentenza = conexionsql.prepareStatement(sql);
			sentenza.setInt(1, Integer.parseInt(IdCliente));

			resultado = sentenza.executeQuery();

			while (resultado.next()) {
				int ventasTotales = resultado.getInt("Ventas totales");
				double importeTotal = resultado.getDouble("Importe total");

				System.out.println("Ventas totales: " + ventasTotales);
				System.out.println("Importe total: " + importeTotal);
			}

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

	public static String introducirDatos(final String string) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(string);
		return br.readLine();
	}
}
