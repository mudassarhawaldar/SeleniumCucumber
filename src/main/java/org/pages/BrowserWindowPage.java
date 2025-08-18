package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowPage {
    public WebDriver driver;
    Actions action;

    @FindBy(xpath = "//button[@title='New Tab']")
    WebElement newTab;

    @FindBy(xpath = "//button[text()='New Window']")
    WebElement newWindow;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void clickOnNewTab() {
        Utility.waitForTheElement(driver,newTab);
        newTab.click();
    }
}
