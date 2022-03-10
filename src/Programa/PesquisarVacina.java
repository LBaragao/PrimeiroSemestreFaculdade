package Programa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisarVacina extends JFrame {

	private JPanel contentPane;
	private JTextField qtdVacinasField;
	private JTextField textField;
	private JTextField numDoseField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarVacina frame = new PesquisarVacina();
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
	public PesquisarVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox vacinaBox = new JComboBox();
		vacinaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Vacinacao().listarVacinas()));
		setLocationRelativeTo(null);
		
		numDoseField = new JTextField();
		numDoseField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		numDoseField.setEditable(false);
		numDoseField.setColumns(10);
		numDoseField.setBounds(360, 327, 57, 32);
		contentPane.add(numDoseField);
		vacinaBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		vacinaBox.setBounds(281, 191, 396, 32);
		contentPane.add(vacinaBox);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(281, 417, 69, 32);
		contentPane.add(textField);
		
		JLabel lblPorcentagem = new JLabel("%");
		lblPorcentagem.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPorcentagem.setBounds(360, 417, 18, 32);
		contentPane.add(lblPorcentagem);
		
		JLabel lblDias = new JLabel("dias.");
		lblDias.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDias.setBounds(479, 372, 188, 32);
		contentPane.add(lblDias);
		
		JLabel lblEficciaemPorcentagem = new JLabel("Efic\u00E1cia:");
		lblEficciaemPorcentagem.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEficciaemPorcentagem.setBounds(214, 417, 198, 32);
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
		btnVoltarButton.setBounds(432, 469, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		JTextField periodoField =  new JTextField();
		periodoField.setEditable(false);
		periodoField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		periodoField.setColumns(10);
		periodoField.setBounds(412, 372, 57, 32);
		getContentPane().add(periodoField);
		
		JLabel lblPeriodoLabel = new JLabel("Per\u00EDodo entre Aplica\u00E7\u00F5es:");
		lblPeriodoLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPeriodoLabel.setBounds(214, 372, 188, 32);
		getContentPane().add(lblPeriodoLabel);
		
		JLabel lblDoseUnicaLabel = new JLabel("N\u00FAmero de Doses:");
		lblDoseUnicaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDoseUnicaLabel.setBounds(214, 327, 132, 32);
		getContentPane().add(lblDoseUnicaLabel);
		
		qtdVacinasField = new JTextField();
		qtdVacinasField.setEditable(false);
		qtdVacinasField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		qtdVacinasField.setColumns(10);
		qtdVacinasField.setBounds(412, 282, 265, 32);
		getContentPane().add(qtdVacinasField);
		
		JLabel lblQtdVacinasLabel = new JLabel("Quantidade de Vacinas:");
		lblQtdVacinasLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblQtdVacinasLabel.setBounds(214, 282, 188, 32);
		getContentPane().add(lblQtdVacinasLabel);
		
		JLabel lblNomeLabel = new JLabel("Nome:");
		lblNomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeLabel.setBounds(214, 191, 57, 32);
		getContentPane().add(lblNomeLabel);
		
		JLabel lblTituloLabel = new JLabel("Pesquisar Vacina");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(329, 135, 265, 32);
		getContentPane().add(lblTituloLabel);
		
		JButton btnConfirmarId = new JButton("Confirmar Vacina");
		btnConfirmarId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmarId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vacina = (String) vacinaBox.getSelectedItem();
	            Vacinacao v = new Vacinacao();
	            v.setNome(vacina);
	            v.consultar();
	            	
	            // setando os campos do formulario com os dados vindos do banco.
	            vacinaBox.setToolTipText(String.valueOf(v.getNome()));
				qtdVacinasField.setText(String.valueOf(v.getQtdvacinas()));
				numDoseField.setText(String.valueOf(v.getDoseunica()));
				periodoField.setText(String.valueOf(v.getPeriodoentredoses()));
				textField.setText(String.valueOf(v.getEficacia()));
				
			}
		});
		btnConfirmarId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnConfirmarId.setBounds(214, 248, 157, 23);
		contentPane.add(btnConfirmarId);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(EditarCadastroVacina.class.getResource("/Imagens/Imagem1.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(0, 0, 903, 590);
		getContentPane().add(lblFundoLabel);
	}

}
