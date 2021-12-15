package com.smallcase.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.smallcase.generic.GenericFunctions;
import com.smallcase.pages.objects.AmazonPageObjects;
import com.smallcase.reports.RecruitCRMReport;
import com.smallcase.startup.BaseTest;

public class AmazonPageActions extends BaseTest {
	AmazonPageObjects amazonPageObjects;

	public AmazonPageActions() {
		amazonPageObjects = PageFactory.initElements(driver, AmazonPageObjects.class);
	}

	Actions action;

	public void enterTvName(String tv) throws Exception {
		amazonPageObjects.search.sendKeys("Vu 126 cm (50 inches) Cinema Series 4K Ultra HD Android Smart LED TV 50LX");
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Entered TV Name as " + tv);
	}

	public void clickOnEnterButton() throws Exception {
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "clicked on Escape button");
	}

	public void clickOnaddToCart() throws Exception {
		amazonPageObjects.addToCart.click();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "clicked on Add To Cart");
	}

	public void clickOnFirstTv() throws Exception {
		amazonPageObjects.firstTV.click();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "clicked on First TV");
	}

	public void clickOnCart() throws Exception {
		amazonPageObjects.cart.click();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "clicked on Cart button");
	}

//	public float getPrice() throws Exception {
//		String priceInString = amazonPageObjects.priceField.getText();
//		System.out.println(priceInString.trim());
//		float priceInint = Integer.parseInt(priceInString.replaceAll(",", "").trim());
//		RecruitCRMReport.getExtentTest().log(Status.INFO, "Total Cart price is " + priceInint);
//		return priceInint;
//
//	}

	public int getPrice() throws Exception {
		String priceInString = amazonPageObjects.priceField.getText();
		String price = priceInString.replaceAll("[^a-zA-Z0-9]", "");
		int intPrice = Integer.parseInt(price.trim().substring(0, price.length() - 2));
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Total Cart price is " + intPrice);
		System.out.println(intPrice);
		return intPrice;

	}

	public void switchToNewwindow() throws Exception {
		GenericFunctions.switchToNewWindow();
		Thread.sleep(3000);
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Switch To New window");
	}

}
