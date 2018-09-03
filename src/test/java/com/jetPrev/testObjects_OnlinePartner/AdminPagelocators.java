package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class AdminPagelocators {
	//url
	public static String url="https://jpplshopadmin.vernost.in/afadmin";
	
	//user credentials
	public static By userName=By.xpath("//input[@id='userName']");
	public static By password=By.xpath("//input[@id='password']");
	public static By btnLogin=By.xpath("//a[text()='Login']");

	//Report label
	public static By labelReprt=By.xpath("//a[text()='Reports']");
	public static By labelTransaction=By.xpath("//a[text()='Transaction']");
	
	//textBox
	public static By txtJPNumber=By.xpath("//input[@id='inputMemberId']");
	
	//search button
	public static By btnSearch=By.xpath("//input[@id='search_btn']");
	
	//transactionDate
	public static By labelTransactionDate=By.xpath("//table[@class=' partner_info_table table-bordered ']/tbody/tr[1]/td[1]");
	
	public static By lblTransactionDate(String partnerName)
	{
		return By.xpath("(//tr[@class='super_admin']/td[text()='"+partnerName+"']/preceding-sibling::td)[1]");
	}
	
	
	//expected date of credit
	public static By labelExpectedDateOfCredit=By.xpath("//table[@class=' partner_info_table table-bordered ']/tbody/tr[1]/td[7]");
	
	public static By lblExpectedDateOfCredit(String partnerName){
		return By.xpath("(//tr[@class='super_admin']/td[text()='"+partnerName+"']/following-sibling::td[5])[1]");
	}
	//partner name	
		public static By labelPartnerName=By.xpath("//table[@class=' partner_info_table table-bordered ']/tbody/tr[1]/td[2]");
		
		//logout button
		public static By btnLogout=By.xpath("//a[text()='Logout']");
	
}
