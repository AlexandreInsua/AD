package ud02.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/* 
 * Exemplo que mostra os obxectos cuxo nome � 'Isabel'
 */
public class Exemplo03_db4o_recuperar_obxectos_criterio {

	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersoas.yap";

	public static void main(final String[] args) {
		Person p;
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);

		// instancia un obxecto cos requisitos,
		// neste caso, con nome Isabel
		p = new Person("Isabel", null);
		// p�sallo como argumento a db.queryByExample
		ObjectSet<Person> resultado = db.queryByExample(p);
		if (resultado.size() == 0)
			System.out.println("Non existen Rexistros de persoas");
		else {
			System.out.println("Numero de Registros: " + resultado.size());
			// recorrer los objetos
			while (resultado.hasNext()) {
				p = resultado.next();
				System.out.println("Nome: " + p.getName() + "\tCidade: " + p.getCity());
			} // fin while
		} // fin else

		// pecha a base de datos
		db.close();
	}// fin main
}
