package ud02.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/* Exemplo que mostra como se modifica un obxecto */

public class Exemplo05_db4o_modifica_rexistro {

	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersoas.yap";

	/* Para modificar un obxecto hai que localizalo e despois modifícase  con store().
	O siguinte exemplo modifica a cidade de Isabel a Cádiz y logo visualiza os seus datos:
	*/
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);
		// Recuperar todos os obxetos con nome Isabel
		Person per = new Person("Isabel", null);
		ObjectSet<Person> resul = db.queryByExample(per);

		// se hai varios obxectos a borrar
		// recorremos o resutado cun while

		// if (resul.size() > 1) {
		// while (resul.hasNext()) {
		// Person p = resul.next();
		// db.setAtribute(... );
		// System.out.println("Modificado ...."); }

		if (resul.size() == 0)
			System.out.println("Non existe Isabel");
		else {
			// devolve o obxecto con nome Isabel
			Person existe = (Person) resul.next();
			existe.setCity("Cádiz");
			// escribimos na base de datos
			db.store(existe); // ciudad modificada
			// consultar os datos dos obxectos con nome Isabel
			resul = db.queryByExample(per);
			existe = resul.next();
			System.out.println("Nome: " + existe.getName() + "\tCidade: " + existe.getCity());
		} // fin else
			// pechar a base de datos
		db.close();
	}// fin main
}

