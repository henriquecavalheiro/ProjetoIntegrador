package servicos;

import java.sql.SQLException;
import dao.DAOFactory;
import dao.UsuarioDAO;
import java.util.ArrayList;
import modelo.UsuarioVO;

public class ProdutosServicos {

    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException {

        UsuarioDAO pDAO = DAOFactory.getUsuarioDAO();

        pDAO.cadastrarUsuario(uVO);

    }
    
    public void buscarUsuario() throws SQLException {
        
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        uDAO.buscarUsuario();
        
    }
    
    public void filtrar (long id) throws SQLException {
        
        UsuarioDAO uDAO = DAOFactory.getUsuarioDAO();
        
        uDAO.filtrar(id);
        
    }
    
    public void deletarProduto(long idProduto) throws SQLException {
        UsuarioDAO pDAO = DAOFactory.getUsuarioDAO();
        
        pDAO.deletarProduto(idProduto);
        
    }

}
