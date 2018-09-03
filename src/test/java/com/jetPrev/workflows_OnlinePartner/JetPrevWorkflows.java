package com.jetPrev.workflows_OnlinePartner;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.jetPrev.testObjects_OnlinePartner.AdminPagelocators;
import com.jetPrev.testObjects_OnlinePartner.AmazonLocators;
import com.jetPrev.testObjects_OnlinePartner.BigBasketLocators;
import com.jetPrev.testObjects_OnlinePartner.FirstCryLocators;
import com.jetPrev.testObjects_OnlinePartner.FlipkartLocators;
import com.jetPrev.testObjects_OnlinePartner.HappilyUnmarried;
import com.jetPrev.testObjects_OnlinePartner.JetPrevPageLocators;
import com.jetPrev.testObjects_OnlinePartner.LenskartLocators;
import com.jetPrev.testObjects_OnlinePartner.MyntraLocators;
import com.jetPrev.testObjects_OnlinePartner.NykaaLocators;
import com.jetPrev.testObjects_OnlinePartner.PopUpPageLocators;
import com.jetPrev.testObjects_OnlinePartner.SearchResults;
import com.jetPrev.testObjects_OnlinePartner.TataCliqLocators;
import com.jetPrev.testObjects_OnlinePartner.UrbanLadderLocators;
import com.jetPrev.testObjects_OnlinePartner.WoohooLocators;
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
	 * Input:-JetPrevInput objDet
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnJetPrevLogin(JetPrevInput objDet) throws Throwable
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
			//wait
			actionLib.waitForVisibilityOfElement(JetPrevPageLocators.txtLoginID, "Login ID", 2000);
			//Enter User ID
			actionLib.type(JetPrevPageLocators.txtLoginID, objDet.UserName, "Enter Login ID");
			//Enter Password
			actionLib.type(JetPrevPageLocators.txtPassword, objDet.Password, "Enter Password");

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

			actionLib.waitForVisibilityOfElement(JetPrevPageLocators.btnLoginPostLogin, "Post Login Button", 2000);
			actionLib.waitForElementPresent(JetPrevPageLocators.btnLoginPostLogin,200);

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
			extentLogs.fail("JetPrev Web Test Script ","Login Fail");
		}
		return blnStatus;
	}
	

	/***************************************
	 * Function Name :-fnJetPrevLogin1
	 * Input:-JetPrevInput objDet
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Moutusi
	 * @throws Throwable 
	 */
	public boolean fnJetPrevLogin1(JetPrevInput objDet) throws Throwable
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
				actionLib.type(JetPrevPageLocators.txtLoginID, objDet.UserName, "Enter Login ID");
			//Enter Password
				actionLib.type(JetPrevPageLocators.txtPassword, objDet.Password, "Enter Password");
			
				//Click on Login
				actionLib.JSClick(JetPrevPageLocators.btnLogin, "Login");
				
				//close the window
				//driver.close();
				//wait
				//actionLib.wait(2000);
				//driver.switchTo().window(parentHandle);
				//actionLib.wait(2000);
				//System.out.println("Parent title : " + driver.getTitle());
				driver.navigate().to("https://shop.jetprivilege.com/home");
				driver.manage().window().maximize();
				actionLib.waitForVisibilityOfElement(JetPrevPageLocators.btnLoginPostLogin, "Post Login Button", 450);
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
			extentLogs.fail("JetPrev Web Test Script ","Login Fail");
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
			extentLogs.fail("JetPrev Web Test Script ","Logout Fail ");
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevAdminLogin	 
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet
	 * Date:-22-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevAdmin(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//navigate to admin site
			driver.get(AdminPagelocators.url);
			//type user name
			actionLib.type(AdminPagelocators.userName,objDet.AdminUserName ,"Enter Login ID");
			//type password
			actionLib.type(AdminPagelocators.password,objDet.AdminPassword ,"Enter Password");			
			//Click on Login
			actionLib.JSClick(AdminPagelocators.btnLogin, "Login");		
			//wait for label transaction
			actionLib.waitForVisibilityOfElement(AdminPagelocators.labelTransaction, "Transaction label", 60);
			//click on label transaction
			actionLib.JSClick(AdminPagelocators.labelTransaction, "Click on Transaction");
			//wait for JPNumberTextBox
			actionLib.waitForVisibilityOfElement(AdminPagelocators.txtJPNumber, "JP Number Text Box", 60);
			//type JPNumber
			actionLib.type(AdminPagelocators.txtJPNumber,objDet.UserName ,"Enter JP Number");
			//click on search button
			actionLib.JSClick(AdminPagelocators.btnSearch, "Click on Search");
			//wait
			if(actionLib.waitForVisibilityOfElement(AdminPagelocators.lblTransactionDate(objDet.AdminPartnerName), "Partner Name", 60)){
				extentLogs.info("JP Miles", "Record is present for partner"+objDet.AdminPartnerName);
				blnStatus=true;
			}
			else{
				extentLogs.fail("JP Miles", "Record is not present for partner "+objDet.AdminPartnerName);
				blnStatus=false;
			}
			//get transaction date
			String transactionDate=actionLib.getElementText(AdminPagelocators.lblTransactionDate(objDet.AdminPartnerName), "TransactionDate");
			//Date dateTransactionDate=new SimpleDateFormat("dd/mm/yyyy").parse(transactionDate);
			Date dateTransactionDate=new SimpleDateFormat("dd/MM/yyyy").parse(transactionDate);
			//DateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
			//Date d=format.format(transactionDate);
			//expectedDateOfCredit
			String expectedDateOfCredit=actionLib.getElementText(AdminPagelocators.lblExpectedDateOfCredit(objDet.AdminPartnerName), "Expected Date Of Credit");
			Date dateExpectedDateOfCredit=new SimpleDateFormat("dd/MM/yyyy").parse(expectedDateOfCredit);
			
			//Date UserDerivedExpectedDate=
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(dateTransactionDate);
			c.add(Calendar.DATE, 75); // Adding 75 days
			String UserDerivedExpectedDate = sdf.format(c.getTime());
			Date dateUserDerivedExpectedDate=new SimpleDateFormat("dd/mm/yyyy").parse(UserDerivedExpectedDate);
			
			if(expectedDateOfCredit.equals(UserDerivedExpectedDate)){
				extentLogs.pass("Earned JP miles", "Earned JPMiles are getting credited within 75 days from the transaction date ");
				blnStatus=true;
			}
			else{
				extentLogs.fail("Earned JP miles", "Earned JPMiles are not getting credited within 75 days from the transaction date ");
				blnStatus=false;
			}
			
			actionLib.JSClick(AdminPagelocators.btnLogout, "Logout from admin page");
			
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("Earned JP miles", "Earned JPMiles are not getting credited within 75 days from the transaction date ");
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevSearch
	 * Input:-String JetPrevInput objDet
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSearch(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
		
		//Enter searchText
			actionLib.type(JetPrevPageLocators.searchTextBox, objDet.SearchText, "Enter the text in searchtextbox");
		//Click on search
			actionLib.JSClick(JetPrevPageLocators.searchBtn, "Search");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevOnlinePartner	
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevOnlinePartner() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
		
			//Click on search
			//actionLib.JSClick(JetPrevPageLocators, "Search");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevSelectFirstSearchedProduct	
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSelectFirstSearchedProduct() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
		
			//Click on searched product description
			actionLib.JSClick(SearchResults.searchPagefirstResult, "Select First Searched Product");
			//Click on partner icon
			actionLib.JSClick(SearchResults.partnerIcon, "Click on partner icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.ProceedBtn, "Click on proceed button");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToPartnerSite	
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToPartnerSite() throws Throwable
	{
		boolean blnStatus=true;
		try
		{
		
			//Click on searched product description
			actionLib.JSClick(SearchResults.searchPagefirstResult, "Select First Searched Product");
			//Click on partner icon
			actionLib.JSClick(SearchResults.partnerIcon, "Click on partner icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.ProceedBtn, "Click on proceed button");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSite	
	 * Return Type:- boolean	
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSite() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	//scroll down
			//Thread.sleep(10000);
			/*try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,200);");
			} catch (Exception e) {
			}*/
			//actLib.waitForElementPresent(JetPrevPageLocators.amazon,100);
			//Thread.sleep(20000);
			//wait
			actLib.waitForElementPresent(JetPrevPageLocators.amazon, 1500);
			//Click on partner icon
			if(actionLib.JSClick(JetPrevPageLocators.amazon, "Click on amazon icon")){
				extentLogs.pass("TC0002:Step 2_Click on for a Amazon.in ", "Icon for Amazon.in clicked successfully");
			}
			else{
				extentLogs.fail("TC0002:Step 2_Click on for a Amazon.in ", "Icon for Amazon.in not clicked");
			}
				
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			extentLogs.pass("TC0002:Step3_Popup window showing  Tips To Earn JPMiles on your Purchase ", "Popup window showing  Tips To Earn JPMiles on your Purchase is launched successfully");
			actLib.waitForElementPresent(PopUpPageLocators.ProceedBtn, 1500);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.ProceedBtn, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			extentLogs.pass("TC0002:Step5_Check partner site is getting open in new tab  ", "partner site is getting open in new tab");
			//wait
			actionLib.waitForVisibilityOfElement(AmazonLocators.txtSearch, "Search Text Box", 9000);
			//actLib.waitForElementPresent(AmazonLocators.txtSearch, 40000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script", "Redirection fail");
		}
		return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteFlipkart	
	 * Return Type:- boolean	
	 * Date:-12-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteFlipkart() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	//scroll down
		//	Thread.sleep(10000);
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,200);");
			} catch (Exception e) {
			}
			
			//Thread.sleep(5000);
			//wait for partner icon
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.flipkart, "Flipkart icon", 2500);
			//actionLib.waitForElementPresent(JetPrevPageLocators.flipkart, 50);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.flipkart, "Click on flipkart icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			actLib.waitForVisibilityOfElement(PopUpPageLocators.btnProceedFlipkart, "Proceed to Partner Flipkart ", 2500);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedFlipkart, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			/*String url = driver.getCurrentUrl();
			
			int url_len = url.length();
				*/
			//Thread.sleep(5000);
			ActionsLibrary.switchToLatestWindow(driver);
			actionLib.waitForVisibilityOfElement(FlipkartLocators.BtnClosePopUp, "Close Pop Up Button", 6000);
			//actionLib.waitForElementPresent(FlipkartLocators.BtnClosePopUp, 9000);
			
			//close the pop up
			actionLib.JSClick(FlipkartLocators.BtnClosePopUp, "Click on X to close the pop up");
			//wait
			actionLib.waitForVisibilityOfElement(FlipkartLocators.txtSearch, "Search Text Box", 6000);
			
			//actionLib.waitForElementPresent(FlipkartLocators.txtSearch, 9000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail" );
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevProceedToOnlinePartnerSiteFlipkart	
	 * Return Type:- boolean	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevProceedToOnlinePartnerSiteFlipkart() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	//scroll down
			//Thread.sleep(10000);
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,200);");
			} catch (Exception e) {
			}
			
			
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			actionLib.waitForElementPresent(PopUpPageLocators.btnProceedFlipkart, 2000);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedFlipkart, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			/*String url = driver.getCurrentUrl();
			
			int url_len = url.length();
				*/
			Thread.sleep(5000);
			//ActionsLibrary.switchToLatestWindow(driver);
			//actionLib.waitForElementPresent(FlipkartLocators.BtnClosePopUp, 30);
			
			//close the pop up
			//actionLib.JSClick(FlipkartLocators.BtnClosePopUp, "Click on X to close the pop up");
			actionLib.waitForVisibilityOfElement(FlipkartLocators.txtSearch,"Search Text Box", 6000);
			actionLib.waitForElementPresent(FlipkartLocators.txtSearch, 7000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail" );
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevProceedToOnlinePartnerSiteFlipkart	
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSearchProduct(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			//wait
			actionLib.waitForVisibilityOfElement(JetPrevPageLocators.searchTextBox, "Search Text box", 2000);
			//enter value in search text box
			actionLib.type(JetPrevPageLocators.searchTextBox, objDet.SearchText, "Type value in search text box");
			//click on search button
			actionLib.JSClick(JetPrevPageLocators.searchBtn, "Click on Search");
			//wait
			actionLib.waitForVisibilityOfElement(JetPrevPageLocators.labelSearchResultsFound, "Search Results", 2000);
			//actionLib.waitForElementPresent(JetPrevPageLocators.labelSearchResultsFound, 180);
			//actionLib.waitForVisibilityOfElement(JetPrevPageLocators.checkBoxFlipkartPartner, "Check box", 180);
			//click on checkbox against Flipkart
			actionLib.JSClick(JetPrevPageLocators.checkBoxFlipkartPartner, "Click on checkbox for Flipkart");
			//click on Apply button
			actionLib.JSClick(JetPrevPageLocators.btnApply, "Click on Apply button");
			//wait
			actionLib.waitForVisibilityOfElement(JetPrevPageLocators.labelFirstProduct, "Searched product", 2000);
			//click on first searched product
			actionLib.JSClick(JetPrevPageLocators.labelFirstProduct, "Click on first searched product");
			//wait
			actionLib.waitForVisibilityOfElement(JetPrevPageLocators.imgCartFirstProduct, "Cart icon", 2000);
			//click on cart to proceed to partner site Flipkart
			actionLib.JSClick(JetPrevPageLocators.imgCartFirstProduct, "Click on cart icon");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Search Fail");
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevSearchProductOnAmazonSite	
	 * Return Type:- boolean	
	 * Input:-JetPrevInput objDet
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSearchProductOnAmazonSite(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			//wait
			//wait for check box
			actLib.waitForVisibilityOfElement(AmazonLocators.txtSearch, "Text Box", 15000);
			
			//actLib.waitForElementPresent(AmazonLocators.txtSearch, 15000);
			//type text in searchTextBox
			actionLib.type(AmazonLocators.txtSearch, objDet.SearchText, "Enter the text in searchtextbox");			
			//click on search button
			actionLib.JSClick(AmazonLocators.btnSearch, "Search");
			//wait
			actLib.waitForElementPresent(AmazonLocators.checkBoxFilterCOD, 15000);
			//click on COD option
			actionLib.JSClick(AmazonLocators.checkBoxFilterCOD, "Select COD checkbox");
			//Click on searched product description
			//actionLib.JSClick(AmazonLocators.firstSearchResult, "Select First Searched Product");
			//wait
			actLib.waitForVisibilityOfElement(AmazonLocators.linksearchresult, "Searched Product", 15000);
			//actLib.waitForElementPresent(AmazonLocators.linksearchresult, 15000);
			actionLib.JSClick(AmazonLocators.linksearchresult, "Select First Searched Product");
			
			//Redirect to new tab
			ActionsLibrary.switchToLatestWindow(driver);
			extentLogs.pass("TC0002:Step7_Ensure that user is able to view the product specification in the Amazon.in site ", "User is able to view the product specification in the Amazon.in site ");
			actLib.waitForVisibilityOfElement(AmazonLocators.btnBuyNow,"Buy Now button", 15000);
			//actLib.waitForElementPresent(AmazonLocators.btnBuyNow, 15000);
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Search Fail");
			
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevPlaceOrderOnAmazonSite	
	 * Return Type:- boolean	
	 * Input:-JetPrevInput objDet
	 * Date:-08-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevPlaceOrderOnAmazonSite(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		{	actLib.waitForElementPresent(AmazonLocators.btnBuyNow, 7000);
			//click on BuyNow button
			actionLib.JSClick(AmazonLocators.btnBuyNow, "Buy Now");
			//Click on searched product description
			//actionLib.JSClick(AmazonLocators.firstSearchResult, "Select First Searched Product");
			/*//Redirect to new tab
			ActionsLibrary.switchToLatestWindow(driver);*/
			//check if login is required
			if(driver.getCurrentUrl().contains("signin")){
				//wait
				actLib.waitForVisibilityOfElement(AmazonLocators.txtEmail,"Email", 5000);
				//actLib.waitForElementPresent(AmazonLocators.txtEmail, 7000);
			//enter email/phone number
			actionLib.type(AmazonLocators.txtEmail, objDet.AmazonUserName, "Enter email id or phone number");
			//wait
			actLib.waitForVisibilityOfElement(AmazonLocators.btnContinue,"Continue button", 5000);
			//actLib.waitForElementPresent(AmazonLocators.btnContinue,7000);
			//click on continue button
			actionLib.JSClick(AmazonLocators.btnContinue, "Click on Continue button");
			//wait
			actLib.waitForVisibilityOfElement(AmazonLocators.txtPassword,"Password", 5000);
			//actLib.waitForElementPresent(AmazonLocators.txtPassword, 8000);
			//enter email/phone number
			actionLib.type(AmazonLocators.txtPassword, objDet.AmazonPassword, "Enter password");
			//wait
			actLib.waitForVisibilityOfElement(AmazonLocators.btnLogin,"Login button", 5000);
			//actLib.waitForElementPresent(AmazonLocators.btnLogin, 7000);
			//click on login button
			actionLib.JSClick(AmazonLocators.btnLogin, "Click on login button");
			}
			actLib.waitForVisibilityOfElement(AmazonLocators.btnDeliverToThisAddress,"Deliver To This Address button", 5000);
			//actLib.waitForElementPresent(AmazonLocators.btnDeliverToThisAddress, 7000);
			//click on Deliver to this address
			actionLib.JSClick(AmazonLocators.btnDeliverToThisAddress, "Click Deliver to this Address");
			actLib.waitForVisibilityOfElement(AmazonLocators.radioBtnCOD,"COD radio button", 5000);
			//actLib.waitForElementPresent(AmazonLocators.radioBtnCOD, 7000);
			//click on COD radio button
			actionLib.JSClick(AmazonLocators.radioBtnCOD, "Select COD radio button");
			actLib.waitForElementPresent(AmazonLocators.btnContinueOrderPg, 7000);
			//click on Continue button
			actionLib.JSClick(AmazonLocators.btnContinueOrderPg, "Select continue button");
			extentLogs.pass("TC0002:Step7_Verify that user is able to place order for any product on Amazon.in web site using Cash on Delivery", "User is able to place order for any product on Amazon.in web site using Cash on Delivery");
			//wait for Place Order button
			actLib.waitForVisibilityOfElement(AmazonLocators.btnPlaceYourOrder,"Place Order", 15000);
			
			actLib.waitForElementPresent(AmazonLocators.btnPlaceYourOrder, 15000);
			//click on Place your order button
			actionLib.JSClick(AmazonLocators.btnPlaceYourOrder, "Place you order");
			//Thread.sleep(10000);
			
			/*
			for(String handle:driver.getWindowHandles()){
				if(!handle.equals(originalHandle)){
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);*/
			
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Place Order fail" );
		}
		return blnStatus;
	}

	
	/***************************************
	 * Function Name :-fnJetPrevValidateURL1	
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet	
	 * Date:-11-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevValidateURL1(JetPrevInput objDet) throws Throwable
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
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && firstPart.contains(objDet.PartnerName)){
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
	 * Function Name :-fnJetPrevValidateURL	
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet	
	 * Date:-11-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevValidateURL(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=false;
		try
		{	
			String url = driver.getCurrentUrl();
			System.out.println("url::::::::"+url);
			
			String[] urlSplit=url.split("=");		
			
			//String firstPart=urlSplit[0];
			String lastPart=urlSplit[urlSplit.length-1];
			String secondlastPart=urlSplit[urlSplit.length-2];
			String[] uniqueNumber=secondlastPart.split("&");
			String jetPNumber=uniqueNumber[0];
			String appendURL="";
			for (int i=0;i<urlSplit.length;i++){
				
				
				 appendURL= appendURL+urlSplit[i]+"=";
				 System.out.println("Append URL"+appendURL);
				
			}
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && appendURL.contains(objDet.PartnerName)){
				blnStatus=true;
				extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
			}
			else{
				blnStatus=false;
				extentLogs.fail("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is not getting generated as expected");
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
	 * Function Name :-fnJetPrevValidateURL	
	 * Return Type:- boolean
	 * Input:-JetPrevInput objDet	
	 * Date:-11-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevValidateURLForPartner(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=false;
		try
		{	
			String url = driver.getCurrentUrl();
			String inputURL=objDet.PartnerName;
			
			if(url.contains(inputURL)){
				System.out.println("Matched");
			}else{
				System.out.println("Not matching");
			}
			
			//String s1="javatpoint is a very good website";  
			String replaceString=url.replace(inputURL, "");//replaces all occurrences of 'a' to 'e'
			
			
			System.out.println(replaceString);  
			if(replaceString.length()>20)
			{
				String s[]=replaceString.split("&");
				System.out.println(s[0]);
				String expValue=s[0];
				System.out.println(expValue.length());
				if(expValue.length()==19)
				{
					System.out.println("Length is 19");
				}else{
					System.out.println("Length is not 19");
				}
				//System.out.println(s[1]);
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
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteFirstCry	
	 * Return Type:- boolean	
	 * Date:-12-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteFirstCry() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	//scroll down
			//Thread.sleep(10000);
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,200);");
			} catch (Exception e) {
			}
			
			//Thread.sleep(3000);
			actionLib.waitForElementPresent(JetPrevPageLocators.firstcry, 1500);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.firstcry, "Click on first cry icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			actionLib.waitForElementPresent(PopUpPageLocators.btnProceedFirstCry, 2500);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedFirstCry, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			
			//Thread.sleep(3000);
			//ActionsLibrary.switchToLatestWindow(driver);
			//actionLib.waitForElementPresent(FirstCryLocators.btnFCClosePopUp, 7000);
			
			//close the pop up
			//actionLib.JSClick(FirstCryLocators.btnFCClosePopUp, "Close the pop up");
			actionLib.waitForVisibilityOfElement(FirstCryLocators.txtFCSearch, "Search Text Box", 6000);
			//actionLib.waitForElementPresent(FirstCryLocators.txtFCSearch, 9000);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail");
		}
		return blnStatus;
	}

	/***************************************
	 * Function Name :-fnJetPrevPlaceOrderOnFirstCrySite	
	 * Return Type:- boolean	
	 * Date:-12-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevPlaceOrderOnFirstCrySite(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		
		{	//wait 
			actionLib.waitForElementPresent(FirstCryLocators.txtFCSearch, 10);
			//navigate to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//click on close button
			actionLib.JSClick(FirstCryLocators.btnFCClosePopUp, "Close pop up");
			
			//type text in searchTextBox
			actionLib.type(FirstCryLocators.txtFCSearch, objDet.SearchText, "Enter the text in searchtextbox");
			//click on search button
			actionLib.JSClick(FirstCryLocators.btnFCSearch, "Search");			
			//Add to bag on searched product description
			actionLib.JSClick(FirstCryLocators.addToCartFCfirstSearchedProduct, "Add to cart First Searched Product");
			//navigate to another window			
			ActionsLibrary.switchToLatestWindow(driver);
			//click on Place Order button
			actionLib.JSClick(FirstCryLocators.btnFCPopUpPlaceOrder, "Place Order");
			
			//enter email/phone number
			actionLib.type(FirstCryLocators.txtFCEmailId,objDet.FlipkartUserName, "Enter email id");
			//click on first radio btn button
			actionLib.JSClick(FirstCryLocators.radiobtnFirstCryAccount, "Click on Password not required radio button");
			//click on continue button
			actionLib.JSClick(FirstCryLocators.btnFCContinue, "Click on Continue button");
			//enter first name
			actionLib.type(FirstCryLocators.txtFCFirstName, "test", "Enter First Name");
			//enter AddressLine1
			actionLib.type(FirstCryLocators.txtFCAddressLine1, "test", "Enter Address Line 1");
			//enter AddressLine2
			actionLib.type(FirstCryLocators.txtFCAddressLine2, "test", "Enter Address Line 2");
			//enter Landmark
			actionLib.type(FirstCryLocators.txtFCLandmark, "test", "Enter Landmark");
			//enter pincode
			actionLib.type(FirstCryLocators.txtFCPinCode, "500081", "Enter pincode");			
			//enter phone number
			actionLib.type(FirstCryLocators.txtFCMobileNo, objDet.AmazonUserName, "Enter phone number");
			//click on use this address button
			actionLib.JSClick(FirstCryLocators.btnFCUseThisAddress, "Click on Use This Address button");
			//click on  Final Payment button
			actionLib.JSClick(FirstCryLocators.btnFCFinalPayment, "Click on Final Payment button");
			//click on COD radio btn
			actionLib.JSClick(FirstCryLocators.radioBtnFCCOD, "Click on COD radio button");
			//click on  FinalPlace Order button
			actionLib.JSClick(FirstCryLocators.btnFCPlaceFinalOrder, "Click on Final Place Order button");
			
			
			
			//click on Deliver to this address
			actionLib.JSClick(AmazonLocators.btnDeliverToThisAddress, "Click Deliver to this Address");
			//click on COD radio button
			actionLib.JSClick(AmazonLocators.radioBtnCOD, "Select COD radio button");
			//click on Continue button
			actionLib.JSClick(AmazonLocators.btnContinueOrderPg, "Select continue button");
			//click on Place your order button
			//actionLib.JSClick(AmazonLocators.btnPlaceYourOrder, "Place you order");
			
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}

	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteBigBasket	
	 * Return Type:- boolean	
	 * Date:-13-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteBigBasket() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	//scroll down
			//Thread.sleep(10000);
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,200);");
			} catch (Exception e) {
			}
			
			//wait
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.arrowMark, "Arrow mark", 1500);
			//click on arrow mark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			//Thread.sleep(30000);
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.bigbasket, "Big basket icon", 1500);
			//Click on partner icon
			if(actionLib.JSClick(JetPrevPageLocators.bigbasket, "Click on big basket icon")){
				extentLogs.pass("TC_005: Step 2", "User is able to find bigbasket icon");
				extentLogs.pass("TC_005: Step 3", "User is able to click bigbasket icon");
			}
			else
			{
				extentLogs.fail("TC_005: Step 2", "User is not able to find bigbasket icon");
				extentLogs.fail("TC_005: Step 3", "User is not able to click bigbasket icon");
			}
			
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);	
			//extentLogs.fail("test", "switch window");
			actLib.waitForVisibilityOfElement(PopUpPageLocators.BtnProceedBigbasket, "Proceed to Big basket", 1500);
			//click on Proceed button
			if(actionLib.JSClick(PopUpPageLocators.BtnProceedBigbasket, "Click on proceed button")){
				extentLogs.pass("TC_005: Step 4", "A pop up window is displayed");
				extentLogs.pass("TC_005: Step 5", "User is able to click Proceed to Partner button");
			}
			else{
				extentLogs.fail("TC_005: Step 4", "A pop up window is not displayed");
				extentLogs.fail("TC_005: Step 5", "User is not able to click Proceed to Partner button");
			}
			
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			System.out.println("title->"+driver.getTitle());
			System.out.println("url->"+driver.getCurrentUrl());
			actLib.waitForVisibilityOfElement(BigBasketLocators.txtSearch, "Search Text Box", 5000);
			actLib.waitForElementPresent(BigBasketLocators.txtSearch, 45000);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}

	/***************************************
	 * Function Name :-fnJetPrevPlaceOrderOnBigBasketSite	
	 * Return Type:- boolean	
	 * Date:-13-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevPlaceOrderOnBigBasketSite(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		
		{	
			//wait
			//Thread.sleep(10000);
			
			if(actLib.waitForVisibilityOfElement(BigBasketLocators.txtSearch, "Text Box", 9000)){
				extentLogs.pass("TC_005:Step6", "Partner site is opened in new tab ");
			}
			else{
				extentLogs.fail("TC_005:Step6", "Partner site is not opened in new tab ");
			}
			
			//type text in searchTextBox
			actionLib.type(BigBasketLocators.txtSearch, objDet.SearchText, "Enter the text in searchtextbox");
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnSearch, "Search Button", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnSearch, 15000);
			//click on search button
			if(actionLib.JSClick(BigBasketLocators.btnSearch, "Search")){
				extentLogs.pass("TC_005:Step8", "User is able to view the product specification ");
			}
			else{
				extentLogs.fail("TC_005:Step8", "User is not able to view the product specification ");
			}
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnFirstSearchProduct, "Searched Product", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnFirstSearchProduct, 9000);
			//Add to bag on searched product description
			actionLib.JSClick(BigBasketLocators.btnFirstSearchProduct, "Add to cart First Searched Product");
			//click on my basket
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnMyBasket, "My Basket", 11000);
			//actionLib.waitForVisibilityOfElement(BigBasketLocators.btnMyBasket, "My basket");
			//actionLib.mouseover(BigBasketLocators.btnMyBasket, "My Basket");
			actionLib.JSClick(BigBasketLocators.btnMyBasket, "My Basket");
			//click on View Basket and Check out button
			actionLib.JSClick(BigBasketLocators.btnViewBasketAndCheckOut, "Click on View Basket and Checkout");
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.labelLogin, "Login", 9000);
			//click on login link
			actionLib.JSClick(BigBasketLocators.labelLogin, "Click on Login Link");
			//enter username
			actionLib.type(BigBasketLocators.txtEmailID, objDet.FlipkartUserName,"Enter email address");
			//enter password
			actionLib.type(BigBasketLocators.txtPassword, objDet.FlipkartPassword, "Enter password");
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnLogin, "Login Button", 9000);
			//click on Login Button
			actionLib.JSClick(BigBasketLocators.btnLogin, "Click on Login Button");
			//wait
			//actLib.waitForElementPresent(BigBasketLocators.btnCheckout, 900);
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnCheckout, "Checkout Button", 9000);
			//click on Checkout button
			actionLib.JSClick(BigBasketLocators.btnCheckout, "Click on Checkout button");
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnDeliverToThisAddress, "Deliver to this address Button", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnDeliverToThisAddress, 900);
			//click on deliver to this address
			actionLib.JSClick(BigBasketLocators.btnDeliverToThisAddress, "Click on Deliver to this address");
			//switch to pop up
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnReviewBasket, "Review Basket Button", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnReviewBasket, 900);
			//click on review basket button
			actionLib.JSClick(BigBasketLocators.btnReviewBasket, "Click on Review Basket button");
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnCheckout, "Checkout Button", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnCheckout, 900);
			//click on Checkout button
			actionLib.JSClick(BigBasketLocators.btnCheckout, "Click on Checkout button");
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnDeliverToThisAddress, "Deliver to this Address Button", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnDeliverToThisAddress, 900);
			//click on deliver to this address
			actionLib.JSClick(BigBasketLocators.btnDeliverToThisAddress, "Click on Deliver to this address");
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnProceedToPayment, "Proceed to Payment Button", 9000);
			//actLib.waitForElementPresent(BigBasketLocators.btnProceedToPayment, 450);
			//click on Proceed to payment button
			if(actionLib.JSClick(BigBasketLocators.btnProceedToPayment,"Click on Proceed to payment button")){
				extentLogs.pass("TC_005:Step9", "User is able to place an order using Cash on delivery");
			}
			else{
				extentLogs.fail("TC_005:Step9", "User is not able to place an order using Cash on delivery");
			}
			//wait
			actLib.waitForVisibilityOfElement(BigBasketLocators.btnPlaceOrder, "Place Order Button", 15000);
			//click on Place order button
			actionLib.JSClick(BigBasketLocators.btnPlaceOrder, "Click on Place Order button");
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("Shop Jet Privilege", "User is not able to place an order using Cash on delivery");
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteHappilyUnmarried	
	 * Return Type:- boolean	
	 * Date:-18-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteHappilyUnmarried() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			//wait
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.arrowMark, "Arrow mark", 1500);
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			//wait
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.happilyunmarried, "Partner icon", 1500);
			//Click on partner icon
			if(actionLib.JSClick(JetPrevPageLocators.happilyunmarried, "Click on happily unmarried icon")){
				extentLogs.pass("TC_005: Step 2", "User is able to find happily unmarried icon");
				extentLogs.pass("TC_005: Step 3", "User is able to click happily unmarried icon");
			}
			else
			{
				extentLogs.fail("TC_005: Step 2", "User is not able to find happily unmarried icon");
				extentLogs.fail("TC_005: Step 3", "User is not able to click happily unmarried icon");
			}
			
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);			
			//wait
			actLib.waitForVisibilityOfElement(PopUpPageLocators.BtnProceedHappilyUnmarried, "Proceed to Partner Happily Unmarried ", 250);
			//wait
			actLib.waitForElementPresent(PopUpPageLocators.BtnProceedHappilyUnmarried, 1500);
			//click on Proceed button
			if(actionLib.JSClick(PopUpPageLocators.BtnProceedHappilyUnmarried, "Click on proceed button")){
				extentLogs.pass("TC_005: Step 4", "A pop up window is displayed");
				extentLogs.pass("TC_005: Step 5", "User is able to click Proceed to Partner button");
			}
			else{
				extentLogs.fail("TC_005: Step 4", "A pop up window is not displayed");
				extentLogs.fail("TC_005: Step 5", "User is not able to click Proceed to Partner button");
			}
			
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			//actLib.waitForElementPresent(HappilyUnmarried.dropDownUser, 10000);
			//wait
			actLib.waitForVisibilityOfElement(HappilyUnmarried.dropDownUser, "Drop Down", 11000);

			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail" );
		}
		return blnStatus;
	}

	/***************************************
	 * Function Name :-fnJetPrevPlaceOrderOnHappilyUnmarriedSite	
	 * Return Type:- boolean	
	 * Date:-18-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevPlaceOrderOnHappilyUnmarriedSite(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		
		{	
			//login to the site
			actLib.JSClick(HappilyUnmarried.dropDownUser, "Click on user icon");
			actLib.JSClick(HappilyUnmarried.labelLogin, "Click on login");
			
			//switch to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			actLib.waitForVisibilityOfElement(HappilyUnmarried.txtLogin, "Login", 6000);
			//actLib.waitForElementPresent(HappilyUnmarried.txtLogin, 1100);
			//enter user credentials
			actionLib.type(HappilyUnmarried.txtLogin, objDet.AmazonUserName, "Enter username");
			actionLib.type(HappilyUnmarried.txtPassword, objDet.AmazonPassword, "Enter password");
			actionLib.JSClick(HappilyUnmarried.btnLogin, "Click on Login Button");
			
			
			//wait for element
			actLib.waitForVisibilityOfElement(HappilyUnmarried.labelfirstproductinlist, "Product", 3000);
			//actionLib.waitForElementPresent(HappilyUnmarried.labelfirstproductinlist, 1100);
			
			//select product
			if(actionLib.JSClick(HappilyUnmarried.labelfirstproductinlist, "Select the product")){
				extentLogs.pass("Select Product", "User is able to select product and view its decription");
			}
			else{
				extentLogs.fail("Select Product", "User is not able to select product and view its decription");
			}
			//wait for element
			actLib.waitForVisibilityOfElement(HappilyUnmarried.btnAddToCart, "Add To Cart", 9000);
			//actionLib.waitForElementPresent(HappilyUnmarried.btnAddToCart, 1100);
			//add to cart
			actionLib.JSClick(HappilyUnmarried.btnAddToCart, "Add product to cart");
			//wait for element
			actLib.waitForVisibilityOfElement(HappilyUnmarried.btnCart, "Cart", 9000);
			//actionLib.waitForElementPresent(HappilyUnmarried.btnCart, 1100);
			//click on cart
			actionLib.JSClick(HappilyUnmarried.btnCart, "Click on cart");
			//wait for element
			actLib.waitForVisibilityOfElement(HappilyUnmarried.btnProceedToCheckout, "Proceed To Checkout", 9000);
			//actionLib.waitForElementPresent(HappilyUnmarried.btnProceedToCheckout, 1100);
			//click on Proceed to check out
			actionLib.JSClick(HappilyUnmarried.btnProceedToCheckout, "Click on Proceed to checkout button");
			//wait for element
			actLib.waitForVisibilityOfElement(HappilyUnmarried.btnProceedToPayment, "Proceed To Payment", 9000);
			//actionLib.waitForElementPresent(HappilyUnmarried.btnProceedToPayment, 1100);
			//click on proceed to payment button
			actionLib.JSClick(HappilyUnmarried.btnProceedToPayment, "Click on Proceed to payment button");
			//wait
			actLib.waitForVisibilityOfElement(HappilyUnmarried.labelCOD, "COD", 9000);
			//actLib.waitForElementPresent(HappilyUnmarried.labelCOD, 1000);
			//click on COD label
			actionLib.JSClick(HappilyUnmarried.labelCOD, "Click on COD option");
			//wait
			actLib.waitForVisibilityOfElement(HappilyUnmarried.btnFinalPayment, "Final Payment button", 15000);
			//click on final payment button
			actionLib.JSClick(HappilyUnmarried.btnFinalPayment, "Click on Pay button to place order");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Place Order Fail");
		}
		return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteNykaa	
	 * Return Type:- boolean	
	 * Date:-18-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteNykaa() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			//wait
			actLib.waitForElementPresent(JetPrevPageLocators.arrowMark, 7000);
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			//Click on partner icon
			if(actionLib.JSClick(JetPrevPageLocators.nykaa, "Click on Nykaa icon")){
				extentLogs.pass(" Step 2", "User is able to find Nykaa icon");
				extentLogs.pass(" Step 3", "User is able to click Nykaa icon");
			}
			else
			{
				extentLogs.fail("Step 2", "User is not able to find Nykaa icon");
				extentLogs.fail("Step 3", "User is not able to click Nykaa icon");
			}
			
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);			
			
			//wait
			actLib.waitForElementPresent(PopUpPageLocators.btnProceedNykaa, 7000);
			//click on Proceed button
			if(actionLib.JSClick(PopUpPageLocators.btnProceedNykaa, "Click on proceed button")){
				extentLogs.pass("Step 4", "A pop up window is displayed");
				extentLogs.pass("Step 5", "User is able to click Proceed to Partner button");
			}
			else{
				extentLogs.fail("Step 4", "A pop up window is not displayed");
				extentLogs.fail("Step 5", "User is not able to click Proceed to Partner button");
			}
			
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			
			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.txtSearchBox, "Text box", 30000);

			actLib.waitForElementPresent(NykaaLocators.txtSearchBox, 3000000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("Shop Jet Privilege script", "Redirection fail");
		}
		return blnStatus;
	}

	/***************************************
	 * Function Name :-fnJetPrevPlaceOrderOnNykaaSite	
	 * Return Type:- boolean
	 * Input :	JetPrevInput objDet
	 * Date:-18-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevPlaceOrderOnNykaaSite(JetPrevInput objDet) throws Throwable
	{
		boolean blnStatus=true;
		try
		
		{	
			//wait for search text box
			//actionLib.waitForElementPresent(NykaaLocators.txtSearchBox, 9000);
			//type in search text box
			actionLib.type(NykaaLocators.txtSearchBox, objDet.SearchText, "Type in search text box");
			//enter
			driver.findElement(NykaaLocators.txtSearchBox).sendKeys(Keys.ENTER);

			//wait for price locators
			//actLib.waitForVisibilityOfElement(NykaaLocators.labelPrice, "Price Locators", 250);
			//sort based on price
			
			/*WebElement element = driver.findElement(By.linkText("PRICE "));
			 
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).build().perform();
	 
	        driver.findElement(By.linkText("PRICE ")).click();
			//actLib.mouseover(NykaaLocators.labelPrice, "Price Locators");
			//actLib.mouseHoverByJavaScript(NykaaLocators.labelPrice, "Price Locators");
			//actLib.JSClick(NykaaLocators.labelPrice, "Price Locators");
			//actionLib.mouseHoverByJavaScript(NykaaLocators.labelPrice, "Price Locators");
			
			//wait for check box
			actionLib.waitForElementPresent(NykaaLocators.checkBoxPriceRange, 300);
			actLib.waitForVisibilityOfElement(NykaaLocators.checkBoxPriceRange, "Check Box", 250);
			//select option for 1000-2000
			actionLib.JSClick(NykaaLocators.checkBoxPriceRange, "Select price range");
*/
			//wait for check box
			actLib.waitForVisibilityOfElement(NykaaLocators.imgSelectProduct, "Product", 15000);
			//click on searched product
			actionLib.JSClick(NykaaLocators.imgSelectProduct, "Click on searched product");

			//switch to next window
			ActionsLibrary.switchToLatestWindow(driver);

			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.btnAddToBag, "Add To Bag", 5000);
			actionLib.waitForElementPresent(NykaaLocators.btnAddToBag, 15000);

			//click on Add To Bag button
			actLib.JSClick(NykaaLocators.btnAddToBag, "Click on Add to Bag");
			//actionLib.Click(NykaaLocators.btnAddToBag, "Click on Add to Bag");
			//driver.findElement(NykaaLocators.btnAddToBag).click();
			actLib.waitForVisibilityOfElement(NykaaLocators.labelAddedToBag, "Added to Cart", 15000);
			//wait
			//actionLib.waitForElementPresent(NykaaLocators.imgCart, 350);
			actLib.waitForVisibilityOfElement(NykaaLocators.imgCart, "Cart", 15000);
			//click on Cart
			actLib.JSClick(NykaaLocators.imgCart, "Click on cart");
			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.labelContShopping, "Continue Shopping label", 30000);

			//wait
			if(actLib.waitForVisibilityOfElement(NykaaLocators.btnCheckout, "Checkout", 9000)){
				extentLogs.pass("Items available in cart", "Items available in cart");
			}
			else{
				extentLogs.fail("Items not available in cart", "Items not available in cart");
				actionLib.JSClick(NykaaLocators.linkHomePage, "Home Page");
			}

			//click on checkout
			actLib.JSClick(NykaaLocators.btnCheckout, "Click on checkout");

			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.txtEmail, "Email", 5000);
			actionLib.waitForElementPresent(NykaaLocators.txtEmail, 15000);

			//enter email id
			actionLib.type(NykaaLocators.txtEmail, objDet.FlipkartUserName, "Type in email id text box");

			//click on continue
			actLib.JSClick(NykaaLocators.btnContinue, "Click on continue button");

			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.txtPassword, "Password", 5000);
			actionLib.waitForElementPresent(NykaaLocators.txtPassword, 15000);

			//enter password
			actionLib.type(NykaaLocators.txtPassword, objDet.FlipkartPassword, "Type in password text box");

			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.btnLoginToContinue, "Continue", 5000);
			actionLib.waitForElementPresent(NykaaLocators.btnLoginToContinue, 35000);

			//click on login to continue
			actLib.JSClick(NykaaLocators.btnLoginToContinue, "Click on login to continue button");

			//wait
			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.btnShipToThisAddress, "Ship To This Address button", 3000);

			//click on ship to this address btn
			actLib.JSClick(NykaaLocators.btnShipToThisAddress, "Click on ship to this address button");

			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.optionCOD, "COD option", 3000);

			//click on COD option
			actLib.JSClick(NykaaLocators.optionCOD, "Click on COD option");
			//wait
			actLib.waitForVisibilityOfElement(NykaaLocators.btnPlaceOrder, "Place Order", 15000);
			//click on place order button
			actLib.JSClick(NykaaLocators.btnPlaceOrder, "Click on Place Order button");





		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Place Order Fail");
		}
		return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteUrbanLadder	
	 * Return Type:- boolean	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteUrbanLadder() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			actionLib.waitForElementPresent(JetPrevPageLocators.arrowMark, 2500);
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			
			actionLib.waitForElementPresent(JetPrevPageLocators.urbanLadder, 1500);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.urbanLadder, "Click on Urban Ladder icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			actionLib.waitForVisibilityOfElement(PopUpPageLocators.btnProceedUrbanLadder, "Partner Pop Up", 6000);
			//actionLib.waitForElementPresent(PopUpPageLocators.btnProceedUrbanLadder, 1500);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedUrbanLadder, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait for close button on pop up window
			actionLib.waitForVisibilityOfElement(UrbanLadderLocators.btnClosePopUp, "Close Pop Up", 6000);
			//actionLib.waitForElementPresent(UrbanLadderLocators.btnClosePopUp, 1500);			
			//close the pop up
			actionLib.JSClick(UrbanLadderLocators.btnClosePopUp, "Close the pop up");
			//wait
			//actionLib.waitForElementPresent(UrbanLadderLocators.txtSearch, 2500);
			actionLib.waitForVisibilityOfElement(UrbanLadderLocators.txtSearch,"Search Text Box", 6000);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail");
		}
		return blnStatus;
	}

	
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteMyntra	
	 * Return Type:- boolean	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteMyntra() throws Throwable
	{
		boolean blnStatus=true;
		try
		{			
			//wait
			actionLib.waitForElementPresent(JetPrevPageLocators.myntra, 900);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.myntra, "Click on Myntra icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			actionLib.waitForElementPresent(PopUpPageLocators.btnProceedMyntra, 900);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedMyntra, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");

			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);


			actionLib.waitForVisibilityOfElement(MyntraLocators.txtSearch,"Search Text Box", 6000);
			//actionLib.waitForElementPresent(MyntraLocators.txtSearch, 2500);


		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail" );
		}
		return blnStatus;
	}
	

	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteWoohoo	
	 * Return Type:- boolean	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteWoohoo() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			//wait
			actionLib.waitForElementPresent(JetPrevPageLocators.arrowMark, 950);
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");			
			actionLib.waitForElementPresent(JetPrevPageLocators.woohoo, 950);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.woohoo, "Click on Woohoo icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			actionLib.waitForElementPresent(PopUpPageLocators.btnProceedWoohoo, 950);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedWoohoo, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//extentLogs.fail("test", "test");
			actionLib.waitForVisibilityOfElement(WoohooLocators.logoJetPrev,"Logo", 6000);
			//actionLib.waitForElementPresent(WoohooLocators.logoJetPrev, 2500);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail" );
		}
		return blnStatus;
	}

	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteTataCliq	
	 * Return Type:- boolean	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteTataCliq() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			
			
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");			
			actionLib.waitForElementPresent(JetPrevPageLocators.tatacliq, 920);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.tatacliq, "Click on Tata Cliq icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//wait
			actionLib.waitForElementPresent(PopUpPageLocators.btnProceedTataCliq, 920);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedTataCliq, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			
			actLib.waitForVisibilityOfElement(TataCliqLocators.txtSearch, "Search Text Box", 2500);
			actionLib.waitForElementPresent(TataCliqLocators.txtSearch, 2500);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail");
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnJetPrevRedirectToOnlinePartnerSiteLenskart	
	 * Return Type:- boolean	
	 * Date:-19-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevRedirectToOnlinePartnerSiteLenskart() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			//wait
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.arrowMark, "Arrow mark", 950);
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			//click on arrowmark to slide next
			actionLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.lenskart, "Pop up", 950);
			actionLib.waitForElementPresent(JetPrevPageLocators.lenskart, 950);
			//Click on partner icon
			actionLib.JSClick(JetPrevPageLocators.lenskart, "Click on Lenskart icon");
			//switch to another window
			ActionsLibrary.switchToLatestWindow(driver);
			//click on Proceed button
			actionLib.JSClick(PopUpPageLocators.btnProceedLenskart, "Click on proceed button");
			//click on proceed as guest
			//actionLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			
			//redirect to new window
			ActionsLibrary.switchToLatestWindow(driver);
			//actLib.waitForVisibilityOfElement(LenskartLocators.txtSearchBox, "Search Text Box", 100);
			//Thread.sleep(3000);
			/*ActionsLibrary.switchToLatestWindow(driver);
			actionLib.waitForElementPresent(LenskartLocators.btnClosePopUp, 150);
			actLib.waitForVisibilityOfElement(LenskartLocators.btnClosePopUp, "Pop up", 150);
			
			//close the pop up
			actionLib.JSClick(LenskartLocators.btnClosePopUp, "Close the pop up");
			
			actionLib.waitForElementPresent(LenskartLocators.txtSearchBox, 50);*/
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
			extentLogs.fail("JetPrev Web Test Script ","Redirection Fail" );
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

	
	/***************************************
	 * Function Name :-fnJetPrevSwitchBackToJetPrevPage	
	 * Return Type:- boolean		
	 * Date:-15-Dec-2017
	 * Author:-Parita
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSwitchBackToJetPrevPage1() throws Throwable
	{
		boolean blnStatus=true;
		try
		{	
			/*for(String handle:driver.getWindowHandles()){
				if(!handle.equals(originalHandle)){
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);*/
			//driver.navigate().to("https://shop.jetprivilege.com/home");
			driver.navigate().back();
			
		
		
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
