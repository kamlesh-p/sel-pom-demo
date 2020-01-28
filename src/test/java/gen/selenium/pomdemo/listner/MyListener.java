package gen.selenium.pomdemo.listner;

import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import gen.selenium.pomdemo.common.Init;

public class MyListener implements ITestListener, ITestNGListener  {

	Logger logger = Logger.getLogger("l");

	public void onFinish(ITestContext arg0) {
	}

	public void onStart(ITestContext arg0) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("---on fail %");
		logger.info("on test fail with%");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("---on fail");
		logger.info("on test fail");
		Init.getExtentTest().log(LogStatus.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("---on skip");
		logger.info("on test skip");
		Init.getExtentTest().log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("---on start " + arg0.getName());
		logger.info("on test start");
		Init.getExtentTest().log(LogStatus.INFO, "About to strat " + arg0.getName());
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("---on success");
		logger.info("on test success");
		Init.getExtentTest().log(LogStatus.PASS, "Test passed");
	}

}
