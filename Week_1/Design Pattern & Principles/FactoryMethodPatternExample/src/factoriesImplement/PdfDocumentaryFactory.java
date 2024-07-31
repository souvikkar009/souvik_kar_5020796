package factoriesImplement;

import doc.Document;
import docType.PdfDocument;
import factories.DocumentFactory;

public class PdfDocumentaryFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
