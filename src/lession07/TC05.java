package lession07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC05 extends Common{
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

	@Test
	public void testCase04() {
		//click [Click for JS Alert] btn
		WebElement btn= driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
		clickElement(btn,driver);
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(),"I am a JS Confirm");
		alert.dismiss();
		WebElement resultText= driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals(resultText.getText(),"You clicked: Cancel");
		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
