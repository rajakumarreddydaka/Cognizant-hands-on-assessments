package DesignPrinciplesAndPatterns.StrategyPatternExample;

public class Main {
    public static void main(String[] args) {

        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        paymentContext.setPaymentStrategy(
                new CreditCardPayment("1234567890123456"));
        paymentContext.executePayment(5000);

        // Pay using PayPal
        paymentContext.setPaymentStrategy(
                new PayPalPayment("user@gmail.com"));
        paymentContext.executePayment(2500);
    }
}