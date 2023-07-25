package org.wk.runner;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;

public class ActionsClass {


//    @Then("I create invoice for matter \"M1\" with vendor \"<company_name>\" for template \"<invoice_template>\"")
//    public  static String creatingInvoice(String matter_name, String organization_Name,List<Map<String, String>> dataTable) {
//        String statement = "I create invoice for matter" + matter_name +
//                "with vendor" + organization_Name;
////        List<List<String>> userList = dataTable.asLists(String.class);
////        for (List<String> tablevalue : userList) {
////            System.out.println(tablevalue);
////        }
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//
//        for (Map<String,String> row :data) {
//             String invoice_date = row.get("invoice_date");
//
//            System.out.println(row);
//        }
//
//        return statement;
//    }


    @Test
    @Then("I create invoice for matter \"M1\" with vendor \"<company_name>\" for template \"<invoice_template>\"")
    public static String creatingInvoice(String matter_name, String organization_Name, List<LinkedHashMap<String, String>> dataTable) {
        String statement = "I create invoice for matter " + matter_name +
                " with vendor " + organization_Name;

        for (Map<String, String> row : dataTable) {
            String invoice_date = row.get("invoice_date");
            // Use the invoice_date value as needed
            System.out.println(invoice_date);
        }

        return statement;
    }


    @Given("user login")
    public static String loginPage() {
        String statement = "User is on login page";
        return statement;
    }

    @Then("passing username")
    public static String enterText(String userName, String password) {
        String statement = "User should enter " + userName + " and " + password;
        return statement;
    }

    @Then("Passing password")
    public static String click(String buttonType) {
        String statement = "User should click the " + buttonType + " button";
        return statement;
    }

    @Then("I add  line item to the invoice with template \"Task and activity\"")
    public static String addingLineItmes(String Task_and_activity) {
        String statement = "I add  line item to the invoice with template" + Task_and_activity;
        System.out.println(statement);
        return statement;

    }

    @Then("I save the invoice and name it as \"inv1\"")
    public static String savinInvoice(String invoice) {
        String statement = "I save the invoice and name it as" + invoice + "\n"
                + "I submit the invoice" + invoice + "for review" + "\n";
        System.out.println(statement);
        return statement;


    }

    @Then("I submit the invoice \"inv1\" for review")
    public static String submittingInvoice(String invoice) {
        String statement = "I submit the invoice" + invoice + "for review";
        System.out.println(statement);
        return statement;

    }

    @Then("I validate alert message")
    public static String alterMessage(String alert_message) {
        String statement = "I validate alert " + alert_message + " message";
        System.out.println(statement);
        return statement;

    }

    @Then("I click on the link \"\" and redirect to the respective page")
    public static String clickLink(String link) {
        String statement = " I click on the link" + link + "and redirect to the respective page";
        System.out.println(statement);
        return statement;

    }

    @Then("I approve the invoice")
    public static String approveInvoice() {
        String statement = "  I approve the invoice";
        System.out.println(statement);
        return statement;

    }

    @Then("I reject the invoice ")
    public static String rejectInvoice() {
        String statement = " I reject the invoice";
        System.out.println(statement);
        return statement;

    }


}


