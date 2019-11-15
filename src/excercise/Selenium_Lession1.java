package excercise;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Selenium_Lession1 {
	WebDriver driver;
	@Test
	public void f() {
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","E:\\Auto test learning\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://zingmp3.vn/nghe-si/Thuy-Chi");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
