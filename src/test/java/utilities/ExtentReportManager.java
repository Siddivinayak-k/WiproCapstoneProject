package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	ExtentSparkReporter sparkReporter;
	String reportName;

	public ExtentReports getReportInstance() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "ExtentReport-Automation" + timeStamp + "html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("Selenium Automation");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Siddivinayak");

		return extent;
	}

	public ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public ExtentTest getTest() {
		return test;
	}
}
