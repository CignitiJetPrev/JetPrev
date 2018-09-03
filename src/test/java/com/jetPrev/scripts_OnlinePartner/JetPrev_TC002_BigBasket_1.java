package com.jetPrev.scripts_OnlinePartner;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jetPrev.workflows_OnlinePartner.JetPrevInput;
import com.jetPrev.workflows_OnlinePartner.JetPrevWorkflows;
import com.jetPrev.workflows_OnlinePartner.SheetDetails;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.testmanagement.IssueDetails;
import com.web.automation.testrail.TestRunStatus;
import com.web.automation.utilities.CommonVariables;

public class JetPrev_TC002_BigBasket_1 extends TestEngineWeb {
	
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	private JetPrevWorkflows JetPrev;
	SheetDetails objDet=new SheetDetails();
	public IssueDetails objIssue=new IssueDetails();
	Map<String, List<String>> testdata = null;
	ActionsLibrary actLib = new ActionsLibrary();
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
		fnGetIssueDetails();
	}


	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void ShopJetPrev_TC002_BigBasket() throws Throwable {
		try {
			
			testData=testData.getTestData(objDet);
			boolean blnJetPrevLogin=JetPrev.fnJetPrevLogin(testData);
			boolean blnJetPrevBigBasket=false;
			boolean blnJetPrevURL=false;
			boolean blnJetPrevBigBasketOrder=false;
			boolean blnJetPrevLogout=false;
			boolean blnJPMilesValidation=false;
			if(blnJetPrevLogin)
			{
				extentLogs.pass("JetPrev Web Test Script ","Login Pass for jet Prev Login ID : " + testData.UserName );
				blnJetPrevBigBasket		    =JetPrev.fnJetPrevRedirectToOnlinePartnerSiteBigBasket();	
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Login Fail for jet Prev Login ID : " + testData.UserName );
			}
			if(blnJetPrevBigBasket)
			{
				extentLogs.pass("JetPrev Web Test Script ","Redirection Pass for jet Prev Login ID : " + testData.UserName );
				blnJetPrevURL				=JetPrev.fnJetPrevValidateURL(testData);
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Redirection Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			if(blnJetPrevURL)
			{
				extentLogs.pass("JetPrev Web Test Script ","URL Validation Pass for jet Prev Login ID : " + testData.UserName );
				blnJetPrevBigBasketOrder				=JetPrev.fnJetPrevPlaceOrderOnBigBasketSite(testData);
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","URL validation fail for jet Prev Login ID : " + testData.UserName );
				JetPrev.fnJetPrevSwitchBackToJetPrevPage();
				JetPrev.fnJetPrevLogout(); 
			}
			extentLogs.info("JetPrev Web Test Script ","JetPrev big basket redirection");			
			
			
			if(blnJetPrevBigBasketOrder)
			{
				extentLogs.pass("JetPrev Web Test Script ","Place Order Pass for jet Prev Login ID : " + testData.UserName );
				JetPrev.fnJetPrevSwitchBackToJetPrevPage();
				blnJetPrevLogout=JetPrev.fnJetPrevLogout();
				blnJPMilesValidation=JetPrev.fnJetPrevAdmin(testData);
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Place Order Fail for jet Prev Login ID : " + testData.UserName );
			}
			//actLib.waitForVisibilityOfElement(BigBasketLocators.txtSearch, "Search Text Box", 20);
			//actLib.waitForElementPresent(BigBasketLocators.txtSearch, 60);
			//JetPrev.fnJetPrevSwitchBackToJetPrevPage();
			//blnJetPrevLogout=JetPrev.fnJetPrevLogout(); 
			
			/*if(blnJetPrevLogout)
			{
				extentLogs.pass("JetPrev Web Test Script ","Logout Pass for jet Prev Login ID : " + testData.UserName );
				
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Logout Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			
			
			if(blnJPMilesValidation)
			{
				extentLogs.pass("JetPrev Web Test Script ","JPMiles are getting credited within 75 days from the transaction date  jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","JPMiles are not getting credited within 75 days from the transaction date for jet Prev Login ID : " + testData.UserName );
			}*/
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Redirection";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(2, objIssue));
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="JET";
		objIssue.SUMMARY="[Affiliate] User is not able to place an order through BigBasket partner";
		objIssue.DESCRIPTION="[Affiliate] User is not able to place an order through BigBasket partner using COD option";
		objIssue.PRIORITY="High";
	}
	
	
}

