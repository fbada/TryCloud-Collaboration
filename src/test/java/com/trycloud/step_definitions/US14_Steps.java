package com.trycloud.step_definitions;

import com.trycloud.pages.ModulesPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US14_Steps {

    ModulesPage modulesPage = new ModulesPage();

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        BrowserUtils.highlight(modulesPage.magnifiierIcon);
        modulesPage.magnifiierIcon.click();
        BrowserUtils.verifyElementDisplayed(modulesPage.searchField);
    }

    @When("users search any existing {string}")
    public void users_search_any_existing(String string) {
        BrowserUtils.highlight(modulesPage.searchField);
        modulesPage.searchField.sendKeys(string);
        BrowserUtils.waitFor(3);
    }

    @Then("verify the app displays the expected result {string}")
    public void verify_the_app_displays_the_expected_result(String string) {
        BrowserUtils.waitFor(3);
        BrowserUtils.highlight(modulesPage.searchQueryResult(string));
        Assert.assertTrue(modulesPage.searchQueryResult(string).isDisplayed());
    }
}
