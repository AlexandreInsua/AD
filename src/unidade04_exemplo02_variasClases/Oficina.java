package unidade04_exemplo02_variasClases;

public class Oficina {
 private short codigo;
 private String nombreOficina;
 private String localidad;

 public Oficina() {
	super();
}

public Oficina(short codigo, String nombreOficina, String localidad) {
	super();
	this.codigo = codigo;
	this.nombreOficina = nombreOficina;
	this.localidad = localidad;
}

public short getCodigo() {
	return codigo;
}

public void setCodigo(short codigo) {
	this.codigo = codigo;
}

public String getNombreOficina() {
	return nombreOficina;
}

public void setNombreOficina(String nombreOficina) {
	this.nombreOficina = nombreOficina;
}

public String getLocalidad() {
	return localidad;
}

public void setLocalidad(String localidad) {
	this.localidad = localidad;
}

@Override
public String toString() {
	return "Oficina [codigo=" + codigo + ", nombreOficina=" + nombreOficina + ", localidad=" + localidad + "]";
}
 
 
 
}
