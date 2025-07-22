package LLDL1;

public class DependencyInversion {
    public static void main(String[] args) {
        // Using CreditCardPaymentProcessor
        PaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        PaymentService creditCardPaymentService = new PaymentService(creditCardProcessor);
        creditCardPaymentService.makePayment(100.0);

        // Using PayPalPaymentProcessor
        PaymentProcessor payPalProcessor = new PayPalPaymentProcessor();
        PaymentService payPalPaymentService = new PaymentService(payPalProcessor);
        payPalPaymentService.makePayment(200.0);
    }

    // PaymentProcessor interface (abstraction)
    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    // CreditCardPaymentProcessor class (low-level module)
    public static class CreditCardPaymentProcessor implements PaymentProcessor {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    }

    // PayPalPaymentProcessor class (low-level module)
    public static class PayPalPaymentProcessor implements PaymentProcessor {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    // PaymentService class (high-level module)
    public static class PaymentService {
        private final PaymentProcessor paymentProcessor;

        public PaymentService(PaymentProcessor paymentProcessor) {
            this.paymentProcessor = paymentProcessor;
        }

        public void makePayment(double amount) {
            paymentProcessor.processPayment(amount);
        }
    }
}
