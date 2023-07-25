package test;

import constant.FileJson;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Feature {

@Test
    public static void main(String[] args) {
        String excelFilePath = "testdata/wkTestCase.xlsx";
        String featureFilePath = "template/newdynamic.feature";



        try (FileInputStream fileInputStream = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(featureFilePath)) {

            Sheet sheet = workbook.getSheetAt(0);

            StringBuilder featureFileContent = new StringBuilder();


            for (int rowNumber = 1;  rowNumber<= sheet.getLastRowNum(); rowNumber++) {
                Row rowvalue = sheet.getRow(rowNumber);

                String testcaseId = rowvalue.getCell(0).getStringCellValue();
                String testCase = rowvalue.getCell(2).getStringCellValue();
//                String keyValue = row.getCell(1).getStringCellValue();
                if ( rowNumber== 1) {
                    featureFileContent.append("Scenario: Testcase ").append(testcaseId + "\n");
                }
                if (rowNumber == 1) {
                    featureFileContent.append("Given ").append(testCase).append("\n");
                } else {
                    featureFileContent.append("Then").append(testCase).append("\n");

                }


//                String testcaseId = row.getCell(0).getStringCellValue();
//                String keyValue = row.getCell(1).getStringCellValue();
//                String testCase = row.getCell(2).getStringCellValue();
//
//                // Generate the feature file content based on the Excel data
//                featureFileContent.append("Feature: Testcase ").append(testcaseId).append("\n");
//                featureFileContent.append("Scenario").append(testcaseId);
////                featureFileContent.append("    Scenario: ").append(testCase).append("\n");
//                featureFileContent.append("Given").append(testCase);
//
//                featureFileContent.append("Then").append(keyValue).append("\n");


            }

            // Write the generated content to the feature file
            fileOutputStream.write(featureFileContent.toString().getBytes());

            System.out.println("Feature file generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


