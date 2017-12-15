package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.Produto;


public class ProdutoDAO extends ConexaoDAO {

	private Connection conn;

	public ProdutoDAO() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao abrir a conexão: " + e.getMessage());
		}
	}

	// Método responsável por salvar o aluno no banco de dados

	public void save(Produto prod) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into produto values (null, ?, ?, ?, ?)");
			stmt.setString(1, prod.getNomeProduto());
			stmt.setString(2, prod.getDescProduto());
			stmt.setInt(3, prod.getQuantidade());
			stmt.setDouble(4, prod.getPreco());

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
