package servicos;

public class ServicosFactory {

    private static final ProdutosServicos produtoServicos = new ProdutosServicos();

    public static ProdutosServicos getProdutoServicos() {

        return produtoServicos;

    }

}