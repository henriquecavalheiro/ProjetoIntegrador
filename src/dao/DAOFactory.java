
package dao;


public class DAOFactory {
    
     private static final UsuarioDAO usuarioDAO = new UsuarioDAO();
     
     public static UsuarioDAO getUsuarioDAO(){
        return usuarioDAO;
    }
    
}
