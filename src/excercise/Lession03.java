package excercise;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lession03{
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "E:\\HongNT\\Demo\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com");
		/*
		 * System.setProperty(
		 * "webdriver.chrome.driver","E:\\Auto test learning\\chromedriver.exe"); driver
		 * = new ChromeDriver();
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	 @Test
	public void TC4() {
		System.out.println("start TC4!!");
		// click button my account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("nguyenhong.hus.201@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("123123123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		String invalidPassMessage = driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
		assertEquals("Invalid login or password.", invalidPassMessage);

	}

	@Test
	public void TC5() {
		System.out.println("start TC5!!");
		// click button my account
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("nguyenhong.hus.201@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("Hong123@@");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		String correctName = driver.findElement(By.xpath("//p[@class='welcome-msg']")).getText();
		System.out.println(correctName);
		correctName.contentEquals("WELCOME");
		
		//Assert.assertTrue(correctName.contains("welcome"));
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
