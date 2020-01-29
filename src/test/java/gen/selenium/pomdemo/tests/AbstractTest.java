/**
 * 
 */
package gen.selenium.pomdemo.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import gen.selenium.pomdemo.common.DriverManager;
import gen.selenium.pomdemo.listner.MyListener;
import gen.selenium.pomdemo.pageObjects.SearchPage;

/**
 * Class for all the common methods within Tests.
 * 
 * @author kamlesh
 *
 */
@Listeners({ MyListener.class })
public abstract class AbstractTest extends DriverManager {

	/**
	 * Navigate to landing Page.
	 */
	protected SearchPage navigateToSearchPage() {
		// TODO: read from properties
		driver.navigate().to("https://www.google.com/");
		return PageFactory.initElements(driver, SearchPage.class);
	}

}
