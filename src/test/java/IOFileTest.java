import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
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

    private void writeToExcel(File file) {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet #1");
        Row row = sheet.createRow(0);
        Cell name = row.createCell(0);
        name.setCellValue("Vasya");
        Cell age = row.createCell(1);
        age.setCellValue(20);
        sheet.autoSizeColumn(1);
        try {
            workbook.write(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int readFromExcel(File file) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HSSFSheet sheet = workbook.getSheet("Sheet #1");
        HSSFRow row = sheet.getRow(0);
        return (int) row.getCell(1).getNumericCellValue();
    }

    @Test
    public void createExcel() {
        File file = new File("src\\main\\resources\\Example.xls");
        writeToExcel(file);
        Assert.assertEquals(readFromExcel(file), 19);
    }
}
