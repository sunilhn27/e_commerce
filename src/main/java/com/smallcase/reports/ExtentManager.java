package com.smallcase.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.smallcase.constants.IAutoConst;

/**
 * 
 * Purpose: Create instance for report and set extent configs
 */

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtent() {
		if (extent == null) {
			try {
				extent = new ExtentReports();
				extent.attachReporter(getHtmlReporter());
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return extent;

	}

	private static ExtentHtmlReporter getHtmlReporter() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(IAutoConst.REPORT_DIR_PATH);
		htmlReporter.config().enableTimeline(false);
		htmlReporter.config().setReportName("Test Automation");
		return htmlReporter;
	}

}
