package runner;
import constant.ConfigPathReadExcel;
import constant.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import stepDefenition.GeneralMethods;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Test
public class TestCaseRunner49177
{
    @Test
    public  static String writeFeature(String methodName) throws IOException, ParseException {
        String featureStep;
        List<String> methods = new ArrayList<>();
        methods.add(GeneralMethods.login());
        methods.addAll(GeneralMethods.clickEdition());
        methods.add(GeneralMethods.createOrganisation());
        methods.addAll(GeneralMethods.typeOfOrganization());
        methods.addAll(GeneralMethods.verfiedCreatedOrganizationlist());

        try (FileWriter fileWriter = new FileWriter(ConfigPathReadExcel.FeatureFilepath)) {
            fileWriter.append("Feature:" + " \n" + JsonReader.getFeatureData("feature") + "\n");
            fileWriter.append("Scenario Outline:" + " \n" + JsonReader.getFeatureData("Tc_No") + "\n");
            for (String method : methods) {
                Method storeMethod = GeneralMethods.class.getMethod(methodName);
                Object result=storeMethod.invoke(null);
                if (method.equalsIgnoreCase(GeneralMethods.login())) {
                    featureStep = "Given";
                } else {
                    featureStep = "Then";
                }
                String featureLine = String.format("%s %s\n", featureStep, method);
                fileWriter.append(featureLine);
                fileWriter.append('\n');

            }
            fileWriter.append("Examples: \n" +
                    " | Scenario | \n" +
                    " |    1   |");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}

// for (Row row : sheet) {
//         // Read the key value from the first column
//         Cell keyCell = row.getCell(0);
//         String keyValue = keyCell.getStringCellValue();
//
//         // Check if the key value matches a method name
//         for (Method method : GeneralMethods.class.getMethods()) {
//        if (method.getName().equals(keyValue)) {
//        // Execute the matching method
//        try {
//        String result = (String) method.invoke(null);
//        System.out.println("Executing method: " + method.getName());
//        System.out.println("Result: " + result);
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
//        break; // Exit the loop after finding a match
//        }
//        }
//        }
//
//        // Close the workbook
//        workbook.close();
//        }













































//package runner;
//        import constant.ConfigPathReadExcel;
//        import constant.JsonReader;
//        import org.json.simple.parser.ParseException;
//        import org.testng.annotations.Test;
//        import stepDefenition.GeneralMethods;
//        import java.io.FileWriter;
//        import java.io.IOException;
//        import java.lang.reflect.Method;
//        import java.util.ArrayList;
//        import java.util.List;
//
//@Test
//public class TestCaseRunner49177
//{
//    @Test
//    public  void writeFeature() throws IOException, ParseException {
//        String featureStep;
//        List<String> methods = new ArrayList<>();
//        methods.add(GeneralMethods.login());
//        methods.addAll(GeneralMethods.clickEdition());
//        methods.add(GeneralMethods.createOrganisation());
//        methods.addAll(GeneralMethods.typeOfOrganization());
//        methods.addAll(GeneralMethods.verfiedCreatedOrganizationlist());
//        try (FileWriter fileWriter = new FileWriter(ConfigPathReadExcel.FeatureFilepath)) {
//            fileWriter.append("Feature:" + " \n" + JsonReader.getFeatureData("feature") + "\n");
//            fileWriter.append("Scenario Outline:" + " \n" + JsonReader.getFeatureData("Tc_No") + "\n");
//            for (String method : methods) {
//                if (method.equalsIgnoreCase(GeneralMethods.login())) {
//                    featureStep = "Given";
//                } else {
//                    featureStep = "Then";
//                }
//                String featureLine = String.format("%s %s\n", featureStep, method);
//                fileWriter.append(featureLine);
//                fileWriter.append('\n');
//
//            }
//            fileWriter.append("Examples: \n" +
//                    " | Scenario | \n" +
//                    " |    1   |");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
//// for (Row row : sheet) {
////         // Read the key value from the first column
////         Cell keyCell = row.getCell(0);
////         String keyValue = keyCell.getStringCellValue();
////
////         // Check if the key value matches a method name
////         for (Method method : GeneralMethods.class.getMethods()) {
////        if (method.getName().equals(keyValue)) {
////        // Execute the matching method
////        try {
////        String result = (String) method.invoke(null);
////        System.out.println("Executing method: " + method.getName());
////        System.out.println("Result: " + result);
////        } catch (Exception e) {
////        e.printStackTrace();
////        }
////        break; // Exit the loop after finding a match
////        }
////        }
////        }
////
////        // Close the workbook
////        workbook.close();
////        }






















