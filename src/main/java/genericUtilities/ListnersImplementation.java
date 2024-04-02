package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of TestNg
 * @author 91831
 *
 */
public class ListnersImplementation implements ITestListener {
	ExtentReports report ;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "---Test Execution Started---");
		//add @Test to Your Extent Reports--report dont know that script is started so we have to tell it script execution is started
		
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "---Test Execution passed---");
		test.log(Status.PASS,methodName+"--Test PASS--");//bcz print statment will not display in report
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "---Test Execution Failed---");
		//Log the Fail status to extent report
		test.log(Status.FAIL,methodName+"--Test FAIL--");
		
		SeleniumUtilities s = new SeleniumUtilities();
		JavaUtility j= new JavaUtility(); 
		String screenShotName =methodName+"-"+ j.getDate();
		//try catch is used and throws is not used because this is a  overrided method and in a over rided method we can't make any changes in method declaration or method signature because of that reason we cannot use Throws.
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenShotName);
			//Attach screenShot to extent Report
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "---Test Execution Skipped---");
		//Log the SKIP status to extent report
		test.log(Status.SKIP,methodName+"--Test FAIL--");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("---Suite Execution Started ---");
		//Extent Report configuration 
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("Vtiger Execution Report");
		rep.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Reporter Name", "kriti");
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("---Suite Execution Finished ---");
		//Generate extent Report
		report.flush();
	}
   
	
}
