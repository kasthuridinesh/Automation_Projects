package runner;
import commonMethods.GeneralMethods;
import constant.Constant;
import org.json.simple.parser.ParseException;


import java.io.IOException;
public class DatatableRunner {
    public static void main(String[] args) throws IOException, ParseException {
        String inv1 = "saveinvoice";
        String invoice="alertMessage";
        String links="Link";
        String featureFilePath = Constant.FEATURE_FILE_PATH;
        // Define the table data
        String[][] invoiceCreation = {
                {"invoice_date", "vendor_tax_reg", "billing_office_name", "currency_type", "start_date", "end_date  ",},
                {" ", "              ", "                   ", "USD          ", "06/07/2023", "07/07/2023",}
        };
        String[][] lineItemDataTable= {
                {"fee_amount","fee_narrative","expense_amount","expense_narrative","charge_date ","task     ","activity                    ",},
                {"          ","             ","              ","				 ","06/07/2023  ","Fee - Fee","A105 - Communicate (in firm)",}
        };
        String[][] rejectionDataTable = {
                {"RejectOption      ", "Reason                      ", "Narrative              ", "LineItemNos", "IsLineItemWindow",},
                {"Selected Line Item", "Alternative Fee Arrangement ", "Test reject by invoice ",  "all       ",  "true           ",}
        };
        GeneralMethods.generateFeature(featureFilePath, invoiceCreation,lineItemDataTable,rejectionDataTable);
        GeneralMethods.savingInvoice(inv1);
        GeneralMethods.submittingInvoice(inv1);
        GeneralMethods.alertMessage(invoice);
        GeneralMethods.clickLink(links);
        GeneralMethods.approveInvoice();
//        GeneralMethods.invoiceCreation(featureFilePath,invoiceCreation);
//        GeneralMethods.lineItemDataTable(featureFilePath,lineItemDataTable);

    }

}
