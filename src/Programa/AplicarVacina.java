package Programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class AplicarVacina {
	private int id;
	private int id_pessoa;
	private int id_vacina;
	private String cpf;
	private String nome;
	private String nome1;
	private String dose;
	private LocalDate primeiraAplicacao;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate segundaAplicacao;
	private String todasdosesaplicadas;
	
	public boolean cpfValido(String cpf) {
		return cpf != null && !cpf.equals("         -  ") && cpf.length() == 12;
	}
	public String getCpf() {
		return this.cpfValido(cpf) ? cpf : null;
	}

	public void setCpf(String cpf) {
		this.cpf = this.cpfValido(cpf) ? cpf : null;
	}
	
	
	public String getNome1() {
		return nome1;
	}

	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public LocalDate getPrimeiraAplicacao() {
		return primeiraAplicacao;
	}

	public void setPrimeiraAplicacao(String d){
		try {
			primeiraAplicacao = LocalDate.parse(d, formato);
		}
		catch(DateTimeParseException e) {
			primeiraAplicacao = null;
		}
		}

	public String getPrimeiraAplicacaoFormatado(){
		return primeiraAplicacao != null ? formato.format(primeiraAplicacao) : null;
		}

	public void setPrimeiraAplicacao(java.sql.Date d){
		primeiraAplicacao = d.toLocalDate();
	}
	
	public LocalDate getSegundaAplicacao() {
		return segundaAplicacao;
	}

	public void setSegundaAplicacao(String d){
		try {
			segundaAplicacao = LocalDate.parse(d, formato);
		}
		catch(DateTimeParseException e) {
			segundaAplicacao = null;
		}
		}

	public String getSegundaAplicacaoFormatado(){
		return segundaAplicacao != null ? formato.format(segundaAplicacao) : null;
		}

	public void setSegundaAplicacao(java.sql.Date d){
		segundaAplicacao = d.toLocalDate();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean idPessoa(int id_pessoa) {
		return id_pessoa > 0;
	}
	public int getId_pessoa() {
		return this.idPessoa(id_pessoa) ? id_pessoa : 0;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = this.idPessoa(id_pessoa) ? id_pessoa : 0;
	}
	
	public boolean idVacina(int idVacina) {
		return id_vacina > 0;
	}
	public int getId_vacina() {
		return idPessoa(id_vacina) ? id_vacina : 0;
	}
	public void setId_vacina(int id_vacina) {
		this.id_vacina = idPessoa(id_vacina) ? id_vacina : 0;
	}
	public boolean doseUnicaValida(String doseunica) {
		return doseunica != null && !doseunica.equals("");
	}
	public String getDoseunica() {
		return this.doseUnicaValida(dose) ? dose : null;
	}
	public void setDoseunica(String doseunica) {
		this.dose = this.doseUnicaValida(doseunica) ? doseunica : null;
	}
	
	public String getTodasdosesaplicadas() {
		return todasdosesaplicadas;
	}

	public void setTodasdosesaplicadas(String todasdosesaplicadas) {
		this.todasdosesaplicadas = todasdosesaplicadas;
	}
	
	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT IGNORE INTO aplicacao_vacina(id_pessoa, id_vacina, dose, primeiraaplicacao, todasdosesaplicadas) VALUES"
				+ "((SELECT id_pessoa from tb_pessoa where cpf = ?), (SELECT id_vacina from tb_vacina where nome = ?), ?, ?, "
				+ "(CASE dose WHEN aplicacao_vacina.dose = (SELECT num_doses FROM tb_vacina WHERE nome = ?) "
				+ "THEN \"Sim\" WHEN aplicacao_vacina.dose <> (SELECT num_doses FROM tb_vacina WHERE nome = ?) THEN \"Não\" END)) "
				+ "ON DUPLICATE KEY UPDATE dose = \"2\", todasdosesaplicadas = \"Sim\", segundaaplicacao = ?;";
				
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, cpf);
			ps.setString(2, nome);
			ps.setString(3, dose);
			ps.setDate(4, primeiraAplicacao != null ? java.sql.Date.valueOf(primeiraAplicacao) : null);
			ps.setString(5, nome);
			ps.setString(6, nome);
			ps.setDate(7, primeiraAplicacao != null ? java.sql.Date.valueOf(primeiraAplicacao) : null);

			// 5: Executa o comando
			ps.execute();
			if(!cpf.equals("         -  ") && primeiraAplicacao != null) {
				JOptionPane.showMessageDialog(null, "Vacinação Cadastrada");
				// 1: Definir o comando SQL
				String sql1 = "UPDATE tb_vacina SET qtdvacinas = qtdvacinas - 1 WHERE nome = ?;";
				// 2: Abrir uma conexão
				ConnectionFactory factory1 = new ConnectionFactory();
				try (Connection c1 = factory1.obtemConexao()) {
					// 3: Pré compila o comando
					PreparedStatement ps1 = c1.prepareStatement(sql1);
					// 4: Preenche os dados faltantes
					ps1.setString(1, nome);
					

					// 5: Executa o comando
					ps1.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Erros nos dados de Inserção.", "Tente novamente!", 0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erros nos dados de Inserção.", "Tente novamente!", 0);
			
		}
	}
	
	
	public void consultar() {
		// 1: Definir o comando SQL
		String sql = "select c.nome, b.nome, a.dose, a.primeiraaplicacao, "
				+ "if(b.num_doses = 1, '2000-01-01', date_add(primeiraaplicacao, INTERVAL "
				+ "(select periodoentredoses FROM tb_vacina WHERE id_vacina = (select id_vacina from aplicacao_vacina "
				+ "where id_pessoa = (select id_pessoa from tb_pessoa where cpf = ?))) day)) as segundaaplicacao, "
				+ "a.todasdosesaplicadas from aplicacao_vacina a inner join tb_vacina b on "
				+ "a.id_vacina = b.id_vacina inner join tb_pessoa c on a.id_pessoa = c.id_pessoa where c.cpf = ?;";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.setString(2, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome1 = rs.getString("nome");
				nome = rs.getString("b.nome");
				dose = rs.getString("dose");
				setPrimeiraAplicacao(rs.getDate("primeiraaplicacao"));
				setSegundaAplicacao(rs.getDate("segundaaplicacao"));	
				todasdosesaplicadas = rs.getString("todasdosesaplicadas");
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro inválido para consulta. Tente novamente!");
			e.printStackTrace();
			
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
	
	public String[] listarDosesVacina(String nomeVacina) {
		ArrayList<String> l = new ArrayList<>();
		
		String sql = "SELECT num_doses FROM tb_vacina WHERE nome = ?";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nomeVacina);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int max = rs.getInt("num_doses");
				for(int i = 1; i <= max; i++) {
					l.add(Integer.toString(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.toArray(new String[l.size()]);
	}	
	
	public String qualVacinaFoiAplicada(String valorCampoCpf) {
		String sql = "SELECT tb_vacina.nome FROM tb_vacina "
				+ "WHERE EXISTS("
				+ "SELECT aplicacao_vacina.id_vacina "
				+ "FROM aplicacao_vacina "
				+ "WHERE aplicacao_vacina.id_vacina = tb_vacina.id_vacina "
				+ "AND "
				+ "aplicacao_vacina.id_pessoa IN ("
				+ "SELECT tb_pessoa.id_pessoa FROM tb_pessoa WHERE tb_pessoa.cpf = ?"
				+ "))";
		
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, valorCampoCpf);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String resultado = rs.getString("nome");
				return resultado != null ? resultado : "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
		return "";
	}	

}
