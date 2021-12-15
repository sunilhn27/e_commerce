package com.smallcase.driver;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smallcase.startup.BaseTest;
import com.smallcase.utils.propertyutil.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * Driver class is used to start browsers based on the property file input. User
 * gets the option to work on firefox and chrome browser.
 * 
 */

public class Driver extends BaseTest {

	public static void startUp(Method m) {
		try {

			if (ReadPropertyFile.get("BROWSER").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (ReadPropertyFile.get("BROWSER").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else {
				throw new Exception("No browser macthed");
			}
			driver.manage().window().maximize();
			if (m.getName().equalsIgnoreCase("getpriceFromAmazon")) {
				driver.get(ReadPropertyFile.get("Amazon_URL"));

			} else if (m.getName().equalsIgnoreCase("getpriceFromFlipkart")) {
				driver.get(ReadPropertyFile.get("FlipKart_URL"));

			} else {
				driver.get(ReadPropertyFile.get("FlipKart_URL"));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void quit() {
		if (driver != null) {
			driver.quit();
		}
	}

}
