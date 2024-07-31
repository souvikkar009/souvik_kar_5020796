package docType;

import doc.Document;

public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening excel document...");
    }

    @Override
    public void close() {
        System.out.println("Closing excel document...");
    }
}
