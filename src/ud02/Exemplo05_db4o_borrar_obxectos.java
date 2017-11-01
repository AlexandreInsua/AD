package ud02;

/* Para eliminar obxectos utilizamos delete(), antes de eliminar cómpre localizar o 
obxecto que eliminar.

 O seguinte exemplo elimina os objxectos cuxo nome sexa Beatriz:
*/
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

//Eliminar os objetos de nome Beatriz
public class Exemplo05_db4o_borrar_obxectos {
	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersonas.yap";

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);
		Person per = new Person("Beatriz", null);
		ObjectSet<Person> resul = db.queryByExample(per);
		if (resul.size() == 0)
			System.out.println("Non existe Beatriz");
		else {
			// Recupera o rexistro encontrado
			Person existe = resul.next();
			System.out.println("Rexistros a borrar: " + resul.size());
			if (resul.size() > 1) { // se hai varios obxectos a borrar
				// varios rexistros a borrar recorremos resul
				while (resul.hasNext()) {
					Person p = resul.next();
					db.delete(p);
					System.out.println("Borrado....");
				} // fin while
			}
			// só un obxecto a borrar ou borra o primeiro
			db.delete(existe);
		} // fin else
			// pechar a base de datos
		db.close();
	}
}
