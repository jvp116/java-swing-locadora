package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import util.Mensagem;
import util.Titulo;

/**
 * Classe responsável por controlar os métodos do objeto Estado
 * 
 * @author João Victor
 * @since 08/03/2021
 * @version 1.0
 */
public class LogradouroController {

	// declarar o nome do arquivo TXT utilizado
	private String arquivo = "logradouros.txt";

	/*
	 * método responsável por retornar uma lista de estados
	 */
	public ArrayList<String> getLogradouros() {
		// objeto lista para retornar no método
		ArrayList<String> logradouros = buscarTodos();
		return logradouros;
	}

	/*
	 * método para ler o arquivo de logradouros
	 */
	private ArrayList<String> buscarTodos() {

		// lista auxiliar para retornar no método
		ArrayList<String> logradouros = new ArrayList<String>();

		try {
			// classe Scanner auxiliar para ler o arquivo de logradouros
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para leitura do arquivo com o comando hasNext
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no método
				String logradouro = leitor.nextLine();
				// atribuindo o objeto logradouro na lista de retorno
				logradouros.add(logradouro);
			}

		} catch (FileNotFoundException e) {
			// exibindo pro usuário uma mensagem de erro
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo, Titulo.cadastroCliente, 0);
			// exibe no console o log de erro do java
			e.printStackTrace();
		}

		// retornando a lista de logradouros
		return logradouros;
	}
} // fim da classe