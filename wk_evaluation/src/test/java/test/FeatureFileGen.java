package test;

import org.testng.annotations.Test;

import java.io.FileWriter;
import java.lang.reflect.Method;

@Test
public class FeatureFileGen {
    private FileWriter featureFileWriter;

    private void generateMethod(String methodName) {

        try {
            Class<?> cls = Class.forName("test.AllMethods");
            Method methods = cls.getMethod(methodName);
            Object result = methods.invoke(null);
            // Invoke the static method

//                String step = methodName.substring(0, 1).toUpperCase() + methodName.substring(1); // Convert method name to
            // sentence case

            String featureStep;

            if (methodName.equalsIgnoreCase("login")) {
                featureStep = "Given";
            } else {
                featureStep = "Then";
            }

            String featureLine = String.format("%s %s\n", featureStep, result); // Combine step and result in Gherkin
            // format

            // Write the feature step to the console
            System.out.println(featureLine);

            // Write the feature step to the feature file
            featureFileWriter.write(featureLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
