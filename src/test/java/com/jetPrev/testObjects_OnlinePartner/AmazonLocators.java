package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class AmazonLocators {
	
		//search	
		public static By txtSearch  = By.xpath("//input[@id='twotabsearchtextbox']");
		public static By btnSearch		= By.xpath("//input[@value='Go']");
		
		//search results		
		public static By searchResults     = By.xpath("//li[@class='s-result-item  celwidget ']//h2[@class='a-size-base s-inline  s-access-title  a-text-normal']");
		public static By firstSearchResult = By.xpath("(//li[@class='s-result-item  celwidget ']//h2[@class='a-size-base s-inline  s-access-title  a-text-normal'])[1]");
		public static By linksearchresult	= By.xpath("(//div[@class='s-item-container']//a/h2)[1]");
		
		//buyNow button		
		public static By btnBuyNow		   = By.xpath("//input[@id='buy-now-button']");
		
		//emaildetails
		public static By txtEmail		  = By.xpath("//input[@type='email']");
		public static By txtPassword      = By.xpath("//input[@type='password']");
		public static By btnContinue	  = By.xpath("//input[@id='continue']");
		public static By btnLogin		  = By.xpath("//input[@id='signInSubmit']");
		
		//deliverToThisAddressBtn
		public static By btnDeliverToThisAddress  = By.xpath("//div[@id='address-book-entry-0']//a[1]");
		
		//CODcheckboxFilter
		public static By checkBoxFilterCOD				= By.xpath("//span[text()='Eligible for Cash On Delivery']/parent::span/preceding-sibling::input");
		
		//CODradio
		public static By radioBtnCOD		= By.xpath("//input[@value='cashOnDeliveryCash']");
		
		//ContinueBtnOrderPg
		public static By btnContinueOrderPg	= By.xpath("//input[@value='Continue']");
		
		//placeYourOrderBtn
		public static By btnPlaceYourOrder	= By.xpath("//input[@name='placeYourOrder1']");
		
		
}
