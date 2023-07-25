package org.wk.runner;
// ************* importing Libraries**************
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.wk.constant.Constant;
import org.wk.step.StepDefinition;
import org.wk.test.GetMethods;
import org.wk.utils.FeatureFileWriter;
import org.wk.utils.TestCaseReader;

//************ Start of the program *****************

public  class CreateFeaturFile {
    static Logger logger = Logger.getLogger(StepDefinition.class);
    public static String keywords;

//    public static FileWriter featureFileWriter;


    @Test
    public static void generateMethods() {
        List<String> featureSteps = new ArrayList<>();
        try {
            Map<String, String> readExcel = TestCaseReader.readExcel(Constant.EXCEL_FILE_PATH, Constant.SHEET_NAME);

            for (Map.Entry<String, String> entry : readExcel.entrySet()) {

                keywords = entry.getKey();
                featureSteps.add((GetMethods.generateMethod(keywords)));
            }
            FeatureFileWriter.writeFeatureFile(Constant.FEATURE_FILE_PATH, featureSteps);
            logger.info("Feature file generated successfully");
        } catch (Exception exception) {
            logger.error("Feature file is not generated" + exception);
        }

    }}
//    ****************** End of the Program **********************
