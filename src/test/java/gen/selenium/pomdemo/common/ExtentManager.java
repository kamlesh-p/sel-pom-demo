/**
 * 
 */
package gen.selenium.pomdemo.common;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author kamlesh
 *
 */
public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentTest test;

	public synchronized static ExtentReports getReporter(String filePath) {
		if (extent == null) {
			extent = new ExtentReports(filePath, true);
			extent.loadConfig(new File("extent-config.xml"));
			extent.addSystemInfo("Host Name", "test").addSystemInfo("Environment", "QA");
		}

		return extent;
	}

	// TODO
	public synchronized static ExtentReports getTest(String testName) {
		return null;
	}

}
