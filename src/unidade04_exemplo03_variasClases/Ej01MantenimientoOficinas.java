package unidade04_exemplo03_variasClases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import unidade04_exemplo02_variasClases.Ejemplo01ActualizacionVariasTablas;
import unidade04_exemplo03_variasClases.clasesVO.Oficina;

public class Ej01MantenimientoOficinas {
	static ODB odb = null;
	static IQuery query = null;

	public static void nuevaOficina() {

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		short auxCodigo;
		System.out.println("\nInsertar los datos de la OFICINA. ");

		// mientras el código sea distinto de cero seguimos insertando
		while ((auxCodigo = Short.parseShort(Ej01Main.introducirDatos("Código de oficina <0 Para finalizar"))) != 0) {

			// Consulta de comprobación se o código existe devolve false
			if (comprobarExistenciaOficina(auxCodigo, odb)) {
				// se a oficina non existe, créamola
				Oficina oficina = new Oficina();
				oficina = crearOficina(auxCodigo, oficina);
				odb.store(oficina);
			} else {

			}

		}

		// cerramos la base de datos
		odb.close();

	}// fin nuevaOficina

	public void actualizarOficina() {

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		// insertamos el codigo de la oficina a actualizar
		short auxCodigo;

		// mientras el código sea distinto de 0 seguimos actualizando

		// cierra la base de datos para validar los cambios
		odb.close();

	} // fin actualizarOficina

	public void consultarOficina() {

		// Consultar oficinas por código
		// SELECT * FROM Oficina WHERE codigo = ?;

		// abrir la base de datos
		odb = ODBFactory.open("Empleados.neodatis");

		// insertamos el codigo de la oficina a consultar
		short auxCodigo;

		// mientras el código sea distinto de 0 seguimos consultando
		while ((auxCodigo = Short.parseShort(Ej01Main.introducirDatos("Código: <0 para sair>"))) != 0) {
			// crear a consulta
			query = new CriteriaQuery(Oficina.class, Where.equal("codigo", auxCodigo));
			try {
				Oficina oficina = (Oficina) odb.getObjects(query).getFirst();
				visualizarOficina(oficina);
			} catch (IndexOutOfBoundsException e) {
				System.out.println(auxCodigo + "Non existe");
			}
		}
		// cierra la base de datos para validar los cambios
		odb.close();

	}// fin consultarOficina

	public void eliminarOficina() {
		// Eliminar oficinas por código
		// DELETE FROM Oficina WHERE codigo = ?;

		// abrir la base de datos
		odb = ODBFactory.open("Empleados.neodatis");

		// insertamos el codigo de la oficina a eliminar
		short auxCodigo;
		// mientras el código sea distinto de 0 seguimos eliminando

		while ((auxCodigo = Short.parseShort(Ej01Main.introducirDatos("Código: <0 para sair>"))) != 0) {
			// crear a consulta
			query = new CriteriaQuery(Oficina.class, Where.equal("codigo", auxCodigo));
			try {
				Oficina oficina = (Oficina) odb.getObjects(query).getFirst();
				visualizarOficina(oficina);
				if (Ej01Main.introducirDatos("Eliminar S/").equalsIgnoreCase("S")) {
					odb.delete(oficina);
				}

			} catch (IndexOutOfBoundsException e) {
				System.out.println(auxCodigo + "Non existe");
			}
		}

		// cierra la base de datos para validar los cambios
		odb.close();

	}// fin eliminarOficina

	public void listarOficina() {

		// Abrimos la base de datos, si no existe la crea
		odb = ODBFactory.open("Empleados.neodatis");

		// recuperamos todos los objetos
		Objects<Oficina> oficinas = odb.getObjects(Oficina.class);

		// visualizar las oficinas
		while (oficinas.hasNext()) {
			Oficina oficina = oficinas.next();
			visualizarOficina(oficina);
		}

		// cerramos la base de datos
		odb.close();

	}// fin listarOficina

	public static boolean comprobarExistenciaOficina(short auxCodigo, ODB odb) {

		// crea la consulta

		query = new CriteriaQuery(Oficina.class, Where.equal("codigo", auxCodigo));
		// úsase un try-catch para controlar a esxitendia

		try {
			Oficina oficina = (Oficina) odb.getObjects(query).getFirst();
			System.out.println(auxCodigo + "existe.");
			return false;
		} catch (IndexOutOfBoundsException ioobe) {
			// non encontrou o código polo que devolve verdadeiro
			return true;

		}
	}// fin comprobarExistenciaOficina

	public static Oficina comprobarExistenciaOficina01(short auxCodigo, ODB odb) {

		// crea la consulta
		query = new CriteriaQuery(Oficina.class, Where.equal("codigo", auxCodigo));
		try {
			Oficina oficina = (Oficina) odb.getObjects(query).getFirst();
			visualizarOficina(oficina);
			return oficina;
		} catch (Exception e) {
			return null; 
		}

	}// fin comprobarExistenciaOficina

	public static Oficina crearOficina(short auxCodigo, Oficina oficina) {

		oficina.setCodigo(auxCodigo);
		oficina.setLocalidad(Ej01Main.introducirDatos("localidade: "));
		oficina.setOficina(Ej01Main.introducirDatos("nombre: "));

		return oficina;
	}// fin crearOficina

	private static void visualizarOficina(Oficina oficina) {
		System.out.println(oficina.getCodigo() + "\t" + oficina.getLocalidad() + "\t" + oficina.getOficina());

	}// fin visualizarOficina
}
