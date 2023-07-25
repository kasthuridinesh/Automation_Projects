package org.action_class;
// Contains UI Elements Method for Generating Feature File.
// *************** Importing Libraries ************

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
// *********** Start of the program ************//
public class ActionClass {
    static Logger logger = Logger.getLogger(ActionClass.class);

    @Test
    public String loginToApplication(String username, String password) {
        String statement = " Given I login to the application using username" + username + "and password" + password;
        logger.info("loginToApplication::" + statement);
        return statement;
    }
    @Test
    public String selectValueFromDropDown(String field, String value) {
        String statement = "Then I Select the dropdown" + field + "with" + value;
        logger.info("selectValueFromDropDown::" + statement);
        return statement;

    }
    @Test
    public String selectCheckBox(String field, String value) {
        String statement = "Then I Select the checkbox" + field + "with" + value;
        logger.info("selectCheckBox::" + statement);
        return statement;
    }
    @Test
    public String enterDataInTextBox(String data) {
        String statement = "Then I enter the " + data + " in textbox field";
        logger.info("enterDataInTextBox::" + statement);
        return statement;
    }
    @Test
    public String clickRadioButton(String buttonName) {
        String statement = "Then I Select the radio button option" + buttonName;
        logger.info("clickRadioButton::" + statement);
        return statement;
    }
    @Test
    public String clickButton(String actionName) {
        String statement = "Then I click on " + actionName + " button";
        logger.info("clickButton::" + statement);
        return statement;
    }
    @Test
    public String searchButton(String data) {
        String statement = "Then I search for the " + data + "in the search bar";
        logger.info("searchButton::" + statement);
        return statement;
    }
    @Test
    public String menuBar(String feild) {
        String statement = "Then I click menubar and select" + feild + " menu";
        logger.info("menuBar::" + statement);
        return statement;
    }
    @Test
    public String verifyMenuBar(String feild) {
        String statement = "Then I verify menu bar contains" + feild + "button";
        logger.info("verifyMenuBar::" + statement);
        return statement;
    }
    @Test
    public String alterMessage(String message) {
        String statement = "Then I validate alert message" + message + "and accept";
        logger.info("alterMessage::" + statement);
        return statement;
    }
    @Test
    public String navigateToPages(String page, String feild) {
        String statement = "Then I navigate to" + page + " and click" + feild;
        logger.info("navigateToPages::" + statement);
        return statement;
    }
    @Test
    public String clickImage(String image) {
        String statement = " Then I click on " + image + "image";
        logger.info("clickImage::" + statement);
        return statement;
    }
    @Test
    public String selectIcon(String iconName) {
        String statement = " Then I click on " + iconName + "icon";
        logger.info("selectIcon::" + statement);
        return statement;
    }
    @Test
    public String clickTooltip(String element) {
        String statement = " Then I click on the " + element + "displayed on tooltip";
        logger.info("clickTooltip::" + statement);
        return statement;

    }
    @Test
    public String clickingLink(String link, String destination_page) {
        String statement = " Then I click the" + link + "and that should be redirected to the" + destination_page;
        logger.info("clickingLink::" + statement);
        return statement;

    }
    @Test
    public String notificationMessage(String notification_message) {
        String statement = " Then I should see the notification message" + notification_message + " and display the message in the output";
        logger.info("notificationMessage::" + statement);
        return statement;

    }
    @Test
    public String takeScreenShot() {
        String statment = "Then I perform an action that requires a screenshot";
        logger.info("takeScreenShot::" + statment);
        return statment;
    }
    @Test
    public String saveScreenShot(String captured_image) {
        String statment = "Then a screenshot should be captured with the name" + captured_image;
        logger.info("saveScreenShot::" + statment);
        return statment;
    }
    @Test
    public String viewImage(String image) {
        String statment = "When I click the " + image + " and view image";
        logger.info("viewImage::" + statment);
        return statment;
    }
    @Test
    public static String switchToWindow(String windowName) {
        String statement = "User should switch to the " + windowName + " window";
        logger.info("switchToWindow::" + statement);
        return statement;
    }
    @Test
    public String logOut() {
        String statment = " Then I logout from the application";
        logger.info("logOut::" + statment);
        return statment;
    }
    @Test
    public String datePicker(String currectDate){
        String statement = "Then I select the"+currectDate+ "from the date picker";
        logger.info("datePicker::"+statement);
        return statement;
    }
    @Test
    public String dragAndDrop(String element,String dropPlace) {
        String statement = "Then I drag the" + element + "and drop it into the respective" + dropPlace;
        logger.info("dragAndDrop::"+statement);
        return statement;
    }
    @Test
    public String scrollOperation(){
        String statement ="Then I perform the scroll up and scroll down operation";
        logger.info("scrollOperation::"+statement);
        return statement;
    }
    @Test
    public String slider(String values){
        String statement = "Then I perform the Slider operation for the specific"+ values;
        logger.info("slider::"+statement);
        return statement;
    }

}



