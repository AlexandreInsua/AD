package unidade04_exemplo02_variasClases;

public class Empleado {
	private int empleCodigo;
	private String empleNombre;
	private String emplePuesto;
	private int empleSalario; 
	private int empleComision;
	private Oficina oficina;
	
	public Empleado() {
		super();
	}
	
	public Empleado(int empleCodigo, String empleNombre, String emplePuesto, int empleSalario, int empleComision,
			Oficina oficina) {
		super();
		this.empleCodigo = empleCodigo;
		this.empleNombre = empleNombre;
		this.emplePuesto = emplePuesto;
		this.empleSalario = empleSalario;
		this.empleComision = empleComision;
		this.oficina= oficina;
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
	public Oficina getOficina() {
		return oficina ;
	}
	public void setOficina(Oficina departamento) {
		this.oficina = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [empleCodigo=" + empleCodigo + ", empleNombre=" + empleNombre + ", emplePuesto=" + emplePuesto
				+ ", empleSalario=" + empleSalario + ", empleComision=" + empleComision + ", oficina=" + oficina + "]";
	}

	
}
