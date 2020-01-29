package gen.selenium.pomdemo.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import gen.selenium.pomdemo.constants.Browser;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is used to initialize different browsers.
 * 
 * @author kamlesh
 *
 */
public class DriverManager {

	/**
	 * TODO: to be read from properties.
	 */
	private Browser browerName = Browser.GOOGLE_CHROME;

	public WebDriver driver;

	protected ExtentReports extent;

	protected static ExtentTest test;

	/**
	 * TODO: method to initialize browser
	 */
	@BeforeClass
	public void browserSetup() {

		System.out.println("before suite");
		if (Browser.GOOGLE_CHROME.equals(browerName)) {

			WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
			driver = new ChromeDriver();
		} else if (Browser.EDGE.equals(browerName)) {
			WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
			driver = new ChromeDriver();

		} else if (Browser.MOZILLA_FIREFOX.equals(browerName)) {
			WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
			driver = new ChromeDriver();

		} else {
			/* initialize default browser IE */
			WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void reportSetup() {
		System.out.println("Before class: " + getClass().getSimpleName());
		extent = ExtentManager.getReporter("./report/extentReport-" + getDateTime() + ".html");
		test = extent.startTest(getClass().getSimpleName());
	}

	@AfterClass
	public void tearDown() {
		System.out.println("After class");
		extent.endTest(test);
		extent.flush();
	}

	// @AfterMethod
	// protected void afterMethod(ITestResult result) {
	// if (result.getStatus() == ITestResult.FAILURE) {
	// test.log(LogStatus.FAIL, result.getThrowable());
	// } else if (result.getStatus() == ITestResult.SKIP) {
	// test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	// } else {
	// test.log(LogStatus.PASS, "Test passed");
	// }
	// }

	@AfterSuite
	public void stop() {
		System.out.println("after suite");
		extent.close();
		driver.close();
		driver.quit();
	}

	/**
	 * 
	 */
	private String getDateTime() {
		return LocalDate.now().toString() + "T" + LocalTime.now().getHour() + "-" + LocalTime.now().getMinute();
	}

	public static ExtentTest getExtentTest() {
		return test;

	}

}
