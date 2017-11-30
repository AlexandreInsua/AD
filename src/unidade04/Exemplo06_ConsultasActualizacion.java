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

/* Para Actualizar os datos necesitamos facer dous pasos:
 * 1º recuperar o obxecto de disco á memoria.
 * 2º borrar o obxecto do disco.
 * 3º pechar base de datos
 */

/* eliminar -> delete()
 * insertar -> store()
 * modificar / actualizar -> recuperar - store()
 */
public class Exemplo06_ConsultasActualizacion {

	static ODB odb = null;
	static IQuery query = null;
	static ICriterion criterio = null;
	static Objects<Empleado> empleados = null;
	static String bd = "neodatis.test";

	public static void main(String[] args) {
		// consulta 1.- Actualiza a cidade de de Ana de Bilbao a Redondela
		// consulta01();

		// consulta 2.- Actualizar o soldo do empregados de Vigo en 500€
		// consulta02();

		listadoEmpleados();
		// consulta 3.- Elimina os empleados de Vigo
		consulta03();
		listadoEmpleados();
	}

	private static void consulta03() {
		// UPDATE Empleados SET sueldo = sueldo + 500 WHERE ciudad = 'Vigo
		odb = ODBFactory.open(bd);
		// establecemos o criterio
		criterio = Where.equal("ciudad", "Vigo");
		// establecemos a consulta
		query = odb.criteriaQuery(Empleado.class, criterio);
		// recuperamos o primeiro dos obxectos que cumpre a condición - devove vorios
		empleados = odb.getObjects(query);
		// actualizamos o dato dentro dun bucle
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			// Para borrar un obxecto debe estar en memoria
			odb.delete(empleado);
		}
		odb.close();

	}

	private static void consulta02() {
		// UPDATE Empleados SET sueldo = sueldo + 500 WHERE ciudad = 'Vigo
		odb = ODBFactory.open(bd);
		// establecemos o criterio
		criterio = Where.equal("ciudad", "Vigo");
		// establecemos a consulta
		query = odb.criteriaQuery(Empleado.class, criterio);
		// recuperamos o primeiro dos obxectos que cumpre a condición - devove vorios
		empleados = odb.getObjects(query);
		// actualizamos o dato dentro dun bucle
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			empleado.setSueldo(empleado.getSueldo() + 500);
			// actualizar modo store - (garda a bd)
			odb.store(empleado);
		}
		odb.close();
	}

	private static void consulta01() {
		// UPDATE Empleado SET ciudad = 'Redondela' WHERE nombre = 'Ana'
		odb = ODBFactory.open(bd);
		// establecemos o criterio
		criterio = Where.equal("nombre", "Ana");
		// establecemos a consulta
		query = odb.criteriaQuery(Empleado.class, criterio);
		// recuperamos o primeiro dos obxectos que cumpre a condición - devolve varias
		Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
		// actualizamos o dato
		empleado.setCiudad("Redondela");

		// actualizar modo store - (garda a bd)
		odb.store(empleado);

		odb.close();

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
