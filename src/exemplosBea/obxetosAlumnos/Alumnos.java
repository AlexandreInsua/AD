package exemplosBea.obxetosAlumnos;

import java.io.Serializable;

public class Alumnos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String direccion;
	private int edad;
	
	public Alumnos() {
		super();
	}

	public Alumnos(String nombre, String direccion, int edad) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return nombre + ", " + direccion + ", " + edad;
	}
}
