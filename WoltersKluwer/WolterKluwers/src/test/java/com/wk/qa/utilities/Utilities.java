package com.wk.qa.utilities;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.wk.qa.constants.Constant;
import com.wk.qa.dataprovider.ExcelDataReader;
import com.wk.qa.helper.GeneralMethod;

public class Utilities {

	public static String userName;
	public static String passWord;
	public static ExcelDataReader config = new ExcelDataReader(Constant.MATTERTESTCASE_FILE);

	public static List<Object> methodFetcher(List<String> ref, Class<?> targetClass) {
		Method[] methods = null;
		List<Object> stepDefinitions = new ArrayList<>();
		try {
			targetClass = GeneralMethod.class;
			methods = targetClass.getDeclaredMethods();
					int i=0;
			for (Method method : methods) {
				String methodName = method.getName();
				for(String step: ref) {
				if (methodName.toLowerCase().contains(step.toLowerCase())) {
					if (!Modifier.isAbstract(method.getModifiers())) {
						Object stepDefinition = method.invoke(targetClass.newInstance());
						stepDefinitions.add(stepDefinition);
						System.out.println(stepDefinitions);
					}
				}
				}
			}
			return stepDefinitions;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return null;
	}
	
}
