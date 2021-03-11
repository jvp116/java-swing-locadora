package model;

/**
 * Classe resposável por controlar o objeto Filme
 * 
 * @author João Victor
 * @since 04/03/2021
 */
public class Filme {

	// gerando o construtor vazio
	public Filme() {
		// TODO Auto-generated constructor stub
	}

	// declarando os atributos da classe
	private int codigo;
	private String nome;
	private double valor;
	private boolean disponivel;
	private boolean promocao;
	private double valorPromocao;
	private String genero;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public double getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}

}