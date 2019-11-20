package excercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
			String expectedValueItem) throws InterruptedException {

		// Khai báo javascript
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// khởi tạo hàm wait của javascript:
		WebDriverWait waitExplicit = new WebDriverWait(driver, 60);

		// Khai báo webElement cua ô dropdown
		WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));

		if (parentDropdown.isDisplayed()) {

			// Click của selenium
			parentDropdown.click();
		} else {
			// Click của javascript
			jsExecutor.executeScript("arguments[0].click();", parentDropdown);
		}
		// đợi cho tất cả các phần tử hiển
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		// tạo 1 list webElement để lưu lại Xpath của tất cả element con
		List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
		// for
		for (int i = 0; i < allItems.size(); i++) {
			if (allItems.get(i).getText().equals(expectedValueItem)) {
				// scroll đến element cần click
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", allItems.get(i));
				Thread.sleep(1500);
				if (allItems.get(i).isDisplayed()) {
					allItems.get(i).click();
				} else {
					jsExecutor.executeScript("arguments[0].click();", allItems.get(i));
				}

				break;
			}
		}
	}

	// click vào ô dropdown
	// chọn các giá trị cần click

	//
	public void selectMutipleItems(WebDriver driver, String parentXpath, String allItemsXpath, String[] expectedValues,
			String selectedLocators) throws Exception {

		// Khai báo thư viện sử dụng
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebDriverWait waitExplicit = new WebDriverWait(driver, 60);

		// khai báo webElement của ô dropdown
		WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));

		// Click vào ô dropdown
		if (parentDropdown.isDisplayed()) {
			parentDropdown.click();
		} else {
			jsExecutor.executeScript("arguments[0].click();", parentDropdown);
		}
// Đợi cho tất cả element hiển thị
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsXpath)));

		// Khai báo list element chứa các phần tử con
		List<WebElement> allItems = driver.findElements(By.xpath(allItemsXpath));

		// khai báo 1 webElement con để lặp trong list webElement
		for (WebElement childELement : allItems) {
			// Khai báo biến để lặp trong các giá trị cần chọn
			for (String item : expectedValues) {
				if (childELement.getText().equals(item)) {
					jsExecutor.executeScript("arguments[0].scrollIntoView(true);", childELement);
					Thread.sleep(1000);
					if (childELement.isDisplayed()) {
						childELement.click();
					} else {
						jsExecutor.executeScript("arguments[0].click();", childELement);
					}
					Thread.sleep(1000);
					List<WebElement> selectedItems = driver.findElements(By.xpath(selectedLocators));

					if (expectedValues.length == selectedItems.size()) {
						break;

					}

				}

			}
		}
	}
}
