import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFileTest extends CommonCondition {

    @Test
    public void testIO() {
        writeToFile("Yellow\nBlue\nWhite");
        Assert.assertEquals(readFromFile(), collection.get(collection.size() - 2));
    }

    private void writeToFile(String content) {
        try {
            Path path = Paths.get(".//target/data.txt");
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    private String readFromFile() {
        StringBuilder text = new StringBuilder();
        try {
            File path = new File(".//target/data.txt");
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (currentLine != null) {
                text.append(currentLine);
                text.append("\t");
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return text.toString();
    }
}
