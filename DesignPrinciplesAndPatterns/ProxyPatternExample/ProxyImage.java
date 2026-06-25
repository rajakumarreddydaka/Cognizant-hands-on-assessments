package DesignPrinciplesAndPatterns.ProxyPatternExample;

public class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        // Cached object reused
        realImage.display();
    }
}