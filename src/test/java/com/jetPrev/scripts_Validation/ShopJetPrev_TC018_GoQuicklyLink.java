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

public class ShopJetPrev_TC018_GoQuicklyLink extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	public IssueDetails objIssue=new IssueDetails();
	private JetPrevWorkflows JetPrev;
	SheetDetails objData=new SheetDetails();
	Map<String, List<String>> testdata = null;
	
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}
	@BeforeMethod(alwaysRun = true)
	public void  beforeMethod() throws Throwable {
		JetPrev = new JetPrevWorkflows(CommonVariables.CommonDriver.get());
		objData.strSheetPath=System.getProperty("user.dir").replace("\\", "/") + "/testdata/TestData.xlsx";
		objData.strSheetName="JetPrev";
		objData.intRowNo=1;
		fnGetIssueDetails();
	}
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void shopjetPrev_TC018_GoQuicklyLink() throws Throwable {
		try {
			testData=testData.getTestData(objData);
			//Verifying Go Quickly to has 7 Links 
			boolean blnJetPrevGoQuickly=JetPrev.fnGoQuicklytolink();
			
			if(blnJetPrevGoQuickly)
			{
				extentLogs.pass("JetPrev Web Test Script ","Go Quickly links verification Pass");
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Go Quickly links verification Fail" );
			}
			
			}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Login";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(18, objIssue));
		
		
		
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to verify that 'Go Quickly to' has 7 hyperlinks";
		objIssue.DESCRIPTION="[Affiliate] User is not able to verify that 'Go Quickly to' has 7 hyperlinks";
		objIssue.PRIORITY="Medium";
	}
	
	
	
}