package com.wk.qa.dataprovider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.wk.qa.constants.Constant;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FeatureFileGenerator {

	public static void generateFeatureFile(List<Object> stepDefinition, String featureName, String scenario) {
		try {
			// Set up the Freemarker configuration
			Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
			configuration.setClassForTemplateLoading(FeatureFileGenerator.class, "/template");
			// Prepare data model for the scenario
			Map<String, Object> dataModel = new HashMap<>();
			dataModel.put("feature", featureName);
			dataModel.put("scenarioName", scenario);
		//	if(!stepDefinition.) {
			for(Object de: stepDefinition) {
			List<Object> givenSteps = new ArrayList<>();
			givenSteps.add(de);		
			dataModel.put("givenSteps", givenSteps);
			}
		
			
			// Process the template and generate the feature file scenario
			Template template = configuration.getTemplate("feature.ftl");
			FileWriter fileWriter = new FileWriter(new File(Constant.FEATURE_HOME + featureName + ".feature"));
			template.process(dataModel, fileWriter);
			fileWriter.close();
			System.out.println("Feature file scenario generated successfully.");
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}
}