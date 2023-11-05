// Este código demonstra como o Padrão de Fábrica permite criar diferentes tipos de objetos (Produto A e B) sem conhecer os detalhes da criação.
//  interface para o produto que as fábricas irão criar
interface Produto {
    void operacao();
}

//classes concretas que implementam a interface Produto
class ProdutoA implements Produto {
    @Override
    public void operacao() {
        System.out.println("Produto A executando operação.");
    }
}

class ProdutoB implements Produto {
    @Override
    public void operacao() {
        System.out.println("Produto B executando operação.");
    }
}

// fábrica abstrata para criar objetos do tipo Produto
interface Fabrica {
    Produto criarProduto();
}

// Implementando fábricas concretas que produzem objetos do tipo Produto
class FabricaProdutoA implements Fabrica {
    @Override
    public Produto criarProduto() {
        return new ProdutoA();
    }
}

class FabricaProdutoB implements Fabrica {
    @Override
    public Produto criarProduto() {
        return new ProdutoB();
    }
}

// Utilizando a fábrica para criar objetos do tipo Produto
public class Main {
    public static void main(String[] args) {
        // Escolhendo a fábrica desejada (por exemplo, FabricaProdutoA ou FabricaProdutoB)
        Fabrica fabrica = new FabricaProdutoA();

        // Usando a fábrica para criar um objeto do tipo Produto
        Produto produto = fabrica.criarProduto();

        // Executando a operação no objeto criado
        produto.operacao();
    }
}
