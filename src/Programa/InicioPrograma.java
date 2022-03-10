package Programa;


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
import javax.swing.border.EmptyBorder;

public class InicioPrograma extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioPrograma frame = new InicioPrograma();
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
	public InicioPrograma() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVacina = new JButton("Vacina");
		btnVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vacinas V = new Vacinas();
				V.setVisible(true);
				dispose();
			}
		});
		
		JButton btnAplicarVacina = new JButton("Aplicar Vacina");
		btnAplicarVacina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAplicarVacina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioAplicarVacina iav = new InicioAplicarVacina();
				iav.setVisible(true);
				dispose();
			}
		});
		btnAplicarVacina.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnAplicarVacina.setBounds(356, 355, 189, 44);
		contentPane.add(btnAplicarVacina);
		btnVacina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVacina.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnVacina.setBounds(356, 275, 189, 44);
		getContentPane().add(btnVacina);
		
		JButton btnNewButton = new JButton("Cidad\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cidadao c = new Cidadao();
				c.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnNewButton.setBounds(356, 195, 189, 44);
		getContentPane().add(btnNewButton);
		
		JLabel lblFundoLabel = new JLabel("");
		lblFundoLabel.setIcon(new ImageIcon(InicioPrograma.class.getResource("/Imagens/whatsapp_image_2021-02-27_at_11.53.03.jpg")));
		lblFundoLabel.setBounds(0, 0, 915, 608);
		getContentPane().add(lblFundoLabel);
	}

}
