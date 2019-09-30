import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFileTest extends CommonCondition {
    private File file = new File(".//target/data.txt");
    private String color;

    @Test
    public void testIO() {
        writeToFile(file, collection.get(1));
        Assert.assertEquals(readFromFile(), collection.get(collection.size() - 2));
    }

    private void writeToFile(File file, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    private String readFromFile() {
        String colorFromFile = null;
        try {
            Path path = Paths.get(".//target/data.txt");
            colorFromFile = Files.readAllLines(path).get(0);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return colorFromFile;
    }
}
