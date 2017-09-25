package UD01;

import java.io.Serializable;

public class Persoa implements Serializable {

	/**
	 * 
	 */
	// Engade un id único
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;

	public Persoa(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public Persoa() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
