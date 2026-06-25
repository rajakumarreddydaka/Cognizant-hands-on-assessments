package DesignPrinciplesAndPatterns.BuilderPatternExample;

public class Main {

    public static void main(String[] args) {

        // Gaming Computer
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 4090")
                .setOperatingSystem("Windows 11")
                .build();

        // Office Computer
        Computer officePC = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM(16)
                .setStorage(512)
                .setOperatingSystem("Windows 10")
                .build();

        // Developer Computer
        Computer developerPC = new Computer.Builder()
                .setCPU("AMD Ryzen 7")
                .setRAM(32)
                .setStorage(2000)
                .setGraphicsCard("NVIDIA RTX 4060")
                .setOperatingSystem("Ubuntu 24.04")
                .build();

        gamingPC.displayConfiguration();
        officePC.displayConfiguration();
        developerPC.displayConfiguration();
    }
}