package unidade04_exemplo02_variasClases;

public class Empleado {
	private int empleCodigo;
	private String empleNombre;
	private String emplePuesto;
	private int empleSalario; 
	private int empleComision;
	private Departamento departamento;
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Empleado(int empleCodigo, String empleNombre, String emplePuesto, int empleSalario, int empleComision,
			Departamento departamento) {
		super();
		this.empleCodigo = empleCodigo;
		this.empleNombre = empleNombre;
		this.emplePuesto = emplePuesto;
		this.empleSalario = empleSalario;
		this.empleComision = empleComision;
		this.departamento = departamento;
	}
	public int getEmpleCodigo() {
		return empleCodigo;
	}
	public void setEmpleCodigo(int empleCodigo) {
		this.empleCodigo = empleCodigo;
	}
	public String getEmpleNombre() {
		return empleNombre;
	}
	public void setEmpleNombre(String empleNombre) {
		this.empleNombre = empleNombre;
	}
	public String getEmplePuesto() {
		return emplePuesto;
	}
	public void setEmplePuesto(String emplePuesto) {
		this.emplePuesto = emplePuesto;
	}
	public int getEmpleSalario() {
		return empleSalario;
	}
	public void setEmpleSalario(int empleSalario) {
		this.empleSalario = empleSalario;
	}
	public int getEmpleComision() {
		return empleComision;
	}
	public void setEmpleComision(int empleComision) {
		this.empleComision = empleComision;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
}
