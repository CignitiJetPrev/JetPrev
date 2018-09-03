package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class PopUpPageLocators {
	
	//Page title
	
	public static By titlePage			= By.id("//div[@class='dialog_title']/h3");
	
	
	// LHS Text
	
	public static By point_1 			= By.xpath("//div[@id='point1']");
	public static By point_2 			= By.xpath("//div[@id='point2']");
	public static By point_3 			= By.xpath("//div[@id='point3']");
	public static By termsAndCondition	= By.id("trm_and_condition");
	
	// Form title
	
	public static By form_title 		= By.xpath("//div[@class='form_title']/h4");
	
	// JPNumberTextbox
	
	public static By jpnum_textbox     = By.id("jpNum_");
	
	// Proceed button
	
	public static By ProceedBtn_1        = By.xpath("//input[@id='URL_param4_']");
	public static By ProceedBtn=By.xpath("//a[@id='proceedBtn_Amazon']");
	public static By BtnProceedBigbasket=By.xpath("//a[@id='proceedBtn_Bigbasket']");
	public static By BtnProceedHappilyUnmarried=By.xpath("//a[@id='proceedBtn_HappilyUnmarried']");
	public static By btnProceedNykaa=By.xpath("//a[@id='proceedBtn_NYKAA']");
	public static By btnProceedFlipkart=By.xpath("//a[@id='proceedBtn_Flipkart']");
	public static By btnProceedMyntra=By.xpath("//a[@id='proceedBtn_Myntra']");
	public static By btnProceedFirstCry=By.xpath("//a[@id='proceedBtn_Firstcry']");
	public static By btnProceedUrbanLadder=By.xpath("//a[@id='proceedBtn_UrbanLadder']");
	public static By btnProceedWoohoo=By.xpath("//a[@id='proceedBtn_Woohoo']");
	public static By btnProceedTataCliq=By.xpath("//a[@id='proceedBtn_TataCliq']");
	public static By btnProceedLenskart=By.xpath("//a[@id='proceedBtn_Lenskart']");
	
	
	// Text on proceed button
	
	public static By ProceedBtnText  	= By.xpath("//a[@class='default_btn proceedBtn']");
	
	// PartnerimageIcon
	
	public static By partnerImgIcon		= By.xpath("//img[@id='partnerImage']");
	
	//enrol link
	
	public static By enrolNowLink		= By.linkText("Enrol Now");
	
	//continue as guest link
	
	public static By continueAsGuestLink = By.xpath("//a[@class='blue_txt_ continueAsGuest']");
	
	
	//  RHS text
	
	public static By notajetprevText	= By.xpath("//div[@class='form_footer bg_eee']//p");
	
	
	
	
	
	

}
