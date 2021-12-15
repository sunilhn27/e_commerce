package com.smallcase.reports;

import com.aventstack.extentreports.ExtentTest;

public class RecruitCRMReport {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public static void setExtentTest(ExtentTest extentTest) {
		RecruitCRMReport.extentTest.set(extentTest);
	}

}
