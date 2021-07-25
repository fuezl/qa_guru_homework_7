import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Zip.unzip;

public class ZipTest {

    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/1.zip";
        String unzipFolderPath = "./src/test/resources/unzip";
        String password = "12345";
        String unzipTxtFilePath = "./src/test/resources/unzip/1.txt";
        String expectedText = "Hello, world!";

        unzip(zipFilePath, unzipFolderPath, password);

        File txt = new File(unzipTxtFilePath);
        String actualText = FileUtils.readFileToString(txt, StandardCharsets.UTF_8);
        assertThat(actualText, containsString(expectedText));
    }
}
