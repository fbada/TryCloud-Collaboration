package com.trycloud.step_definitions;

import com.trycloud.pages.FileAccessPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.ModulesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class US10_Steps {

    LoginPage loginPage = new LoginPage();
    ModulesPage modulesPage = new ModulesPage();
    FileAccessPage fileAccessPage = new FileAccessPage();
    String systemPath = System.getProperty("user.dir");
    String filePath = systemPath + "/src/test/resources/UploadFileAda/Jenkins.png";
    String fileName = filePath.substring(filePath.lastIndexOf('/') + 1, filePath.lastIndexOf('.'));

    @When("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login();
    }

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        fileAccessPage.settingsButton.click();
        BrowserUtils.waitFor(3);
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        modulesPage.accessModules(string).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {

        for (WebElement checkBox : fileAccessPage.settingsCheckboxes) {
            BrowserUtils.highlight(checkBox);
            checkBox.click();
            BrowserUtils.waitFor(1);
           Assert.assertTrue(checkBox.isEnabled());
            checkBox.click();
        }
    }


    String beforeStorage, afterStorage;

    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        beforeStorage = fileAccessPage.storageAmount.getText();
        System.out.println("beforeStorage = " + beforeStorage);

    }

    @And("user uploads file with the {string} file option")
    public void userUploadsFileWithTheOption(String arg0) {

        fileAccessPage.addButton.click();
        BrowserUtils.waitForInvisibilityOf(fileAccessPage.uploadStart);
        fileAccessPage.uploadStart.sendKeys(filePath);
        BrowserUtils.waitFor(5);

        // Check if upload failed due to Not Enough Space and retry
        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(fileAccessPage.notEnoughSpaceBtn.isDisplayed());
            fileAccessPage.notEnoughSpaceBtn.click();
            BrowserUtils.sleep(1);
            fileAccessPage.uploadStart.sendKeys(filePath);
            BrowserUtils.waitFor(3);
        } catch (Exception e) {
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }


    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(2);
    }

    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        afterStorage = fileAccessPage.storageAmount.getText();
        afterStorage = afterStorage.substring(0, afterStorage.indexOf(' '));
        beforeStorage = beforeStorage.substring(0, beforeStorage.indexOf(' '));

        System.out.println(afterStorage);

        BrowserUtils.waitFor(1);
        Assert.assertTrue(Double.parseDouble(beforeStorage) < Double.parseDouble(afterStorage));


  //Delete the element
      fileAccessPage.deleteUploadedFile(fileName);

      //  Driver.closeDriver();
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String arg0, String arg1) {
        loginPage.loginInPageCred(arg0, arg1);
    }
}