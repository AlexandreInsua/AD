package ud02ex;

public class Cliente {

	private int idCliente = 0;
	private String nombre = null;
	private String direccion = null;
	private String poblacion = null;
	private String telefono = null;
	private String nif = null;
	
	public Cliente(int idCliente, String nombre, String direccion, String poblacion, String telefono, String nif) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.nif = nif;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getNif() {
		return nif;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	@Override
	public String toString() {
		return idCliente + ", "+ nombre + ", " + direccion + ", "
				+ poblacion + ", " + telefono + ", " + nif;
	}
	
	
}
