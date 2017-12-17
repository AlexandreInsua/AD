package ud02ex;

public class Productos {

	private int idNumerico = 0;
	private String descricion = null;
	private int stockActual = 0;
	private int stockMinimo = 0;
	private double precio = 0.0;
	
	public Productos(int idNumerico, String descricion, int stockActual, int stockMinimo, double precion) {
		this.idNumerico = idNumerico;
		this.descricion = descricion;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.precio = precion;
	}
	public int getIdNumerico() {
		return idNumerico;
	}
	public String getDescricion() {
		return descricion;
	}
	public int getStockActual() {
		return stockActual;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	public double getPrecion() {
		return precio;
	}
	public void setIdNumerico(int idNumerico) {
		this.idNumerico = idNumerico;
	}
	public void setDescricion(String descricion) {
		this.descricion = descricion;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	public void setPrecion(double precion) {
		this.precio = precion;
	}
	@Override
	public String toString() {
		return idNumerico + ", " + descricion + ", " + stockActual
				+ ", " + stockMinimo + ", " + precio;
	}
	
	
	
}
