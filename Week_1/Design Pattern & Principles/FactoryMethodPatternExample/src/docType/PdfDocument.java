package docType;

import doc.Document;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening pdf document...");
    }

    @Override
    public void close() {
        System.out.println("Closing pdf document...");
    }
}
