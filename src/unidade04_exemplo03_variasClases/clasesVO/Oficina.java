package unidade04_exemplo03_variasClases.clasesVO;

public class Oficina {
	private short codigo;
	private String nombreOficina;
	private String localidad;
	
	
	public Oficina() {
		super();
	}

	public Oficina(short codigo, String oficina, String localidad) {
		super();
		this.codigo = codigo;
		this.nombreOficina = oficina;
		this.localidad = localidad;
	}

	public short getCodigo() {
		return codigo;
	}

	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}

	public String getOficina() {
		return nombreOficina;
	}

	public void setOficina(String oficina) {
		this.nombreOficina = oficina;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return nombreOficina;
	}

}
