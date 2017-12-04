package unidade04_exemplo02_variasClases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;

public class Ejemplo01ActualizacionVariasTablas {

	static ODB odb = null;
	static Objects<Departamento> departamentos = null;
	static Objects<Empleado> empleados = null;

	static IQuery query = null;
	static ICriterion criterio = null;

	public static void main(String[] args) {
		int opcion;
		do {
			menu();
			opcion = Integer.parseInt(introducirDatos("Elegir opción: "));

			switch (opcion) {
			case 1:
				// altasEmpleados();
				altasEmpleados01(); // verifica o nome departamento
				break;
			case 2:
				listadoDepartamentos();
				break;
			case 3:
				listadoEmpleados();
				break;
			case 4:
				System.exit(0);

			}
		} while (opcion != 4);

	}

	public static void menu() {
		System.out.println("1.- Altas Empleados ");
		System.out.println("2.- Listado Departamentos");
		System.out.println("3.- Listado Empleados");
		System.out.println("4.- Salir ");
		System.out.println();
	}

	public static String introducirDatos(String s) {

		// declaramos los objetos para la introducción de datos desde el teclado
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(s);
			return bf.readLine();
		} catch (IOException io) {
			System.out.println("Error en la introducción de datos");
		}
		return "Error";
	}

	public static void altasEmpleados() {
		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados");

		int codDepar = Integer.parseInt(introducirDatos("Código departamento. <0> para finalizar"));

		while (codDepar != 0) {
			String nbDepar = introducirDatos("Nombre Departamento:");
			String ciuDepar = introducirDatos("Ciudad departamento");
			Departamento departamento = new Departamento(codDepar, nbDepar, ciuDepar);
			String respuesta = null;

			do {
				Empleado empleado = new Empleado();

				// crear empleado
				empleado.setEmpleCodigo(Integer.parseInt(introducirDatos("Código Empleado")));
				empleado.setEmpleNombre(introducirDatos("Nombre empleado"));
				empleado.setEmplePuesto(introducirDatos("Puesto empleado"));
				empleado.setEmpleSalario(Integer.parseInt(introducirDatos("Salario ")));
				empleado.setEmpleComision(Integer.parseInt(introducirDatos("Comisión: ")));
				empleado.setDepartamento(departamento);

				// gardar

				odb.store(empleado);
				respuesta = introducirDatos("Nuevo empleado S/N");
			} while (respuesta.equalsIgnoreCase("S"));
			codDepar = Integer.parseInt(introducirDatos("Código departamento. <0> para finalizar"));
		}

		// cerramos la base de datos
		odb.close();
	}// fin altasEmpleados()

	// metodo en el que da de alta un departamento o un empleado comprobando que no
	// exista
	public static void altasEmpleados01() {
		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados");

		int codDepar = Integer.parseInt(introducirDatos("Código departamento. <0> para finalizar"));

		while (codDepar != 0) {
			// verifica o departamento
			if (comprobarExisteDepartamento(codDepar) == true) {
				String nbDepar = introducirDatos("Nombre Departamento:");
				String ciuDepar = introducirDatos("Ciudad departamento");
				Departamento departamento = new Departamento(codDepar, nbDepar, ciuDepar);

				String respuesta = null;

				do {
					Empleado empleado = new Empleado();
					int codEmple = Integer.parseInt(introducirDatos("Código Empleado"));
					// verifica o empregado
					if (comprobarExisteEmpleado(codEmple) == true) {
						empleado.setEmpleCodigo(codEmple);
						empleado.setEmpleNombre(introducirDatos("Nombre empleado"));
						empleado.setEmplePuesto(introducirDatos("Puesto empleado"));
						empleado.setEmpleSalario(Integer.parseInt(introducirDatos("Salario ")));
						empleado.setEmpleComision(Integer.parseInt(introducirDatos("Comisión: ")));
						empleado.setDepartamento(departamento);
					}
					odb.store(empleado);
					respuesta = introducirDatos("Nuevo empleado S/N");
				} while (respuesta.equalsIgnoreCase("S"));
			} else {
				System.out.println("El departamento  ya existe. ");
			}

			codDepar = Integer.parseInt(introducirDatos("Código departamento. <0> para finalizar"));
			// cerramos la base de datos
			odb.close();
		}
	}// fin altasEmpleados01()

	// METODOS DE COMPROBACIÓN DE EXISTENCIAS
	// Nesta base de datos a bd de datos xa esta aberta

	private static boolean comprobarExisteEmpleado(int codEmple) {
		criterio = Where.equal("emplecodigo", codEmple);
		query = odb.criteriaQuery(Empleado.class, criterio);
		// para evitar que pete hai que usar a capturar a excepción
		try {
			Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
			System.out.println("El empleado ya existe");
			return false;
		} catch (IndexOutOfBoundsException iobe) {
			return true;
		}
		// Recuperar datos
		/*
		 * Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
		 * 
		 * 
		 * if (empleado == null) { return false; } else { return true; }
		 */
	}

	private static boolean comprobarExisteDepartamento(int codDepar) {
		criterio = Where.equal("deparCodigo", codDepar);
		query = odb.criteriaQuery(Departamento.class, criterio);

		// para evitar que pete hai que usar a capturar a excepción
		try {
			Departamento departamento = (Departamento) odb.getObjects(query).getFirst();
			System.out.println("El departamento ya existe");
			return false;
		} catch (IndexOutOfBoundsException iobe) {
			return true;
		}
		/*
		 * // Resuperar datos Departamento departamento = (Departamento)
		 * odb.getObjects(query).getFirst(); if (departamento == null) { return false; }
		 * else { return true; }
		 */

	}

	public static void listadoDepartamentos() {
		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados");

		departamentos = odb.getObjects(Departamento.class);

		while (departamentos.hasNext()) {
			Departamento depar = departamentos.next();
			System.out.println(depar.getDeparCodigo() + "\t " + depar.getDeparNombre());
		}

		// cerrar la base de datos
		odb.close();
	} // fin listadoDepartamentos

	public static void listadoEmpleados() {
		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados");

		empleados = odb.getObjects(Empleado.class);

		// lista unicamento a nome e cidade do departamento
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			System.err.println(empleado.getEmpleCodigo() + "\t " + empleado.getEmpleNombre() + "\t"
					+ empleado.getEmplePuesto() + "\t " + empleado.getEmpleSalario() + "\t "
					+ empleado.getEmpleComision() + "\t " + empleado.getDepartamento().getDeparNombre() + "\t "
					+ empleado.getDepartamento().getDeparCiudad());
		}

		// cerrar la base de datos
		odb.close();
	} // fin listadpEmpleados()
}
