package DesignPrinciplesAndPatterns.StrategyPatternExample;

public class PaymentContext {

    private PaymentStrategy paymentStrategy;

    // Set Strategy at Runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute Strategy
    public void executePayment(double amount) {

        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return;
        }

        paymentStrategy.pay(amount);
    }
}
