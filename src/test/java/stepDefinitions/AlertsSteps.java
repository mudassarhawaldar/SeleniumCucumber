package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.BrowserWindowPage;
import org.utils.Utility;

public class BrowserWindowSteps {

    WebDriver driver;
    BrowserWindowPage browserWindowPage;
    @Given("user has the url and browser for BrowserWindow")
    public void user_has_the_url_and_browser_links() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        browserWindowPage = new BrowserWindowPage(driver);
    }

    public String parentWindow = null;

    @When("user clicks on new tab")
    public void userClicksOnNewTab() {
        parentWindow = driver.getWindowHandle();
        browserWindowPage.clickOnNewTab();
    }

    @Then("new tab gets open")
    public void newTabGetsOpen() {
        browserWindowPage.verifyNewTab(parentWindow);
        driver.close();
    }

    @When("user clicks on new window")
    public void userClicksOnNewWindow() {
        parentWindow = driver.getWindowHandle();
        browserWindowPage.clickOnNewWindow();
    }

    @Then("new window gets open")
    public void newWindowGetsOpen() {
        browserWindowPage.verifyNewWindow(parentWindow);
    }
}
