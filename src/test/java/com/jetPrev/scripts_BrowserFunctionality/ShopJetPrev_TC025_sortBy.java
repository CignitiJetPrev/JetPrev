package com.jetPrev.scripts_BrowserFunctionality;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jetPrev.testObjects_BrowserFunctionality.JetPrevPageLocators;
import com.jetPrev.workflows_BrowserFunctionality.JetPrevInput;
import com.jetPrev.workflows_BrowserFunctionality.JetPrevWorkflows;
import com.jetPrev.workflows_BrowserFunctionality.SheetDetails;
import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.fileutils.ExcelReader;
import com.web.automation.googledrive.ReportStatus;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.pages.SugarCRMPage;
import com.web.automation.pages.SugarContactsInput;
import com.web.automation.testmanagement.IssueDetails;
import com.web.automation.testrail.TestRunStatus;
import com.web.automation.utilities.CommonVariables;

public class ShopJetPrev_TC025_sortBy extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	public IssueDetails objIssue=new IssueDetails();//add this
	private JetPrevInput testData=new JetPrevInput();
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
		fnGetIssueDetails();//add this
	}
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void shopjetPrev_TC025_sortBy() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			extentLogs.info("JetPrev Web Test Script ","JetPrev login verification");
			//Login to JetPrev Application
			boolean blnsortby=JetPrev.fnJetsortby();
			
	
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Login";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(25, objIssue));//Change issue no  --- 
		
		
		
	}
	
	//add this block
		private void fnGetIssueDetails()
		{
			objIssue.ASSIGNEE="admin";
			objIssue.PROJECT="CIG";
			objIssue.SUMMARY="[Affiliate] Below mentioned options are not getting display under Sort By dropdown and valide their functionality:-1) Relevance2) Price(High to Low)3) Price(Low to  High)4) JPMiles Earning(Low to High)5) JPMiles Earning(High to Low)";
			objIssue.DESCRIPTION="[Affiliate] Below mentioned options are not getting displayed under Sort By dropdown and unable to valide their functionality:-1) Relevance2) Price(High to Low)3) Price(Low to  High)4) JPMiles Earning(Low to High)5) JPMiles Earning(High to Low)";
			objIssue.PRIORITY="High";
		}
	
	
}

