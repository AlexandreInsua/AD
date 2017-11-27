package unidade04;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

/* Programa que xestiona unhaxe de datos NeoDatis que garda obxecto de tipo Empregado */

public class Exemplo01_neodatis {

	public static void main(String[] args) {

		// Crea instancia da clase Empleado para almacenar na bd
		Empleado empleado1 = new Empleado("Juan", "Príncipe, 32", "Vigo", 2500, 40);
		Empleado empleado2 = new Empleado("María", "García Barbón, 80", "Vigo", 1800, 25);
		Empleado empleado3 = new Empleado("Ana", "Principe de Vergara", "Madrid", 3200, 45);
		Empleado empleado4 = new Empleado("Pedro", "Gran Vía, 102", "Bilbao", 2200, 38);

		// Abre a base de datos, se non existe crea a bd.
		ODB odb = ODBFactory.open("neodatis.test");

		// Almacena os obxectos
		odb.store(empleado1);
		odb.store(empleado2);
		odb.store(empleado3);
		odb.store(empleado4);

		// Recuperamos os obxectos
		Objects<Empleado> empleados = odb.getObjects(Empleado.class);

		System.out.println(empleados.size() + " Empleados");

		int i = 1; // para contar o número de Empleados

		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			System.out.println("Empleado nº: " + (i++) + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion()
					+ "\t" + empleado.getCiudad() + "\t" + empleado.getEdad());
		}
		// Pechamos a bd
		odb.close();
	}
}
