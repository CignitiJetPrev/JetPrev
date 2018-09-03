package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class LoginPageLocators {

	//loginpageTextBox	
	public static By loginIDTextBox	 = By.xpath("//input[@id='ctl01_jetno']");
	public static By passwordTextBox = By.xpath("//input[@id='ctl01_password']");
	
	//LoginBtn
	
	public static By loginBtn		= By.xpath("//input[@id='ctl01_loginbtnM']");
	
	//links
	
	public static By enrolNowLink		= By.linkText("Enrol Now");
	public static By forgotPasswordLink = By.linkText("Forgot Password? ");
	public static By contWithoutloginLink	= By.linkText("Continue without Login ");
	
	
	
	
}
