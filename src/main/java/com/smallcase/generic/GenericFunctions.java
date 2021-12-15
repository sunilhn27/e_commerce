package com.smallcase.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.smallcase.startup.BaseTest;

public class GenericFunctions extends BaseTest {

	static Logger log = Logger.getLogger(GenericFunctions.class.getName());

	// Method to switchToFrame
	public static void switchToFrame(WebDriver mDriver, WebElement frame) {
		try {
			mDriver.switchTo().frame(frame);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// wait till max timeout
	public static void waitForElementToAppear(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(id));
	}

	// Method to Select DropDown Value by Index
	public static void selectValueByIndex(WebDriver mDriver, WebElement locator, int index) {
		Select select = new Select(locator);
		select.selectByIndex(index);
		;
	}

	// Method to Scroll To particular Element
	public static void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Method to Switch To New Window.
	public static void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}
	
//	public int getPrice(String price) throws Exception {
//		String priceInString = price.replaceAll("[^a-zA-Z0-9]", "");
//		int intPrice = Integer.parseInt(priceInString.trim().substring(0, priceInString.length() - 2));
//		System.out.println(intPrice);
//		return intPrice;
//
//	}
}
