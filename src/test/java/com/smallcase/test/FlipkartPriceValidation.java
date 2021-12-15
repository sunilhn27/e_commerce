package com.smallcase.test;

import org.testng.annotations.Test;

import com.smallcase.annotations.Author;
import com.smallcase.pages.actions.FlipKartPageActions;
import com.smallcase.startup.BaseTest;

public class FlipkartPriceValidation extends BaseTest {

	FlipKartPageActions flipKartPageActions;

	public FlipKartPageActions getFlipKartPageActions() throws Exception {
		return new FlipKartPageActions();
	}

	@Test
	@Author(name = "Sunil H N")
	public void flipkartPriceValidation() throws Exception {
		getFlipKartPageActions().clickOnEscapeButton();
		getFlipKartPageActions().enterTvName("Vu 126 cm");
		getFlipKartPageActions().clickOnEnterButton();
		getFlipKartPageActions().clickedOnFirstTV();
		getFlipKartPageActions().switchToNewwindow();
		getFlipKartPageActions().clickedOnAddToCart();
		System.out.println("************Before Add *****************");
		getFlipKartPageActions().getPrice();
		getFlipKartPageActions().clickedOnPlusButton();
		System.out.println("************After Adding *****************");
		getFlipKartPageActions().getPrice();

	}

}
