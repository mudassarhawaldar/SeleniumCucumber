package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {

    public static WebDriver driver;

    public static WebDriver initBrowserAndEnterUrl(String browserName, String url){
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.get(url);
            /*int browserWidth = driver.manage().window().getPosition().getX();
            System.out.println(browserWidth);
            int browserHeight = driver.manage().window().getPosition().getY();
            System.out.println(browserHeight);*/
            driver.manage().window().maximize();
            /*browserWidth = driver.manage().window().getPosition().getX();
            System.out.println(browserWidth);
            browserHeight = driver.manage().window().getPosition().getY();
            System.out.println(browserHeight);*/
        } else if (browserName.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            driver.get(url);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void waitForTheElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
