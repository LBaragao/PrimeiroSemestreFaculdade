package Programa;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EditarCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField enderecoField;
	private JTextField emailField;
	private JTextField cidadeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarCadastroUsuario frame = new EditarCadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditarCadastroUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JFormattedTextField formattedFone1Field = new JFormattedTextField();
		try {
            formattedFone1Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JFormattedTextField formattedFone2Field = new JFormattedTextField();
		try {
            formattedFone2Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		contentPane.setLayout(null);
		
		
		
		JLabel lblObrigatrio = new JLabel("Obrigat\u00F3rio(*)");
		lblObrigatrio.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblObrigatrio.setBounds(165, 76, 93, 14);
		contentPane.add(lblObrigatrio);
		
		JFormattedTextField formattedCPFField = new JFormattedTextField();
		formattedCPFField.setToolTipText("");
		formattedCPFField.setName("");
		formattedCPFField.setForeground(Color.BLACK);
		formattedCPFField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedCPFField.setDisabledTextColor(SystemColor.textInactiveText);
		formattedCPFField.setBackground(Color.WHITE);
		formattedCPFField.setActionCommand("");
		formattedCPFField.setBounds(210, 101, 132, 20);
		getContentPane().add(formattedCPFField);
		try {
            formattedCPFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JFormattedTextField formattedDataField = new JFormattedTextField();
		try {
            formattedDataField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		
		JComboBox estadoBox = new JComboBox();
		estadoBox.setModel(new DefaultComboBoxModel(new String[] {"", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		estadoBox.setBounds(483, 347, 145, 22);
		getContentPane().add(estadoBox);
		
		JButton btnConfirmarButton = new JButton("Confirmar Usu\u00E1rio");
		btnConfirmarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = formattedCPFField.getText();
            	Pessoa p = new Pessoa();
            	p.setCpf(cpf);
            	p.consultar();
            	
            	// setando os campos do formulario com os dados vindos do banco.
				nomeField.setText(p.getNome());
				formattedDataField.setText(p.getDtNascimentoFormatado());
				formattedFone1Field.setText(p.getFone1());
				formattedFone2Field.setText(p.getFone2());
				enderecoField.setText(p.getEndereco());
				cidadeField.setText(p.getCidade());
				estadoBox.setSelectedItem(p.getEstado());
				emailField.setText(p.getEmail());
				
			}
		});
		btnConfirmarButton.setBounds(374, 101, 155, 23);
		contentPane.add(btnConfirmarButton);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEstado.setBounds(422, 347, 64, 14);
		getContentPane().add(lblEstado);
		
		cidadeField = new JTextField();
		cidadeField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		cidadeField.setBounds(232, 347, 168, 20);
		getContentPane().add(cidadeField);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCidade.setBounds(165, 347, 81, 14);
		getContentPane().add(lblCidade);
		
		formattedFone2Field.setToolTipText("");
		formattedFone2Field.setName("");
		formattedFone2Field.setForeground(Color.BLACK);
		formattedFone2Field.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedFone2Field.setDisabledTextColor(SystemColor.textInactiveText);
		formattedFone2Field.setBackground(Color.WHITE);
		formattedFone2Field.setActionCommand("");
		formattedFone2Field.setBounds(496, 247, 132, 20);
		getContentPane().add(formattedFone2Field);
		formattedFone1Field.setToolTipText("");
		formattedFone1Field.setName("");
		formattedFone1Field.setForeground(Color.BLACK);
		formattedFone1Field.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedFone1Field.setDisabledTextColor(SystemColor.textInactiveText);
		formattedFone1Field.setBackground(Color.WHITE);
		formattedFone1Field.setActionCommand("");
		formattedFone1Field.setBounds(243, 247, 132, 20);
		getContentPane().add(formattedFone1Field);
		
		
		
		
		
		JButton btnEditarButton = new JButton("Salvar");
		btnEditarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeField.getText();
				String data = formattedDataField.getText();
				String cpf = formattedCPFField.getText();
				String fone1 = formattedFone1Field.getText();
				String fone2 = formattedFone2Field.getText();
				String endereco = enderecoField.getText();
				String cidade = cidadeField.getText();
				String estado = (String) estadoBox.getSelectedItem();
				String email = emailField.getText();

				Pessoa p = new Pessoa();
				p.setNome(nome);
				p.setDtNascimento(data);
				p.setCpf(cpf);
				p.setFone1(fone1);
				p.setFone2(fone2);
				p.setEndereco(endereco);
				p.setCidade(cidade);
				p.setEstado(estado);
				p.setEmail(email);
				p.alterar();
				
				Cidadao Tela = new Cidadao();
				Tela.setVisible(true);
				dispose();
			}
		});
		btnEditarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnEditarButton.setBounds(516, 462, 112, 23);
		getContentPane().add(btnEditarButton);	
		
		
		
		
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cidadao Tela = new Cidadao();
				Tela.setVisible(true);
				dispose();
			}
		});
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVoltarButton.setBounds(165, 462, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		
		emailField = new JTextField();
		emailField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		emailField.setColumns(10);
		emailField.setBounds(232, 397, 396, 20);
		getContentPane().add(emailField);
		
		JLabel lblEmailLabel = new JLabel("E-mail:");
		lblEmailLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEmailLabel.setBounds(165, 397, 57, 14);
		getContentPane().add(lblEmailLabel);
		
		enderecoField = new JTextField();
		enderecoField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		enderecoField.setColumns(10);
		enderecoField.setBounds(253, 297, 375, 20);
		getContentPane().add(enderecoField);
		
		JLabel lblEnderecoLabel = new JLabel("Endere\u00E7o:");
		lblEnderecoLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEnderecoLabel.setBounds(165, 297, 81, 14);
		getContentPane().add(lblEnderecoLabel);
		
		JLabel lblFone2 = new JLabel("Telefone Fixo:");
		lblFone2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFone2.setBounds(387, 247, 112, 14);
		getContentPane().add(lblFone2);
		
		JLabel lblFone = new JLabel("Celular*:");
		lblFone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFone.setBounds(165, 247, 81, 14);
		getContentPane().add(lblFone);
		formattedDataField.setToolTipText("");
		formattedDataField.setName("");
		formattedDataField.setForeground(Color.BLACK);
		formattedDataField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField.setDisabledTextColor(SystemColor.textInactiveText);
		formattedDataField.setBackground(Color.WHITE);
		formattedDataField.setActionCommand("");
		formattedDataField.setBounds(330, 197, 99, 20);
		getContentPane().add(formattedDataField);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento*:");
		lblDataDeNascimento.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(165, 197, 155, 14);
		getContentPane().add(lblDataDeNascimento);
		
		nomeField = new JTextField();
		nomeField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		nomeField.setBounds(232, 147, 396, 20);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNomeLabel = new JLabel("Nome*:");
		lblNomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeLabel.setBounds(165, 147, 57, 14);
		getContentPane().add(lblNomeLabel);
		
		JLabel lblUsuarioLabel = new JLabel("CPF:");
		lblUsuarioLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsuarioLabel.setBounds(165, 101, 37, 14);
		getContentPane().add(lblUsuarioLabel);
		
		JLabel lblTituloLabel = new JLabel("Cadastro");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(345, 39, 117, 32);
		getContentPane().add(lblTituloLabel);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(EditarCadastroUsuario.class.getResource("/Imagens/profissional-prepara-vacina-contra-covid-19-para-aplicacao-no-rio-de-janeiro (1).jpeg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 796, 526);
		getContentPane().add(lblFundoLabel);
	}
}
