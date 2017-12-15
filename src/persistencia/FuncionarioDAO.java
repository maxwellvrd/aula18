package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.Produto;
import entidade.Funcionario;

public class FuncionarioDAO extends ConexaoDAO {

	private Connection conn;

	public FuncionarioDAO() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao abrir a conexão: " + e.getMessage());
		}
	}

	// Método responsável por salvar o aluno no banco de dados

	public void save(Funcionario func) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into funcionario values (null, ?, ?, ?, ?, ?, ?, ?, md5(?) )");
			stmt.setString(1, func.getNome());
			stmt.setString(2, func.getCpf());
			stmt.setString(3, func.getTelefone());
			stmt.setString(4, func.getEndereco());
			stmt.setString(5, func.getCargo());
			stmt.setString(6, func.getEmail());
			stmt.setString(7, func.getLogin());
			stmt.setString(8, func.getSenha());
			int flag = stmt.executeUpdate();
			if (flag == 0)
				throw new SQLException("Erro ao gravar no banco");
		} finally {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
		}
	}

}
