package excercise;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TC06 {
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
	String randomEmail= "hong" + random() + "@gmail.com";
	@Test
	public void TC6() {
		String ho= "Nguyen Thi";
		String ten= "Hong";
		System.out.println("start TC6!!");
		// click button my account
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();
		// firstname
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		// input firstname
		firstName.sendKeys(ho);
		// lastname
		WebElement lasttName = driver.findElement(By.xpath("//input[@id='lastname']"));
		// input firstname
		lasttName.sendKeys(ten);
		// email
		WebElement email = driver.findElement(By.xpath("//input[@id='email_address']"));
		email.sendKeys(randomEmail);
		// pass
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("Hong123@@");
		// repass
		WebElement rePass = driver.findElement(By.xpath("//input[@id='confirmation']"));
		rePass.sendKeys("Hong123@@");
		// click dang ky
		WebElement btnRegister = driver.findElement(By.xpath("//button[@title='Register']"));
		btnRegister.click();
	
		WebElement textNote = driver.findElement(By.xpath("//li[@class='success-msg']//span"));
		String successText= textNote.getText();
		assertEquals("Thank you for registering with Main Website Store.", successText);
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//a[@class='skip-link skip-account']")).click();
		driver.findElement(By.xpath("//a[@title='Log Out']")).click();
		String url = driver.getCurrentUrl();
		assertEquals(url,"http://live.demoguru99.com/index.php/customer/account/logoutSuccess/");
		
	}

	public int random() {
		Random ran = new Random();
		int r = ran.nextInt(100);
		return r;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
