package com.wk.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wk.qa.constants.Constant;
import com.wk.qa.pojomodel.MatterDatas;

public class Base {

	static String userName;
	static String passWord;
	static String isIncident;

	public static List<Object> jsonDataProvider() {
		ObjectMapper objectMapper = new ObjectMapper();
		File jsonFile = new File(Constant.MATTERTESTDATA_FILE);
		List<Object> values = new ArrayList<>();
		try {

			MatterDatas data = objectMapper.readValue(jsonFile, MatterDatas.class);
			userName = data.getUsername();
			passWord = data.getPassword();
			isIncident = data.getPassword();
			values.add(userName);
			values.add(passWord);
			values.add(isIncident);
			return values;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
