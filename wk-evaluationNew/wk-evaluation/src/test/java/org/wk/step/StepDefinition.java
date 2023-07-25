package org.wk.step;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.wk.utils.JsonDataReader;

public class StepDefinition {
	static Logger logger = Logger.getLogger(StepDefinition.class);
	static JSONObject jsonObject = JsonDataReader.getJsonObject("LoginData", "TC01");
	static String value = "Then ";

	public static String login() {

		return "I login as " + jsonObject.getString("userName") + " and " + jsonObject.getString("password");

	}

	public static String contextMenu() {

		return (" I prepare list screen 'Organization List' with given mode 'Normal'\n" + value
				+ "I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'");

	}

	public static String createNewOrganization() {

		return "I provide field 'Name' with value '[#]OrgName'";

	}

	public static String organizationType() {

		return ("I  provide filed organization type with value " + jsonObject.getString("organizationType") + "\n"
				+ value + "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" + value
				+ "I provide field 'Vendor ID' with value '[#]OrgNum'\n" + value + "I invoke operation 'Save'");
	}

	public static String verification() {

		return "I prepare list screen 'Organization List' with given mode 'Normal'\n" +
		  value + "I remove all search filters\n" + 
		  value + "I add search filters perform search and store result in a variable '_ParentInstanceId'\n" +
		  value + "I verify list row count '[#]count'\n\n" + 
		  value + "I logout\n";

	}

}
