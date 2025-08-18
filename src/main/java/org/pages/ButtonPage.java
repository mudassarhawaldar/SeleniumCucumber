package org.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Utility;

import java.util.List;

public class ButtonPage {
    public WebDriver driver;
    Actions action;

    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement clickMe;

    @FindBy(xpath = "//button[text()='Double Click Me']")
    WebElement doubleClickMe;

    @FindBy(xpath = "//button[text()='Right Click Me']")
    WebElement rightClickMe;

    @FindBy(id = "welcomeDiv")
    WebElement messageClickMe;

    @FindBy(id = "doublec")
    WebElement messageDoubleClickMe;

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void clickButton(String btnName){
        if(btnName.contains("Right Click")){
            Utility.waitForTheElement(driver,rightClickMe);
            action.contextClick(rightClickMe);
        } else if(btnName.contains("Double Click")){
            Utility.waitForTheElement(driver,doubleClickMe);
            action.doubleClick(doubleClickMe).perform();
        } else {
            Utility.waitForTheElement(driver,clickMe);
            //clickMe.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red'", clickMe);
            js.executeScript("arguments[0].click();",clickMe);
            js.executeScript("document.getElementById('welcomeDiv').click()");
            js.executeScript("arguments[0].style.border=''", clickMe);
        }
    }

    public void verifyMessageForClickMe(String expectedMessage){
        String actualMessage = null;
        if(expectedMessage.contains("Double")){
            Utility.waitForTheElement(driver,messageDoubleClickMe);
            actualMessage = messageDoubleClickMe.getText();
        } else {
            Utility.waitForTheElement(driver,messageClickMe);
            actualMessage = messageClickMe.getText();
        }

        if(actualMessage.equals(expectedMessage)){
            System.out.println("Messages are matched");
        } else {
            System.out.println("Messages does not match");
        }
    }
}
