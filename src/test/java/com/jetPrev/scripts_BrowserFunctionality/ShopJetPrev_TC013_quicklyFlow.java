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

public class ShopJetPrev_TC013_quicklyFlow extends TestEngineWeb {
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
		objDet.intRowNo=4;
		fnGetIssueDetails();//add this
	}
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void shopjetPrev_TC013_quicklyFlow() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			//Login to JetPrev Application
			boolean blnquicklyFlow=JetPrev.fnGoQuicklylinkFlow();
			
			if(blnquicklyFlow){
				extentLogs.pass("JetPrev Web Test Script ","User is able to place a order by selecting product from the Go quickly to category list" );
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","user is not able to place a order by selecting product from the Go quickly to category list" );
			}

			
	
		}
		catch (Exception e) {
			testCaseFailureReason = "User is not able to place a order by selecting product from the Go quickly to category list";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(13, objIssue));

		
		
		
		
	}
	
	//add this block
		private void fnGetIssueDetails()
		{
			objIssue.ASSIGNEE="admin";
			objIssue.PROJECT="CIG";
			objIssue.SUMMARY="[Affiliate] User is not able to place a order by selecting product from the Go quickly to category list";
			objIssue.DESCRIPTION="[Affiliate] User is not able to place a order by selecting product from the Go quickly to category list";
			objIssue.PRIORITY="High";
		}
	
	
}

