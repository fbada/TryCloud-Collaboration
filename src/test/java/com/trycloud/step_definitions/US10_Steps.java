package com.trycloud.step_definitions;

import com.trycloud.pages.FileAccessPage;
import com.trycloud.pages.Login_Page_Default;
import com.trycloud.pages.ModulesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class US10_Steps {

    LoginPage loginPage = new LoginPage();
    ModulesPage modulesPage = new ModulesPage();
    FileAccessPage fileAccessPage = new FileAccessPage();
    public final String pathFile = "/Users/rds1/Desktop/CYDEO/Automation/TryCloud-Collaboration/src/test/resources/UploadFileAda/Jenkins.png";
    String fileName = pathFile.substring(pathFile.lastIndexOf('/')+1, pathFile.lastIndexOf('.'));

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
        BrowserUtils.waitFor(4);
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        fileAccessPage.clickSettingCheckboxes();

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
        fileAccessPage.uploadFileButton.sendKeys(pathFile);
        BrowserUtils.waitFor(4);
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {

        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(3);
    }

    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        afterStorage = fileAccessPage.storageAmount.getText();
        afterStorage = afterStorage.substring(0, afterStorage.indexOf(' '));
        beforeStorage = beforeStorage.substring(0, beforeStorage.indexOf(' '));
        System.out.println(afterStorage);

        BrowserUtils.waitFor(3);
        Assert.assertTrue(Double.parseDouble(beforeStorage)< Double.parseDouble(afterStorage));


//Delete the element
        Actions action = new Actions(Driver.getDriver());

        BrowserUtils.scrollToElement(fileAccessPage.getfileUploaded(fileName));
        BrowserUtils.waitFor(1);
        action.moveToElement(fileAccessPage.getfileUploaded(fileName), -100, 0).click().perform();




        action.moveToElement(fileAccessPage.actionsInHeader).click().perform();
        BrowserUtils.waitFor(1);
       action.click(fileAccessPage.deleteDropdown).perform();
        BrowserUtils.waitFor(1);




    }


}
