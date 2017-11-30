package unidade04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.core.oid.OIDFactory;

/*
 * Exemplo que accede aos obxectos a través do seu OID
 */
public class Exemplo02_EmpleadoOID {
	public static void main(String[] args) {
		// Abrir a bd
		ODB odb = ODBFactory.open("neodatis.test");
		// Obter o obxecto coa clase OID
		// Neste caso tomaremos o obxecto cuxo OID é 3
		OID oid = OIDFactory.buildObjectOID(3);
		// Recuperamos un obxecto Empleado cuxo OID pedimos anteiormente
		Empleado empleado = (Empleado) odb.getObjectFromId(oid);
		visualizarResultados(empleado);
		// Buscar Empleado segundo o seu OID introducindo os datos desde o
		// teclado
		try {
			// Introducir o código a buscar por teclado
			int codigo = Integer.parseInt(introducirDatos("Introducir el código a buscar:"));
			oid = OIDFactory.buildObjectOID(codigo);
			empleado = (Empleado) odb.getObjectFromId(oid);
			visualizarResultados(empleado);
		} catch (NumberFormatException nfe) {
			System.out.println("Error de formato");
		}
		// Pechar a bd
		odb.close();
	}

	private static void visualizarResultados(Empleado empleado) {
		System.out.println(("Empleado: " + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion() + "\t"
				+ empleado.getCiudad() + "\t" + empleado.getSueldo() + "\t" + empleado.getEdad()));
	}

	public static String introducirDatos(String s) {
		// Declaramos os obxectos para a introdución de datos desde o teclado
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(s);
			return bf.readLine();
		} catch (IOException io) {
			System.out.println("Error en la introducción de datos");
		}
		return "Error";
	}
}