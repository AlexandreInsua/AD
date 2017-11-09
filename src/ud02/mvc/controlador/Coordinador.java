package ud02.mvc.controlador;

import ud02.mvc.modelo.Loxica;
import ud02.mvc.vista.VentanaBuscar;
import ud02.mvc.vista.VentanaNuevo;
import ud02.mvc.vista.VentanaPrincipal;
import ud02.mvc.vo.PersoaVo;

public class Coordinador {

	private Loxica miLogica = new Loxica();
	private VentanaPrincipal miVentanaPrincipal = null;
	private VentanaNuevo miVentanaRegistro = null;
	private VentanaBuscar miVentanaBuscar = null;

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		miVentanaPrincipal = new VentanaPrincipal();
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaNuevo getMiVentanaRegistro() {
		return miVentanaRegistro;
	}

	public void setMiVentanaRegistro(VentanaNuevo miVentanaRegistro) {
		miVentanaRegistro = new VentanaNuevo();
		this.miVentanaRegistro = miVentanaRegistro;
	}

	public VentanaBuscar getMiVentanaBuscar() {
		return miVentanaBuscar;
	}

	public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
		miVentanaBuscar = new VentanaBuscar();
		this.miVentanaBuscar = miVentanaBuscar;
	}

	public Loxica getMiLogica() {
		return miLogica;
	}

	public void setMiLogica(Loxica miLogica) {
		this.miLogica = miLogica;
	}

	//////////////////////////////////////////////////////////
	public void mostrarVentanaRegistro() {
		
		miVentanaRegistro.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);
	}

	public void registrarPersona(PersoaVo miPersona) {
		miLogica.validarRegistro(miPersona);
	}

	public PersoaVo buscarPersona(String codigoPersona) {
		return miLogica.validarConsulta(codigoPersona);
	}

	public void modificarPersona(PersoaVo miPersona) {
		miLogica.validarModificacion(miPersona);
	}

	public void eliminarPersona(String codigo) {
		miLogica.validarEliminacion(codigo);
	}

	public void ocultarVentanaNuevo() {
	
		miVentanaRegistro.setVisible(false);
		
	}

}
