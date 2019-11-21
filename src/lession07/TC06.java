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

public class TC06 extends Common{
	WebDriver driver;
	String text= "Nguyen Thi Hong";

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
	public void testCase06() {
		//click [Click for JS Alert] btn
		WebElement btn= driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		clickElement(btn,driver);
		Alert alert= driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(),"I am a JS prompt");
		alert.sendKeys(text);
		alert.accept();
		WebElement resultText= driver.findElement(By.xpath("//p[@id='result']"));
		Assert.assertEquals(resultText.getAttribute("value"),"You entered: "+text);
		
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
