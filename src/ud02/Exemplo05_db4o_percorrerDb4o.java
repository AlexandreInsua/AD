package ud02;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

//Recuperar todos los objetos de la base de datos
public class Exemplo05_db4o_percorrerDb4o {
	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersonas.yap";

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);
		Person per = new Person(null, null);
		ObjectSet<Person> resul = db.queryByExample(per);

		// filtra ao principio
		if (resul.size() == 0)
			System.out.println("Non existen Rexistros de persoas");
		else {
			System.out.println("Número de rexistros: " + resul.size());
			// recorrer os objetos
			while (resul.hasNext()) {
				Person p = resul.next();
				System.out.println("Nome: " + p.getName() + "\tCidade: " + p.getCity());
			} // fin while
		} // fin else
			// pecha a base de datos
		db.close();
	}// fin main
}
