package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EstadoController;
import controller.VendedorController;
import model.Estado;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por controlar a tela CadastrarVendedor
 * 
 * @author João Victor
 * @since 04/03/2021
 */
public class CadastrarVendedorView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbAreaVenda;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbSexo;
	private JLabel lbIdade;
	private JLabel lbSalario;
	// declarando os TextFields
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfAreaVenda;
	private JTextField tfCidade;
	private JTextField tfIdade;
	private JTextField tfSalario;
	// declarando o JComboBox
	private JComboBox cbxEstados;
	// declarando os radio buttons
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// componente ButtonGroup responsável por gerenciar os componentes de Sexo
	private ButtonGroup grpSexo;
	// declarando os botões
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// painel para organização dos componentes
	private JPanel painel;

	// vetor auxiliar para armazenar os estados
	private String[] estados = {};

	/*
	 * método para criar a tela
	 */
	public void iniciaGui() { // início do método

		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle(Titulo.cadastroVendedor);
		// configurando o tamanho da tela
		janela.setSize(580, 360);
		// configurando a posição inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configurações do JLabel código
		 */
		lbCodigo = new JLabel();
		// configurando texto inicial
		lbCodigo.setText("Código:");
		// configurando a posição e tamanho do componente
		lbCodigo.setBounds(20, 20, 50, 25);

		/*
		 * configurações do JLabel Nome
		 */
		lbNome = new JLabel();
		// configurando texto inicial
		lbNome.setText("Nome:");
		// configurando a posição e tmaanho do componente
		lbNome.setBounds(20, 50, 50, 25);

		/*
		 * configurações do JLabel Area de Venda
		 */
		lbAreaVenda = new JLabel();
		// configurando texto inicial
		lbAreaVenda.setText("Área de Venda:");
		// configurando a posição e tmaanho do componente
		lbAreaVenda.setBounds(20, 80, 85, 25);

		/*
		 * configurações do JLabel Valor
		 */
		lbCidade = new JLabel();
		// configurando texto inicial
		lbCidade.setText("Cidade:");
		// configurando a posição e tmaanho do componente
		lbCidade.setBounds(20, 110, 70, 25);

		/*
		 * configurando o campo de texto Código
		 */
		tfCodigo = new JTextField();
		// configurar a posição e o tamanho
		tfCodigo.setBounds(120, 20, 410, 25);

		/*
		 * configurando o campo de texto Nome
		 */
		tfNome = new JTextField();
		// configurar a posição e o tamanho
		tfNome.setBounds(120, 50, 410, 25);

		/*
		 * configurando o campo de texto Área de Venda
		 */
		tfAreaVenda = new JTextField();
		// configurar a posição e o tamanho
		tfAreaVenda.setBounds(120, 80, 410, 25);

		/*
		 * configurando o campo de texto Valor
		 */
		tfCidade = new JTextField();
		// configurar a posição e o tamanho
		tfCidade.setBounds(120, 110, 410, 25);

		/*
		 * configurações do JLabel Estado
		 */
		lbEstado = new JLabel();
		// configurando tezto inicial
		lbEstado.setText("Estado:");
		// configurando a posição e tamanho do componente
		lbEstado.setBounds(20, 142, 70, 25);

		/*
		 * configurações do JComboBox
		 */
		cbxEstados = new JComboBox(estados);
		cbxEstados.setBounds(120, 142, 300, 25);

		/*
		 * configurações do JLabel Sexo
		 */
		lbSexo = new JLabel();
		// configurando texto inicial
		lbSexo.setText("Sexo:");
		// configurando a posição e tamanho do componente
		lbSexo.setBounds(20, 175, 50, 25);

		/*
		 * configurações do radio button Masculino e Feminino
		 */
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		// configurando o texto do componente
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");
		// configurando a posição e o tamanho
		rbMasculino.setBounds(120, 175, 80, 25);
		rbFeminino.setBounds(220, 175, 80, 25);

		/*
		 * configurações do ButtonGroup Sexo
		 */
		grpSexo = new ButtonGroup();
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * configurações do JLabel Idade
		 */
		lbIdade = new JLabel();
		// configurando texto inicial
		lbIdade.setText("Idade:");
		// configurando a posição e tamanho do componente
		lbIdade.setBounds(20, 205, 100, 25);

		/*
		 * configurando o campo de texto Idade
		 */
		tfIdade = new JTextField();
		// configurar a posição e o tamanho
		tfIdade.setBounds(120, 205, 410, 25);

		/*
		 * configurações do JLabel Salário
		 */
		lbSalario = new JLabel();
		// configurando texto inicial
		lbSalario.setText("Salário:");
		// configurando a posição e tamanho do componente
		lbSalario.setBounds(20, 235, 100, 25);

		/*
		 * configurando o campo de texto Salário
		 */
		tfSalario = new JTextField();
		// configurar a posição e o tamanho
		tfSalario.setBounds(120, 235, 410, 25);

		/*
		 * configurações do JButton Salvar
		 */
		btSalvar = new JButton();
		// configurando o texto inicial
		btSalvar.setText("SALVAR");
		// configurando a posição e tamanho do componente
		btSalvar.setBounds(120, 275, 145, 30);
		// configurando a ação do botão
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		/*
		 * configurações do JButton Cancelar
		 */
		btCancelar = new JButton();
		// configurando o texto inicial
		btCancelar.setText("CANCELAR");
		// configurando a posição e tamanho do componente
		btCancelar.setBounds(285, 275, 145, 30);
		// configurando a ação do botão
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// método para limpar os campos da tela
				limparTela();
				// método para bloquear os campos da tela
				bloquearTela();
			}
		});

		/*
		 * configurações do JButton Novo e Sair
		 */
		btNovo = new JButton();
		btSair = new JButton();
		// configurando o texto inicial
		btNovo.setText("NOVO");
		btSair.setText("SAIR");
		// configurando a posição e tamanho do componente
		btNovo.setBounds(120, 275, 145, 30);
		btSair.setBounds(285, 275, 145, 30);
		// configurando a ação do botão
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				liberarTela();

			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
		painel.add(lbCodigo);
		painel.add(tfCodigo);
		painel.add(lbNome);
		painel.add(tfNome);
		painel.add(lbAreaVenda);
		painel.add(tfAreaVenda);
		painel.add(lbCidade);
		painel.add(tfCidade);
		painel.add(lbEstado);
		painel.add(cbxEstados);
		painel.add(lbSexo);
		painel.add(rbMasculino);
		painel.add(rbFeminino);
		painel.add(lbIdade);
		painel.add(tfIdade);
		painel.add(lbSalario);
		painel.add(tfSalario);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// chamando o método para carregar a combo de estados
		carregarComboEstados();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a visibilidade da tela
		janela.setVisible(true);
	} // fim do método gui

	/*
	 * método para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfAreaVenda.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		tfIdade.setEditable(false);
		tfSalario.setEditable(false);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	/*
	 * método para liberar os campos da tela de cadastro
	 */
	public void liberarTela() {
		tfCodigo.setEditable(true);
		tfNome.setEditable(true);
		tfAreaVenda.setEditable(true);
		tfCidade.setEditable(true);
		cbxEstados.setEnabled(true);
		tfIdade.setEditable(true);
		tfSalario.setEditable(true);
		rbMasculino.setEnabled(true);
		rbFeminino.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}

	/*
	 * método para limpar os campos da tela de cadastro
	 */
	private void limparTela() {
		tfCodigo.setText(null);
		tfNome.setText(null);
		tfAreaVenda.setText(null);
		tfCidade.setText(null);
		tfIdade.setText(null);
		tfSalario.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
	}

	/*
	 * método para preencher a combo de estados
	 */
	private void carregarComboEstados() {
		// valor inicial da combo
		cbxEstados.addItem("-Selecione Estado-");

		// laço de repetição ára carregar a combo de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}

	}

	/*
	 * método para receber ação do clique salvar
	 */
	public void salvar() {

		// salvar o vendedor apenas se estiver válido todos os dados
		if (validar()) {

			/*
			 * procedimentos de gravação do objeto vendedor no arquivo TXT
			 */
			Vendedor vendedor = getVendedor();

			// chamando o método responsávepor gravar o arquivo TXT
			new VendedorController().gravarTxtVendedor(vendedor);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null, Mensagem.vendedorGravado, Titulo.cadastroVendedor, 1);
		}

	}

	/*
	 * método para validar os campos da tela
	 */
	private boolean validar() {

		// validação do campo código
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando o usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o método
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usuário que o código é inválido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isStringValida(tfNome.getText())) {
			// informando ao usuário que o nome é inválido
			JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo área de venda
		if (Valida.isEmptyOrNull(tfAreaVenda.getText())) {
			// informando o usuário que a área de venda não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isStringValida(tfAreaVenda.getText())) {
			// informando ao usuário que a área de venda é inválida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando o usuário que a cidade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isStringValida(tfCidade.getText())) {
			// informando ao usuário que a cidade é inválida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação da combo estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando o usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foc no campo com erro
			cbxEstados.grabFocus();
			return false;
		}

		// validação do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando o usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroVendedor, 0);
				// retornar falso para o método
				return false;
			}
		}

		// validação do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando o usuário que a idade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o método
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usuário que a idade é inválida
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo salário
		if (Valida.isEmptyOrNull(tfSalario.getText())) {
			// informando o usuário que o salário não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornar false para o método
			return false;
		} else if (!Valida.isDouble(tfSalario.getText())) {
			// informando ao usuário que o salário é inválidp
			JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornar false para o método
			return false;
		}

		// devolvendo true caso esteja tudo válido
		return true;
	} // fim do método validar

	/*
	 * método para valorizar um objeto vendedor utilizando so campos da tela
	 */
	private Vendedor getVendedor() {

		// instanciando o objeto vendedor para retorno do método
		Vendedor vendedor = new Vendedor();

		// valorizando o objeto vendedor
		vendedor.setCodigo(Util.getInt(tfCodigo.getText()));
		vendedor.setNome(tfNome.getText());
		vendedor.setAreaVenda(tfAreaVenda.getText());
		vendedor.setCidade(tfCidade.getText());
		vendedor.setEstado(cbxEstados.getSelectedItem() + "");

		// condicional ternária - if em uma linha
		vendedor.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');

		vendedor.setIdade(Util.getInt(tfIdade.getText()));
		vendedor.setSalario(Util.getDouble(tfSalario.getText()));

		// retornando o onjeto valorizado
		return vendedor;

	} // fim do método getVendedor

} // fim da classe