public interface FactoryPattern {
    void open();
}

// WordDocument.java
public class WordDocument implements FactoryPattern {
    public void open() {
        System.out.println("Opening Word Document");
    }
}
// PdfDocument.java
public class PdfDocument implements FactoryPattern {
    public void open() {
        System.out.println("Opening PDF Document");
    }
}
// ExcelDocument.java
public class ExcelDocument implements FactoryPattern {
    public void open() {
        System.out.println("Opening Excel Document");
    }
}
// DocumentFactory.java (abstract factory)
public abstract class DocumentFactory {
    public abstract FactoryPattern createDocument();
}

// WordDocumentFactory.java
public class WordDocumentFactory extends DocumentFactory {
    public FactoryPattern createDocument() {
        return new WordDocument();
    }
}
// PdfDocumentFactory.java
public class PdfDocumentFactory extends DocumentFactory {
    public FactoryPattern createDocument() {
        return new PdfDocument();
    }
}
//ExcelDocumentFactory.java
public class ExcelDocumentFactory extends DocumentFactory {
    public FactoryPattern createDocument() {
        return new ExcelDocument();
    }
}
//Main.java

public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        FactoryPattern wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        FactoryPattern pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        FactoryPattern excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

