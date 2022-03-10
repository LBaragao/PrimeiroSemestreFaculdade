package Programa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFormattedTextField formattedCPFField = new JFormattedTextField();
		try {
            formattedCPFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JButton btnCadastrarButton = new JButton("N\u00E3o possui conta? Cadastrar");
		btnCadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrarButton.setContentAreaFilled(false);
		btnCadastrarButton.setBorderPainted(false);
		btnCadastrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnCadastrarButton.setBounds(391, 375, 192, 23);
		getContentPane().add(btnCadastrarButton);
		
		JButton btnEsqueciSenhaButton = new JButton("Esqueci minha senha");
		btnEsqueciSenhaButton.setContentAreaFilled(false);
		btnEsqueciSenhaButton.setBorderPainted(false);
		btnEsqueciSenhaButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnEsqueciSenhaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEsqueciSenhaButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnEsqueciSenhaButton.setBounds(230, 375, 151, 23);
		getContentPane().add(btnEsqueciSenhaButton);
		
		JButton btnEntrarButton = new JButton("Entrar");
		btnEntrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnEntrarButton.setBounds(364, 338, 81, 23);
		getContentPane().add(btnEntrarButton);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(293, 290, 274, 20);
		getContentPane().add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSenha.setBounds(230, 290, 57, 14);
		getContentPane().add(lblSenha);
		formattedCPFField.setName("");
		formattedCPFField.setForeground(new Color(0, 0, 0));
		formattedCPFField.setBackground(new Color(255, 255, 255));
		formattedCPFField.setActionCommand("");
		formattedCPFField.setDisabledTextColor(new Color(109, 109, 109));
		formattedCPFField.setToolTipText("");
		formattedCPFField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedCPFField.setBounds(293, 240, 274, 20);
		getContentPane().add(formattedCPFField);
		
		JLabel lblUsuarioLabel = new JLabel("CPF:");
		lblUsuarioLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUsuarioLabel.setBounds(230, 240, 37, 14);
		getContentPane().add(lblUsuarioLabel);
		
		JLabel lblTituloLabel = new JLabel("Login");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(375, 175, 57, 32);
		getContentPane().add(lblTituloLabel);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon("C:\\Users\\Lucas Winkler\\Desktop\\profissional-prepara-vacina-contra-covid-19-para-aplicacao-no-rio-de-janeiro.jpeg"));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 804, 536);
		getContentPane().add(lblFundoLabel);
	}

}
