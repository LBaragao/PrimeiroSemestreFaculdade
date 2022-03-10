package Programa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class InicioAplicarVacina extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioAplicarVacina frame = new InicioAplicarVacina();
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
	public InicioAplicarVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.setBorderPainted(false);
		btnVoltarButton.setContentAreaFilled(false);
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioPrograma Tela = new InicioPrograma();
				Tela.setVisible(true);
				dispose();
			}
		});
		
		JButton btnConsultarStatusDe = new JButton("Consultar Status de Aplica\u00E7\u00E3o da Vacina");
		btnConsultarStatusDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusVacinacao sv = new StatusVacinacao();
				sv.setVisible(true);
				dispose();
			}
		});
		
		JButton btnRelatrioDeAplicao = new JButton("Relat\u00F3rio: N\u00E3o Aplicou Todas as Doses");
		btnRelatrioDeAplicao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatrioDeAplicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio tela = new Relatorio();
				tela.setVisible(true);
				dispose();
			}
		});
		
		JButton btnRelatrioDeAplicao_1 = new JButton("Relat\u00F3rio: Aplicou Todas as Doses");
		btnRelatrioDeAplicao_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatrioDeAplicao_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio2 tela = new Relatorio2();
				tela.setVisible(true);
				dispose();
			}
		});
		btnRelatrioDeAplicao_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnRelatrioDeAplicao_1.setBounds(264, 430, 370, 38);
		contentPane.add(btnRelatrioDeAplicao_1);
		btnRelatrioDeAplicao.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnRelatrioDeAplicao.setBounds(264, 365, 370, 38);
		contentPane.add(btnRelatrioDeAplicao);
		btnConsultarStatusDe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarStatusDe.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnConsultarStatusDe.setBounds(264, 300, 370, 38);
		contentPane.add(btnConsultarStatusDe);
		
		JButton btnNewButton = new JButton("Registrar Aplica\u00E7\u00E3o da Vacina");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicacaoVacina av = new AplicacaoVacina();
				av.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(264, 235, 370, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblAplicaoDaVacina = new JLabel("Aplica\u00E7\u00E3o da Vacina");
		lblAplicaoDaVacina.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicaoDaVacina.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblAplicaoDaVacina.setBounds(264, 167, 370, 32);
		contentPane.add(lblAplicaoDaVacina);
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVoltarButton.setBounds(392, 491, 107, 23);
		getContentPane().add(btnVoltarButton);
		
		
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(AplicacaoVacina.class.getResource("/Imagens/vacina-covid-19-voluntaria.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(-150, 0, 1105, 590);
		getContentPane().add(lblFundoLabel);
	}
}
