package unidade04_Exercicio;

import java.sql.Date;

public class Venta {

	private int idVenta;
	private Cliente cliente;
	private Date fechaVenta;
	private Producto producto;
	private int cantidad;
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(int idVenta, Cliente cliente, Date fechaVenta, Producto producto, int cantidad) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", cliente=" + cliente + ", fechaVenta=" + fechaVenta + ", producto="
				+ producto + ", cantidad=" + cantidad + "]";
	}
	
	
}
