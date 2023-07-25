package org.wk.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.wk.constant.Constant;

public class JsonDataReader {
	static Logger logger = Logger.getLogger(JsonDataReader.class);
	public static JSONObject getJsonObject(String key, String testCaseId) {
		
		try {
			InputStream input = new FileInputStream(Constant.testDataFile);
			JSONTokener tokener = new JSONTokener(input);
			JSONObject jsonObject = new JSONObject(tokener);
			JSONObject object = jsonObject.getJSONObject(key).getJSONObject(testCaseId);
			 
			return object;
		} catch (FileNotFoundException exception) {
			logger.error("Json Object Read is Not Performed" + exception);
		}
		return null;

	}



	
}
