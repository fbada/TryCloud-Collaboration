package com.trycloud.pages;


import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FileAccessPage {

    public FileAccessPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='uploadprogressbar']")
    public WebElement uploadBar;

    @FindBy(xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']/span")
    public WebElement notEnoughSpaceBtn;

    @FindBy(xpath = "//span[.='Delete file']/..")
    public WebElement deleteDropdown;

    @FindBy(xpath = "//th[@class='column-name']//span[.='Actions']")
    public WebElement actionsInHeader;

    @FindBy(xpath = "//aside//a[@class='action more icon icon-more has-tooltip']")
    public WebElement moreAsideAction;

    @FindBy(xpath = "//aside//span[@class='icon icon-delete']")
    public WebElement deleteCommentIcon;

    @FindBy(xpath = "//a[@class='menuitem action action-details permanent']")
    public WebElement detailsOption;

    @FindBy(xpath = "//button[@class='settings-button']")
    public WebElement settingsButton;

    @FindBy(xpath = "//aside//div[@data-placeholder='New comment …']")
    public WebElement commentField;

    @FindBy(xpath = "//aside//span[@class='app-sidebar-tabs__tab-icon icon-comment']/..")
    public WebElement commentIcon;

    @FindBy(xpath = "//label[@for='recommendationsEnabledToggle']")
    public WebElement reccomendationsToggle;

    @FindBy(xpath = "//a[@class='nav-icon-trashbin svg']")
    public WebElement detetedFiles;

    @FindBy(xpath = "//div[@id='app-settings-content']//label[contains(.,'Show')]")
    public List<WebElement> settingsCheckboxes;

    @FindBy(xpath = "//a/p")
    public WebElement storageAmount;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addButton;

    @FindBy (xpath = "//input[@id='file_upload_start']")
    public WebElement uploadStart;

    @FindBy(xpath = "//div[@id='uploadprogressbar']")
    public WebElement progressBar;

    @FindBy(xpath = "(//tbody//span[@class='icon icon-more'])")
    public List<WebElement> listActions;

    @FindBy(xpath = "(//td//span[@class='innernametext'])")
    public List<WebElement> files;

    @FindBy(xpath = "//span[.='New folder']/..")
    public WebElement newFolder;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderTextBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement newFolderSubmit;

    //td//span[.='Poppy']/following-sibling::span[2]/a[2]/span[1]
    @FindBy(xpath = "//tbody//td//div[contains(@style,'folder')]")
    public List<WebElement> folderFiles;

    public void actionButtonLastFile() {
        String xpath = "(//tbody//span[@class='icon icon-more'])[" + listActions.size() + "]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
        BrowserUtils.waitFor(2);
        DeleteOption.click();
        BrowserUtils.waitFor(2);

    }

    public WebElement getfileUploadedAction(String name) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + name + "' and @class='innernametext']/../..//a[@class='action action-menu permanent']"));
    }

    public void actionButtonLastFileFav(int index) {

        String xpath = "(//tbody//span[@class='icon icon-more'])[" + index + "]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
        BrowserUtils.waitFor(2);
    }

    public String nameOfFileSelected() {
        return Driver.getDriver().findElement(By.
                xpath("(//td//span[@class='innernametext'])[" + listActions.size() + "]")).getText();
    }


    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> listInFavorites;


    public String nameOfFirstFileSelected() {
        return Driver.getDriver().findElement(By.
                xpath("(//td//span[@class='innernametext'])[1]")).getText();
    }


    public void dropDownOptions(String str) {
        Driver.getDriver().findElement(By.xpath("//div[@id='rightClickMenu']//span[.='" + str + "']/..")).click();

    }


    @FindBy(xpath = "td[@class='selection']/label")
    public List<WebElement> allFiles;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAll;

    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']/..")
    public WebElement favoriteSideModule;

    @FindBy(xpath = "(//a/span[@class='icon icon-delete'])[2]")
    public WebElement DeleteOption;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement addfavoriteOption;


    public void dropDownOpt(String str) {
        Driver.getDriver().findElement(By.xpath("//span[.='" + str + "']/..")).click();
    }

    public WebElement subModule(String string) {

        return Driver.getDriver().findElement(By.xpath("//li/a[.='" + string + "']"));
    }

    public void goToSubModule(String subModule) {
        Driver.getDriver().findElement(By.xpath("//a[.='" + subModule + "']")).click();
    }

    public void sideModule(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String sf = "//li[starts-with(@class,'nav')]/a[text()='" + moduleName + "']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(sf))).click().perform();
    }

    public void deleteUploadedFile(String fileName) {
        Actions action = new Actions(Driver.getDriver());
        BrowserUtils.scrollToElement(getfileUploadedAction(fileName));
        BrowserUtils.waitFor(1);
        BrowserUtils.highlight(getfileUploadedAction(fileName));
        BrowserUtils.clickWithJS(getfileUploadedAction(fileName));
        BrowserUtils.waitFor(1);
        BrowserUtils.highlight(deleteDropdown);
        BrowserUtils.clickWithJS(deleteDropdown);
        BrowserUtils.waitFor(1);
    }

    public boolean findFile(String filename){
        return Driver.getDriver().findElement(By.xpath("//span[.='"+filename+"']")).isDisplayed();
    }

}



