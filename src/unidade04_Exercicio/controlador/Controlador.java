package unidade04_Exercicio.controlador;

import unidade04_Exercicio.Vistas.*;

public class Controlador {
	VentanaClientes ventanaClientes = null;

	// TODO BORRAR
	public static void main(String[] args) {
		Controlador c = new Controlador();
		c.mostrarVentanaClientes();

	}

	public void mostrarVentanaClientes() {
		ventanaClientes = new VentanaClientes();
		ventanaClientes.setVisible(true);
	}
}
