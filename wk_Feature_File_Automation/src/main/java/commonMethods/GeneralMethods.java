package commonMethods;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;


public class GeneralMethods {

    public static void generateFeature(String filepath, String[][] invoiceDataTable, String[][] lineItemDataTable, String[][] rejectionDataTable) {
        try (FileWriter writer = new FileWriter(filepath)) {
//             Write the feature file content
            writer.write("Feature: Create Invoice\n");
            writer.write("\n");
            writer.write("Scenario: Create Invoice for Matter\n");
            writer.write(
                    "When I create an invoice for matter \"M1\" with vendor \"<company_name>\" for template \"<invoice_template>\" and template type \"<invoice_template_type>\"\n");

            // Write the table content
            for (String[] row : invoiceDataTable) {
                writer.write("|");
                for (String cell : row) {
                    writer.write(" " + cell + " |");
                }
                writer.write("\n");
            }
            writer.write("When I add  line item to the invoice with \"<template_name>\"\n");
            // Write the table content
            for (String[] row : lineItemDataTable) {
                writer.write("|");
                for (String cell : row) {
                    writer.write(" " + cell + " |");
                }
                writer.write("\n");
            }
            String savingInvoiceStep = savingInvoice("inv1");
            writer.write(savingInvoiceStep + "\n");
            String submittingInvoiceStep = submittingInvoice("inv1");
            writer.write(submittingInvoiceStep + "\n");
            String alertMessageStep = alertMessage("invoice");
            writer.write(alertMessageStep + "\n");
            String clickLinkStep = clickLink("link");
            writer.write(clickLinkStep + "\n");
            String approveInvoiceStep = approveInvoice();
            writer.write(approveInvoiceStep + "\n");
            writer.write("When I add reject the invoice as per the below table:\"\n");
            // Write the table content
            for (String[] row : rejectionDataTable) {
                writer.write("|");
                for (String cell : row) {
                    writer.write(" " + cell + " |");
                }
                writer.write("\n");
            }

            System.out.println("Feature file generated successfully!");
        } catch (IOException e) {
            System.err.println("Failed to generate the feature file: " + e.getMessage());
        }
    }

    @Test
    public static String savingInvoice(String inv1) {
        return "Then I save the invoice and name it as " + inv1;
    }

    @Test
    public static String submittingInvoice(String inv1) {
        return "Then I submit the invoice " + inv1 + " for review";
    }

    @Test
    public static String alertMessage(String invoice) {
        return "Then I validate alert " + invoice + " message";
    }

    @Test
    public static String clickLink(String link) {
        String statement = "Then I click on the " + link + " and redirect to the respective page";
        System.out.println("clickLink Successfull");
        return statement;
    }

    @Test
    public static String approveInvoice() {
        String Statement = "Then I approve the invoice";
        System.out.println("approve invoce Successfull");
        return Statement;
    }

//    public static void invoiceCreation(String filepath, String[][] invoiceCreation) {
//        try (FileWriter writer = new FileWriter(filepath)) {
//            // Write the feature file content
//            writer.write("Feature: Create Invoice\n");
//            writer.write("\n");
//            writer.write("Scenario: Create Invoice for Matter\n");
//            writer.write(
//                    "When I create an invoice for matter \"M1\" with vendor \"<company_name>\" for template \"<invoice_template>\" and template type \"<invoice_template_type>\"\n");
//
//            // Write the table content
//            for (String[] row : invoiceCreation) {
//                writer.write("|");
//                for (String cell : row) {
//                    writer.write(" " + cell + " |");
//                }
//                writer.write("\n");
//            }
//            System.out.println("+++++++++++++++++++++++");
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void lineItemDataTable(String filepath, String[][] lineItemDataTable) throws IOException {
//        try (FileWriter writer = new FileWriter(filepath)) {
//            writer.append("When I add  line item to the invoice with \"<template_name>\"\n");
//            // Write the table content
//            for (String[] row : lineItemDataTable) {
//                writer.append("|");
//                for (String cell : row) {
//                    writer.append(" " + cell + " |");
//                }
//                writer.append("\n");
//            }
//
//        }
//    }



//    public static String verifyTable(DataTable table) {
//        StringBuilder statement = new StringBuilder("Then I should see the following table:\n");
//
//        // Get the table data as a list of lists
//        List<List<String>> tableData = table.asLists(String.class);
//
//        // Iterate over the table rows
//        for (ListDocument.List<String> row : tableData) {
//            // Append the row values to the statement
//            statement.append("  | ");
//            statement.append(String.join(" | ", row));
//            statement.append(" |\n");
//        }
//
//        // Return the statement
//        return statement.toString();
//    }
}

