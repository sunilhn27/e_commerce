package com.smallcase.utils.propertyutil;

import java.io.FileInputStream;
import java.util.Properties;

import com.smallcase.constants.IAutoConst;

public class ReadPropertyFile {

	/*
	 * Generic Method to read data from Properties Files
	 */
	public static String get(String propertyname) {

		String returnproperty = null;
		Properties property = new Properties();
		try {
			FileInputStream file = new FileInputStream(IAutoConst.CONFIG_URL);
			property.load(file);
			returnproperty = property.getProperty(propertyname);
			if (returnproperty == null) {
				throw new Exception("Property named " + propertyname + "not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnproperty;

	}

}
