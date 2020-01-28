package gen.selenium.page_object_model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Hello world!
 *
 */
public class App {
	// public static void main(String[] args) {
	// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
	// driver.get("https://www.google.co.in/");
	// driver.findElement(By.name("q")).sendKeys("hello world!");
	// driver.findElement(By.name("btnK")).click();
	// driver.close();
	// driver.quit();
	// }

	public static void main(String[] args) {
		System.out.println(LocalDate.now().toString() + "-" + LocalTime.now().getHour() +":"+ LocalTime.now().getMinute());
	}
}
