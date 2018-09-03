package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class FlipkartLocators {
	
	//Product description
	public static By txtProdDesc  = By.xpath("//div[@id='container']//h1");
	public static By btnAddToCart = By.xpath("//button[text()='ADD TO CART']");
	//public static By btnBuyNow	  = By.xpath("//button[text()='BUY NOW']");
	
	//search Text box
	public static By txtSearch	= By.xpath(".//input[@name='q']");
	public static By btnSearch	= By.xpath(".//button[@type='submit']");
	//first searched product
	public static By labelFirstSearchProd=By.xpath("(.//a[@class='_1UoZlX'])[1]");
	//Btn
	public static By btnBuyNow=By.xpath(".//*[text()='BUY NOW']");
	public static By btnContinue=By.xpath(".//*[text()='CONTINUE']");
	public static By btnLogin=By.xpath(".//*[text()='Login']");
	public static By btnDeliverHere=By.xpath(".//*[text()='Deliver Here']");
	//COD radioBtn
	public static By radioBtnCOD=By.xpath(".//*[@for='COD']/input");
	
	//Close on pop up 
	public static By BtnClosePopUp=By.xpath("//button[text()='✕']");
	
	

}
