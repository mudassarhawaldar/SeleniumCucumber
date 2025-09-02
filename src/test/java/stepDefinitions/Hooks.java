package org.hooks;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class hooks {

    private WebDriver driver;

    public hooks(WebDriver driver){
        this.driver = driver;
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

}
