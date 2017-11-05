package ud02.mvc.modelo;

import javax.swing.JOptionPane;
import ud02.mvc.vo.PersoaVo;
import ud02.mvc.dao.PersoaDao;
import ud02.mvc.controlador.Coordinador;

public class Loxica {
	@SuppressWarnings("unused")
	private Coordinador miCoordinador;
	public static boolean consultaPersona = false;
	public static boolean modificaPersona = false;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	public void validarRegistro(PersoaVo miPersona) {
		PersoaDao miPersonaDao;
		if (miPersona.getIdPersoa() > 99) {
			miPersonaDao = new PersoaDao();
			miPersonaDao.inserirPersoa(miPersona);
		} else {
			JOptionPane.showMessageDialog(null, "El documento de la persona debe ser mas de 3 digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public PersoaVo validarConsulta(String codigoPersona) {
		PersoaDao miPersonaDao;
		try {
			int codigo = Integer.parseInt(codigoPersona);
			if (codigo > 99) {
				miPersonaDao = new PersoaDao();
				consultaPersona = true;
				return miPersonaDao.buscarPersona(codigo);
			} else {
				JOptionPane.showMessageDialog(null, "El documento de la persona debe ser mas de 3 digitos",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				consultaPersona = false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaPersona = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaPersona = false;
		}
		return null;
	}

	public void validarModificacion(PersoaVo miPersona) {
		PersoaDao miPersonaDao;
		if (miPersona.getNome().length() > 5) {
			miPersonaDao = new PersoaDao();
			miPersonaDao.modificarPersona(miPersona);
			modificaPersona = true;
		} else {
			JOptionPane.showMessageDialog(null, "El nombre de la persona debe ser mayor a 5 	digitos", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
			modificaPersona = false;
		}
	}

	public void validarEliminacion(String codigo) {
		PersoaDao miPersonaDao = new PersoaDao();
		miPersonaDao.eliminarPersona(codigo);
	}
}
