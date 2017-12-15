package implement;

import java.sql.SQLException;
import entidade.Funcionario;
import persistencia.FuncionarioDAO;
public class FuncionarioDAOImp {



		private FuncionarioDAO dao = null;
		
		public FuncionarioDAOImp() {
			dao = new FuncionarioDAO();
		}
		
		public boolean salvar(Funcionario f) {
			try {
				dao.save(f);
				return Boolean.TRUE;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Boolean.FALSE;
		}
}

