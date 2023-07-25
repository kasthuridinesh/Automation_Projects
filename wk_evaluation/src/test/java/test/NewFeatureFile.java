package test;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import constant.FileJson;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

@Test
public class NewFeatureFile {

    private StringBuilder featureFileContent = new StringBuilder();

    //        @Given("Login into the application with username and password")
    public void login() {
        // Implementation for login step
        System.out.println("Login into the application with username and password" + "\n");
    }

    //        @Then
    public void clickContextMenu() {
        // Implementation for click context menu step
        System.out.println("Click context menu link organization" + "\n");
    }

    //        @Then
    public void navigateAndCreateOrganization() {
        // Implementation for navigate and create organization step
        System.out.println("Navigate to organization tab and then create new organization" + "\n");
    }

    //
    public void verifyOrganizationType() {
        // Implementation for organization type verification step
        System.out.println("Organization type should be internal" + "\n");
    }

    //
    public void verifyNewlyCreatedOrganization() {
        // Implementation for organization verification step
        System.out.println("Verify newly created organization record");
    }

    // Method to match key-value pairs and invoke respective step methods
    public void matchKeyValue(String keyValue) {
        switch (keyValue) {
            case "Login":
                login();
                break;
            case "ClickEditIcon":
                clickContextMenu();
                break;
            case "PeopleTab":
                navigateAndCreateOrganization();
                break;
            case "EnterFieldSave":
                verifyOrganizationType();
                break;
            case "Verification":
                verifyNewlyCreatedOrganization();
                break;
            default:
                // Handle unknown key-value pair
                break;
        }
    }

    String outputFilePath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\feature_templatenew1.mustache";
    public void generateFeatureFileFromExcel(String excelFilePath, String featureFilePath) {
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(excelFilePath))) {
            Sheet sheet = workbook.getSheetAt(0);
            Writer writer = new FileWriter(outputFilePath);

            for (int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                Row row = sheet.getRow(rowNumber);

                String testcaseId = row.getCell(0).getStringCellValue();
                String keyValue = row.getCell(1).getStringCellValue();
                String testCase = row.getCell(2).getStringCellValue();
                System.out.println(testcaseId);
                System.out.println(keyValue);
                System.out.println(testCase);


                if (rowNumber == 1) {
                    featureFileContent.append("Feature: Testcase ").append(testcaseId).append("\n");
                }

                if (rowNumber == 1) {
                    featureFileContent.append("Scenario: ").append(testcaseId).append("\n");
                }

                featureFileContent.append("Then ").append(testCase).append("\n");
                MustacheFactory mustacheFactory = new DefaultMustacheFactory();
                Mustache mustache = mustacheFactory.compile(String.valueOf(new FileReader("C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\feature_template.mustache")));

                // Match key-value pair and invoke respective step method
                matchKeyValue(keyValue);
                mustache.execute(writer,keyValue );

                System.out.println("Feature file generated successfully!");

            }

            // Write the generated feature file content to a file
            // You can modify this part to save the content in the desired file path
            // For simplicity, we are just printing the content to the console here
            System.out.println(featureFileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
  
}


