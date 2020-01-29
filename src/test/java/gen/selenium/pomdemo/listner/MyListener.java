package gen.selenium.pomdemo.listner;

import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import gen.selenium.pomdemo.common.DriverManager;

public class MyListener implements ITestListener, ITestNGListener {

	Logger logger = Logger.getLogger("Listener");

	public void onFinish(ITestContext arg0) {
	}

	public void onStart(ITestContext arg0) {
		logger.info("on test start");
		if (DriverManager.getExtentTest() != null) {
			DriverManager.getExtentTest().log(LogStatus.INFO, "Test started");
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		logger.info("on test fail with%");
	}

	public void onTestFailure(ITestResult result) {
		logger.info("on test fail");
		DriverManager.getExtentTest().log(LogStatus.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("on test skip");
		DriverManager.getExtentTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {
		logger.info("on test start " + arg0.getName());
		DriverManager.getExtentTest().log(LogStatus.INFO, "About to strat " + arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		logger.info("on test success");
		DriverManager.getExtentTest().log(LogStatus.PASS, "Test passed");
	}

}
