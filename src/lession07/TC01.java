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

public class TC01 extends Common {
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
		driver.get("http://live.demoguru99.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void testCase01() {
		WebElement account = driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']"));
		clickElement(account, driver);
		String currentUrl_01 = driver.getCurrentUrl();
		System.out.println(currentUrl_01);
		Assert.assertEquals("http://live.demoguru99.com/index.php/customer/account/login/", currentUrl_01);
		WebElement creatAccount = driver.findElement(By.xpath("//a[@title='Create an Account']"));
		clickElement(creatAccount, driver);
		String currentUrl_02 = driver.getCurrentUrl();
		System.out.println(currentUrl_02);
		Assert.assertEquals("http://live.demoguru99.com/index.php/customer/account/create/", currentUrl_02);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
