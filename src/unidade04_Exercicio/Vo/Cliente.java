package unidade04_Exercicio.Vo;

public class Cliente {

	private String nif;
	private String nombre;
	private String poblacion;
	private int	codPostal;
	private String provincia;
	private int telefono;
	private String email;
	
	
	public Cliente() {
		super();
	
	}


	public Cliente(String nif, String nombre, String poblacion, int codPostal, String provincia, int telefono,
			String email) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.telefono = telefono;
		this.email = email;
	}


	public String getNif() {
		return nif;
	}


	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public int getCodPostal() {
		return codPostal;
	}


	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Cliente [nif=" + nif + ", nombre=" + nombre + ", poblacion=" + poblacion + ", codPostal=" + codPostal
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", email=" + email + "]";
	}
	
	
	
}
