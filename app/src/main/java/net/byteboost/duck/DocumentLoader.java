package net.byteboost.duck;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.FileSystemDocumentLoader;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DocumentLoader {

    static class Load_Pdf_From_File_System_Example {

        public static void main(String[] args) {
            Path filePath = toPath("example-files/story-about-happy-carrot.pdf");
            Document document = FileSystemDocumentLoader.loadDocument(filePath);
            System.out.println(document);
        }
    }

    static class Load_Docx_From_File_System_Example {

        public static void main(String[] args) {
            Path filePath = toPath("example-files/story-about-happy-carrot.docx");
            Document document = FileSystemDocumentLoader.loadDocument(filePath);
            System.out.println(document);
        }
    }


    private static Path toPath(String fileName) {
        try {
            URL fileUrl = ChatWithDocuments.class.getResource(fileName);
            return Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}