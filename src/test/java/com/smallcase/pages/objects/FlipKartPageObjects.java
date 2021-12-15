package com.smallcase.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class FlipKartPageObjects {

	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	public WebElement search;

	@FindBy(xpath = "(//div[@class='_4rR01T'])[1]")
	public WebElement firstTv;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww'][contains(.,'ADD TO CART')]")
	public WebElement addToCart;

	@FindBy(xpath = "//*[@class=\"_2-ut7f _1WpvJ7\"]")
	public WebElement priceField;

	@FindBy(xpath = "//button[contains(.,'+')]")
	public WebElement plussButton;

	@FindBys({ @FindBy(xpath = "//button[contains(.,'GO TO CART')]"),
			@FindBy(xpath = "//button[contains(.,'ADD TO CART')]") })
	public WebElement addToCart1;

}