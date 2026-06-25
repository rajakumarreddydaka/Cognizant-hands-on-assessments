package DesignPrinciplesAndPatterns.ObserverPatternExample;
public class Main {
    public static void main(String[] args) {

        // Create Stock Market
        StockMarket tcsStock = new StockMarket("TCS");

        // Create Observers
        Observer mobileUser = new MobileApp("Raja");
        Observer webUser = new WebApp("Kiran");

        // Register Observers
        tcsStock.registerObserver(mobileUser);
        tcsStock.registerObserver(webUser);

        // Change Stock Price
        tcsStock.setStockPrice(3500.50);

        tcsStock.setStockPrice(3650.75);

        // Remove One Observer
        System.out.println("\nRemoving Web Observer...\n");
        tcsStock.removeObserver(webUser);

        // Change Stock Price Again
        tcsStock.setStockPrice(3800.00);
    }
}