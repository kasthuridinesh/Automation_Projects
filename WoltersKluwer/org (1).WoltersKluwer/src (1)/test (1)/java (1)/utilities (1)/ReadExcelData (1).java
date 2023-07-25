package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadExcelData {
    static FileInputStream inputStream;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;

    public static Map<String, String> readExcel(String filePath, String sheetName, int column, int column1) {
        Map<String, String> data = new LinkedHashMap<>();

        try {
            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
            for (int row = 1; row < sheet.getLastRowNum(); row++) {
                cell = sheet.getRow(row).getCell(column);
                String key = cell.getStringCellValue();
                String value = sheet.getRow(row).getCell(column1).getStringCellValue();
//                System.out.println(key);
//                System.out.println(value);
                data.put(key, value);

            }
            return data;


        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return null;
    }
}