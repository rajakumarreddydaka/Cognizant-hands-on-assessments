package DesignPrinciplesAndPatterns.SingletonPatternExample;

public class Main {
    public static void main(String[] args) {

        // Get Logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use logger
        logger1.log("First log message.");
        logger2.log("Second log message.");

        // Verify both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        } else {
            System.out.println("Multiple Logger instances exist.");
        }

        // Print hash codes
        System.out.println("Logger1 HashCode: " + logger1.hashCode());
        System.out.println("Logger2 HashCode: " + logger2.hashCode());
    }
}
