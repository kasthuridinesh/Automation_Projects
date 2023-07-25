package runner;

import constant.ConfigPathReadExcel;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import utilities.ReadExcelData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Test
public class FileRunner {
    static String keyword;
    static String name;
    static String value;

    @Test
    public void getKeyword() throws IOException, ParseException {
        List<String> getKeyword = new ArrayList<>();
        Map<String, String> readExcel = ReadExcelData.readExcel(ConfigPathReadExcel.excelFilePath, ConfigPathReadExcel.sheetName, 1, 2);
        for (Map.Entry<String, String> entry : readExcel.entrySet()) {
            keyword = entry.getKey();
            value = entry.getValue();
            getKeyword.add(TestCaseRunner49177.writeFeature(keyword));
           // System.out.println("Key: " + keyword);
            //System.out.println("Value: " + value);
            readExcel.put(keyword, value);
        }
    }

}




// *********************************************************************************************************
//package runner;
//
//        import constant.ConfigPathReadExcel;
//        import org.apache.log4j.Logger;
//        import org.testng.annotations.Test;
//        import utilities.ReadExcelData;
//
//
//@Test
//public class FileRunner {
//
//    @Test
//    public  static void readExcel(){
//        ReadExcelData.readExcel(ConfigPathReadExcel.excelFilePath, ConfigPathReadExcel.sheetName,1);
//        System.out.println("excel created");
//
//
//    }
//
//}