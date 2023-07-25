package com.wk.qa.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.wk.qa.constants.Constant;

public class FeatureFileWriter {

    public static void main(String[] args) {
    	
    	StringBuilder contentBuilder = new StringBuilder();
    	contentBuilder.append(false);
        String featureFileContent = "Feature: My Feature\n\n" +
                "Scenario: My Scenario\n" +
                "Given I have a precondition\n" +
                "When I perform an action\n" +
                "Then I should see the expected result";
        writeFeatureFile(Constant.FEATURE_FILE, featureFileContent);
    }

    public static void writeFeatureFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Feature file written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the feature file: " + e.getMessage());
        }
    }
}
