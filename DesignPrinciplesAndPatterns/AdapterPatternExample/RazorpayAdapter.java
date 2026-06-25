package DesignPrinciplesAndPatterns.AdapterPatternExample;

public class RazorpayAdapter implements PaymentProcessor {

    private RazorpayGateway razorpayGateway;

    public RazorpayAdapter(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    public void processPayment(double amount) {
        razorpayGateway.sendPayment(amount);
    }
}