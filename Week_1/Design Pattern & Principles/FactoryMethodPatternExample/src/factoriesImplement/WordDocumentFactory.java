package factoriesImplement;

import doc.Document;
import docType.WordDocument;
import factories.DocumentFactory;

public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
