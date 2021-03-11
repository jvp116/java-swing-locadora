package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EstadoController;
import controller.LogradouroController;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe responsável por controlar a tela CadastrarCliente
 * 
 * @author João Victor
 * @since 05/03/2021
 */
public class CadastroClienteView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbDataNascimento;
	private JLabel lbIdade;
	// label Contato
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	// labels Endereço
	private JLabel lbLogradouro;
	private JLabel lbEndereco;
	private JLabel lbNumero;
	private JLabel lbComplemento;
	private JLabel lbBairro;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbCep;
	// text Endereço
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	// declarando os campos e os formatados
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfEmail;
	private JFormattedTextField tfCep;
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
	// declarando os atributos de formatação
	private MaskFormatter fmtCep;
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	// declarando os radio buttons
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// componente ButtonGroup responsável por gerenciar os componentes de Sexo
	private ButtonGroup grpSexo;
	// declarando o JComboBox
	private JComboBox cbxEstados;
	private JComboBox cbxLogradouros;
	// declarando os botões
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// painel para organização dos componentes
	private JPanel painel;
	private JPanel painelSexo;
	private JPanel painelContato;

	// vetor auxiliar para armazenar os estados
	private String[] estados = {};

	// vetor auxiliar para armazenar os logradouros
	private String[] logradouros = {};

	/*
	 * método para criar a tela
	 */
	/**
	 * @throws ParseException
	 */
	public void iniciaGui() throws ParseException { // início do método

		/*
		 * configurações dos campos de formatação
		 */
		fmtCep = new MaskFormatter("#####-###");
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCelular = new MaskFormatter("(##) #####-####");

		/*
		 * configurações do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o título da tela
		janela.setTitle(Titulo.cadastroCliente);
		// configurando o tamanho da tela
		janela.setSize(805, 460);
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
		 * configurações do JLabel Valor
		 */
		lbCpf = new JLabel();
		// configurando texto inicial
		lbCpf.setText("CPF:");
		// configurando a posição e tamanho do componente
		lbCpf.setBounds(170, 20, 30, 25);

		/*
		 * configurações do JLabel Nome
		 */
		lbNome = new JLabel();
		// configurando texto inicial
		lbNome.setText("Nome:");
		// configurando a posição e tamanho do componente
		lbNome.setBounds(340, 20, 40, 25);

		/*
		 * configurando o campo de texto Código
		 */
		tfCodigo = new JTextField();
		// configurar a posição e o tamanho
		tfCodigo.setBounds(70, 20, 60, 25);

		/*
		 * configurações do JFormattedTextField Cpf
		 */
		tfCpf = new JFormattedTextField(fmtCpf);
		// configurando a posição e o tamanho
		tfCpf.setBounds(205, 20, 105, 25);

		/*
		 * configurando o campo de texto Nome
		 */
		tfNome = new JTextField();
		// configurar a posição e o tamanho
		tfNome.setBounds(390, 20, 380, 25);

		/*
		 * configurações da JLabel Data de Nascimento
		 */
		lbDataNascimento = new JLabel();
		lbDataNascimento.setText("Data de Nascimento:");
		// configurando a posição e tamanho
		lbDataNascimento.setBounds(20, 70, 120, 25);

		/*
		 * configurações do JFormattedTextField Data de Nascimento
		 */
		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);
		// configurando a posição e o tamanho
		tfDataNascimento.setBounds(145, 70, 80, 25);

		/*
		 * configurações da JLabel RG
		 */
		lbRg = new JLabel();
		lbRg.setText("RG:");
		// configurando a posição e tamanho
		lbRg.setBounds(280, 70, 30, 25);

		/*
		 * configurações do JFormattedTextField Rg
		 */
		tfRg = new JFormattedTextField(fmtRg);
		// configurando a posição e o tamanho
		tfRg.setBounds(310, 70, 95, 25);

		/*
		 * configurações da JLabel Idade
		 */
		lbIdade = new JLabel();
		lbIdade.setText("Idade:");
		// configurando a posição e tamanho
		lbIdade.setBounds(430, 70, 50, 25);

		/*
		 * configurações do JTextField Idade
		 */
		tfIdade = new JTextField();
		// configurando a posição e o tamanho
		tfIdade.setBounds(475, 70, 50, 25);

		/*
		 * configurações do radio button Masculino e Feminino
		 */
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		// configurando o texto do componente
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");

		/*
		 * configurações do ButtonGroup Sexo
		 */
		grpSexo = new ButtonGroup();
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * configurações do painel sexo
		 */
		painelSexo = new JPanel();
		// configurar posição e o tamanho
		painelSexo.setBounds(570, 55, 200, 58);
		// configurar o layout do painel
		painelSexo.setLayout(new GridLayout(1, 1, 0, 0));
		// configurar a borda do painel
		painelSexo.setBorder(new TitledBorder("Sexo"));
		painelSexo.add(rbMasculino);
		painelSexo.add(rbFeminino);

		/*
		 * configurações da JLabel e JFormattedTextField do Telefone
		 */
		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone:");
		tfTelefone = new JFormattedTextField(fmtTelefone);

		/*
		 * configurações da JLabel e JFormattedTextField do Celular
		 */
		lbCelular = new JLabel();
		lbCelular.setText("Celular:");
		tfCelular = new JFormattedTextField(fmtCelular);

		/*
		 * configurações da JLabel e JTextField do Email
		 */
		lbEmail = new JLabel();
		lbEmail.setText("Email:");
		tfEmail = new JTextField();

		/*
		 * configurações da JLabel Cep
		 */
		lbCep = new JLabel();
		lbCep.setText("CEP:");
		// configurando a posição e tamanho
		lbCep.setBounds(20, 125, 30, 25);

		/*
		 * configurações da JLabel Logradouro
		 */
		lbLogradouro = new JLabel();
		lbLogradouro.setText("Logradouro:");
		// configurando a posição e tamanho
		lbLogradouro.setBounds(20, 160, 80, 25);

		/*
		 * configurações da JLabel Endereço
		 */
		lbEndereco = new JLabel();
		lbEndereco.setText("Endereço:");
		// configurando a posição e tamanho
		lbEndereco.setBounds(20, 195, 70, 25);

		/*
		 * configurações da JLabel Número
		 */
		lbNumero = new JLabel();
		lbNumero.setText("Nº:");
		// configurando a posição e tamanho
		lbNumero.setBounds(280, 125, 30, 25);

		/*
		 * configurações do JFormattedTextField RgCep
		 */
		tfCep = new JFormattedTextField(fmtCep);
		// configurando a posição e o tamanho
		tfCep.setBounds(60, 125, 85, 25);

		/*
		 * configurações do JComboBox
		 */
		cbxLogradouros = new JComboBox(logradouros);
		cbxLogradouros.setBounds(100, 160, 140, 25);

		/*
		 * configurações do JTextField Logradouro
		 */
		tfEndereco = new JTextField();
		// configurando a posição e o tamanho
		tfEndereco.setBounds(90, 195, 150, 25);

		/*
		 * configurações do JTextField Logradouro
		 */
		tfNumero = new JTextField();
		// configurando a posição e o tamanho
		tfNumero.setBounds(330, 125, 50, 25);

		/*
		 * configurações da JLabel Complemento
		 */
		lbComplemento = new JLabel();
		lbComplemento.setText("Complemento:");
		// configurando a posição e tamanho
		lbComplemento.setBounds(280, 195, 90, 25);

		/*
		 * configurações da JLabel Bairro
		 */
		lbBairro = new JLabel();
		lbBairro.setText("Bairro:");
		// configurando a posição e tamanho
		lbBairro.setBounds(280, 160, 40, 25);

		/*
		 * configurações da JLabel Cidade
		 */
		lbCidade = new JLabel();
		lbCidade.setText("Cidade:");
		// configurando a posição e tamanho
		lbCidade.setBounds(550, 140, 60, 25);

		/*
		 * configurações da JLabel Estado
		 */
		lbEstado = new JLabel();
		lbEstado.setText("Estado:");
		// configurando a posição e tamanho
		lbEstado.setBounds(550, 180, 60, 25);

		/*
		 * configurações do JFormattedTextField Complemento
		 */
		tfComplemento = new JTextField();
		// configurando a posição e o tamanho
		tfComplemento.setBounds(370, 195, 95, 25);

		/*
		 * configurações do JFormattedTextField Bairro
		 */
		tfBairro = new JTextField();
		// configurando a posição e o tamanho
		tfBairro.setBounds(330, 160, 135, 25);

		/*
		 * configurações do JFormattedTextField Cidade
		 */
		tfCidade = new JTextField();
		// configurando a posição e o tamanho
		tfCidade.setBounds(600, 140, 150, 25);

		/*
		 * configurações do JComboBox
		 */
		cbxEstados = new JComboBox(estados);
		cbxEstados.setBounds(600, 180, 150, 25);

		/*
		 * configurações do painel contato
		 */
		painelContato = new JPanel();
		// configurar posição e o tamanho
		painelContato.setBounds(0, 240, 785, 125);
		// configurar o layout do painel
		painelContato.setLayout(new GridLayout(3, 0, 0, 0));
		// configurar a borda do painel
		painelContato.setBorder(new TitledBorder("Contato"));
		painelContato.add(lbTelefone);
		painelContato.add(tfTelefone);
		painelContato.add(lbCelular);
		painelContato.add(tfCelular);
		painelContato.add(lbEmail);
		painelContato.add(tfEmail);

		/*
		 * configurações do JButton Salvar
		 */
		btSalvar = new JButton();
		// configurando o texto inicial
		btSalvar.setText("SALVAR");
		// configurando a posição e tamanho do componente
		btSalvar.setBounds(230, 375, 145, 30);
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
		btCancelar.setBounds(400, 375, 145, 30);
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
		btNovo.setBounds(230, 375, 145, 30);
		btSair.setBounds(400, 375, 145, 30);
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
		 * configurações do painel principal da tela
		 */
		painel = (JPanel) janela.getContentPane();
		// configurar o layout inicial
		painel.setLayout(null);
		painel.add(lbCodigo);
		painel.add(lbCpf);
		painel.add(lbNome);
		painel.add(tfCodigo);
		painel.add(tfCpf);
		painel.add(tfNome);
		painel.add(lbDataNascimento);
		painel.add(lbRg);
		painel.add(lbIdade);
		painel.add(tfDataNascimento);
		painel.add(tfRg);
		painel.add(tfIdade);
		painel.add(painelSexo);
		painel.add(lbCep);
		painel.add(lbLogradouro);
		painel.add(lbEndereco);
		painel.add(lbNumero);
		painel.add(tfCep);
		painel.add(cbxLogradouros);
		painel.add(tfEndereco);
		painel.add(tfNumero);
		painel.add(lbComplemento);
		painel.add(lbBairro);
		painel.add(lbCidade);
		painel.add(lbEstado);
		painel.add(tfComplemento);
		painel.add(tfBairro);
		painel.add(tfCidade);
		painel.add(cbxEstados);
		painel.add(painelContato);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// chamando o método para carregar a combo de estados
		carregarComboEstados();

		// chamando o método para carregar a combo de estados
		carregarComboLogradouros();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a visibilidade da tela
		janela.setVisible(true);

	} // fim do método

	/*
	 * método para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfCpf.setEditable(false);
		tfNome.setEditable(false);
		tfDataNascimento.setEditable(false);
		tfRg.setEditable(false);
		tfCep.setEditable(false);
		cbxLogradouros.setEnabled(false);
		tfEndereco.setEditable(false);
		tfNumero.setEditable(false);
		tfComplemento.setEditable(false);
		tfBairro.setEditable(false);
		tfCidade.setEditable(false);
		tfTelefone.setEditable(false);
		tfCelular.setEditable(false);
		tfEmail.setEditable(false);
		tfIdade.setEditable(false);
		cbxEstados.setEnabled(false);
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
		tfCpf.setEditable(true);
		tfNome.setEditable(true);
		tfCidade.setEditable(true);
		tfDataNascimento.setEditable(true);
		tfRg.setEditable(true);
		tfCep.setEditable(true);
		cbxLogradouros.setEnabled(true);
		tfEndereco.setEditable(true);
		tfNumero.setEditable(true);
		tfComplemento.setEditable(true);
		tfBairro.setEditable(true);
		tfCidade.setEditable(true);
		tfTelefone.setEditable(true);
		tfCelular.setEditable(true);
		tfEmail.setEditable(true);
		tfIdade.setEditable(true);
		cbxEstados.setEnabled(true);
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
		tfCpf.setText(null);
		tfNome.setText(null);
		tfCidade.setText(null);
		tfDataNascimento.setText(null);
		tfRg.setText(null);
		tfCep.setText(null);
		tfEndereco.setText(null);
		tfNumero.setText(null);
		tfComplemento.setText(null);
		tfBairro.setText(null);
		tfCidade.setText(null);
		tfTelefone.setText(null);
		tfCelular.setText(null);
		tfEmail.setText(null);
		tfIdade.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
		cbxLogradouros.setSelectedIndex(0);
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

	} // fim do método estados

	/*
	 * método para preencher a combo de logradouros
	 */
	private void carregarComboLogradouros() {
		// valor inicial da combo
		cbxLogradouros.addItem("-Selecione Logradouro-");

		// laço de repetição ára carregar a combo de estados
		for (String logradouro : new LogradouroController().getLogradouros()) {
			cbxLogradouros.addItem(logradouro);
		}

	} // fim do método estados

	/*
	 * método para receber ação do clique salvar
	 */
	public void salvar() {

		// salvar o cliente apenas se estiver válido todos os dados
		if (validar()) {

			/*
			 * procedimentos de gravação do objeto cliente no arquivo TXT
			 */
			Cliente cliente = getCliente();

			// chamando o método responsável por gravar o arquivo TXT
			new ClienteController().gravarTxtCliente(cliente);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo mensagem de sucesso para o usuário
			JOptionPane.showMessageDialog(null, Mensagem.clienteGravado, Titulo.cadastroCliente, 1);
		}

	}// fim do método salvar

	/*
	 * método para validar os campos da tela
	 */
	private boolean validar() {

		// validação do campo código
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando o usuário que o código não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o método
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usuário que o código é inválido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo cpf
		if (Valida.isEmptyOrNull(tfCpf.getText()) || tfCpf.getText().equals("   .   .   -  ")) {
			// informando o usuário que o cpf não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCpf.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando o usuário que o nome não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isStringValida(tfNome.getText())) {
			// informando ao usuário que o nome é inválido
			JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo data de nascimento
		if (Valida.isEmptyOrNull(tfDataNascimento.getText()) || tfDataNascimento.getText().equals("  /  /    ")) {
			// informando o usuário que a data de nascimento não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfDataNascimento.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo rg
		if (Valida.isEmptyOrNull(tfRg.getText()) || tfRg.getText().equals("  .   .   - ")) {
			// informando o usuário que o rg não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfRg.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando o usuário que a idade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o método
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usuário que a idade é inválida
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando o usuário que o sexo não foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroCliente, 0);
				// retornar falso para o método
				return false;
			}
		}

		// validação do campo cep
		if (Valida.isEmptyOrNull(tfCep.getText()) || tfCep.getText().equals("     -   ")) {
			// informando o usuário que o cep não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCep.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo endereço/rua
		if (Valida.isEmptyOrNull(tfEndereco.getText())) {
			// informando o usuário que o endereço/rua não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.enderecoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEndereco.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isInteger(tfEndereco.getText())) {
			// informando ao usuário que o endereço/rua é inválido
			JOptionPane.showMessageDialog(null, Mensagem.enderecoInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEndereco.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo complemento
		if (Valida.isEmptyOrNull(tfComplemento.getText())) {
			// informando o usuário que o complemento não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.complementoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfComplemento.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo bairro
		if (Valida.isEmptyOrNull(tfBairro.getText())) {
			// informando o usuário que o bairro não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfBairro.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isInteger(tfBairro.getText())) {
			// informando ao usuário que o bairro é inválido
			JOptionPane.showMessageDialog(null, Mensagem.bairroInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfBairro.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo número
		if (Valida.isEmptyOrNull(tfNumero.getText())) {
			// informando o usuário que o número não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornar false para o método
			return false;
		} else if (!Valida.isInteger(tfNumero.getText())) {
			// informando ao usuário que o número é inválido
			JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando o usuário que a cidade não está preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o método
			return false;
		} else if (Valida.isInteger(tfCidade.getText())) {
			// informando ao usuário que a cidade é inválida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeInvalida, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação da combo estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando o usuário que o estado não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			cbxEstados.grabFocus();
			return false;
		}

		// validação da combo logradouro
		if (cbxLogradouros.getSelectedIndex() == 0) {
			// informando o usuário que o Logradouros não foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			cbxLogradouros.grabFocus();
			return false;
		}

		// validação do campo telefone
		if (Valida.isEmptyOrNull(tfTelefone.getText()) || tfTelefone.getText().equals("(  )     -    ")) {
			// informando o usuário que o telefone não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfTelefone.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo celular
		if (Valida.isEmptyOrNull(tfCelular.getText()) || tfCelular.getText().equals("(  )      -    ")) {
			// informando o usuário que o celular não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCelular.grabFocus();
			// retornar false para o método
			return false;
		}

		// validação do campo email
		if (Valida.isEmptyOrNull(tfEmail.getText())) {
			// informando o usuário que o email não está preenchido
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEmail.grabFocus();
			// retornar false para o método
			return false;
		}

		// devolvendo true caso esteja tudo válido
		return true;

	}// fim do método validar

	/*
	 * método para valorizar um objeto cliente utilizando so campos da tela
	 */
	private Cliente getCliente() {

		// instanciando o objeto cliente para retorno do método
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Data dataNascimento = new Data();

		// valorizando o objeto cliente
		cliente.setCodigo(Util.getInt(tfCodigo.getText()));
		cliente.setNome(tfNome.getText());
		endereco.setCodigo(Util.getInt(tfCodigo.getText()));
		endereco.setLogradouro(cbxLogradouros.getSelectedItem() + "");
		endereco.setEndereco(tfEndereco.getText());
		endereco.setNumero(Util.getInt(tfNumero.getText()));
		endereco.setComplemento(tfComplemento.getText());
		endereco.setBairro(tfBairro.getText());
		endereco.setCidade(tfCidade.getText());
		endereco.setEstado(cbxEstados.getSelectedItem() + "");
		endereco.setCep(tfCep.getText());
		cliente.setEndereco(endereco);
		// cpf e rg
		cliente.setCpf(tfCpf.getText());
		cliente.setRg(tfRg.getText());
		// data
		// Separando a data em 3
		String dataQuebrada[] = (tfDataNascimento.getText().split("/"));
		dataNascimento.setDia(Util.getInt(dataQuebrada[0]));
		dataNascimento.setMes(Util.getInt(dataQuebrada[1]));
		dataNascimento.setAno(Util.getInt(dataQuebrada[2]));
		cliente.setDataNascimento(dataNascimento);

		cliente.setIdade(Util.getInt(tfIdade.getText()));
		// condicional ternária - if em uma linha
		cliente.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
		// contatos do cliente
		cliente.setTelefone(tfTelefone.getText());
		cliente.setCelular(tfCelular.getText());
		cliente.setEmail(tfEmail.getText());

		// retornando o objeto valorizado
		return cliente;

	} // fim do método getCliente

} // fim da classe