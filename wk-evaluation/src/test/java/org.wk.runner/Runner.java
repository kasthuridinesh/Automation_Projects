package org.wk.runner;

import io.cucumber.datatable.DataTable;
import org.testng.annotations.Test;

public class Runner {
    @Test
    public void runner() {
        CreateFeaturFile.generateMethods();
        DataTable table = null;
//        DataTableSteps.createDataTable(table);
    }

    @Test
    public void runnerFeature() {
//        List<LinkedHashMap<String, String>> dataTable = new ArrayList<>();
//        ActionsClass.creatingInvoice("M1", "<company_name>", dataTable);

//        ActionsClass.creatingInvoice("matter_name", "organization_Name", dataTable);
        ActionsClass.addingLineItmes("Task_and_activity");
        ActionsClass.savinInvoice("invoice");
        ActionsClass.submittingInvoice("invoice");
        ActionsClass.alterMessage("alert_message");
        ActionsClass.clickLink("link");
        ActionsClass.approveInvoice();
        ActionsClass.rejectInvoice();
    }

    }

