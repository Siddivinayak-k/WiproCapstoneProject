package automatedtest;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import testbaseclass.BaseClass;

public class HealthProgramsAndServices extends BaseClass {

	@Test(priority = 1)
	public void verifyHealthProgram_1() {
		test = extent.createTest("Verify Health Program(Tobacco) Content");
		try {
			WebElement target = driver.findElement(By.xpath("//span[text()='PROGRAMS']"));
			Actions ac = new Actions(driver);
			ac.moveToElement(target);
			WebElement healthProgram1 = driver.findElement(By.id("menu-item-344"));
			ac.click(healthProgram1);
			ac.build().perform();
			String healthProgram1Title = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
			assertEquals(healthProgram1Title, "TOBACCO", "Content mismatch");
			test.log(Status.PASS, "Verify Health Program(Tobacco) Content Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Health Program(Tobacco) Content " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 2)
	public void verifyHealthProgram_2() {
		test = extent.createTest("Verify Health Program(AHEC SCHOLARS) Content");
		try {
			WebElement target = driver.findElement(By.xpath("//span[text()='PROGRAMS']"));
			Actions ac = new Actions(driver);
			ac.moveToElement(target);
			WebElement healthProgram2 = driver.findElement(By.id("menu-item-280"));
			ac.click(healthProgram2);
			ac.build().perform();
			String healthProgram2Title = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
			assertEquals(healthProgram2Title, "AHEC SCHOLARS", "Content mismatch");
			test.log(Status.PASS, "Verify Health Program(AHEC SCHOLARS) Content Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Health Program(AHEC SCHOLARS) Content Failed");
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 3)
	public void verifyHealthProgram_3() {
		test = extent.createTest("Verify Health Program(HEALTHY AGING) Content");
		try {
			WebElement target = driver.findElement(By.xpath("//span[text()='PROGRAMS']"));
			Actions ac = new Actions(driver);
			ac.moveToElement(target);
			WebElement healthProgram3 = driver.findElement(By.id("menu-item-534"));
			ac.click(healthProgram3);
			ac.build().perform();
			String healthProgram3Title = driver.findElement(By.className("entry-title")).getText();
			assertEquals(healthProgram3Title, "HEALTHY AGING", "Content mismatch");
			test.log(Status.PASS, "Verify Health Program(HEALTHY AGING) Content Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Health Program(HEALTHY AGING) Content Failed");
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 4)
	public void verifyHealthProgram_4() {
		test = extent.createTest("Verify Health Program(EDUCATING TOWARDS A HEALTHIER COMMUNITY) Content");
		try {
			WebElement target = driver.findElement(By.xpath("//span[text()='PROGRAMS']"));
			Actions ac = new Actions(driver);
			ac.moveToElement(target);
			WebElement healthProgram4 = driver.findElement(By.id("menu-item-1572"));
			ac.click(healthProgram4);
			ac.build().perform();
			String healthProgram4Title = driver
					.findElement(By.xpath("//h2[@class='fusion-title-heading title-heading-center']")).getText();
			assertEquals(healthProgram4Title, "EDUCATING TOWARDS A HEALTHIER COMMUNITY", "Content mismatch");
			test.log(Status.PASS, "Verify Health Program(EDUCATING TOWARDS A HEALTHIER COMMUNITY) Content Passed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Verify Health Program(EDUCATING TOWARDS A HEALTHIER COMMUNITY) Content Failed");
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}
}
