package Programa;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AplicacaoVacina extends JFrame {

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
					AplicacaoVacina frame = new AplicacaoVacina();
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
	public AplicacaoVacina() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrimeiraAplicao = new JLabel("Primeira Dose:");
		lblPrimeiraAplicao.setVisible(false);
		
		idPacienteField = new JTextField();
		idPacienteField.setVisible(false);
		
		JComboBox doseBox = new JComboBox();
		
		JFormattedTextField formattedCPFField = new JFormattedTextField();
		
		JComboBox vacinaBox = new JComboBox();
		vacinaBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String valor = (String) e.getItem();
					
					doseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new AplicarVacina().listarDosesVacina(valor)));
                }
			}
		});
		vacinaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new AplicarVacina().listarVacinas()));
		setLocationRelativeTo(null);
		vacinaBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		vacinaBox.setBounds(265, 290, 170, 25);
		contentPane.add(vacinaBox);
		idPacienteField.setBounds(322, 225, 86, 25);
		contentPane.add(idPacienteField);
		idPacienteField.setColumns(10);
		
		
		formattedCPFField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String valorCampoCpf = formattedCPFField.getText();
				String qualVacinaFoiAplicada = new AplicarVacina().qualVacinaFoiAplicada(valorCampoCpf);
				String valor = (String) vacinaBox.getSelectedItem();
				
				if(!qualVacinaFoiAplicada.equals("")) {
					vacinaBox.setSelectedItem(qualVacinaFoiAplicada);
					vacinaBox.setEnabled(false);
					doseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new AplicarVacina().listarDosesVacina(valor)));
				}
				else {
					vacinaBox.setEnabled(true);
				}
			}
		});
		formattedCPFField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedCPFField.setBounds(322, 225, 168, 25);
		contentPane.add(formattedCPFField);
		try {
            formattedCPFField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		
		lblPrimeiraAplicao.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrimeiraAplicao.setBounds(196, 350, 170, 32);
		contentPane.add(lblPrimeiraAplicao);
		
		String valor = (String) vacinaBox.getSelectedItem();
		doseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new AplicarVacina().listarDosesVacina(valor)));
		doseBox.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		doseBox.setBounds(268, 417, 140, 32);
		contentPane.add(doseBox);
		
		JFormattedTextField formattedDataField2_1 = new JFormattedTextField();
		formattedDataField2_1.setVisible(false);
		formattedDataField2_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField2_1.setEditable(false);
		formattedDataField2_1.setBounds(322, 355, 110, 25);
		contentPane.add(formattedDataField2_1);
		
		JLabel lblTomouTodasAs = new JLabel("Tomou todas as doses?");
		lblTomouTodasAs.setVisible(false);
		lblTomouTodasAs.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTomouTodasAs.setBounds(487, 285, 168, 32);
		contentPane.add(lblTomouTodasAs);
		
		todasDosesField = new JTextField();
		todasDosesField.setEditable(false);
		todasDosesField.setVisible(false);
		todasDosesField.setColumns(10);
		todasDosesField.setBounds(652, 290, 50, 25);
		contentPane.add(todasDosesField);
		
		JFormattedTextField formattedDataField2 = new JFormattedTextField();
		formattedDataField2.setVisible(false);
		formattedDataField2.setEditable(false);
		formattedDataField2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField2.setBounds(322, 420, 110, 25);
		contentPane.add(formattedDataField2);
		try {
            formattedDataField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JLabel lblPrximaAplicao = new JLabel("Segunda Dose:");
		lblPrximaAplicao.setVisible(false);
		lblPrximaAplicao.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPrximaAplicao.setBounds(196, 415, 170, 32);
		contentPane.add(lblPrximaAplicao);
		
		
		JLabel lblDose = new JLabel("Dose:");
		lblDose.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDose.setBounds(196, 415, 56, 32);
		contentPane.add(lblDose);
		
		idVacinaField = new JTextField();
		idVacinaField.setVisible(false);
		idVacinaField.setColumns(10);
		idVacinaField.setBounds(265, 290, 170, 25);
		contentPane.add(idVacinaField);
		
		
		JFormattedTextField formattedDataField = new JFormattedTextField();
		formattedDataField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		formattedDataField.setBounds(263, 355, 110, 25);
		getContentPane().add(formattedDataField);
		try {
            formattedDataField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JLabel lblDataDaAplicao = new JLabel("Data:");
		lblDataDaAplicao.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDataDaAplicao.setBounds(196, 350, 70, 32);
		getContentPane().add(lblDataDaAplicao);
		
		
		
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
		btnVoltarButton.setBounds(196, 489, 81, 23);
		getContentPane().add(btnVoltarButton);
		
		JLabel lblIdVacinaLabel = new JLabel("Vacina:");
		lblIdVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIdVacinaLabel.setBounds(196, 285, 125, 32);
		getContentPane().add(lblIdVacinaLabel);
		
		JLabel lblIdPacienteLabel = new JLabel("CPF do Paciente:");
		lblIdPacienteLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIdPacienteLabel.setBounds(196, 220, 118, 32);
		getContentPane().add(lblIdPacienteLabel);
		
		JLabel lblTituloLabel = new JLabel("Registrar Aplica\u00E7\u00E3o da Vacina");
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(303, 158, 303, 32);
		getContentPane().add(lblTituloLabel);
		
		JButton btnConsultarStatus = new JButton("Consultar Status");
		btnConsultarStatus.setVisible(false);
		btnConsultarStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = formattedCPFField.getText();
				AplicarVacina av = new AplicarVacina();
				av.setCpf(cpf);
				av.consultar();
				
				vacinaBox.setVisible(false);
				idVacinaField.setVisible(true);
				formattedCPFField.setVisible(false);
				lblDataDaAplicao.setVisible(false);
				formattedDataField.setVisible(false);
				lblPrimeiraAplicao.setVisible(true);
				formattedDataField2_1.setVisible(true);
				lblPrximaAplicao.setVisible(true);
				formattedDataField2.setVisible(true);
				lblTomouTodasAs.setVisible(true);
				todasDosesField.setVisible(true);
				lblDose.setVisible(false);
				doseBox.setVisible(false);
				lblIdPacienteLabel.setText("Nome do Paciente:");
				lblIdPacienteLabel.setBounds(196, 220, 140, 32);
				idPacienteField.setVisible(true);
				idPacienteField.setBounds(340, 225, 365, 25);
				idPacienteField.setEditable(false);
				idVacinaField.setEditable(false);
				lblIdVacinaLabel.setBounds(196, 285, 125, 32);
				lblIdVacinaLabel.setText("Vacina:");
				idVacinaField.setBounds(265, 290, 170, 25);
				
				
				idPacienteField.setText(av.getNome1());
				idVacinaField.setText(av.getNome());
				doseBox.setSelectedItem(av.getDoseunica());
				formattedDataField2_1.setText(av.getPrimeiraAplicacaoFormatado());
				formattedDataField2.setText(av.getSegundaAplicacaoFormatado());
				todasDosesField.setText(av.getTodasdosesaplicadas());
				
			}
		});
		btnConsultarStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnConsultarStatus.setBounds(322, 489, 168, 23);
		contentPane.add(btnConsultarStatus);
		
		JButton btnCadastrarButton = new JButton("Registrar Aplica\u00E7\u00E3o");
		btnCadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = formattedCPFField.getText();
				
				String vacina = (String) vacinaBox.getSelectedItem();
				
				String doses = (String) doseBox.getSelectedItem();
				String dataUm = formattedDataField.getText();
				AplicarVacina av = new AplicarVacina();
				av.setCpf(cpf);
				av.setNome(vacina);
				av.setDoseunica(doses);
				av.setPrimeiraAplicacao(dataUm);
				av.inserir();
				
				btnCadastrarButton.setVisible(false);
				btnConsultarStatus.setVisible(true);
								
				
			}
		});
		btnCadastrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrarButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnCadastrarButton.setBounds(310, 489, 184, 23);
		getContentPane().add(btnCadastrarButton);
		
		JButton btnLimparButton = new JButton("Limpar Campos");
		btnLimparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vacinaBox.setEnabled(true);
				btnConsultarStatus.setVisible(false);
				vacinaBox.setVisible(true);
				idVacinaField.setVisible(false);
				formattedCPFField.setText("");
				formattedCPFField.setVisible(true);
				idPacienteField.setVisible(false);
				idPacienteField.setText("");
				idVacinaField.setText("");
				doseBox.setSelectedItem("");
				formattedDataField.setText("");
				lblIdPacienteLabel.setText("CPF do Paciente:");
				lblIdPacienteLabel.setBounds(196, 220, 118, 32);
				idPacienteField.setBounds(322, 225, 86, 25);
				idPacienteField.setEditable(true);
				lblDataDaAplicao.setVisible(true);
				formattedDataField.setVisible(true);
				lblPrimeiraAplicao.setVisible(false);
				formattedDataField2_1.setVisible(false);
				lblPrximaAplicao.setVisible(false);
				formattedDataField2.setVisible(false);
				lblTomouTodasAs.setVisible(false);
				todasDosesField.setVisible(false);
				btnCadastrarButton.setVisible(true);
				lblDose.setVisible(true);
				doseBox.setVisible(true);
				idVacinaField.setEditable(true);
				btnCadastrarButton.setVisible(true);
				
			}
		});
		btnLimparButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimparButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnLimparButton.setBounds(532, 489, 170, 23);
		contentPane.add(btnLimparButton);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(AplicacaoVacina.class.getResource("/Imagens/vacina-covid-19-voluntaria.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblFundoLabel.setBounds(-150, 0, 1105, 590);
		getContentPane().add(lblFundoLabel);
	}
}
