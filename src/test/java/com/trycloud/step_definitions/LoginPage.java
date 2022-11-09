package com.trycloud.step_definitions;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Config;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="user")
    public WebElement userField;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="submit-form")
    public WebElement submitButton;

    @FindBy(xpath = "//button[@aria-label='Actions']")
    public WebElement setWeatherLocationButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public  WebElement warningMessage;

    public void login(){
        userField.sendKeys(Config.getProperty("username"));
       passwordField.sendKeys(Config.getProperty("passWord"));
       submitButton.click();
        BrowserUtils.verifyElementDisplayed(setWeatherLocationButton);
    }

    public void loginInPageCred(String user, String pass){

        userField.sendKeys(user);
        passwordField.sendKeys(pass);
        submitButton.click();
        BrowserUtils.verifyElementDisplayed(setWeatherLocationButton);



    }


}
