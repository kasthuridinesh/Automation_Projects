package org.wk.step;
// ************** importing libraries***************
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.wk.utils.JsonDataReader;

// *********** Start of the Program ************
public class StepDefinition {
    static Logger logger = Logger.getLogger(StepDefinition.class);
    static JSONObject jsonObject = JsonDataReader.getJsonObject("Data", "TC:49177");

    private static String prefix(String statement) {
        return "Then " + statement;
    }

    public static String login() {

        return "I login as " + jsonObject.getString("userName") + " and " + jsonObject.getString("password");

    }

    public static String contextMenu() {

        return ("I prepare list screen " + jsonObject.getString("listScreenName") + "with given mode"
                + jsonObject.getString("mode") + "\n"
                + prefix("I prepare item screen" + jsonObject.getString("itemScreen") + "for the entity"
                + jsonObject.getString("entity") + "in mode" + jsonObject.getString("entityMode")));

    }

    public static String createNewOrganization() {
        return "I provide field" + jsonObject.getString("fieldName") + "with value "
                + jsonObject.getString("fieldValue");

    }

    public static String organizationType() {
        return ("I provide filed organization type with value " + jsonObject.getString("organizationType") + "\n"
                + prefix("I provide field " + jsonObject.getString("fieldSubName") + " with value "
                + jsonObject.getString("fieldSubValue") + "\n")
                + prefix("I provide field " + jsonObject.getString("vendorId") + " with value "
                + jsonObject.getString("vendorValue") + "\n"
                + prefix("I invoke operation " + jsonObject.getString("actionKey"))));
    }

    public static String verification() {
        return "I prepare list screen " + jsonObject.getString("listScreenName") + " with given mode "
                + jsonObject.getString("mode") + "\n" + prefix("I remove all search filters\n")
                + prefix("I add search filters perform search and store result in a variable "
                + jsonObject.getString("instanceId") + "\n")
                + prefix("I verify list row count " + jsonObject.getString("rowCount") + "\n");

    }

    public static String logout() {
        return "I logout";

    }


}
