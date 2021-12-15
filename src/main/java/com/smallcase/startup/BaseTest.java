package com.smallcase.startup;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.smallcase.driver.Driver;

public class BaseTest {

	public static WebDriver driver;

	public static String browser;

	@BeforeMethod
	public void initilize(Method m) throws MalformedURLException {
		System.out.println("helo");
		Driver.startUp(m);
	}

	@AfterMethod
	public void close() {
		Driver.quit();
	}
}
