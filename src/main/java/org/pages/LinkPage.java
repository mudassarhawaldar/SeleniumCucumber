package org.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LinkPage {
    public WebDriver driver;
    Actions action;

    @FindBy(xpath = "//a[text()='Home']")
    WebElement homeLink;

    @FindBy(xpath = "//ul[@id='library-nav']//a[text()='Java']")
    WebElement javaLink;

    public LinkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void clickHomeLink(){
        Utility.waitForTheElement(driver,homeLink);
        homeLink.click();
    }

    public void getWindowHandleForOtherWindow(String parentWindow){
        Set<String> handles = driver.getWindowHandles();
        ArrayList<String> windowHandles = new ArrayList<>(handles);
        for (String winHandle : windowHandles){
            if(!(winHandle.equals(parentWindow))){
                driver.switchTo().window(winHandle);
            }
        }
    }

    public void clickJavaMenu(){
        Utility.waitForTheElement(driver,javaLink);
        javaLink.click();
    }

    public void closeNewWindow(String parentWindow){
        driver.close();
        driver.switchTo().window(parentWindow);
        clickHomeLink();
    }
}
