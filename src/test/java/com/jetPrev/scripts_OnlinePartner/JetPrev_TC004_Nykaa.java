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

public class JetPrev_TC004_Nykaa extends TestEngineWeb {

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
		objDet.intRowNo=11;
		fnGetIssueDetails();
	}


	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void ShopJetPrev_TC004_Nykaa() throws Throwable {
		try {

			testData=testData.getTestData(objDet);
			boolean blnJetPrevLogin=JetPrev.fnJetPrevLogin(testData);

			//Nykaa
			boolean blnJetPrevNykaa		    =JetPrev.fnJetPrevRedirectToOnlinePartnerSiteNykaa();	
			extentLogs.info("JetPrev Web Test Script ","JetPrev Nykaa redirection");
			boolean blnJetPrevURL				=JetPrev.fnJetPrevValidateURL(testData);
			boolean blnJetPrevNykaaPlaceOrder	=JetPrev.fnJetPrevPlaceOrderOnNykaaSite(testData);
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

			if(blnJetPrevNykaa)
			{
				System.out.println("Redirection Pass for jet Prev Login ID : " + testData.UserName );

			}
			else
			{
				System.out.println("Redirection Fail for jet Prev Login ID : " + testData.UserName );
			}

			/*if(blnJetPrevURL)
			{
				extentLogs.pass("JetPrev Web Test Script ","URL validation Pass for jet Prev Login ID : " + testData.UserName );

			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","URL validation Fail for jet Prev Login ID : " + testData.UserName );
			}*/



			if(blnJetPrevNykaaPlaceOrder)
			{
				System.out.println("Place Order Pass for jet Prev Login ID : " + testData.UserName );

			}
			else
			{
				System.out.println("Place Order Fail for jet Prev Login ID : " + testData.UserName );
			}
			if(blnJetPrevLogout)
			{
				System.out.println("Logout Pass for jet Prev Login ID : " + testData.UserName );

			}
			else
			{
				System.out.println("Logout Fail for jet Prev Login ID : " + testData.UserName );
			}
			if(blnJPMilesValidation)
			{
				System.out.println("JPMiles are getting credited within 75 days from the transaction date  jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				System.out.println("JPMiles are not getting credited within 75 days from the transaction date for jet Prev Login ID : " + testData.UserName );
			}
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Redirection";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(4, objIssue));
	}

	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to place an order through Nykaa partner";
		objIssue.DESCRIPTION="[Affiliate] User is not able to place an order through Nykaa partner using COD option";
		objIssue.PRIORITY="High";
	}


}

