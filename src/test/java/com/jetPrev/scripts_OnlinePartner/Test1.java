package com.jetPrev.scripts_OnlinePartner;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jetPrev.testObjects_OnlinePartner.JetPrevPageLocators;
import com.jetPrev.testObjects_OnlinePartner.PopUpPageLocators;
import com.jetPrev.workflows_OnlinePartner.JetPrevInput;
import com.jetPrev.workflows_OnlinePartner.JetPrevWorkflows;
import com.jetPrev.workflows_OnlinePartner.SheetDetails;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.testmanagement.IssueDetails;
import com.web.automation.utilities.CommonVariables;

public class Test1  extends TestEngineWeb{
	
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	private JetPrevWorkflows JetPrev;
	SheetDetails objDet=new SheetDetails();
	Map<String, List<String>> testdata = null;
	ActionsLibrary actLib = new ActionsLibrary();
	public IssueDetails objIssue=new IssueDetails();
	
	//public WebDriver drParent=driver;
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}
	@BeforeMethod(alwaysRun = true)
	public void  beforeMethod() throws Throwable {
		JetPrev = new JetPrevWorkflows(CommonVariables.CommonDriver.get());
		objDet.strSheetPath=System.getProperty("user.dir").replace("\\", "/") + "/testdata/TestData.xlsx";
		objDet.strSheetName="JetPrev";
		objDet.intRowNo=2;
	}
	
	/*@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void ShopJetPrevBigBasket() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			
			
			
			// Store the current window handle
			String winHandleBefore = driver.getWindowHandle();
			//wait
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.arrowMark, "Arrow mark", 50);
			//click on arrowmark to slide next
			actLib.JSClick(JetPrevPageLocators.arrowMark, "Click on arrow mark");
			//Thread.sleep(30000);
			actLib.waitForVisibilityOfElement(JetPrevPageLocators.bigbasket, "Big basket icon", 250);
			if(actLib.JSClick(JetPrevPageLocators.bigbasket, "Click on big basket icon")){
				extentLogs.pass("TC_005: Step 2", "User is able to find bigbasket icon");
				extentLogs.pass("TC_005: Step 3", "User is able to click bigbasket icon");
			}
			else
			{
				extentLogs.fail("TC_005: Step 2", "User is not able to find bigbasket icon");
				extentLogs.fail("TC_005: Step 3", "User is not able to click bigbasket icon");
			}
			// Perform the click operation that opens new window
			//Click on partner icon
			
			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver=driver.switchTo().window(winHandle);
			}
			extentLogs.fail("test", "test");
			extentLogs.fail("test1", "test1");
			// Perform the actions on new window
			actLib.JSClick(PopUpPageLocators.continueAsGuestLink, "Continue as guest");
			// Switch to new window opened
						for(String winHandle : driver.getWindowHandles()){
						    driver=driver.switchTo().window(winHandle);
						}
			extentLogs.fail("test", "test");
			extentLogs.fail("test1", "test1");
			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver=driver.switchTo().window(winHandleBefore);

			extentLogs.fail("test2", "test2");


			driver.close();
			driver=drParent;
			//JetPrev.fnJetPrevAdmin(testData);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}
*/
}

