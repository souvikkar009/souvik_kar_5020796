package docType;

import doc.Document;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening word document...");
    }

    @Override
    public void close() {
        System.out.println("Opening word document...");
    }
}
