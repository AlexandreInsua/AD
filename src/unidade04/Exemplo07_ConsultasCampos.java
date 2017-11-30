package unidade04;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/*
 * As consultas de selección de campo e as sentenzas de agrupacións usa interfaces diferentes que as anteriores.
 */
public class Exemplo07_ConsultasCampos {

	public static void main(String[] args) {

		listadoEmpleados();
		listadoEmpleados();
	}

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

	private static void visualizarResultados(Empleado empleado) {
		System.out.println(("Empleado: " + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion() + "\t"
				+ empleado.getCiudad() + "\t" + empleado.getSueldo() + "\t" + empleado.getEdad()));
	}
}