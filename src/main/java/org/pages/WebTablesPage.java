package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.utils.Utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WebTablesPage {
    public WebDriver driver;
    Actions action;

    @FindBy(xpath = "//table[contains(@class,'table') and contains(@class,'table-striped') and contains(@class,'mt-3')]")
    WebElement table;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public int getFirstNameHeaderNumber(String firstName) {
        List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));
        System.out.println("Size of header: " + headers.size());

        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
        System.out.println("Size of rows: " + rows.size());

        int countHeader = 1;
        int countRow = 1;

        for (WebElement header : headers) {
            String headerName = header.getText().trim();
            if (headerName.equals("First Name")) {
                break;
            } else {
                countHeader = countHeader + 1;
            }
        }

        for (int i = 1; i <= rows.size(); i++) {
            String firstNameValue = table
                    .findElement(By.xpath("//tbody/tr[" + i + "]/td[" + countHeader + "]"))
                    .getText();

            if (firstNameValue.equals(firstName)) {
                break;
            } else {
                countRow = countRow + 1;
            }
        }

        return countRow;
    }

    public void getEmailID(int countRow){
        List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));
        System.out.println("Size of header: " + headers.size());
        List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
        System.out.println("Size of rows: " + rows.size());

        int countEmail = 1;

        for (WebElement header : headers) {
            String headerName = header.getText().trim();
            if (headerName.equals("Email")) {
                break;
            } else {
                countEmail = countEmail + 1;
            }
        }

        String emailID = table
                .findElement(By.xpath("//tbody/tr[" + countRow + "]/td[" + countEmail + "]"))
                .getText();

        System.out.println("EmailID: " + emailID);
    }
}
