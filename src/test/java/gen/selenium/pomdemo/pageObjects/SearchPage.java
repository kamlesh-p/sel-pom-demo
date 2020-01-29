package gen.selenium.pomdemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import gen.selenium.pomdemo.base.BasePage;

public class SearchPage extends BasePage {

	@FindBy(name = "q")
	private WebElement searchBar;

	@FindBy(name = "btnK")
	private WebElement searchButton;

	/**
	 * @param driver
	 */
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	public void search(String text) {
		setText(searchBar, text);
		clickEnter();
	}
}
