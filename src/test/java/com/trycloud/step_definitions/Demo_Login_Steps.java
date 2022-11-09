package com.trycloud.step_definitions;

import com.trycloud.pages.Login_Page_Default;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo_Login_Steps {
    Login_Page_Default cloudDriver= new Login_Page_Default();
    @Given("user on the login page")
    public void user_on_the_login() {

        cloudDriver.navigateTo();
    }
    @When("user types username {string} and password {string}")
    public void user_use_username_and_passcode(String username,String password) {

        cloudDriver.trycloud_login(username,password);


    }
    @When("user click the login button")
    public void user_click_the_login_button() {


        cloudDriver.user_click_loginBtn();

        BrowserUtils.waitUntilVisible(cloudDriver.customizeBtn,20);


    }
    @Then("verify the user should be at the dashboard {string} page")
    public void verify_the_user_should_be_at_the_dashboard_page(String title) {
        BrowserUtils.verifyTitleEquals(title);
    }
}
