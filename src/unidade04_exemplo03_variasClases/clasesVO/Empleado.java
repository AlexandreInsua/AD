package unidade04_exemplo03_variasClases.clasesVO;

public class Empleado {
	private int codEmpleado;
	private String nombre;
	private String puesto;
	private int salario; 
	private int comision;
	private Oficina oficina;

	
	public Empleado() {
		super();
	}
	public Empleado(int codEmpleado, String nombre, String puesto, int salario, int comision) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.comision = comision;
	}
	
	public Empleado(int codEmpleado, String nombre, String puesto, int salario, int comision, Oficina oficina) {
		super();
		this.codEmpleado = codEmpleado;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.comision = comision;
		this.oficina = oficina;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	
	public Oficina getOficina() {
		return oficina;
	}
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	@Override
	public String toString() {
		return nombre;
	}
}
