package ud02;
/*
 * Crea unha base de datos
 */
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Exemplo05_db4o_a {
	final static String BDPersona = "C:\\Users\\Alexandre\\Documents\\DAM\\db4o\\db4o-8.0\\BDPersonas.yap";

	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPersona);
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

class Person {
	private String name;
	private String city;

	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String nombre) {
		this.name = nombre;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String ciudad) {
		this.city = ciudad;
	}
}