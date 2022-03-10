package Programa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.Color;

public class ExcluirVacina extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcluirVacina frame = new ExcluirVacina();
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
	public ExcluirVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacinas V = new Vacinas();
				V.setVisible(true);
				dispose();
			}
		});
		JLabel lblNomeVacina = new JLabel("CASO SIM, CLIQUE EM EXCLUIR. CASO NÃO, CLIQUE EM VOLTAR.");
		lblNomeVacina.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Vacinacao().listarVacinas()));
		comboBox.setBounds(278, 240, 232, 32);
		contentPane.add(comboBox);
		lblNomeVacina.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeVacina.setForeground(Color.BLACK);
		lblNomeVacina.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeVacina.setBounds(214, 348, 463, 32);
		contentPane.add(lblNomeVacina);
		
		JLabel lblNewLabel = new JLabel("DESEJA REALMENTE EXCLUIR ESTA VACINA?");
		lblNewLabel.setVisible(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(214, 305, 463, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnExcluirButton = new JButton("Excluir");
		
		JButton btnVacinaQueDeseja = new JButton("Confirmar Vacina");
		btnVacinaQueDeseja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = (String) comboBox.getSelectedItem();
	            Vacinacao v = new Vacinacao();
	            v.setNome(nome);
	            v.consultar();
	            
	            lblNewLabel.setVisible(true);
	            lblNomeVacina.setVisible(true);
	            btnExcluirButton.setEnabled(true);
	            
	            	
	            // setando os campos do formulario com os dados vindos do banco.
				
				
			}
		});
		
		
		
		
		
		btnVacinaQueDeseja.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVacinaQueDeseja.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVacinaQueDeseja.setBounds(520, 240, 157, 32);
		contentPane.add(btnVacinaQueDeseja);
		
		JLabel lblId = new JLabel("Nome:");
		lblId.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblId.setBounds(214, 240, 57, 32);
		contentPane.add(lblId);
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVoltarButton.setBounds(214, 412, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		
		btnExcluirButton.setEnabled(false);
		btnExcluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = (String) comboBox.getSelectedItem();
				
				Vacinacao v = new Vacinacao();
				
				v.setNome(nome);
				v.excluir();
				
				Vacinas Tela = new Vacinas();
				Tela.setVisible(true);
				dispose();
				
			}
		});
		btnExcluirButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnExcluirButton.setBounds(565, 410, 112, 23);
		getContentPane().add(btnExcluirButton);
		
		JLabel lblTituloLabel = new JLabel("Excluir Vacina");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(360, 155, 183, 32);
		getContentPane().add(lblTituloLabel);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(ExcluirVacina.class.getResource("/Imagens/Imagem1.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 906, 592);
		getContentPane().add(lblFundoLabel);
	}
}
