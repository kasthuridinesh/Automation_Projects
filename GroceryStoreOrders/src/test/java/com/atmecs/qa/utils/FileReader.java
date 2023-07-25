package com.atmecs.qa.utils;

import java.io.FileInputStream;
import java.util.Properties;
// Importing Libraries
import org.testng.log4testng.Logger;


public class FileReader {
    public Logger logger = Logger.getLogger(FileReader.class);

    public String getAttribute(String attributeName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(Constant.configPath));
            return properties.getProperty(attributeName);
        } catch (Exception exception) {
            logger.error("File Not Found " + exception);
        }
        return null;
    }
}
