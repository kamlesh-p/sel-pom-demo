package gen.selenium.pomdemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import gen.selenium.pomdemo.common.Init;

public class DemoTest extends Init {
	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1)
	public void test11() throws InterruptedException {
		driver.navigate().to("https://translate.google.com");

		driver.findElement(By.id("gt-tl-gms")).click();

		driver.findElement(By.xpath("//*[@id='goog-menuitem-group-3']//div[text()='Hindi']")).click();
		driver.findElement(By.id("source")).sendKeys("Software Testing");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("")));

		System.out.println(driver.findElement(By.id("gt-res-dir-ctr")).getText());

	}

};
