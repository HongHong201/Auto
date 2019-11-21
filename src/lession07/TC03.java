package lession07;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03 extends Common{
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// firefox
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "E:\\HongNT\\Demo\\lib\\geckodriver.exe"); driver = new FirefoxDriver();
		 * driver.get("http://demo.guru99.com/v4/");
		 */

		System.setProperty("webdriver.chrome.driver", "E:\\Auto test learning\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void testCase03() {
		WebElement radio= driver.findElement(By.xpath("//input[@id='engine3']"));
		
		// check ON Dual-zone air conditioning
		clickElement(radio, driver);
		Assert.assertTrue(radio.isSelected());
		if (!radio.isSelected())
			clickElement(radio, driver);
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
