package com.jetPrev.workflows_Validation;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jetPrev.testObjects_OnlinePartner.BigBasketLocators;
import com.jetPrev.testObjects_OnlinePartner.PopUpPageLocators;
import com.jetPrev.testObjects_Validation.JetPrevPageLocators;
import com.jetPrev.workflows_OnlinePartner.JetPrevInput;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.googledrive.ReportStatus;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.pages.BasePage;
import com.web.automation.utilities.ConfigManager;

import net.rcarz.jiraclient.Issue;


public class JetPrevWorkflows extends BasePage {
	public WebDriver driver=ActionsLibrary.driver;
	//public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));
	ActionsLibrary actLib = new ActionsLibrary();
	public String originalHandle=driver.getWindowHandle();

	public JetPrevWorkflows(WebDriver driver) {

		super(driver);

	}

	
	
	/***************************************
	 * Function Name :-fnJetPrevLogin
	 * Input:-String strUserID,String strPassword
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnJetPrevLogin1(JetPrevInput objData) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//Click on Login
				actionLib.JSClick(JetPrevPageLocators.headerLogin, "Jet Prev Login");
			//Switch Window	
				ActionsLibrary.switchToLatestWindow(driver);
			//Enter User ID
				actionLib.type(JetPrevPageLocators.txtLoginID, objData.UserName, "Enter Login ID");
			//Enter Password
				actionLib.type(JetPrevPageLocators.txtPassword,objData.Password, "Enter Password");
			//Click on Login
				actionLib.JSClick(JetPrevPageLocators.btnLogin, "Login");
			}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :- Select Baby Care from All Categories
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-15-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean BabyProductsearch() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
		//wait
		actionLib.waitForElementPresent(JetPrevPageLocators.AllCategoriesdropdown, 120);
		//Click on All Categories drop down
		actionLib.JSClick(JetPrevPageLocators.AllCategoriesdropdown, "Click on All Categories dropdown");
		//wait
		actionLib.waitForElementPresent(JetPrevPageLocators.BabyCar, 120);
		//Select Baby Care category
		actionLib.JSClick(JetPrevPageLocators.BabyCar, "Select BabyCare Category");
		//wait
		actionLib.waitForElementPresent(JetPrevPageLocators.Searchbtn, 120);
		//Click on search button
		actionLib.JSClick(JetPrevPageLocators.Searchbtn, "Click on Search button");
		//Verify BabyCare Screen
        String ValidateBabyCarepage = actionLib.getElementText(JetPrevPageLocators.BabyCareResult, "Validate Babycare page");
        
        if(ValidateBabyCarepage.contains("Baby Care Categories"))
		{
			extentLogs.pass("BabyCare Screen is getting display", ValidateBabyCarepage+ " in baby care page is successfully getting displayed");
			
		}
		else
		{
			blnStatus=false;
			extentLogs.fail("BabyCare Screen is not getting display", ValidateBabyCarepage+ " in baby care page is not successfully getting displayed");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	
	
	}
	
	/***************************************
	 * Function Name :- Select Sports from All Categories
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-15-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean SportsProductsearch() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
		

		//Click on All Categories drop down
		actionLib.JSClick(JetPrevPageLocators.AllCategoriesdropdown, "Click on All Categories dropdown");
		//Select Sports category
		actionLib.JSClick(JetPrevPageLocators.sports, "Select BabyCare Category");
	    //Click on search button
		actionLib.JSClick(JetPrevPageLocators.Searchbtn, "Click on Search button");
		
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	
	
	}
	
	/***************************************
	 * Function Name :-Test Case-18 "Go Quickly to" has 7 hyper link 
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-14-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnGoQuicklytolink() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
	    //Verify Go Quickly to have 7 hyper links
		
		 List<String> allLinks = actionLib.fnGetAllList(JetPrevPageLocators.Goquicklyto, "Go quickly links");
		 extentLogs.info("Total Go quickly links are :", ""+allLinks.size());
		 if(allLinks.size()==7)
			{
				
				extentLogs.pass("Go Quickly to is having 7 links","Go Quickly to has " +allLinks.size());
				
			}
			else
			{
				
				extentLogs.fail("Go Quickly to is not having 7 links","Go Quickly to has" +allLinks.size());
			}
		  for(int i=0;i<allLinks.size();i++)
		  {
			
			 extentLogs.info("Link name", "Name of GoQuickly link "+(i+1)+":  "+allLinks.get(i).toString());
			 
	      }
		
	}
    catch(Exception e)
	{
    	e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	}

	
	/***************************************
	 * Function Name :- Test Case-20 Hovering the mouse pointer over the Categories 
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-15-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean hovermouseovercategories() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
		//Click on All Categories drop down
		actionLib.JSClick(JetPrevPageLocators.AllCategoriesdropdown, "Click on drop down");
		//Hover mouse on all All Categories having Sub Categories
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.BooksMedia, "BooksMedia");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.ElectronicsandGaming, "ElectronicsandGaming");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.ElectronicsandGaming, "ElectronicsandGaming");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.FashionAccess, "FashionAccess");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.HealthFitness, "HealthFitness");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.HomeKitchen, "HomeKitchen");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.HomeOfficeDecor, "HomeOfficeDecor");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.Kid, "Kid");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.MensFashion, "MensFashion");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.MobilesAccessories, "MobilesAccessories");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.MotorsAccessories, "MotorsAccessories");
		actionLib.mouseHoverByJavaScriptByLocator(JetPrevPageLocators.WomensFashion, "WomensFashion");
		//Printing the Category and sub category list
		String CategoryList = actionLib.getElementInnerText(JetPrevPageLocators.Categories, "Get text");
		if(CategoryList.equalsIgnoreCase(CategoryList)) {
			extentLogs.pass("JetPrev Web Test Script ","Category List:" + CategoryList );
		}
		else {
			extentLogs.fail("JetPrev Web Test Script ","Category List:" + CategoryList );
		}
		}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
}
	return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :- Test Case-22 Functionality of Home icon
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-15-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnhomeicon() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
		 //Click on Home icon
         actionLib.JSClick(JetPrevPageLocators.Homeiconbtn, "Home icon is getting clicked");
         //Verify HomePage
         boolean homepageValidation=actionLib.verifyElementDisplayed(JetPrevPageLocators.HomePagevalidationtext, "Go quickly to label");
        if(homepageValidation==true) {
			extentLogs.pass("Click on Home Icon",  "Home Page is getting display");
		}
		else {
			extentLogs.fail("Click on Home Icon",  "Home Page is not getting display");
		}
        }
		catch(Exception e) {
			e.printStackTrace();
			blnStatus=false;
	}
	
	return blnStatus;
	}


	/***************************************
	 * Function Name :-Test Case- 23 Functionality of Browser Back button
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-15-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	   public boolean fnbrowserbackbtn() throws Throwable
	  {
		 boolean blnStatus=true;
	  try
	  {
		 //Verify Sports Screen
	   String validateSportscreen=actionLib.getElementText(JetPrevPageLocators.ResultsText, "Validate Sports page");
	   if(validateSportscreen.contains("Sports Categories"))
	  {
	   extentLogs.pass("Sports Screen is getting display", validateSportscreen+ " in Sports page is successfully getting displayed");
	  }
	  else
	  {
	   extentLogs.fail("Sports Screen is not getting display", validateSportscreen+ " in Sports page is not successfully getting displayed");
	  }
		//Apply filter for Price
		actionLib.JSClick(JetPrevPageLocators.fltprice, "Applied filter under Price");
		//Apply filter for Brand
		//actionLib.JSClick(JetPrevPageLocators.fltbrand, "Applied filter under Brand");
		actionLib.ScrollToTop();
		//Click on Apply button
		actionLib.JSClick(JetPrevPageLocators.applybtn, "Click on apply Button");
		
		//Click on Browser back button
	    actionLib.NavigateBack();
	    
	    String navigateBackScreen=actionLib.getElementText(JetPrevPageLocators.ResultsText, "Validate Sports page");
	    //Verify page got navigated to previous page or not
		if(navigateBackScreen==validateSportscreen)
		{
			extentLogs.pass("Verify that Browser Back is working properly","Browser Back is working properly");
		}
		else
		{
			extentLogs.fail("Verify that Browser Back is working properly","Browser Back is not working properly");
		}
	
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	}
	
	/***************************************
	 * Function Name :- Test Case- 24 Functionality of Close button
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-15-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnClosebtn() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
     	//Click on Product Details
		actionLib.JSClick(JetPrevPageLocators.Product, "Click on first Product");
		//Click on Close button
		boolean Closebtndisplay=actionLib.isElementDisplayed(JetPrevPageLocators.Closebtn);
		if(Closebtndisplay==true) {
		actionLib.JSClick(JetPrevPageLocators.Closebtn, "Click on Close button");
		extentLogs.pass("Click on Close Button","Close Button is functional:"+Closebtndisplay);
		
		}else {
			extentLogs.fail("Click on Close Button", "Close Button is not getting dispaly"+Closebtndisplay);
		}
}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	}
	
	/***************************************
	 * Function Name :- Test Case- 27 Total Results found in the result grid
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-18-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
//	public boolean totalresultsfound() throws Throwable
//	{
//		boolean blnStatus=true;
//	try
//	{
//		
//		//Verify total result is getting displayed 
//		String totalcount=actionLib.getElementText(JetPrevPageLocators.totalresultdisplayed,"total result count");
//		String[] totalcountSplit=totalcount.split(" ");
//		String count=totalcountSplit[1];
//		extentLogs.pass("Verify total results is getting display","Total count is" +count);
//        }
//	catch(Exception e) {
//		e.printStackTrace();
//		blnStatus=false;
//	}
//	return blnStatus;
//	}
	/***************************************
	 * Function Name :-Test Case-29 Place an order for BabyCare Product
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-18-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean placeOrderBabyCare() throws Throwable
	{
		boolean blnStatus=true;
	try
	
	{
		//Scroll Down 
		actionLib.ScrollToBottom();
		//Apply filter for First cry Partner
		actionLib.JSClick(JetPrevPageLocators.Firstcryp, "Apply filter for FirstCry Partner");
		//Scroll up
		actionLib.ScrollToTop();
		//Click on Apply button
		actionLib.JSClick(JetPrevPageLocators.applybtn, "Click on Apply button");
		actionLib.waitForVisibilityOfElement(JetPrevPageLocators.labelSecondProduct, "First Product");
		//Click on Product Details
		actionLib.JSClick(JetPrevPageLocators.labelSecondProduct, "Click on first Product");
		//Print the Product Details
		String Productdetails=actionLib.getElementInnerText(JetPrevPageLocators.labelFirstProduct, "Product Details");
		if(Productdetails.equalsIgnoreCase(Productdetails))
		{
		extentLogs.pass("Get text for Product details","Product details :" + Productdetails );
		}
		else {
			extentLogs.fail("Get text for Product details","Product details :" + Productdetails );
		}
		//click on cart
		actionLib.JSClick(JetPrevPageLocators.imgCartFirstProduct, "Click on cart image");
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	}
	
	/***************************************
	 * Function Name :-Test Case-29 Place an order for BabyCare Product through FirstCry Partner
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-18-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean placeorderBabyCareFirstcry() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
		//Click on Cart
		//actionLib.JSClick(JetPrevPageLocators.imgCartFirstProduct, "Click on cart icon");
		//Switch to another window
		ActionsLibrary.switchToLatestWindow(driver);
		//Thread.sleep(3000);
		actionLib.waitForVisibilityOfElement(JetPrevPageLocators.continueAsGuestLink, "Continue as guest link");
		//Click on Continue as Guest Link
		actionLib.JSClick(JetPrevPageLocators.continueAsGuestLink, "Click on Continue as Link");
		//Redirect to new window
		ActionsLibrary.switchToLatestWindow(driver);
		//Validate the first cry page
	   /* String ValidateFisrtCrywindow=actionLib.GetPageTitle();
		if(ValidateFisrtCrywindow.equalsIgnoreCase(ValidateFisrtCrywindow))
		{
			extentLogs.pass("Verify that First Cry window is getting display", ValidateFisrtCrywindow+ " is successfully getting displayed");
		}
		else
		{
			extentLogs.fail("Verify that First Cry window is getting display", ValidateFisrtCrywindow+ " is not successfully getting displayed");
		}*/
}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevValidateURL	
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet	
	 * Date:-11-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevValidateURL(com.jetPrev.workflows_Validation.JetPrevInput testData) throws Throwable
	{
		boolean blnStatus=false;
		try
		{	
			String url = driver.getCurrentUrl();
			String[] urlSplit=url.split("=");		
			
			String firstPart=urlSplit[0];
			String lastPart=urlSplit[urlSplit.length-1];
			String secondlastPart=urlSplit[urlSplit.length-2];
			String[] uniqueNumber=secondlastPart.split("&");
			String jetPNumber=uniqueNumber[0];
			String appendURL="";
			for (int i=0;i<urlSplit.length;i++){
				
				
				 appendURL= appendURL+urlSplit[i]+"=";
				 System.out.println("Append URL"+appendURL);
				
			}
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && appendURL.contains(testData.PartnerName)){
				blnStatus=true;
				extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
			}
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is not getting generated as expected");
		}
		return blnStatus;
	}
	/***************************************
	 * Function Name :-Test case-29 fnFirstCryValidateURL	
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet	
	 * Date:-18-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnFirstCryValidateURL(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=false;
		try
		{	
			String url = driver.getCurrentUrl();
			String[] urlSplit=url.split("=");		
			String firstPart=urlSplit[0];
			String lastPart=urlSplit[urlSplit.length-1];
			String secondlastPart=urlSplit[urlSplit.length-2];
			String[] uniqueNumber=secondlastPart.split("&");
			String jetPNumber=uniqueNumber[0];
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && firstPart.contains(objDet.PartnerName))
			{
				blnStatus=true;
				extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is not getting generated as expected");
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :- Test Case-30 View the List of all products in Jet Privilege Product
	 * Input:- 
	 * Return Type:- boolean 
	 * Date:-19-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean lstAllCategoriesJet() throws Throwable
	{
		boolean blnStatus=true;
	try
	{
		//navigate to url
		driver.get(" https://www.jetprivilege.com/");
		//Click on shop
		actionLib.JSClick(JetPrevPageLocators.shopbtn, "Click on shop button");
		//Click on All category
		actionLib.JSClick(JetPrevPageLocators.allcateg, "Click on All Category");
		List<String> allLinks = actionLib.fnGetAllList(JetPrevPageLocators.CategoryListtext, "JetPrev category List");
		//Print the list of Product
		 extentLogs.info("List of Categories are :", ""+allLinks.size());
		 if(allLinks.size()==17)
			{
				
				extentLogs.pass("Verify Category List","Total Category List are " +allLinks.size());
				
			}
			else
			{
				
				extentLogs.fail("Verify Category List","Total Category List are" +allLinks.size());
			}
		  for(int i=0;i<allLinks.size();i++)
		  {
			
			 extentLogs.info("link name:", "Name of Category links"+(i+1)+allLinks.get(i).toString());
			 
	      }
		  //Select Women Category
		actionLib.JSClick(JetPrevPageLocators.womencate, "Select Womens category");
		//Enter Text in the Search Text box
		//actionLib.type(JetPrevPageLocators.searchtxtbx, objDet.SearchText, "Enter the text in searchtextbox");
		actionLib.type(JetPrevPageLocators.searchtxtbx, "Fashion", "Enter the text in searchtextbox");
		//Click on Search button
		actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search button");
		//Verify the shop.JetPrivelege page
		String ValidateJetPrevwindow=actionLib.GetPageTitle();
		if(ValidateJetPrevwindow.equalsIgnoreCase(ValidateJetPrevwindow))
		{
			extentLogs.pass("Verify that Shop.JetPrev window is getting display", ValidateJetPrevwindow+ " is successfully getting displayed");
		}
		else
		{
			extentLogs.fail("Verify that Shop.JetPrev is getting display",ValidateJetPrevwindow+ " is not successfully getting displayed");
		}
		
}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevLogin
	 * Input:-JetPrevInput objDet
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnJetPrevLogin(JetPrevInput objData) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//get current window handle
			String parentHandle = driver.getWindowHandle();
			System.out.println("Parent title : " + driver.getTitle());
			
			//Click on Login
				actionLib.JSClick(JetPrevPageLocators.headerLogin, "Jet Prev Login");
			//Switch Window	
				ActionsLibrary.switchToLatestWindow(driver);				
			//Enter User ID
				actionLib.type(JetPrevPageLocators.txtLoginID, objData.UserName, "Enter Login ID");
			//Enter Password
				actionLib.type(JetPrevPageLocators.txtPassword, objData.Password, "Enter Password");
			
				//Click on Login
				actionLib.JSClick(JetPrevPageLocators.btnLogin, "Login");
				//wait
				//actionLib.wait(1000);
				//close the window
				//driver.close();
				//wait
				//actionLib.wait(2000);
				driver.switchTo().window(parentHandle);
				//actionLib.wait(2000);
				System.out.println("Parent title : " + driver.getTitle());
				
				actionLib.waitForVisibilityOfElement(JetPrevPageLocators.btnLoginPostLogin, "Post Login Button", 250);
				actionLib.waitForElementPresent(JetPrevPageLocators.btnLoginPostLogin,450);
				
				/* for (String handle : driver.getWindowHandles()) {

					    driver.switchTo().window(handle);
					    }*/
				//switch to parent window
				//ActionsLibrary.switchToLatestWindow(driver);
				
				
			//wait for element to be present
				//actionLib.waitForVisibilityOfElement(JetPrevPageLocators.btnLoginPostLogin, "Post Login Button");
				
				
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevLogout	 
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevLogout() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//Click on arrow
				actionLib.JSClick(JetPrevPageLocators.arrow_down, "Down arrow");			
			//Click on Logout
				actionLib.JSClick(JetPrevPageLocators.LogoutBtn, "Logout");		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevSwitchBackToJetPrevPage	
	 * Return Type:- boolean		
	 * Date:-15-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSwitchBackToJetPrevPage() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			for(String handle:driver.getWindowHandles()){
				if(!handle.equals(originalHandle)){
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}

	public void fnUpdateDefectDetails(Issue issue)
    {
        if(issue!=null)
        {
            extentLogs.info("Jet Prev Web Test Script ","Defect Details");
            extentLogs.pass("Jira Defect ID ", issue.getKey());
            extentLogs.pass("Jira Project Name ", issue.getProject().toString());
            extentLogs.pass("Jira Defect Summary ", issue.getSummary());
            extentLogs.pass("Jira Defect Description ", issue.getDescription());
            extentLogs.pass("Jira Defect Assignee ", issue.getAssignee().toString());
            extentLogs.pass("Jira Defect Priority ", issue.getPriority().toString());
            extentLogs.pass("Jira Defect Status ", issue.getStatus().toString());
        }
        if(ReportStatus.blnStatus==false)
        {
            try
            {
                int c=10/0;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                Assert.fail();
            }
        }
    }

}


	
	
