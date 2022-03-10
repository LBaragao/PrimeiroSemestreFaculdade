package Programa;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextPane;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicio extends JFrame {

	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 809);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setOpaque(false);
		table.setName("");
		table.setToolTipText("");
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"CoronaVac", "V\u00EDrus Inativado", "N\u00E3o", "2 semanas", "50,38%"},
				{"Oxford/AstraZeneca", "Adenov\u00EDrus", "N\u00E3o", "3 meses", "70%"},
				{"Pfizer", "RNA Mensageiro", "N\u00E3o", "Entre 2 e 4 semanas", "95%"},
				{"Johnson & Johnson", "Adenov\u00EDrus", "Sim", "-", "66%"},
				{"Sputnik V", "Adenov\u00EDrus", "N\u00E3o", "3 semanas", "91,6%"},
			},
			new String[] {
				"Nome", "Tecnologia", "Dose \u00DAnica?", "Per\u00EDodo entre Aplica\u00E7\u00F5es", "Efic\u00E1cia"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(109);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(76);
		table.getColumnModel().getColumn(3).setPreferredWidth(139);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		
		JTextPane txtpnIndependenteDaVacina = new JTextPane();
		txtpnIndependenteDaVacina.setEditable(false);
		txtpnIndependenteDaVacina.setOpaque(false);
		txtpnIndependenteDaVacina.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		txtpnIndependenteDaVacina.setText("Independente da Vacina que for disponibilizada para voc\u00EA tomar, o importante \u00E9 se imunizar. O \u00FAnico jeito de acabarmos com esse v\u00EDrus \u00E9 nos imunizando. Quando chegar sua hora de ser vacinado, n\u00E3o perca tempo, cadastre-se logo para poder se vacinar.\r\nVacine-se!");
		txtpnIndependenteDaVacina.setBounds(166, 542, 696, 158);
		getContentPane().add(txtpnIndependenteDaVacina);
		table.setBounds(166, 428, 696, 80);
		getContentPane().add(table);
		
		JLabel lblEficaciaVacinaLabel = new JLabel("Efic\u00E1cia");
		lblEficaciaVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEficaciaVacinaLabel.setBounds(759, 403, 100, 22);
		getContentPane().add(lblEficaciaVacinaLabel);
		
		JLabel lblPeriodoVacinaLabel = new JLabel("Per\u00EDodo entre Aplica\u00E7\u00F5es");
		lblPeriodoVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblPeriodoVacinaLabel.setBounds(576, 403, 178, 22);
		getContentPane().add(lblPeriodoVacinaLabel);
		
		JLabel lblDoseUnicaVacinaLabel = new JLabel("Dose \u00DAnica?");
		lblDoseUnicaVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDoseUnicaVacinaLabel.setBounds(455, 403, 100, 22);
		getContentPane().add(lblDoseUnicaVacinaLabel);
		
		JLabel lblTecnologiaVacinaLabel = new JLabel("Tecnologia");
		lblTecnologiaVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTecnologiaVacinaLabel.setBounds(321, 403, 100, 22);
		getContentPane().add(lblTecnologiaVacinaLabel);
		
		JLabel lblNomeVacinaLabel = new JLabel("Nome");
		lblNomeVacinaLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNomeVacinaLabel.setBounds(167, 403, 46, 22);
		getContentPane().add(lblNomeVacinaLabel);
		
		JButton btnEditarCadastroButton = new JButton("Editar Cadastro");
		btnEditarCadastroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarCadastroUsuario Editar = new EditarCadastroUsuario();
				Editar.setVisible(true);
			}
		});
		btnEditarCadastroButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarCadastroButton.setFocusPainted(false);
		btnEditarCadastroButton.setBorderPainted(false);
		btnEditarCadastroButton.setBounds(700, 88, 132, 23);
		getContentPane().add(btnEditarCadastroButton);
		
		JLabel lblCidade = new JLabel("Cidade do Usuário");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCidade.setBounds(601, 221, 261, 19);
		getContentPane().add(lblCidade);
		
		JLabel lblTituloCidadeLabel = new JLabel("Cidade:");
		lblTituloCidadeLabel.setForeground(Color.WHITE);
		lblTituloCidadeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloCidadeLabel.setBounds(514, 221, 70, 19);
		getContentPane().add(lblTituloCidadeLabel);
		
		JLabel lblEndereco = new JLabel("Endereço do Usuário");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEndereco.setBounds(601, 191, 261, 19);
		getContentPane().add(lblEndereco);
		
		JLabel lblTituloEnderecoLabel = new JLabel("Endere\u00E7o:");
		lblTituloEnderecoLabel.setForeground(Color.WHITE);
		lblTituloEnderecoLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloEnderecoLabel.setBounds(514, 191, 80, 19);
		getContentPane().add(lblTituloEnderecoLabel);
		
		JLabel lblCPF = new JLabel("CPF do Usuário");
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblCPF.setBounds(601, 161, 132, 19);
		getContentPane().add(lblCPF);
		
		JLabel lblTituloCPFLabel = new JLabel("CPF:");
		lblTituloCPFLabel.setForeground(Color.WHITE);
		lblTituloCPFLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloCPFLabel.setBounds(514, 161, 57, 19);
		getContentPane().add(lblTituloCPFLabel);
		
		JLabel lblEmail = new JLabel("E-mail do usuário");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblEmail.setBounds(601, 131, 261, 19);
		getContentPane().add(lblEmail);
		
		JLabel lblTituloEmailLabel = new JLabel("E-mail:");
		lblTituloEmailLabel.setForeground(Color.WHITE);
		lblTituloEmailLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloEmailLabel.setBounds(514, 131, 57, 19);
		getContentPane().add(lblTituloEmailLabel);
		
		JLabel lblFone2 = new JLabel("Telefone 2 do Usuário (se tiver)");
		lblFone2.setForeground(Color.WHITE);
		lblFone2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFone2.setBounds(243, 221, 261, 19);
		getContentPane().add(lblFone2);
		
		JLabel lblTituloFone2Label = new JLabel("Telefone2:");
		lblTituloFone2Label.setForeground(Color.WHITE);
		lblTituloFone2Label.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloFone2Label.setBounds(166, 221, 70, 19);
		getContentPane().add(lblTituloFone2Label);
		
		JLabel lblFone = new JLabel("Telefone do Usuário");
		lblFone.setForeground(Color.WHITE);
		lblFone.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFone.setBounds(243, 191, 261, 19);
		getContentPane().add(lblFone);
		
		JLabel lblTituloFoneLabel = new JLabel("Telefone:");
		lblTituloFoneLabel.setForeground(Color.WHITE);
		lblTituloFoneLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloFoneLabel.setBounds(166, 191, 70, 19);
		getContentPane().add(lblTituloFoneLabel);
		
		JLabel lblIdade = new JLabel("Idade do usuário");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblIdade.setBounds(243, 161, 132, 19);
		getContentPane().add(lblIdade);
		
		JLabel lblTituloIdadeLabel = new JLabel("Idade:");
		lblTituloIdadeLabel.setForeground(Color.WHITE);
		lblTituloIdadeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloIdadeLabel.setBounds(166, 161, 57, 19);
		getContentPane().add(lblTituloIdadeLabel);
		
		JLabel lblNome = new JLabel("Nome e Sobrenome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNome.setBounds(243, 131, 261, 19);
		getContentPane().add(lblNome);
		
		JLabel lblTituloNomeLabel = new JLabel("Nome:");
		lblTituloNomeLabel.setForeground(Color.WHITE);
		lblTituloNomeLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTituloNomeLabel.setBounds(166, 131, 57, 19);
		getContentPane().add(lblTituloNomeLabel);
		
		JLabel lblTituloLabel = new JLabel("Informa\u00E7\u00F5es do Usu\u00E1rio");
		lblTituloLabel.setForeground(Color.WHITE);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblTituloLabel.setBounds(166, 79, 226, 33);
		getContentPane().add(lblTituloLabel);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon("C:\\Users\\Lucas Winkler\\Desktop\\vacina_de_oxford_astrazeneca_2701214157_1.jpg"));
		lblFundoLabel.setBounds(0, 0, 1023, 770);
		getContentPane().add(lblFundoLabel);
	}

}
