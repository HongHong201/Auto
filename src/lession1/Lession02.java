package lession1;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Lession02 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "E:\\HongNT\\Demo\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com");
		/*System.setProperty("webdriver.chrome.driver","E:\\Auto test learning\\chromedriver.exe");
		driver = new ChromeDriver();*/
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC1() {
		System.out.println("start!!");
		// click button my account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// click button login, bor trong email va passs
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		// check message bo trong email
		String emailMessage = driver.findElement(By.xpath("//*[@id=\"advice-required-entry-email\"]")).getText();
		String passMessage = driver.findElement(By.xpath("//*[@id=\"advice-required-entry-pass\"]")).getText();
		assertEquals("This is a required field.", emailMessage);
		assertEquals("This is a required field.", passMessage);

	}

	@Test
	public void TC2() {
		System.out.println("start!!");
		// click button my account
		WebElement emailMessage = driver.findElement(By.xpath("//input[@id='email']"));
		emailMessage.sendKeys("123@1334.1233");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		String validEmailMessage = driver.findElement(By.xpath("//div[@id=\"advice-validate-email-email\"]")).getText();
		assertEquals("Please enter a valid email address. For example johndoe@domain.com.", validEmailMessage);

	}
	@Test
	public void TC3() {
		System.out.println("start!!");
		// click button my account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// click button login, bor trong email va passs
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("automation@gmail.com");
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("123");
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		String validEmailMessage = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
		assertEquals("Please enter 6 or more characters without leading or trailing spaces.", validEmailMessage);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
