package com.trycloud.pages;

import com.trycloud.utilities.Config;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class Login_Page_Default extends BasePage{
    public Login_Page_Default() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    private WebElement usernameBox;


    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordBox;


    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;


    @FindBy(xpath = "//a[@id='lost-password']")
    private WebElement lostPasswordBtn;

    @FindBy(xpath = "//div//a[.='Customize']")
    public WebElement customizeBtn;

    @FindBy(xpath = "//div//p[contains(text(),'Wrong username')]")
    public WebElement wrongMsg;








    public void navigateTo(){
        Driver.getDriver().get(Config.getProperty("trycloudEnv"));
    }


    public void trycloud_login(String username,String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

    public void user_click_loginBtn(){
        loginButton.click();

    }

    public void wrong_msg_is_displayed(String msg){
       Assert.assertTrue(wrongMsg.getText().contains(msg));

    }

    public WebElement findModuleElements(String element){

        String xPath="//ul[@id='appmenu']//a//span[contains(text(),'"+element+"')]";

        return Driver.getDriver().findElement(By.xpath(xPath));
    }



    public void click_on_module_option(String option){
        Actions actionRunner= new Actions(Driver.getDriver());

        actionRunner.moveToElement(findModuleElements(option)).pause(3).click().perform();


    }

    public void user_verify_modules(List<String> modules){

        for (int i=0;i<modules.size();i++){

            Assert.assertTrue(modules.get(i).contains(findModuleElements(modules.get(i)).getText()));

        }


    }














    









}
