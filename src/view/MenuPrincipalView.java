package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Classe responsável por controlar o Menu da Locadora
 * 
 * @author João Victor
 * @since 04/03/2021
 */
public class MenuPrincipalView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando o componente para a barrad e menu
	private JMenuBar barraMenu;
	// declarando o menu1, menu2 e menu3
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	// declarando os itens de menu
	private JMenuItem itemMenu1;
	private JMenuItem itemMenu2;
	private JMenuItem itemMenu3;
	private JMenuItem itemMenu4;
	private JMenuItem itemMenu5;
	private JMenuItem itemMenu6;
	private JMenuItem itemMenu7;
	private JMenuItem itemMenu8;
	private JMenuItem itemMenu13;

	/*
	 * método para criar a tela
	 */
	public void iniciaGui() {

		/*
		 * criando as instâncias dos objetos
		 */
		janela = new JFrame();
		barraMenu = new JMenuBar();
		menu1 = new JMenu();
		menu2 = new JMenu();
		menu3 = new JMenu();
		itemMenu1 = new JMenuItem();
		itemMenu2 = new JMenuItem();
		itemMenu3 = new JMenuItem();
		itemMenu4 = new JMenuItem();
		itemMenu5 = new JMenuItem();
		itemMenu6 = new JMenuItem();
		itemMenu7 = new JMenuItem();
		itemMenu8 = new JMenuItem();
		itemMenu13 = new JMenuItem();

		/*
		 * configurações de texto do menu
		 */
		menu1.setText("CADASTRO");
		menu2.setText("CONSULTA");
		menu3.setText("SAIR");

		/*
		 * configurações de texto dos itens de menu
		 */
		itemMenu1.setText("Cliente");
		itemMenu2.setText("Vendedor");
		itemMenu3.setText("Filme");
		itemMenu4.setText("Locação");
		itemMenu5.setText("Cliente");
		itemMenu6.setText("Vendedor");
		itemMenu7.setText("Filme");
		itemMenu8.setText("Locação");
		itemMenu13.setText("Sair");

		/*
		 * adicionando o menu na barra de menus
		 */
		barraMenu.add(menu1);
		barraMenu.add(menu2);
		barraMenu.add(menu3);

		/*
		 * adicionando os itens de menu no menu 1
		 */
		menu1.add(itemMenu1);
		menu1.add(itemMenu2);
		menu1.add(itemMenu3);
		menu1.add(itemMenu4);

		/*
		 * adicionando os itens de menu no menu 2
		 */
		menu2.add(itemMenu5);
		menu2.add(itemMenu6);
		menu2.add(itemMenu7);
		menu2.add(itemMenu8);

		/*
		 * adicionando os itens de menu no menu 3 - SAIR
		 */
		menu3.add(itemMenu13);

		/*
		 * adicionando as ações aos itens de menu
		 */
		itemMenu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new CadastroClienteView().iniciaGui();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});

		itemMenu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarVendedorView().iniciaGui();
			}
		});

		itemMenu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarFilmeView().iniciaGui();
			}
		});

		itemMenu4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CadastrarLocacaoView().iniciaGui();
			}
		});

		itemMenu5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarClienteView().iniciaGui();
			}
		});

		itemMenu6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarVendedorView().iniciaGui();
			}
		});

		itemMenu7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultarFilmeView().iniciaGui();
			}
		});

		itemMenu8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// new ConsultarLocacaoView().iniciaGui();
			}
		});

		itemMenu13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		/*
		 * configurações do JFrame - janela
		 */
		// adicionando a barra de menu a janela
		janela.setJMenuBar(barraMenu);
		// configurando o título do Menu
		janela.setTitle("LOCADORA");
		// configurando a ação do X e do Maximizar do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// janela.setResizable(false);
		// configurando o tamanho da tela maximizado - largura/altura
		janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);
		// configurando a visibilidade da tela
		janela.setVisible(true);

	} // fim do método

} // fim do classe