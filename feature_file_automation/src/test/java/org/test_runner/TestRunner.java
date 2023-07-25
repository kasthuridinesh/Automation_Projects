package org.test_runner;
// **********Importing Libraries ****************
import org.action_class.ActionClass;
import org.constant.Constant;
import org.testng.annotations.Test;
import org.utils.JsonReader;
import org.utils.WriteFeatureFile;
import java.util.ArrayList;
import java.util.List;
// Runner Class for All the Ui element methods.
@Test
public class TestRunner {

    WriteFeatureFile write = new WriteFeatureFile();
@Test
    public void userAction() throws Exception {
        List<String> statements = new ArrayList<>();
        ActionClass actions = new ActionClass();
        String[] featureLines =
                {actions.loginToApplication(JsonReader.getJson("userName"), JsonReader.getJson("password")),
                actions.selectValueFromDropDown(JsonReader.getJson("dropdownField"), JsonReader.getJson("dropdownFieldValue")),
                actions.selectCheckBox(JsonReader.getJson("checkBoxField"), JsonReader.getJson("checkBoxValues")),
                actions.enterDataInTextBox(JsonReader.getJson("textBoxContent")),
                actions.clickRadioButton(JsonReader.getJson("radioButtonName")),
                actions.searchButton(JsonReader.getJson("searchBar")),
                actions.menuBar(JsonReader.getJson("menuBar")),
                actions.verifyMenuBar(JsonReader.getJson("verifyMenuInMenuBar")),
                actions.alterMessage(JsonReader.getJson("handleAlertMessage")),
                actions.navigateToPages(JsonReader.getJson("navigationPage"), JsonReader.getJson("navigationField")),
                actions.selectIcon(JsonReader.getJson("icon")),
                actions.clickImage(JsonReader.getJson("imageIcon")),
                actions.clickTooltip(JsonReader.getJson("clickToolTip")),
                actions.clickingLink(JsonReader.getJson("clickLink"), JsonReader.getJson("redirectionPage")),
                actions.notificationMessage(JsonReader.getJson("notificationMessage")),
                actions.takeScreenShot(),
                actions.saveScreenShot(JsonReader.getJson("saveScreenshot")),
                actions.datePicker(JsonReader.getJson("datePicker")),
                actions.dragAndDrop(JsonReader.getJson("dragElement"),JsonReader.getJson("dropPlace")),
                actions.scrollOperation(),
                actions.slider("values")
                };

        for (String feature_file_steps : featureLines) {
            statements.add(feature_file_steps);
        }
//        writing All the featurefile steps   in the feature file.
        write.writeFeatureFile(Constant.FEATURE_FILE_PATH, statements);


    }
}



