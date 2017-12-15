package implement;
import java.sql.SQLException;
import entidade.Produto;
import persistencia.ProdutoDAO;
public class ProdutoDAOImp {



		private ProdutoDAO dao = null;
		
		public ProdutoDAOImp() {
			dao = new ProdutoDAO();
		}
		
		public boolean salvar(Produto p) {
			try {
				dao.save(p);
				return Boolean.TRUE;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Boolean.FALSE;
		}
}

