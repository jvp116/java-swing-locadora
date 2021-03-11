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

import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;

/**
 * Classe responsável por controlar os processos de gravação e leitura da tela
 * Vendedor
 * 
 * @author João Victor
 * @since 09/03/2021
 * @version 1.0
 */
public class VendedorController {

	// declarar o nome do arquivo TXT utilizado
	private String arquivo = "vendedor.txt";

	/*
	 * método para gravar registros no arquivo TXT
	 */
	public void gravarTxtVendedor(Vendedor vendedor) {

		// classe auxiliar para carregar um arquivo existente ou criar um novo arquivo
		File file = new File(arquivo);

		try {
			// classe auxiliar para gerar um objeto de memória para gravação do arquivo
			FileOutputStream arquivoOutput = new FileOutputStream(file, true);

			// classe auxiliar para gerar o arquivo e seu conteúdo
			PrintStream gravador = new PrintStream(arquivoOutput);

			// gravando o conteúdo do arquivo
			gravador.print(vendedor.getCodigo());
			gravador.print(";");
			gravador.print(vendedor.getNome());
			gravador.print(";");
			gravador.print(vendedor.getAreaVenda());
			gravador.print(";");
			gravador.print(vendedor.getCidade());
			gravador.print(";");
			gravador.print(vendedor.getEstado());
			gravador.print(";");
			gravador.print(vendedor.getSexo());
			gravador.print(";");
			gravador.print(vendedor.getIdade());
			gravador.print(";");
			gravador.print(vendedor.getSalario());
			gravador.print("\n");

			// fechando o processo de gravação
			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {
			// exibindo pro usuário uma mensagem de erro
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroVendedor, 0);
			// exibe no console o log de erro do java
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Mensagem.erroGravarArquivoVendedor, Titulo.cadastroVendedor, 0);
			e.printStackTrace();
		}

	}

	/*
	 * método para retornar uma lista de vendedores
	 */
	public ArrayList<Vendedor> getVendedores() {
		// objeto de lista para retornar no método
		ArrayList<Vendedor> vendedores = buscarTodos();
		return vendedores;
	}

	/*
	 * método para ler o arquivo TXT de vendedor
	 */
	private ArrayList<Vendedor> buscarTodos() {

		// lista auxiliar para retornar no método
		ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

		try {
			// classe Scanner auxiliar para ler o arquivo de vendedores
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// laço de repetição para leitura do arquivo com o comando hasNext
			while (leitor.hasNext()) {

				// objeto auxiliar para retornar no método
				Vendedor vendedor = getVendedor(leitor.nextLine());

				// atribuindo o objeto vendedor na lista de retorno
				vendedores.add(vendedor);
			} // fim do while
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vendedores;
	} // fim do método

	/*
	 * método para retornar um objeto do tipo vendedor
	 */
	private Vendedor getVendedor(String args) {
		// objeto auxiliar para retornar no métodp
		Vendedor vendedor = new Vendedor();
		// variável auxiliar para quebrar o registro do arquivo
		String aux[] = args.split(";");

		// valorizando o objeto vendedor
		vendedor.setCodigo(Util.getInt(aux[0]));
		vendedor.setNome(aux[1]);
		vendedor.setAreaVenda(aux[2]);
		vendedor.setCidade(aux[3]);
		vendedor.setEstado(aux[4]);
		// comando charAt serve para pegar apenas a posição indicada
		vendedor.setSexo(aux[5].charAt(0));
		vendedor.setIdade(Util.getInt(aux[6]));
		vendedor.setSalario(Util.getDouble(aux[7]));

		// retornando o objeto valorizado
		return vendedor;
	} // fim do método

} // fim da classe