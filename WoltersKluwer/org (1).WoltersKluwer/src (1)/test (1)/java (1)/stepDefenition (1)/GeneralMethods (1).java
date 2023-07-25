package stepDefenition;

import constant.ConfigPathReadExcel;
import constant.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Test
public class GeneralMethods {

    @Given("I login as <username> with <password>")
    public static String login() throws IOException, ParseException {
        return " I login as " + JsonReader.getJson("Username") + " " + "with" + " " + JsonReader.getJson("password");
    }

    @Then("I click the context menu link {string}")
    public static  List<String> clickEdition() throws IOException, ParseException {
        return Stream.of(
                " I prepare list screen" + JsonReader.getJson("Organisation Type") +"with given mode 'Normal'",
                " I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'")
                .collect(Collectors.toList());

    }

    @Then("I navigate to the Organization tab")
    public static String createOrganisation() {
        return " I provide field 'Name' with value '[#]OrgName'";

    }

    @Then("I verify that the newly created organization record is displayed correctly")
    public static List<String> typeOfOrganization() {
        return Stream.of(
                "I provide field 'Organization Type' with value '[#]OrgType'",
                "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'",
                "I provide field 'Vendor ID' with value '[#]OrgNum'",
                "I invoke operation 'Save'"
        ).collect(Collectors.toList());
    }

    @Then("I verify created organization")
    public static List<String> verfiedCreatedOrganizationlist() {
        return Stream.of( "I prepare list screen 'Organization List' with given mode 'Normal'",
                " I remove all search filters",
                " I add search filters perform search and store result in a variable '_ParentInstanceId'",
                " I verify list row count '[#]count'").collect(Collectors.toList());
    }
    
}









