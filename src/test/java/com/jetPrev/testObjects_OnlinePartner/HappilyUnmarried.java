package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class HappilyUnmarried {

	//drop down
	public static By dropDownUser =By.xpath("(//div[@class='btn-group paddingrightside']/button[@class='btn btn-default dropdown-toggle btnwiddrop'])[1]");
	public static By labelLogin   =By.xpath("(//ul[@class='dropdown-menu']//a[@id='mainlogin'])[1]");

	//login pop up

	public static By txtLogin		=By.xpath("//input[@id='youama-email-login']");
	public static By txtPassword	=By.xpath("//input[@id='youama-password-login']");
	public static By btnLogin		=By.xpath("//button[@id='login-submit']");
	
	//selectproduct
	public static By labelfirstproductinlist=By.xpath("(//div[@class='product-img']/a)[1]");
	public static By btnAddToCart=By.xpath("//button[@id='add_to_cart']");
	public static By btnCart=By.xpath("//span[@class='glyphicon glyphicon-shopping-cart']/..");
	public static By btnProceedToCheckout=By.xpath("//button[@id='place_order']");
	public static By txtPhoneNumber=By.xpath("//input[@id='guest-phone-number']");
	public static By btnProceedToPayment=By.xpath("//button[@id='review-step-continue']");
	public static By labelCOD=By.xpath("//label[text()='Cash On Delivery']/..");
	public static By btnFinalPayment=By.xpath("//button[@id='payment-button']");


}
