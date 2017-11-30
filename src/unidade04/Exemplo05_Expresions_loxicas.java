package unidade04;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Not;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Exemplo05_Expresions_loxicas {
	static ODB odb = null;
	static IQuery query = null;
	static ICriterion criterio = null;
	static Objects<Empleado> empleados = null;

	public static void main(String[] args) {

		//listarEmpleadosVigo40Anhos();
		// listarEmpleadosVigo40Anhos2();
		 listarEmpleadosVigoNo();
		
	}

	/* MOSTRA OS EMPLEADOS QUE NON SON DE VIGO */
	private static void listarEmpleadosVigoNo() {
		odb = ODBFactory.open("neodatis.test");
		// SELECT * FROM Empleados WHERE NOT ciudad = 'Vigo'
		// SELECT * FROM Empleados WHERE ciudad <> 'Vigo'
		// operador lóxico new NOT(criteiro);
		criterio = new Not(Where.equal("ciudad", "Vigo"));
		// crear a consulta 
		query = odb.criteriaQuery(Empleado.class, criterio);
		// executar a consulta - devolve varios
		
		empleados = odb.getObjects(query);
		while (empleados.hasNext()) {
			// A cada paso de bucle mostra un empregado
			Empleado empleado = empleados.next();
			visualizarResultados(empleado);
		}
	
		odb.close();

	}

	private static void listarEmpleadosVigo40Anhos() {
		// SELECT * FROM Empleados ciudad = 'Vigo' OR 'Edad' = 40;
				odb = ODBFactory.open("neodatis.test");
				// operador lóxico OR ten a sintaxe And().add(criteiro).add(criterio-n));
				criterio = new And().add(Where.equal("ciudad", "Vigo")).add(Where.equal("edad", 40));
				// crear a consulta 
				query = odb.criteriaQuery(Empleado.class, criterio);
				// executar a consulta - devolve varios
				
				empleados = odb.getObjects(query);
				while (empleados.hasNext()) {
					// A cada paso de bucle mostra un empregado
					Empleado empleado = empleados.next();
					visualizarResultados(empleado);
				}
			
				odb.close();
		
	}

	private static void listarEmpleadosVigo40Anhos2() {
		// SELECT * FROM Empleados ciudad = 'Vigo' OR 'Edad' = 40;
		odb = ODBFactory.open("neodatis.test");
		
		ICriterion criterio1 = Where.equal("ciudad", "Vigo");
		ICriterion criterio2 = Where.ge("edad", 40);
		// operador lóxico and ten a sintaxe new Or().add(criteiro).add(criterio-n));
		criterio = new Or().add(criterio1).add(criterio2);
		
		// crear a consulta 
		query = odb.criteriaQuery(Empleado.class, criterio);
		// executar a consulta - devolve varios
		
		empleados = odb.getObjects(query);
		while (empleados.hasNext()) {
			// A cada paso de bucle mostra un empregado
			Empleado empleado = empleados.next();
			visualizarResultados(empleado);
		}
	
		odb.close();
	}

	private static void listadoempleados() {
		// SELECT * FROM Empleados
				// Abrimos a base de datos
				odb = ODBFactory.open("neodatis.test");
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
