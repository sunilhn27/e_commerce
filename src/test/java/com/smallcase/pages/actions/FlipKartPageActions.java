package com.smallcase.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.smallcase.generic.GenericFunctions;
import com.smallcase.pages.objects.FlipKartPageObjects;
import com.smallcase.reports.RecruitCRMReport;
import com.smallcase.startup.BaseTest;

public class FlipKartPageActions extends BaseTest {

	FlipKartPageObjects flipKartPageObjects;

	public FlipKartPageActions() {
		flipKartPageObjects = PageFactory.initElements(driver, FlipKartPageObjects.class);
	}

	Actions action;

	public void clickOnEscapeButton() throws Exception {
		Thread.sleep(3000);
		action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "clicked on Escape button");

	}

	public void clickOnEnterButton() throws Exception {
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "clicked on Escape button");
	}

	public void enterTvName(String tv) throws Exception {
		flipKartPageObjects.search.sendKeys(tv);
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Entered TV Name as " + tv);
	}

	public void clickedOnFirstTV() throws Exception {
		GenericFunctions.waitForElementToAppear(flipKartPageObjects.firstTv);
		flipKartPageObjects.firstTv.click();
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Clicked on First Link");
	}

	public void switchToNewwindow() throws Exception {
		GenericFunctions.switchToNewWindow();
		Thread.sleep(3000);
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Switch To New window");
	}

	public void clickedOnAddToCart() throws Exception {
		flipKartPageObjects.addToCart.click();
		Thread.sleep(3000);
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Clicked on Add To Cart");
	}

	public void clickedOnPlusButton() throws Exception {
		GenericFunctions.waitForElementToAppear(flipKartPageObjects.plussButton);
		flipKartPageObjects.plussButton.click();
		Thread.sleep(3000);
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Clicked on Plus button");
	}

	public int getPrice() throws Exception {
		String priceInString = flipKartPageObjects.priceField.getText();
		String price = priceInString.replaceAll("[^a-zA-Z0-9]", "");
		int intPrice = Integer.parseInt(price.trim());
		System.out.println(intPrice);
		RecruitCRMReport.getExtentTest().log(Status.INFO, "Total Cart price is " + intPrice);
		return intPrice;

	}

//	public String getPrice() throws Exception {
//		String priceIntxt = flipKartPageObjects.priceField.getText();
//		String priceInint = priceIntxt.replaceAll(",", "");
//		RecruitCRMReport.getExtentTest().log(Status.INFO, "Total Cart price is " + priceInint);
//		return priceInint;
//	}

}
