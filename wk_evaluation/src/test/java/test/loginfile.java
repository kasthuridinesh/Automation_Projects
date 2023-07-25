package test;
import constant.Constant;
import io.cucumber.java.en.Then;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.*;
import test.MethodGenerator;


import static constant.Constant.password;
import static constant.Constant.username;

@Test
public class loginfile {

    private static StringBuilder featureFileContent = new StringBuilder();
    String featureFilePath = Constant.FeatureFilePath;
@Test(priority = 1)
    public void loginIntoApplication() throws IOException {
        // Read JSON data from file
        JSONObject jsonData = readJsonDataFromFile(Constant.jsonFilePath);
        System.out.println(jsonData);

        // Get username and password from JSON data
        assert jsonData != null;
        String username = (String) jsonData.get("userName");
        String password = (String) jsonData.get("password");


        // Add code to perform login with the obtained username and password
        // ...

        // Generate the corresponding step in the feature file
        featureFileContent.append("Login into the application with username ")
                .append(username)
                .append(" and password ")
                .append(password)
                .append("\n");

        try (FileWriter writer = new FileWriter(featureFilePath)) {
            writer.write(featureFileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }}

    @Test
    public String clickContextMenu() {
        return (" I prepare list screen 'Organization List' with given mode 'Normal' \n" +
                " I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'\n" +
                "\n");
    }


    @Test
    public String navigateToOrganizationTab() {
        // Implementation for PeopleTab step
        // Add code to navigate to the organization tab and create a new organization
        return ("I navigate to the Organization tab\n"+"I provide field 'Name' with value '[#]OrgName'\n");
    }

    @Test
    public String verifyOrganizationType() {
        // Implementation for EnterFieldSave step
        // Add code to verify that the organization type is set to "internal"
        return ("I provide field 'Organization Type' with value '[#]OrgType'\n" +
                "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" +
                "I provide field 'Vendor ID' with value '[#]OrgNum'\n" +
                "I invoke operation 'Save'\n");
    }

    @Test
    public String verifyNewlyCreatedOrganization() {
        // Implementation for Verification step
        // Add code to verify the newly created organization record
        return ("I prepare list screen 'Organization List' with given mode 'Normal' \n" +
                "I remove all search filters\n" +
                "I add search filters perform search and store result in a variable '_ParentInstanceId'");
    }
    @Test
    public String getTestData(String key) {
        // Implement the logic to read the test data from the Excel file based on the given key
        // Return the corresponding value for the key
        return ("Then I logout");
    }


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        public void ClickEditIcon(){
        String context_Menu = String.valueOf(featureFileContent.append("Click context menu link organization"+"\n"));
            try (FileWriter writer = new FileWriter(featureFilePath)) {
                writer.write(featureFileContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void clickEditIcon() {
        Map<String, String> keyValuePairs = readKeyValuePairsFromExcel(Constant.excelFilePath);
        String contextMenuLink = keyValuePairs.get("ClickEditIcon");
        featureFileContent.append("Click ").append(contextMenuLink).append("\n");

        try (FileWriter writer = new FileWriter(featureFilePath)) {
            writer.write(featureFileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    public void generateFeatureFile() {
        try (FileWriter writer = new FileWriter("C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\new1.feature")) {
            writer.write(featureFileContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  JSONObject readJsonDataFromFile(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filePath));
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Map<String, String> readKeyValuePairsFromExcel(String filePath) {
        Map<String, String> keyValuePairs = new HashMap<>();
        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber++) {
                Row row = sheet.getRow(rowNumber);
                String key = row.getCell(1).getStringCellValue();
                String value = row.getCell(2).getStringCellValue();
                keyValuePairs.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keyValuePairs;
    }

//    @Test
//    public static String login() {
//        return "I login as " + featureFileContent.toString();
//    }
    }


