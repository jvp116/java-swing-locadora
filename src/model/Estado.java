package model;

/**
 * Classe resposável por controlar o objeto Estado
 * 
 * @author João Victor
 * @since 04/03/2021
 */
public class Estado {

	// gerar construtor vazio
	public Estado() {
	}

	private String uf;
	private String nome;

	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}