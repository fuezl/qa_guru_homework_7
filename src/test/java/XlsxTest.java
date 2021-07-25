import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XlsxTest {

    String[] columnNames = {
            "Дата",
            "Направление",
            "Категория SAP",
            "PLU",
            "Наименование",
            "Тип ячейки",
            "Ячейка",
            "Количество"
    };

    @Test
    void xlsxTest() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("Homework_Excel.xls");
        assert stream != null;
        XLS xlsFile = new XLS(stream);
        int index = 2;
        String columnNamesFromExcel = xlsFile.excel
                .getSheetAt(0)
                .getRow(0)
                .getCell(index)
                .getStringCellValue();
        assertEquals(columnNames[index], columnNamesFromExcel);
    }
}
