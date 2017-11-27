package unidade04;

public class Empleado {
	private String nombre;
	private String direccion;
	private String ciudad;
	private int sueldo;
	private int edad;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, String direccion, String ciudad, int sueldo, int edad) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.sueldo = sueldo;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public int getSueldo() {
		return sueldo;
	}
	public int getEdad() {
		return edad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", sueldo=" + sueldo
				+ ", edad=" + edad + "]";
	}


}