package org.wk.constant;

public class Constant {

	public static String USER_DIRECTORY = System.getProperty("user.dir");
	public static String EXCEL_FILE_PATH = USER_DIRECTORY + "\\testData\\wk_testcase.xlsx";
	public static String TEST_DATA_FILE = USER_DIRECTORY + "\\testData\\inputData.json";
	public static String FEATURE_FILE_PATH = USER_DIRECTORY + "\\src\\test\\resources\\FeatureFile\\createOrganization.feature";
	public static String SHEET_NAME = "Sheet1";
	public static String ALL_METHODS = "org.wk.step.StepDefinition";
	public static String COMMON_METHODS = "org.wk.step.Common";
}