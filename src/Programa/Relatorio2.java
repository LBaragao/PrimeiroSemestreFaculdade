package Programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Relatorio2 extends JFrame {

	
	private JTable table;
	private LocalDate proximaAplicacao;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public LocalDate getProximaAplicacao() {
		return proximaAplicacao;
	}

	public void setProximaAplicacao(String d){
		try {
			proximaAplicacao = LocalDate.parse(d, formato);
		}
		catch(DateTimeParseException e) {
			proximaAplicacao = null;
		}
		}

	public String getProximaAplicacaoFormatado(){
		return proximaAplicacao != null ? formato.format(proximaAplicacao) : null;
		}

	public void setProximaAplicacao(java.sql.Date d){
		proximaAplicacao = d.toLocalDate();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio2 frame = new Relatorio2();
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
	
	public Relatorio2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 618);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setBounds(-150, 0, 1105, 590);
		lblFundoLabel.setIcon(new ImageIcon(Relatorio.class.getResource("/Imagens/vacina-covid-19-voluntaria.jpg")));
		lblFundoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		getContentPane().setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioAplicarVacina tela = new InicioAplicarVacina();
				tela.setVisible(true);
				dispose();
			}
		});
		
		
		
		JLabel lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataFinal.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDataFinal.setBounds(498, 200, 86, 25);
		getContentPane().add(lblDataFinal);
		
		JLabel lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataInicial.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDataInicial.setBounds(168, 200, 86, 25);
		getContentPane().add(lblDataInicial);
		btnVoltar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnVoltar.setBounds(135, 480, 145, 23);
		getContentPane().add(btnVoltar);
		
		JFormattedTextField formattedDataField = new JFormattedTextField();
		formattedDataField.setBounds(594, 203, 113, 20);
		getContentPane().add(formattedDataField);
		formattedDataField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		try {
            formattedDataField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		JFormattedTextField formattedDataField2 = new JFormattedTextField();
		formattedDataField2.setBounds(262, 203, 113, 20);
		getContentPane().add(formattedDataField2);
		formattedDataField2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		try {
			formattedDataField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 277, 616, 173);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Vacina", "Celular", "E-mail", "Tomou todas as Doses?"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		table.getColumnModel().getColumn(4).setPreferredWidth(108);
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate dataInicial = null;
				LocalDate dataFinal = null;
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

				try {
					dataInicial = LocalDate.parse(formattedDataField2.getText(), formato);
					dataFinal = LocalDate.parse(formattedDataField.getText(), formato);
				}
				catch(DateTimeParseException err) {
					dataInicial = null;
					dataFinal = null;
					JOptionPane.showMessageDialog(null, "Erro na Consulta. Tente novamente!");
				}

				String sql = "select c.nome, b.nome, c.telefone1, c.email, "
						+ "a.todasdosesaplicadas from aplicacao_vacina a inner join tb_vacina b on "
						+ "a.id_vacina = b.id_vacina inner join tb_pessoa c on a.id_pessoa = c.id_pessoa where a.todasdosesaplicadas = \"Sim\" "
						+ "and if(b.num_doses = 1, primeiraaplicacao >= ?, segundaaplicacao >= ?) "
						+ "and if(b.num_doses = 1, primeiraaplicacao <= ?, segundaaplicacao <= ?)";
				ConnectionFactory factory = new ConnectionFactory();
				try (Connection c = factory.obtemConexao()) {
					// 3: Pré compila o comando
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setDate(1, dataInicial != null ? java.sql.Date.valueOf(dataInicial) : null);
					ps.setDate(2, dataInicial != null ? java.sql.Date.valueOf(dataInicial) : null);
					ps.setDate(3, dataFinal != null ? java.sql.Date.valueOf(dataFinal) : null);
					ps.setDate(4, dataFinal != null ? java.sql.Date.valueOf(dataFinal) : null);
					
					// 4: Executa o comando e guarda
					// o resultado em um ResultSet
					ResultSet rs = ps.executeQuery();
					// 5: itera sobre o resultado
					DefaultTableModel modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					
					
					while(rs.next()) {
						modelo.addRow(new Object[] {rs.getString("c.nome"), rs.getString("b.nome"), rs.getString("c.telefone1"), rs.getString("c.email"), rs.getString("a.todasdosesaplicadas")});
					}
					
					
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Erro na Consulta. Tente novamente!");
					erro.printStackTrace();
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(367, 236, 145, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formattedDataField.setText("");
				formattedDataField2.setText("");
			}
		});
		btnLimparCampos.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnLimparCampos.setBounds(606, 482, 145, 23);
		getContentPane().add(btnLimparCampos);
		
		JLabel lblTituloLabel = new JLabel("Pacientes que j\u00E1 tomaram todas as doses entre:");
		lblTituloLabel.setBounds(135, 160, 616, 32);
		lblTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		getContentPane().add(lblTituloLabel);
		getContentPane().add(lblFundoLabel);
	}
}
