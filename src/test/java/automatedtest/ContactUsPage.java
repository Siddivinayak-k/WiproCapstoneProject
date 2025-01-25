package automatedtest;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import testbaseclass.BaseClass;

public class ContactUsPage extends BaseClass {
	@Test(priority = 1)
	public void contactUsPageAddress() {
		test = extent.createTest("Verify Address Is Present On Contact Us Page");
		try {
			driver.findElement(By.xpath("//*[@id=\"menu-item-209\"]/a/span")).click();
			WebElement address = driver.findElement(By.xpath("//h3[text()='Address']"));
			String addressText = address.getText();
			assertEquals(addressText, "Address", "Address is not present");
			test.log(Status.PASS, "Verify Address Is Present On Contact Us Page Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Address Is Present On Contact Us Page Failed");
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
				Assert.fail();
			}
		}
	}

	@Test(priority = 2)
	public void contactUsPageCallUs() {
		test = extent.createTest("Verify Call Us Is Present On Contact Us Page");
		try {
			driver.findElement(By.xpath("//*[@id=\"menu-item-209\"]/a/span")).click();
			WebElement callUs = driver.findElement(By.xpath("//h3[text()='Call us']"));
			String callUsText = callUs.getText();
			assertEquals(callUsText, "Call us", "Call us is not present");
			test.log(Status.PASS, "Verify Call Us Is Present On Contact Us Page Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Call Us Is Present On Contact Us Page Passed");
		}
	}

	@Test(priority = 2)
	public void contactUsPageFax() {
		test = extent.createTest("Verify Fax Is Present On Contact Us Page");
		try {
			driver.findElement(By.xpath("//*[@id=\"menu-item-209\"]/a/span")).click();
			WebElement fax = driver.findElement(By.xpath("//h3[text()='Fax']"));
			String faxText = fax.getText();
			assertEquals(faxText, "Fax", "Fax no. is not present");
			test.log(Status.PASS, "Verify Fax Is Present On Contact Us Page Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Fax Is Present On Contact Us Page Failed");
		}
	}

	@Test(priority = 4)
	public void contactUsPageEmailUs() {
		test = extent.createTest("Verify Email Us Is Present On Contact Us Page");
		try {
			driver.findElement(By.xpath("//*[@id=\"menu-item-209\"]/a/span")).click();
			WebElement emailUs = driver.findElement(By.xpath("//h3[text()='Email us']"));
			String emailText = emailUs.getText();
			assertEquals(emailText, "Email us", "Email is not present");
			test.log(Status.PASS, "Verify Email Us Is Present On Contact Us Page Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Email Us Is Present On Contact Us Page Failed");

		}
	}
}
