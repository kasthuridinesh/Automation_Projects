package test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.testng.annotations.Test;
import java.io.*;
import java.util.*;


public class FeatureFile {
    @Test
        public static void main(String[] args) {
            String excelFilePath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\testdata\\wkTestCase.xlsx";
            String templateFilePath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\feature_template.mustache";
            String outputFilePath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\feature_templatenew.mustache";

            try (InputStream excelFile = new FileInputStream(excelFilePath);
                 Workbook workbook = new XSSFWorkbook(excelFile);
                 Writer writer = new FileWriter(outputFilePath)) {

                Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
                Iterator<Row> rowIterator = sheet.iterator();

                List<Map<String, String>> testCases = new ArrayList<>();

                // Skip header row
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                }

                // Read data from Excel and populate test cases list
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Map<String, String> testCase = new HashMap<>();
                    testCase.put("testCaseId", row.getCell(0).getStringCellValue());
                    testCase.put("step1", row.getCell(1).getStringCellValue());
                    testCase.put("step2", row.getCell(2).getStringCellValue());
                    testCase.put("step3", row.getCell(3).getStringCellValue());
                    testCases.add(testCase);
                }


                    // Load the Mustache template
                    MustacheFactory mustacheFactory = new DefaultMustacheFactory();
                Mustache mustache = mustacheFactory.compile(String.valueOf(new FileReader("C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\feature_template.mustache")));

                // Continue with the rest of your code...

                // Render the template with the data and write to the output file
                Map<String, Object> context = new HashMap<>();
                context.put("featureName", "Your Feature Name");
                context.put("testCases", testCases);
                mustache.execute(writer, context);

                System.out.println("Feature file generated successfully!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


