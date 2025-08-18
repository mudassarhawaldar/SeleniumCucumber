package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.BrokenLinkPage;
import org.pages.BrowserWindowPage;
import org.utils.Utility;

import java.io.IOException;
import java.util.ArrayList;

public class BrowserWindowSteps {

    WebDriver driver;
    BrowserWindowPage browserWindowPage;
    @Given("user has the url and browser for BrokenLinks")
    public void user_has_the_url_and_browser_links() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/broken-links.php");
        browserWindowPage = new BrowserWindowPage(driver);
    }

    @When("user clicks on new tab")
    public void userClicksOnNewTab() {
        browserWindowPage.clickOnNewTab();
    }
    public String parentWindow = null;
    @Then("new tab gets open")
    public void newTabGetsOpen() {
        parentWindow = driver.getWindowHandle();
        
    }
}
