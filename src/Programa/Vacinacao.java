package Programa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Vacinacao {
	private int id_vacina;
	private String nome;
	private int qtdvacinas;
	private int dose;
	private int periodoentredoses;
	private double eficacia;
	
	public boolean eficaciaValida(double eficacia) {
		return eficacia >0 && eficacia <= 100;
	}
	public double getEficacia() {
		return this.eficaciaValida(eficacia) ? eficacia : 0;
	}
	public void setEficacia(double eficacia) {
		this.eficacia = this.eficaciaValida(eficacia) ? eficacia : 0;
	}
	public int getId() {
		return id_vacina;
	}
	public void setId(int id) {
		this.id_vacina = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtdvacinas() {
		return this.qtdvacinasValido(qtdvacinas) ? qtdvacinas : 0;
	}
	public boolean qtdvacinasValido(int qtdvacinas) {
		return qtdvacinas > 0;
	}
	public void setQtdvacinas(int qtdvacinas) {
		this.qtdvacinas = this.qtdvacinasValido(qtdvacinas) ? qtdvacinas : 0;
	}
	
	public boolean doseUnicaValida(int doseunica) {
		return doseunica > 0;
	}
	public int getDoseunica() {
		return this.doseUnicaValida(dose) ? dose : null;
	}
	public void setDoseunica(int doseunica) {
		this.dose = this.doseUnicaValida(doseunica) ? doseunica : 0;
	}
	public boolean periodoentredosesValido(int periodoentredoses) {
		return periodoentredoses >= 0;
	}
	public int getPeriodoentredoses() {
		return this.periodoentredosesValido(periodoentredoses) ? periodoentredoses : -99;
	}
	public void setPeriodoentredoses(int periodoentredoses) {
		this.periodoentredoses = this.periodoentredosesValido(periodoentredoses) ? periodoentredoses : -99;
	}
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_vacina(nome, qtdvacinas, num_doses, periodoentredoses, eficacia) VALUES (?, ?, ?, (if(num_doses = 1, 0, ?)), ?)";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setInt(2, qtdvacinas == 0 ? null : qtdvacinas);
			ps.setInt(3, dose == 0 ? null : dose);
			ps.setInt(4, periodoentredoses == -99 ? null : periodoentredoses);
			ps.setDouble(5, eficacia == 0 ? null : eficacia);
			
			// 5: Executa o comando
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Vacina Cadastrada");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro Inválido!", "Tente novamente!", 0);
		}
	}
	
	public void alterar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_vacina set nome = ?, qtdvacinas = ?, num_doses = ?, periodoentredoses = (if(num_doses = 1, 0, ?)), eficacia = ? WHERE nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setInt(2, qtdvacinas == 0 ? null : qtdvacinas);
			ps.setInt(3, dose == 0 ? null : dose);
			ps.setInt(4, periodoentredoses == -99 ? null : periodoentredoses);
			ps.setDouble(5, eficacia == 0 ? null : eficacia);
			ps.setString(6, nome);
			
			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro de Vacina alterado!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Informações Inválidas!", "Tente novamente!", 0);
		}
	}
	
	public void consultar() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, qtdvacinas, num_doses, periodoentredoses, eficacia FROM tb_vacina where nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				qtdvacinas = rs.getInt("qtdvacinas");
				dose = rs.getInt("num_doses");
				periodoentredoses = rs.getInt("periodoentredoses");
				eficacia = rs.getDouble("eficacia");
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro inválido para consulta. Tente novamente!");
		}
	}
	
	public void excluir() {
		String sql = "DELETE FROM tb_vacina WHERE nome = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);

			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Vacina Excluída!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vacina já foi aplicada em alguma pessoa. Tente novamente!");
		}
	}
	
	public String[] listarVacinas() {
		ArrayList<String> vacinas = new ArrayList<>();
		
		String sql = "SELECT nome FROM tb_vacina";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			PreparedStatement ps = c.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				vacinas.add(rs.getString("nome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacinas.toArray(new String[vacinas.size()]);
	}
	
	public void listar() {
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_vacina";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String qtdvacinas = rs.getString("qtdvacinas");
				String doseunica = rs.getString("num_doses");
				int periodoentredoses = rs.getInt("periodoentredoses");
				String eficacia = rs.getString("eficacia");
				String aux = String.format("Id: %d, Nome: %s, Quantidade de Vacinas: %s, Dose Única?: %s, Período Entre Doses: %s, "
						+ "Eficácia: %s", id, nome, qtdvacinas, doseunica, periodoentredoses, eficacia);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
