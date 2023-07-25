package org.wk.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

public class FeatureFileWriter {
	static Logger logger = Logger.getLogger(FeatureFileWriter.class);

	static FileWriter featureFileWriter;

	public static void writeFeatureFile(String outputFilePath, List<String> content) {
		try {

			featureFileWriter = new FileWriter(outputFilePath);
			featureFileWriter.append("Feature: Creating Internal Organization\n\n");
			featureFileWriter.append("Scenario: Create an internal organization record\n\n");

			for (String single : content) {

				featureFileWriter.append(single);

			}

			featureFileWriter.append("\nExamples:\n");
			featureFileWriter.append("| Scenario |\n");
			featureFileWriter.append("|    1     |\n");
			featureFileWriter.close();

			logger.info("Feature file writ successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
