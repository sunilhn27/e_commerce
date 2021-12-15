package com.smallcase.test;

import org.testng.annotations.Test;

import com.smallcase.annotations.Author;
import com.smallcase.pages.actions.AmazonPageActions;
import com.smallcase.pages.actions.FlipKartPageActions;
import com.smallcase.startup.BaseTest;

public class AmazonPriceCompare extends BaseTest {

	public FlipKartPageActions getFlipKartPageActions() throws Exception {
		return new FlipKartPageActions();
	}

	public AmazonPageActions getAmazonPageActions() throws Exception {
		return new AmazonPageActions();
	}

	public int flipkartPrice;
	public int amazonPrice;

	@Test(priority = 1)
	@Author(name = "Sunil H N")
	public void getpriceFromFlipkart() throws Exception {
		getFlipKartPageActions().clickOnEscapeButton();
		getFlipKartPageActions().enterTvName("Vu 126 cm");
		getFlipKartPageActions().clickOnEnterButton();
		getFlipKartPageActions().clickedOnFirstTV();
		getFlipKartPageActions().switchToNewwindow();
		getFlipKartPageActions().clickedOnAddToCart();
		flipkartPrice = getFlipKartPageActions().getPrice();

	}

	@Test(priority = 2)
	@Author(name = "Sunil H N")
	public void getpriceFromAmazon() throws Exception {
		getAmazonPageActions().enterTvName("Vu tv");
		getAmazonPageActions().clickOnEnterButton();
		getAmazonPageActions().clickOnFirstTv();
		getAmazonPageActions().switchToNewwindow();
		getAmazonPageActions().clickOnaddToCart();
		Thread.sleep(5000);
		getAmazonPageActions().clickOnCart();
		Thread.sleep(2000);
		amazonPrice = getAmazonPageActions().getPrice();
		if (amazonPrice > flipkartPrice) {
			System.out.println("Price of TV is more in Amazon Price");
		} else {
			System.out.println("Price of TV is more in Flipkart");
		}

	}



}