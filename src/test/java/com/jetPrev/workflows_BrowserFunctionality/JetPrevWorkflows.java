package com.jetPrev.workflows_BrowserFunctionality;


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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JEditorPane;

import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amazonaws.services.simpleworkflow.flow.worker.SynchronousActivityTaskPoller;
import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jetPrev.testObjects_BrowserFunctionality.JetPrevPageLocators;
import com.jetPrev.testObjects_BrowserFunctionality.JetPrev_Smoke_Locators;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.fileutils.ExcelReader;
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

	public JetPrevWorkflows(WebDriver driver) {

		super(driver);

	}

	
	
	/***************************************
	 * Function Name :-fnJetPrevLogin
	 * Input:-String strUserID,String strPassword
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	public boolean fnJetPrevLogin(JetPrevInput objData) throws Throwable
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
				actionLib.Click(JetPrevPageLocators.btnLogin, "Login");
			}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	
	/***************************************
	 * Function Name :-fnJetPrevSearchbar
	 * Input:-String strUserID,String strPassword
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	public boolean fnJetPrevSearchbar(By locator1, By locator2) throws Throwable
	{
		
		boolean blnStatus=true;
		try
		{
			//Scroll down
			actionLib.ScrollToBottom();
			//click on retail partners
			actionLib.JSClick(locator1, "Click on Retailed partners");
			//Click on proceed to lifestyle button on a pop up window
			actionLib.JSClick(locator2, "Click on proceed to lifestyle button");
					
			String id;
			for (String WindowHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(WindowHandle);
			}
			String lblHeader = actionLib.getElementText(JetPrevPageLocators.mainHeader, "Header name");
			if(lblHeader.equalsIgnoreCase("Lifestyle Fine Jewelry"))
			{
				extentLogs.pass("Verify Other Retails Partners", lblHeader+ " is successfully displayed");
			}
			else
			{
				extentLogs.fail("Verify Other Retails Partners", lblHeader+ " is not displayed");
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
	 * Function Name :-fnJetHeader
	 * Input:-String strUserID,String strPassword
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	public boolean fnJetHeader(By locator1) throws Throwable{
		
		boolean blnStatus = true;
		try{
			
			//Header
			//click on Our program
			actionLib.JSClick(locator1, "Click on our program");
			String lblHeader = actionLib.getElementText(JetPrevPageLocators.mainHeader, "Header name");
			
			if(lblHeader.equalsIgnoreCase(lblHeader))
			{
				extentLogs.pass("Verify Headers", lblHeader+ " is successfully displayed");
			}
			else
			{
				extentLogs.fail("Verify Headers", lblHeader+ " is not displayed");
			}
			//navigate back to the home page
			Thread.sleep(3000);
			actionLib.NavigateBack();
	/*		//click on Earn Jpmiles
			actionLib.JSClick(JetPrevPageLocators.earnJpmiles, "Click on Earn JPMiles");
			//navigate back to the home page
			actionLib.NavigateBack();
			//click on Use JPMiles
			actionLib.JSClick(JetPrevPageLocators.useJpmiles, "Click on Use JPMiles");
			//navigate back to home page
			actionLib.NavigateBack();
			//click on offers & Deals
			actionLib.JSClick(JetPrevPageLocators.offerDeals, "click on offer&Deals");
			//navigate back to home page
			actionLib.NavigateBack();
			//click on BookNow
			actionLib.JSClick(JetPrevPageLocators.bookNow, "click on booknow" );*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus= false;
		}
		return blnStatus;
	}
	
	/***************************************
	 * Function Name :-fnStaticbanner
	 * Input:-Fname,LName,Monile,Postal Etc
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	    public boolean fnStaticbanner(JetPrevInput objData) throws Throwable{
		boolean blnStatus = true;
		try{
			
						
			actionLib.JSClick(JetPrevPageLocators.staticBanner, "Static Banner");	
			ActionsLibrary.switchToLatestWindow(driver);
			actionLib.JSClick(JetPrevPageLocators.proceedToLenskart, "Static Banner");
			ActionsLibrary.switchToLatestWindow(driver);
			/*for (String WindowHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(WindowHandle);
			}*/
			String url = driver.getCurrentUrl();
			String[] urlSplit=url.split("=");
			String firstPart=urlSplit[0];
			String lastPart=urlSplit[urlSplit.length-1];
			String secondlastPart=urlSplit[urlSplit.length-2];
			String[] uniqueNumber=secondlastPart.split("&"); 
			String jetPNumber=uniqueNumber[0];
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && firstPart.contains("http://www.lenskart.com"))
			{
			blnStatus=true;
			extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
			}
			driver.quit();
//			actionLib.WaitForElementVisible(JetPrevPageLocators.popUp, 2000);
//			actionLib.JSClick(JetPrevPageLocators.popUp, "Click on popup");
//			actionLib.Click(JetPrevPageLocators.sunGlasses, "Click on product");
//			//actionLib.waitForElementPresent(JetPrevPageLocators.sunGlassitem, 200);
//			actionLib.Click(JetPrevPageLocators.sunGlassitem, "Click on item");
//			//actionLib.JSAcceptAlert();
//			//actionLib.waitForElementPresent(JetPrevPageLocators.buyNowsunglasses, 200);
//			actionLib.Click(JetPrevPageLocators.buyNowsunglasses, "Click on buynow");
////			actionLib.Click(JetPrevPageLocators.proccedTocheckout, "Click on proceed to checkout");
////			Thread.sleep(2000);
//			actionLib.Click(JetPrevPageLocators.close, "Click on close popup");
//			//actionLib.waitForElementPresent(JetPrevPageLocators.radioButton, 200);
//			actionLib.JSClick(JetPrevPageLocators.radioButton, "Click on radio button");
//			//actionLib.waitForElementPresent(JetPrevPageLocators.email, 200);
//			System.out.println( objData.Email);
//			actionLib.type(JetPrevPageLocators.email, objData.Email, "Enter Email");
//			actionLib.type(JetPrevPageLocators.password, objData.Passwordnew, "Enter password");
//			//actionLib.waitForElementPresent(JetPrevPageLocators.continuee, 200);
//			actionLib.JSClick(JetPrevPageLocators.continuee, "Click on continue");
//			Thread.sleep(2000);
		//	if()
//			try {
//				actionLib.type(JetPrevPageLocators.fName, objData.FName, "enter First name");
//				actionLib.type(JetPrevPageLocators.lName, objData.LName, "enter Last name");
//				actionLib.type(JetPrevPageLocators.moBile, objData.Mobile, "enter mobile number");
//				actionLib.Click(JetPrevPageLocators.genderMale, "Select male");
//				actionLib.type(JetPrevPageLocators.postalCode, objData.PostalCode, "enter Postal code");
//				actionLib.type(JetPrevPageLocators.addressLine1, objData.AddressLine1, "enter AddressLine1");
//				actionLib.type(JetPrevPageLocators.addressLine2, objData.AddressLine2, "enter AddressLine2");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println("Fname is not available....................");
		//	}
			Thread.sleep(2000);
			actionLib.JSClick(JetPrevPageLocators.close, "Click on x icon");
			//actionLib.waitForElementPresent(JetPrevPageLocators.continu, 200);
			Thread.sleep(2000);
			actionLib.JSClick(JetPrevPageLocators.continu, "Click on Continue");
//		    actionLib.JSClick(JetPrevPageLocators.cashOndelivery, "Click on cash on delivery");
//		    actionLib.JSClick(JetPrevPageLocators.placeOrder, "click on place order");
//		    actionLib.JSClick(JetPrevPageLocators.otp, "Click on otp");
			}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	    public boolean fnJetstaticinput(JetPrevInput objDet) throws Throwable{
		boolean blnstatus = true;
		try{
			actionLib.type(JetPrevPageLocators.fName, objDet.FName, "enter First name");
			actionLib.type(JetPrevPageLocators.lName, objDet.LName, "enter Last name");
			actionLib.type(JetPrevPageLocators.moBile, objDet.Mobile, "enter mobile number");
			actionLib.type(JetPrevPageLocators.postalCode, objDet.PostalCode, "enter Postal code");
			actionLib.type(JetPrevPageLocators.addressLine1, objDet.AddressLine1, "enter AddressLine1");
			actionLib.type(JetPrevPageLocators.addressLine2, objDet.AddressLine2, "enter AddressLine2");
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			blnstatus = false;
		}
		return blnstatus;
	}
	    
//	    
//	public boolean fnJetsearchPage(String strsearchPage) throws Throwable{
//		
//		boolean blnStatus = true;
//		try{
//			//List<WebElement> filter = 
//			//click on all categories
//			actionLib.JSClick(JetPrevPageLocators.allcategories, "click on all categories");
//			//Mousehover on electronics and media
//			actionLib.mouseHoverByJavaScript(JetPrevPageLocators.electronicsGaming, "Mousehover on electronicsGaming");
//			//Mousehover on aircoolers and conditioners
//			actionLib.JSClick(JetPrevPageLocators.airCoolers, "Mousehovre on aircoolers");
//			//Click on Search
//			actionLib.JSClick(JetPrevPageLocators.searchbtn, "click on Search button");
//			//actionLib.mouseHoverByJavaScript(JetPrevPageLocators., locatorName)
//			}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			blnStatus = false;
//		}
//		return blnStatus;
//	}
	    /***************************************
		 * Function Name :-fnJetsortby
		 * Return Type:- boolean
		 * Date:-08-Dec-2017
		 * Author:-Nithin
		 * @throws Throwable 
		 */
	public boolean fnJetsortby() throws Throwable{
	boolean	blnStatus = true;
	try{
		actionLib.JSClick(JetPrevPageLocators.booksandMedia , "Click on Books and media");
		actionLib.JSClick(JetPrevPageLocators.sortBybutton, "Click on sort by button");
		String result = actionLib.getElementInnerText(JetPrevPageLocators.sortByresults, "get inner text from results");
		if(result.equalsIgnoreCase(result))
		{
			extentLogs.pass("Verify Headers", result+ " is successfully displayed");
		}
		else{
			extentLogs.pass("Verify Headers", result+ " is failed to display");
		}
		actionLib.JSClick(JetPrevPageLocators.relevance, "Click on relevance");
		String relevancetext = actionLib.getElementInnerText(JetPrevPageLocators.relevancetext, "Get the selected text");
		extentLogs.info("Verify selected text", relevancetext+ " is successfully displayed");
		//System.out.println(relevancetext);
		actionLib.JSClick(JetPrevPageLocators.highTolow, "Click on high to low");
		String hightolowtext = actionLib.getElementInnerText(JetPrevPageLocators.relevancetext, "Get the selected text");
		extentLogs.info("Verify selected text", hightolowtext+ " is successfully displayed");
		//System.out.println(hightolowtext);
		actionLib.JSClick(JetPrevPageLocators.lowTohigh, "Click on high to low");
		String lowtohightext = actionLib.getElementInnerText(JetPrevPageLocators.relevancetext, "Get the selected text");
		extentLogs.info("Verify selected text", lowtohightext+ " is successfully displayed");
		//System.out.println(lowtohightext);
		actionLib.JSClick(JetPrevPageLocators.jpMileshightolow, "Click on high to low");
		String jpmileshightolowtext = actionLib.getElementInnerText(JetPrevPageLocators.relevancetext, "Get the selected text");
		extentLogs.info("Verify selected text", jpmileshightolowtext+ " is successfully displayed");
		//System.out.println(jpmileshightolowtext);
		actionLib.JSClick(JetPrevPageLocators.jpMileslowtohigh, "Click on high to low");
		String jpmileslowtohightext = actionLib.getElementInnerText(JetPrevPageLocators.relevancetext, "Get the selected text");
		extentLogs.info("Verify selected text", jpmileslowtohightext+ " is successfully displayed");
		//System.out.println(jpmileslowtohightext);
	}	
	catch(Exception e)
	{
		e.printStackTrace();
		blnStatus = false;
	}
	return blnStatus;
	}
	
	/*public boolean fnnavigation(By locator){
		boolean blnstatus = true;
		try{
			actionLib.JSClick(locator, "click on" + locator);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		blnstatus = false;
		}
		return blnstatus;
	}*/
	
	/***************************************
	 * Function Name :-fnnavigation
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	public boolean fnnavigation() throws Throwable{
		boolean blnStatus = true;
		try{
			actionLib.JSClick(JetPrevPageLocators.booksandMedia, "Clicks on books and media");
			actionLib.waitForElementPresent(JetPrevPageLocators.next, 200);
			actionLib.JSClick(JetPrevPageLocators.next, "Click on Next");
			actionLib.waitForElementPresent(JetPrevPageLocators.forward, 300);
			actionLib.JSClick(JetPrevPageLocators.forward, "click on forward");
			actionLib.WaitForElementVisible(JetPrevPageLocators.back , 200);
			actionLib.JSClick(JetPrevPageLocators.back, "click on back");
			actionLib.WaitForElementVisible(JetPrevPageLocators.backward, 400);
			actionLib.JSClick(JetPrevPageLocators.backward, "Click on backwards");
			extentLogs.pass("Navigation flow", "Validation for navigation of forward and backward is pass");
		}
		catch(Exception e){
			e.printStackTrace();
			blnStatus = false;
			extentLogs.fail("Navigation flow", "Validation for navigation of forward and backward is fail");
		}
		return blnStatus;
		}
	
	/***************************************
	 * Function Name :-fnprice
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	public boolean fnprice() throws Throwable{
		Boolean blnstatus = true;
		try{
			
			actionLib.JSClick(JetPrevPageLocators.allCategories, "click on all categories");
			actionLib.WaitForElementVisible(JetPrevPageLocators.babyCare, 200);
			actionLib.JSClick(JetPrevPageLocators.babyCare, "Click on baby care");
			actionLib.WaitForElementVisible(JetPrevPageLocators.searchbtn, 200);
			actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
			actionLib.WaitForElementVisible(JetPrevPageLocators.range1, 200);
			actionLib.JSClick(JetPrevPageLocators.range1, "Click on price range");
			actionLib.WaitForElementVisible(JetPrevPageLocators.range2, 200);
			actionLib.JSClick(JetPrevPageLocators.range2, "Click on price range");
			actionLib.WaitForElementVisible(JetPrevPageLocators.brand1, 300);
			actionLib.JSClick(JetPrevPageLocators.brand1, "Click on brand1");
			actionLib.WaitForElementVisible(JetPrevPageLocators.brand2, 200);
			actionLib.JSClick(JetPrevPageLocators.brand2, "Click on brand2");
			actionLib.waitForElementPresent(JetPrevPageLocators.pricePartner, 200);
			actionLib.JSClick(JetPrevPageLocators.pricePartner, "Click on partner");
			actionLib.waitForElementPresent(JetPrevPageLocators.priceApply, 200);
			actionLib.JSClick(JetPrevPageLocators.priceApply, "Click on apply");
			String price = actionLib.getElementInnerText(JetPrevPageLocators.priceText, " of refined serach results");
			System.out.println("price ::::"+price);
			extentLogs.info("Verify the results", price+ "is successfully displayed");
//			actionLib.wait(2000);
//			if(price.contains("Found 13 Results in Baby Care Categories is  succesfully displayed")){
//				extentLogs.pass("Verify text", price+ "is succesfully displayed");
//				System.out.println("price Pass::::"+price);	
//			}
//			else{
//				extentLogs.fail("Verify text", price+ "is failed to display");
//				System.out.println("price ::::"+price);
//			}
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		blnstatus = false;
		}
		return blnstatus;
	}
	
	/***************************************
	 * Function Name :-fnURLValidation
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
	public boolean fnURLValidation(JetPrevInput objDet) throws Throwable
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
	 * Function Name :-fncat
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Exception 
	 * @throws Throwable 
	 */
	public void categories(String mainCat , String subCat) throws Exception{
		 Actions a=new Actions(driver);
			// List <WebElement> categories = driver.findElement(By.xpath("//ul[@id='menu']")).findElements(By.xpath("//ul[@id='menu']/li/a/span[1]"));
			 actionLib.JSClick(JetPrevPageLocators.allCategories, "Click");
			 a.moveToElement(driver.findElement(By.xpath("//span[contains(text(), '"+mainCat+"')]"))).build().perform();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//span[contains(text(), '"+subCat+"')]")).click();
	}
       public boolean fncat(JetPrevInput objData) throws Throwable{
	   Boolean blnstatus = true;
	     try{
	    //	 for (int s = 0; s <16; s++) {
			
		// actionLib.JSClick(JetPrevPageLocators.allCategories, "Click");
		 //String str = actionLib.getElementInnerText(JetPrevPageLocators.meNu, "gettext");
/*		 Actions a=new Actions(driver);
		// List <WebElement> categories = driver.findElement(By.xpath("//ul[@id='menu']")).findElements(By.xpath("//ul[@id='menu']/li/a/span[1]"));
		 actionLib.JSClick(JetPrevPageLocators.allCategories, "Click");
		 System.out.println("--------------------------"+objData.Categories);
		 a.moveToElement(driver.findElement(By.xpath("//span[contains(text(), '"+objData.Categories+"')]"))).build().perform();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[contains(text(), '"+objData.Sub1+"')]")).click();*/
		 
		 categories(objData.Categories, objData.Sub1);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub1 = actionLib.getElementInnerText(JetPrevPageLocators.getText,  " of Air Coolers and Conditioners");
		 extentLogs.info("verify the displayed text", sub1+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub2);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub2 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Camera Accessories ");
		 extentLogs.info("verify the displayed text", sub2+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub3);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub3 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Audio Players");
		 extentLogs.info("verify the displayed text", sub3+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub4);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub4 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Cameras  ");
		 extentLogs.info("verify the displayed text", sub4+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub5);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub5 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of  Computer Accessories");
		 extentLogs.info("verify the displayed text", sub5+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub6);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub6 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of desktops");
		 extentLogs.info("verify the displayed text", sub6+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub7);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub7 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of gaming");
		 extentLogs.info("verify the displayed text", sub7+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub8);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub8 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Home Entertainment");
		 extentLogs.info("verify the displayed text", sub8+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub9);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub9 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Laptops");
		 extentLogs.info("verify the displayed text", sub9+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub10);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub10 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Microwave ovens");
		 extentLogs.info("verify the displayed text", sub10+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub11);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub11 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Refrigerator");
		 extentLogs.info("verify the displayed text", sub11+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub12);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub12 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of TV and Video Accessories");
		 extentLogs.info("verify the displayed text", sub12+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub13);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub13 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Television");
		 extentLogs.info("verify the displayed text", sub13+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		 categories(objData.Categories, objData.Sub14);
		 actionLib.JSClick(JetPrevPageLocators.searchbtn, "Click on search");
		 Thread.sleep(2000);
		 String sub14 = actionLib.getElementInnerText(JetPrevPageLocators.getText, " of Washing machine");
		 extentLogs.info("verify the displayed text", sub14+ "got displayed successfully");
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on home");
		 Thread.sleep(2000);
		
		 
		 
		 
		 
/*		 for( int i=2; i<16;i++)
		 {
			 actionLib.JSClick(JetPrevPageLocators.allCategories, "Click");
			 List <WebElement> categories = driver.findElements(By.xpath("//ul[@id='menu']/li/a/span[1]"));
			 System.out.println("categories  :"+categories.size());
			System.out.println(categories.get(i).getText()); 
			//categories.get(i).click();
			a.moveToElement(categories.get(i)).build().perform();
			if(categories.get(i).getText().equalsIgnoreCase("Electronics and Gaming")){
				a.moveToElement(categories.get(i)).build().perform();
						
			try {
				List <WebElement> subcategories=driver.findElements(By.xpath("//div[@class='dropdown-wrapper']//ul//li//ul/li//a"));
				System.out.println("subcategories  :"+subcategories.size());
				try {
					for (int j = 0; j < subcategories.size(); j++) {
						System.out.println(subcategories.get(j).getText()); 
					if(subcategories.get(j).getText().equalsIgnoreCase("Air Coolers and Conditioners")){
					a.click(subcategories.get(j)).build().perform();
					break;
					
						}
						
						//subcategories.get(j).click();
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List <WebElement> subItems = categories.get(i).findElements(By.xpath("//ul[@class='dropdown1 active']/li/a/span[1]"));
			for (int j=0;j<subItems.size();j++)
			{
				System.out.println(subItems.get(j).getText());
			}
		 }
		// }
		 if(str.equalsIgnoreCase(str)){
			 extentLogs.pass("all categories",str+ "text is displayed");
		 }
		 else{
			 extentLogs.fail("allCategories",str+ "failed to display");
		 }
		 }*/
	     }
	 catch(Exception e){
		 e.printStackTrace();
		 blnstatus = false;
	 }
	 return blnstatus;
 }
	
       /***************************************
   	 * Function Name :-fnGoQuicklylinkFlow
   	 * Return Type:- boolean
   	 * Date:-08-Dec-2017
   	 * Author:-Nithin
   	 * @throws Throwable 
   	 */
     public boolean fnGoQuicklylinkFlow() throws Throwable
     {
     boolean blnStatus=true;
     try
     {
     //Verify Go Quickly to have 7 hyper links
//	 String str = actionLib.getElementInnerText(JetPrevPageLocators.quicklyMenu, "Get the text");
//	 if(str.equalsIgnoreCase(str))
//	 {
//		 extentLogs.pass("Below are the seven links"+str, "are successfully displayed");
//	 }
//	 else{
//		 extentLogs.fail("Below are the seven links"+str, "are not displayed");
//	 }
//	 System.out.println(str);
	 
	 List<WebElement>links=driver.findElements(By.xpath("//div[@class='swiper-container']//a"));
	 System.out.println(links.size());
	 for (int i = 0; i < links.size(); i++) {
		 
		 if (links.get(i).getText().equalsIgnoreCase("Fashion Accessories")) 
		{
			links.get(i).click();
			break;
		}
		}
//	 List<WebElement>sublinks=driver.findElements(By.xpath("//*[@id='desktop_product_category']"));
//	 Thread.sleep(2000);
//	 System.out.println(sublinks.size());
//	 for(int j=0;j<sublinks.size(); j++){
//		 if(sublinks.get(j).getText().equalsIgnoreCase("Eyewear(34321)"))
//		 {
//			 Thread.sleep(3000);
//			 sublinks.get(j).click();
//			 break;
//		 }
//		
//	 }
	 
	 actionLib.JSClick(JetPrevPageLocators.menuItem, "Click on item");
	 Thread.sleep(4000);
	 actionLib.JSClick(JetPrevPageLocators.mynthra, "Click on Myntra");
	 Thread.sleep(4000);
	 actionLib.JSClick(JetPrevPageLocators.priceApply, "click on apply");
	 actionLib.JSClick(JetPrevPageLocators.mynthraProduct, "Click on product");
	 actionLib.JSClick(JetPrevPageLocators.mynthraCart, "Click on cart");
	 actionLib.JSClick(JetPrevPageLocators.myntraContinueasguest, "Click on continue as guest");
	 ActionsLibrary.switchToLatestWindow(driver);
	 String url = driver.getCurrentUrl();
		String[] urlSplit=url.split("=");
		String firstPart=urlSplit[0];
		String lastPart=urlSplit[urlSplit.length-1];
		String secondlastPart=urlSplit[urlSplit.length-2];
		String[] uniqueNumber=secondlastPart.split("&");
		String jetPNumber=uniqueNumber[0];
		System.out.println(lastPart.length());
		System.out.println(firstPart.length());
		System.out.println(secondlastPart.length());
		if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && firstPart.contains("www.myntra.com"))
		{
		extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
		}
     /*List<WebElement> allLinks = driver.findElements(By.xpath("//*[@id='dashboard']/div[3]"));
     extentLogs.info("Total Go quickly links are :", ""+allLinks.size());*/
    /*if(allLinks.size()==7)
    {
    extentLogs.pass("Go Quickly to is having 7 links","Go Quickly to has " +allLinks.size());
    }
    else
    {
    extentLogs.fail("Go Quickly to is not having 7 links","Go Quickly to has" +allLinks.size());
    }*/
   /*for(int i=0;i<allLinks.size();i++)
   {
    extentLogs.info("link name:", "Name of GoQuickly links"+(i+1)+allLinks.get(i).toString());
  
       }*/
     }
     catch(Exception e)
    {
     e.printStackTrace();
    blnStatus=false;
    }
     return blnStatus;
     }

     
     /***************************************
 	 * Function Name :-fnrecommendedCategories
 	 * Return Type:- boolean
 	 * Date:-08-Dec-2017
 	 * Author:-Nithin
 	 * @throws Throwable 
 	 */
  public boolean fnrecommendedCategories(){
	 Boolean blnstatus = true;
	 try{
		 Thread.sleep(3000);
		 actionLib.JSClick(JetPrevPageLocators.dropDown, "Click on dropdown");
		 Thread.sleep(3000);
		 actionLib.JSClick(JetPrevPageLocators.bookMedia, "Click on book and media");
		 Thread.sleep(3000);
		 actionLib.JSClick(JetPrevPageLocators.srchbtn, "Click on search button");
		 actionLib.waitForElementPresent(JetPrevPageLocators.hoMe, 200);
		 actionLib.JSClick(JetPrevPageLocators.hoMe, "Click on Home");
		 actionLib.waitForElementPresent(JetPrevPageLocators.recomItem, 200);
		 actionLib.JSClick(JetPrevPageLocators.recomItem, "Click on item");
		 actionLib.waitForElementPresent(JetPrevPageLocators.subitem, 200);
		 actionLib.JSClick(JetPrevPageLocators.subitem, "Click on subitem");
		 actionLib.waitForElementPresent(JetPrevPageLocators.proceedFurther, 200);
		 actionLib.JSClick(JetPrevPageLocators.proceedFurther, "Click on cart to proceed further");
		 ActionsLibrary.switchToLatestWindow(driver);
		 actionLib.waitForElementPresent(JetPrevPageLocators.continueAsGuest, 200);
		 actionLib.JSClick(JetPrevPageLocators.continueAsGuest, "Click on continue as guest");
		 ActionsLibrary.switchToLatestWindow(driver);
		 try
			{
			String url = driver.getCurrentUrl();
			String[] urlSplit=url.split("=");
			String firstPart=urlSplit[0];
			String lastPart=urlSplit[urlSplit.length-1];
			String secondlastPart=urlSplit[urlSplit.length-2];
			String[] uniqueNumber=secondlastPart.split("&");
			String jetPNumber=uniqueNumber[0];
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && firstPart.contains("www.flipkart.com"))
			{
			blnstatus=true;
			extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();
			blnstatus=false;
			extentLogs.fail("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is not getting generated as expected");
			}
		// actionLib.waitForElementPresent(JetPrevPageLocators.buyNw, 200);
		// actionLib.JSClick(JetPrevPageLocators.buyNw, "Clcik on buy now");
		 
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 blnstatus=false;
	 }
	 return blnstatus;
 }

  
  

  /***************************************
	 * Function Name :-fnrecommendedProducts
	 * Return Type:- boolean
	 * Date:-08-Dec-2017
	 * Author:-Nithin
	 * @throws Throwable 
	 */
public boolean fnrecommendedProducts(){
	 Boolean blnstatus = true;
	 try{
		 actionLib.JSClick(JetPrevPageLocators.product, "click on product");
		 actionLib.WaitForElementVisible(JetPrevPageLocators.caRt, 200);
		 actionLib.JSClick(JetPrevPageLocators.caRt, "Click on cart");
		 ActionsLibrary.switchToLatestWindow(driver);
		 actionLib.JSClick(JetPrevPageLocators.continueAsGuest, "Click on continue as guest");
		 ActionsLibrary.switchToLatestWindow(driver);
		 String url = driver.getCurrentUrl();
			String[] urlSplit=url.split("=");
			String firstPart=urlSplit[0];
			String lastPart=urlSplit[urlSplit.length-1];
			String secondlastPart=urlSplit[urlSplit.length-2];
			String[] uniqueNumber=secondlastPart.split("&");
			String jetPNumber=uniqueNumber[0];
			if((lastPart.length()==19 ||lastPart.substring(5).length()==19|| jetPNumber.length()==19) && firstPart.contains("www.flipkart.com"))
			{
			extentLogs.pass("Validate the affiliate Id and  member reference (tracking) Id passed by the affiliate partner site ", " Affiliate Id and  member reference (tracking) Id passed by the affiliate partner site is getting generated as expected");
			}
		//actionLib.waitForElementPresent(JetPrevPageLocators.buyNw, 200);
		//actionLib.JSClick(JetPrevPageLocators.buyNw, "Clcik on buy now");
		 
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 blnstatus=false;
	 } 
	 return blnstatus;
}

/***************************************
 * Function Name :-fnMobileEmulation
 * Return Type:- boolean
 * Date:-25-Jan-2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnMobileEmulation() throws Throwable{
Boolean blnstatus = true;
try {
	actionLib.JSClick(JetPrevPageLocators.logomain, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileOurprogram, "Click on ourprogram");
	actionLib.JSClick(JetPrevPageLocators.ourprogramSubheading, "Click on ourprogram subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.ourProgramBreadcrumb,"ourProgramBreadcrumb");
	String headerOurprogram = actionLib.getElementText(JetPrevPageLocators.ourprogramHeader, "get the text of the header");
	extentLogs.info("Verified our program header", headerOurprogram+ " got displayed successfully");
	Thread.sleep(3000);
	actionLib.NavigateBack();
	actionLib.NavigateBack();
	//driver.navigate().back();
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.logomain, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileEarnJPmile, "Click on Earn Jpmiles");
	//actionLib.JSClick(JetPrevPageLocators.mobileearnSubheading, "Click on Earnjpmiles subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.earnjpmilesHeader,"earnjpmilesHeader");
	String headerEarnJpmiles = actionLib.getElementText(JetPrevPageLocators.earnjpmilesHeader, "get the text of the header");
	extentLogs.info("Verified Earn Jpmiles header", headerEarnJpmiles+ " got displayed successfully");
	Thread.sleep(3000);
	actionLib.NavigateBack();
	
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.logomain, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileUsejpmiles, "Click on useJpmiles");
	actionLib.JSClick(JetPrevPageLocators.mobileusejpmileSubheading, "Click on useJpmiles subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.usejpmilesHeader,"usejpmilesHeader");
	String headerUseJpmiles = actionLib.getElementText(JetPrevPageLocators.usejpmilesHeader, "get the text of the header");
	extentLogs.info("Verified useJpmiles header", headerUseJpmiles+ " got displayed successfully");
	Thread.sleep(3000);
	actionLib.NavigateBack();
	
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.logomain, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileOffersanddeals, "Click on Offersanddeals");
	//actionLib.JSClick(JetPrevPageLocators.ourprogramSubheading, "Click on Offersanddeals subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.offersanddealsHeader,"offersanddealsHeader");
	String headerOffersanddeals = actionLib.getElementText(JetPrevPageLocators.offersanddealsHeader, "get the text of the header");
	extentLogs.info("Verified Offersanddeals header", headerOffersanddeals+ " got displayed successfully");
	Thread.sleep(3000);
	actionLib.NavigateBack();
	
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.logomain, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobilebooknow, "Click on booknow");
	//actionLib.JSClick(JetPrevPageLocators.booknowSubheading, "Click on booknow subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.booknowHeader,"booknowHeader");
	String headerBooknow = actionLib.getElementText(JetPrevPageLocators.booknowHeader, "get the text of the header");
	extentLogs.info("Verified our program header", headerBooknow+ " got displayed successfully");
	Thread.sleep(3000);
	actionLib.NavigateBack();
	
	
}
catch(Exception e) {
	e.printStackTrace();
	blnstatus = false;
}
return blnstatus;
}



/***************************************
 * Function Name :-fnHeaderNew
 * Return Type:- boolean
 * Date:-25-Jan-2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnHeaderNew() throws Throwable{
Boolean blnstatus = true;
try {
	//actionLib.JSClick(JetPrevPageLocators.logomain, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileOurprogram, "Click on ourprogram");
	//actionLib.JSClick(JetPrevPageLocators.ourprogramSubheading, "Click on ourprogram subheading");
	Thread.sleep(10000);
	actionLib.validateCheckStyle(JetPrevPageLocators.ourProgramBreadcrumb,"ourProgramBreadcrumbFirefox");
	String headerOurprogram = actionLib.getElementText(JetPrevPageLocators.ourprogramHeader, "get the text of the header");
	extentLogs.info("Verified our program header", headerOurprogram+ " got displayed successfully");
	actionLib.NavigateBack();
	//actionLib.NavigateBack();
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	Thread.sleep(5000);
	actionLib.JSClick(JetPrevPageLocators.mobileEarnJPmile, "Click on Earn Jpmiles");
	//actionLib.JSClick(JetPrevPageLocators.mobileearnSubheading, "Click on Earnjpmiles subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.earnjpmilesHeader,"earnjpmilesHeaderFirefox");
	String headerEarnJpmiles = actionLib.getElementText(JetPrevPageLocators.earnjpmilesHeader, "get the text of the header");
	extentLogs.info("Verified Earn Jpmiles header", headerEarnJpmiles+ " got displayed successfully");
	actionLib.NavigateBack();
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileUsejpmiles, "Click on useJpmiles");
	Thread.sleep(5000);
	//actionLib.JSClick(JetPrevPageLocators.mobileusejpmileSubheading, "Click on useJpmiles subheading");
	actionLib.validateCheckStyle(JetPrevPageLocators.usejpmilesHeader,"usejpmilesHeaderFirefox");
	String headerUseJpmiles = actionLib.getElementText(JetPrevPageLocators.usejpmilesHeader, "get the text of the header");
	extentLogs.info("Verified useJpmiles header", headerUseJpmiles+ " got displayed successfully");
	actionLib.NavigateBack();
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobileOffersanddeals, "Click on Offersanddeals");
	Thread.sleep(5000);
	//actionLib.JSClick(JetPrevPageLocators.ourprogramSubheading, "Click on Offersanddeals subheading");
	//actionLib.JSClick(JetPrevPageLocators.offeranddealSubheader, "Click on offeranddealSubheader");
	actionLib.validateCheckStyle(JetPrevPageLocators.offersanddealsHeader,"offersanddealsHeaderFirefox");
	String headerOffersanddeals = actionLib.getElementText(JetPrevPageLocators.offersanddealsHeader, "get the text of the header");
	extentLogs.info("Verified Offersanddeals header", headerOffersanddeals+ " got displayed successfully");
	actionLib.NavigateBack();
	
	//actionLib.JSClick(JetPrevPageLocators.logoEarn, "Click on logo");
	actionLib.JSClick(JetPrevPageLocators.mobilebooknow, "Click on booknow");
	//actionLib.JSClick(JetPrevPageLocators.booknowSubheading, "Click on booknow subheading");
	Thread.sleep(3000);
	actionLib.validateCheckStyle(JetPrevPageLocators.booknowHeader,"booknowHeaderFirefox");
	Thread.sleep(3000);
	String headerBooknow = actionLib.getElementText(JetPrevPageLocators.booknowHeader, "get the text of the header");
	extentLogs.info("Verified our program header", headerBooknow+ " got displayed successfully");
	actionLib.NavigateBack();
}
catch(Exception e) {
	e.printStackTrace();
	blnstatus = false;
}
return blnstatus;
}



/***************************************
 * Function Name :-fnHeaderBrandingNew
 * Return Type:- boolean
 * Date:-19-Mar-2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnHeaderBrandingNew() throws Throwable{
Boolean blnstatus = true;
try {
		
	actionLib.validateCheckStyle(JetPrevPageLocators.headerLogo, "HeaderLogo");
	actionLib.validateCheckStyle(JetPrevPageLocators.countryShortName, "CountryShortName");
	actionLib.validateCheckStyle(JetPrevPageLocators.countryIcon, "CountryIcon");
	actionLib.validateCheckStyle(JetPrevPageLocators.guidedTour, "GuidedTour");
	actionLib.validateCheckStyle(JetPrevPageLocators.searchIcon, "SearchIcon");
	actionLib.validateCheckStyle(JetPrevPageLocators.enrolLink, "EnrolLink");
	//actionLib.validateCheckStyle(JetPrevPageLocators.loginStyles, "LoginStyles");
	actionLib.validateCheckStyle(JetPrevPageLocators.ourProgramNew, "OurProgramLinks");
	
	actionLib.validateCheckStyle(JetPrevPageLocators.earnJpMilesNew, "CountryIcon");
	actionLib.validateCheckStyle(JetPrevPageLocators.earnJpMilesNew, "CountryIcon");
	actionLib.validateCheckStyle(JetPrevPageLocators.useJPMilesNew, "GuidedTour");
	actionLib.validateCheckStyle(JetPrevPageLocators.useJPMilesNew, "GuidedTour");
	actionLib.validateCheckStyle(JetPrevPageLocators.offersDealsNew, "SearchIcon");
	actionLib.validateCheckStyle(JetPrevPageLocators.offersDealsNew, "SearchIcon");
	actionLib.validateCheckStyle(JetPrevPageLocators.bookNowNew, "EnrolLink");
	actionLib.validateCheckStyle(JetPrevPageLocators.bookNowNew, "EnrolLink");
	
}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



/***************************************
 * Function Name :-fnBrandingGuidelinesFooter
 * Return Type:- boolean
 * Date:-19-Mar-2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnBrandingGuidelinesFooter() throws Throwable{ 
Boolean blnstatus = true;
try {
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.featuredOffer,"FeaturedOffer");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.copyRights, "CopyRights");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.imG, "BrickImgContainer");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.footerBackground, "FooterBackground");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.faceBook, "FaceBook");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.twitter, "Twitter");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.youTube, "YouTube");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.linkedIn, "LinkedIn");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.pinInterest, "PinInterest");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.instaGram, "Instagram");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.newImage, "New");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.featuredStar, "FeaturedStar");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.aboutUs, "AboutUs");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.socialImpact,"SocialImpact");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.contactUs, "ContactUs");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.faq,"FAQ");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.pressRoom, "PressRoom");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.carrers,"Carrers");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.termsConditions, "TermsConditions");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.disclaimerPolicies,"DisclaimerPolicies");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.siteMap, "SiteMap");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.india,"India");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.indiaMetrocities, "IndiaMetrocities");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.begaluruandInfo,"BegaluruandInfo");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.otherCities, "OtherCities");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.otherCitiesInfo,"OtherCitiesInfo");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.unitedKingdom, "UnitedKingdom");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.unitedKingdomNumber,"UnitedKingdomNumber");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.uSa, "USA");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.usaNumber,"USANumber");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.tollFree, "TollFree");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.connectWithUs, "ConnectWithUs");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.extraIconMargin, "ExtraIconMargin");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.indicatesThatsu, "IndicatesThatsu");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.indicatesthatUIconMargin,"IndicatesthatUIconMargin");
	
	
	
}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




public boolean fnBrandingGuidelinesHeader() throws Throwable{
Boolean blnstatus = true;
try {
	
	actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	//actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar, "Calendar");
	
//	fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendar, "Calendar");
	
	
	/*actionLib.validateCheckStyle(JetPrev_Smoke_Locators.headerLogo1, "HeaderLogo");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.countryShortName1, "CountryShortName");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.countryIcon1, "CountryIcon");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.guidedTour1, "GuidedTour");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.searchIcon1, "SearchIcon");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.enrolLink1, "EnrolLink");*/
	//actionLib.validateCheckStyle(JetPrevPageLocators.loginStyles, "LoginStyles");
	
/*
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.ourProgramNew1, "OurProgram");
	
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.earnJpMilesNew1, "earnjpmilesHeader");
	
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.useJPMilesNew1, "usejpmilesHeader");
	
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.offersDealsNew1, "offersanddealsHeader");
	
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.bookNowNew1, "BooknowHeader");

	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.headerbackGround, "HeaderSite");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.ourprogramIcons1, "OurProgrammeicon");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.earnJpmilesIcon1, "EarnJPMilesicon");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.useJpmilesIcon1, "UseJPMilesicon");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.offersAndDealsIcon1, "Offerdealsicon");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.bookNowIcon1, "Booknowicon");*/
}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

/***************************************
 * Function Name :-fncomponentcalendar
 * Return Type:- boolean
 * Date:-25-Jan-2018
 * Author:-Nithin
 * @throws Throwable 
 */
public boolean fncomponentcalendarold(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {
	
	
	actionLib.OpenUrl(objData.AppURL);

	//driver.get("http://jppluat.jetprivilege.com/");
	//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");
	
	//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	/*String str = actionLib.getElementText(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	if(str.contains("Enrol")) {
	actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	}*/
	/*actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.calendarnew, 60);
	if(driver.findElement(By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']")).isDisplayed()) {*/
		
		actionLib.waitForElementPresent(JetPrev_Smoke_Locators.calndr, 3000);
		extentLogs.info("Calendar Component", "Calendar component is present");
	
	List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']"));
	System.out.println(tagnames.size());
	for(int i=1;i<=tagnames.size();i++) {
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar(i), "Calendar");
		
		fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendarmobile(i), "Calendar");
		
	
	
	/*Iterator<WebElement> iterator = tagnames.iterator();
	while (iterator.hasNext()){
		 

	
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar, "Calendar");
	
	fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendar, "Calendar");
	iterator.next();

	}
	*/	}
}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fncomponentcalendarIE(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {
	
	
	actionLib.OpenUrl(objData.AppURL);

	//driver.get("http://jppluat.jetprivilege.com/");
	//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");
	
	//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	/*String str = actionLib.getElementText(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	if(str.contains("Enrol")) {
	actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
	}*/
/*	actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.calendarnew, 60);
	if(driver.findElement(By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']")).isDisplayed()) {
		*/
		actionLib.waitForElementPresent(JetPrev_Smoke_Locators.calndr, 3000);
		extentLogs.info("Calendar Component", "Calendar component is present");
	
	List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']"));
	System.out.println(tagnames.size());
	for(int i=1;i<=tagnames.size();i++) {
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar(i), "CalendarIE");
		
		fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendarmobile(i), "Calendar");
		
	}
	
	/*Iterator<WebElement> iterator = tagnames.iterator();
	while (iterator.hasNext()){
		 

	
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar, "Calendar");
	
	fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendar, "Calendar");
	iterator.next();

	}
	*/	
}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



/***************************************
 * Function Name :-fncomponentcalendarmobile
 * Return Type:- boolean
 * Date:-25-Jan-2018
 * Author:-Nithin
 * @param AppURL 
 * @throws Throwable 
 */
public boolean fncomponentcalendarmobile(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {
	
	
	actionLib.OpenUrl(objData.AppURL);
	
	extentLogs.info("Calendar Component", "Calendar component is present");
	
	List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']"));
	System.out.println(tagnames.size());
	for(int i=1;i<=tagnames.size();i++) {
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar(i), "CalendarMobile");
		
		fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendar(i), "CalendarMobile");
	
	}
	}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

/***************************************
 * Function Name :-fncomponentcalendartablet
 * Return Type:- boolean
 * Date:-25-Jan-2018
 * Author:-Nithin
 * @param AppURL 
 * @throws Throwable 
 */
public boolean fncomponentcalendartablet(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {
	
	
	actionLib.OpenUrl(objData.AppURL);
	
	
	
	List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']"));
	System.out.println(tagnames.size());
	for(int i=1;i<=tagnames.size();i++) {
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.calendar(i), "CalendarTablet");
		
		fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.calendar(i), "Calendar");
	
	}
	}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentsWebaccesibility(JetPrevInput objData) throws Throwable {
	Boolean blnstatus = true;
	String str = null;
	
	try {

	//	actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("form"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			try {
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("id");
			System.out.println(str);
			if(str.contains("ctl00")){
				driver.findElement(By.xpath("//form[@id='"+str+"']")).click();
				int icounter=0;
				boolean flag=false;
				do {
					//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
					
					Actions a = new Actions(driver);
					a.sendKeys(Keys.TAB).build().perform();
					Thread.sleep(3000);
					String strClass=actionLib.getAttributeFromFocusedElement("class");
					String strClassAttribute="class";
					if(strClass.isEmpty()) {
						strClass=actionLib.getAttributeFromFocusedElement("id");
						 strClassAttribute="id";
					}
					if(strClass.isEmpty()) {
						strClass=actionLib.getAttributeFromFocusedElement("name");
						strClassAttribute="name";
					}
					if(!strClass.isEmpty()) {
					Thread.sleep(3000);
					flag=strClass.contains("back-to-top");
					
					Thread.sleep(3000);
					if(flag) {
						extentLogs.info("validate checkStyle of an element", "'"+strClass+"'");
						actionLib.validateCheckStyleAllComponents(driver.findElement(By.xpath("//*[@"+strClassAttribute+"='"+strClass+"']")), "WebaccessibiltyFocus");
						
						break;
						
					}else {
						icounter++;
					}
					extentLogs.info("validate checkStyle of an element", "'"+strClass+"'");
				actionLib.validateCheckStyleAllComponents(driver.findElement(By.xpath("//*[@"+strClassAttribute+"='"+strClass+"']")), "WebaccessibiltyFocus");
				
					}
				} while (icounter<63&&!flag);
			
			}
						}
			}
			catch(Exception e) {
				continue;
			}
		
 
		}
		
		//fnComponentLabel(objData);
		
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentTooltiptext(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "helpText";
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			try {
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains("helpText")){
				
				Actions a = new Actions(driver);
				a.moveToElement(linkone.get(i)).build().perform();
			java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//span[@class='helpText']//span"));
			System.out.println(linktwo.size());
			for (int j = 0; j<linktwo.size(); j++)
	 		{
			//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
			actionLib.validateCheckStyleAllComponents(linktwo.get(j), "HelpTextMessage");
			}
						}else {
							extentLogs.warning("JetPrev Component TooltipText ","TooltipText Component class : "+str1+" is not available on : " + objData.AppURL );
							ReportStatus.blnElementStatus=false;
							
						}
			}
			}
			catch(Exception e) {
				continue;
			}
		
 
		}
		
		
		
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}






public boolean fnComponentHelptext(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "helpText";
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			try {
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains("helpText")){
			//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
			actionLib.validateCheckStyleAllComponents(linkone.get(i), "HelpText");
			blnstatus=ReportStatus.blnStatus;
			if(blnstatus==false)
			{
				blnstatus=false;
			}
			}else {
				extentLogs.warning("JetPrev Component HelpText ","HelpText Component class : "+str1+" is not available on : " + objData.AppURL );
				ReportStatus.blnElementStatus=false;
			}
						}
			}
			catch(Exception e) {
				continue;
			}
		
 
		}
		
		
		
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentMandatory(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "errorText";
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains(str2)) {
				actionLib.validateCheckStyleAllComponents(linkone.get(i), "MandatoryField");
				blnstatus=ReportStatus.blnStatus;
				if(blnstatus==false)
				{
					blnstatus=false;
				}
			}
			else {
				extentLogs.warning("JetPrev Component Mandatory ","Mandatory Component class : "+str2+" is not available on : " + objData.AppURL );
				ReportStatus.blnElementStatus=false;    
			}
		     }
 		}
	}
		     catch(Exception e) {
		    	 e.printStackTrace();
		    	 blnstatus = false;
		    	 }
		    	 return blnstatus;
		    	 }


public boolean fnComponentCalendar(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "jppl-sprites ui-icon-datepicker";
	
	try {
		System.out.println(objData.AppURL);
		
		//actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
		    if(linkone.get(i).isDisplayed())
		    {
					str = linkone.get(i).getAttribute("class");
					System.out.println(str);
					if(str.contains(str2)) 
					{
										String str1 = linkone.get(i).getText();
										System.out.println(str1);
									if(str1!=null) {
									extentLogs.info("Webaccessibility of calendar field  : "+str, "is displayed successfully.");
									}
									System.out.println(str);
									actionLib.validateCheckStyleAllComponents(linkone.get(i), "CalendarIE");
									blnstatus=ReportStatus.blnStatus;
									if(blnstatus==false)
									{
										blnstatus=false;
									}
									
					}
					else 
					{
							extentLogs.warning("JetPrev Component Calendar ","Calendar Component class : "+str2+"is not available on : " + objData.AppURL );
							ReportStatus.blnElementStatus=false;
					}
			}
 		}
	}
catch(Exception e) 
	{
   	 e.printStackTrace();
	 blnstatus = false;
	}
	return blnstatus;
	}


public boolean fnComponentTextField(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str3 = "text";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[not(contains(@class,'_'))]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
    	 if(linktwo.get(i).isEnabled()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains(str3)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		String str1 = linktwo.get(i).getAttribute("aria-describedby");
		System.out.println(str1);
		if(str1!=null) {
		extentLogs.info("Webaccessibility of text field aria-describedby :"+str1, "is displayed successfully.");
		}
		String str2 = linktwo.get(i).getAttribute("aria-label");
		System.out.println(str2);
		if(str2!=null) {
		extentLogs.info("Webaccessibility of text field aria-label :"+str, "is displayed successfully.");
		}
	try {
		
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextField");
		blnstatus=ReportStatus.blnStatus;
		if(blnstatus==false)
		{
			blnstatus=false;
		}
		/*Thread.sleep(4000);
		Actions a = new Actions(driver);
		 actionLib.HighlightWebElement(linktwo.get(i), 15);
		a.moveToElement(linktwo.get(i),1,1).build().perform();
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", linktwo.get(i));
		linktwo.get(i).clear();
		linktwo.get(i).click();
		linktwo.get(i).sendKeys("1");
		
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldType");*/
	} catch (Exception e) {
		// TODO Auto-generated catch block
		continue;
	}
	}
	else {
		extentLogs.warning("JetPrev Component Textfield ","Textfield Component class : "+str3+"is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;    
	}
	
	}
    }
	}
	}
     
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTextFieldFocus(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str3 = "text";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[not(contains(@class,'_'))]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
    	 if(linktwo.get(i).isEnabled()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains(str3)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		String str1 = linktwo.get(i).getAttribute("aria-describedby");
		System.out.println(str1);
		if(str1!=null) {
		extentLogs.info("Webaccessibility of text field aria-describedby :"+str, "is displayed successfully.");
		}
		String str2 = linktwo.get(i).getAttribute("aria-label");
		System.out.println(str2);
		if(str2!=null) {
		extentLogs.info("Webaccessibility of text field aria-label :"+str, "is displayed successfully.");
		}
	try {
		
		/*actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextField");
		Thread.sleep(4000);*/
		Actions a = new Actions(driver);
		 actionLib.HighlightWebElement(linktwo.get(i), 5);
		a.moveToElement(linktwo.get(i),1,1).build().perform();
		/*JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", linktwo.get(i));*/
		linktwo.get(i).clear();
		/*linktwo.get(i).click();
		linktwo.get(i).sendKeys("1");
*/		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocus");

		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		continue;
	}
	}else {
		extentLogs.warning("JetPrev Component TextfieldFocus ","TextfieldFocus Component class : "+str3+"is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	
	}
    }
	}
	}
     
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTextFieldFocusTyped(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str3 = "text";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[not(contains(@class,'_'))]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
    	 if(linktwo.get(i).isEnabled()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains("text")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		String str1 = linktwo.get(i).getAttribute("aria-describedby");
		System.out.println(str1);
		if(str1!=null) {
		extentLogs.info("Webaccessibility of text field aria-describedby :"+str, "is displayed successfully.");
		}
		String str2 = linktwo.get(i).getAttribute("aria-label");
		System.out.println(str2);
		if(str2!=null) {
		extentLogs.info("Webaccessibility of text field aria-label :"+str, "is displayed successfully.");
		}
	try {
		
		/*actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextField");
		Thread.sleep(4000);*/
		Actions a = new Actions(driver);
		 actionLib.HighlightWebElement(linktwo.get(i), 15);
		a.moveToElement(linktwo.get(i),1,1).build().perform();
		/*JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", linktwo.get(i));*/
		linktwo.get(i).clear();
		/*linktwo.get(i).click();
		linktwo.get(i).sendKeys("1");
*/		linktwo.get(i).sendKeys("abcd");
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocusTyped");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		continue;
	}
	}else {
		extentLogs.info("JetPrev Component TextfieldFocustyped ","TextfieldFocustyped Component class : "+str3+"is not available on : " + objData.AppURL );
    }
	
	}
    }
	}
	}
     
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}





public boolean fnComponentCheckbox(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "checkbox";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	extentLogs.info("JetPrev Component Checkbox Inactive ","Input tag is available and class : "+str+" is available on on : " + objData.AppURL );
	if(str.contains("checkbox")) {
		try {
			extentLogs.info("JetPrev Component Checkbox Inactive ","Input tag is available and class : "+str2+" is available on : " + objData.AppURL );
		
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "CheckboxInactive");
			blnstatus=ReportStatus.blnStatus;
			if(blnstatus==false)
			{
				blnstatus=false;
			}
				} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
	}
	else {
		//extentLogs.info("JetPrev Component Checkbox Inactive ","checkbox Inactive Component class : "+str2+" is not available on : " + objData.AppURL );
	}
	}
     
     extentLogs.warning("JetPrev Component Checkbox Inactive ","Input tag is available but class : "+str2+" is not available on : " + objData.AppURL );
     ReportStatus.blnElementStatus=false;
	}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }




public boolean fnComponentCheckboxActive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "CheckboxActive";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
	driver.findElement(By.xpath("//form[@name='ctl00']")).click();	
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	extentLogs.info("JetPrev Component Checkbox Inactive ","Input tag is available and class : "+str+" is available on on : " + objData.AppURL );

	if(str.contains("checkbox")) {
		try {
			Actions a = new Actions(driver);
			 
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			try {
				a.click(linktwo.get(i)).build().perform();
				extentLogs.info("JetPrev Component Checkbox active ","Input tag is available and class : "+str2+" is available on : " + objData.AppURL );

				actionLib.validateCheckStyleAllComponents(linktwo.get(i), "CheckboxActive");
				blnstatus=ReportStatus.blnStatus;
				if(blnstatus==false)
				{
					blnstatus=false;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
	}
	else {
		extentLogs.warning("JetPrev Component Checkbox active ","checkbox active Component class : "+str2+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	}}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }



public boolean fnComponentRadioButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = "radio";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		driver.findElement(By.xpath("//form[@name='ctl00']")).click();	
		Thread.sleep(2000);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label[@for][1]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	/*str = linktwo.get(i).getAttribute("type");
	System.out.println(str);*/
	/*if(str.contains("radio")) {*/
		try {
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "RadiobuttonInactive");
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			a.click(linktwo.get(i)).build().perform();
			//a.click(driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label[@for][1]")));
			//driver.findElement(By.xpath("//input[@type='"+str+"']")).click();
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			Thread.sleep(4000);
			//a.moveToElement(driver.findElement(By.xpath("//input[@type='radio']/following-sibling::label[@for][1]"))).build().perform();
			//linktwo.get(i).click();
			Thread.sleep(2000);
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "RadiobuttonActive");
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
	/*}*/
     }
     else{
  		extentLogs.warning("JetPrev Component Radio ","Radio Component class : "+str+" is not available on : " + objData.AppURL );
  		ReportStatus.blnElementStatus=false; 
     } 
	}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }



public boolean fnComponentPasswordText(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "password";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains(str2)) {
		try {
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextField");
			//Actions a = new Actions(driver);
			//a.click(driver.findElement(By.xpath("//input[@type='"+str+"']")));
			//driver.findElement(By.xpath("//input[@type='"+str+"']")).click();
			Actions a = new Actions(driver);
			 actionLib.HighlightWebElement(linktwo.get(i), 15);
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			linktwo.get(i).clear();
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocus");
			//driver.findElement(By.xpath("//input[@type='"+linktwo.get(i)+"']")).sendKeys("abcd");
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			linktwo.get(i).sendKeys("abcd");
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocusTyped");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
     }else{
 		extentLogs.warning("JetPrev Component passwordtext ","passwordtext Component class : "+str2+" is not available on : " + objData.AppURL );
 		ReportStatus.blnElementStatus=false;
     }}}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }



public boolean fnComponentPrimaryButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "btnblue";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	

if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("class");
	System.out.println(str);
	if(str.contains(str2)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linktwo.get(i), "PrimaryButton");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	}
	else {
		extentLogs.warning("JetPrev Component Primarybutton ","Primarybutton Component class : "+str2+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	/*if(str.contains("btnStyle  SubmitFocus")) {
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "BlueButtontwo");
	}*/
	
}

}

}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }


public boolean fnComponentSecondaryButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "btnStyle  SubmitFocus";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	

if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("class");
	System.out.println(str);
	/*if(str.contains("btnblue")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linktwo.get(i), "Bluebutton");
	}*/
	// str2= new String("btnStyle  SubmitFocus");
	if(str.contains(str2)) {
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "SecondaryButton");
		blnstatus=ReportStatus.blnStatus;
		if(blnstatus==false)
		{
			blnstatus=false;
		}
	}
	
}
else {
	extentLogs.warning("JetPrev Component SecondaryButton ","SecondaryButton Component class : "+str2+" is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
}
	}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }


public boolean fnComponentLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("label"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("label");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("text")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "InputField");
	}
	if(str.contains("checkbox")) {
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ButtonBlue");
	}
	else {
		ReportStatus.blnElementStatus=false;
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentExternalLink(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "extImageIcon";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("span"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ExternalLink");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	}
	else {
		extentLogs.warning("JetPrev Component ExternalLink ","ExternalLink Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentPDFandPRINT(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 ="/iwov-resources/images/tnc/icon-pdf-new.png";
	String str2 = "/iwov-resources/images/tnc/print-icon.png";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("img"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("src");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PDFPrint");
	}
	else {
		extentLogs.warning("JetPrev Component PDF ","PDF Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	if(str.contains(str2)){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PDFPrint");
		}else {
			extentLogs.warning("JetPrev Component Print ","Print Component class : "+str1+" is not available on : " + objData.AppURL );
			ReportStatus.blnElementStatus=false;
		}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentCountryIcon(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "countryIcon";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "CountryIcon");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	}
	else {
		extentLogs.warning("JetPrev Component CountryIcon ","CountryIcon Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentoutsideButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "formFooter";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OutsideButton");
	}
	else {
		extentLogs.warning("JetPrev Component OutsideButton ","OutsideButton Component class : "+str1+" is not available on : " + objData.AppURL );
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




public boolean fnComponentActionButtonExternalURL(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "btnblue SubmitFocus extLinkBtn";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("input"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str2)){
	
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ActionButtonExternalURL");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	}
	else {
		extentLogs.warning("JetPrev Component ActionButtonExternalURL ","ActionButtonExternalURL Component class : "+str2+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean loginGlobal(WebDriver dr,JetPrevInput objData) {
	Boolean blnstatus = true;
	try {
				
			
			dr.findElement(By.xpath("//div[@class='loginWrapper']")).click();
			Thread.sleep(2000);
			dr.findElement(By.xpath("//div[@class='loginWrapper']")).click();
			Thread.sleep(1000);
    		dr.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
    		Thread.sleep(1000);
    		dr.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
    		Thread.sleep(1000);
    		dr.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
    		Thread.sleep(2000);
    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
    		Thread.sleep(3000);
    		//actionLib.OpenUrl(objData.AppURL);
			
			
			
			
				}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		blnstatus = false;
	}
	return blnstatus;
}

public boolean fnComponentwhitebtn(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "whiteBtn";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
				

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("input"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "WhiteBtn");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}
	else {
		extentLogs.warning("JetPrev Component WhiteBtn ","WhiteBtn Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}







public boolean fnComponentoldFormLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				/*
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("label"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("handHeldHide")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormLabel");
	}
	if(str.contains("floating-label")){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormLabel");
		}
	
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentoldFormLabelupdated(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "formLabel";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
    	 
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormLabel");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	}
	else {
		extentLogs.warning("JetPrev Component OldFormLabel ","OldFormLabel Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentNewFormLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//div[@class='formLabel']/label"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	if(linkthree.get(i).isDisplayed()) {
     /*if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formLabel")){*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewFormLabel");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	}else {
		extentLogs.warning("JetPrev Component NewFormLabel ","NewFormLabel Component is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	}
	
     }
	/*}
	}
	}*/

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}









public boolean fnComponentExpandtitle(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "expandcollapsetitle accordian";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ExpandTitle");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	/*Actions a = new Actions(driver);
	a.moveToElement(linkthree.get(i)).build().perform();
	JavascriptExecutor ex = (JavascriptExecutor) driver;
	ex.executeScript("arguments[0].click();", linkthree.get(i));
	a.click(linkthree.get(i));
	Thread.sleep(2000);
	linkthree.get(i).click();
	Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(driver.findElement(By.xpath("//span[@class='openaccordian']")), "OpenTitle");
	*/
	}
	else {
		extentLogs.warning("JetPrev Component ExpandTitle ","ExpandTitle Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentTable2(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "trackerTable table";
	
	try {
	/*	actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Tabletrack2");	
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}

	}else {
		
		extentLogs.warning("JetPrev Component table2 ","Table2 Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
		
     }
	}
	}


	}


catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTable2Caption(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "trackerTable table";
	
	try {
		java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
		System.out.println(linkthree.size());
		for (int i = 0; i<linkthree.size(); i++)
			{
			
		     if(linkthree.get(i).isDisplayed()) {
			str = linkthree.get(i).getAttribute("class");
			System.out.println(str);
			if(str!=null) {
			if(str.contains(str1)) {

java.util.List<WebElement> linkfour = driver.findElements(By.xpath("//table[@class='trackerTable table  ']//caption[1]"));
System.out.println(linkfour.size());
for (int j = 0; j<linkfour.size(); j++) {
	 if(linkfour.get(j).isDisplayed()) {
			actionLib.validateCheckStyleAllComponents(linkfour.get(j), "Tablecaption2");
			blnstatus=ReportStatus.blnStatus;
			if(blnstatus==false)
			{
				blnstatus=false;
			}
		}else {
			
				
				extentLogs.warning("JetPrev Component table2caption ","Table2caption Component class : is not available on : " + objData.AppURL );
				ReportStatus.blnElementStatus=false;
		}
	 
	 }
	}
		}
		    }
		    	}
	}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


			


public boolean fnComponentCommonTable(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "table-bluepatch";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);

		/*try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("table-bluepatch")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "CommonTable");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
		}else {
			extentLogs.warning("JetPrev Component Commontable ","CommomTable Component class : "+str1+" is not available on : " + objData.AppURL );
			ReportStatus.blnElementStatus=false;
		}}
     }
	}
	}
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentCommonTableCaption(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	
	try {
		
		
java.util.List<WebElement> linkfour = driver.findElements(By.xpath("//table[@class='trackerTable table  ']//caption[1]"));
System.out.println(linkfour.size());
for (int i = 0; i<linkfour.size(); i++) {
if(linkfour.get(i).isDisplayed()) {
			actionLib.validateCheckStyleAllComponents(linkfour.get(i), "CommonTablecaption");
			blnstatus=ReportStatus.blnStatus;
			if(blnstatus==false)
			{
				blnstatus=false;
			}
		}else {
			ReportStatus.blnElementStatus=false;
		}
		}
	}


catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTable4(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "orangeBorderless";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("orangeBorderless")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Table4");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
		}  else {
			extentLogs.warning("JetPrev Component Table4 ","Table4 Component class : "+str1+" is not available on : " + objData.AppURL );
			ReportStatus.blnElementStatus=false;
		}   }
	}
	}

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTable4Caption(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = "table caption";
	String str1 = null;
	
	try {
		
		

java.util.List<WebElement> linkfour = driver.findElements(By.tagName("caption"));
System.out.println(linkfour.size());
for (int i = 0; i<linkfour.size(); i++) {
if(linkfour.get(i).isDisplayed()) {
	str1 = linkfour.get(i).getAttribute("class");
	System.out.println(str1);
	if(str!=null) {
		if(str1.contains("table caption")) {
			actionLib.validateCheckStyleAllComponents(linkfour.get(i), "Tablecaption4");
			blnstatus=ReportStatus.blnStatus;
			if(blnstatus==false)
			{
				blnstatus=false;
			}
		}else {
			extentLogs.warning("JetPrev Component CommonTable4Caption ","CommonTable4Caption Component class : "+str+" is not available on : " + objData.AppURL );
			ReportStatus.blnElementStatus=false;
		}
	}
}
}

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}





public boolean fnComponentoldFormContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "formContainer";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormContainer");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
		}else {
			extentLogs.warning("JetPrev Component OldFormContainer ","OldFormContainer Component class : "+str1+" is not available on : " + objData.AppURL );
			ReportStatus.blnElementStatus=false;}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentoldInnerContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "innerContainer";
	
	try {
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	
	if(str.contains("innerContainer")) {
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormInnerContainer");
		blnstatus=ReportStatus.blnStatus;
		if(blnstatus==false)
		{
			blnstatus=false;
		}
	}else {
		
		extentLogs.warning("JetPrev Component OldFormInnerContainer ","OldFormInnerContainer Component class : "+str1+" is not available on : " + objData.AppURL );	
		ReportStatus.blnElementStatus=false;}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}





/*public boolean fnComponentoldFormInnerContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("innerContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewInnerContainer");
	if(str.contains("formContainer")){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewFormContainer");
	}
		
     }
	}
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}*/



public boolean fnComponentNewFormContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "formContainer";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewFormContainer");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
     }
	else {
		extentLogs.warning("JetPrev Component NewFormContainer ","NewFormContainer Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	}
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentNewInnerContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "innerContainer";
	
	try {
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	
	
	if(str.contains(str1)){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewInnerContainer");
		blnstatus=ReportStatus.blnStatus;
		if(blnstatus==false)
		{
			blnstatus=false;
		}
	}
		
     }
	else {
		extentLogs.warning("JetPrev Component NewInnerContainer ","NewInnerContainer Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	
	}
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}





public boolean fnComponentNewFormInnerContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				/*
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("innerContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewInnerContainer");
	
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentMFbutton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "loginformbtn";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionLib.OpenUrl(objData.AppURL);*/
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "MFButton");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		extentLogs.warning("JetPrev Component MFButton ","MFButton Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentP(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("p"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
/*	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("mainHeading")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
*/	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "P");
blnstatus=ReportStatus.blnStatus;
if(blnstatus==false)
{
	blnstatus=false;
}
	
	}else {
		extentLogs.warning("JetPrev Component P ","P Component is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	 
	   }
    
	     }

	

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentH1(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "mainHeading";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		
		
/*
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("h1"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "H1");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		extentLogs.warning("JetPrev Component H1 ","H1 Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	 }
	   }
    
	     }

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentH2(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "pageheading";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("h2"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "H2");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		extentLogs.warning("JetPrev Component H2 ","H2 Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}

	
	 }
	   }
	     }

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}







public boolean fnComponentH3(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "pwdPolicyHead";
	
	try {
		  /*  actionLib.OpenUrl(objData.AppURL);
		

			try {
				if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
					
					
					driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
					Thread.sleep(1000);
		    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
		    		Thread.sleep(1000);
		    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
		    		Thread.sleep(1000);
		    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		    		Thread.sleep(2000);
		    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
		    		Thread.sleep(20000);
		    		actionLib.OpenUrl(objData.AppURL);
					
					
					
					
					driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
					Thread.sleep(20000);
					actionLib.OpenUrl(objData.AppURL);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		   // actionLib.OpenUrl(objData.AppURL);
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("h3"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pwdPolicyHead")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "h3");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		extentLogs.warning("JetPrev Component H3 ","H3 Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnbreadcrum(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "breadcrum";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
		//Thread.sleep(4000);
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Breadcrum");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}else {
		ReportStatus.blnElementStatus=false;
	}
	
	}
	extentLogs.warning("JetPrev Component Breadcrum ","Breadcrum Component class : "+str1+" is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnbreadcrumpresentation(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "presentation";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		
/*
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		//actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("role");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PresentationIE");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		extentLogs.warning("JetPrev Component Breadcrum Preentation ","Breadcrum Preentation Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	
	 }
	   }
	     }
	}}
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentSecondaryText(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		

		/*try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("span"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("secondaryText")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SecondaryText");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpostNotifications(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("postloginnotifications")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PostloginNotifications");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}
	else {
		ReportStatus.blnElementStatus=false;
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentIconNotifications(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "icon icon-icon-notification";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		


		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	
	    //actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("span"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("icon icon-icon-notification")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "IconIconNotification");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		extentLogs.warning("JetPrev Component IconIconNotification ","IconIconNotification Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentOldformLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		

		/*try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formTemplate")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormtemplate");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentNewformLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				/*
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formTemplate")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormtemplate");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponenttabPopup(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
		Thread.sleep(3000);
	if(str.contains("tooltipmessages")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Tooltipmessage");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentSuccessMessage(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("successBox")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SuccessMessage");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentErrorIcon(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("erroricon")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ErrorIcon");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentPinCount(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pin-cont")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PinCont");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




public boolean fnComponentPinNote(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pin-note")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PinNote");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}






public boolean fnComponentThirdlevelTabActive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='desktabs tablist']//li"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pin-note")){*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ThirdLeveltabActive");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		ReportStatus.blnElementStatus=false;
	}
	 }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentThirdLevelTabInactive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("ul"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("desktabs tablist")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ThirdLeveltabInactive");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		ReportStatus.blnElementStatus=false;
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentContentLevelTab(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "desklist active";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		
		

		/*try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='tabs tablist4 platinumChkBox bandp']//li"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("desklist active")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ContentLeveltabActive");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	extentLogs.warning("JetPrev Component ContentLeveltabActive ","ContentLeveltabActive Component class : "+str1+" is not available on : " + objData.AppURL );
	
	}else{ReportStatus.blnElementStatus=false;}
	
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentContentLevelTabInactive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "desklist";
	
	try {
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='tabs tablist4 platinumChkBox bandp']//li"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("desklist")){
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ContentLeveltabInActive");
		blnstatus=ReportStatus.blnStatus;
		if(blnstatus==false)
		{
			blnstatus=false;
		}
	}else {
		extentLogs.warning("JetPrev Component ContentLeveltabInactive ","ContentLeveltabInactive Component class : "+str1+" is not available on : " + objData.AppURL );
		ReportStatus.blnElementStatus=false;
		
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentpartnerbricktypeOne(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("partnerDetailLink")){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbricktypeOne");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
		ReportStatus.blnElementStatus=false;
	}
	
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentpartnerbrickA(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "detailsBtn";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("fr brickDetailsLink marginT2")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		Actions a = new Actions(driver);
		a.moveToElement(linkthree.get(i), 1, 1).build().perform();
		a.click(linkthree.get(i));
		linkthree.get(i).click();
		//linkthree.get(i).click();
		
		List<WebElement> linkfour = driver.findElements(By.xpath("//div[@class='partnerDetailsWrapper']//div//a"));
		System.out.println(linkfour.size());
	/*	String str1 = null;
		for(int j=0;j<linkfour.size();j++) {
			if(linkfour.get(j).isDisplayed()) {
			str1 = linkfour.get(i).getAttribute("class");
			if(str1!=null) {
			if(str1.contains(str2)) {*/
		
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbrickA");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
			}
			extentLogs.warning("JetPrev Component partnerbrickA ","partnerbrickA Component class : "+str2+"is not available on : " + objData.AppURL );
			ReportStatus.blnElementStatus=false;
			
			
			/*	}
			}
		}
	}
	*/
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpartnerbricktypeTwo(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "offerBrickContainer";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		

		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str2)){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbricktypeTwo");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}
	extentLogs.warning("JetPrev Component partnerbricktypeTwo ","partnerbricktypeTwo Component class : "+str2+"is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	}
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpartnerbricktypeTwoFooter(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "cardDetailCont";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbricktypeTwoFooter");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}
	extentLogs.warning("JetPrev Component partnerbricktypeTwoFooter ","partnerbricktypeTwoFooter Component class : "+str2+"is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	}
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentpartnerbrickonRHS(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "partnerDetailLink";
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("partnerDetailLink")){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbrickonRHS");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}
	extentLogs.warning("JetPrev Component partnerbrickonRHS ","partnerbrickonRHS Component class : "+str2+ " is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	}
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpartnerbrickonRHSDetail(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		extentLogs.info("JetPrev Component partnerbrickonRHSDetail ","partnerbrickonRHSDetail Component class : "+str2+" is available on : " + objData.AppURL );
		Thread.sleep(1000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbrickonRHSDetail");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
	extentLogs.warning("JetPrev Component partnerbrickonRHSDetail ","partnerbrickonRHSDetail Component class : "+str2+" is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	} 
	}
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentSecondLevelInactive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='desktabs tablist']//li//a"));  

//List<WebElement> childs = rootWebElement.findElements(By.xpath(".//*"));


System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    		extentLogs.info("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SecondLevelInactive");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
	extentLogs.warning("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component class : "+str2+" is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	}
	 }
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentSecondLevelActive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		/*actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='desktabs tablist']//li//a//span"));   
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    	 extentLogs.info("JetPrev Component SecondLevelActive ","SecondLevelActive Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
    	 
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SecondLevelActive");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
	extentLogs.warning("JetPrev Component SecondLevelActive ","SecondLevelActive Component class : "+str2+" is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	} 
	}
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTabPopupComponent(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//div[@class='loginWrapper']")).isDisplayed()) {
				
				
				driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
				Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	    		Thread.sleep(2000);
	    		actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")));
	    		Thread.sleep(20000);
	    		actionLib.OpenUrl(objData.AppURL);
				
				
				
				/*
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);*/
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//li[@role='tooltip']"));   
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	Actions a = new Actions(driver);
	a.moveToElement(linkthree.get(i)).build().perform();
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    	 extentLogs.info("JetPrev Component Tabpopup ","Tabpopup Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Tabpopupcomponent");
	
	}else {
	extentLogs.warning("JetPrev Component Tabpopup","Tabpopup Component class : "+str2+" is not available on : " + objData.AppURL );
	} 
	}
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentToasterPopup(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		
		/*try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Thread.sleep(2000);
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//div[@class='popupcontent']"));   
//System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    	 extentLogs.info("JetPrev Component ToasterPopup ","ToasterPopup Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ToasterPopup");
	blnstatus=ReportStatus.blnStatus;
	if(blnstatus==false)
	{
		blnstatus=false;
	}
	
	}else {
	extentLogs.warning("JetPrev Component ToasterPopup ","ToasterPopup Component class : "+str2+" is not available on : " + objData.AppURL );
	ReportStatus.blnElementStatus=false;
	} 
	}
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean pagination() {
	Boolean blnstatus = true;
	try {
		String str1 = "pagination paginationNavTop active";
		String str2 = "firstbk prev deactive";
		String str3 = "prevbk prev deactive";
		String str4 = "nextbk next";
		String str5 = "lastbk next";
		String str6 = "paginationPanel";
		String str7 = "page active";
		//driver.findElement(By.xpath("//div[@class='loader']")).click();
		actionLib.waitForElementPresent(By.xpath("(//div[@class='hideinmobile'])[2]"), 60);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='hideinmobile'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='hideinmobile'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("100010072");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Test@333");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actionLib.javascriptClick(driver.findElement(By.xpath(" (//input[@value='Login'])[1]")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='UserMessagePanel']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='innerHeadingContainer']/span)[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Activity Details') and @id='']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='userChoice2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='jppl-sprites ui-icon-datepicker'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'1')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Select Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'4')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl03_btnView']")).click();
		
		java.util.List<WebElement> link = driver.findElements(By.tagName("div"));
		System.out.println(link.size());
		
		for (int i = 0; i < link.size(); i++) {
			
			if(link.get(i).isDisplayed()) {
			String	str = link.get(i).getAttribute("class");
				System.out.println(str);
				if(str.contains(str1)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Pagination"); 
					}
				if(str.contains(str2)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Firstbkprevdeactive");
					}
				if(str.contains(str3)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Prevbkprevdeactive");
					}
				if(str.contains(str4)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Nextbknext");
					}
				if(str.contains(str5)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "LastbkNext");
					}
				if(str.contains(str6)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "PaginationPanel");
					}
			}
		}
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		
	for (int j = 0; j < links.size(); j++) {
			
			if(links.get(j).isDisplayed()) {
			String	str = links.get(j).getAttribute("class");
				System.out.println(str);
				if(str.contains(str2)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "Firstbkprevdeactive");
					}
				if(str.contains(str3)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "Prevbkprevdeactive");
					}
				if(str.contains(str4)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "Nextbknext");
					}
				if(str.contains(str5)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "LastbkNext");
					}
				if(str.contains(str7)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "PageActive");
					}
						}
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
		blnstatus = false;	
		
	}
	return blnstatus;
}




/***************************************
* Function Name :-fncomponentHelpText
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentHelpTextold(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
//actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.helpTextWait, 60);
/*if(driver.findElement(By.xpath("(//span[@class='helpText'])[3]")).isDisplayed()) {

	extentLogs.info("Helptext component", " HelpText icon is available");*/
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");



List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='helpText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.helpText(i), "HelpText");
	
	fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.helpText(i), "HelpText");
	
	
	/*actionLib.mouseHoverByJavaScript(JetPrev_Smoke_Locators.helpText(i), "Helptext");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.helpTextmessage, "HelpTextMessage");*/
	
	
	
}

/*}

else {
	extentLogs.info("Helptext component", " HelpText icon is not available ");
}*/
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fncomponentHelptextMessage(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
//actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.helpTextWait, 60);
if(driver.findElement(By.xpath("(//span[@class='helpText'])[3]")).isDisplayed()) {

	extentLogs.info("HelptextMessage component", " HelptextMessage icon is available");
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");



List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='helpText']"));
System.out.println(tagnames.size());
for(int i=3;i<=tagnames.size();i++) {
	actionLib.mouseHoverByJavaScript(JetPrev_Smoke_Locators.helpText(i), "Helptext");
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.helpTextmessage, "HelpTextMessage");
	
	
	
}

}

else {
	extentLogs.info("HelptextMessage component", " HelptextMessage icon is not available ");
}
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}








/***************************************
* Function Name :-fncomponentHelpTextMobile
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentHelpTextMobile(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");

//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");

/*if(driver.findElement(By.xpath("(//span[@class='helpText'])[3]")).isDisplayed()) {

	extentLogs.info("Helptext component", " HelpText icon is available");*/
List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='helpText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.helpText(i), "HelpTextMobile");
	
	fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.helpText(i), "HelpText");
}
/*}
else {
	extentLogs.info("Helptext component", " HelpText icon is not available ");
}
*/
}


catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}






/***************************************
* Function Name :-fncomponentHelpTextTablet
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentHelpTextTablet(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {

Thread.sleep(3000);
actionLib.OpenUrl(objData.AppURL);
List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='helpText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.helpText(i), "HelpTextTablet");
	
	fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.helpText(i), "HelpText");
}

}


catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

/***************************************
* Function Name :-fncomponentContinue
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentContinue(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");

actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");

List<WebElement> tagnames = driver.findElements(By.xpath("//input[@class='btnblue']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.continueBluebtn(i), "ContinueBlueBtn");

fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.continueBluebtn(i), "ContinueBlueBtn");

}
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


/***************************************
* Function Name :-fncomponentMandatoryField
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentMandatoryField(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {

Thread.sleep(3000);
actionLib.OpenUrl(objData.AppURL);
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");

//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
/*
if(driver.findElement(By.xpath("(//span[@class='errorText'])[2]")).isDisplayed()) {

	extentLogs.info("Mandatory component", " Mandatory icon is available");*/

List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='errorText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");

fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");

}
/*}
else {
	extentLogs.info("Mandatory component", " Mandatory icon is not available");
	
	}*/
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



/***************************************
* Function Name :-fncomponentMandatoryMobile
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentMandatoryMobile(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");

//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
/*
if(driver.findElement(By.xpath("(//span[@class='errorText'])[2]")).isDisplayed()) {

	extentLogs.info("Mandatory component", " Mandatory icon is available");
*/
List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='errorText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");

fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");

}
/*}
else {
	extentLogs.info("Mandatory component", " Mandatory icon is not available");
	
	}*/
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




/***************************************
* Function Name :-fncomponentMandatoryTablet
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentMandatoryTablet(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='errorText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");

fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");

}
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




/***************************************
* Function Name :-fncomponentCheckbox
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentCheckboxold(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");

actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");

List<WebElement> tagnames = driver.findElements(By.xpath("//input[@type='checkbox']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.checkbox(i), "Checkbox");

fnwebaccessibilityDefaultReading(JetPrev_Smoke_Locators.checkbox(i), "Checkbox");

}
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}










public void appurl(JetPrevInput objData) {
	actionLib.OpenUrl(objData.AppURL);
	//driver.navigate().to(objData.AppURL);
}

/***************************************
 * Function Name :-fnWebaccessibilty
 * Return Type:- boolean
 * Date:-25-Jan-2018
 * Author:-Nithin
 * @throws Throwable 
 */

public void fnWebaccessibilty(By Loc, String elementNameInExcel){
	
		//actionLib.Click(JetPrev_Smoke_Locators.countryShortName, "Click on IN");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(Loc, "elementNameInExcel");
		
	}


public boolean fnWebaccessibiltyHeader(){
	Boolean blnstatus = true;
	//actionLib.Click(JetPrev_Smoke_Locators.countryShortName, "Click on IN");
	try {
		actionLib.Click(JetPrev_Smoke_Locators.countryShortName1, "Click on IN");
	Actions a = new Actions(driver);
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.countryIcon1, "countryIconWeb");
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.guidedTour1, "guidedTourWeb");
	a.sendKeys(Keys.TAB).build().perform();
	a.sendKeys(Keys.TAB).build().perform();
	Thread.sleep(3000);
	//actionLib.validateCheckStyle(JetPrev_Smoke_Locators.searchExpanded1, "searchExpandedWeb");
	//a.sendKeys(Keys.TAB).build().perform();
	//Thread.sleep(3000);
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.searchIcon, "searchIconWeb");
	a.sendKeys(Keys.TAB).build().perform();
	Thread.sleep(3000);
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.enroll, "enrollWeb");
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.login, "loginWeb");
	a.sendKeys(Keys.TAB).build().perform();
	a.sendKeys(Keys.TAB).build().perform();
	a.sendKeys(Keys.TAB).build().perform();
	Thread.sleep(3000);
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.ourProgramNew1, "ourProgramNewWeb");
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.earnJpMilesNew1, "earnJpMilesNewWeb");
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.useJPMilesNew1, "useJPMilesNewWeb");
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.offersDealsNew1, "offersDealsNewWeb");
	a.sendKeys(Keys.TAB).build().perform();
	actionLib.validateCheckStyle(JetPrev_Smoke_Locators.bookNowNew1, "bookNowNewWeb");
	
	
	
	
	
}catch(Exception e) {
	}
	return blnstatus;
}



public boolean fnFooterWebaccessibility() {
	Boolean blnstatus = true;
	
	try {
				
		actionLib.Click(JetPrev_Smoke_Locators.footerBackground, "Click on header");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(3000);
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.aboutUs, "AboutUsWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.socialImpact,"SocialImpactWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.contactUs, "ContactUsWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.faq,"FAQWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.pressRoom, "PressRoomWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.carrers,"CarrersWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.termsConditions, "TermsConditionsWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.disclaimerPolicies,"DisclaimerPoliciesWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.siteMap, "SiteMapWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.faceBook, "FaceBookWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.twitter, "TwitterWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.youTube, "YouTubeWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.linkedIn, "LinkedInWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.pinInterest, "PinInterestWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.instaGram, "InstagramWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.etihadLogo, "etihadLogoWeb");
		a.sendKeys(Keys.TAB).build().perform();
		actionLib.validateCheckStyle(JetPrev_Smoke_Locators.jetFooterLogo, "jetFooterLogoWeb");
		
		
	}
	catch(Exception e) {
		
	}
	return blnstatus;
}
	

public boolean fnWebaccessibiltyLogin(){
	Boolean blnstatus = true;
	String altText = null;
	try {
		actionLib.Click(JetPrev_Smoke_Locators.countryShortName1, "Click on IN");
		fnWebaccessibilty(JetPrev_Smoke_Locators.countryIcon1, "countryIconWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.guidedTour1, "guidedTourWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.searchExpanded1, "searchExpandedWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.searchIcon, "searchIconWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.enroll, "enrollWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.login, "loginWeb");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		fnWebaccessibilty(JetPrev_Smoke_Locators.ourProgramNew1, "ourProgramNewWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.earnJpMilesNew1, "earnJpMilesNewWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.useJPMilesNew1, "useJPMilesNewWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.offersDealsNew1, "offersDealsNewWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.bookNowNew1, "bookNowNewWeb");
		actionLib.Click(JetPrev_Smoke_Locators.headerbackGround, "Click on header");
		fnWebaccessibilty(JetPrev_Smoke_Locators.aboutUs, "AboutUsWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.socialImpact,"SocialImpactWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.contactUs, "ContactUsWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.faq,"FAQWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.pressRoom, "PressRoomWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.carrers,"CarrersWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.termsConditions, "TermsConditionsWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.disclaimerPolicies,"DisclaimerPoliciesWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.siteMap, "SiteMapWeb");
		a.sendKeys(Keys.TAB).build().perform();
		fnWebaccessibilty(JetPrev_Smoke_Locators.faceBook, "FaceBookWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.twitter, "TwitterWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.youTube, "YouTubeWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.linkedIn, "LinkedInWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.pinInterest, "PinInterestWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.instaGram, "InstagramWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.etihadLogo, "etihadLogoWeb");
		fnWebaccessibilty(JetPrev_Smoke_Locators.jetFooterLogo, "jetFooterLogoWeb");
	}
	catch(Exception e) {
		
		e.printStackTrace();
		blnstatus = false;
	}
	return blnstatus;
}




/***************************************
	 * Function Name :-fnWebaccess
	 * Return Type:- boolean
	 * Date:-25-Jan-2018
	 * Author:-Nithin
	 * @throws Throwable 
	 */

public boolean fnWebaccess(By loc, String name){
	Boolean blnstatus = true;
	String altText = null;
	try {
		 altText=driver.findElement(loc).getAttribute("aria-label");
		 System.out.println(altText);
		if(altText.contains(altText)) {
			System.out.println("aria-label Text is available:"+altText);
			extentLogs.pass("WebAccess guidelines","Aria-label is available : "+name + altText);
		}else {
			System.out.println("Alt Text is not available:"+altText);
			extentLogs.fail("WebAccess guidelines","Aria-label is not available : "+name + altText);
		}
		
		
	}
	catch(Exception e) {
		extentLogs.fail("WebAccess guidelines","Aria-label is not available : "+name + altText);
		e.printStackTrace();
		blnstatus = false;
	}
	return blnstatus;
}

public void fnwebaccessother(By loc, String name) {
String altText = null;
altText = driver.findElement(loc).getAttribute("aria-haspopup");
System.out.println(altText);
if(altText.contains(altText)) {
	System.out.println();
	extentLogs.pass("WebAccess guidelines","Aria-haspopup is available : "+name + altText);
}else {
	System.out.println("Alt Text is not available:"+altText);
	extentLogs.fail("WebAccess guidelines","Aria-haspopup is not available : "+name + altText);
}

}


public void fnwebaccessibilityDefaultReading(By loc, String name) {
String altText = null;
altText = driver.findElement(loc).getText();
System.out.println(altText);
if(altText.contains(altText)) {
	System.out.println();
	extentLogs.pass("Default Reading","Default Reading is available for : "+name + altText);
}else {
	System.out.println("Alt Text is not available:"+altText);
	extentLogs.fail("Default Reading","Default Reading is not available for : "+name + altText);
}

}


//*******-------------------------------------------------------------------------------------------------------------------------------------------------------
//*** Smoke scripts *****

/***************************************
 * Function Name :-fnJetPrevBuymiles
 * Input:-String strUserID,String strPassword
 * Return Type:- boolean
 * Date:-26/03/2018
 * Author:-Nithin
 * @throws Throwable 
 */
public boolean fnJetPrevBuymiles(JetPrevInput objData) throws Throwable
{
	boolean blnStatus=true;
	try
	{
		
		actionLib.JSClick(JetPrev_Smoke_Locators.login, "Click on Login");
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.username, "username", 10);
		actionLib.type(JetPrev_Smoke_Locators.username, objData.Username, "Enter Username");
		actionLib.type(JetPrev_Smoke_Locators.password, objData.PassWord, "Enter Password");
		actionLib.Click(JetPrev_Smoke_Locators.loginButton, "Click on Login button");
		/*actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.properties, "properties");
		actionLib.JSClick(JetPrev_Smoke_Locators.properties, "Click on properties");
		actionLib.JSClick(JetPrev_Smoke_Locators.gotoHome, "Click on continue Homepage");
		ActionsLibrary.switchToLatestWindow(driver);*/
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.earnJpMiles, "username", 60);
		actionLib.mouseover(JetPrev_Smoke_Locators.earnJpMiles, "Click on earn jpmiles");
		actionLib.JSClick(JetPrev_Smoke_Locators.buyJpMiles, "Click on buy jpmiles");
	//	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.jpmilesRequired, "jpmilesRequired", 60);
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.jpmilesRequired, "jpmilesRequired", 60);
		actionLib.type(JetPrev_Smoke_Locators.jpmilesRequired, objData.RequiredMiles, "Enter required miles");
		String str = actionLib.getElementText(JetPrev_Smoke_Locators.availableJpmiles, "availableJpmiles");
		System.out.println(str);
		String amount = actionLib.getElementText(JetPrev_Smoke_Locators.totalAmountBuyJpmiles, "totalAmountBuyJpmiles");
		System.out.println(amount);
		//actionLib.JSClick(JetPrev_Smoke_Locators.voucherCodeApply, "Click on apply");
		actionLib.JSClick(JetPrev_Smoke_Locators.buyMiles, "Click on buymiles");
		bankDetails(objData);
		actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.buymilesSuccess, 30);
		String str1 = actionLib.getElementInnerText(JetPrev_Smoke_Locators.buymilesSuccess, "get the text of the success msg");
		System.out.println(str1);
		
		//Switch Window	
			//ActionsLibrary.switchToLatestWindow(driver);
		//Enter User ID
			//actionLib.type(JetPrevPageLocators.txtLoginID, objData.UserName, "Enter Login ID");
		//Enter Password
			//actionLib.type(JetPrevPageLocators.txtPassword,objData.Password, "Enter Password");
		//Click on Login
			//actionLib.Click(JetPrevPageLocators.btnLogin, "Login");
		}
	catch(Exception e)
	{
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
}


/***************************************
 * Function Name :-fnloginjppluat
 * Input:-String strUserID,String strPassword
 * Return Type:- boolean
 * Date:-26/03/2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnloginjppluat(JetPrevInput objData) throws Throwable{
	boolean blnstatus = true;
	try {
		extentLogs.info("Login", "Logged in successfully");
	actionLib.JSClick(JetPrev_Smoke_Locators.login, "Click on Login");
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.username, "username", 10);
	actionLib.type(JetPrev_Smoke_Locators.username, objData.Username, "Enter Username");
	actionLib.type(JetPrev_Smoke_Locators.password, objData.PassWord, "Enter Password");
	actionLib.Click(JetPrev_Smoke_Locators.loginButton, "Click on Login button");
	/*actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.properties, "properties");
	actionLib.JSClick(JetPrev_Smoke_Locators.properties, "Click on properties");
	actionLib.JSClick(JetPrev_Smoke_Locators.gotoHome, "Click on continue Homepage");
	ActionsLibrary.switchToLatestWindow(driver);*/
	Thread.sleep(8000);
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.logindropdown, "dropdowm", 30);
	actionLib.JSClick(JetPrev_Smoke_Locators.logindropdown, "Click on login dropdown");
	String str = actionLib.getElementText(JetPrev_Smoke_Locators.jpinfo, "Get the entire info");
	System.out.println(str);
	extentLogs.info("Logged JPNumber info" +str, "Complete information of the JPNumber");
	actionLib.JSClick(JetPrev_Smoke_Locators.logOut, "Click on logout");
	}
	catch(Exception e) {
		e.printStackTrace();
		blnstatus = false;
	}

	return blnstatus;
}

/***************************************
 * Function Name :-fnJetPrevEnroll
 * Input:-String strUserID,String strPassword
 * Return Type:- boolean
 * Date:-26/03/2018
 * Author:-Nithin
 * @throws Throwable 
 */
public boolean fnJetPrevEnroll(JetPrevInput objData) throws Throwable
{
	boolean blnStatus=true;
	try
	{
		
		actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on Enroll");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.title, objData.Title, "Title");
		actionLib.type(JetPrev_Smoke_Locators.firstName, objData.FirstName, "Enter FirstName");
		actionLib.type(JetPrev_Smoke_Locators.middleName, objData.MiddleName, "Enter MiddleName");
		actionLib.type(JetPrev_Smoke_Locators.lastName, objData.LastName, "Enter LastName");
		actionLib.Click(JetPrev_Smoke_Locators.dateOfBirth, "Click on date of birth");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.year, objData.Year, "Select year");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.month, objData.Month, "Select Month");
		
		actionLib.Click(JetPrev_Smoke_Locators.date, "Click on date");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.countryOfResidence, objData.CountryOfResidence, "Select country");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.citizenship, objData.Citizenship, "Select citizenship");
		String str1=	actionLib.getElementAttribute(JetPrev_Smoke_Locators.countryCode, "value", "get the value");
	    System.out.println(str1);
					   
		if(str1.equals(str1)) {	
		actionLib.type(JetPrev_Smoke_Locators.mobileNumber, objData.MobileNumber, "Enter MobileNumber");
		actionLib.type(JetPrev_Smoke_Locators.emailId, objData.EmailID, "Enter Email ID");
		String mobileError = actionLib.getElementInnerText(JetPrev_Smoke_Locators.mobilenumberError, "Error description");
		System.out.println(mobileError);
		if(mobileError.contains("Sorry! This Mobile Number is already present")) {
			actionLib.type(JetPrev_Smoke_Locators.mobileNumber, "9000022222", "Mobile");
		}
		else {

			actionLib.type(JetPrev_Smoke_Locators.emailId, objData.EmailID, "Enter Email ID");
			actionLib.type(JetPrev_Smoke_Locators.passwordin, objData.PasswordIn, "Enter PasswordIn");
		}
		//actionLib.type(JetPrev_Smoke_Locators.emailId, objData.EmailID, "Enter Email ID");
		actionLib.type(JetPrev_Smoke_Locators.passwordin, objData.PasswordIn, "Enter PasswordIn");
		}
		else {
			actionLib.selectByVisibleText(JetPrev_Smoke_Locators.countryCode, objData.CountryCode, "CountryCode");
		}
		actionLib.type(JetPrev_Smoke_Locators.reEnterPassword, objData.ReEnterPassword, "Enter ReEnterPassword");
		//actionLib.wait(2000);
		//actionLib.Click(JetPrev_Smoke_Locators.captcha, "Click on captcha");
		//actionLib.wait(2000);
		actionLib.JSClick(JetPrev_Smoke_Locators.termsCondition, "Click on termsCondition");
		
		
		actionLib.JSClick(JetPrev_Smoke_Locators.continues, "Click on continues");
		
		
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.state, objData.State, "Select andhrapradesh");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.city, objData.City, "Select Hyderabad");
		actionLib.type(JetPrev_Smoke_Locators.postalCode, objData.PostalCode, "PostalCode");
		actionLib.type(JetPrev_Smoke_Locators.addressLine, objData.AddressLine, "AddressLine");
		actionLib.type(JetPrev_Smoke_Locators.addressLine2, objData.AddressLineii, "AddressLine2");
		actionLib.type(JetPrev_Smoke_Locators.addressLine3, objData.AddressLine3, "AddressLine3");
		actionLib.JSClick(JetPrev_Smoke_Locators.businessradioButton, "Click on business");
		actionLib.type(JetPrev_Smoke_Locators.companyName, objData.CompanyName, "CompanyName");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.businessCategory, objData.BusinessCategory, "BusinessCategory");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.designation, objData.Designation, "Designation");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.stateBusiness, objData.StateBusiness, "StateBusiness");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.cityBusiness, objData.CityBusiness, "CityBusiness");
		actionLib.type(JetPrev_Smoke_Locators.jobTitle, objData.JobTitle, "JobTitle");
		actionLib.type(JetPrev_Smoke_Locators.postalCodebusiness, objData.PostalCodebusiness, "PostalCodebusiness");	
		actionLib.type(JetPrev_Smoke_Locators.addressLineBusiness, objData.AddressLineBusiness, "AddressLineBusiness");
		actionLib.type(JetPrev_Smoke_Locators.addressLine2Business, objData.AddressLine2Business, "AddressLine2Business");
		actionLib.type(JetPrev_Smoke_Locators.addressLine3Business, objData.AddressLine3Business, "AddressLine3Business");
		actionLib.JSClick(JetPrev_Smoke_Locators.previousHome, "Click on previous");
		actionLib.JSClick(JetPrev_Smoke_Locators.reset, "Click on reset");
		String mandatory = actionLib.getElementInnerText(JetPrev_Smoke_Locators.mandatoryFields, "get text of mandatory fields");
		if(mandatory.contains("Mandatory Fields"))
		{
			homeEnroll(objData);
			businessEnroll(objData);
		}
		else {
			
		fnJetPrevEnroll(objData);
		}
		
		email(objData);
		
		
		//Switch Window	
			//ActionsLibrary.switchToLatestWindow(driver);
		//Enter User ID
			//actionLib.type(JetPrevPageLocators.txtLoginID, objData.UserName, "Enter Login ID");
		//Enter Password
			//actionLib.type(JetPrevPageLocators.txtPassword,objData.Password, "Enter Password");
		//Click on Login
			//actionLib.Click(JetPrevPageLocators.btnLogin, "Login");
		}
	catch(Exception e)
	{
		e.printStackTrace();
		blnStatus=false;
	}
	return blnStatus;
}


public void JetPrevlogin(JetPrevInput objData) throws Throwable {
	actionLib.JSClick(JetPrev_Smoke_Locators.login, "Click on Login");
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.username, "username", 10);
	actionLib.type(JetPrev_Smoke_Locators.username, objData.Username, "Enter Username");
	actionLib.type(JetPrev_Smoke_Locators.password, objData.PassWord, "Enter Password");
	actionLib.JSClick(JetPrev_Smoke_Locators.loginButton, "Click on Login button");
	/*try {
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.properties, "properties");
		actionLib.JSClick(JetPrev_Smoke_Locators.properties, "Click on properties");
		actionLib.JSClick(JetPrev_Smoke_Locators.gotoHome, "Click on continue Homepage");
		ActionsLibrary.switchToLatestWindow(driver);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
}

public void email(JetPrevInput objData) throws Throwable{
	
	driver.get("http://www.gmail.com");
	//actionLib.type(JetPrev_Smoke_Locators.gmailUserID, objData.GmailUserId, "GmailUserId");
	actionLib.type(JetPrev_Smoke_Locators.gmailUserID, "nithinselenium27", "Enter user name");
	actionLib.JSClick(JetPrev_Smoke_Locators.gmailUserIDnext, "Click on next");
	//actionLib.type(JetPrev_Smoke_Locators.gmailPassword, objData.GmailPassword, "Enter GmailPassword");
	actionLib.type(JetPrev_Smoke_Locators.gmailPassword, "Selenium@27", "Enter GmailPassword");
	actionLib.JSClick(JetPrev_Smoke_Locators.gmailpasswordnext, "Click on Next");
    List<WebElement> str = driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr/td[6]"));
    System.out.println(str.size());
    for(int i=0;i<str.size();i++) {
    System.out.println(str.get(i).getText());

if(str.get(i).getText().contains("Validus_Scripts")){
	str.get(i).click();
}

 }
}


/***************************************
 * Function Name :-fnJetPrevgiftMiles
 * Input:-String strUserID,String strPassword
 * Return Type:- boolean
 * Date:-26/03/2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnJetPrevgiftMiles(JetPrevInput objData) throws Throwable
{
	boolean blnStatus=true;
	try {
		
		JetPrevlogin(objData);
		Thread.sleep(6000);
		actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.useJpmiles, 60);
		actionLib.mouseover(JetPrev_Smoke_Locators.useJpmiles, "Use Jp miles");
		actionLib.JSClick(JetPrev_Smoke_Locators.giftorTransfermiles, "Click on giftortransfermiles");
		Thread.sleep(3000);
		actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.transfer, 60);
		String transfer = actionLib.getElementInnerText(JetPrev_Smoke_Locators.transfer, "get the text of transfer");
		if(transfer==transfer) {
			actionLib.JSClick(JetPrev_Smoke_Locators.transfer, "Click on transfer");
		String miles = actionLib.getElementInnerText(JetPrev_Smoke_Locators.availableJpmiles, "Available Jpmiles");
		if(miles==miles) {
		System.out.println(miles);
		}
		}else {
		System.out.println(" no miles are available");
		}
		
		actionLib.type(JetPrev_Smoke_Locators.milestobeGifted, objData.GiftMiles, "GiftMiles");
		String amount = actionLib.getElementText(JetPrev_Smoke_Locators.giftAmount, "Get the amount displayed");
		System.out.println(amount);
		actionLib.type(JetPrev_Smoke_Locators.giftJpmilesto, objData.GiftMilesTo, "GiftMilesTo");
		actionLib.type(JetPrev_Smoke_Locators.personaliseMessage, objData.PersonaliseMessage, "PersonaliseMessage");
		String name = actionLib.getElementInnerText(JetPrev_Smoke_Locators.accountName, "get the text from account");
		System.out.println(name);
		extentLogs.info("Account holder name:" +name, "Name of the account holder to gift miles by transfer");
		actionLib.JSClick(JetPrev_Smoke_Locators.buy, "Click on transfer");
		String error = actionLib.getElementText(JetPrev_Smoke_Locators.transferError, "TransferError");
		System.out.println(error);
		extentLogs.info("Error" +error, "Error description");
		if(error.equalsIgnoreCase(error)) {
			actionLib.type(JetPrev_Smoke_Locators.giftJpmilesto, "210127330", "GiftMilesTo");
			actionLib.type(JetPrev_Smoke_Locators.personaliseMessage, objData.PersonaliseMessage, "PersonaliseMessage");
			String name1 = actionLib.getElementInnerText(JetPrev_Smoke_Locators.accountName, "get the text from account");
			System.out.println(name1);
			extentLogs.info("Account holder name:" +name1, "Name of the account holder to gift miles by transfer");
			actionLib.type(JetPrev_Smoke_Locators.personaliseMessage, "Gift to friend", "PersonaliseMessage");
			actionLib.JSClick(JetPrev_Smoke_Locators.buy, "Click on transfer");
		}
		bankDetails(objData);
		Thread.sleep(50000);
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.successMsg, "successMsg", 10);
		String success = actionLib.getElementInnerText(JetPrev_Smoke_Locators.successMsg, "Get the success text");
		extentLogs.info("Success message"+success, "Success message should get displayed");
		System.out.println(success);
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus = false;
	}
	return blnStatus;
}


/***************************************
 * Function Name :-fnJetPrevgiftMilesbyBuy
 * Input:-String strUserID,String strPassword
 * Return Type:- boolean
 * Date:-26/03/2018
 * Author:-Nithin
 * @throws Throwable 
 */
public boolean fnJetPrevgiftMilesbyBuy(JetPrevInput objData) throws Throwable
{
	boolean blnStatus=true;
	try {
		
		actionLib.JSClick(JetPrev_Smoke_Locators.login, "Click on Login");
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.username, "username", 10);
		actionLib.type(JetPrev_Smoke_Locators.username, objData.Username, "Enter Username");
		actionLib.type(JetPrev_Smoke_Locators.password, objData.PassWord, "Enter Password");
		actionLib.JSClick(JetPrev_Smoke_Locators.loginButton, "Click on Login button");
		//actionLib.wait();
		Thread.sleep(10000);
		actionLib.mouseover(JetPrev_Smoke_Locators.useJpmiles, "Use Jp miles");
		//actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.giftorTransfermiles, 10);
		actionLib.JSClick(JetPrev_Smoke_Locators.giftorTransfermiles, "Click on giftortransfermiles");
		actionLib.WaitForElementVisible(JetPrev_Smoke_Locators.giftbyBuy, 90);
		try {
			actionLib.JSClick(JetPrev_Smoke_Locators.giftbyBuy, "Click on buy radiobutton");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		actionLib.type(JetPrev_Smoke_Locators.milestobeGifted, objData.GiftMiles, "GiftMiles");
		String amount = actionLib.getElementText(JetPrev_Smoke_Locators.giftAmount, "Get the amount displayed");
		System.out.println(amount);
		actionLib.type(JetPrev_Smoke_Locators.giftJpmilesto, objData.GiftMilesTo, "GiftMilesTo");
		actionLib.type(JetPrev_Smoke_Locators.personaliseMessage, objData.PersonaliseMessage, "PersonaliseMessage");
		String name = actionLib.getElementText(JetPrev_Smoke_Locators.accountName, "get the text from account");
		System.out.println(name);
		actionLib.JSClick(JetPrev_Smoke_Locators.buy, "Click on transfer");
		bankDetails(objData);
		Thread.sleep(5000);
		actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.successMsg, "successMsg", 90);
		String success = actionLib.getElementText(JetPrev_Smoke_Locators.successMsg, "Get the success text");
		System.out.println(success);
	
		
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus = false;
	}
	return blnStatus;
}



/***************************************
 * Function Name :-fnJetPrevRedeemMiles
 * Input:-String strUserID,String strPassword
 * Return Type:- boolean
 * Date:-26/03/2018
 * Author:-Nithin
 * @throws Throwable 
 */

public boolean fnJetPrevRedeemMiles(JetPrevInput objData) throws Throwable
{
	boolean blnStatus=true;
	try {
		
		actionLib.mouseover(JetPrev_Smoke_Locators.useJpmiles, "Mousehover on Usejpmiles");
		actionLib.JSClick(JetPrev_Smoke_Locators.redeemforAwardflight, "Click on redeem for award flight");
		actionLib.JSClick(JetPrev_Smoke_Locators.oneWay, "Click on one way");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.from, objData.From, "Enter From");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.tO, objData.To, "Enter To");
		actionLib.JSClick(JetPrev_Smoke_Locators.flyDate, "click on departuredate");
		actionLib.selectByValue(JetPrev_Smoke_Locators.flyDate, objData.FlyDate, "Select flydate");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.adult, objData.Adult, "Select Adults");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.child, objData.Child, "select Child");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.cabin, objData.Cabin, "select Cabin");
		actionLib.JSClick(JetPrev_Smoke_Locators.submit, "Click on submit");
		actionLib.JSClick(JetPrev_Smoke_Locators.radioButton, "Click on radiobutton");
		actionLib.JSClick(JetPrev_Smoke_Locators.continueFly, "Click on continue");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.bookingsalutation, objData.Salutation, "bookingsalutation");
		actionLib.type(JetPrev_Smoke_Locators.bookingFirstname, objData.BookingFirstName, "Enter the firstname");
		actionLib.type(JetPrev_Smoke_Locators.bookingMiddlename, objData.BookingMiddleName, "Enter the middlename");
		actionLib.type(JetPrev_Smoke_Locators.bookingLastname, objData.BookingLastName, "enter the lastname");
		//actionLib.JSClick(JetPrev_Smoke_Locators.bookingCheckboxIndianresident, "Click on indian resident checkbox");
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.bookingMealpreference, objData.MealPreference, "Select meal preference");
		actionLib.JSClick(JetPrev_Smoke_Locators.bookingContinuetocontactdetails, "Click on book continue details");
		actionLib.JSClick(JetPrev_Smoke_Locators.bookingcontinueToextras, "Click on continue extras");
		actionLib.JSClick(JetPrev_Smoke_Locators.bookingTeramsandInsurance, "click on booking terms and conditions");
		actionLib.JSClick(JetPrev_Smoke_Locators.bookingTeramsandInsurance, "Click on terms of insurance");
		actionLib.JSClick(JetPrev_Smoke_Locators.bookingContinuetoPay, "Click on continue to pay");
		
		
		
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
		blnStatus = false;
	}
	return blnStatus;
}



public void bankDetails(JetPrevInput objData) throws Throwable {
	actionLib.type(JetPrev_Smoke_Locators.cardNumber, objData.CardNumber, "Enter card number");
	actionLib.type(JetPrev_Smoke_Locators.cardExp, objData.ExpiryCard, "Enter expiry card");
	actionLib.type(JetPrev_Smoke_Locators.cardCvv, objData.CVV, "Enter CVV");
	actionLib.type(JetPrev_Smoke_Locators.cardHolder, objData.CardName, "Enter card name");
	actionLib.Click(JetPrev_Smoke_Locators.payNow, "Click on Paynow");
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.subMit, "submit", 50);
	actionLib.Click(JetPrev_Smoke_Locators.subMit, "Click on submit");
	}

public void homeEnroll(JetPrevInput objData) throws Throwable {
	actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on Enroll");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.title, objData.Title, "Title");
	actionLib.type(JetPrev_Smoke_Locators.firstName, objData.FirstName, "Enter FirstName");
	actionLib.type(JetPrev_Smoke_Locators.middleName, objData.MiddleName, "Enter MiddleName");
	actionLib.type(JetPrev_Smoke_Locators.lastName, objData.LastName, "Enter LastName");
	actionLib.Click(JetPrev_Smoke_Locators.dateOfBirth, "Click on date of birth");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.year, objData.Year, "Select year");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.month, objData.Month, "Select Month");
	actionLib.Click(JetPrev_Smoke_Locators.date, "Click on date");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.countryOfResidence, objData.CountryOfResidence, "Select country");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.citizenship, objData.Citizenship, "Select citizenship");
	String str1=	actionLib.getElementAttribute(JetPrev_Smoke_Locators.countryCode, "value", "get the value");
    System.out.println(str1);
				   
	if(str1.equals(str1)) {	
	actionLib.type(JetPrev_Smoke_Locators.mobileNumber, objData.MobileNumber, "Enter MobileNumber");
	actionLib.type(JetPrev_Smoke_Locators.emailId, objData.EmailID, "Enter Email ID");
	String mobileError = actionLib.getElementInnerText(JetPrev_Smoke_Locators.mobilenumberError, "Error description");
	System.out.println(mobileError);
	if(mobileError.contains("Sorry! This Mobile Number is already present")) {
		actionLib.type(JetPrev_Smoke_Locators.mobileNumber, "9000022222", "Mobile");
	}
	else {

		actionLib.type(JetPrev_Smoke_Locators.emailId, objData.EmailID, "Enter Email ID");
		actionLib.type(JetPrev_Smoke_Locators.passwordin, objData.PasswordIn, "Enter PasswordIn");
	}
	actionLib.type(JetPrev_Smoke_Locators.emailId, objData.EmailID, "Enter Email ID");
	actionLib.type(JetPrev_Smoke_Locators.passwordin, objData.PasswordIn, "Enter PasswordIn");
	}
	else {
		actionLib.selectByVisibleText(JetPrev_Smoke_Locators.countryCode, objData.CountryCode, "CountryCode");
	}
	actionLib.type(JetPrev_Smoke_Locators.reEnterPassword, objData.ReEnterPassword, "Enter ReEnterPassword");
	//actionLib.wait(2000);
	//actionLib.Click(JetPrev_Smoke_Locators.captcha, "Click on captcha");
	//actionLib.wait(2000);
	actionLib.JSClick(JetPrev_Smoke_Locators.termsCondition, "Click on termsCondition");
	actionLib.JSClick(JetPrev_Smoke_Locators.continues, "Click on continues");
}

public void businessEnroll(JetPrevInput objData) throws Throwable {
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.state, objData.State, "Select andhrapradesh");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.city, objData.City, "Select Hyderabad");
	actionLib.type(JetPrev_Smoke_Locators.postalCode, objData.PostalCode, "PostalCode");
	actionLib.type(JetPrev_Smoke_Locators.addressLine, objData.AddressLine, "AddressLine");
	actionLib.type(JetPrev_Smoke_Locators.addressLine2, objData.AddressLineii, "AddressLine2");
	actionLib.type(JetPrev_Smoke_Locators.addressLine3, objData.AddressLine3, "AddressLine3");
	actionLib.JSClick(JetPrev_Smoke_Locators.businessradioButton, "Click on business");
	actionLib.type(JetPrev_Smoke_Locators.companyName, objData.CompanyName, "CompanyName");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.businessCategory, objData.BusinessCategory, "BusinessCategory");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.designation, objData.Designation, "Designation");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.stateBusiness, objData.StateBusiness, "StateBusiness");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.cityBusiness, objData.CityBusiness, "CityBusiness");
	actionLib.type(JetPrev_Smoke_Locators.jobTitle, objData.JobTitle, "JobTitle");
	actionLib.type(JetPrev_Smoke_Locators.postalCodebusiness, objData.PostalCodebusiness, "PostalCodebusiness");	
	actionLib.type(JetPrev_Smoke_Locators.addressLineBusiness, objData.AddressLineBusiness, "AddressLineBusiness");
	actionLib.type(JetPrev_Smoke_Locators.addressLine2Business, objData.AddressLine2Business, "AddressLine2Business");
	actionLib.type(JetPrev_Smoke_Locators.addressLine3Business, objData.AddressLine3Business, "AddressLine3Business");
	actionLib.JSClick(JetPrev_Smoke_Locators.enrollHome, "EnrollHome");
}

//*****************************Sanity******************************//


public void sanitylogin(JetPrevInput objData) throws Throwable {
	
	actionLib.JSClick(JetPrev_Smoke_Locators.login, "Click on Login");
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.username, "username", 10);
	//actionLib.type(JetPrev_Smoke_Locators.username, objData.UsernameSanity, "Enter Username");
	actionLib.type(JetPrev_Smoke_Locators.username, "101297873", "Enter Username");
	//actionLib.type(JetPrev_Smoke_Locators.password, objData.PassWordSanity, "Enter Password");
	actionLib.type(JetPrev_Smoke_Locators.password, "111111", "Enter Password");
	actionLib.Click(JetPrev_Smoke_Locators.loginButton, "Click on Login button");
	String str = actionLib.getElementInnerText(JetPrev_Smoke_Locators.passwordCompliance, "Get text of password compliance");
	System.out.println(str);
	String str1 = actionLib.getElementInnerText(JetPrev_Smoke_Locators.PasswordComplianceDetails, "Get the text of all the details");
	System.out.println(str1);
    driver.get("https://login.microsoftonline.com/");
	actionLib.type(JetPrev_Smoke_Locators.officeEmail, "E001888@cigniti.com", "Enter the data");
	actionLib.Click(JetPrev_Smoke_Locators.emailNext, "Click on next");
	actionLib.type(JetPrev_Smoke_Locators.officePassword, "Ni9hin@27", "Enter the data");
	actionLib.Click(JetPrev_Smoke_Locators.signIn, "Click on sign in");
	actionLib.Click(JetPrev_Smoke_Locators.staySignInNo, "Click on No");
	actionLib.Click(JetPrev_Smoke_Locators.outLook, "Click on outlook");
	ActionsLibrary.switchToLatestWindow(driver);
	actionLib.Click(JetPrev_Smoke_Locators.other, "click on other");
	driver.findElement(By.xpath("//*[@id=\"_ariaId_26\"]/div[2]")).click();
	driver.findElement(By.xpath("//*[@id=\"x_deviceWidth\"]/tbody/tr/td/table[1]/tbody/tr[6]/td/table/tbody/tr/td/strong/a")).click();
	ActionsLibrary.switchToLatestWindow(driver);
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.newPassword, "Wait fo the element", 20);
	actionLib.type(JetPrev_Smoke_Locators.newPassword, "Pass@1234", "Enter the password");
	actionLib.type(JetPrev_Smoke_Locators.confirmNewPassword, "Pass@1234", "Confirm the password");
	actionLib.JSClick(JetPrev_Smoke_Locators.submitPassword, "Click on submit");
	String Str2 = actionLib.getElementInnerText(JetPrev_Smoke_Locators.passwodSuccessmsg, "Get text");
	System.out.println(Str2);
	actionLib.waitForVisibilityOfElement(JetPrev_Smoke_Locators.passwordLogin, "wait for it", 10);
	actionLib.type(JetPrev_Smoke_Locators.passwordLogin, "101297862", "Enter the username");
	actionLib.type(JetPrev_Smoke_Locators.passwordLoginPassword, "Pass@1234", "Enter the password");
	actionLib.Click(JetPrev_Smoke_Locators.passwordLoginBtn, "Click on button");
	
	
	
	/*List<WebElement> all = driver.findElements(By.xpath("//*[@id=\\\"primaryContainer\\\"]/div[4]/div/div[1]/div/div[4]/div[3]/div/div[2]/div/div/div/div[5]/div[3]/div[1]/div[3]/div[1]"));
	System.out.println(all.size());
	for(int i=0;i<all.size();i++) {
		System.out.println(all.get(i).getText());
		if(all.get(i).getText().contains("JetPrivilege")) {
			all.get(i).click();
			driver.findElement(By.xpath("//*[@id=\"x_deviceWidth\"]/tbody/tr/td/table[1]/tbody/tr[6]/td/table/tbody/tr/td/strong/a")).click();
			driver.close();*/
		}
	
	


public void partnerAwards() throws Throwable {
	
	actionLib.mouseover(JetPrev_Smoke_Locators.useJpmiles, "Mouse over on usejpmiles");
	actionLib.JSClick(JetPrev_Smoke_Locators.partnerAwards, "Click on partner awards");
	actionLib.JSClick(JetPrev_Smoke_Locators.oneWaypartnerAwards, "Click on oneway partner awards");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.fromPartnerAwards, "Hyderabad (HYD)", "Enter Text");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.toPartnerAwards, "Mumbai (BOM)", "Enter text");
//	here dates for dates need to write methods
	actionLib.selectByValue(JetPrev_Smoke_Locators.adultPartnerAwards, "2", "Select adults");
	actionLib.selectByValue(JetPrev_Smoke_Locators.childPartnerAwards, "1", "Select Child");
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.cabinPartnerAwards, "Economy", "Select Economy");
	actionLib.JSClick(JetPrev_Smoke_Locators.addSegment, "Click on addsegment");
	String str = actionLib.getElementInnerText(JetPrev_Smoke_Locators.addSegmentTable, "get the text of the table");
	System.out.println(str);
	actionLib.JSClick(JetPrev_Smoke_Locators.continuePartnerawards, "Click on continue");
	String str1 = actionLib.getElementInnerText(JetPrev_Smoke_Locators.addPassengerdetails, "Get the text of addPassengerdetails");
	System.out.println(str1);
	actionLib.type(JetPrev_Smoke_Locators.partnerAwardPassengername, "seal","enter the name in passenger name");
	// date of birth should invent method-- i will do it.
	actionLib.selectByVisibleText(JetPrev_Smoke_Locators.partnerAwardCitizen, "Indian", "Citizen");
	actionLib.type(JetPrev_Smoke_Locators.PartnerAwardpassportNumber, "1231123", "Passport");
	//valid up to
    //Date of issue
	actionLib.type(JetPrev_Smoke_Locators.partnerAwardPlaceofissue, "Hyderabad", "Place of Issue");
	actionLib.JSClick(JetPrev_Smoke_Locators.partnerAwardAddanotherPassenger, "Addanotherpassenger");
	String str2 = actionLib.getElementInnerText(JetPrev_Smoke_Locators.addPassengerdetailstable, "get text");
	System.out.println(str2);
	actionLib.JSClick(JetPrev_Smoke_Locators.partnerTandC, "Click on T and C");
	actionLib.JSClick(JetPrev_Smoke_Locators.partnerSubmitRequest, "Click on submit request");
	
}





private String GetElementAttribute(By countryCode) {
	// TODO Auto-generated method stub
	return null;
}



public void fnUpdateDefectDetails(Issue issue)
{
    if(issue!=null)
    {
        extentLogs.info("Shop Jet Prev Web Test Script ","Defect Details");
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
            int c=50/0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}

public boolean fnWaitForpageLoad() throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	//Initially bellow given if condition will check ready state of page.
	for(int i=1;i<10;i++)
	{
	  Thread.sleep(2000);	
	  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
	   System.out.println("Page Is loaded.");
	   return true;
	}
	}
	return true;
}






//public void fnValidateBreadCrumbs(){
//	actionLib.validateCheckStyle(JetPrevPageLocators.ourProgramBreadcrumb,"ourProgramBreadcrumb");
//}
}





