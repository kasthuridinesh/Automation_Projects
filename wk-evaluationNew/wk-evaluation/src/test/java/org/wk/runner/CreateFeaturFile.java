package org.wk.runner;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.wk.constant.Constant;
import org.wk.step.StepDefinition;
import org.wk.test.GetMethods;
import org.wk.utils.FeatureFileWriter;
import org.wk.utils.TestCaseReader;


public class CreateFeaturFile {
	static Logger logger = Logger.getLogger(StepDefinition.class);

	public static FileWriter featureFileWriter;
	public static String keywords;

	public void generateMethods() {

		List<String> featureSteps = new ArrayList<>() ;
		
		try {
			
			Map<String, String> readExcel = TestCaseReader.readExcel(Constant.excelFilePath, Constant.sheetName);

			
			for (Map.Entry<String, String> entry : readExcel.entrySet()) {
				
				keywords = entry.getKey();
				featureSteps.add(GetMethods.generateMethod(keywords));

			}

			FeatureFileWriter.writeFeatureFile(Constant.featureFilePath, featureSteps);
			logger.info("Feature file generated successfully");
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
