package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.Cliente;
import util.Titulo;

/**
 * Classe responsável por controlar a tela ConsultarCliente
 * 
 * @author João Victor
 * @since 05/03/2021
 */
public class ConsultarClienteView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando a tabela para armazenar os dados inputados pelo usuário
	private JTable tabelaClientes;
	// declarando o scroll auxiliar para exibir os registros da tabela
	private JScrollPane scrollTabelaClientes;
	// declarando os botões
	private JButton btSair;
	// declarando o painel para organizar os componentes de tela
	private JPanel painel;

	// vetor auxiliar para armazenar os nomes das colunas
	private String colunas[] = { "Nome", "Sexo", "Idade", "Cidade", "Celular" };
	// matriz auxiliar para armazenar os dados exibidos na tabela
	private String linhas[][] = {};

	/*
	 * método para criar a tela
	 */
	public void iniciaGui() { // início do método

		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle(Titulo.consultaCliente);
		// configurando o tamanho da tela
		janela.setSize(600, 400);
		// configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configurações do componente JTable - tabela de dados
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modelo = new DefaultTableModel(linhas, colunas);
		tabelaClientes = new JTable(modelo);
		// configurar a posição e tamanho
		// tabelaLocacao.setBounds(19, 30, 300, 95);
		// configurar a ação do usuário quando clica no registro armazena
		tabelaClientes.setEnabled(true);

		/*
		 * configurações do componente JScrollPane
		 */
		scrollTabelaClientes = new JScrollPane(tabelaClientes);
		// configurar local de exibição do scroll
		scrollTabelaClientes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posição e tamanho
		scrollTabelaClientes.setBounds(0, 0, 585, 310);

		/*
		 * configurações do JButton Sair
		 */
		btSair = new JButton();
		// configurando o texto inicial
		btSair.setText("SAIR");
		// configurando a posição e tamanho do componente
		btSair.setBounds(215, 320, 150, 30);
		// configurando a ação do botão
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();
			}
		});

		// configurando a ação do X e do Maximizar do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setResizable(false);

		/*
		 * configurações do painel da janela
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(scrollTabelaClientes);
		painel.add(btSair);

		// chamando o método para carregar a tabela
		carregarTabela();

		// configurando a visibilidade da tela
		janela.setVisible(true);
	} // fim do método

	/*
	 * método para carregar a tabela com os clientes gravados no arquivo TXT
	 */
	public void carregarTabela() {

		// obtendo o modelo da tabela criada
		DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
		// limpando os dados (linhas) da tabela
		// modelo.removeRow(0);

		// laço de repetição para preencher as linhas da tabela
		for (Cliente cliente : new ClienteController().getClientes()) {

			// adicionando a linha a tabela
			modelo.addRow(new String[] { cliente.getNome(), cliente.getSexo() + "", cliente.getIdade() + "",
					cliente.getEndereco().getCidade(), cliente.getCelular() });
		}
	}

} // fim da classe