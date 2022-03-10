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


public class CadastrarUsuario extends JFrame {

	private JPanel contentPane;
	public JTextField nomeField;
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
					CadastrarUsuario frame = new CadastrarUsuario();
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
	public CadastrarUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JFormattedTextField formattedFone1Field = new JFormattedTextField();
		formattedFone1Field.setBounds(245, 202, 132, 20);
		try {
            formattedFone1Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JFormattedTextField formattedFone2Field = new JFormattedTextField();
		formattedFone2Field.setBounds(496, 202, 132, 20);
		try {
            formattedFone2Field.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JComboBox estadoBox = new JComboBox();
		estadoBox.setBounds(483, 302, 145, 22);
		estadoBox.setModel(new DefaultComboBoxModel(new String[] {"", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1", "Distrito Federal", "Esp\u00EDrito Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1", "Pernambuco", "Piau\u00ED", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins"}));
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(422, 302, 64, 14);
		lblEstado.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		cidadeField = new JTextField();
		cidadeField.setBounds(232, 302, 168, 20);
		cidadeField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(165, 302, 81, 14);
		lblCidade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		formattedFone2Field.setToolTipText("");
		formattedFone2Field.setName("");
		formattedFone2Field.setForeground(Color.BLACK);
		formattedFone2Field.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedFone2Field.setDisabledTextColor(SystemColor.textInactiveText);
		formattedFone2Field.setBackground(Color.WHITE);
		formattedFone2Field.setActionCommand("");
		formattedFone1Field.setToolTipText("");
		formattedFone1Field.setName("");
		formattedFone1Field.setForeground(Color.BLACK);
		formattedFone1Field.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedFone1Field.setDisabledTextColor(SystemColor.textInactiveText);
		formattedFone1Field.setBackground(Color.WHITE);
		formattedFone1Field.setActionCommand("");
		
		
		JFormattedTextField formattedCPFField = new JFormattedTextField();
		formattedCPFField.setBounds(496, 152, 132, 20);
		formattedCPFField.setToolTipText("");
		formattedCPFField.setName("");
		formattedCPFField.setForeground(Color.BLACK);
		formattedCPFField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedCPFField.setDisabledTextColor(SystemColor.textInactiveText);
		formattedCPFField.setBackground(Color.WHITE);
		formattedCPFField.setActionCommand("");
		try {
            formattedCPFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JFormattedTextField formattedDataField = new JFormattedTextField();
		formattedDataField.setBounds(330, 152, 99, 20);
		try {
            formattedDataField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JButton btnCadastrarButton = new JButton("Cadastrar");
		btnCadastrarButton.setBounds(516, 462, 112, 23);
		btnCadastrarButton.addActionListener(new ActionListener() {
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
				
				
				p.inserir();
				Cidadao Tela = new Cidadao();
				Tela.setVisible(true);
				dispose();
				
				
				
			}
		});
		
		
		
		btnCadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.setBounds(165, 462, 81, 23);
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cidadao Tela = new Cidadao();
				Tela.setVisible(true);
				dispose();
			}
		});
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		
		
		emailField = new JTextField();
		emailField.setBounds(232, 352, 396, 20);
		emailField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		emailField.setColumns(10);
		
		JLabel lblEmailLabel = new JLabel("E-mail:");
		lblEmailLabel.setBounds(165, 352, 57, 14);
		lblEmailLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		enderecoField = new JTextField();
		enderecoField.setBounds(253, 252, 375, 20);
		enderecoField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		enderecoField.setColumns(10);
		
		JLabel lblEnderecoLabel = new JLabel("Endere\u00E7o:");
		lblEnderecoLabel.setBounds(165, 252, 81, 14);
		lblEnderecoLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel lblFone2 = new JLabel("Telefone Fixo:");
		lblFone2.setBounds(387, 202, 99, 14);
		lblFone2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel lblFone = new JLabel("Celular:*");
		lblFone.setBounds(165, 202, 81, 14);
		lblFone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		formattedDataField.setToolTipText("");
		formattedDataField.setName("");
		formattedDataField.setForeground(Color.BLACK);
		formattedDataField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField.setDisabledTextColor(SystemColor.textInactiveText);
		formattedDataField.setBackground(Color.WHITE);
		formattedDataField.setActionCommand("");
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:*");
		lblDataDeNascimento.setBounds(165, 152, 155, 14);
		lblDataDeNascimento.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		nomeField = new JTextField();
		nomeField.setBounds(232, 102, 396, 20);
		nomeField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		nomeField.setColumns(10);
		
		JLabel lblNomeLabel = new JLabel("Nome:*");
		lblNomeLabel.setBounds(165, 102, 57, 14);
		lblNomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel lblUsuarioLabel = new JLabel("CPF:*");
		lblUsuarioLabel.setBounds(451, 152, 37, 14);
		lblUsuarioLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		
		JLabel lblTituloLabel = new JLabel("Cadastro");
		lblTituloLabel.setBounds(345, 39, 117, 32);
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setBounds(-3, 0, 796, 526);
		lblFundoLabel.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/Imagens/profissional-prepara-vacina-contra-covid-19-para-aplicacao-no-rio-de-janeiro (1).jpeg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		contentPane.setLayout(null);
		
		JLabel lblObrigatrio = new JLabel("Obrigat\u00F3rio(*)");
		lblObrigatrio.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblObrigatrio.setBounds(165, 77, 93, 14);
		contentPane.add(lblObrigatrio);
		contentPane.add(lblFone);
		contentPane.add(lblCidade);
		contentPane.add(cidadeField);
		contentPane.add(btnVoltarButton);
		contentPane.add(nomeField);
		contentPane.add(lblTituloLabel);
		contentPane.add(lblEmailLabel);
		contentPane.add(lblEstado);
		contentPane.add(formattedFone1Field);
		contentPane.add(lblUsuarioLabel);
		contentPane.add(lblNomeLabel);
		contentPane.add(formattedDataField);
		contentPane.add(formattedFone2Field);
		contentPane.add(btnCadastrarButton);
		contentPane.add(emailField);
		contentPane.add(lblFone2);
		contentPane.add(enderecoField);
		contentPane.add(estadoBox);
		contentPane.add(lblEnderecoLabel);
		contentPane.add(lblDataDeNascimento);
		contentPane.add(formattedCPFField);
		contentPane.add(lblFundoLabel);
	}
}
