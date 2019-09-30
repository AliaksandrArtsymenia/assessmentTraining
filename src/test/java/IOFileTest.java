import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOFileTest extends CommonCondition {

    @Test
    public void testIO() {
        writeToFile(collection.get(1));
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
