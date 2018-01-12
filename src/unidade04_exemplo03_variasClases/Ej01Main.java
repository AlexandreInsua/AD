package unidade04_exemplo03_variasClases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej01Main {
	static Ej01MantenimientoEmpleados manEmpleados = new Ej01MantenimientoEmpleados();
	static Ej01MantenimientoOficinas manOficinas = new Ej01MantenimientoOficinas();
	static Ej01Consultas01Empleados conEmpleados01 = new Ej01Consultas01Empleados();
	static Ej01Consultas02EmpleadosCampos conEmpleados02 = new Ej01Consultas02EmpleadosCampos();
	static Ej01Consultas03VariasTablas conVariasTablas = new Ej01Consultas03VariasTablas();

	public static void main(String[] args) {

		menuPrincipal();

	}// fin main

	private static void menuPrincipal() {
		int opcion = 0;

		do{
			System.out.println("1.- Oficinas");
			System.out.println("2.- Empleados");
			System.out.println("3.- Consultas Empleados");
			System.out.println("4.- Consultas Empleados (Campos, Funciones agregado)");
			System.out.println("5.- Consultas Oficinas - Empleados");

			System.out.println("6.- Salir");
			try{
				opcion = Integer.parseInt(introducirDatos("Elegir opcion: "));
				switch(opcion){
				case 1:
					menuOficinas();
					break;
				case 2:
					menuEmpleados();
					break;
				case 3:
					menuConsultasEmpleados();
					break;
				case 4:
					menuConsultasEmpleadosCamposFunciones();
					break;
				case 5:
					menuConsultasOficinasEmpleados();
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}

		}while(opcion != 5);

	}// fin menuPrincipal


	private static void menuConsultasEmpleadosCamposFunciones() {
		int opcion = 0;

		do{
			System.out.println("CONSULTAS EMPLEADOS SELECCIONANDO CAMPOS Y FUNCIONES DE GRUPO");
			System.out.println("=============================================================");
			System.out.println("1.- Obtener nombre y salario de los empleados");
			System.out.println("2.- Obtener la suma de los salarios y de las comisiones");
			System.out.println("3.- Obtener el número de empleados de la empresa");
			System.out.println("4.- Obtener el mayor y el menor salario");
			System.out.println("5.- Obtener el salario medio");
			System.out.println("6.- Obtener totales por puesto");
			System.out.println("7.- Obtener totales por puesto para los salarios mayores que 3000");
			System.out.println("8.- Volver");

			System.out.println("16.- Volver");
			try{
				opcion = Integer.parseInt(Ej01Main.introducirDatos("Elegir opcion: "));
				switch(opcion){
				case 1:
					conEmpleados02.consulta01();
					break;
				case 2:
					conEmpleados02.consulta02();
					break;
				case 3:
					conEmpleados02.consulta03();
					break;
				case 4:
					conEmpleados02.consulta04();
					break;
				case 5:
					conEmpleados02.consulta05();
					break;
				case 6:
					conEmpleados02.consulta06();
					break;
				case 7:
					conEmpleados02.consulta07();
					break;
				case 8:
					menuPrincipal();
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}

		}while(opcion != 8);
	}

	private static void menuConsultasOficinasEmpleados() {
		int opcion = 0;

		do{
			System.out.println("CONSULTAS OFICINAS Y EMPLEADOS ");
			System.out.println("=============================================================");
			System.out.println("1.- Obtener nombre, salario, localidad y oficina de los empleados");
			System.out.println("2.- Obtener nombre, salario y oficina de los empleados de Vigo");
			System.out.println("3.- Obtener nombre, salario y oficina de los empleados de Vigo que ganen más de 3000");
			System.out.println("4.- Obtener nombre, salario bruto, retencione IRPF (15%), retenciones SS (12%),"
					+ "Salario Neto");
			System.out.println("5.- Volver");

			try{
				opcion = Integer.parseInt(Ej01Main.introducirDatos("Elegir opcion: "));
				switch(opcion){
				case 1:
					conVariasTablas.consulta01();
					break;
				case 2:
					conVariasTablas.consulta02();
					break;
				case 3:
					conVariasTablas.consulta03();
					conVariasTablas.consulta03Bis();
					break;
				case 4:
					conVariasTablas.consulta04();
					break;
				case 5:
					menuPrincipal();
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}

		}while(opcion != 4);

	}
	private static void menuConsultasEmpleados() {
		int opcion = 0;

		do{
			System.out.println("CONSULTAS EMPLEADOS");
			System.out.println("=========");
			System.out.println("1.- Obtener el empleado conociendo su OIB (Identificaador de Objetos)");
			System.out.println("2.- Recuperar el OID de los empleados");
			System.out.println("3.- Listado Empleados");
			System.out.println("4.- Listado primer Empleado");
			System.out.println("5.- Listado Empleados ordenados por puesto");
			System.out.println("6.- Listado Empleados ordenados por Sueldo y Nombre descendente");
			System.out.println("7.- Listado Empleados de un determinado Puesto");
			System.out.println("8.- Listado Empleados que ganan más de un determminado sueldo");
			System.out.println("9.- Listado Empleados que ganan igual o menos que un determminado sueldo");
			System.out.println("10.- Listado Empleados cuyo nombre empieza por C");
			System.out.println("11.- Listado Empleados cuyo nombre no empieza por J");
			System.out.println("12.- Listado Empleados que no tengan asignado un puesto");
			System.out.println("13.- Listado Empleados que tengan asignado un puesto");
			System.out.println("14.- Listado Empleados de un determinado puesto y ganen más de una cantidad");
			System.out.println("15.- Listado Empleados de un determinado puesto o que ganen más de una cantidad");

			System.out.println("16.- Volver");
			try{
				opcion = Integer.parseInt(Ej01Main.introducirDatos("Elegir opcion: "));
				switch(opcion){
				case 1:
					conEmpleados01.consulta01();
					break;
				case 2:
					conEmpleados01.consulta02();
					break;
				case 3:
					conEmpleados01.consulta03();
					break;
				case 4:
					conEmpleados01.consulta04();
					break;
				case 5:
					conEmpleados01.consulta05();
					break;
				case 6:
					conEmpleados01.consulta06();
					break;
				case 7:
					conEmpleados01.consulta07();
					break;
				case 8:
					conEmpleados01.consulta08();
					break;
				case 9:
					conEmpleados01.consulta09();
					break;
				case 10:
					conEmpleados01.consulta10();
					break;
				case 11:
					conEmpleados01.consulta11();
					conEmpleados01.consulta11Bis();
					break;
				case 12:
					conEmpleados01.consulta12();
					break;	
				case 13:
					conEmpleados01.consulta13();
					break;		
				case 14:
					conEmpleados01.consulta14();
					break;		
				case 15:
					conEmpleados01.consulta15();
					break;
				case 16:
					menuPrincipal();
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}

		}while(opcion != 16);

	}
	private static void menuEmpleados() {
		int opcion = 0;

		do{
			System.out.println("EMPLEADOS");
			System.out.println("=========");
			System.out.println("1.- Nuevo");
			System.out.println("2.- Actualizar");
			System.out.println("3.- Consultar");
			System.out.println("4.- Eliminar");
			System.out.println("5.- Listado");
			System.out.println("6.- Volver");
			try{
				opcion = Integer.parseInt(introducirDatos("Elegir opcion: "));
				switch(opcion){
				case 1:
					manEmpleados.nuevoEmpleado();
					break;
				case 2:
					manEmpleados.actualizarEmpleado();
					break;
				case 3:
					manEmpleados.consultarEmpleado();
					break;
				case 4:
					manEmpleados.eliminarEmpleado();
					break;
				case 5:
					manEmpleados.listarEmpleados();
					break;
				case 6:
					menuPrincipal();
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}

		}while(opcion != 6);


	}// fin menuEmpleados

	private static void menuOficinas() {
		int opcion = 0;

		do{
			System.out.println("OFICINAS");
			System.out.println("=========");
			System.out.println("1.- Nueva");
			System.out.println("2.- Actualizar");
			System.out.println("3.- Consultar");
			System.out.println("4.- Eliminar");
			System.out.println("5.- Listado");
			System.out.println("6.- Volver");
			try{
				opcion = Integer.parseInt(Ej01Main.introducirDatos("Elegir opcion: "));
				switch(opcion){
				case 1:
					manOficinas.nuevaOficina();
					break;
				case 2:
					manOficinas.actualizarOficina();
					break;
				case 3:
					manOficinas.consultarOficina();
					break;
				case 4:
					manOficinas.eliminarOficina();
					break;
				case 5:
					manOficinas.listarOficina();
					break;
				case 6:
					Ej01Main.menuPrincipal();
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}

		}while(opcion != 6);

	}// fin menuOficinas


	//IntroducirDatos
	public static String introducirDatos(String s){
		try{
			System.out.print(s);
			return (new BufferedReader (new InputStreamReader (System.in))).readLine();
		}catch (IOException ioe){
			System.out.println("\nError interno en sistema de entrada/salida\n");
		}
		return "";

	}// fin introducirDatos

}
