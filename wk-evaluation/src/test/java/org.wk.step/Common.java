package org.wk.step;

import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.wk.utils.JsonDataReader;
import org.testng.annotations.Test;

import static org.wk.step.StepDefinition.jsonObject;

public class Common {
//    static Logger logger = Logger.getLogger(Common.class);
//    private static String prefix(String statement) {
//        return "Then " + statement;
//    }
//
//    // login method
//    @Test
//    public static String login() {
//        return "I login as " + jsonObject.getString("userName") + " and " + jsonObject.getString("password");
//    }
//
//    @Test
//    public static String logout() {
//        return "I logout";
//
//    }
//    public static String createOrganization(){
//
//        return "I provide field" + jsonObject.getString("fieldName") + "with value "
//                + jsonObject.getString("fieldValue")+"\n"+
//                "I prepare list screen " + jsonObject.getString("listScreenName") + "with given mode"
//                + jsonObject.getString("mode") + "\n"
//                + prefix("I prepare item screen" + jsonObject.getString("itemScreen") + "for the entity"
//                + jsonObject.getString("entity") + "in mode" + jsonObject.getString("entityMode"));
//    }
static Logger logger = Logger.getLogger(StepDefinition.class);
    static JSONObject jsonObject = JsonDataReader.getJsonObject("Data", "TC:49177");
@Test
    public static String generateStepDefinitions() {
        StringBuilder stepDefinitions = new StringBuilder();

        stepDefinitions.append("I login as ")
                .append(jsonObject.getString("userName"))
                .append(" and ")
                .append(jsonObject.getString("password"))
                .append("\n");

        stepDefinitions.append("I prepare list screen ")
                .append(jsonObject.getString("listScreenName"))
                .append(" with given mode ")
                .append(jsonObject.getString("mode"))
                .append("\n")
                .append("Then I prepare item screen ")
                .append(jsonObject.getString("itemScreen"))
                .append(" for the entity ")
                .append(jsonObject.getString("entity"))
                .append(" in mode ")
                .append(jsonObject.getString("entityMode"))
                .append("\n");

        stepDefinitions.append("I provide field ")
                .append(jsonObject.getString("fieldName"))
                .append(" with value ")
                .append(jsonObject.getString("fieldValue"))
                .append("\n");

        stepDefinitions.append("I provide filed organization type with value ")
                .append(jsonObject.getString("organizationType"))
                .append("\n")
                .append("Then I provide field ")
                .append(jsonObject.getString("fieldSubName"))
                .append(" with value ")
                .append(jsonObject.getString("fieldSubValue"))
                .append("\n")
                .append("Then I provide field ")
                .append(jsonObject.getString("vendorId"))
                .append(" with value ")
                .append(jsonObject.getString("vendorValue"))
                .append("\n")
                .append("Then I invoke operation ")
                .append(jsonObject.getString("actionKey"))
                .append("\n");

        stepDefinitions.append("I prepare list screen ")
                .append(jsonObject.getString("listScreenName"))
                .append(" with given mode ")
                .append(jsonObject.getString("mode"))
                .append("\n")
                .append("Then I remove all search filters\n")
                .append("Then I add search filters perform search and store result in a variable ")
                .append(jsonObject.getString("instanceId"))
                .append("\n")
                .append("Then I verify list row count ")
                .append(jsonObject.getString("rowCount"))
                .append("\n");

        stepDefinitions.append("I logout");
        logger.info(stepDefinitions.toString());

        return stepDefinitions.toString();
    }


}
