package automatedtest;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import testbaseclass.BaseClass;

public class UserAccountManagement extends BaseClass {

	@Test(priority = 1)
	public void userLogin() {
		test = extent.createTest("User Login Test");
		try {
			driver.findElement(By.linkText("MY ACCOUNT")).click();
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("john123");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("johndoe@#136");
			WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
			loginButton.click();
			WebElement result = driver.findElement(By.linkText("Sign Out"));
			assertTrue(result.isDisplayed(), "Login failed");
			test.log(Status.PASS, "User login functionality works as expected");
			result.click();
			driver.findElement(By.linkText("Confirm and log out")).click();
		} catch (Exception e) {
			test.log(Status.FAIL, "User login functionality test Failed: " + e.getMessage());
			Assert.fail();
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());

			}
		}
	}

	@Test(priority = 2)
	public void passwordRecovery() throws InterruptedException {
		test = extent.createTest("Password Recovery Test");
		try {
//			driver.findElement(By.linkText("MY ACCOUNT")).click();
			driver.findElement(By.linkText("Lost your password?")).click();
			driver.findElement(By.id("user_login")).sendKeys("johndoe@gmail.com");
			driver.findElement(By.xpath("//button[@value='Reset password']")).click();
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wc-block-components-notice-banner__content")));
			WebElement passwordReset = driver.findElement(By.className("wc-block-components-notice-banner__content"));
			assertTrue(passwordReset.isDisplayed(), "Password reset verification failed");
			test.log(Status.PASS, "Password Recovery functionality works as expected");

		} catch (Exception e) {
			test.log(Status.FAIL, "Password Recovery test Failed");
			Assert.fail();
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}
}
