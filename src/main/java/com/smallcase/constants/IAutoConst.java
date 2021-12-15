package com.smallcase.constants;

import java.io.File;

public interface IAutoConst {

	public final static String PROJECT_PATH = System.getProperty("user.dir");

	public final static String REPORT_DIR_PATH = PROJECT_PATH + File.separator + "Reports" + File.separator
			+ "ExtentReport.html";

	public final static String CONFIG_URL = PROJECT_PATH + File.separator + "Properties" + File.separator
			+ "Config_URL.properties";

	public final static String IMAGE = PROJECT_PATH + File.separator + "TestData" + File.separator + "image.png";

}
