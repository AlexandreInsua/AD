package ud02.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/* Exemplo que garda varios obxectos nunha base db4o de exemplo */

public class Exemplo01_db4o_creaDB4o {

	// Exemplo de base creada canda o executable
	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersoas.yap";

	// Exemplo de base no proxecto
	final static String BDPersona2 = "BDPersoas.yap";

	public static void main(String[] args) {

		// Crea a base de datos se non existe
		// Abre a base de datos se existe
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona2);
		// Creamos Personas
		Person p1 = new Person("Beatriz", "Eibar");
		Person p2 = new Person("Iciar", "Deba");
		Person p3 = new Person("Santiago", "Vigo");
		Person p4 = new Person("Isabel", "Madrid");

		// Almacenar os obxectos da clase Person na base de datos
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);
		// Pecha a base de datos
		db.close();
	}
}
