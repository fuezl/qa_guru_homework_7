import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class DocxTest {

    String checkedText = "Работаем с файлами";

    @Test
    void docxTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("Homework_Word.docx");
        assert stream != null;
        XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(stream));
        List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
        StringBuilder text = new StringBuilder();
        for (XWPFParagraph p : paragraphs) {
            text.append(p.getText()).append("\n");
        }
        System.out.println(text);
        assertThat(format("В файле отсутствует текст '%s'", checkedText), text.toString(), containsString(checkedText));
    }
}
