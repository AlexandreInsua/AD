package unidade04_exemplo02_variasClases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Ejemplo02ConsultasVariasTablas {

	static ODB odb = null;
	static Values valores = null;
	static ObjectValues objectValues = null;

	public static void main(String[] args) {
		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados");

		// Consulta 1. Obtener el nombre, puesto, sueldo y el departamento de cada
		// empleado
		consulta01();

		// Consulta 2. Obtener el nombre, puesto de los empleados del departamento de
		// Contabilidad
		// consulta02();

		// Consulta 3. Obtener el nombre, puesto, sueldo y comision de los empleados del
		// departamento de Contabilidad con sueldo mayor de 3000 €
		// consulta03();

		// cerrar la base de datos
		odb.close();
	} // fin del main

	/////////////////////////////////////////////////////////////////////////////////
	private static void consulta01() {
		// Consulta 1. Obtener el nombre, puesto, sueldo y el departamento de cada
		// empleado
		// Producto cartesiano
		// SELECT empleNombre, emplePuesto, empleSalario, deparNombre FROM Empleado e,
		// Departamento d WHERE e.codDepar = d.codDepar;
		// Join interno
		// SELECT empleNombre, emplePuesto, empleSalario, deparNombre FROM Empleado e
		// INNER JOIN
		// Departamento d ON e.codDepar = d.codDepar;

		valores = odb.getValues(new ValuesCriteriaQuery(Empleado.class).field("empleNombre").field("emplePuesto")
				.field("empleSalario2").field("departamento.deparNombre"));

		// con iquery
		// iQuery = new
		// ValuesCriteriaQuery(Empleado.class).field("empleNombre").field("emplePuesto").field("empleSalario2").field("departamento.deparNombre"));
		//
		// visualizar datos
		System.out.println("LISTADO DE EMPLEADOS");
		System.out.println("nombre \t \t puesto  \t\t salario \t\\t departamento");
		while (valores.hasNext()) {
			objectValues = valores.next();
			System.out.println(objectValues.getByAlias("empleNombre") + "\t" + objectValues.getByAlias("emplePuesto")
					+ "\t" + objectValues.getByAlias("empleSalario") + "\t"
					+ objectValues.getByAlias("departamento.deparNombre"));
		}
	}

	private static void consulta02() {

		// Consulta 2. Obtener el nombre, puesto de los empleados del departamento de
		// Contabilidad
		// SELECT empleNombre, emplePuesto, empleSalario FROM Empleado e, Departamento d
		// WHERE e.codDepar = d.codDepar AND deparNombre = 'Contabilidad';
		// SELECT empleNombre, emplePuesto, empleSalario FROM Empleado e INNER JOIN
		// Departamento d
		// ON e.codDepar = d.codDepar WHERE deparNombre = 'Contabilidad';

		valores = odb.getValues(
				new ValuesCriteriaQuery(Empleado.class, Where.equal("departamento.dparNombre", "contabilidad"))
						.field("empleNombre").field("emplePuesto").field("empleSalario2")
						.field("departamento.deparNombre"));

		// con iquery
		// iQuery = new
		// ValuesCriteriaQuery(Empleado.class, Where.equal("departamento.dparNombre",
		// "contabilidad")).field("empleNombre").field("emplePuesto").field("empleSalario2").field("departamento.deparNombre"));

		// visualizar datos
		System.out.println("LISTADO DE EMPLEADOS");
		System.out.println("nombre \t \t puesto  \t\t salario \t\\t departamento");
		while (valores.hasNext()) {
			objectValues = valores.next();
			System.out.println(objectValues.getByAlias("empleNombre") + "\t" + objectValues.getByAlias("emplePuesto")
					+ "\t" + objectValues.getByAlias("empleSalario") + "\t"
					+ objectValues.getByAlias("departamento.deparNombre"));
		}
	}

	private static void consulta03() {

		// Consulta 3. Obtener el nombre, puesto, sueldo y comision de los empleados del
		// departamento
		// de Contabilidad con sueldo mayor de 2400 €
		// SELECT empleNombre, emplePuesto, empleSalario FROM Empleado e, Departamento d
		// WHERE e.codDepar = d.codDepar AND deparNombre = 'Contabilidad' and
		// empleSalario>3000;
		// SELECT empleNombre, emplePuesto, empleSalario FROM Empleado e INNER JOIN
		// Departamento d
		// ON e.codDepar = d.codDepar WHERE deparNombre =
		// 'Contabilidad'empleSalario>3000;

	}

}
