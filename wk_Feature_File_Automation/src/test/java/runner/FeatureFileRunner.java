package runner;

import commonMethods.Login;
import org.testng.annotations.Test;

public class FeatureFileRunner {
    @Test
    public static void main(String[] args) {
     Login obj = new Login();
     obj.user_navigate_to_login_page();
     obj.user_enter_vaild_userName("");
     obj.enter_valid_password("");
     obj.click_on_login_button();
     obj.User_should_login_successfully();


//        obj.click_on_login_button("");
    }
}
