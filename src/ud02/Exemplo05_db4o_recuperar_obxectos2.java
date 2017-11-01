package ud02;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Exemplo05_db4o_recuperar_obxectos2 {

	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersonas.yap";

	public static void main(final String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);
		// instancia un obxecto cos requisito, neste caso, con nome Isabel
		Person per = new Person(null, "Vigo");
		// pásallo como argumento a db.queryByExample
		ObjectSet<Person> resul = db.queryByExample(per);
		if (resul.size() == 0)
			System.out.println("NON existen Rexistros de persoas");
		else {
			System.out.println("Numero de Registros: " + resul.size());
			// recorrer los objetos
			while (resul.hasNext()) {
				Person p = resul.next();
				System.out.println("Nome: " + p.getName() + "\tCidade: " + p.getCity());
			} // fin while
		} // fin else
			// cerrar la base de datos
		db.close();
	}// fin main
}
