package unidade04_exemplo03_variasClases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IValuesQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import unidade04_exemplo03_variasClases.clasesVO.Empleado;

public class Ej01Consultas03VariasTablas {
	static ODB odb = null;

	static IValuesQuery iValues = null;
	static Values values = null;
	static ObjectValues objectValues = null;
	static ICriterion criterio = null;

	static Ej01MantenimientoEmpleados manEmpleado = new Ej01MantenimientoEmpleados();

	public void consulta01() {
		// Obtener nombre, salario y oficina de los empleados
		// SELECT nombre, salario, localidad, oficina FROM Empleado e, Oficina o WHERE
		// e.codigo = o.codigo ;
		// SELECT nombre, salario, localidad, oficina FROM Empleado e INNER JOIN Oficina
		// o ON e.codigo = o.codigo ;

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try {

			// creamos la consulta
			// para acceder a cun campo accédese mediante o método field("nome do atributo")
			// pepro para acceder a un campo dentro dun obxecto úsase a nomenclatura do
			// punto:
			// field("obxecto.atributo");

			iValues = new ValuesCriteriaQuery(Empleado.class).field("nombre").field("salario")
					.field("oficina.localidad").field("oficina.nombreOficina");
			// recuperamos los valores
			values = odb.getValues(iValues);

			// visualizar resultados
			System.out.println("Nombre\t\t\tSalario\t\t\tLocalidad\t\t\tOficina");
			System.out.println("=======\t\t\t======\t\t\t=========\t\t\t=======");
			while (values.hasNext()) {
				objectValues = (ObjectValues) values.next();
				System.out.println(objectValues.getByAlias("nombre") + "\t\t\t" + objectValues.getByIndex(1) + "\t\t\t"
						+ objectValues.getByIndex(2) + "\t\t\t" + objectValues.getByIndex(3));
			}

		} catch (IndexOutOfBoundsException io) {
			System.out.println("No hay Empleados");
		}

		// cerramos la base de datos
		odb.close();
	}// fin consulta01

	public void consulta02() {
		// Obtener nombre, salario y oficina de los empleados de Vigo

		// SELECT nombre, salario, localidad, oficina FROM Empleado e, Oficina o WHERE
		// e.codigo = o.codigo AND
		// localidad = "Vigo";
		// SELECT nombre, salario, localidad, oficina FROM Empleado e INNER JOIN Oficina
		// o ON e.codigo = o.codigo
		// WHERE localidad = "Vigo";

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try {

			// creamos la consulta
			iValues = new ValuesCriteriaQuery(Empleado.class, Where.equal("Oficina.localidad", "Vigo")).field("nombre")
					.field("salario").field("oficina.localidad").field("oficina.nombreOficina");

			// recuperamos los valores
			values = odb.getValues(iValues);

			// visualizar resultados

			System.out.println("Nombre\t\t\tSalario\t\t\tLocalidad\t\t\tOficina");
			System.out.println("=======\t\t\t======\t\t\t=========\t\t\t=======");
			while (values.hasNext()) {
				objectValues = (ObjectValues) values.next();
				System.out.println(objectValues.getByAlias("nombre") + "\t\t\t" + objectValues.getByIndex(1) + "\t\t\t"
						+ objectValues.getByIndex(2) + "\t\t\t" + objectValues.getByIndex(3));
			}

		} catch (IndexOutOfBoundsException io) {
			System.out.println("No hay Empleados");
		}

		// cerramos la base de datos
		odb.close();
	}// fin consulta02

	public void consulta03() {
		// Obtener nombre, salario y oficina de los empleados de Vigo que ganen más de
		// 3000

		// SELECT nombre, salario, localidad, oficina FROM Empleado e, Oficina o WHERE
		// e.codigo = o.codigo AND
		// localidad = "Vigo AND salario > 3000";
		// SELECT nombre, salario, localidad, oficina FROM Empleado e INNER JOIN Oficina
		// o ON e.codigo = o.codigo
		// WHERE localidad = "Vigo AND salario > 3000";

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try {

			// creamos la consulta
			iValues = new ValuesCriteriaQuery(Empleado.class,
					new And().add(Where.equal("oficina.localidad", "Vigo")).add(Where.ge("salario", 3000)))
							.field("nombre").field("salario").field("oficina.localidad").field("oficina.nombreOficina");

			// recuperamos los valores
			values = odb.getValues(iValues);
			// visualizar resultados

			System.out.println("Nombre\t\t\tSalario\t\t\tLocalidad\t\t\tOficina");
			System.out.println("=======\t\t\t======\t\t\t=========\t\t\t=======");
			while (values.hasNext()) {
				objectValues = (ObjectValues) values.next();
				System.out.println(objectValues.getByAlias("nombre") + "\t\t\t" + objectValues.getByIndex(1) + "\t\t\t"
						+ objectValues.getByIndex(2) + "\t\t\t" + objectValues.getByIndex(3));
			}

		} catch (IndexOutOfBoundsException io) {
			System.out.println("No hay Empleados");
		}

		// cerramos la base de datos
		odb.close();
	}// fin consulta03

	public void consulta03Bis() {
		// Obtener nombre, salario y oficina de los empleados de Vigo que ganen más de
		// 3000

		// SELECT nombre, salario, localidad, oficina FROM Empleado e, Oficina o WHERE
		// e.codigo = o.codigo AND
		// localidad = "Vigo AND salario > 3000";
		// SELECT nombre, salario, localidad, oficina FROM Empleado e INNER JOIN Oficina
		// o ON e.codigo = o.codigo
		// WHERE localidad = "Vigo AND salario > 3000";

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try {
			// creamos la consulta
			iValues = new ValuesCriteriaQuery(Empleado.class,
					new And().add(Where.equal("oficina.localidad", "Vigo")).add(Where.gt("salario", 3000)))
							.field("nombre").field("salario").field("oficina.localidad").field("oficina.nombreOficina");

			// recuperamos los valores
			values = odb.getValues(iValues);
			// visualizar resultados
			
			 System.out.println("Nombre\t\t\tSalario\t\t\tLocalidad\t\t\tOficina");
			 System.out.println("=======\t\t\t======\t\t\t=========\t\t\t=======");
			 while(values.hasNext()){ objectValues = (ObjectValues)values.next();
			 System.out.println(objectValues.getByAlias("nombre") +"\t\t\t"
			 +objectValues.getByIndex(1) +"\t\t\t" +objectValues.getByIndex(2) +"\t\t\t"
			 +objectValues.getByIndex(3)); }
			

		} catch (IndexOutOfBoundsException io) {
			System.out.println("No hay Empleados");
		}

		// cerramos la base de datos
		odb.close();
	}// fin consulta03

	public void consulta04() {
		// Obtener nombre, salario bruto, retencione IRPF (15%), retenciones SS (12%),
		// Salario Neto
		// SELECT nombre, salario, salario*0.15, salario*0.12,
		// salario-salario*0.15-salario*0.12
		// FROM Empleado;

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		try {

			// creamos la consulta

			// recuperamos los valores

			// visualizar resultados
			/*
			 * System.out.
			 * println("Nombre\t\t\tOficina\t\t\tLocalidad\t\t\tSalario\t\t\tIRPF\t\t\tSS\t\t\tSueldo Neto"
			 * ); System.out.println("=======\t\t\t======\t\t\t=========\t\t\t=======");
			 * while(values.hasNext()){ objectValues = (ObjectValues)values.next();
			 * 
			 * Integer sal = (Integer) objectValues.getByAlias("salario"); double irpf =
			 * sal*0.15; double ss = sal*0.12; double salarioNeto = sal-irpf-ss;
			 * System.out.println(objectValues.getByAlias("nombre") +"\t\t\t"
			 * +objectValues.getByIndex(1) +"\t\t\t" +objectValues.getByIndex(2) +"\t\t\t"
			 * +sal +"\t\t\t" +irpf +"\t\t\t" +ss +"\t\t\t" +salarioNeto); }
			 */
		} catch (IndexOutOfBoundsException io) {
			System.out.println("No hay Empleados");
		}
		// cerramos la base de datos
		odb.close();
	}
}
