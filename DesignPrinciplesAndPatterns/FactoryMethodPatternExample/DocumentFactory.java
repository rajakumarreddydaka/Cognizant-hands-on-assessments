package DesignPrinciplesAndPatterns.FactoryMethodPatternExample;

public  abstract class DocumentFactory {
     public abstract Document createDocument();

    // Common operation
    public void openDocument() {
        Document doc = createDocument();
        doc.open();
    }
}
