import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class textTest {
    private String readFromFile(File file) {
        StringBuilder builder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentString = bufferedReader.readLine();
            while (currentString != null) {
                builder.append(currentString);
                currentString = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private List<String> readFromFileViaFiles(Path path) {
        List<String> list = new LinkedList<>();
        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void writeToFileViaFiles(List<String> str, Path path) {
        try {
            Files.write(path, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(String str, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replace() {
        Path pathToRead = Paths.get("D:\\Lab\\projects\\trainingProject\\src\\main\\resources\\taskFiles.txt");
        Path pathToWrite = Paths.get("D:\\Lab\\projects\\trainingProject\\src\\main\\resources\\replacedFiles.txt");
        List<String> list = readFromFileViaFiles(pathToRead);
        List<String> replacedList = new LinkedList<>();
        for (String elem : list) {
            replacedList.add(elem.replaceAll("(\\(A-95\\))", "\\(G-10\\)"));
        }
        writeToFileViaFiles(replacedList, pathToWrite);
    }

    @Test
    public void replaceSubString() {
        File fileToRead = new File("D:\\Lab\\projects\\trainingProject\\src\\main\\resources\\task.txt");
        File fileToWrite = new File("D:\\Lab\\projects\\trainingProject\\src\\main\\resources\\replaced.txt");
        String replacedString = readFromFile(fileToRead).replaceAll("(\\(A-95\\))", "\\(G-10\\)");
        writeToFile(replacedString, fileToWrite);
    }

}
