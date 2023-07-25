package test;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static freemarker.template.Configuration.*;

public class FeatureFileGenerator {

//        public static void main(String[] args) {
//            // Read test case data from a source (e.g., Excel, database)
//            Map<String, String> testCaseData = readTestCaseData();
//
//            // Prepare the data model for the Freemarker template
//            Map<String, Object> dataModel = new HashMap<>();
//            dataModel.put("testCaseId", testCaseData.get("TestCaseID"));
//            dataModel.put("testCaseSteps", testCaseData.get("Testcase"));
//
//            // Configure Freemarker
//            Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
//            cfg.setClassForTemplateLoading(FeatureFileGenerator.class, "/templates");
//
//            try {
//                // Load the Freemarker template
//                Template template = cfg.getTemplate("feature_template.ftl");
//
//                // Create the output file
//                File outputFile = new File("output.feature");
//
//                // Generate the feature file from the template and data model
//                FileWriter writer = new FileWriter(outputFile);
//                template.process(dataModel, writer);
//                writer.close();
//
//                System.out.println("Feature file generated successfully!");
//            } catch (IOException | TemplateException e) {
//                e.printStackTrace();
//            }
//        }
//
//        private static Map<String, String> readTestCaseData() {
//            // Read and return the test case data from your source
//            // In this example, we are using a dummy data map for simplicity
//            Map<String, String> testCaseData = new HashMap<>();
//            testCaseData.put("TestCaseID", "Tc01");
//            testCaseData.put("Testcase", "1.Login into the application with username and password\n" +
//                    "2.Click context menu link organization\n" +
//                    "3.Navigate to organization tab and then create new organization\n" +
//                    "4.Organization type should be internal\n" +
//                    "5.Verify newly created organization record");
//
//            return testCaseData;
//        }


@Test
        public static void main(String[] args) {
            // Load the Freemarker configuration
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(FeatureFileGenerator.class, "\\template");

            // Define the test case data
            List<Map<String, String>> testCases = new ArrayList<>();
            Map<String, String> testCase1 = new HashMap<>();
            testCase1.put("TestcaseID", "Tc01");
            testCase1.put("KeyValue", "Login");
            testCase1.put("Testcase", "1. Login into the application with username and password");
            // Add more test cases as needed

            // Process the test case data and generate the feature file
            try {
                Template template = configuration.getTemplate("feature.ftl");

                for (Map<String, String> testCase : testCases) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("testcase", testCase);

                    String fileName = testCase.get("TestcaseID") + ".feature";
                    Writer fileWriter = new FileWriter(new File(fileName));
                    template.process(data, fileWriter);
                    fileWriter.close();
                }

                System.out.println("Feature files generated successfully.");
            } catch (IOException | TemplateException e) {
                e.printStackTrace();
            }
        }
    }




