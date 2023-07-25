package runner;

//import constant.ConfigPathReadExcel;
//import org.testng.annotations.Test;
//import stepDefenition.GeneralMethods;
//import utilities.ReadExcelData;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Map;
//
//
//@Test
//public class CompareRunner {
//    static String keyword;
//    static String value;
//
//    @Test
//    public void getKeyword() {
//        Map<String, String> readExcel = ReadExcelData.readExcel(ConfigPathReadExcel.excelFilePath, ConfigPathReadExcel.sheetName, 1, 2);
//        for (Map.Entry<String, String> entry : readExcel.entrySet()) {
//            keyword = entry.getKey();
//            value=entry.getValue();
//            System.out.println("Key: " + keyword);
//            //System.out.println("Value:"+ value);
//            readExcel.put(keyword,value);
//
//
//        }
//    }
//
//    @Test
//    public static void getMethodNames() {
//        GeneralMethods definition = new GeneralMethods();
//        Method[] methods = definition.getClass().getDeclaredMethods();
//        for (Method method : methods) {
//            String name = method.getName();
//            System.out.println("Method Name: " + name);
//            System.out.println("Key: " + CompareRunner.keyword);
//
//            try {
//                method.setAccessible(true); // Allow invoking private methods if needed
//                Object result = method.invoke(null);
//                //System.out.println("Output: " + result);
//            } catch (IllegalAccessException e) {
//                // Handle IllegalAccessException
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                // Handle InvocationTargetException
//                e.printStackTrace();
//            }
//        }
//    }
//}

//        Method[] methods = GeneralMethods.class.getMethods();
//
//        for (Method method : methods) {
//            System.out.println(method);
//            if (method.getName().equalsIgnoreCase(keyword)) {
//                String methodName = method.getName();
//                try {
//                    String result = (String) method.invoke(null);
//                    System.out.println("Executing method: " + methodName);
//                    System.out.println("Result: " + result);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }



//import constant.ConfigPathReadExcel;
//import org.json.simple.parser.ParseException;
//import org.testng.annotations.Test;
//import utilities.ReadExcelData;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//
//@Test
//public class CompareRunner {
//    static String keyword;
//    static String name;
//    static String value;
//
//    @Test
//    public void getKeyword() throws IOException, ParseException {
//        List<String> getKeyword = new ArrayList<>();
//        Map<String, String> readExcel = ReadExcelData.readExcel(ConfigPathReadExcel.excelFilePath, ConfigPathReadExcel.sheetName, 1, 2);
//        for (Map.Entry<String, String> entry : readExcel.entrySet()) {
//            keyword = entry.getKey();
//            value = entry.getValue();
//            getKeyword.add(TestCaseRunner49177.writeFeature(keyword));
//            System.out.println("Key: " + keyword);
//            //System.out.println("Value: " + value);
//            readExcel.put(keyword, value);
//        }
//    }
//
//}
