package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.pages.BrokenLinkPage;
import org.pages.UploadDownloadPage;
import org.utils.Utility;

public class UploadDownloadSteps {

    WebDriver driver;
    UploadDownloadPage uploadDownloadPage;
    @Given("user has the url and browser for UploadDownload")
    public void user_has_the_url_and_browser_links() {
        driver = Utility.initBrowserAndEnterUrl("chrome", "https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        uploadDownloadPage = new UploadDownloadPage(driver);
    }

    @When("user click on download button")
    public void userClickOnDownloadButton() {
        uploadDownloadPage.downloadFile("C:\\Users\\mudas\\Downloads\\","sampleFile");
    }

    @Then("file gets downloaded in download directory")
    public void fileGetsDownloadedInDownloadDirectory() {
        String downloadPath = "C:\\Users\\mudas\\Downloads";
        uploadDownloadPage.verifyDownloadedFile(downloadPath);
    }

    @When("user click on choose file button")
    public void userClickOnChooseFileButton() {
        uploadDownloadPage.uploadFile();
    }

    @And("provides the path")
    public void providesThePath() {
        uploadDownloadPage.enterPathInTheFileBrowser("C:\\Users\\mudas\\Downloads\\sampleFile.JPEG");
    }

    @Then("file gets uploaded")
    public void fileGetsUploaded() {
        uploadDownloadPage.verifyUploadedFile();
    }
}
