package org.wk.runner;

import org.apache.poi.ss.usermodel.*;
import org.wk.constant.Constant;

import java.io.FileInputStream;
import java.io.IOException;

public class Bot {

    public static void main(String[] args) {
        String excelFilePath = Constant.EXCEL_FILE_PATH;
        generateFeatureFile(excelFilePath);
    }

    public static void generateFeatureFile(String excelFilePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(excelFilePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            StringBuilder featureContent = new StringBuilder();

            for (Row row : sheet) {
                Cell testCaseNameCell = row.getCell(0);
                Cell stepsCell = row.getCell(1);
                Cell expectedResultsCell = row.getCell(2);

                String testCaseName = testCaseNameCell.getStringCellValue();
                String steps = stepsCell.getStringCellValue();
                String expectedResults = expectedResultsCell.getStringCellValue();

                // Generate the feature file content using the extracted data
                String scenarioTemplate = "Scenario: %s\nGiven %s\nThen %s\n\n";
                String scenarioContent = String.format(scenarioTemplate, testCaseName, steps, expectedResults);
                featureContent.append(scenarioContent);
            }

            // Print or save the generated feature file content
            System.out.println(featureContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
