package Programa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class Pessoa {
	private int id_pessoa;
	private String nome;
	private LocalDate dtNascimento;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String cpf;
	private String fone1;
	private String fone2;
	private String endereco;
	private String cidade;
	private String estado;
	private String email;
	
	
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String d){
		try {
			dtNascimento = LocalDate.parse(d, formato);
		}
		catch(DateTimeParseException e) {
			dtNascimento = null;
		}
		}

	public String getDtNascimentoFormatado(){
		return dtNascimento != null ? formato.format(dtNascimento) : "";
		}

	public void setDtNascimento(java.sql.Date d){
		dtNascimento = d.toLocalDate();
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id_pessoa;
	}

	public void setId(int id) {
		this.id_pessoa = id;
	}
	
	public boolean nomeValido(String nome) {
		return nome != null && !nome.equals("") && !nome.trim().equals("");
	}

	public String getNome() {
		return this.nomeValido(nome) ? nome : null;
	}

	public void setNome(String nome) {
		this.nome = this.nomeValido(nome) ? nome : null;
	}
	
	public boolean cpfValido(String cpf) {
		return cpf != null && !cpf.equals("         -  ") && cpf.length() == 12;
	}
	public String getCpf() {
		return this.cpfValido(cpf) ? cpf : null;
	}

	public void setCpf(String cpf) {
		this.cpf = this.cpfValido(cpf) ? cpf : null;
	}
	
	public boolean foneValido(String fone) {
		return fone != null && !fone.equals("") && !fone.equals("(  )     -    ") && !fone.equals("(  )    -    ") && (fone.length() == 13 || fone.length() == 14);
	}

	public String getFone1() {
		return this.foneValido(fone1) ? fone1 : null;
	}

	public void setFone1(String fone1) {
		this.fone1 = this.foneValido(fone1) ? fone1 : null;
	}

	public String getFone2() {
		return this.foneValido(fone2) ? fone2 : null;
	}

	public void setFone2(String fone2) {
		this.fone2 = this.foneValido(fone2) ? fone2 : null;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public void inserir() {
		// 1: Definir o comando SQL
		String sql = "INSERT INTO tb_pessoa(nome, datanascimento, cpf, telefone1, telefone2, endereco, cidade, estado, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setDate(2, dtNascimento != null ? java.sql.Date.valueOf(dtNascimento) : null);
			ps.setString(3, cpf);
			ps.setString(4, fone1);
			ps.setString(5, fone2);
			ps.setString(6, endereco);
			ps.setString(7, cidade);
			ps.setString(8, estado);
			ps.setString(9, email);


			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cidadão Cadastrado.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro Inválido!", "Tente novamente!", 0);
			
		}
	}

	public void alterar() {
		// 1: Definir o comando SQL
		String sql = "UPDATE tb_pessoa SET nome = ?, datanascimento = ?, telefone1 = ?, telefone2 = ?, endereco = ?, cidade = ?, estado = ?, email = ? WHERE cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, nome);
			ps.setDate(2, dtNascimento != null ? java.sql.Date.valueOf(dtNascimento) : null);
			ps.setString(3, fone1);
			ps.setString(4, fone2);
			ps.setString(5, endereco);
			ps.setString(6, cidade);
			ps.setString(7, estado);
			ps.setString(8, email);
			ps.setString(9, cpf);
			

			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Cadastro Alterado.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro inválido para editar!",  "Tente novamente!", 0);
		}
	}
	
	public void consultar() {
		// 1: Definir o comando SQL
		String sql = "SELECT nome, datanascimento, telefone1, telefone2, endereco, cidade, estado, email FROM tb_pessoa where cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, cpf);
			// 4: Executa o comando e guarda
			// o resultado em um ResultSet
			ResultSet rs = ps.executeQuery();
			// 5: itera sobre o resultado
			if (rs.next()) {
				nome = rs.getString("nome");
				setDtNascimento(rs.getDate("datanascimento"));
				fone1 = rs.getString("telefone1");
				fone2 = rs.getString("telefone2");
				endereco = rs.getString("endereco");
				cidade = rs.getString("cidade");
				estado = rs.getString("estado");
				email = rs.getString("email");	
			}
			
			if(nome.equals(" ")) {
				JOptionPane.showMessageDialog(null, "Cidadão não encontrado!", "Tente novamente!", 2);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite um cpf válido/existente!", "Tente novamente!", 2);
		}
	}


	public void excluir() {
		String sql = "DELETE FROM tb_pessoa WHERE cpf = ?";
		// 2: Abrir uma conexão
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			// 3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			// 4: Preenche os dados faltantes
			ps.setString(1, cpf);

			// 5: Executa o comando
			ps.execute();
			JOptionPane.showMessageDialog(null, "Usuário Excluído!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cadastro não existe ou já aplicou vacina!", "Tente novamente!", 0);
		}
	}

	public void listar() {
		// 1: Definir o comando SQL
		String sql = "SELECT * FROM tb_pessoa";
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
				String cpf = rs.getString("nome");
				String fone1 = rs.getString("telefone1");
				String fone2 = rs.getString("telefone2");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String email = rs.getString("email");
				String aux = String.format("Id: %d, Nome: %s, CPF: %s, Telefone 1: %s, Telefone 2: %s, Endereço: %s, Cidade: "
						+ "%s, Estado: %s, Email: %s", id, nome, cpf, fone1, fone2, endereco, cidade, estado, email);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
