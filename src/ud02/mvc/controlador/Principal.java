package ud02.mvc.controlador;

import ud02.mvc.modelo.Loxica;
import ud02.mvc.vista.VentanaBuscar;
import ud02.mvc.vista.VentanaNuevo;
import ud02.mvc.vista.VentanaPrincipal;

public class Principal {

	Loxica miLogica;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaNuevo miVentanaRegistro;
	Coordinador miCoordinador;
	public static void main(String[] args) {
	Principal miPrincipal=new Principal();
	miPrincipal.iniciar();
	}
	/**
	* Permite instanciar todas las clases con las que trabaja
	* el sistema
	*/
	private void iniciar() {
	/*Se instancian las clases*/
	miVentanaPrincipal=new VentanaPrincipal();
	miVentanaRegistro=new VentanaNuevo();
	miVentanaBuscar= new VentanaBuscar();
	miLogica=new Loxica();
	miCoordinador= new Coordinador();
	/*Se establecen las relaciones entre clases*/
	miVentanaPrincipal.setCoordinador(miCoordinador);
	miVentanaRegistro.setCoordinador(miCoordinador);
	miVentanaBuscar.setCoordinador(miCoordinador);
	miLogica.setCoordinador(miCoordinador);
	
	/*Se establecen relaciones con la clase coordinador*/
	miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
	miCoordinador.setMiVentanaRegistro(miVentanaRegistro);
	miCoordinador.setMiVentanaBuscar(miVentanaBuscar);
	miCoordinador.setMiLogica(miLogica);
	miVentanaPrincipal.setVisible(true);
	}
	}

