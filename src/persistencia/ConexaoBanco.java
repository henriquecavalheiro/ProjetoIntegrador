package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    
    //ATRIBUTOS ESTATICOS COM O BD
    private static final String URL = "jdbc:mysql://localhost:3306/projetopi";
    private static String USUARIO = "root";
    private static String SENHA = "";
    
    
    public static Connection getConexao() throws SQLException {        
        Connection con = null;
        
        try {
            con = DriverManager.getConnection(URL, USUARIO, SENHA);           
            
        } catch (SQLException se) {
            throw new SQLException("Erro ao conectar! " + se.getMessage());
        }   
        return con;
        
    }
}
