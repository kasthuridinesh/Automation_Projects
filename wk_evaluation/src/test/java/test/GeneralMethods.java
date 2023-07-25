package test;
import constant.Constant;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class GeneralMethods {

    private static StringBuilder featureFileContent = new StringBuilder();


//    @Given("Login into the application with username and password")
//    public void loginIntoApplication() throws IOException {
//       loginfile login = new loginfile();
//       login.loginIntoApplication();
//
//    }

    @Then("Click context menu link organization")
    public String clickContextMenu(String modeType) {
       return (" I prepare list screen 'Organization List' with given mode 'Normal' \n" +
                " I prepare item screen 'Base Org Header' for the entity 'Organization' in mode 'Add'\n" +
                "\n");
    }

    @Then("Navigate to organization tab and then create new organization")
    public String navigateToOrganizationTab() {
        // Implementation for PeopleTab step
        // Add code to navigate to the organization tab and create a new organization
        return ("I navigate to the Organization tab\n"+"I provide field 'Name' with value '[#]OrgName'\n");
    }

    @Then("Organization type should be internal")
    public String verifyOrganizationType() {
        // Implementation for EnterFieldSave step
        // Add code to verify that the organization type is set to "internal"
       return ("I provide field 'Organization Type' with value '[#]OrgType'\n" +
               "I provide field 'Int Organization Sub Type' with value '[#]InternalSubOrgType'\n" +
               "I provide field 'Vendor ID' with value '[#]OrgNum'\n" +
               "I invoke operation 'Save'\n");
    }

    @Then("Verify newly created organization record")
    public String verifyNewlyCreatedOrganization() {
        // Implementation for Verification step
        // Add code to verify the newly created organization record
        String a = "Then ";
        return (a+"I prepare list screen 'Organization List' with given mode 'Normal' \n" +
                a+"I remove all search filters\n" +
                a+"I add search filters perform search and store result in a variable '_ParentInstanceId'");
    }

    public String getTestData(String key) {
        // Implement the logic to read the test data from the Excel file based on the given key
        // Return the corresponding value for the key
        return ("Then I logout");
    }
}


