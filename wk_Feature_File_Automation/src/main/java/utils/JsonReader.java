package utils;

import constant.Constant;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
@Test
    public static String getJson(String key) throws IOException, ParseException {

        {
            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader(Constant.TEST_DATA_PATH);

            Object obj = jsonparser.parse(reader);
            JSONObject Userobj = (JSONObject) obj;
            String name = (String) Userobj.get(key);
            System.out.println(name);
            return name;
        }
    }

//    public static String getFeatureData(String key) throws IOException, ParseException {
//
//        {
//            JSONParser jsonparsers = new JSONParser();
//            FileReader read = new FileReader(ConfigPathReader.FeatureData);
//
//            Object object = jsonparsers.parse(read);
//            JSONObject Userobject = (JSONObject) object;
//            String getInput = (String) Userobject.get(key);
//            return getInput;
//
//        }
//    }
}
