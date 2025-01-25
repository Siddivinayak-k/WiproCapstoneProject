package stepdefinitions;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginSteps {
	
	WebDriver driver;
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		driver = new ChromeDriver();
		driver.get("https://westfloridaahec.org/");
		driver.manage().window().maximize();
        driver.findElement(By.linkText("MY ACCOUNT")).click();
	}

	@When("I enter {string} as username and {string} as password")
	public void i_enter_as_username_and_as_password(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

	@Then("I should be successfully logged in")
	public void i_should_be_successfully_logged_in() {
        WebElement signOut = driver.findElement(By.linkText("Sign Out"));
        assertTrue(signOut.isDisplayed(),"did not log in");
	}

	@Then("an error message should be displayed for invalid credentials")
	public void an_error_message_should_be_displayed_for_invalid_credentials() {
		WebElement error = driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div/div"));
        assertTrue(error.isDisplayed());
	}

	@When("I click on the Forgot Password link")
	public void i_click_on_the_forgot_password_link() {
		driver.findElement(By.linkText("Lost your password?")).click();
	}

	@When("I enter {string} as email address")
	public void i_enter_as_email_address(String string) {
		driver.findElement(By.id("user_login")).sendKeys("johndoe@gmail.com");
	}

	@When("I click on the Submit button")
	public void i_click_on_the_submit_button() {
		driver.findElement(By.xpath("//button[@value='Reset password']")).click();
	}

	@Then("a password reset link should be sent to the email")
	public void a_password_reset_link_should_be_sent_to_the_email() {
        WebElement passwordResetText = driver.findElement(By.className("wc-block-components-notice-banner__content"));
        assertTrue(passwordResetText.isDisplayed());
	}
	
	@After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
