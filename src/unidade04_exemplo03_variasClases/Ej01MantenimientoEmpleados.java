package unidade04_exemplo03_variasClases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import unidade04_exemplo03_variasClases.clasesVO.Empleado;
import unidade04_exemplo03_variasClases.clasesVO.Oficina;

public class Ej01MantenimientoEmpleados {

	static ODB odb = null;
	static IQuery query = null;

	static Ej01MantenimientoOficinas manOficinas = new Ej01MantenimientoOficinas();

	public static void listarEmpleados() {

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		// recuperamos todos los objetos
		Objects<Empleado> empleados = odb.getObjects(Empleado.class);

		// visualizar los empleados
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			visualizarEmpleado(empleado);
		}

		// cerramos la base de datos
		odb.close();

	}// fin listarEmpleados

	public static void eliminarEmpleado() {
		// Eliminar empleados por código
		// DELETE FROM Empleado WHERE codEmpleado = ?;

		// abrir la base de datos
		odb = ODBFactory.open("Empleados.neodatis");

		// insertamos el codigo del empleado a eliminar
		int auxCodigo;

		// mientras el código sea distinto de cero seguimos eliminando
		System.out.println("\nInsertar los datos del Empleado. ");
		// mientras el código sea distinto de cero seguimos insertando
		while ((auxCodigo = Short.parseShort(Ej01Main.introducirDatos("Código: <0 para sair>"))) != 0) {
			// comprobar empleado devolve true cando non existe
			if (comprobarExistenciaEmpleado(auxCodigo, odb)) {

			} else {

				// crear a consulta
				query = new CriteriaQuery(Empleado.class, Where.equal("codigo", auxCodigo));
				try {
					Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
					visualizarEmpleado(empleado);

					if (Ej01Main.introducirDatos("Eliminar, S/N").equalsIgnoreCase("S")) {
						odb.delete(empleado);
					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println("Empregado " + auxCodigo + " non existe");

				}
			}
		}

		// cierra la base de datos para validar los cambios
		odb.close();

	}// eliminarEmpleado

	public static void visualizarEmpleado(Empleado empleado) {
		System.out.println(empleado.getCodEmpleado() + "\t" + empleado.getNombre() + "\t" + empleado.getPuesto()
				+ "\t\t\t" + empleado.getSalario() + "\t" + empleado.getComision() + "\t" + empleado.getOficina());

	}

	public static void consultarEmpleado() {
		// Consultar empleados por código
		// SELECT * FROM Empleado WHERE codEmpleado = ?;

		// abrir la base de datos
		odb = ODBFactory.open("Empleados.neodatis");

		// insertamos el codigo del empleado a consultar
		int auxCodigo;

		// mientras el código sea distinto de cero seguimos consultando
		while ((auxCodigo = Short.parseShort(Ej01Main.introducirDatos("Código: <0 para sair>"))) != 0) {

			// crear a consulta
			query = new CriteriaQuery(Empleado.class, Where.equal("codigo", auxCodigo));
			try {
				Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
				visualizarEmpleado(empleado);

			} catch (IndexOutOfBoundsException ioobe) {
				System.out.println(auxCodigo + "Non existe");
			}
		}

	}

	public static void actualizarEmpleado() {
		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		// insertamos el codigo del empleado a actualizar
		int auxCodigo;

		// mientras el código sea distinto de cero seguimos actualizando

		// cierra la base de datos para validar los cambios
		odb.close();
	}// fin actualizarEmpleado

	public static void nuevoEmpleado() {

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		int auxCodigo;
		System.out.println("\nInsertar los datos del Empleado. ");
		// mientras el código sea distinto de cero seguimos insertando
		while ((auxCodigo = Short.parseShort(Ej01Main.introducirDatos("Código: <0 para sair>"))) != 0) {
			// comprobar empleado devolve true cando non existe
			if (comprobarExistenciaEmpleado(auxCodigo, odb)) {
				Empleado empleado = new Empleado();
				empleado = crearEmpleado(auxCodigo, empleado, odb);
				odb.store(empleado);
			} else {
			}

			// crear a consulta
			query = new CriteriaQuery(Oficina.class, Where.equal("codigo", auxCodigo));
			try {

			} catch (IndexOutOfBoundsException e) {

			}
		}

		// cerramos la base de datos
		odb.close();

	}// fin nuevoEmpleado

	public static Empleado crearEmpleado(int auxCodigo, Empleado empleado, ODB odb) {

		empleado.setCodEmpleado(auxCodigo);
		empleado.setNombre(Ej01Main.introducirDatos("Nombre: "));
		empleado.setPuesto(Ej01Main.introducirDatos("Puesto: "));
		empleado.setSalario(Integer.parseInt(Ej01Main.introducirDatos("Salario: ")));
		empleado.setComision(Integer.parseInt(Ej01Main.introducirDatos("Comisión: ")));

		short codOficina = Short.parseShort(Ej01Main.introducirDatos("Código de oficina: "));
		// comprobar se a oficina exists
		Oficina oficina = manOficinas.comprobarExistenciaOficina01(codOficina, odb);

		if (oficina != null) {
			// a oficina existe, pasámoslla como argumento
			System.out.println("Oficina: " + oficina);
			empleado.setOficina(oficina);
		} else {
			// se non existe, creámola
			oficina = new Oficina();
			manOficinas.crearOficina(codOficina, oficina);
		}

		return empleado;

	}// fin crearEmpleado

	public static boolean comprobarExistenciaEmpleado(int auxCodigo, ODB odb) {

		// Crear a consulta
		query = new CriteriaQuery(Empleado.class, Where.equal("codEmpleado", auxCodigo));
		try {
			Empleado empleado = (Empleado) odb.getObjects(query).getFirst();
			System.out.println(auxCodigo + "Xa existe");
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
