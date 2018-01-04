package ud02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Obtén a mesma informaicón indicando o nome da columnas en lugar da posición
 */
public class Exemplo07c_metadatos {

	public static void main(String[] args) {
		// Configurar parametros de conexion
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "randulfolupe";
		String url = "jdbc:mysql://localhost:3306/UD02BD01Empregados?serverTimezone=Europe/Madrid";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexión establecida");

			DatabaseMetaData dbmd = conexion.getMetaData();

			ResultSet columnas = dbmd.getColumns(null, "UD02BD01Empregados", "departamentos", null);
			// pk necesita o nome da táboa
			ResultSet pk = dbmd.getPrimaryKeys(null, "UD02BD01Empregados", "departamentos");

			while (columnas.next()) {

				// características das columnas
				String nomeCol = columnas.getString("COLUMN_NAME");
				String tipoCol = columnas.getString("TYPE_NAME");
				String tamCol = columnas.getString("COLUMN_SIZE");
				String tipo = columnas.getString("IS_NULLABLE");

				System.out.println("Columna: " + nomeCol + " - Tipo: " + tipoCol + " tamaño: " + tamCol
						+ " - Pode ser nulo?: " + tipo + "clave primaria ");
			}

			// CLAVE PRIMARIA
			String pkDep = "", separador = "";
			while (pk.next()) {
				pkDep = pkDep + separador + pk.getString("COLUMN_NAME");
				// getString(4)
				separador = "+";
			} // fin while
			System.out.println("Clave primaria: " + pkDep);

			// CLAVE PRIMARIA E ALLEA NOUTRAS TÁBOAS
			ResultSet fk = dbmd.getExportedKeys(null, "UD02BD01Empleados", "departamentos");
			while (fk.next()) {
				String fkNbColumna = fk.getString("FKCOLUMN_NAME");
				String pkNbColumna = fk.getString("PKCOLUMN_NAME");
				String pkNbTabla = fk.getString("PKTABLE_NAME");
				String fkNbTabla = fk.getString("FKTABLE_NAME");
				System.out.println("Tabla PK: " + pkNbTabla + " Clave Primaria: " + pkNbColumna);
				System.out.println("Tabla FK: " + fkNbTabla + " Clave Allea: " + fkNbColumna);
			} // fin while

			// CLAVES ALLEAS NA PROPIA TÁBOA
			System.out.println("Claves alleas en empleados");
			ResultSet fk1 = dbmd.getImportedKeys(null, "UD02BD01Empleados",
					"empleados");
			while (fk1.next()){
				String fkTaboa = fk1.getString("FKCOLUMN_NAME");
				System.out.println(fkTaboa);
			}
			
			// 	OBTER INFORMACIÓN SOBRE OS PROCEDEMENTOS ALMACENADOS
			ResultSet proc = dbmd.getProcedures(null, " UD02BD01Empleados ",
			null);
			while (proc.next()){
			String procNb = proc.getString("PROCEDURE_NAME");
			String procTipo = proc.getString("PROCEDURE_TYPE");
			System.out.println("Nombre Procedimiento: "+procNb +" Tipo: "
			+procTipo);
			}//fin while
			
			conexion.close();
			System.err.println("CERRANDO CONEXIÓN A BD");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
