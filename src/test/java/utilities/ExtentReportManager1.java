package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager1 implements ITestListener{
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // Common info of the report
	public ExtentTest test; // creating test entries in the report and update status of the test method
	
	public void onTestStart(ITestResult result) {
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/CapstoneProject.html"); 
	    sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report
	    sparkReporter.config().setReportName("Capstone Report"); // Name of the report
	    sparkReporter.config().setTheme(Theme.DARK); // theme of the report
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    extent.setSystemInfo("Computer Name", "localhost");
	    extent.setSystemInfo("Tester", "Siddivinayak");
	    extent.setSystemInfo("os", "Windows");
	}
	
	public void onTestSuccess(ITestResult result) {
	    test = extent.createTest(result.getName()); // create a new entry in the report
	    test.log(Status.PASS, "Test case PASSED is:"+result.getName()); //update status
	}
	public void onTestFailure(ITestResult result) {
	    test = extent.createTest(result.getName());
	    test.log(Status.FAIL, "Test case FAILED is:"+result.getName());
	    test.log(Status.FAIL, "Test case FAILED cause is:"+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
	    test.log(Status.SKIP, "Test case SKKIPED is:"+result.getName());
	}
	public void onFinish(ITestContext context) {
	    extent.flush();
	}
	
}

