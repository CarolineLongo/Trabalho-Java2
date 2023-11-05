// Classe que representa um sofá
class Sofa {
    private String style;
    private double price;

    public Sofa(String style, double price) {
        this.style = style;
        this.price = price;
    }

    // Outros métodos relacionados a sofás
}

// Classe que representa uma fábrica de sofás
class SofaFactory {
    public Sofa createSofa(String style, double price) {
        return new Sofa(style, price);
    }
}

public class SofaFactoryExample {
    public static void main(String[] args) {
        SofaFactory sofaFactory = new SofaFactory();

        Sofa sofa1 = sofaFactory.createSofa("Sofá de Couro", 800.0);
        Sofa sofa2 = sofaFactory.createSofa("Sofá de Tecido", 600.0);

        // Fábrica de sofás cria instâncias de sofás
    }
}
