package com.jetPrev.scripts_Sanity;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
import com.web.automation.utilities.CommonVariables;

public class JetPrev_Sanity_Enroll extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
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
	}
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void JetPrev_Smoke_Enroll() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			extentLogs.info("JetPrev Web Test Script ","JetPrev login verification");
			//Login to JetPrev Application
			boolean blnbuymiles=JetPrev.fnJetPrevEnroll(testData);
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
		
	}
	
	
	
	
}

