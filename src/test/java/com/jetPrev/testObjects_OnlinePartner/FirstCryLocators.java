package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class FirstCryLocators {
	//searchbox
	public static By txtFCSearch=By.xpath("//input[@id='search_box']");
	public static By btnFCSearch=By.xpath(".//*[@class='search-button']");
	public static By addToCartFCfirstSearchedProduct=By.xpath("(.//*[text()='ADD TO CART'])[1]");
	public static By btnFCPlaceOrder=By.xpath(".//*[@id='btnPlaceOrder']");
	public static By btnFCPopUpPlaceOrder=By.xpath(".//div[@id='Cart_PlaceOrder']/div");
	public static By txtFCEmailId=By.xpath(".//*[@id='BillEmailAddress']");
	public static By txtFCPassword=By.xpath(".//*[@id='Password']");
	public static By btnFCContinue=By.xpath(".//*[text()='CONTINUE']");	
	public static By radiobtnFirstCryAccount=By.xpath("(.//input[@id='radLoginType'])[1]");
	public static By txtFCFirstName=By.xpath(".//*[@id='ShipFirstName']");
	public static By txtFCAddressLine1=By.xpath(".//*[@id='AddressLine1']");
	public static By txtFCAddressLine2=By.xpath(".//*[@id='AddressLine2']");
	public static By txtFCLandmark=By.xpath(".//*[@id='AddressLine3']");
	public static By txtFCPinCode=By.xpath(".//*[@id='ShipPinCode']");
	public static By txtFCMobileNo=By.xpath(".//*[@id='ShipMobileNo']");
	public static By btnFCUseThisAddress=By.xpath(".//*[@id='btnSubmitAdd']");
	public static By btnFCFinalPayment=By.xpath(".//*[@id='fpay']");
	public static By radioBtnFCCOD=By.xpath(".//*[@id='Cod']");
	public static By btnFCPlaceFinalOrder=By.xpath(".//*[@id='BtnCodPayNow']");
	public static By btnFCClosePopUp=By.xpath("//a[text()='Close']/following-sibling::div");

}
