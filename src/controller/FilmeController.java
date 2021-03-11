package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por controlar os processos de gravação e leitura da tela
 * Filme
 * 
 * @author João Victor
 * @since 09/03/2021
 * @version 1.0
 */
public class FilmeController {

	// declarar o nome do arquivo TXT utilizado
	private String arquivo = "filme.txt";

	/*
	 * método para gravar registros no arquivo TXT
	 */
	public void gravarTxtFilme(Filme filme) {

		// classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file = new File(arquivo);

		try {
			// classe auxiliar para gerar um objeto de memória para gravação do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file, true);

			// classe auxiliar para gerar o arquivo e seu conteúdo
			PrintStream gravador = new PrintStream(arquivoOutput);

			// gravando o conteúdo do arquivo
			gravador.print(filme.getCodigo());
			gravador.print(";");
			gravador.print(filme.getNome());
			gravador.print(";");
			gravador.print(filme.getValor());
			gravador.print(";");
			gravador.print(filme.isDisponivel());
			gravador.print(";");
			gravador.print(filme.isPromocao());
			gravador.print(";");
			gravador.print(filme.getValorPromocao());
			gravador.print(";");
			gravador.print(filme.getGenero());
			gravador.print("\n");

			// fechando o processo de gravação
			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			// exibindo pro usuário uma mensagem de erro
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoFilme, Titulo.cadastroFilme, 0);
			// exibe no console o log de erro do java
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoFilme, Titulo.cadastroFilme, 0);
			e.printStackTrace();
		}

	}

	/*
	 * método para retornar uma lista de filmes
	 */
	public ArrayList<Filme> getFilmes() {
		// objeto de lista para retornar no método
		ArrayList<Filme> filmes = buscarTodos();
		return filmes;
	}

	/*
	 * método para ler o arquivo TXT de filme
	 */
	private ArrayList<Filme> buscarTodos() {

		// lista auxiliar para retornar no método
		ArrayList<Filme> filmes = new ArrayList<Filme>();

		try {
			// classe Scanner auxiliar para ler o arquivo de filmes
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para leitura do arquivo com o comando hasNext
			while (leitor.hasNext()) {

				// objeto auxiliar para retornar no método
				Filme filme = getFilme(leitor.nextLine());

				// atribuindo o objeto filme na lista de retorno
				filmes.add(filme);
			} // fim do while
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filmes;
	} // fim do método

	/*
	 * método para retornar um objeto do tipo filme
	 */
	private Filme getFilme(String args) {
		// objeto auxiliar para retornar no método
		Filme filme = new Filme();
		// variável auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// valorizando o objeto filme
		filme.setCodigo(Util.getInt(aux[0]));
		filme.setNome(aux[1]);
		filme.setValor(Util.getDouble(aux[2]));
		filme.setDisponivel(Util.getBoolean(aux[3]));
		filme.setPromocao(Util.getBoolean(aux[4]));
		filme.setValorPromocao(Util.getDouble(aux[5]));
		filme.setGenero(aux[6]);

		// retornando o objeto valorizado
		return filme;
	} // fim do método

} // fim da classe