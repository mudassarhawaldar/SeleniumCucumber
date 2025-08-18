package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.LinkPage;
import org.utils.Utility;

public class linkSteps {

    WebDriver driver;
    LinkPage linkPage;
    @Given("user has the url and browser for links")
    public void user_has_the_url_and_browser_links() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/links.php");
        linkPage = new LinkPage(driver);
    }

    String parentWindow;

    @When("user clicks on the {string} link")
    public void userClicksOnTheLink(String linkName) {
        parentWindow = driver.getWindowHandle();
        linkPage.clickHomeLink();
    }

    @Then("new windows gets opened")
    public void newWindowsGetsOpened() {
        linkPage.getWindowHandleForOtherWindow(parentWindow);
    }

    @Then("user clicks on {string} menu")
    public void userClicksOnMenu(String menuName) {
        linkPage.clickJavaMenu();
    }

    @And("closes the window")
    public void closesTheWindow() {
        linkPage.closeNewWindow(parentWindow);
    }
}
