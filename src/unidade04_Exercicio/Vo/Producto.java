package unidade04_Exercicio.Vo;

public class Producto {

	private int idProducto;
	private String descripcion;
	private double pvp;
	private int stockActual;
	private int stockMinimo;
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(int idProducto, String descripcion, double pvp, int stockActual, int stockMinimo) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", pvp=" + pvp + ", stockActual="
				+ stockActual + ", stockMinimo=" + stockMinimo + "]";
	}
	
	
}
