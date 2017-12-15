package ud02.db4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

//Recuperar todos los objetos de la base de datos
public class Exemplo02_db4o_percorrerDb4o {
	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersoas.yap";

	public static void main(String[] args) {
		// Abrir a bd
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);

		// Instanciamos un obxecto (cun valor a null, busca todos)
		Person p = new Person(null, null);

		// pasámollo como parámentro da procura
		// obtemos un conxunto de obxectos
		ObjectSet<Person> resultado = db.queryByExample(p);

		// filtra ao principio
		// usa o método size para obter o resultado.
		// se é 0, é que non hai datos.
		if (resultado.size() == 0)
			System.out.println("Non existen rexistros de persoas");
		else {
			System.out.println("Número de rexistros: " + resultado.size());

			// percorrer os obxectos
			while (resultado.hasNext()) {
				p = resultado.next();
				System.out.println("Nome: " + p.getName() + "\tCidade: " + p.getCity());
			} // fin while
		} // fin else

		// pecha a base de datos
		db.close();
	}// fin main
}// fin clase
