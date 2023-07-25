package org.utils;
// **********Importing Libraries ****************
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import org.apache.log4j.Logger;
// Class for writing Feature file for the UI element methods
public class WriteFeatureFile {
    static Logger logger = Logger.getLogger(WriteFeatureFile.class);
    JsonReader jsonData = new JsonReader();

    public void writeFeatureFile(String featureFilePath, List<String> featureFile) {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(featureFilePath))) {
            writer.write("Feature: " + jsonData.getJson("feature") + "\n\n");
            writer.write("Scenario Outline: " + jsonData.getJson("Scenario") + "\n\n");
            for (String lines : featureFile) {
                writer.write(lines + "\n");
            }
            writer.write("\nExamples:\n");
            writer.write("| Scenario |\n");
            writer.write("|    1     |\n");

        }

        catch(Exception exception){
            exception.printStackTrace();
        }

    }
}


