package LLDL2;

public class StrategyPatternDemo {

    // Main method
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(500);

        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(300);
    }

    // Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete Strategy 1
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        public CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
        }
    }

    // Concrete Strategy 2
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal: " + email);
        }
    }

    // Context
    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy strategy) {
            this.paymentStrategy = strategy;
        }

        public void checkout(int amount) {
            if (paymentStrategy == null) {
                System.out.println("No payment method selected.");
            } else {
                paymentStrategy.pay(amount);
            }
        }
    }
}

