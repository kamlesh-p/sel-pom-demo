/**
 * 
 */
package gen.selenium.pomdemo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author kamlesh
 *
 */
public class BasePage {

	private static final long WAIT_TIME_IN_SEC = 30;

	/**
	 * Never mane driver static, else it will fail in parallel execution.
	 */
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 */
	protected void clickElement(WebElement element) {
		try {
			waitUntilElementIsVisible(element);
			element.click();
		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			// NOTE: Do not catch generic Exception.
			element.click();
		}
	}

	protected void setText(WebElement element, String value) {
		try {
			waitUntilElementIsVisible(element);
			element.clear();
			element.sendKeys(value);
		} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
			// NOTE: Do not catch generic Exception.
			element.clear();
			element.sendKeys(value);
		}
	}

	protected void clickEnter() {
		driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
	}

	/**
	 * Wait for visibility of element.
	 */
	private void waitUntilElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_IN_SEC);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
