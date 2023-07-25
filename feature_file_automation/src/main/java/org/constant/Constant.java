package org.constant;
// ***********Importing Libraries **************
import java.io.File;
//********** Constant Class for saving Constant Data **********
public class Constant {
    public static String JSON_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "testdata.json" + File.separator;
    public static String FEATURE_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "FeatureFile" + File.separator + "FeatureFile.feature" + File.separator;
}
