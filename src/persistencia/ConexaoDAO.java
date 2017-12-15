package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexaoDAO {


	
	public ConexaoDAO() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erro ao selecionar o driver: " + e.getMessage());
			
		}
		
	}
	
	protected Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost/banco";
		Connection conn = DriverManager.getConnection(url, "root", "");
		return conn;
	}
	
	public static void main(String[] args) throws SQLException {
		ConexaoDAO db = new ConexaoDAO();
		// Testa a conex�o
		Connection conn = db.getConnection();
		System.out.println(conn);
	}
}

