package stepdefinitions;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationSteps {
	
	WebDriver driver;
	
	@Given("I am on the Home page")
	public void i_am_on_the_page() {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://westfloridaahec.org/");
	}

	@When("I click on the {string} menu")
	public void i_click_on_the_menu(String string) {
	    driver.findElement(By.linkText(string)).click();
	}

	@Then("I should see a list of health programs")
	public void i_should_see_a_list_of_health_programs() {
		String[] ids = {"menu-item-344","menu-item-280","menu-item-534","menu-item-1572"};
	    List<WebElement> programs = new ArrayList<WebElement>();
	    for(String id : ids) {
	    	programs.add(driver.findElement(By.id(id)));
	    }
	    boolean flag = true;
	    String[] ele = {"Tobacco", "AHEC Scholars","Healthy Aging", "Covering Florida"};
	    for(int i=0; i<programs.size(); i++) {
	    	if(programs.get(i).getText().contentEquals(ele[i])) {
	    		flag = true;
	    	} else {
	    		flag = false;
	    		break;
	    	}
	    }
	    assertTrue(flag, "Mismatch in list of programs");
	    driver.quit();
	}

	@Given("I am on the {string} page")
    public void i_am_on_page(String string) {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://westfloridaahec.org/");
		driver.findElement(By.linkText(string)).click();
    }
	
	@When("I click on the {string} program")
	public void i_click_on_the_program(String string) {
		WebElement target = driver.findElement(By.linkText("PROGRAMS"));
		target.click();
		String[] ids = {"menu-item-344","menu-item-280","menu-item-534","menu-item-1572"};
	    List<WebElement> programs = new ArrayList<WebElement>();
	    for(String id : ids) {
	    	programs.add(driver.findElement(By.id(id)));
	    }
	    WebElement clickElement = null;
        for (WebElement ele : programs) {
            if (ele.getText().contentEquals(string)) {
                clickElement = ele;
                break;
            }
        }
        boolean flag = false;
        // Verify the matching element is found
        if (clickElement != null) {
            // Perform mouse hover and click the matching item
            Actions actions = new Actions(driver);
            actions.moveToElement(target).perform(); // Hover over 'PROGRAMS'
            actions.moveToElement(clickElement).click().perform(); // Click the matching item
            flag = true;
        } 
        assertTrue(flag, "No matching element found for: " + string);
	}

	@Then("I should see the TOBACCO program details")
	public void i_should_see_the_program_details() {
		String healthProgram = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/section/div/div/div/div/h1")).getText();
        boolean result = healthProgram.contentEquals("TOBACCO");
        assertTrue(result);
        driver.quit();
	}
}
