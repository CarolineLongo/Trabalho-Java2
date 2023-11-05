// Interface Strategy
// Strategy, este é exemplificado com pagamento intercambiável entre cartão de Crédito em si ou por e-mail.
interface PaymentStrategy {
    void pay(int amount);
}

// Implementações concretas das estratégias
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " pago com cartão de crédito " + cardNumber + " em nome de " + name);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " pago via PayPal para o email " + email);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Defina a estratégia de pagamento como cartão de crédito
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100);

        // Mude a estratégia de pagamento para PayPal
        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout(50);
    }
}
