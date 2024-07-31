package factoriesImplement;

import doc.Document;
import docType.ExcelDocument;
import factories.DocumentFactory;

public class ExcelDocumentaryFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
