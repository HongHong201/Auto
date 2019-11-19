package excercise;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lession05 {
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
		driver.get("http://demo.guru99.com/v4/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testCase01() {
		WebElement userID = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		String e= "automation"+random()+"@gmail.com";

		// clear textbox
		userID.clear();
		password.clear();

		// login
		userID.sendKeys("mngr233426");
		password.sendKeys("gurYguh");
		loginBtn.click();

		WebElement newCustomerBtn = driver.findElement(By.xpath("//a[contains(text(),'New Customer')]"));
		newCustomerBtn.click();

		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.clear();
		name.sendKeys("AUTOMATION TESTING");

		WebElement dateOfBrith = driver.findElement(By.xpath("//input[@id='dob']"));
		dateOfBrith.clear();
		dateOfBrith.sendKeys("01/01/1989");

		WebElement address = driver.findElement(By.xpath("//textarea[@name='addr']"));
		address.clear();
		address.sendKeys("PO Box 911 8331 Duis Avenue");

		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		city.clear();
		city.sendKeys("Tampa");

		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		state.clear();
		state.sendKeys("SL");

		WebElement pin = driver.findElement(By.xpath("//input[@name='pinno']"));
		pin.clear();
		pin.sendKeys("466250");

		WebElement mobile = driver.findElement(By.xpath("//input[@name='telephoneno']"));
		mobile.clear();
		mobile.sendKeys("4555442476");

		WebElement email = driver.findElement(By.xpath("//input[@name='emailid']"));
		email.clear();
		email.sendKeys(e);

		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		pass.clear();
		pass.sendKeys("automation");

		WebElement submitBtn = driver.findElement(By.xpath("//input[@name='sub']"));
		submitBtn.click();

	}

	@Test(priority = 2)
	public void testCase02() {
		/*
		 * WebElement userID = driver.findElement(By.xpath("//input[@name='uid']"));
		 * WebElement password =
		 * driver.findElement(By.xpath("//input[@name='password']")); WebElement
		 * loginBtn = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		 * 
		 * 
		 * //clear textbox userID.clear(); password.clear();
		 * 
		 * //login userID.sendKeys("mngr233426"); password.sendKeys("gurYguh");
		 * loginBtn.click();
		 */

		WebElement editCustomerBtn = driver.findElement(By.xpath("//a[contains(text(),'Edit Customer')]"));
		editCustomerBtn.click();

		WebElement cusId = driver.findElement(By.xpath("//input[@name='cusid']"));
		cusId.clear();
		cusId.sendKeys("64289");

		WebElement submitBtn = driver.findElement(By.xpath("//input[@name='AccSubmit']"));
		submitBtn.click();

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
