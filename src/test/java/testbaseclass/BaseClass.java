package testbaseclass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.ExtentReportManager;

public class BaseClass {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public WebDriverWait wait;

	// Utility method for capturing screenshots
	public static String captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = "target/screenshots/screenshot_" + timestamp + ".png";
		FileHandler.copy(source, new File(filePath));
		return filePath;
	}

	@Parameters("browser") // Use @Parameters to allow browser selection
	@BeforeClass
	public void setUp(String browser) {
		ExtentReportManager ex = new ExtentReportManager();
		extent = ex.getReportInstance();

		// Browser setup based on the parameter
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
		}
		driver.get("https://westfloridaahec.org/");
		driver.manage().window().maximize();
		test = extent.createTest("Test on " + browser);
	}

//    @BeforeMethod
//    public void startTest(Method method) {
//        test = ExtentReportManager.createTest(method.getName());
//    }

	@AfterClass
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
}
