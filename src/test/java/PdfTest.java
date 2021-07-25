import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class PdfTest {

    @Test
    void pdfTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("Homework_Pdf.pdf");
        assert stream != null;
        PDF parsedPdf = new PDF(stream);
        assertThat(parsedPdf.text).contains("Домашнее задание");
    }
}
