package org.wk.test;
// ************ importing libraries *************

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.wk.constant.Constant;
import java.lang.reflect.Method;

//*************** Start of the program *******************
public class GetMethods {
    static Logger logger = Logger.getLogger(GetMethods.class);
    public static String featureLine;

    @Test
    public static String generateMethod(String methodName) {
        try {
            Class<?> classloader = Class.forName(Constant.ALL_METHODS);
            Method method = classloader.getMethod(methodName);
            Object result = method.invoke(null); // Invoke the static method

            String featureStep;

            if (methodName.equalsIgnoreCase("login")) {
                featureStep = "Given";
            } else {
                featureStep = "Then";
            }

            featureLine = String.format("%s %s\n", featureStep, result);
            logger.info(featureLine);

            return featureLine;

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return methodName;
    }
}




