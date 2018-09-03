

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

public class JetPrev_TC012_SearchProduct extends TestEngineWeb {
	
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
		objDet.intRowNo=13;
		fnGetIssueDetails();
	}


	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void ShopJetPrev_TC012_SearchProduct() throws Throwable {
		try {
						
			testData=testData.getTestData(objDet);
			boolean blnJetPrevLogin=JetPrev.fnJetPrevLogin(testData);			
			//Search Product
			boolean blnJetPrevSearchProduct		    =JetPrev.fnJetPrevSearchProduct(testData);
			extentLogs.info("JetPrev Web Test Script ","JetPrev Search");
			boolean blnJetPrevFlipkartRedirection=JetPrev.fnJetPrevProceedToOnlinePartnerSiteFlipkart();
			boolean blnJetPrevFlipkartURL		= JetPrev.fnJetPrevValidateURL(testData);
			JetPrev.fnJetPrevSwitchBackToJetPrevPage();
			boolean blnJetPrevLogout=JetPrev.fnJetPrevLogout();
			
			
			if(blnJetPrevLogin)
			{
				extentLogs.pass("JetPrev Web Test Script ","Login Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Login Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			if(blnJetPrevSearchProduct)
			{
				extentLogs.pass("JetPrev Web Test Script ","Search Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Search Fail for jet Prev Login ID : " + testData.UserName );
			}
			if(blnJetPrevFlipkartRedirection)
			{
				extentLogs.pass("JetPrev Web Test Script ","Redirection Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Redirection Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			if(blnJetPrevFlipkartURL)
			{
				extentLogs.pass("JetPrev Web Test Script ","URL validation Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","URL validation Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			
	
			
			if(blnJetPrevLogout)
			{
				extentLogs.pass("JetPrev Web Test Script ","Logout Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Logout Fail for jet Prev Login ID : " + testData.UserName );
			}
			
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Redirection";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(12, objIssue));
	}
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able place a order by searching the product from the search bar";
		objIssue.DESCRIPTION="[Affiliate] User is not able place a order by searching the product from the search bar through Flipkart partner";
		objIssue.PRIORITY="High";
	}
	
}
