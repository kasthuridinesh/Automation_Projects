package utilis;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream inputStream;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;

    public static void readExcel(String filePath, String sheetName, int column) {
        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
            for (int row = 1; row < sheet.getLastRowNum(); row++) {
                cell = sheet.getRow(row).getCell(column);
                String value = cell.getStringCellValue();
                System.out.println(value);
            }
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
