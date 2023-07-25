package org.wk.utils;
// *********importing libraties***********
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//*************** Start of the program *******************
public class TestCaseReader {
    static Logger logger = Logger.getLogger(TestCaseReader.class);
    static Map<String, String> data = new LinkedHashMap<String, String>();
    static FileInputStream inputStream;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static XSSFCell cell;

    public static Map<String, String> readExcel(String filePath, String sheetName) {

        try {

            inputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);

            for (int rowNumber = 1; rowNumber < sheet.getLastRowNum(); rowNumber++) {
                String key = sheet.getRow(rowNumber).getCell(1).getStringCellValue();
                String value = sheet.getRow(rowNumber).getCell(2).getStringCellValue();

                data.put(key, value + "\n");

            }
            logger.info("Excel Read is Performed");

            return data;

        } catch (FileNotFoundException fileNotFound) {

            logger.error("Excel Read is Not Performed " + fileNotFound);
        } catch (IOException ioException) {
            logger.error("Excel Read is Not Performed " + ioException);
        }
        return null;

    }

}
// ******************* End of the program **********************
