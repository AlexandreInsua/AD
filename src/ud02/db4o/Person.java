package ud02.db4o;

public class Person {
	private String name;
	private String city;

	/* Clase que � o obxecto que manexa a aplicaci�n 
	 * Necesita getters e setters */
	
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