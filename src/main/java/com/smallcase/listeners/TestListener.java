package com.smallcase.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.smallcase.annotations.Author;
import com.smallcase.reports.ExtentManager;
import com.smallcase.reports.ExtentTestManager;
import com.smallcase.reports.RecruitCRMReport;
import com.smallcase.startup.BaseTest;
import com.smallcase.utils.propertyutil.ReadPropertyFile;

public class TestListener extends BaseTest implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		ExtentTestManager.InitReport();
		System.out.println("I am in onStart method " + iTestContext.getName());

	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
		ExtentManager.getExtent().flush();

	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		String testName = iTestResult.getMethod().getMethodName() + "";
		Author author = iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Author.class);
		ExtentTest testReport = ExtentTestManager.createTest(testName, ReadPropertyFile.get("BROWSER"), author);
		RecruitCRMReport.setExtentTest(testReport);
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Test passed.");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		RecruitCRMReport.getExtentTest().log(Status.FAIL, "Test Failed.");
		System.out.println(iTestResult.getThrowable().getLocalizedMessage().toString());
		// Take Screen shot logic can be return and attach it to Report

	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Test Skipped.");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("onTestFailedButWithinSuccessPercentage" + getTestMethodName(iTestResult));
	}

}