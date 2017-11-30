package unidade04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Exemplo04_EmpleadoConsultasSencillas {

	public static void main(String[] args) {
		String opcion;
		/*
		 * do { System.out.println("1.- Listado todos los empleados");
		 * System.out.println("2.- Listado Empleados de Bilbao"); System.out.
		 * println("3.- Listado Empleados de Vigo ordenados por sueldo y nombre");
		 * System.out.println("4.- Salir"); opcion =
		 * introducirDatos("Introduce una opcion: "); try { switch
		 * (Integer.parseInt(opcion)) { case 1: listadoEmpleados(); break; case 2:
		 * listadoPrimerEmpleadoBilbao(); break; case 3: listadoEmpleadosVigoOrdenado();
		 * break; case 4: System.exit(0); default: System.out.println("Opcion erronea");
		 * } } catch (NumberFormatException e) {
		 * System.out.println("La opcion tiene que ser un 	numero"); } } while
		 * (!opcion.equals("4"));
		 */

		listarEmpleadosPrincipioNombreNo();

	}// fin main
	
	/* MOSTRA EMPLEADOS CUXO NOME NON COMEZA POR "J" */
	private static void listarEmpleadosPrincipioNombreNo() {
		// SELECT * FROM Empledados WHERE nombre NOT LIKE 'J%'
		ODB odb = ODBFactory.open("neodatis.test");
		// crea o criterio - campo e criterio
		ICriterion criterio = Where.not(Where.like("nombre", "J%"));
		// creamos a consulta
		IQuery query = new CriteriaQuery(Empleado.class, criterio);
		// Obtén o resultado da consulta - varias posibles
		Objects empleados = odb.getObjects(query);
		// Devolve o número de Empleados
		System.out.println(empleados.size() + " Empleados");

		// VISUALIZA OS EMPLEADOS
		System.out.println("LISTADO EMPLEADOS");
		System.out.println("=================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			// Método parecido a un toString
			visualizarResultados(empleado);
		}
		// pecha a bd
		odb.close();
		
	}

	/* MOSTRA EMPLEADOS CUXO NOME COMEZA POR "J" */
	private static void listarEmpleadosPrincipioNombre() {
		// SELECT * FROM Empledados WHERE nombre LIKE 'J%'
		ODB odb = ODBFactory.open("neodatis.test");
		// crea o criterio - campo e criterio
		ICriterion criterio = Where.like("nombre", "J%");
		// creamos a consulta
		IQuery query = new CriteriaQuery(Empleado.class, criterio);
		// Obtén o resultado da consulta - varias posibles
		Objects empleados = odb.getObjects(query);
		// Devolve o número de Empleados
		System.out.println(empleados.size() + " Empleados");

		// VISUALIZA OS EMPLEADOS
		System.out.println("LISTADO EMPLEADOS");
		System.out.println("=================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			// Método parecido a un toString
			visualizarResultados(empleado);
		}
		// pecha a bd
		odb.close();
	}

	private static void listarEmpleadosCiudadAsignada() {
		// SELECT * FROM Empleados WHERE "ciudad" is NOT NULL
		// Abrimos a base de datos
		ODB odb = ODBFactory.open("neodatis.test");
		// crea o criterio
		ICriterion criterio = Where.isNotNull("ciudad");
		// creamos a consulta
		IQuery query = new CriteriaQuery(Empleado.class, criterio);
		// Obtén o resultado da consulta - varias posibles
		Objects empleados = odb.getObjects(query);
		// Devolve o número de Empleados
		System.out.println(empleados.size() + " Empleados");

		// VISUALIZA OS EMPLEADOS
		System.out.println("LISTADO EMPLEADOS");
		System.out.println("=================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			// Método parecido a un toString
			visualizarResultados(empleado);
		}
		// pecha a bd
		odb.close();
	}

	private static void listarEmpleadosCiudadNull() {
		// SELECT * FROM Empleados WHERE "ciudad" is NULL
		// Abrimos a base de datos
		ODB odb = ODBFactory.open("neodatis.test");
		// crea o criterio
		ICriterion criterio = Where.isNull("ciudad");
		// creamos a consulta
		IQuery query = new CriteriaQuery(Empleado.class, criterio);
		// Obtén o resultado da consulta - varias posibles
		Objects empleados = odb.getObjects(query);
		// Devolve o número de Empleados
		System.out.println(empleados.size() + " Empleados");

		// VISUALIZA OS EMPLEADOS
		System.out.println("LISTADO EMPLEADOS");
		System.out.println("=================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			// Método parecido a un toString
			visualizarResultados(empleado);
		}
		// cierra la base de datos
		odb.close();
	}

	/* LISTA PRIMEIRO EMPREGADO DE VIGO */
	private static void listarPrimerEmpleadoVigo() {

		// SELECT * FROM Empleados WHERE ciudad = "Vigo" LIMIT 1;
		// Abrimos la base de datos, si no existe la crea
		ODB odb = ODBFactory.open("neodatis.test");
		// Preparar a consulta
		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("ciudad", "Vigo"));
		// Obtén o primeiro resultado da consulta
		// o método getFirst() obtén só o primeiro
		Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
		System.out.println("LISTADO PRIMER EMPLEADO VIGO");
		System.out.println("=================================");
		visualizarResultados(empleado);
		// cierra la base de datos
		odb.close();

	}

	/* LISTA EMPLEADO DE 40 ANOS */
	private static void listadoEmpleadosEdad() {
		// SELECT * FROM Empleados WHERE EDAD = 40;
		// Abrir base
		ODB odb = ODBFactory.open("neodatis.test");
		// Creamos a consulta
		// primeiro o criterio
		ICriterion criterio = Where.equal("edad", 40);
		// depois a consula
		IQuery query = new CriteriaQuery(Empleado.class, criterio);
		// recuparar os obxectos (varios)
		Objects<Empleado> empleados = odb.getObjects(query);
		// mostrar os resultados
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			visualizarResultados(empleado);
		}

		odb.close();
	}

	/* LISTA EMPLEADO DE MAIS DE 40 ANOS */
	private static void listadoEmpleadosEdad2() {
		// SELECT * FROM Empleados WHERE EDAD > 40;
		// Abrir base
		ODB odb = ODBFactory.open("neodatis.test");
		// Creamos a consulta
		// primeiro o criterio
		ICriterion criterio = Where.gt("edad", 40);
		// depois a consula
		IQuery query = new CriteriaQuery(Empleado.class, criterio);
		// recuparar os obxectos (varios)
		Objects<Empleado> empleados = odb.getObjects(query);
		// mostrar os resultados
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			visualizarResultados(empleado);
		}

		odb.close();
	}

	/* LISTA TODOS OS EMPREGADOS */
	private static void listadoEmpleados() {
		// SELECT * FROM Empleados
		// Abrimos a base de datos
		ODB odb = ODBFactory.open("neodatis.test");
		// crea a consulta
		IQuery query = new CriteriaQuery(Empleado.class);
		// Obtén o resultado da consulta
		Objects empleados = odb.getObjects(query);
		// Devolve o número de Empleados
		System.out.println(empleados.size() + " Empleados");
		//
		int i = 1;
		// VISUALIZA OS EMPLEADOS
		// visua
		System.out.println("LISTADO EMPLEADOS");
		System.out.println("=================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			// Método parecido a un toString
			visualizarResultados(empleado);
		}
		// cierra la base de datos
		odb.close();
	}

	// VISUALIZAR O PRIMEIRO EMPLEADOS
	private static void primerEmpleado() {
		// parecido a
		// SELECT * FROM Empleado LIMIT 1;
		ODB odb = ODBFactory.open("neodatis.net");
		IQuery query = new CriteriaQuery(Empleado.class);
		// Devolve o primeiro emplegado
		Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
		visualizarResultados(empleado);
		// Pechar a bd
		odb.close();
	}

	// VISUALIZAR OS EMPLEADOS ORDENADOS POR NOME
	private static void listadoEmpleadosOrdenadosNombre() {
		// SELECT * FROM Empleados ORDER BY Nombre
		// Abrir base de datos
		ODB odb = ODBFactory.open("neodatis.net");
		// Construímos a consulta co método orderByAsc()
		IQuery query = new CriteriaQuery(Empleado.class).orderByAsc("nombre");
		// Recuperar a consulta - Devolve varios
		Objects<Empleado> empleados = odb.getObjects(query);

		// Recorrer o resultado
		while (empleados.hasNext()) {
			// A cada paso de bucle mostra un empregado
			Empleado empleado = empleados.next();
			visualizarResultados(empleado);
		}
		// Pechar a bd
		odb.close();
	}

	// VISUALIZAR OS EMPLEADOS ORDENADOS POR SOLDO E NOME
	private static void listadoEmpleadosOrdenadosSueldoNombre() {
		// SELECT * FROM Empleados ORDER BY Sueldo, Nombre;
		// Abrir base de datos
		ODB odb = ODBFactory.open("neodatis.net");
		// Construímos a consulta pero o formado cambia
		// os campos van dentro da mesma String (como ser for unha sentenza sql)
		IQuery query = new CriteriaQuery(Empleado.class).orderByAsc("sueldo, nombre");
		// Recuperar a consulta - Devolve varios
		Objects<Empleado> empleados = odb.getObjects(query);

		// Recorrer o resultado
		while (empleados.hasNext()) {
			// A cada paso de bucle mostra un empregado
			Empleado empleado = empleados.next();
			visualizarResultados(empleado);
		}
		// Pechar a bd
		odb.close();
	}

	private static void listadoPrimerEmpleadoBilbao() {
		// Consulta 2. Obtener el primer empleado de Bilbao
		// SELECT * FROM Empleados WHERE ciudad = "Bilbao LIMIT 1;"
		// Abrimos la base de datos, si no existe la crea
		ODB odb = ODBFactory.open("neodatis.test");

		// Crea a consulta para buscar segundo un cre
		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("ciudad", "Bilbao"));
		// Obtiene el primer resultado de la consulta
		// el método getFirst() obtiene solo el primero
		Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
		System.out.println("LISTADO PRIMER EMPLEADO BILBAO");
		System.out.println("=================================");
		visualizarResultados(empleado);
		// cierra la base de datos
		odb.close();
	}

	/* VISUALIAR OS EMPLEADOS DE VIGO EN ORDE DESCENDENTE DE SOLDO */
	private static void listadoEmpleadosVigoOrdenado() {
		// Consulta 3. Obter os empleados de Vigo ordenados por soldo desdencente de
		// soldo e nome
		// SELECT * FROM Empleados WHERE ciudad = "Vigo ORDER BY sueldo, nombre ASC;"
		// Abrimos la base de datos, si no existe la crea
		ODB odb = ODBFactory.open("neodatis.test");
		// seleccion por cidade
		// query = new CriteriaQuery(Empleado.class, Where.equal("ciudad", "Vigo"));
		// ordena ascendente por edad y nombre
		// query.orderByAsc("sueldo,nombre");
		// otra forma de escribir la consulta sería:
		IQuery query = new CriteriaQuery(Empleado.class, Where.equal("ciudad", "Vigo")).orderByDesc("sueldo,nombre");
		// Obtiene el resultado de la consulta
		Objects empleados = odb.getObjects(query);
		// visualizar los empleados de Vigo ordenados por sueldo y nombre
		System.out.println("LISTADO EMPLEADOS ORDENADOS SUELDO Y 	NOMBRE");
		System.out.println("===================================================");
		while (empleados.hasNext()) {
			Empleado empleado = (Empleado) empleados.next();
			visualizarResultados(empleado);
		}
		// cerrar la bbdd
		odb.close();
	}

	private static void visualizarResultados(Empleado empleado) {
		System.out.println(("Empleado: " + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion() + "\t"
				+ empleado.getCiudad() + "\t" + empleado.getSueldo() + "\t" + empleado.getEdad()));
	}

	public static String introducirDatos(String s) {
		// declaramos los objetos para la introducción de datos desde el teclado
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(s);
			return bf.readLine();
		} catch (IOException io) {
			System.out.println("Error en la introducción de 		datos");
		}
		return "Error";
	}// fin introducirDatos

}