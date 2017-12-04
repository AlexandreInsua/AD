package unidade04_exemplo02_variasClases;

public class Departamento {
	private int deparCodigo;
	private String deparNombre;
	private String deparCiudad;
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departamento(int deparCodigo, String deparNombre, String deparCiudad) {
		super();
		this.deparCodigo = deparCodigo;
		this.deparNombre = deparNombre;
		this.deparCiudad = deparCiudad;
	}
	public int getDeparCodigo() {
		return deparCodigo;
	}
	public void setDeparCodigo(int deparCodigo) {
		this.deparCodigo = deparCodigo;
	}
	public String getDeparNombre() {
		return deparNombre;
	}
	public void setDeparNombre(String deparNombre) {
		this.deparNombre = deparNombre;
	}
	public String getDeparCiudad() {
		return deparCiudad;
	}
	public void setDeparCiudad(String deparCiudad) {
		this.deparCiudad = deparCiudad;
	}
}
