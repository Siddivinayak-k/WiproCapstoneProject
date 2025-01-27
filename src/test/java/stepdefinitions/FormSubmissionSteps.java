package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertTrue;

public class FormSubmissionSteps {
    WebDriver driver;
    @Given("I am on the form page")
    public void i_am_on_the_form_page1() {
    	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://westfloridaahec.org/");
        driver.findElement(By.linkText("HEALTHY AGING PROGRAMS")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("I enter {string} as first name, {string} as last name, {string} as phone number, and {string} as email")
    public void i_enter_as_first_name_as_last_name_as_phone_number_and_as_email(String firstName, String lastName, String phoneNum, String email) {
        driver.findElement(By.id("cog-input-auto-0")).sendKeys(firstName);
        driver.findElement(By.id("cog-input-auto-1")).sendKeys(lastName);
        driver.findElement(By.id("cog-1")).sendKeys(phoneNum);
        driver.findElement(By.id("cog-2")).sendKeys(email);
    }

    @And("I select Tai Chi for Arthritis and Living Healthy \\(Chronic Disease Self-Management) as programs of interest")
    public void i_select_and_as_programs_of_interest() {
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[1]/span[1]/span"));
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[2]/span[1]/span"));
        checkbox2.click();
    }

    @And("I select Santa Rosa as my county")
    public void i_select_as_my_county() {
        WebElement country = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[2]/div[1]/div[1]/div/label[2]/span[1]/span"));
        country.click();
    }

    @And("I select Virtual as my preferred class format")
    public void i_select_as_my_preferred_class_format() {
        WebElement classFormat = driver.findElement((By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[5]/fieldset/div[1]/div[1]/div/label[2]/span[1]/span")));
        classFormat.click();
    }

    @And("I select I am best described as: option")
    public void i_select_option() {
        WebElement dropDown = driver.findElement(By.id("cog-6"));
        dropDown.click();
        Actions ac = new Actions(driver);
        WebElement select = driver.findElement(By.xpath("//*[@id=\"cog-6-option-An individual looking to take classes wherever they may be available in my county\"]/div/span"));
        ac.moveToElement(select);
        ac.click(select).build().perform();
    }

    @And("I enter {string} in Please help us by telling us how/where you heard about us:")
    public void i_enter_text(String string){
        driver.findElement(By.id("cog-7")).sendKeys(string);
    }

    @And("I select the checkbox I am best described as: option")
    public void i_select_the_checkbox() {
        WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[8]/div/div[1]/label/span[1]/span"));
        checkbox3.click();
    }

    @When("I select the checkbox I would like to be notified by email when classes are available in my area")
    public void i_select_the_checkbox_i_would_like_to_be_notified_by_email_when_classes_are_available_in_my_area() {
        driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[8]/div/div[1]/label/span[1]")).click();
    }
    
    @And("I click on the submit button")
    public void i_click_on_the_button() {
    	WebElement element = driver.findElement(By.id("cog-6"));

        // Scroll to the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath("//span[@class='cog-button__text']")).click();
    }

    @Then("the form should be submitted successfully message should be displayed")
    public void the_form_should_be_submitted_successfully() {
        assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
        driver.quit();
    }
    
    @When("I leave the NAME field empty")
    public void i_leave_the_name_field_empty() {
        
    }

    @When("I leave PHONE field empty")
    public void i_leave_phone_field_empty() {
        
    }

    @When("I leave EMAIL field empty")
    public void i_leave_email_field_empty() {
        
    }

    @Then("an error message should be displayed for the missing fields")
    public void an_error_message_should_be_displayed_for_the_missing_fields() {
    	assertTrue(driver.findElement(By.xpath("//div[text()='First and Last are required.']")).isDisplayed(), "First and Last are required not displayed");
        assertTrue(driver.findElement(By.xpath("//div[text()='Phone is required.']")).isDisplayed(), "Phone is required not displayed");
        assertTrue(driver.findElement(By.xpath("//div[text()='Email is required.']")).isDisplayed(), "Email is required not displayed");
        driver.quit();
    }
}
