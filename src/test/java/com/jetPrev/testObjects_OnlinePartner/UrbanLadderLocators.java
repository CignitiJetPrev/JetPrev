package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class UrbanLadderLocators {
	
	//search
	public static By txtSearch=By.xpath("//input[@id='search']");
	public static By btnSearch=By.xpath("//button[@id='search_button']");
	public static By dropDownSort=By.xpath("//div[@class='item']");
	public static By labelSortLowToHigh=By.xpath("//li[text()='Price: Low to High']");
	public static By labelFirstSearchedResult=By.xpath("(//div[@class='product-title'])[1]");
	public static By btnAddToCart=By.xpath("(//button[@id='add-to-cart-button'])[3]");
	public static By btnCheckout=By.xpath("(//button[@id='checkout-link'])[1]");
	public static By txtEmail=By.xpath("//input[@id='order_email']");
	public static By txtPincode=By.xpath("//input[@id='order_ship_address_attributes_zipcode']");
	public static By txtAddress=By.xpath("//input[@id='order_ship_address_attributes_address1']");
	public static By txtFirstName=By.xpath("//input[@id='order_ship_address_attributes_firstname']");
	public static By txtLastName=By.xpath("//input[@id='order_ship_address_attributes_lastname']");
	public static By txtMobileNo=By.xpath("//input[@id='order_ship_address_attributes_phone']");
	
	public static By radioBtnCOD=By.xpath("//li[@class='payment-method']//input[@id='order_payments_attributes__payment_method_id_5']");
	public static By btnPlaceOrder=By.xpath("//input[@class='continue button paybtn']");
	
	//pop up 
	public static By btnClosePopUp=By.xpath("//div[@id='authentication_popup']/div[1]/div/div[2]/a[1]");
	
}
