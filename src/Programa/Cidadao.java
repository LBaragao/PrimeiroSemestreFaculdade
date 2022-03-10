package Programa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Cidadao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cidadao frame = new Cidadao();
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
	public Cidadao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioPrograma I = new InicioPrograma();
				I.setVisible(true);
				dispose();
			}
		});
		btnVoltarButton.setContentAreaFilled(false);
		btnVoltarButton.setBorderPainted(false);
		btnVoltarButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnVoltarButton.setBounds(369, 402, 71, 23);
		getContentPane().add(btnVoltarButton);
		
		JButton btnExcluirButton = new JButton("Excluir Cadastro");
		btnExcluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirUsuario Excluir = new ExcluirUsuario();
				Excluir.setVisible(true);
				dispose();
			}
		});
		btnExcluirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnExcluirButton.setBounds(274, 360, 245, 40);
		getContentPane().add(btnExcluirButton);
		
		JButton btnPesquisarButton = new JButton("Pesquisar Cidad\u00E3o");
		btnPesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarUsuario Pesquisar = new PesquisarUsuario();
				Pesquisar.setVisible(true);
				dispose();
			}
		});
		btnPesquisarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnPesquisarButton.setBounds(274, 305, 245, 40);
		getContentPane().add(btnPesquisarButton);
		
		JButton btnEditarButton = new JButton("Editar Cadastro");
		btnEditarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCadastroUsuario Editar = new EditarCadastroUsuario();
				Editar.setVisible(true);
				dispose();
			}
		});
		btnEditarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnEditarButton.setBounds(274, 250, 245, 40);
		getContentPane().add(btnEditarButton);
		
		JButton btnCadastrarButton = new JButton("Cadastrar Cidad\u00E3o");
		btnCadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario Cadastrar = new CadastrarUsuario();
				Cadastrar.setVisible(true);
				dispose();
			}
		});
		btnCadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCadastrarButton.setBounds(274, 195, 245, 40);
		getContentPane().add(btnCadastrarButton);
		
		JLabel lblTituloLabel = new JLabel("Cidad\u00E3o");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(267, 152, 265, 32);
		getContentPane().add(lblTituloLabel);
		
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(Cidadao.class.getResource("/Imagens/profissional-prepara-vacina-contra-covid-19-para-aplicacao-no-rio-de-janeiro.jpeg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 796, 526);
		getContentPane().add(lblFundoLabel);
	}

	

}
