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

public class ShopJetPrev_TC029_placeorderBabycare extends TestEngineWeb {
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
		objDet.intRowNo=14;
		fnGetIssueDetails();
	}
	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	public void shopJetPrev_TC029_placeorderBabycare() throws Throwable {
		try {
			testData=testData.getTestData(objDet);
			//Search for a Baby Care product and navigate to first cry page
			boolean blnJetPrevSearch=JetPrev.BabyProductsearch();
			boolean blnJetPrevPlaceOrder=JetPrev.placeOrderBabyCare();			
			boolean blnRedirection=JetPrev.placeorderBabyCareFirstcry();
			boolean blnJetPrevURL= JetPrev.fnJetPrevValidateURL(testData);	
			
			if(blnJetPrevSearch)
			{
				System.out.println("Search functionality Pass");
				
			}
			else
			{
				System.out.println("Search functionality Fail");
			}
			
			if(blnJetPrevPlaceOrder)
			{
				System.out.println("Place Order Pass");
				
			}
			else
			{
				System.out.println("Place Order Fail" );
			}
			
			
			if(blnRedirection)
			{
				System.out.println("Redirection to First Cry Pass");
				
			}
			else
			{
				System.out.println("Redirection to First Cry Fail");
			}
			if(blnJetPrevURL)
			{
				System.out.println("URL validation Pass");
				
			}
			else
			{
				System.out.println("URL validation Fail");
			}
			
			
			
			/*blnJetPrevURL= true;
				if(blnJetPrevURL)
			{
			  extentLogs.pass( "Validate partner url","URL validation Pass for jet Prev Login ID : " +testData.PartnerName );
				
				
			}
			else
			{
				extentLogs.fail("Validate Partner url" ,"URL validation Pass for jet Prev Login ID : " +testData.PartnerName  );


			}*/
	}
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Login";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
		JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(29, objIssue));
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="admin";
		objIssue.PROJECT="CIG";
		objIssue.SUMMARY="[Affiliate] User is not able to place an order by selecting  any BabyCare product";
		objIssue.DESCRIPTION="[Affiliate] User is not able to place an order by selecting  any BabyCare product";
		objIssue.PRIORITY="Medium";
	}
	
	
}