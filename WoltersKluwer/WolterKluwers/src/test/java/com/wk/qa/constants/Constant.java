package com.wk.qa.constants;

import java.io.File;

public class Constant {

	public final static String USERS_HOME = System.getProperty("user.dir") + File.separator;

	public final static String FEATURE_HOME = USERS_HOME + File.separator+"src"+ File.separator+"main"+ File.separator + "resources" + File.separator;
	public final static String FEATURE_FILE = FEATURE_HOME + "mattercreation.feature";
	
	public final static String MATTERTESTCASE_HOME = USERS_HOME + File.separator+"src"+ File.separator+"main"+ File.separator + "resources" + File.separator+ "testcase" + File.separator;
	public final static String MATTERTESTCASE_FILE = MATTERTESTCASE_HOME + "MatterTestcase.xlsx";
	
	public final static String MATTERTESTDATA_HOME = USERS_HOME + File.separator+"src"+ File.separator+"main"+ File.separator + "resources" + File.separator+ "testdata" + File.separator;
	public final static String MATTERTESTDATA_FILE = MATTERTESTDATA_HOME + "Amtrak_US105846_MatterAllocation.json";
	
	
	

}
