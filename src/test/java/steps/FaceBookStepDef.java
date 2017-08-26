package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeNotNull;

/**
 * Created by daljit-pc on 26-Aug-17.
 */
public class FaceBookStepDef {
    private WebDriver webDriver;
    @Before
    public void intialize(){
        webDriver= new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.close();
    }

    @Given("^Chrome is installed$")
    public void chrome_is_installed() throws Throwable {
        assumeNotNull(webDriver);
    }

    @When("^User opens url \"([^\"]*)\"$")
    public void user_opens_url(String arg1) throws Throwable {
        webDriver.get(arg1);
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_username_as_and_password_as(String arg1, String arg2) throws Throwable {
        webDriver.findElement(By.id("email")).sendKeys(arg1);
        webDriver.findElement(By.id("pass")).sendKeys(arg2);

    }

    @When("^User click login button$")
    public void user_click_login_button() throws Throwable {
        webDriver.findElement(By.xpath("//*[@value='Log In']")).click();
    }

    @Then("^User should get incorrect username/password error message$")
    public void user_should_get_incorrect_username_password_error_message() throws Throwable {
            //if no home screen thyem user fails
       try {
           webDriver.findElement ( By.partialLinkText ( "home" ) );
           assumeFalse(true);
       }catch (NoSuchElementException e){
           // Take screenshot and store as a file format
           captureScreenShot(webDriver);
           assumeFalse(false);
       }

    }

    public static void captureScreenShot(WebDriver webDriver) throws IOException {
        File src= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        // now copy the  screenshot to desired location using copyFile //method
        FileUtils.copyFile(src, new File("src//test//evidence//error_"+getFileName()+".png"));
    }

    public static String getFileName(){
        return String.valueOf(Timestamp.from(Instant.now()).getTime());

    }

}
