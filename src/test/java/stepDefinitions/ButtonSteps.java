package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.ButtonPage;
import org.pages.StudentFormPage;
import org.pages.WebTablesPage;
import org.utils.Utility;

public class ButtonSteps {

    WebDriver driver;
    ButtonPage btnPage;

    @Given("user has the url and browser for Buttons")
    public void userHasTheUrlAndBrowserForButtons() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/buttons.php");
        btnPage = new ButtonPage(driver);
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String btnName) {
        btnPage.clickButton(btnName);
    }

    @Then("message returned as {string}")
    public void messageReturnedAs(String message) {
        btnPage.verifyMessageForClickMe(message);
    }
}
