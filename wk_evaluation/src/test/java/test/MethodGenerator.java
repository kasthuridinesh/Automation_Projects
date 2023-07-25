package test;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import constant.Constant;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class MethodGenerator {
//    package org.wk.utils;

    public static FileWriter featureFileWriter;
    public static String featureStep;

    @Test
    public void generateMethods() throws IOException {
// reading excel for key value
        String userDirectory = System.getProperty("user.dir");
        String featureFilePath = userDirectory + "\\template\\file.feature";
        featureFileWriter = new FileWriter(featureFilePath);

        FileInputStream inputFile = new FileInputStream(userDirectory + "\\testdata\\wkTestCase.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        Map<String, String> data = new LinkedHashMap<String, String>();

        // Reading data from Excel to HashMap
        for (int rowNum = 1; rowNum <= rowCount; rowNum++) {
            String key = sheet.getRow(rowNum).getCell(1).getStringCellValue();
            String value = sheet.getRow(rowNum).getCell(2).getStringCellValue();
            data.put(key, value);
        }
        featureFileWriter.append("Feature: Creating Internal Organization\n\n");
        featureFileWriter.append("Scenario Outline: Create an internal organization record\n\n");
        // Generate methods based on the keys
        for (Map.Entry<String, String> entry : data.entrySet()) {
            generateMethod(entry.getKey());
        }
        featureFileWriter.append("\nExamples:\n");
        featureFileWriter.append("| Scenario |\n");
        featureFileWriter.append("|    1     |\n");
        featureFileWriter.close();
    }

    public static void generateMethod(String methodName) {

        try {
            Class<?> cls = Class.forName("test.MethodGenerator");
            Method method = cls.getMethod(methodName);
            Object result = method.invoke(null); // Invoke the static method

//                String step = methodName.substring(0, 1).toUpperCase() + methodName.substring(1); // Convert method name to
            // sentence case



            if (methodName.equalsIgnoreCase("login")) {
                featureStep = "Given";
            } else {
                featureStep = "Then";
            }

            String featureLine = String.format("%s %s\n", featureStep, result); // Combine step and result in Gherkin
            // format

            // Write the feature step to the console
            System.out.println(featureLine);

            // Write the feature step to the feature file
            featureFileWriter.write(featureLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Generated methods based on keys
    public static String TypeOfOrganization() {
        // System.out.println("organizationType()");
        String value = "Then ";
        return ("I provide field 'Organization Type' with value '[#]OrgType'\n" +
                featureStep + "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" +
                value + "I provide field 'Vendor ID' with value '[#]OrgNum'\n" +
                value + "I invoke operation 'Save'\n");
    }

    public static String ClickEditIcon() {
        // System.out.println("contextmenu()");
        // Add your test logic here
        return (" I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'\n" +
                "\n");
    }

    public static String CreateOrganization() {
        // System.out.println("createNewOrganization()");
        // Add your test logic here
        String a = "Then ";
        return ("I prepare list screen 'Organization List' with given mode 'Normal' \n" +
                a + "I remove all search filters\n" +
                a + "I add search filters perform search and store result in a variable '_ParentInstanceId'");
    }

    public static String Login() {
        // System.out.println("login()");
        // Add your test logic here
        return "I login as " + Constant.username + " and " + Constant.password;
    }

    public static String Verification() {
        // System.out.println("verification()");
        // Add your test logic here
        String a = "Then ";
        return ("I provide field 'Organization Type' with value '[#]OrgType'\n" +
                a + "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" +
                a + "I provide field 'Vendor ID' with value '[#]OrgNum'\n" +
                a + "I invoke operation 'Save'\n");
    }

}


