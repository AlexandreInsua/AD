package ud02.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/*
 * Exemplo que mostra os obxectos Person cuxa cidade é Vigo
 */
public class Exemplo04_db4o_recuperar_obxectos_criterio {

	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersoas.yap";
	
	// Exemplo de base no proxecto
	final static String BDPersona2 = "BDPersoas.yap";
	
	static Person p;

	public static void main(final String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona2);
		// instancia un obxecto cos requisito, neste caso, con cidade Vigo
		p = new Person(null, "Vigo");
		// pásallo como argumento a db.queryByExample
		ObjectSet<Person> resul = db.queryByExample(p);
		if (resul.size() == 0)
			System.out.println("Non existen Rexistros de persoas");
		else {
			System.out.println("Número de rexistros: " + resul.size());
			// recorrer los objetos
			while (resul.hasNext()) {
				p = resul.next();
				System.out.println("Nome: " + p.getName() + "\tCidade: " + p.getCity());
			} // fin while
		} // fin else
			// cerrar la base de datos
		db.close();
	}// fin main
}
