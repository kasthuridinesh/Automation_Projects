package org.wk.runner;

import io.cucumber.java.en.Then;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
//
public class FeatureFileGenerator {

    public static void main(String[] args) {
        String featureFilePath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk-evaluation\\src\\test\\resources\\FeatureFile\\createOrganization1.feature";
        generateFeatureFile(ActionsClass.class, featureFilePath);
    }

    public static void generateFeatureFile(Class<?> stepDefinitionsClass, String featureFilePath) {
        StringBuilder featureFile = new StringBuilder();

        // Get all public methods from the step definitions class
        Method[] methods = stepDefinitionsClass.getMethods();

        // Generate the feature section
        featureFile.append("Feature: Invoice Creation and Submission\n\n");

        // Generate the scenario for each method
        for (Method method : methods) {
            if (method.isAnnotationPresent(Then.class)) {
                Then feature_annotation = method.getAnnotation(Then.class);
                String stepPattern = feature_annotation.value();
                System.out.println(stepPattern);

                // Generate the scenario steps
//                String scenario = String.format("  Scenario: %s\n", method.getName());
//                scenario += String.format("    Given %s\n", stepPattern);
                String scenario = String.format("    Then %s\n", stepPattern);
//                String scenario1= String.format("Then %s\n"),
//                scenario += String.format("    Then %s\n\n", method.getName());

                featureFile.append(scenario);
            }

        }

        // Write the generated feature file to the specified path
        try (FileWriter writer = new FileWriter(featureFilePath)) {
            writer.write(featureFile.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("feature file created");
    }
}
//    @Test
//public  void generateFeatureFile(Class<?> stepDefinitionsClass, String featureFilePath) {
//    StringBuilder featureFile = new StringBuilder();
//
//    // Get all public methods from the step definitions class
//    Method[] methods = stepDefinitionsClass.getMethods();
//
//    // Generate the feature section
//    featureFile.append("Feature: Invoice Creation and Submission\n\n");
//
//    // Generate the scenario for each method
//    for (Method method : methods) {
//        if (method.isAnnotationPresent(Then.class)) {
//            Then annotation = method.getAnnotation(Then.class);
//            String stepPattern = annotation.value();
//
//            // Generate the scenario steps
//            String scenario = String.format("  Then %s\n", stepPattern);
//            featureFile.append(scenario);
//
//            // Get the statements inside the method
//            try {
//                Object result = method.invoke(null); // Assuming static method
//                String methodStatements = result.toString();
//                featureFile.append("    " + methodStatements + "\n");
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // Write the generated feature file to the specified path
//    try (FileWriter writer = new FileWriter(featureFilePath)) {
//        writer.write(featureFile.toString());
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    System.out.println("Feature file created");
//}}
