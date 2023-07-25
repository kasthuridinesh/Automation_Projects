package com.wk.qa.helper;

import java.util.List;
import com.wk.qa.utilities.Base;

public class GeneralMethod extends Base {

	static StringBuilder contentBuilder = new StringBuilder();
	static List<Object> values = jsonDataProvider();

	public static String loginPassport() {
		return "I login as '" + values.get(0) + "' with password '" + values.get(1) + "'";
	}

	// Then I provide field 'Is New Incident' with value '[#]Exist'
	public static String newIncident() {
		return "Then I provide field 'Is New Incident' with value '" + values.get(2) + "'";
	}
	
	
	
	
}
