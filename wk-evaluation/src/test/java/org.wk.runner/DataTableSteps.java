package org.wk.runner;
//
//import io.cucumber.java.en.Given;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.Map;
//
//public class DataTableSteps {
//
//    private static DataTableSteps storedDataTable;
//
//    @Given("I store the following data table:")
//    public void storeDataTable(DataTableSteps dataTable) {
//        storedDataTable = dataTable;
//    }
//@Test
//    @Given("I retrieve values from the stored data table")
//    public static String retrieveValuesFromDataTable() {
//        List<Map<String, String>> data = storedDataTable.asMaps(String.class, String.class);
//
//        // Access values from the DataTable
//        for (Map<String, String> row : data) {
//            String invoiceDate = row.get("invoice_date");
//            String vendorTaxReg = row.get("vendor_tax_reg");
//            String billingOfficeName = row.get("billing_office_name");
//            System.out.println(row);
//
//            // Use the retrieved values as needed
//            System.out.println("Invoice Date: " + invoiceDate);
//            System.out.println("Vendor Tax Reg: " + vendorTaxReg);
//            System.out.println("Billing Office Name: " + billingOfficeName);
//        }
//    return null;
//}
//
//    private List<Map<String, String>> asMaps(Class<String> stringClass, Class<String> stringClass1) {
//        List<Map<String, String>> retrieveValuesFromDataTable = null;
//        return retrieveValuesFromDataTable;
//    }
//}

//
//import io.cucumber.java.DataTableType;
//import io.cucumber.java.en.Given;
//import io.cucumber.datatable.DataTable;
//import org.testng.annotations.Test;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Map;
//
//public class DataTableSteps {
//
//    private static DataTable storedDataTable;
//
//    @Given("I store the following data table:")
//    public void storeDataTable(DataTable dataTable) {
//        storedDataTable = dataTable;
//    }
//
//    @Given("I retrieve values from the stored data table")
//    public static String retrieveValuesFromDataTable() {
//        List<Map<String, String>> data = storedDataTable.asMaps(String.class, String.class);
//
//        // Access values from the DataTable
//        for (Map<String, String> row : data) {
//            String invoiceDate = row.get("invoice_date");
//            String vendorTaxReg = row.get("vendor_tax_reg");
//            String billingOfficeName = row.get("billing_office_name");
//
//            // Use the retrieved values as needed
//            System.out.println("Invoice Date: " + invoiceDate);
//            System.out.println("Vendor Tax Reg: " + vendorTaxReg);
//            System.out.println("Billing Office Name: " + billingOfficeName);
//        }
//
//        return null;
//    }
//
//    @DataTableType
//    public DataTable createDataTable(List<Map<String, String>> dataTable) {
//        for (Map<String, String> row : dataTable) {
//            String invoiceDate = generateInvoiceDate();
//            String vendorTaxReg = generateVendorTaxReg();
//            String billingOfficeName = generateBillingOfficeName();
//
//            row.put("invoice_date", invoiceDate);
//            row.put("vendor_tax_reg", vendorTaxReg);
//            row.put("billing_office_name", billingOfficeName);
//        }
//
//        DataTable dt = DataTable.create(dataTable);
//        return dt;
//    }
//
//    private String generateInvoiceDate() {
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return currentDate.format(formatter);
//    }
//
//    private String generateVendorTaxReg() {
//        // Implement logic to generate vendor tax registration number
//        return "VENDOR123";
//    }
//
//    private String generateBillingOfficeName() {
//        // Implement logic to generate billing office name
//        return "Office XYZ";
//    }
//}

//import io.cucumber.datatable.TableConverter;
//import io.cucumber.datatable.TableEntryTransformer;
//
//import io.cucumber.java.DataTableType;
//import io.cucumber.java.en.Given;
//import io.cucumber.datatable.DataTable;
//import org.testng.annotations.Test;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//public class DataTableSteps {
//
//    public static DataTable storedDataTable;
//
//
//    @Given("I store the following data table:")
//    public void storeDataTable(DataTable value) {
//        storedDataTable = dataTable;
//    }
//
//    @Given("I retrieve values from the stored data table")
//    public static String retrieveValuesFromDataTable() {
//        List<Map<String, String>> data = storedDataTable.asMaps(String.class, String.class);
//
//        // Access values from the DataTable
//        for (Map<String, String> row : data) {
//            String invoiceDate = row.get("invoice_date");
//            String vendorTaxReg = row.get("vendor_tax_reg");
//            String billingOfficeName = row.get("billing_office_name");
//
//            // Use the retrieved values as needed
//            System.out.println("Invoice Date: " + invoiceDate);
//            System.out.println("Vendor Tax Reg: " + vendorTaxReg);
//            System.out.println("Billing Office Name: " + billingOfficeName);
//        }
//
//        return convertedData;
//    }
//
//    @DataTableType
//    public static  String  createDataTable(List<Map<String, String>> dataTable) {
//        List<List<String>> convertedData = new ArrayList<>();
//        for (Map<String, String> row : dataTable) {
//            List<String> rowData = new ArrayList<>();
//            for (String value : row.values()) {
//                rowData.add(value);
//            }
//            convertedData.add(rowData);
//            System.out.println("Value"+value);
//        }
//
//        TableConverter<List<String>> converter = new TableConverter<>(new EntryTransformer());
//        return DataTable.create(convertedData, converter);
//    }
//
//    public static String generateInvoiceDate() {
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return currentDate.format(formatter);
//    }
//
//    public static String generateVendorTaxReg() {
//        // Implement logic to generate vendor tax registration number
//        return "VENDOR123";
//    }
//
//    public static String generateBillingOfficeName() {
//        // Implement logic to generate billing office name
//        return "Office XYZ";
//    }
//
//    public static class EntryTransformer implements TableEntryTransformer<List<String>> {
//        @Override
//        public List<String> transform(Map<String, String> entry) {
//            return new ArrayList<>(entry.values());
//        }
//    }
//}

//
//import io.cucumber.java.DataTableType;
//import io.cucumber.java.en.Given;
//import io.cucumber.datatable.DataTable;
//import org.testng.annotations.Test;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class DataTableSteps {
//
//    private static DataTable storedDataTable;
//
//    @Given("I store the following data table:")
//    public void storeDataTable(DataTable dataTable) {
//        storedDataTable = dataTable;
//    }
//
//    @Given("I retrieve values from the stored data table")
//    public static String retrieveValuesFromDataTable() {
//        List<Map<String, String>> data = storedDataTable.asMaps(String.class, String.class);
//
//        // Access values from the DataTable
//        for (Map<String, String> row : data) {
//            String invoiceDate = row.get("invoice_date");
//            String vendorTaxReg = row.get("vendor_tax_reg");
//            String billingOfficeName = row.get("billing_office_name");
//
//
//            // Use the retrieved values as needed
//            System.out.println("Invoice Date: " + invoiceDate);
//            System.out.println("Vendor Tax Reg: " + vendorTaxReg);
//            System.out.println("Billing Office Name: " + billingOfficeName);
//        }
//
//        return retrieveValuesFromDataTable;
//    }
//
//    @DataTableType
//    public static List<Map<String, String>> createDataTable(DataTable dataTable) {
//        List<Map<String, String>> convertedData = new ArrayList<>();
//        List<List<String>> table = dataTable.asLists(String.class);
//
//        List<String> headers = table.get(0);
//        for (int i = 1; i < table.size(); i++) {
//            List<String> row = table.get(i);
//            Map<String, String> rowData = new HashMap<>();
//
//            for (int j = 0; j < headers.size(); j++) {
//                String header = headers.get(j);
//                String value = row.get(j);
//                rowData.put(header, value);
//            }
//            convertedData.add(rowData);
//            System.out.println("datatbale printing:"+convertedData);
//        }

//        return convertedData;
//    }
//
//    private static String generateInvoiceDate() {
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return currentDate.format(formatter);
//    }
//
//    private static String generateVendorTaxReg() {
//        // Implement logic to generate vendor tax registration number
//        return "VENDOR123";
//    }
//
//    private static String generateBillingOfficeName() {
//        // Implement logic to generate billing office name
//        return "Office XYZ";
//    }
//}
