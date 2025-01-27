package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	features = "src/test/resources/features",
	glue = "stepdefinitions",
	plugin = {"pretty", "html:test-output/cucumber-reports.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}