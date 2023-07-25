package test;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.Constant;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadExcel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class FeatureFileGenerator1 {
    public static Logger logger = Logger.getLogger(FeatureFileGenerator1.class);
    @Test
    public static void main(String[] args) {
        String templatePath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\template.feature";
        String outputPath = "C:\\Users\\kasthuri.kandavelu\\Downloads\\api_basic\\wk_evaluation\\template\\dynamictemplatecreated.feature"; // Specify the path where you want to generate the feature file

        try {
            String templateContent = readFileContent(templatePath);
            String dynamicContent = generateDynamicContent(templateContent);
            writeToFile(outputPath, dynamicContent);

            logger.info("Dynamic feature file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFileContent(String filePath) throws IOException {
        // Read the content of the template file
        // You can use any file reading technique, such as BufferedReader or Files.readAllLines
        // Here, I'm using a simple approach with StringBuilder and FileReader
        StringBuilder contentBuilder = new StringBuilder();
        FileReader fileReader = new FileReader(filePath);
        int ch;
        while ((ch = fileReader.read()) != -1) {
            contentBuilder.append((char) ch);
        }
        fileReader.close();
        return contentBuilder.toString();
    }

    private static String generateDynamicContent(String templateContent) {
        // Generate the dynamic content based on your requirements
        String precondition = "I have a precondition";
        String action = "I perform an action";
        String result = "I should see an expected result";

        // Replace the placeholders in the template with the dynamic values
        return templateContent
                .replace("<precondition>", precondition + " ")
                .replace("<username>", Constant.username + " ")
                .replace("<password>", Constant.password + " ")
                .replace("<action>", action)
                .replace("<result>", result);
    }

    private static void writeToFile(String filePath, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(content);
        writer.close();
    }
}

