package com.wk.qa.runner;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import com.wk.qa.constants.Constant;
import com.wk.qa.dataprovider.ExcelDataReader;
import com.wk.qa.dataprovider.FeatureFileGenerator;
import com.wk.qa.helper.GeneralMethod;
import com.wk.qa.utilities.Utilities;

public class Matter {

	public static ExcelDataReader config = new ExcelDataReader(Constant.MATTERTESTCASE_FILE);

	@Test
	public void matterRunner() {

		List<String> ref= new ArrayList<>();
		ref.add("login");
		ref.add("newIncident");
		FeatureFileGenerator.generateFeatureFile(
				Utilities.methodFetcher(ref, GeneralMethod.class), config.getKeyValue(0, 1, 2),
				config.getKeyValue(0, 1, 3));
	}

}
