package DesignPrinciplesAndPatterns.AdapterPatternExample;

public class RazorpayGateway {

    public void sendPayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed through Razorpay.");
    }
}
