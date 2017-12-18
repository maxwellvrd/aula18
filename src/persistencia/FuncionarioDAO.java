package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidade.Produto;
import entidade.Usuario;
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
public Usuario control(Usuario usuario) throws SQLException{
		
		PreparedStatement stmt = null;
		Usuario usu = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select * from usuario where usuario like ? and senha = md5(?)");
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getSenha()); 
			rs = stmt.executeQuery();
			if(rs.next()) {
				usu = new Usuario();
				usu.setUsuario(rs.getString(1));
				usu.setSenha(rs.getString(2));
				
			}
		}finally {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
			if(rs !=null)
				rs.close();
		}
		
		return usu;
	}
	

}
