package com.jetPrev.scripts_Smoke;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.jetPrev.testObjects_BrowserFunctionality.JetPrev_Smoke_Locators;
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

public class JetPrev_Smoke_WebaccessibilityFooterChrome extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	private JetPrevInput testData=new JetPrevInput();
	public IssueDetails objIssue=new IssueDetails();
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
	public void JetPrev_WebaccessibilityFooterChrome() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			extentLogs.info("JetPrev Web Test Script ","JetPrev login verification");
			//Login to JetPrev Application
			boolean blnbuymiles=JetPrev.fnFooterWebaccessibility();
			/*JetPrev.fnWebaccess(JetPrev_Smoke_Locators.faceBook,"faceBook");
			 JetPrev.fnWebaccess(JetPrev_Smoke_Locators.instaGram,"instaGram");
			 JetPrev.fnWebaccess(JetPrev_Smoke_Locators.pinInterest,"pinInterest");
			 JetPrev.fnWebaccess(JetPrev_Smoke_Locators.featuredOffer,"featuredOffer");
			 JetPrev.fnWebaccess(JetPrev_Smoke_Locators.twitter,"twitter");
			 JetPrev.fnWebaccess(JetPrev_Smoke_Locators.youTube,"youTube");
			 JetPrev.fnWebaccess(JetPrev_Smoke_Locators.linkedIn,"linkedIn");*/
			
			if(blnbuymiles)
			{
				extentLogs.pass("JetPrev Web Test Script ","Login Pass for jet Prev Login ID : " + testData.Username );
				//First Row 
				
				
				//Second Row
				/*objDet.intRowNo=2;
				testData=testData.getTestData(objDet);
				*/
				
			}
			else
			{
				extentLogs.fail("JetPrev Web Test Script ","Login Fail for jet Prev Login ID : " + testData.Username );
			}
	
		}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Login";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(13, objIssue));
		
	}
	
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to place a order by selecting product from the Go quickly to category list";
		objIssue.DESCRIPTION="[Affiliate] User is not able to place a order by selecting product from the Go quickly to category list";
		objIssue.PRIORITY="High";
	}
	
}

