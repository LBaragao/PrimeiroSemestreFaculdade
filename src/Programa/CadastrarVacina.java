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
import javax.swing.DefaultComboBoxModel;
import java.lang.NumberFormatException;

public class CadastrarVacina extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField numDoseField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVacina frame = new CadastrarVacina();
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
	public CadastrarVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numDoseField = new JTextField();
		numDoseField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		numDoseField.setColumns(10);
		numDoseField.setBounds(368, 305, 57, 32);
		contentPane.add(numDoseField);
		
		JLabel lblObrigatrio = new JLabel("Obrigat\u00F3rio(*)");
		lblObrigatrio.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblObrigatrio.setBounds(214, 190, 93, 14);
		contentPane.add(lblObrigatrio);
		
		JLabel lblDias = new JLabel("dias.");
		lblDias.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDias.setBounds(463, 351, 81, 32);
		contentPane.add(lblDias);
		
		
		JLabel lblPorcentagem = new JLabel("%");
		lblPorcentagem.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPorcentagem.setBounds(384, 395, 18, 32);
		contentPane.add(lblPorcentagem);
		
		textField = new JTextField();
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(305, 395, 69, 32);
		contentPane.add(textField);
		
		JLabel lblEficciaemPorcentagem = new JLabel("Efic\u00E1cia:*");
		lblEficciaemPorcentagem.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEficciaemPorcentagem.setBounds(214, 395, 69, 32);
		getContentPane().add(lblEficciaemPorcentagem);
		
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacinas V = new Vacinas();
				V.setVisible(true);
				dispose();
			}
		});
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVoltarButton.setBounds(214, 450, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		JTextField periodoField = new JTextField();
		periodoField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		periodoField.setColumns(10);
		periodoField.setBounds(412, 351, 41, 32);
		getContentPane().add(periodoField);
		
		JLabel lblPeriodoLabel = new JLabel("Per\u00EDodo entre Aplica\u00E7\u00F5es:");
		lblPeriodoLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPeriodoLabel.setBounds(214, 350, 198, 32);
		getContentPane().add(lblPeriodoLabel);
		
		JLabel lblDoseUnicaLabel = new JLabel("N\u00FAmero de doses:*");
		lblDoseUnicaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDoseUnicaLabel.setBounds(214, 305, 153, 32);
		getContentPane().add(lblDoseUnicaLabel);
		
		JTextField qtdVacinasField = new JTextField();
		qtdVacinasField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		qtdVacinasField.setColumns(10);
		qtdVacinasField.setBounds(412, 260, 132, 32);
		getContentPane().add(qtdVacinasField);
		
		JLabel lblQtdVacinasLabel = new JLabel("Quantidade de Vacinas:*");
		lblQtdVacinasLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblQtdVacinasLabel.setBounds(214, 260, 188, 32);
		getContentPane().add(lblQtdVacinasLabel);
		
		JTextField nomeField = new JTextField();
		nomeField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		nomeField.setBounds(281, 215, 396, 32);
		getContentPane().add(nomeField);
		nomeField.setColumns(10);
		
		JLabel lblNomeLabel = new JLabel("Nome:*");
		lblNomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeLabel.setBounds(214, 215, 57, 32);
		getContentPane().add(lblNomeLabel);
		
		JButton btnCadastrarButton = new JButton("Cadastrar");
		btnCadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeField.getText();
				int qtdVacinas = 0;
				
				try {
					qtdVacinas = Integer.parseInt(qtdVacinasField.getText());
				}
				catch(NumberFormatException erro) {
					qtdVacinas = 0;
				}
				
				int doseunica = 0;
				try {
					doseunica = Integer.parseInt(numDoseField.getText());
				}
				catch(NumberFormatException erro) {
					doseunica = 0;
				}
				
				int periodoentredoses = -99;
				try {
					periodoentredoses = Integer.parseInt(periodoField.getText());
				}
				catch(NumberFormatException erro2) {
					periodoentredoses = -99;
				}
				
				double eficacia = 0;
				try {
					eficacia = Double.parseDouble(textField.getText());
				}
				catch(NumberFormatException erro3) {
					eficacia = 0;
				}
				Vacinacao v = new Vacinacao();
				v.setNome(nome);
				v.setQtdvacinas(qtdVacinas);
				v.setDoseunica(doseunica);
				
				v.setPeriodoentredoses(periodoentredoses);
				v.setEficacia(eficacia);
				v.inserir();
				
				Vacinas tela = new Vacinas();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCadastrarButton.setBounds(565, 448, 112, 23);
		getContentPane().add(btnCadastrarButton);
		
		JLabel lblTituloLabel = new JLabel("Cadastrar Vacina");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(368, 155, 183, 32);
		getContentPane().add(lblTituloLabel);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(CadastrarVacina.class.getResource("/Imagens/Imagem1.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 906, 592);
		getContentPane().add(lblFundoLabel);
	}
}
