package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.BrokenLinkPage;
import org.pages.LinkPage;
import org.utils.Utility;

import java.io.IOException;
import java.util.ArrayList;

public class BrokenLinkSteps {

    WebDriver driver;
    BrokenLinkPage brokenLinkPage;
    @Given("user has the url and browser for BrokenLinks")
    public void user_has_the_url_and_browser_links() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/broken-links.php");
        brokenLinkPage = new BrokenLinkPage(driver);
    }

    @When("user finds the broken link")
    public void userFindsTheBrokenLink() throws IOException {
        ArrayList<String> brokenLink = brokenLinkPage.getListOfBrokenLink();
        brokenLinkPage.clickBrokenLink();
    }

    @Then("user closed the window")
    public void userClosedTheWindow() {
        driver.close();
    }
}
