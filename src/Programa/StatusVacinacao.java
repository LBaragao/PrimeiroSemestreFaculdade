package Programa;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

public class StatusVacinacao extends JFrame {

	private JPanel contentPane;
	private JTextField idPacienteField;
	private JTextField idVacinaField;
	private JTextField todasDosesField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusVacinacao frame = new StatusVacinacao();
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
	public StatusVacinacao() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idPacienteField = new JTextField();
		idPacienteField.setVisible(false);
		idPacienteField.setBounds(340, 225, 365, 25);
		contentPane.add(idPacienteField);
		idPacienteField.setColumns(10);
		
		
		JLabel lblPrimeiraAplicao = new JLabel("Primeira Dose:");
		lblPrimeiraAplicao.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrimeiraAplicao.setBounds(196, 370, 170, 32);
		contentPane.add(lblPrimeiraAplicao);
		
		JFormattedTextField formattedDataField2_1 = new JFormattedTextField();
		formattedDataField2_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField2_1.setEditable(false);
		formattedDataField2_1.setBounds(322, 375, 110, 25);
		contentPane.add(formattedDataField2_1);
		try {
            formattedDataField2_1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JLabel lblTomouTodasAs = new JLabel("Tomou todas as doses?");
		lblTomouTodasAs.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTomouTodasAs.setBounds(196, 320, 168, 32);
		contentPane.add(lblTomouTodasAs);
		
		todasDosesField = new JTextField();
		todasDosesField.setEditable(false);
		todasDosesField.setColumns(10);
		todasDosesField.setBounds(374, 325, 50, 25);
		contentPane.add(todasDosesField);
		
		JFormattedTextField formattedDataField2 = new JFormattedTextField();
		formattedDataField2.setEditable(false);
		formattedDataField2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField2.setBounds(540, 425, 110, 25);
		contentPane.add(formattedDataField2);
		try {
            formattedDataField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JLabel lblPrximaAplicao = new JLabel("Data que tomou/ir\u00E1 tomar a segunda dose:");
		lblPrximaAplicao.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrximaAplicao.setBounds(196, 420, 309, 32);
		contentPane.add(lblPrximaAplicao);
		
		idVacinaField = new JTextField();
		idVacinaField.setEditable(false);
		idVacinaField.setColumns(10);
		idVacinaField.setBounds(360, 275, 145, 25);
		contentPane.add(idVacinaField);
		
		
		JButton btnVoltarButton = new JButton("Voltar");
		btnVoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioAplicarVacina iav = new InicioAplicarVacina();
				iav.setVisible(true);
				dispose();
			}
		});
		btnVoltarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVoltarButton.setBounds(285, 486, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		JLabel lblIdVacinaLabel = new JLabel("Vacina que tomou:");
		lblIdVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIdVacinaLabel.setBounds(196, 270, 194, 32);
		getContentPane().add(lblIdVacinaLabel);
		
		JLabel lblIdPacienteLabel = new JLabel("CPF do Paciente:");
		lblIdPacienteLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIdPacienteLabel.setBounds(196, 220, 118, 32);
		getContentPane().add(lblIdPacienteLabel);
		
		JLabel lblTituloLabel = new JLabel("Status de Aplica\u00E7\u00E3o da Vacina");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(265, 158, 364, 32);
		getContentPane().add(lblTituloLabel);
		
		
		JFormattedTextField formattedCPFField = new JFormattedTextField();
		formattedCPFField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedCPFField.setBounds(322, 225, 145, 25);
		contentPane.add(formattedCPFField);
		try {
            formattedCPFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JButton btnConsultarStatus = new JButton("Consultar Status");
		btnConsultarStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarStatus.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String cpf = formattedCPFField.getText();
				AplicarVacina av = new AplicarVacina();
				av.setCpf(cpf);
				av.consultar();
				
				formattedCPFField.setVisible(false);
				idPacienteField.setVisible(true);
				idPacienteField.setText(av.getNome1());
				idPacienteField.setEditable(false);
				lblIdPacienteLabel.setText("Nome do Paciente:");
				lblIdPacienteLabel.setBounds(196, 220, 140, 32);
				idPacienteField.setBounds(340, 225, 365, 25);
				idVacinaField.setText(av.getNome());
				formattedDataField2_1.setText(av.getPrimeiraAplicacaoFormatado());
				formattedDataField2.setText(av.getSegundaAplicacaoFormatado());
				todasDosesField.setText(av.getTodasdosesaplicadas());
				btnConsultarStatus.setVisible(false);
				
			}
		});
		
		
		btnConsultarStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnConsultarStatus.setBounds(493, 224, 168, 23);
		contentPane.add(btnConsultarStatus);
		
		
		JButton btnLimparButton = new JButton("Limpar Campos");
		btnLimparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formattedCPFField.setVisible(true);
				formattedCPFField.setText("");
				idPacienteField.setText("");
				idPacienteField.setVisible(false);;
				idPacienteField.setBounds(322, 225, 86, 25);
				lblIdPacienteLabel.setText("CPF do Paciente:");
				lblIdPacienteLabel.setBounds(196, 220, 118, 32);
				idVacinaField.setText("");
				todasDosesField.setText("");
				formattedDataField2_1.setText("");
				formattedDataField2.setText("");
				btnConsultarStatus.setVisible(true);
			}
		});
		btnLimparButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimparButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnLimparButton.setBounds(459, 486, 170, 23);
		contentPane.add(btnLimparButton);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(AplicacaoVacina.class.getResource("/Imagens/vacina-covid-19-voluntaria.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(-150, 0, 1105, 590);
		getContentPane().add(lblFundoLabel);
	}
}
