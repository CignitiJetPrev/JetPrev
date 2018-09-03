package com.jetPrev.scripts_AndroidTabletComponents;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jetPrev.workflows_BrowserFunctionality.JetPrevInput;
import com.jetPrev.workflows_BrowserFunctionality.JetPrevWorkflows;
import com.jetPrev.workflows_BrowserFunctionality.JetPrevWorkflowsMobile;
import com.jetPrev.workflows_BrowserFunctionality.JetPrevWorkflowsTablet;
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

public class JetPrev_Smoke_AndroidTabletComponent_PartnerBrickonRHS extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	public IssueDetails objIssue=new IssueDetails();
	private JetPrevInput testData=new JetPrevInput();
	private JetPrevWorkflowsTablet JetPrev;
	SheetDetails objDet=new SheetDetails();
	Map<String, List<String>> testdata = null;
	
	public void TestCaseStatus(Boolean status, String reason) {
		if (status == false) {
			Assert.fail("Test Case Failed because - " + reason);
		}
	}
	@BeforeMethod(alwaysRun = true)
	@Parameters("rowNum")
	public void  beforeMethod(int rowNum) throws Throwable {
		JetPrev = new JetPrevWorkflowsTablet(CommonVariables.CommonDriver.get());
		objDet.strSheetPath=System.getProperty("user.dir").replace("\\", "/") + "/testdata/TestData.xlsx";
		objDet.strSheetName="JetPrev";
		 
		objDet.intRowNo=rowNum;
		fnGetIssueDetails();
	}
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void JetPrev_Smoke_AndroidTabletComponent_PartnerBrickonRHS() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			extentLogs.info("JetPrev Web Test Script ","JetPrev components verification");
			//Login to JetPrev Application
			
			boolean blnbuymiles=JetPrev.fnComponentpartnerbrickonRHS(testData);
			if(blnbuymiles)
			{
				extentLogs.pass("JetPrev Component PartnerBrickonRHS ","PartnerBrickonRHS Component is present on : " + testData.AppURL );
				//First Row 
				
				
				//Second Row
				/*objDet.intRowNo=2;
				testData=testData.getTestData(objDet);
				*/
				
			}
			else
			{
				extentLogs.fail("JetPrev Component PartnerBrickonRHS ","PartnerBrickonRHS Component is absent on : " + testData.AppURL );
			}
	
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Login";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		//JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(1, objIssue));
		
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="nithin.bolishetti";
		objIssue.PROJECT="JPW";
		objIssue.SUMMARY="[Affiliate] PartnerBrickonRHS component styles on android tablet browser are not as expected";
		objIssue.DESCRIPTION="[Affiliate] Styles of PartnerBrickonRHS component on android tablet browser are not as expected in "+"testData.AppURL"+"URL";
		objIssue.PRIORITY="High";
	}

	
	
}

