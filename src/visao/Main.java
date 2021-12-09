package visao;

import javax.swing.JOptionPane;
import modelo.UsuarioVO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import servicos.ProdutosServicos;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] op = {"Cadastrar Usuário", "Buscar Usuário", "Deletar Usuário"};
        int escolha = JOptionPane.showOptionDialog(null, "Informe a opçao",
                " ATIVIDADE PI CRUD",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, op, null);

        if (escolha == 0) {

            try {

                //Instancia classe
                UsuarioVO uVO = new UsuarioVO();
                //recebe os valores
                String nome = JOptionPane.showInputDialog(null, "Informe seu nome completo :");
                String telefone = JOptionPane.showInputDialog(null, "Informe seu nr de telefone :");
                String email = JOptionPane.showInputDialog(null, "Informe seu email :");

                //Passa valores para o objeto UsuarioVO
                uVO.setNome(nome);

                uVO.setTelefone(telefone);

                uVO.setEmail(email);

                //cadastra Produto
                ProdutosServicos ps = servicos.ServicosFactory.getProdutoServicos();

                ps.cadastrarUsuario(uVO);

                ps.buscarUsuario();

            } catch (Exception e) {

                throw new Exception("Erro ao inserir dados no Banco de Dados! " + e.getMessage());

            }

        }//fecha o escolha ==0
        else if (escolha == 1) {
            //Instancia classe
            UsuarioVO uVO = new UsuarioVO();
            
            long codigo = Long.parseLong(JOptionPane.showInputDialog(null,
                    "Informe a ID do cliente para que possamos buscar no nosso Sistema: "));
            
            uVO.setId(codigo);
            
            ProdutosServicos ps = servicos.ServicosFactory.getProdutoServicos();
            
            ps.filtrar(uVO.getId());

        } else if (escolha == 2) {

            try {

                UsuarioVO uVO = new UsuarioVO();

                Long codigo = Long.parseLong(JOptionPane.showInputDialog(null,
                        "Informe A ID do usuario a ser excluído: "));

                uVO.setId(codigo);

                ProdutosServicos ps = servicos.ServicosFactory.getProdutoServicos();

                ps.deletarProduto(uVO.getId());

            } catch (Exception e) {

                throw new Exception("Erro ao conectar no Banco de Dados! " + e.getMessage());

            }
        }

    }//fecha método

}
