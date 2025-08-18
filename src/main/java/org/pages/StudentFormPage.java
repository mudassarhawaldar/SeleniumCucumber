package org.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.utils.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StudentFormPage {
    public WebDriver driver;
    Actions action;

    @FindBy(id = "name")
    WebElement firstName;

    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(id = "gender")
    WebElement genderMale;

    @FindBy(id = "mobile")
    WebElement mobileNumber;

    @FindBy(id = "dob")
    WebElement dobPicker;

    @FindBy(id = "subjects")
    WebElement subjects;

    @FindBy(id = "hobbies")
    WebElement hobbies;

    @FindBy(xpath = "//input[@id='picture']")
    WebElement picture;

    @FindBy(xpath = "//textarea[@id='picture']")
    WebElement pictureText;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement login;

    public StudentFormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void enterUserName(String userName){
        Utility.waitForTheElement(driver,firstName);
        firstName.sendKeys(userName);
    }

    public void enterEmailID(String emailID){
        Utility.waitForTheElement(driver,emailId);
        emailId.sendKeys(emailID);
    }

    public void selectGender(String gender){
        Utility.waitForTheElement(driver,genderMale);
        if(!genderMale.isSelected())
            genderMale.click();
    }

    public void enterMobileNumber(String inputNumber){
        Utility.waitForTheElement(driver,mobileNumber);
        mobileNumber.sendKeys(inputNumber);
    }

    public void enterBirthDate(String birthDate){
        Utility.waitForTheElement(driver,dobPicker);
        dobPicker.sendKeys(birthDate);
    }

    public void enterSubject(String inputSubject){
        Utility.waitForTheElement(driver,subjects);
        subjects.sendKeys(inputSubject);
    }

    public void selectHobbies(String hobby){
        Utility.waitForTheElement(driver,hobbies);
        //hobbies.click();
        action.click(hobbies).perform();
    }

    public void selectPicture(String path) throws AWTException {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Utility.waitForTheElement(driver,picture);
        //picture.sendKeys(path);

        /*Robot robot = new Robot();
        StringSelection filePath = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);*/
    }

    public void enterAddress(String address){
        Utility.waitForTheElement(driver,pictureText);
        //pictureText.sendKeys(address);
        action.sendKeys(pictureText,address).perform();
        action.doubleClick(pictureText).perform();
    }

    public void selectStateCity(String inputState, String inputCity){
        Select s = new Select(state);
        ArrayList<WebElement> options = (ArrayList<WebElement>) s.getOptions();
        boolean multiple = s.isMultiple();
        s.selectByVisibleText(inputState);
        String selectedText = s.getFirstSelectedOption().getText();
        List<WebElement> allOption = s.getAllSelectedOptions();
        System.out.println(selectedText);
        s = new Select(city);
        s.selectByVisibleText(inputCity);
    }

    public void login(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",login);
        login.click();
    }
}
