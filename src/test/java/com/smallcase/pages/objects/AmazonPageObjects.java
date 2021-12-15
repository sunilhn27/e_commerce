package com.smallcase.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPageObjects {

	@FindBy(xpath = "//input[@aria-label='Search']")
	public WebElement search;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	public WebElement firstTV;

	@FindBy(xpath = "//input[@name='submit.add-to-cart']")
	public WebElement addToCart;

	@FindBy(xpath = "(//span[contains(.,'Vu 126 cm (50 inches) Cinema Series 4K Ultra HD Android Smart LED TV 50LX (Matte Black) (2021 Model) I 100 Watt Front Soundbar')])[3]")
	public WebElement vuTv;

	@FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
	public WebElement cart;

	@FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	public WebElement priceField;

}
