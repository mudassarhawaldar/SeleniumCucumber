package org.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.utils.Utility;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadDownloadPage {
    public WebDriver driver;
    Actions action;

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    @FindBy(id = "uploadFile")
    WebElement uploadButton;

    public UploadDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        action = new Actions(driver);
    }

    public void downloadFile(String fileName, String sampleFile){
        File file = new File(fileName);
        File[] files = file.listFiles();
        for(File fileInDir : files){
            if(fileInDir.getName().contains(sampleFile)){
                fileInDir.delete();
            }
        }

        Utility.waitForTheElement(driver,downloadButton);
        downloadButton.click();
    }

    public void verifyDownloadedFile(String downloadPath) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        File dir = new File(downloadPath);
        boolean fileExists = false;
        File[] contents = dir.listFiles();
        if(contents != null){
            for (File file : contents){
                if ( file.getName().contains("sampleFile")){
                    fileExists = true;
                }
            }
        }
        if(fileExists){
            System.out.println("Downloaded file exists");
        } else {
            System.out.println("Downloaded file does not exist");
        }
    }

    public void uploadFile() {
        Utility.waitForTheElement(driver,uploadButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",uploadButton);
        //uploadButton.click();
    }

    public void enterPathInTheFileBrowser(String uploadPath) {
        StringSelection selection = new StringSelection(uploadPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
        try {
            Thread.sleep(5000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyUploadedFile() {
        String fileName = uploadButton.getText();
        Assert.assertEquals(fileName, "sampleFile.JPEG");
    }
}
