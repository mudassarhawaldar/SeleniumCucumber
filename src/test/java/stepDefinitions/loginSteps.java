package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import org.pages.StudentFormPage;
import org.utils.Utility;

import java.awt.*;


public class loginSteps {

    WebDriver driver;
    StudentFormPage std;
    @Given("user has the url and browser")
    public void user_has_the_url_and_browser() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        std = new StudentFormPage(driver);
    }
    @When("user enters username {string}")
    public void user_enters_username(String stdName) {
        std.enterUserName(stdName);
    }
    @When("email as {string}")
    public void email_as(String emailId) {
        std.enterEmailID(emailId);
    }
    @When("selects gender as {string}")
    public void selects_gender_as(String gender) {
        std.selectGender(gender);
    }
    @When("enters mobile number as {string}")
    public void enters_mobile_number_as(String mobileNumber) {
        std.enterMobileNumber(mobileNumber);
    }
    @When("enters Date of Birth as {string}")
    public void enters_date_of_birth(String dob) {
        std.enterBirthDate(dob);
    }
    @When("enters subjects")
    public void enters_subjects() {
        std.enterSubject("Maths");
    }
    @When("checks hobbies as {string} and {string}")
    public void checks_hobbies_as_and(String hobby1, String hobby2) {
        std.selectHobbies(hobby1);
    }
    @When("selects picture from {string}")
    public void selects_picture_from(String filePath) throws AWTException {
        std.selectPicture(filePath);
    }
    @When("selects state and city as {string} and {string}")
    public void selects_state_and_city_as_and(String state, String city) {
        std.selectStateCity(state,city);
    }
    @When("clicks on login button")
    public void clicks_on_login_button() {
        std.login();
    }

    @And("enters address")
    public void entersAddress() {
        std.enterAddress("Pune");
    }
    /*@Then("Registration is successful")
    public void registration_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

}
