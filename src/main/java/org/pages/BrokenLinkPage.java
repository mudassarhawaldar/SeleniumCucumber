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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrokenLinkPage {
    public WebDriver driver;
    Actions action;

    @FindBy(xpath = "//a[@href='broken-link.php']")
    WebElement brokenLink;

    @FindBy(xpath = "//div[contains(@class,'container') and contains(@class,'bg-white') and contains(@class,'text-center')]")
    WebElement brokenLinkPage;



    public BrokenLinkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public ArrayList<String> getListOfBrokenLink() throws IOException {
        List<WebElement> hrefLink = driver.findElements(By.xpath("//*[@class='col-md-8 col-lg-8 col-xl-8']//a"));
        ArrayList<String> brokenLinks = new ArrayList<>();
        for (WebElement href : hrefLink){
            String url = href.getAttribute("href");
            if(!url.contains("javascript")){
                HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                httpURLConnection.connect();

                int responseCode = httpURLConnection.getResponseCode();
                if(responseCode != 200){
                    brokenLinks.add(url);
                }
                httpURLConnection.disconnect();
            }
        }
        return brokenLinks;
    }

    public void clickBrokenLink() {
        Utility.waitForTheElement(driver,brokenLink);
        brokenLink.click();
        String brokenLinkDetails = brokenLinkPage.getText();
        System.out.println(brokenLinkDetails);
    }

}
