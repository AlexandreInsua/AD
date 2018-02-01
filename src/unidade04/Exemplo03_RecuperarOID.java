package unidade04;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.Objects;

public class Exemplo03_RecuperarOID {
	public static void main(String[] args) {
		// Abre a bd (se non existe a crea)
		ODB odb = ODBFactory.open("neodatis.test");
		
		// Recuperamos todos os obxectos devolve un SET de resultados
		Objects<Empleado> empleados = odb.getObjects(Empleado.class);
		
		System.out.println(empleados.size() + " Empleados");
		
		// Visualizar os empleados
		while (empleados.hasNext()) {
			Empleado empleado = empleados.next();
			// Recuperamos o OID do obxecto as dúas liñas obteñen o mesmo
			// resultado

			// OID oid = odb.store(empleado);
			OID oid = odb.getObjectId(empleado);
			
			System.out.println(("oid: " + oid + " Empleado: " + "\t" + empleado.getNombre() + "\t" + empleado.getDireccion() + "\t"
					+ empleado.getCiudad() + "\t" + empleado.getSueldo() + "\t" + empleado.getEdad()));
		}
		
		// Recuperando 
		
		odb.close();
	}
}