package test;


import constant.Constant;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadExcel;

public class CreateFeatureFile {
    public static Logger logger = Logger.getLogger(CreateFeatureFile.class);

    @Test
    public void readExcel() {
        ReadExcel.readExcel(Constant.excelFilePath, Constant.sheetName, 1);
        logger.info("file read successfilly done");
    }

}
