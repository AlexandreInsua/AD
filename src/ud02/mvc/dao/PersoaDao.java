package ud02.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ud02.mvc.modelo.Conexion;
import ud02.mvc.vo.PersoaVo;

/*
 * Clase que permite o acceso á base de datos
 */
public class PersoaDao {

	public void inserirPersoa(PersoaVo miPersona) {
		Conexion conexion = new Conexion();

		try {
			/*
			 * Statement estatuto = conex.getConnection().createStatement();
			 * estatuto.executeUpdate("INSERT INTO personas VALUES
			 * ('"+miPersona.getIdPersona()+"', '" +miPersona.getNombre()+"',
			 * '"+miPersona.getEdad()+"', '" +miPersona.getProfesion()+"',
			 * '"+miPersona.getTelefono()+"')");
			 */
			String consulta = "INSERT INTO Personas VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = conexion.getConnection().prepareStatement(consulta);
			ps.setInt(1, miPersona.getIdPersoa());
			ps.setString(2, miPersona.getNome());
			ps.setInt(3, miPersona.getIdade());
			ps.setString(4, miPersona.getProfesion());
			ps.setInt(5, miPersona.getTelefono());
			@SuppressWarnings("unused")
			int filas = ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Inserción correcta", "Información", JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Guardo");
		}
	}

	public PersoaVo buscarPersona(int codigo) {
		Conexion conex = new Conexion();
		PersoaVo persona = new PersoaVo();
		boolean existe = false;
		try {
			String consulta = "SELECT * FROM personas where id = ? ";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setInt(1, codigo);
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				existe = true;
				persona.setIdPersoa(Integer.parseInt(res.getString("id")));
				persona.setNome(res.getString("nombre"));
				persona.setIdade(Integer.parseInt(res.getString("edad")));
				persona.setProfesion(res.getString("profesion"));
				persona.setTelefono(Integer.parseInt(res.getString("telefono")));
			}
			res.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}
		if (existe) {
			return persona;
		} else
			return null;
	}

	public void modificarPersona(PersoaVo miPersona) {
		Conexion conex = new Conexion();
		try {
			String consulta = "UPDATE personas SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? "
					+ "WHERE id= ? ";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setInt(1, miPersona.getIdPersoa());
			ps.setString(2, miPersona.getNome());
			ps.setInt(3, miPersona.getIdade());
			ps.setString(4, miPersona.getProfesion());

			ps.setInt(5, miPersona.getTelefono());
			ps.setInt(6, miPersona.getIdPersoa());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, " Se ha	Modificado Correctamente ", "Confirmación",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Error al 	Modificar", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void eliminarPersona(String codigo) {
		Conexion conex = new Conexion();
		try {
			/*
			 * Statement estatuto = conex.getConnection().createStatement();
			 * estatuto.executeUpdate("DELETE FROM persona WHERE
			 * id='"+codigo+"'");
			 */
			String consulta = "DELETE FROM personas WHERE id= 	?";
			PreparedStatement ps = conex.getConnection().prepareStatement(consulta);
			ps.setInt(1, Integer.parseInt(codigo));
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			ps.close();
			conex.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se 	Elimino");
		}
	}
}
