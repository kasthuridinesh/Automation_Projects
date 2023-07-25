package org.wk.test;

import java.lang.reflect.Method;

public class GetMethods {
	public static String featureLine;

	public static String generateMethod(String methodName) {
		try {
			Class<?> cls = Class.forName("org.wk.step.StepDefinition");
			Method method = cls.getMethod(methodName);
			Object result = method.invoke(null); // Invoke the static method

			String featureStep;

			if (methodName.equalsIgnoreCase("login")) {
				featureStep = "Given";
			} else {
				featureStep = "Then";
			}

			featureLine = String.format("%s %s\n", featureStep, result);
			System.out.println(featureLine);
			return featureLine;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
