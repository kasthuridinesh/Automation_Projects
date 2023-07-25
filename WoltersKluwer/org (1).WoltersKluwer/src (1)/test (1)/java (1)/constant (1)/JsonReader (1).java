package constant;
// "Importing libraries"
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
//+++++++++++++++ Start of the program ++++++++++++++++++++++++
@Test
public class JsonReader {
    public static String getJson(String key) throws IOException, ParseException {

        {
            JSONParser jsonparser = new JSONParser();
            FileReader reader = new FileReader(ConfigPathReadExcel.Jsondatapath);

            Object obj = jsonparser.parse(reader);
            JSONObject Userobj = (JSONObject) obj;
            String name = (String) Userobj.get(key);
            return name;

        }
    }

    public static String getFeatureData(String key) throws IOException, ParseException {

        {
            JSONParser jsonparsers = new JSONParser();
            FileReader read = new FileReader(ConfigPathReadExcel.FeatureData);

            Object object = jsonparsers.parse(read);
            JSONObject Userobject = (JSONObject) object;
            String getInput = (String) Userobject.get(key);
            return getInput;

        }
    }
}
//++++++++++++++++ End of the  program +++++++++++++++++++
