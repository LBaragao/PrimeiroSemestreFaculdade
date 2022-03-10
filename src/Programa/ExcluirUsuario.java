package Programa;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class ExcluirUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirUsuario frame = new ExcluirUsuario();
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
	public ExcluirUsuario() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeLabel = new JLabel("");
		lblNomeLabel.setVisible(false);
		lblNomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeLabel.setForeground(Color.BLACK);
		lblNomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNomeLabel.setBounds(226, 309, 348, 32);
		contentPane.add(lblNomeLabel);
		
		
		
		JLabel lblMensagemLabel = new JLabel("O USU\u00C1RIO A SEGUIR SER\u00C1 EXCLU\u00CDDO");
		lblMensagemLabel.setVisible(false);
		lblMensagemLabel.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblMensagemLabel.setForeground(Color.RED);
		lblMensagemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemLabel.setBounds(226, 274, 348, 14);
		contentPane.add(lblMensagemLabel);
		
		
		
		JFormattedTextField formattedCPFField = new JFormattedTextField();
		formattedCPFField.setToolTipText("");
		formattedCPFField.setName("");
		formattedCPFField.setForeground(Color.BLACK);
		formattedCPFField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedCPFField.setDisabledTextColor(SystemColor.textInactiveText);
		formattedCPFField.setBackground(Color.WHITE);
		formattedCPFField.setActionCommand("");
		formattedCPFField.setBounds(286, 215, 147, 32);
		getContentPane().add(formattedCPFField);
		try {
            formattedCPFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		
		JButton btnExcluirButton = new JButton("Excluir");
		btnExcluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = formattedCPFField.getText();
			

				Pessoa p = new Pessoa();
				
				p.setCpf(cpf);
				p.excluir();
				
				Cidadao Tela = new Cidadao();
				Tela.setVisible(true);
				dispose();
			}
		});
		btnExcluirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnExcluirButton.setBounds(462, 352, 112, 23);
		getContentPane().add(btnExcluirButton);
		
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
		btnVoltarButton.setBounds(226, 352, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		JLabel lblUsuarioLabel = new JLabel("CPF:");
		lblUsuarioLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblUsuarioLabel.setBounds(226, 212, 81, 32);
		getContentPane().add(lblUsuarioLabel);
		
		JLabel lblTituloLabel = new JLabel("Insira o CPF do Usu\u00E1rio que ser\u00E1 Excu\u00EDdo");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(213, 155, 377, 32);
		getContentPane().add(lblTituloLabel);
		
		JButton btnNewButton = new JButton("Confirmar Usu\u00E1rio");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = formattedCPFField.getText();
            	Pessoa p = new Pessoa();
            	p.setCpf(cpf);
            	p.consultar();
            	
            	// setando os campos do formulario com os dados vindos do banco.
            	lblNomeLabel.setText(p.getNome());
            	
            	lblMensagemLabel.setVisible(true);
        		lblNomeLabel.setVisible(true);
			}
		});
		btnNewButton.setBounds(440, 220, 134, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(ExcluirUsuario.class.getResource("/Imagens/profissional-prepara-vacina-contra-covid-19-para-aplicacao-no-rio-de-janeiro.jpeg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 796, 526);
		getContentPane().add(lblFundoLabel);
	}
}
