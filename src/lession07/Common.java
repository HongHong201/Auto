package lession07;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
	public void clickElement (WebElement element, WebDriver driver) {
		if(element.isDisplayed() && element.isEnabled())
			element.click();
		else {
			JavascriptExecutor js = (JavascriptExecutor) driver;			
			js.executeScript("arguments[0].click();", element);
		}
	}
	public void checkOnElement(WebElement element, WebDriver driver) {
		if (element.isDisplayed() && element.isSelected())
			element.click();
		else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
	}
		
}
