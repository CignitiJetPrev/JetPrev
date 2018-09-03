package com.jetPrev.workflows_OnlinePartner;


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

import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jetPrev.testObjects_OnlinePartner.JetPrevPageLocators;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.pages.BasePage;
import com.web.automation.utilities.ConfigManager;



public class JetPrevWorkflows_1 extends BasePage {
	public WebDriver driver=ActionsLibrary.driver;
	//public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public JetPrevWorkflows_1(WebDriver driver) {

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
	public boolean fnJetPrevLogin(JetPrevInput objData) throws Throwable
	{
		boolean blnStatus=true;
		try
		{
			//Click on Login
				actionLib.JSClick(JetPrevPageLocators.headerLogin, "Jet Prev Login");
			//Switch Window	
				
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
	
	/*public boolean fnJetPrevSearchbar(String strSearch)
	{
		
		boolean blnStatus=true;
		try
		{
			//Scroll down
			actionLib.ScrollToBottom();
			//click on retail partners
			actionLib.JSClick(JetPrevPageLocators.retailPartners, "Click on Retailed partners");
			//Click on proceed to lifestyle button on a pop up window
			actionLib.JSClick(JetPrevPageLocators.proceedToLyfstyle, "Click on proceed to lifestyle button");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus=false;
		}
		return blnStatus;
	}
	
	public boolean fnJetHeader(String strHeader){
		
		boolean blnStatus = true;
		try{
			
			//Header
			//click on Our program
			actionLib.JSClick(JetPrevPageLocators.ourProgram, "Click on our program");
			//naviagte back to the home page
			actionLib.NavigateBack();
			//click on Earn Jpmiles
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
			actionLib.JSClick(JetPrevPageLocators.bookNow, "click on booknow" );
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus= false;
		}
		return blnStatus;
	}
	
	public boolean fnJetsearchPage(String strsearchPage) throws Throwable{
		
		boolean blnStatus = true;
		try{
			//click on all categories
			actionLib.JSClick(JetPrevPageLocators.allcategories, "click on all categories");
			//Mousehover on electronics and media
			actionLib.mouseHoverByJavaScript(JetPrevPageLocators.electronicsGaming, "Mousehover on electronicsGaming");
			//Mousehover on aircoolers and conditioners
			actionLib.JSClick(JetPrevPageLocators.airCoolers, "Mousehovre on aircoolers");
			//Click on Search
			actionLib.JSClick(JetPrevPageLocators.searchbtn, "click on Search button");
			//actionLib.mouseHoverByJavaScript(JetPrevPageLocators., locatorName)
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			blnStatus = false;
		}
		return blnStatus;
	}*/
}