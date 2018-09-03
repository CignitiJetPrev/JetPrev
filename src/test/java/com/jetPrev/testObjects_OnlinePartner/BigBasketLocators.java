package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class BigBasketLocators {
	
	public static By txtSearch = By.xpath(".//*[@class='search-input']");
	public static By btnSearch = By.xpath(".//*[@type='submit']");
	public static By btnFirstSearchProduct=By.xpath("(//button[@qa='add'])[1]");
	public static By btnMyBasket=By.xpath("//span[@class='basket-content']");
	public static By arrowMark=By.xpath(".//span[@class='arrow-marker']");	
	public static By btnViewBasketAndCheckOut=By.xpath(".//*[text()='View Basket & Checkout']");
	public static By labelLogin=By.xpath(".//*[text()=' Login']");
	public static By txtEmailID=By.xpath(".//*[@name='username']");
	public static By txtPassword=By.xpath(".//*[@id='password']");
	public static By btnLogin=By.xpath(".//*[text()='LOGIN']");
	
	
	public static By btnCheckout=By.xpath(".//*[@id='checkout']");
	public static By btnDeliverToThisAddress=By.xpath(".//*[@value='deliver to this address']");
	
	//window
	//pop up
	public static By btnReviewBasket=By.xpath("(.//li[@class='ng-scope']/a[text()='Review Basket'])[2]");
	public static By btnCancel=By.xpath("(.//ul[@class='list-unstyled list-inline']//a[text()='Cancel'])[2]");
	
	//check out, deliver to this address
	public static By btnProceedToPayment=By.xpath("(.//*[@id='delivery-preference-continue2' and @class='proceed-btn bb-next collapsed'])[2]");
	public static By radioBtnCOD=By.xpath("(.//input[@name='optradio'])[1]");
	public static By btnPlaceOrder=By.xpath(".//*[text()='Place Order']");

}
