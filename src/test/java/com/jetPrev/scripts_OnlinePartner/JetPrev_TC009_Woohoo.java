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

public class JetPrev_TC009_Woohoo extends TestEngineWeb {
	
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
		objDet.intRowNo=7;
		fnGetIssueDetails();
	}


	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void ShopJetPrev_TC009_Woohoo() throws Throwable {
		try {
						
			testData=testData.getTestData(objDet);
			boolean blnJetPrevLogin=JetPrev.fnJetPrevLogin(testData);			
			
			//Woohoo
			boolean blnJetPrevWoohoo	=JetPrev.fnJetPrevRedirectToOnlinePartnerSiteWoohoo();
			boolean blnJetPrevURL		= JetPrev.fnJetPrevValidateURL(testData);
			JetPrev.fnJetPrevSwitchBackToJetPrevPage();
			boolean blnJetPrevLogout=JetPrev.fnJetPrevLogout();
			
			
			if(blnJetPrevLogin)
			{
				System.out.println("Login Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				System.out.println("Login Fail for jet Prev Login ID : " + testData.UserName );
			}
			
			if(blnJetPrevWoohoo)
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
			
				
			
			if(blnJetPrevLogout)
			{
				System.out.println("Logout Pass for jet Prev Login ID : " + testData.UserName );
				
			}
			else
			{
				System.out.println("Logout Fail for jet Prev Login ID : " + testData.UserName );
			}
			
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Redirection";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(9, objIssue));
	}
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to validate URL for Woohoo partner";
		objIssue.DESCRIPTION="[Affiliate] User is not able to validate URL for Woohoo partner";
		objIssue.PRIORITY="High";
	}
	
}



