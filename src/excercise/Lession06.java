package excercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Lession06{
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
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(priority = 1)
	public void testCase02() {
		// kiem tra job role 01 khong ho tro multi-select 
		Select select= new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		Assert.assertFalse(select.isMultiple());
		
		// select [Automation Tester] option
		select.selectByVisibleText("Automation Tester");
		//check: gia tri da duoc chon thanh cong
		Assert.assertEquals("Automation Tester", select.getFirstSelectedOption().getText());
		
		//select Manual Tester
		select.selectByValue("Manual Tester");
		Assert.assertEquals("Manual Tester", select.getFirstSelectedOption().getText());
		
		//select Mobile Tester
		select.selectByIndex(3);
		Assert.assertEquals("Mobile Tester", select.getFirstSelectedOption().getText());
		
		//check du 5 opption cua list
		Assert.assertEquals(5, select.getOptions().size());
		
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
