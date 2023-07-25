package org.utils;
// **********Importing Libraries ****************

import java.io.FileReader;
import java.io.IOException;
import org.constant.Constant;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Class for reading Json  file and return value to method
public class JsonReader {
    public static String getJson(String key) {
        try {
            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader(Constant.JSON_FILE_PATH);

            Object object = jsonparser.parse(reader);
            JSONObject Userobj = (JSONObject) object;
            String name = (String) Userobj.get(key);
            return name;

        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }

        return "Data read from json is failed";
    }
}