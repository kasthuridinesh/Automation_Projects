Feature: Feature File for common UI Elements

Scenario Outline: Generating feature file for the common UI Elements in web Applications

 Given I login to the application using username<user_name>and password<password>
Then I Select the dropdown<field>with<values>
Then I Select the checkbox<field>with<values>
Then I enter the <content> in textbox field
Then I Select the radio button option<radioButtonName>
Then I search for the <content>in the search bar
Then I click menubar and select<menu> menu
Then I verify menu bar contains<all Necessary>button
Then I validate alert message<message>and accept
Then I navigate to<page> and click<field>
 Then I click on <iconName>icon
 Then I click on <image>image
 Then I click on the <field>displayed on tooltip
 Then I click the<linkText>and that should be redirected to the<destinationPage>
 Then I should see the notification message<notificationMessage> and display the message in the output
Then I perform an action that requires a screenshot
Then a screenshot should be captured with the name<path>
Then I select the<currentDate>from the date picker
Then I drag the<element>and drop it into the respective<dropPlace>
Then I perform the scroll up and scroll down operation
Then I perform the Slider operation for the specificvalues

Examples:
| Scenario |
|    1     |
