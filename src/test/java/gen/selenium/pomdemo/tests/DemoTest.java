package gen.selenium.pomdemo.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import gen.selenium.pomdemo.pageObjects.SearchPage;

public class DemoTest extends AbstractTest {
	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1)
	public void searchTest() {
		SearchPage searchPage = navigateToSearchPage();
		searchPage.search("Test");

	}

	@Test(priority = 1)
	public void test11() {
		driver.navigate().to("https://translate.google.com");

		driver.findElement(By.id("gt-tl-gms")).click();

		driver.findElement(By.xpath("//*[@id='goog-menuitem-group-3']//div[text()='Hindi']")).click();
		driver.findElement(By.id("source")).sendKeys("Software Testing");

		System.out.println(driver.findElement(By.id("gt-res-dir-ctr")).getText());

	}

};
