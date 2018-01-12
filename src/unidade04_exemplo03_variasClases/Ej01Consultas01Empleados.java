package unidade04_exemplo03_variasClases;

import org.neodatis.odb.CorruptedDatabaseException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import unidade04_exemplo03_variasClases.clasesVO.Empleado;

public class Ej01Consultas01Empleados {

	static ODB odb = null;
	static IQuery query = null;
	static OID oid = null;
	static ICriterion criterio = null;

	static Ej01MantenimientoEmpleados manEmpleado = new Ej01MantenimientoEmpleados();

	public static void consulta01() {

		// Obtener el empleado conociendo su OIB (Identificaador de Objetos)

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{

			//obtenemos el empleado con el OID que introducimos por teclado
			oid = OIDFactory.buildObjectOID(Long.parseLong(Ej01Main.introducirDatos("Introducir el OID: ")));

			Empleado empleado = (Empleado) odb.getObjectFromId(oid); 
			manEmpleado.visualizarEmpleado(empleado);
		}catch(CorruptedDatabaseException cd){
			System.out.println("Empleado no existe");
		}

		//cerramos la base de datos
		odb.close();
	}// fin consulta01

	public void consulta02() {
		// Recuperar el OID de los empleados

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		// recuperamos todos los objetos
		try{
			Objects <Empleado> empleados = odb.getObjects(Empleado.class);
			System.out.println("Listado Empleados");
			System.out.println("OID\tCódigo\tNombre\tPuesto\tSalario\tComisión\n");

			//visulizamos los empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				//recuperamos el oid
				oid = odb.getObjectId(empleado);
				System.out.print(oid  +"\t");
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}
		//cerramos la base de datos
		odb.close();
	}// fin consulta02

	public void consulta03() {
		// Recuperar todos los empleados
		//SELECT * FROM empleados,

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class);
			// recuperamos todos los objetos utilizando la consulta
			Objects <Empleado> empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS");
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}		
		//cerramos la base de datos
		odb.close();
	}// fin consulta03

	public void consulta04() {
		//Recuperar solo un objeto
		//SELECT * FROM Empleado LIMIT 1;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class);

			// recuperamos el  primer objeto utilizando la consulta
			Empleado empleado =  (Empleado) odb.getObjects(query).getFirst();
			// visualizar el empleado
			Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}
		//cerramos la base de datos
		odb.close();
	}// fin consulta04

	public void consulta05() {
		// Listado Empleados ordenados por puesto
		// SELECT * FROM empleado ORDER BY Puesto;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class).orderByAsc("puesto");

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS ORDENADOS POR PUESTO");
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta05

	public void consulta06() {
		// Listado Empleados ordenados por Sueldo  y Nombre descendente

		// SELECT * FROM empleado ORDER BY Salario DESC, Nombre DESC;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class).orderByDesc("salario,nombre");

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS ORDENADOS POR SALARIO Y NOMBRE DESCENDENTE");
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta06

	public void consulta07() {
		// Listado Empleados de un determinado Puesto ordenados por nombre

		// SELECT * FROM empleado WHERE Puesto = ?;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, Where.equal("puesto", 
					Ej01Main.introducirDatos("Introducir el puesto: "))).orderByAsc("nombre");

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS " );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta07

	public void consulta08() {
		// Listado Empleados que ganan más de un determminado suledo

		// SELECT * FROM empleado WHERE Salario > ?;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, Where.gt("salario", 
					Float.parseFloat(Ej01Main.introducirDatos("Introducir el salario: ")))).orderByAsc("nombre");

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS SUELDO" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta08

	public void consulta09() {
		// Listado Empleados que ganan igual o menos que un determminado sueldo

		// SELECT * FROM empleado WHERE Salario <= ?;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, Where.le("salario", 
					Float.parseFloat(Ej01Main.introducirDatos("Introducir el salario: ")))).orderByAsc("nombre");

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS SUELDO" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta09

	public void consulta10() {
		// Listado Empleados cuyo nombre empieza por C

		// SELECT * FROM empleado WHERE Nombre LIKE 'C%';

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, Where.like("nombre","C%"));

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS NOMBRE EMPIEZA POR C" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta10

	public void consulta11() {
		// Listado Empleados cuyo nombre no empieza por J


		// SELECT * FROM empleado WHERE Nombre NOT LIKE 'J%';

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, Where.not(Where.like("nombre","J%")));

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS NOMBRE NO EMPIEZA POR J" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta11

	public void consulta11Bis() {
		// Listado Empleados cuyo nombre no empieza por J
		// expresa los criterios de otra forma

		// SELECT * FROM empleado WHERE Nombre NOT LIKE 'J%';

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos los criterios
			criterio = Where.like("nombre","J%");
			ICriterion criterio2 = Where.not(criterio);

			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, criterio2);

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS NOMBRE NO EMPIEZA POR J" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta11Bis

	public void consulta12() {
		// Listado Empleados que no tengan asignado un puesto

		// SELECT * FROM empleado WHERE Puesto IS NULL;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos el criterio
			criterio = Where.isNull("puesto");

			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, criterio);

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS SIN PUESTO" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta12

	public void consulta13() {
		// Listado Empleados que tengan asignado un puesto

		// SELECT * FROM empleado WHERE Puesto IS NOT NULL;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos el criterio
			criterio = Where.isNotNull("puesto");

			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, criterio);

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS CON PUESTO" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta13

	public void consulta14() {
		// Listado Empleados de un determinado puesto y ganen más de una cantidad

		// SELECT * FROM empleado WHERE Puesto = ? AND Salario >= ?;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos el criterio
			criterio = new And().add(Where.equal("puesto", Ej01Main.introducirDatos("Introducir puesto: ")))
					.add(Where.ge("salario", Float.parseFloat(Ej01Main.introducirDatos("Introducir salario: "))));

			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, criterio);

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS PUESTO Y SALARIO" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta14

	public void consulta15() {
		// Listado Empleados de un determinado puesto o que ganen más de una cantidad"

		// SELECT * FROM empleado WHERE Puesto = ? OR Salario >= ?;

		//Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try{
			//creamos el criterio
			criterio = new Or().add(Where.equal("puesto", Ej01Main.introducirDatos("Introducir puesto: ")))
					.add(Where.ge("salario", Float.parseFloat(Ej01Main.introducirDatos("Introducir salario: "))));

			//creamos la consulta
			query = new CriteriaQuery(Empleado.class, criterio);

			// recuperamos todos los objetos utilizando la consulta
			Objects<Empleado>  empleados =  odb.getObjects(query);

			System.out.println("LISTADO EMPLEADOS PUESTO Y SALARIO" );
			// visualizar los Empleados
			while(empleados.hasNext()){
				Empleado empleado = empleados.next();
				Ej01MantenimientoEmpleados.visualizarEmpleado(empleado);
			}
		}catch(IndexOutOfBoundsException io){
			System.out.println("No hay Empleados");
		}			
		//cerramos la base de datos
		odb.close();
	}// fin consulta15
}
