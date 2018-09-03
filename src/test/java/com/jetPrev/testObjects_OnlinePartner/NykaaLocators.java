package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class NykaaLocators {
	
	//search text box
	public static By txtSearchBox=By.xpath("//div[@id='search_box1']/input[@id='search']");
	//filter 
	public static By labelPrice1=By.xpath("//a[text()='PRICE ']");
	public static By labelPrice=By.xpath("//div[@class='filt-li price filt-actv']/a");
	public static By checkBoxPriceRange=By.xpath("//ul[@id='mobilehead_11_block']/ol/li[3]");
	public static By imgSelectProduct=By.xpath("(//div[@class='product-image']/a)[2]");
	//switch window
	//public static By btnAddToBag=By.xpath("//div[@id='prod_addtocart_container']//a");
	public static By btnAddToBag=By.xpath("//div[@id='prod_addtocart_before']/a");
	public static By imgCart=By.xpath("//div[@id='BagItems']");

	//switch window
	
	//checkout
	public static By btnCheckout=By.xpath("//div[@id='sliding_checkout_region']//span[text()='CHECKOUT ']");
	
	public static By txtEmail=By.xpath("//input[@id='billing_email']");
	public static By btnContinue=By.xpath("//a[@id='isregisteredbtn']");
	public static By txtPassword=By.xpath("//input[@id='billing_customer_password']");
	public static By btnLoginToContinue=By.xpath("//button[@id='altloginbtn']");
	public static By btnContinueAsGuest=By.xpath("//button[@id='continueasguestbtn']");
	
	//login details
	public static By txtPhoneNumber=By.xpath("//input[@id='shipping_telephone']");
	public static By txtPincode=By.xpath("//input[@id='shipping_postcode']");
	public static By txtStreetAddr1=By.xpath("//input[@id='shipping_street1']");
	public static By txtStreetAddr2=By.xpath("//input[@id='shipping_street2']");
	public static By btnShipToThisAddress1=By.xpath("//a[@id='btn_add_sa_submit_1']");
	public static By btnShipToThisAddress=By.xpath("//div[text()='SHIP TO THIS ADDRESS']");
	
	//cod
	public static By optionCOD=By.xpath("//li[@id='method_phoenix_cashondelivery']");
	
	//pay now btn
	public static By btnPlaceOrder=By.xpath("//div[@class='payment_button']/input[@id='phoenix_cashondelivery_btn']");
	
	//label for no items in cart
	public static By labelCartEmpty=By.xpath("//div[@class='cart-empty']/p");
	//homepage if cart is empty
	public static By linkHomePage=By.xpath("//div[@class='cart-empty']/p/a");
	
	//continue shopping label in sliding region
	public static By labelContShopping=By.xpath("//div[@id='sliding_checkout_region']//span[@id='cont_shop_label']");
	
	//label added to bag
	public static By labelAddedToBag=By.xpath("//span[text()='ADDED TO BAG']");
}
