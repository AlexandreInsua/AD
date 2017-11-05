package ud02.mvc.vo;

/*
 * Representa as táboas das BD. 
 */
public class PersoaVo {

	private Integer idPersoa;
	private String nome;
	private Integer idade;
	private String profesion;
	private Integer telefono;
	
	
	
	public Integer getIdPersoa() {
		return idPersoa;
	}
	public void setIdPersoa(Integer idPersoa) {
		this.idPersoa = idPersoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
}
