package ud02ex;

import java.sql.Date;

public class Venta {

	private int idVenta = 0;
	private Date fechaVenta = null;
	private int idCliente = 0;
	private int idProducto = 0;
	private int cantidad = 0;

	public Venta(int idVenta, Date fechaVenta, int idCliente, int idProducto, int cantidad) {
		this.idVenta = idVenta;
		this.fechaVenta = fechaVenta;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return idVenta + ", " + fechaVenta + ", " + idCliente + ", " + idProducto + ", " + cantidad;
	}

}
