
package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtilities implements ITestListener{

	//reference variables craeted for below 3 as global
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;
//java clas
	public void configureReport() {
//to get system date & time in variable timeStamp
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date time capture using java
//to craete a folder if ExtentReport enna folder is not present
	File reportPath=new File(System.getProperty("user.dir")+"//ExtentReport");

	if(!reportPath.exists()) {
	reportPath.mkdir(); //create folder using java for storing extent Report
	}

	//create file
	//ExtentSparkReporter sparkReporter;on line 21--here object created ,so that their methods can be used
	//ExtentReports reports;
	//ExtentTest test;
	//create an empty html file 
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReport//"+"ExtentReport_" + timeStamp + ".html");
	reports = new ExtentReports();
	//to attach with their projectreport>extentreport>htmlfile 
	reports.attachReporter(sparkReporter);

	//System details
	//adding report basic details like PC, report name
	reports.setSystemInfo("PC Name", "ALViNs");
	reports.setSystemInfo("OS", "Windows 10");
	sparkReporter.config().setDocumentTitle("Extent Report Sample");
	sparkReporter.config().setReportName("Report Summary");
	sparkReporter.config().setTheme(Theme.DARK);
	}
	
	//from now Listener 
	//interface-abstract methods, no body, body is created at class where its implemented

	public void onTestStart(ITestResult result) {

	}

//if a TC passed,as listener monitors, if success, control goes to OnTestSuccesee
	public void onTestSuccess(ITestResult result) {
	test = reports.createTest(result.getName());
	//label created, TC name in green
	//result.getName()--gets name of the just run TC
	test.log(Status.PASS,
	MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

	}

//if TC failed
	public void onTestFailure(ITestResult result) {
	test = reports.createTest(result.getName());
	//label created, TC name in red
	test.log(Status.FAIL,
	MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));

	}

//if TC skipped
	public void onTestSkipped(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.SKIP,
	MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));

	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	public void onTestFailedWithTimeout(ITestResult result) {

	}

//just before execution starts,this is triggered
	public void onStart(ITestContext context) {
	configureReport();
	//basic empty file creation, foldercreation,html fileetc 
	}

//at the end when complete execution is done
	public void onFinish(ITestContext context) {
		//flush method is what creates complete html file 
		//entire pgm wontwork w/o this fluch method line
	reports.flush();
	}
//to execute it we neeed to callthe class, we use 
}






















