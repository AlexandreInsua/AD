package unidade01;

import java.io.Serializable;

public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String direccion;
	private int idade;
	/**
	 * 
	 */
	public Alumno() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nome
	 * @param direccion
	 * @param idade
	 */
	public Alumno(String nome, String direccion, int idade) {
		this.nome = nome;
		this.direccion = direccion;
		this.idade = idade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNome() {
		return nome;
	}
	public String getDireccion() {
		return direccion;
	}
	public int getIdade() {
		return idade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return nome + ", " + direccion + ", " + idade;
	}
	
	
	

}
