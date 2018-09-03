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

public class JetPrev_TC001_Amazon extends TestEngineWeb {
	
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	private JetPrevWorkflows JetPrev;
	SheetDetails objDet=new SheetDetails();
	Map<String, List<String>> testdata = null;
	ActionsLibrary actLib = new ActionsLibrary();
	public IssueDetails objIssue=new IssueDetails();
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
		objDet.intRowNo=12;
		fnGetIssueDetails();
	}


	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void ShotJetPrev_TC001_Amazon() throws Throwable {
		try {
						
			testData=testData.getTestData(objDet);
			boolean blnJetPrevLogin=JetPrev.fnJetPrevLogin(testData);
			//Amazon
			boolean blnJetPrevAmazon		    =JetPrev.fnJetPrevRedirectToOnlinePartnerSite();
			
			boolean blnJetPrevURL				= JetPrev.fnJetPrevValidateURL(testData);
			//boolean blnJetPrevURL				= JetPrev.fnJetPrevValidateURLForPartner(testData);
			boolean blnJetPrevAmazonSearch	    =JetPrev.fnJetPrevSearchProductOnAmazonSite(testData);
			boolean blnJetPrevAmazonPlaceOrder  =JetPrev.fnJetPrevPlaceOrderOnAmazonSite(testData);
			JetPrev.fnJetPrevSwitchBackToJetPrevPage();
			boolean blnJetPrevLogout=JetPrev.fnJetPrevLogout();
			boolean blnJPMilesValidation=JetPrev.fnJetPrevAdmin(testData);
			
			
			if(blnJetPrevLogin)
			{
				System.out.println("Login Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				System.out.println("Login Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			/*if(blnJetPrevAmazon)
			{
				extentLogs.pass("JetPrev Web Test Script ","Redirection Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Redirection Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			if(blnJetPrevURL)
			{
				extentLogs.pass("JetPrev Web Test Script ","URL validation Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","URL validation Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			if(blnJetPrevAmazonSearch)
			{
				extentLogs.pass("JetPrev Web Test Script ","Search Pass for Search text : " + testData.SearchText );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Search Fail for Search text : " + testData.SearchText );
			}
	
			if(blnJetPrevAmazonPlaceOrder)
			{
				extentLogs.pass("JetPrev Web Test Script ","Place Order Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Place Order Fail for jet Prev Login ID : " + testData.UserName );
			}*/
			if(blnJetPrevLogout)
			{
				System.out.println("Logout Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				System.out.println("Logout Fail for jet Prev Login ID : " + testData.UserName );
			}
			/*if(blnJPMilesValidation)
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
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(1, objIssue));
	}
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to place an order through Amazon.in partner";
		objIssue.DESCRIPTION="[Affiliate] User is not able to place an order through Amazon.in partner using COD option";
		objIssue.PRIORITY="High";
	}
	
}
