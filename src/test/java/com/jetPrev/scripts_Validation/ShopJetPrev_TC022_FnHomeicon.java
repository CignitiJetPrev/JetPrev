package com.jetPrev.scripts_Validation;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jetPrev.workflows_Validation.JetPrevInput;
import com.jetPrev.workflows_Validation.JetPrevWorkflows;
import com.jetPrev.workflows_Validation.SheetDetails;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.testmanagement.IssueDetails;
import com.web.automation.testrail.TestRunStatus;
import com.web.automation.utilities.CommonVariables;

public class ShopJetPrev_TC022_FnHomeicon extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	private JetPrevWorkflows JetPrev;
	SheetDetails objDet=new SheetDetails();
	public IssueDetails objIssue=new IssueDetails();
	Map<String, List<String>> testdata = null;
	
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
		objDet.intRowNo=1;
		fnGetIssueDetails();
		
	}
	@Test(description = "ShopJetPrev", groups = { "smoke", "regression" })
	public void shopjetPrev_TC022_FnHomeicon() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			//extentLogs.info("JetPrev Web Test Script ","JetPrev login verification");
			//Search for a Baby Care product
			boolean blnJetPrevSearch=JetPrev.BabyProductsearch();
			//Functionality of Home Icon
			boolean blnJetPrevHomePage=JetPrev.fnhomeicon();
			
			if(blnJetPrevSearch)
			{
				extentLogs.pass("JetPrev Web Test Script ","Search functionality Pass" );
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Search functionality Fail");
			}
			
			if(blnJetPrevHomePage)
			{
				extentLogs.pass("JetPrev Web Test Script ","Home Page validation Pass");
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Home Page validation Fail");
			}
				}
		catch (Exception e) {
			testCaseFailureReason = "Failed to perform the functionality of Home icon";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(22, objIssue));
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to redirect  to the homepage after clicking on 'Home' icon";
		objIssue.DESCRIPTION="[Affiliate] User is not able to redirect  to the homepage after clicking on 'Home' icon";
		objIssue.PRIORITY="Medium";
	}
	
	
}
