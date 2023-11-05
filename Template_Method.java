// Classe abstrata que define o Template Method
// Template Method, foi exemplificado através de um algoritmo de compra online e implementado para compra física também.
abstract class OrderProcessTemplate {
    public void processOrder() {
        selectProduct();
        makePayment();
        deliver();
    }

    protected abstract void selectProduct();
    protected abstract void makePayment();
    protected abstract void deliver();
}

// Subclasse 1
class OnlineOrderProcess extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Produto selecionado online.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Pagamento feito online.");
    }

    @Override
    protected void deliver() {
        System.out.println("Entrega online concluída.");
    }
}

// Subclasse 2
class InStoreOrderProcess extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Produto selecionado na loja.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Pagamento feito na loja.");
    }

    @Override
    protected void deliver() {
        System.out.println("Retirada na loja concluída.");
    }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        System.out.println("------ Pedido Online ------");
        OrderProcessTemplate onlineOrder = new OnlineOrderProcess();
        onlineOrder.processOrder();

        System.out.println("\n------ Pedido na Loja ------");
        OrderProcessTemplate inStoreOrder = new InStoreOrderProcess();
        inStoreOrder.processOrder();
    }
}
