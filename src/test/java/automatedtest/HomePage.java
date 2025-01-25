package automatedtest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testbaseclass.BaseClass;

public class HomePage extends BaseClass {
	
	@Test(priority = 1)
    public void searchBarFunctionality() {
        test = extent.createTest("Verify Search Bar Functionality");
        try {
            driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Health programs");
            WebElement searchButton = driver.findElement(By.className("fusion-search-submit"));
            searchButton.click();
            String searchResult = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
            assertEquals(searchResult, "Search results for: Health programs", "Search function is not working");
            test.log(Status.PASS, "Search functionality works as expected");
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
	
	@Test(priority = 2)
    public void verifyNavigationMenu() {
        test = extent.createTest("Verify Navigation Menu");
        try {
            assertTrue(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[3]/div[2]/div/nav[1]")).isDisplayed(), "Navigation Menu is not present");
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
	@Test(priority = 3)
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

    @Test(priority = 4)
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

    @Test(priority = 5)
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

    @Test(priority = 6)
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

    @Test(priority = 7)
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

    @Test(priority = 8)
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

    @Test(priority = 9)
    public void verifyNavigationElement_7() {
        test = extent.createTest("Verify Navigation Element - MY ACCOUNT");
        try {
            assertEquals(driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]")).getText(), "MY ACCOUNT", "Element is not present");
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

    
}
