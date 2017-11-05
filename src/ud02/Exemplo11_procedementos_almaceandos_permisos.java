package ud02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/*
 * Exemplo de execucion dunha funci�n de usuario mysql desde un programa Java.
 * Executamos a funci�n FuAnhosTrabajados da base de datos.
 * A funci�n calcula o n�mero de anos traballados na empresa dun determinado traballador,
 * cuxo c�digo � pasado como par�metro.
*/

public class Exemplo11_procedementos_almaceandos_permisos {

	public static void main(String[] args) throws IOException {
		Connection conexion = null;
		String user = "SegundoDAM";
		String password = "SegundoDAM";
		// D� acceso aos procedementos 
		String url = "jdbc:mysql://localhost:3306/ud02bd01Empregados?serverTimezone=Europe/Madrid&noAccessToProcedureBodies=true";
		String driver = "com.mysql.jdbc.Driver";
		
		// A interface CallableStatement permite que se poda chamar desde Java aos procementos almacenados.
		CallableStatement chamadaFuncion = null;
		//variables auxiliares para introducir os distintos tipos de datos
		int auxInt = 0;
		
		try{
			// Codigo para cargar o Driver da BD
			Class.forName(driver).newInstance();
			// Establecemos a conexi�n
			conexion = DriverManager.getConnection(url, user, password);
			System.err.println("Conexion establecida");
			// Senteza en SQL para executar a funci�n ser�a  SELECT FuAnhosTrabajados (15);
			// Construimos a orde de chamada
			// {? = CALL -> Chama a unha funci�n
			// o (?) -> indica que se lle vai pasar un par�metro
			String sql = "{? = CALL FuAnhoTrabajo (?)}";
			// Preparamos a chamada ao procedemento 
			chamadaFuncion = conexion.prepareCall(sql);
			// D�moslle valor aos argumentos valor de retorno
			chamadaFuncion.registerOutParameter(1, Types.INTEGER);
			// Par�metro de entrada
			auxInt = Integer.parseInt(IntroducirDatos("C�digo de empregado: "));
			chamadaFuncion.setInt(2, auxInt);
			// Executamos o procedemento
			chamadaFuncion.execute();
			int anhos = chamadaFuncion.getInt(1);
			System.out.println("O Empregado: " +auxInt +" Anos: " +anhos);
			// Otra forma de visualizar la informacion
			System.out.println("El empregado: " +auxInt +" A�os: " +chamadaFuncion.getInt(1));
			conexion.close();
			}catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
			}catch(SQLException sqle){
			sqle.printStackTrace();
			}catch(Exception e){
			e.printStackTrace();
			}
			} // fin
																																																														// main
	// M�todo para introducir datos desde o teclado

	public static String IntroducirDatos(final String cad) throws IOException {
		// Introducindo unha cadea de caracteres
		String cadena = null;
		// 1�. Crea un obxecto InputStreamReader
		InputStreamReader isr = new InputStreamReader(System.in);
		// 2�. Crea un obxecto BufferedReader
		BufferedReader br = new BufferedReader(isr);
		System.out.println(cad);
		return br.readLine();

	}// fin introducirDatos()
}// fin clase
