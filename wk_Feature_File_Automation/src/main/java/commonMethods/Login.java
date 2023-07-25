package commonMethods;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;

public class Login {
    //    @Given("User navigate to login page")
    public void user_navigate_to_login_page() {
        System.out.println("user got navigate to login page");

    }

    //    @Then("User enter valid username")
    public void user_enter_vaild_userName(String string) {
        System.out.println("user enter valid username");
    }

    //    @Then("User enter valid password")
    public void enter_valid_password(String string) {
        System.out.println("user enter password");
    }

    //    @Then("Click on the login button")
    public void click_on_login_button() {
        System.out.println(" User click the login button ");
    }

    //    @Then("User should login successfully")
    public void User_should_login_successfully() {
        System.out.println(" user login successfully ");
    }

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
