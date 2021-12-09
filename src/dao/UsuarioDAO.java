package dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.UsuarioVO;
import persistencia.ConexaoBanco;

public class UsuarioDAO {

    public void cadastrarUsuario(UsuarioVO uVO) throws SQLException {
        //Buscando uma conexao com o BD
        Connection con = ConexaoBanco.getConexao();
        //Criando obj capaz de executar instrucoes SQL no BD
        Statement stat = con.createStatement();

        try {
            //String que receberá instrução ao SQL
            String sql;

            //Usar aspas simples para valores String
            sql = "insert into usuario(nome, telefone, email)"
                    + "values('"+uVO.getNome()+"', '" + uVO.getTelefone()+"','"+uVO.getEmail()+"')";
            
            stat.execute(sql);
            System.out.println("Usuário Cadastrado com Sucesso");
            
            

        } catch (SQLException se) {

            throw new SQLException("Erro ao inserir dados" + se.getMessage());

        } finally {
            stat.close();
            con.close();
        }

    }
    
    public void buscarUsuario() throws SQLException {
        Connection con = ConexaoBanco.getConexao();

        Statement stat = con.createStatement();
        
        try {
            String sql;
            
            sql = "select * from usuario";
            
            ResultSet result = stat.executeQuery(sql);
            
            while (result.next()) {
                
                int id = result.getInt("id");
                
                String nome = result.getString("nome");
                
                String telefone = result.getString("telefone");
                
                String email = result.getString("email");
                
                System.out.println("-".repeat(30));

                System.out.println("O valor do Id é: " + id);

                System.out.println("O nome do usuario é: " + nome);

                System.out.println("O telefone do usuário é: " + telefone);

                System.out.println("O email do usuario é: " + email);
                
                
            }
            
        } catch (SQLException se) {

            throw new SQLException("Erro ao buscar dados no banco : " + se.getMessage());
            
        } finally {
            stat.close();
            con.close();
        }
            
        

    }
    
    public void filtrar(long cond_query) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        try (Statement stat = con.createStatement()) {
            String sql;

            sql = "select * from usuario where id = " + cond_query;

            ResultSet result1 = stat.executeQuery(sql);

            if (!result1.next()) {

                JOptionPane.showMessageDialog(null, "Usuário não encontrado");

            }
            ResultSet result = stat.executeQuery(sql);

            while (result.next()) {

                int id = result.getInt("id");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                System.out.println("-".repeat(30));
                System.out.println("A ID do usuário é: " + id);
                System.out.println("O nome é usuário é: " + nome);
                System.out.println("O telefone do usuário é: " + telefone);
                System.out.println("O email do usuário é: " + email);
            }

        } catch (SQLException se) {

            throw new SQLException("Erro ao buscar dados no banco : " + se.getMessage());

        } finally {

            con.close();

        }
    }
    
    public void deletarProduto(long idUsuario) throws SQLException {
        //Buscando uma conexao com o BD
        Connection con = ConexaoBanco.getConexao();
        try (Statement stat = con.createStatement()) {

            String sql;
            sql = "Delete from usuario where id = " + idUsuario;
            stat.execute(sql);

            JOptionPane.showMessageDialog(null, "Usuário Excluído com sucesso");

        } catch (SQLException se) {

            throw new SQLException("Erro ao buscar dados no banco : " + se.getMessage());

        } finally {

            con.close();
        }
    }
    
    
    
}
