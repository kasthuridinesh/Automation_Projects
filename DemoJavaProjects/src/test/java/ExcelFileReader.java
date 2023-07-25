import Constant.Constant;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utilis.ExcelReader;

public class ExcelFileReader {
    public static Logger logger = Logger.getLogger(ExcelFileReader.class);
@Test
    public void readExcel() {
        ExcelReader.readExcel(Constant.excelFilePath, Constant.sheetName, 1);
        logger.info("file read successfilly done");
    }

}
