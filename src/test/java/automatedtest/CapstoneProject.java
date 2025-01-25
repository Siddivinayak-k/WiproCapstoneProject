package automatedtest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utilities.ExtentReportManager;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CapstoneProject {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		ExtentReportManager ex = new ExtentReportManager();
		extent = ex.getReportInstance();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://westfloridaahec.org/");
	}

	@Test(priority = 1)
	public void verifyNavigationMenu() {
		test = extent.createTest("Verify Navigation Menu");
		try {
			assertTrue(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[2]/div/nav[1]"))
					.isDisplayed(), "Navigation Menu is not present");
			test.log(Status.PASS, "Navigation Menu is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Menu test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 2)
	public void verifyNavigationElement_1() {
		test = extent.createTest("Verify Navigation Element - HOME");
		try {
			assertEquals(driver.findElement(By.id("menu-item-207")).getText(), "HOME", "Element is not present");
			test.log(Status.PASS, "Navigation Element - HOME is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - HOME test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 3)
	public void verifyNavigationElement_2() {
		test = extent.createTest("Verify Navigation Element - ABOUT");
		try {
			assertEquals(driver.findElement(By.id("menu-item-616")).getText(), "ABOUT", "Element is not present");
			test.log(Status.PASS, "Navigation Element - ABOUT is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - ABOUT test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 4)
	public void verifyNavigationElement_3() {
		test = extent.createTest("Verify Navigation Element - PROGRAMS");
		try {
			assertEquals(driver.findElement(By.id("menu-item-264")).getText(), "PROGRAMS", "Element is not present");
			test.log(Status.PASS, "Navigation Element - PROGRAMS is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - PROGRAMS test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 5)
	public void verifyNavigationElement_4() {
		test = extent.createTest("Verify Navigation Element - SERVICES");
		try {
			assertEquals(driver.findElement(By.id("menu-item-331")).getText(), "SERVICES", "Element is not present");
			test.log(Status.PASS, "Navigation Element - SERVICES is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - SERVICES test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 6)
	public void verifyNavigationElement_5() {
		test = extent.createTest("Verify Navigation Element - CPR");
		try {
			assertEquals(driver.findElement(By.id("menu-item-467")).getText(), "CPR", "Element is not present");
			test.log(Status.PASS, "Navigation Element - CPR is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - CPR test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 7)
	public void verifyNavigationElement_6() {
		test = extent.createTest("Verify Navigation Element - CONTACT US");
		try {
			assertEquals(driver.findElement(By.id("menu-item-209")).getText(), "CONTACT US", "Element is not present");
			test.log(Status.PASS, "Navigation Element - CONTACT US is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - CONTACT US test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 8)
	public void verifyNavigationElement_7() {
		test = extent.createTest("Verify Navigation Element - MY ACCOUNT");
		try {
			assertEquals(driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]")).getText(), "MY ACCOUNT",
					"Element is not present");
			test.log(Status.PASS, "Navigation Element - MY ACCOUNT is displayed");
		} catch (Exception e) {
			test.log(Status.FAIL, "Navigation Element - MY ACCOUNT test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 9)
	public void searchBarFunctionality() {
		test = extent.createTest("Verify Search Bar Functionality");
		try {
			driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Health programs");
			WebElement searchButton = driver.findElement(By.className("fusion-search-submit"));
			searchButton.click();
			String searchResult = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
			assertEquals(searchResult, "Search results for: Health programs", "Search function is not working");
			test.log(Status.PASS, "Search functionality works as expected");
			driver.navigate().back();
		} catch (Exception e) {
			test.log(Status.FAIL, "Search functionality test failed: " + e.getMessage());
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 10)
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

	@Test(priority = 11)
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

	@Test(priority = 12)
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

	@Test(priority = 13)
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

	@Test(priority = 14)
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
			}
		}
	}

	@Test(priority = 15)
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

	@Test(priority = 16)
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

	@Test(priority = 17)
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

	@Test(priority = 18)
	public void verifyForm() throws InterruptedException {
		try {
			driver.findElement(By.linkText("HOME")).click();
			driver.findElement(By.linkText("HEALTHY AGING PROGRAMS")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement firstName = driver.findElement(By.id("cog-input-auto-0"));
			firstName.sendKeys("John");
			WebElement lastName = driver.findElement(By.id("cog-input-auto-1"));
			lastName.sendKeys("Doe");
			WebElement phoneNumber = driver.findElement(By.id("cog-1"));
			phoneNumber.sendKeys("9876543321");
			WebElement email = driver.findElement(By.id("cog-2"));
			email.sendKeys("johndoe@gmail.com");
			WebElement checkbox1 = driver.findElement(By.xpath(
					"//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[1]/span[1]/span"));
			checkbox1.click();
			WebElement checkbox2 = driver.findElement(By.xpath(
					"//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[2]/span[1]/span"));
			checkbox2.click();
			WebElement country = driver.findElement(By.xpath(
					"//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[2]/div[1]/div[1]/div/label[2]/span[1]/span"));
			country.click();
			WebElement classFormat = driver.findElement((By.xpath(
					"//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[5]/fieldset/div[1]/div[1]/div/label[2]/span[1]/span")));
			classFormat.click();
			WebElement dropDown = driver.findElement(By.id("cog-6"));
			dropDown.click();
			Actions ac = new Actions(driver);
			WebElement select = driver.findElement(By.xpath(
					"//*[@id=\"cog-6-option-An individual looking to take classes wherever they may be available in my county\"]/div/span"));
			ac.moveToElement(select);
			ac.click(select).build().perform();
			driver.findElement(By.id("cog-7")).sendKeys("Internet");
			WebElement checkbox3 = driver.findElement(By.xpath(
					"//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[8]/div/div[1]/label/span[1]/span"));
			checkbox3.click();
			driver.findElement(
					By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[10]/button"))
					.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				String screenshotPath = captureScreenshot(driver);
				test.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException ioException) {
				test.fail("Failed to capture screenshot: " + ioException.getMessage());
			}
		}
	}

	@Test(priority = 19)
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

	@Test(priority = 20)
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

	// Utility method for capturing screenshots
	public static String captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = "target/screenshots/screenshot_" + timestamp + ".png";
		FileHandler.copy(source, new File(filePath));
		return filePath;
	}

	@AfterClass
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
}