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

public class ShopJetPrev_TC030_Category extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	public IssueDetails objIssue=new IssueDetails();//add this
	private JetPrevWorkflows JetPrev;
	SheetDetails objDet=new SheetDetails();
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
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void shopJetPrev_TC030_Category() throws Throwable {
		try {
			boolean blnJetPrevCategories=JetPrev.lstAllCategoriesJet();
			//JetPrev.lstAllCategoriesJet(testData);
			
			if(blnJetPrevCategories)
			{
				extentLogs.pass("JetPrev Web Test Script ","User is able to view the list of Subcategories by hovering the mouse pointer over the Categories");
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","User is not able to view the list of Subcategories by hovering the mouse pointer over the Categories" );
			}
	}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev All Categories script";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(30, objIssue));
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to view the list of Subcategories by hovering the mouse pointer over the Categories";
		objIssue.DESCRIPTION="[Affiliate] User is not able to view the list of Subcategories by hovering the mouse pointer over the Categories";
		objIssue.PRIORITY="High";
	}
	
	
	
}