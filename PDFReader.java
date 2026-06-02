package pdf;

import java.io.File;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

    public static String extractText(String path) {

        try {

            PDDocument doc =
                    Loader.loadPDF(
                            new File(path));

            PDFTextStripper stripper =
                    new PDFTextStripper();

            String text =
                    stripper.getText(doc);

            doc.close();

            return text;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "";
    }
}