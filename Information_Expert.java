// Classe que representa um produto
// Information Expert , foi exemplificada através de uma loja online e seu carrinho de compras.
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

// Classe que representa um carrinho de compras
class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}

public class InformationExpertExample {
    public static void main(String[] args) {
        Product product1 = new Product("Camiseta", 20.0);
        Product product2 = new Product("Calça", 30.0);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(product1);
        cart.addItem(product2);

        double totalPrice = cart.calculateTotalPrice();
        System.out.println("Total Price: $" + totalPrice);
    }
}
