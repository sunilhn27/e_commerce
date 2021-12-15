package com.smallcase.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.smallcase.annotations.Author;

/**
 * Purpose: overloaded methods as we use it for send information to report
 * 
 */

public class ExtentTestManager {

	private static ExtentTest extentTest;
	public static ExtentReports extentReports;

	public static void InitReport() {
		extentReports = ExtentManager.getExtent();
	}

	public synchronized static ExtentTest createTest(String name, String deviceId, Author author) {
		extentTest = extentReports.createTest(name).assignCategory(deviceId).assignAuthor(author.name());
		return extentTest;
	}

}
