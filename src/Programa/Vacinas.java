package Programa;


import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vacinas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vacinas frame = new Vacinas();
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
	public Vacinas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 617);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioPrograma I = new InicioPrograma();
				I.setVisible(true);
				dispose();
			}
		});
		
		JButton btnExcluirCadastroDe = new JButton("Excluir Cadastro de Vacina");
		btnExcluirCadastroDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirVacina Tela = new ExcluirVacina();
				Tela.setVisible(true);
				dispose();
			}
		});
		btnExcluirCadastroDe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirCadastroDe.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnExcluirCadastroDe.setBounds(336, 399, 245, 40);
		getContentPane().add(btnExcluirCadastroDe);
		btnVoltarButton.setContentAreaFilled(false);
		btnVoltarButton.setBorderPainted(false);
		btnVoltarButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		btnVoltarButton.setBounds(432, 450, 71, 23);
		getContentPane().add(btnVoltarButton);
		
		JButton btnPesquisarButton = new JButton("Pesquisar Vacina");
		btnPesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarVacina P = new PesquisarVacina();
				P.setVisible(true);
				dispose();
			}
		});
		btnPesquisarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnPesquisarButton.setBounds(336, 339, 245, 40);
		getContentPane().add(btnPesquisarButton);
		
		JButton btnEditarButton = new JButton("Editar Cadastro de Vacina");
		btnEditarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCadastroVacina E = new EditarCadastroVacina();
				E.setVisible(true);
				dispose();
			}
		});
		btnEditarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnEditarButton.setBounds(336, 279, 245, 40);
		getContentPane().add(btnEditarButton);
		
		JButton btnCadastrarButton = new JButton("Cadastrar Nova Vacina");
		btnCadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVacina C = new CadastrarVacina();
				C.setVisible(true);
				dispose();
			}
		});
		btnCadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCadastrarButton.setBounds(336, 219, 245, 40);
		getContentPane().add(btnCadastrarButton);
		
		JLabel lblTituloLabel = new JLabel("Vacina");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(325, 156, 265, 32);
		getContentPane().add(lblTituloLabel);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(Vacinas.class.getResource("/Imagens/Imagem1.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 903, 590);
		getContentPane().add(lblFundoLabel);
	}

}
