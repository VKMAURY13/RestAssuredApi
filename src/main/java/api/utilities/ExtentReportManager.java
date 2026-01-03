package api.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	String reportName;
	
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report-"+timeStamp+".html";
		//ITestListener.super.onTestStart(result);
		
		spark = new ExtentSparkReporter("./AdvancedReportTest"+reportName);
		spark.config().setDocumentTitle("RestAssuredAutomationProjects");
		spark.config().setReportName("Fake_Api_User");
		spark.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Application", "User_Faker_Api");
		reports.setSystemInfo("Operating System", System.getProperty("os.name"));
		reports.setSystemInfo("User Name", System.getProperty("User.name"));
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User", "Rahul");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test = reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed;");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = reports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Skipped;");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
	
	
	
	

}
