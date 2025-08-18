package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.WebTablesPage;
import org.utils.Utility;

public class WebTablesSteps {

    WebDriver driver;
    WebTablesPage wt;

    @Given("user has the url and browser for WebTables")
    public void user_has_the_url_and_browser() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/webtables.php");
        wt = new WebTablesPage(driver);
    }

    int rowNumber = 0;
    @When("the first name is provided as {string}")
    public void theFirstNameIsProvidedAs(String firstName) {
        rowNumber = wt.getFirstNameHeaderNumber(firstName);
    }

    @Then("code returns the emailID")
    public void codeReturnsTheEmailID() {
        wt.getEmailID(rowNumber);
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String arg0) {

    }
}
