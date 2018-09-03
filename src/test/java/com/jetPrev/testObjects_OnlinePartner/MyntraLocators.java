package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class MyntraLocators {

	//product description
	public static By txtProdDesc = By.xpath("//div[@class='pdp-description-container']//h1");
	
	public static By iconSearch=By.xpath(".//*[@class='desktop-submit']");
	public static By txtSearch=By.xpath("//header[@id='desktop-header-cnt']//input");
	public static By firstSelectedProduct=By.xpath("(.//li[@class='product-base']/a)[1]");
	public static By selectSize=By.xpath("(.//*[@class='size-buttons-size-button size-buttons-size-button-default'])[1]");
	public static By btnAddToBag=By.xpath(".//*[text()='ADD TO BAG']");
	public static By iconBag=By.xpath(".//*[@class='myntraweb-sprite desktop-iconBag sprites-bag']");
	public static By btnPlaceOrder=By.xpath(".//*[text()='PLACE ORDER']");
	public static By btnContinue=By.xpath(".//*[text()='continue']");
}
