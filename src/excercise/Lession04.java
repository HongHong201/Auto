package excercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lession04 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// firefox
		System.setProperty("webdriver.gecko.driver", "E:\\HongNT\\Demo\\lib\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
		/*
		 * System.setProperty(
		 * "webdriver.chrome.driver","E:\\Auto test learning\\chromedriver.exe"); driver
		 * = new ChromeDriver();
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void testCase01() {
		WebElement email = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement age = driver.findElement(By.xpath("//label[text()='Age:']"));
		WebElement edu = driver.findElement(By.xpath("//textarea[@id='edu']"));
		String text = "Automation Testing";

		// check displayed email textbox
		Assert.assertTrue(email.isDisplayed());

		// check displayed email field
		Assert.assertTrue(age.isDisplayed());

		// check displayed education field
		Assert.assertTrue(edu.isDisplayed());

		// if email exits then input "Automation Testing" value into email textbox
		if (email.isDisplayed()) {
			email.clear();
			email.sendKeys(text);
		}

		// if education exits then input "Automation Testing" value into education
		// textbox
		if (edu.isEnabled()) {
			edu.clear();
			edu.sendKeys(text);
		}

		// check: input value correct -> getAttribute("value"): get value of textbox
		Assert.assertEquals(text, email.getAttribute("value"));
		System.out.println(email.getAttribute("value"));
		Assert.assertEquals(text, edu.getAttribute("value"));
	}

	@Test(priority = 2)
	public void testCase02() {
		WebElement job01 = driver.findElement(By.xpath("//select[@id='job1']"));
		WebElement interests_enable = driver.findElement(By.xpath("//input[@id='development']"));
		WebElement slider01 = driver.findElement(By.xpath("//input[@id='slider-1']"));

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement radioBtn = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
		WebElement biography = driver.findElement(By.xpath("//textarea[@id='bio']"));
		WebElement job02 = driver.findElement(By.xpath("//select[@id='job2']"));
		WebElement interests_disable = driver.findElement(By.xpath("//input[@id='check-disbaled']"));
		WebElement slider02 = driver.findElement(By.xpath("//input[@id='slider-2']"));

		// check job role 01
		Assert.assertTrue(job01.isEnabled());
		if (job01.isEnabled())
			System.out.println("[Job role 01] element is enabled ");
		else
			System.out.println("[Job role 01] element is disabled ");

		// check interests
		Assert.assertTrue(interests_enable.isEnabled());
		if (interests_enable.isEnabled())
			System.out.println("[Interests (development)] element is enabled ");
		else
			System.out.println("[Interests (development)] element is disabled ");

		// check Slider 01
		Assert.assertTrue(slider01.isEnabled());
		if (slider01.isEnabled())
			System.out.println("[Slider 01] element is enabled ");
		else
			System.out.println("[Slider 01] element is disabled ");

		// check password
		Assert.assertFalse(password.isEnabled());
		if (!password.isEnabled())
			System.out.println("[Password] element is disabled ");
		else
			System.out.println("[Password] element is enabled ");

		// check radio button
		Assert.assertFalse(radioBtn.isEnabled());
		if (!radioBtn.isEnabled())
			System.out.println("[Radio button] element is disabled ");
		else
			System.out.println("[Radio button] element is enabled ");

		// check biography
		Assert.assertFalse(biography.isEnabled());
		if (!biography.isEnabled())
			System.out.println("[Biography] element is disabled ");
		else
			System.out.println("[Biography] element is enabled ");

		// check job02
		Assert.assertFalse(job02.isEnabled());
		if (job02.isEnabled())
			System.out.println("[Job role 02] element is disabled ");
		else
			System.out.println("[Job role 02] element is enabled ");

		// check interests_disable
		Assert.assertFalse(interests_disable.isEnabled());
		if (!interests_disable.isEnabled())
			System.out.println("[Interest disable] element is disabled ");
		else
			System.out.println("[Interest disable] element is enabled ");
//
		// check slider02
		Assert.assertFalse(slider02.isEnabled());
		if (!slider02.isEnabled())
			System.out.println("[Slider 02] element is disabled ");
		else
			System.out.println("[Slider 02] element is enabled ");
	}

	@Test(priority = 3)
	public void testCase03() {
		WebElement under18 = driver.findElement(By.xpath("//input[@id='under_18']"));
		WebElement interests_development = driver.findElement(By.xpath("//input[@id='development']"));
		
		under18.click();
		interests_development.click();
		
		//check isSelected
		Assert.assertTrue(under18.isSelected());
		Assert.assertTrue(interests_development.isSelected());
		
		//unSelected interests_development
		interests_development.click();
		Assert.assertFalse(interests_development.isSelected());

	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
