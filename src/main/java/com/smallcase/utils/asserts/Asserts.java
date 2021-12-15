package com.smallcase.utils.asserts;

import org.testng.Assert;

public class Asserts {

	public static void assertEquals(String actual, String expected, String msg) {
		Assert.assertEquals(actual, expected, msg);
	}
	
	public static void assertEquals(int actual, int expected, String msg) {
		Assert.assertEquals(actual, expected, msg);
	}

	public void assertNotEquals(String actual, String expected, String msg) {
		Assert.assertNotEquals(actual, expected, msg);
	}

}
