package com.jetPrev.scripts_Components;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import com.web.automation.reports.ExtentManager;
import com.web.automation.testmanagement.IssueDetails;
import com.web.automation.testrail.TestRunStatus;
import com.web.automation.utilities.CommonVariables;

public class JetPrev_Smoke_Component_A_Dataprovider extends TestEngineWeb {
	private String testCaseFailureReason = "";
	private boolean testCaseStatus = true;
	private ExtentLogs extentLogs = new ExtentLogs();
	public IssueDetails objIssue=new IssueDetails();
	private JetPrevInput testData=new JetPrevInput();
	private JetPrevWorkflows JetPrev;
	public ExcelReader excelReader;
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
		objDet.strSheetPath=System.getProperty("user.dir").replace("\\", "/") + "/testdata/TestData_Components.xlsx";
		objDet.strSheetName="JetPrevComponent";
		//fnGetIssueDetails();
	}

	@Test(description = "JetPrev", groups = { "smoke", "regression" })
	@Parameters({"startRow","endRow"})
	public void JetPrev_Component_BreadcrumPresentation(int startRow, int endRow) throws Throwable {
		try {
			boolean blnLogin=true;
		
			for(int i=startRow;i<=endRow;i++)
			{
					objDet.intRowNo=i;
					testData=testData.getTestDataComponents(objDet);
					if(blnLogin)
					{
							//Login to Application			
							JetPrev.driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
							Thread.sleep(10000);
							JetPrev.driver.findElement(By.xpath("//div[@class='loginWrapper']")).click();
							Thread.sleep(1000);
							JetPrev.driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("132225785");
				    		Thread.sleep(1000);
				    		JetPrev.driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Blue@123");
				    		Thread.sleep(1000);
				    		JetPrev.driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
				    		Thread.sleep(2000);
				    		JetPrev.driver.findElement(By.xpath("(//input[@class='btnblue'])[1]")).click();
				    		Thread.sleep(10000);
				    		blnLogin=false;
					}
					JetPrev.driver.navigate().to(testData.AppURL);
					JetPrev.fnWaitForpageLoad();
					String strReportName=fnAddReport("JetPrev_URL_"+ i,"URL "+testData.AppURL);
					Thread.sleep(3000);
					boolean blnCanender=JetPrev.fnComponentCalendar(testData);
					if(ReportStatus.blnElementStatus)
					{
						if(blnCanender)
						{
							extentLogs.pass("JetPrev Component Calendar ","Calendar Component is present on : " + testData.AppURL );
						}
						else
						{
							extentLogs.fail("JetPrev Component Calendar ","Calendar Component styles are not as expected on : " + testData.AppURL );
						}
					}
					else
					{
						extentLogs.warning("JetPrev Component Calendar ","Calendar Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Calender", blnCanender, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					/*boolean blncheckbox=JetPrev.fnComponentCheckbox(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blncheckbox)
					{
						extentLogs.pass("JetPrev Component Checkboxinactive ","Checkboxinactive Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component Checkboxinactive ","Checkboxinactive Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component Checkboxinactive ","Checkboxinactive Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Checkboxinactive", blncheckbox, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
				
					if(ReportStatus.blnElementStatus==true) {
						boolean blncheckboxactive=JetPrev.fnComponentCheckbox(testData);
						ReportStatus.blnStatus = true;
						extentLogs.warning("JetPrev Component checkboxactive ","checkboxactive Component Component is absent on : " + testData.AppURL );
						ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "checkboxactive", blncheckboxactive, TestEngineWeb.strBrowserName);
					}else {
					boolean blncheckboxactive=JetPrev.fnComponentCheckboxActive(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blncheckboxactive)
					{
						extentLogs.pass("JetPrev Component checkboxactive ","checkboxactive Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component checkboxactive ","checkboxactive Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component checkboxactive ","checkboxactive Component Component is absent on : " + testData.AppURL );
					}
					
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "checkboxactive", blncheckboxactive, TestEngineWeb.strBrowserName);
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnbrdcrumPresentation=JetPrev.fnbreadcrumpresentation(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnbrdcrumPresentation)
					{
						extentLogs.pass("JetPrev Component BreadcrumPresentation ","BreadcrumPresentation Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component BreadcrumPresentation ","BreadcrumPresentation Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component BreadcrumPresentation ","BreadcrumPresentation  Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "BreadcrumPresentation", blnbrdcrumPresentation, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnCommonTable=JetPrev.fnComponentCommonTable(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnCommonTable)
					{
						extentLogs.pass("JetPrev Component CommonTable ","CommonTable Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component CommonTable ","CommonTable Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component CommonTable ","CommonTable Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "CommonTable", blnCommonTable, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					boolean blncommon=JetPrev.fnComponentCommonTableCaption(testData);
					Thread.sleep(3000);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blncommon)
					{
						extentLogs.pass("JetPrev Component CommonTableCaption ","CommonTableCaption Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component CommonTableCaption ","CommonTableCaption Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component CommonTableCaption ","CommonTableCaption Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "CommonTableCaption", blncommon, TestEngineWeb.strBrowserName);
					
					
					
					boolean blnContentLevelTab=JetPrev.fnComponentContentLevelTab(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnContentLevelTab)
					{
						extentLogs.pass("JetPrev Component ContentLevelTab ","ContentLevelTab Component is present on : " + testData.AppURL );
						
					}
					else
					{
						extentLogs.fail("JetPrev Component ContentLevelTab ","ContentLevelTab Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component ContentLevelTab ","ContentLevelTab Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ContentLevelTab", blnContentLevelTab, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blncontent=JetPrev.fnComponentContentLevelTabInactive(testData);
					Thread.sleep(3000);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blncontent)
					{
						extentLogs.pass("JetPrev Component ContentLevelTabInactive ","ContentLevelTabInactive Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component ContentLevelTabInactive ","ContentLevelTabInactive Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component ContentLevelTabInactive ","ContentLevelTabInactive Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ContentLevelTabInactive", blncontent, TestEngineWeb.strBrowserName);
					
					
					boolean blnCountryIcon=JetPrev.fnComponentCountryIcon(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnCountryIcon)
					{
						extentLogs.pass("JetPrev Component CountryIcon ","CountryIcon Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component CountryIcon ","CountryIcon Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component CountryIcon ","CountryIcon Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "CountryIcon", blnCountryIcon, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnExpandtitle=JetPrev.fnComponentExpandtitle(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnExpandtitle)
					{
						extentLogs.pass("JetPrev Component ExpandCollapseTitle ","ExpandCollapseTitle Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component ExpandCollapseTitle ","ExpandCollapseTitle Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component ExpandCollapseTitle ","ExpandCollapseTitle Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ExpandCollapseTitle", blnExpandtitle, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnExternalLink=JetPrev.fnComponentExternalLink(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnExternalLink)
					{
						extentLogs.pass("JetPrev Component ExternalLink ","ExternalLink Component is present on : " + testData.AppURL );
						
					}
					else
					{
						extentLogs.fail("JetPrev Component ExternalLink ","ExternalLink Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component ExternalLink ","ExternalLink Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ExternalLink", blnExternalLink, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnActionButtonExternalURL=JetPrev.fnComponentActionButtonExternalURL(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnActionButtonExternalURL)
					{
						extentLogs.pass("JetPrev Component ActionButtonExternalURL ","ActionButtonExternalURL Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component ActionButtonExternalURL ","ActionButtonExternalURL Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component ActionButtonExternalURL ","ActionButtonExternalURL Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ActionButtonExternalURL", blnActionButtonExternalURL, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					//boolean blnoldFormLabelupdated=JetPrev.fnComponentoldFormLabelupdated(testData);
					//if(ReportStatus.blnElementStatus)
					//{
					//if(blnoldFormLabelupdated)
					//{
					//	extentLogs.pass("JetPrev Component FormLabel ","FormLabel Component is present on : " + testData.AppURL );
						
					//}
					//else
					//{
					//	extentLogs.fail("JetPrev Component FormLabel ","FormLabel Component styles are not as expected : " + testData.AppURL );
					//}
					//}
					//else
					//{
					//	extentLogs.warning("JetPrev Component FormLabel ","FormLabel Component is absent on : " + testData.AppURL );
					//}
					//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "FormLabel", blnoldFormLabelupdated, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
				boolean blnH1=JetPrev.fnComponentH1(testData);
				if(ReportStatus.blnElementStatus)
				{
					if(blnH1)
					{
						extentLogs.pass("JetPrev Component H1 ","H1 Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component H1 ","H1 Component styles are not as expected : " + testData.AppURL );
					}
				}
				else
				{
					extentLogs.warning("JetPrev Component H1 ","H1 Component is absent on : " + testData.AppURL );
				}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "H1", blnH1, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnH2=JetPrev.fnComponentH2(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnH2)
					{
						extentLogs.pass("JetPrev Component H2 ","H2 Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component H2 ","H2 Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component H2 ","H2 Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "H2", blnH2, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					
					boolean blnbuymiles=JetPrev.fnComponentH3(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnbuymiles)
					{
						extentLogs.pass("JetPrev Component H3 ","H3 Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component H3 ","H3 Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component H3 ","H3 Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "H3", blnbuymiles, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					
					boolean blnHelptext=JetPrev.fnComponentHelptext(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnHelptext)
					{
						extentLogs.pass("JetPrev Component HelpText ","HelpText Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component HelpText ","HelpText Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component HelpText ","HelpText Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "HelpText", blnHelptext, TestEngineWeb.strBrowserName);
					
					boolean blnIconNotification=JetPrev.fnComponentIconNotifications(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnIconNotification)
					{
						extentLogs.pass("JetPrev Component IconNotification ","IconNotification Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component IconNotification ","IconNotification Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component IconNotification ","IconNotification Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "IconNotification", blnIconNotification, TestEngineWeb.strBrowserName);
					boolean blnLabel=JetPrev.fnComponentoldFormLabelupdated(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnLabel)
					{
						extentLogs.pass("JetPrev Component OldformLabel ","OldformLabel Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component OldformLabel ","OldformLabel Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component OldformLabel ","OldformLabel Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Label", blnLabel, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnMandatoryIcon=JetPrev.fnComponentMandatory(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnMandatoryIcon)
					{
						extentLogs.pass("JetPrev Component MandatoryIcon ","MandatoryIcon Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component MandatoryIcon ","MandatoryIcon Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component MandatoryIcon ","MandatoryIcon Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "MandatoryIcon", blnMandatoryIcon, TestEngineWeb.strBrowserName);
					boolean blnMFButton=JetPrev.fnComponentMFbutton(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnMFButton)
					{
						extentLogs.pass("JetPrev Component MFButton ","MFButton Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component MFButton ","MFButton Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component MFButton ","MFButton Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "MFButton", blnMFButton, TestEngineWeb.strBrowserName);
					//boolean blnNewFormContainer=JetPrev.fnComponentNewFormContainer(testData);
					//if(ReportStatus.blnElementStatus)
					//{
					//if(blnNewFormContainer)
					//{
					//	extentLogs.pass("JetPrev Component NewformfieldAlignment ","NewformfieldAlignment Component is present on : " + testData.AppURL );
					//
					//}
					//else
					//{
					//	extentLogs.fail("JetPrev Component NewformfieldAlignment ","NewformfieldAlignment Component styles are not as expected : " + testData.AppURL );
					//}
					//}
					//else
					//{
					//	extentLogs.warning("JetPrev Component NewformfieldAlignment ","NewformfieldAlignment Component is absent on : " + testData.AppURL );
					//}
					//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "NewformfieldAlignment", blnNewFormContainer, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
										
					//boolean blnNewFormLabel=JetPrev.fnComponentNewFormLabel(testData);
					//if(ReportStatus.blnElementStatus)
					//{
					
					//if(blnNewFormLabel)
					//{
					//	extentLogs.pass("JetPrev Component NewFormLabel ","NewFormLabel Component is present on : " + testData.AppURL );
					//	
					//}
					//else
					//{
					//	extentLogs.fail("JetPrev Component NewFormLabel ","NewFormLabel Component styles are not as expected : " + testData.AppURL );
					//}
					//}
					//else
					//{
					//	extentLogs.warning("JetPrev Component NewFormLabel ","NewFormLabel Component is absent on : " + testData.AppURL );
					//}
					//JetPrev.driver.navigate().to(testData.AppURL);
					//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "NewFormLabel", blnNewFormLabel, TestEngineWeb.strBrowserName);
					
					
					boolean blnoldFormContainer=JetPrev.fnComponentoldFormContainer(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnoldFormContainer)
					{
						extentLogs.pass("JetPrev Component oldFormContainer ","oldFormContainer Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component oldFormContainer ","oldFormContainer Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component oldFormContainer ","oldFormContainer Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "OldFormContainer", blnoldFormContainer, TestEngineWeb.strBrowserName);
					
					boolean blnP=JetPrev.fnComponentP(testData);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blnP)
					{
						extentLogs.pass("JetPrev Component P ","P Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component P ","P Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component P ","P Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "P", blnP, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					
					boolean blnpartnerBrickA =JetPrev.fnComponentpartnerbrickA(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnpartnerBrickA )
					{
						extentLogs.pass("JetPrev Component PartnerBrickA ","PartnerBrickA Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component PartnerBrickA ","PartnerBrickA Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PartnerBrickA ","PartnerBrickA Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PartnerBrickA", blnpartnerBrickA, TestEngineWeb.strBrowserName);
					
					boolean blnpartnerbrickonRHS=JetPrev.fnComponentpartnerbrickonRHS(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnpartnerbrickonRHS)
					{
						extentLogs.pass("JetPrev Component PartnerBrickonRHS ","PartnerBrickonRHS Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component PartnerBrickonRHS ","PartnerBrickonRHS Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PartnerBrickonRHS ","PartnerBrickonRHS Component is absent on : " + testData.AppURL );
					}
					//JetPrev.driver.navigate().to(testData.AppURL);
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PartnerBrickonRHS", blnpartnerbrickonRHS, TestEngineWeb.strBrowserName);
					//boolean blnpartnerbrickonRHSDetail=JetPrev.fnComponentpartnerbrickonRHSDetail(testData);
					//if(ReportStatus.blnElementStatus)
					//{
					//if(blnpartnerbrickonRHSDetail)
					//{
					//	extentLogs.pass("JetPrev Component PartnerBrickonRHSDetail ","PartnerBrickonRHSDetail Component is present on : " + testData.AppURL );
					//
					//}
					//else
					//{
					//	extentLogs.fail("JetPrev Component PartnerBrickonRHSDetail ","PartnerBrickonRHSDetail Component styles are not as expected : " + testData.AppURL );
					//}
					//}
					//else
					//{
					//	extentLogs.warning("JetPrev Component PartnerBrickonRHSDetail ","PartnerBrickonRHSDetail Component is absent on : " + testData.AppURL );
					//}
					//JetPrev.driver.navigate().to(testData.AppURL);
					//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PartnerBrickonRHSDetail", blnpartnerbrickonRHSDetail, TestEngineWeb.strBrowserName);
					boolean blnpartnerbricktypeOne=JetPrev.fnComponentpartnerbricktypeOne(testData);
					
					if(ReportStatus.blnElementStatus)
					{
					if(blnpartnerbricktypeOne)
					{
						extentLogs.pass("JetPrev Component PartnerBricktypeOne ","PartnerBricktypeOne Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component PartnerBricktypeOne ","PartnerBricktypeOne Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PartnerBricktypeOne ","PartnerBricktypeOne Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PartnerBricktypeOne", blnpartnerbricktypeOne, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					boolean blnpartnerbricktypeTwo=JetPrev.fnComponentpartnerbricktypeTwo(testData);
					
					if(ReportStatus.blnElementStatus)
					{
					if(blnpartnerbricktypeTwo)
					{
						extentLogs.pass("JetPrev Component PartnerBricktypeTwo ","PartnerBricktypeTwo Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component PartnerBricktypeTwo ","PartnerBricktypeTwo Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PartnerBricktypeTwo ","PartnerBricktypeTwo Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PartnerBricktypeTwo", blnpartnerbricktypeTwo, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);

					boolean blnpartnerbricktypeTwoFooter=JetPrev.fnComponentpartnerbricktypeTwoFooter(testData);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blnpartnerbricktypeTwoFooter)
					{
						extentLogs.pass("JetPrev Component PartnerBricktypeTwoFooter ","PartnerBricktypeTwoFooter Component is present on : " + testData.AppURL );
						
					}
					else
					{
						extentLogs.fail("JetPrev Component PartnerBricktypeTwoFooter ","PartnerBricktypeTwoFooter Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PartnerBricktypeTwoFooter ","PartnerBricktypeTwoFooter Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PartnerBricktypeTwoFooter", blnpartnerbricktypeTwoFooter, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					boolean blnPasswordText=JetPrev.fnComponentPasswordText(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnPasswordText)
					{
						extentLogs.pass("JetPrev Component Passwordtext ","Passwordtext Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component Passwordtext ","Passwordtext Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component Passwordtext ","Passwordtext Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Passwordtext", blnPasswordText, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnPDFandPRINT=JetPrev.fnComponentPDFandPRINT(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnPDFandPRINT)
					{
						extentLogs.pass("JetPrev Component PDFPrint ","PDFPrint Component is present on : " +" 'testData.AppURL'" );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component PDFPrint ","PDFPrint Component styles are not as expected : " +" 'testData.AppURL'" );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PDFPrint ","PDFPrint Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PDFPrint", blnPDFandPRINT, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnpostNotifications=JetPrev.fnComponentpostNotifications(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnpostNotifications)
					{
						extentLogs.pass("JetPrev Component PostLoginNotification ","PostLoginNotification Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component PostLoginNotification ","PostLoginNotification Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component PostLoginNotification ","PostLoginNotification Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "PostLoginNotification", blnpostNotifications, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					boolean blnPrimaryButton=JetPrev.fnComponentPrimaryButton(testData);
					
					if(ReportStatus.blnElementStatus)
					{
					if(blnPrimaryButton)
					{
						extentLogs.pass("JetPrev Component primaryButton ","PrimaryButton Component is present on : " + testData.AppURL);
					
					}
					else
					{
						extentLogs.fail("JetPrev Component primaryButton ","PrimaryButton Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component primaryButton ","primaryButton Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "primaryButton", blnPrimaryButton, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnRadioButton=JetPrev.fnComponentRadioButton(testData);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blnRadioButton)
					{
						extentLogs.pass("JetPrev Component RadioButton ","RadioButton Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component RadioButton ","RadioButton Component is present on : " + testData.AppURL);
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component RadioButton ","RadioButton Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "RadioButton", blnRadioButton, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					
					boolean blnSecondaryButton=JetPrev.fnComponentSecondaryButton(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnSecondaryButton)
					{
						extentLogs.pass("JetPrev Component SecondaryButton ","SecondaryButton Component is present on : " + testData.AppURL  );
					}
					else
					{
						extentLogs.fail("JetPrev Component SecondaryButton ","SecondaryButton Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component SecondaryButton ","SecondaryButton Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "SecondaryButton", blnSecondaryButton, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnSecondLevelActive=JetPrev.fnComponentSecondLevelActive(testData);
					
					if(ReportStatus.blnElementStatus)
					{
					if(blnSecondLevelActive)
					{
						extentLogs.pass("JetPrev Component SecondLevelActive ","SecondLevelActive Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component SecondLevelActive ","SecondLevelActive Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component SecondLevelActive ","SecondLevelActive Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "SecondLevelActive", blnSecondLevelActive, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnSecondLevelInactive=JetPrev.fnComponentSecondLevelInactive(testData);
					
					if(ReportStatus.blnElementStatus)
					{
					if(blnSecondLevelInactive)
					{
						extentLogs.pass("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "SecondLevelInactive", blnSecondLevelInactive, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blnTable2=JetPrev.fnComponentTable2(testData);
					
					if(ReportStatus.blnElementStatus)
					{
					if(blnTable2)
					{
						extentLogs.pass("JetPrev Component Table2 ","Table2 Component is present on : " + testData.AppURL );
					
					}
					else
					{
						extentLogs.fail("JetPrev Component Table2 ","Table2 Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component Table2 ","Table2 Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Table2", blnTable2, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blntable2=JetPrev.fnComponentTable2Caption(testData);
					Thread.sleep(3000);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blntable2)
					{
						extentLogs.pass("JetPrev Component TabletwoCaption ","TabletwoCaption Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component TabletwoCaption ","TabletwoCaption Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component TabletwoCaption ","TabletwoCaption Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "TabletwoCaption", blntable2, TestEngineWeb.strBrowserName);
					
					
					boolean blnTable4=JetPrev.fnComponentTable4(testData);
					if(ReportStatus.blnElementStatus)
					{
					if(blnTable4)
					{
						extentLogs.pass("JetPrev Component Table4 ","Table4 Component is present on : " + testData.AppURL );
						
					}
					else
					{
						extentLogs.fail("JetPrev Component Table4 ","Table4 Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component Table4 ","Table4 Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Table4", blnTable4, TestEngineWeb.strBrowserName);
					//JetPrev.driver.navigate().to(testData.AppURL);
					boolean blntable=JetPrev.fnComponentTable4Caption(testData);
					Thread.sleep(3000);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blntable)
					{
						extentLogs.pass("JetPrev Component TablefourCaption ","TablefourCaption Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component TablefourCaption ","TablefourCaption Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component TablefourCaption ","TablefourCaption Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "TablefourCaption", blntable, TestEngineWeb.strBrowserName);
					
					boolean blnTextField=JetPrev.fnComponentTextField(testData);
					if(ReportStatus.blnElementStatus)
					{
						if(blnTextField)
						{
							extentLogs.pass("JetPrev Component TextField ","TextField Component styles are not as expected : " + testData.AppURL);
						
						}
						else
						{
							extentLogs.fail("JetPrev Component TextField ","TextField Component styles are not as expected : " + testData.AppURL );
						}
					}
					else
					{
						extentLogs.warning("JetPrev Component TextField ","TextField Component is absent on : " + testData.AppURL );
					}
						ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "TextField", blnTextField, TestEngineWeb.strBrowserName);
						//JetPrev.driver.navigate().to(testData.AppURL);
						boolean blnTextFieldFocus=JetPrev.fnComponentTextFieldFocus(testData);
						if(ReportStatus.blnElementStatus)
						{
							if(blnTextFieldFocus)
							{
								extentLogs.pass("JetPrev Component Textfocus ","Textfocus Component is present on : " + testData.AppURL );
							
							}
							else
							{
								extentLogs.fail("JetPrev Component Textfocus ","Textfocus Component styles are not as expected : " + testData.AppURL );
							}
						}
						else
						{
							extentLogs.warning("JetPrev Component Textfocus ","Textfocus Component is absent on : " + testData.AppURL );
						}
							//JetPrev.driver.navigate().to(testData.AppURL);
							ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "TextFocus", blnTextFieldFocus, TestEngineWeb.strBrowserName);
							//boolean blnThirdlevelTabActive=JetPrev.fnComponentThirdlevelTabActive(testData);
							//if(ReportStatus.blnElementStatus)
							//{
							//if(blnThirdlevelTabActive)
							//{
							//	extentLogs.pass("JetPrev Component ThirdLeveltabActive ","ThirdLeveltabActive Component is present on : " + testData.AppURL );
							//	
							//}
							//else
							//{
							//	extentLogs.fail("JetPrev Component ThirdLeveltabActive ","ThirdLeveltabActive Component styles are not as expected : " + testData.AppURL );
							//}
							//}
							//else
							//{
							//	extentLogs.warning("JetPrev Component ThirdLeveltabActive ","ThirdLeveltabActive Component is absent on : " + testData.AppURL );
							//}
							//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ThirdLeveltabActive", blnThirdlevelTabActive, TestEngineWeb.strBrowserName);
							//JetPrev.driver.navigate().to(testData.AppURL);
							//boolean blnThirdLevelTabInactive=JetPrev.fnComponentThirdLevelTabInactive(testData);
							//if(ReportStatus.blnElementStatus)
							//{
							//if(blnThirdLevelTabInactive)
							//{
							//	extentLogs.pass("JetPrev Component ThirdLeveltabInActive ","ThirdLeveltabInActive Component is present on : " + testData.AppURL );
							//
							//}
							//else
							//{
							//	extentLogs.fail("JetPrev Component ThirdLeveltabInActive ","ThirdLeveltabInActive Component styles are not as expected : " + testData.AppURL );
							//}
							//}
							//else
							//{
							//	extentLogs.warning("JetPrev Component ThirdLeveltabInActive ","ThirdLeveltabInActive Component is absent on : " + testData.AppURL );
							//}
							//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ThirdLeveltabInActive", blnThirdLevelTabInactive, TestEngineWeb.strBrowserName);
							//JetPrev.driver.navigate().to(testData.AppURL);
							boolean blnToasterPopup=JetPrev.fnComponentToasterPopup(testData);
							
							if(ReportStatus.blnElementStatus)
							{
							if(blnToasterPopup)
							{
								extentLogs.pass("JetPrev Component ToasterPopUp ","ToasterPopUp Component is present on : " + testData.AppURL );
							
							}
							else
							{
								extentLogs.fail("JetPrev Component ToasterPopUp ","ToasterPopUp Component styles are not as expected : " + testData.AppURL );
							}
							}
							else
							{
								extentLogs.warning("JetPrev Component ToasterPopUp ","ToasterPopUp Component is absent on : " + testData.AppURL );
							}
							ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "ToasterPopUp", blnToasterPopup, TestEngineWeb.strBrowserName);
							//JetPrev.driver.navigate().to(testData.AppURL);
							//boolean blnTooltiptext=JetPrev.fnComponentTooltiptext(testData);
							
							//if(ReportStatus.blnElementStatus)
							//{
							//if(blnTooltiptext)
							//{
							//	extentLogs.pass("JetPrev Component Tooltipmessage ","Tooltipmessage Component is present on : " + testData.AppURL );
								
							//}
							//else
							//{
							//	extentLogs.fail("JetPrev Component Tooltipmessage ","Tooltipmessage Component styles are not as expected : " + testData.AppURL );
							//}
							//}
							//else
							//{
							//	extentLogs.warning("JetPrev Component Tooltipmessage ","Tooltipmessage Component is absent on : " + testData.AppURL );
							//}
							//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Tooltipmessage", blnTooltiptext, TestEngineWeb.strBrowserName);
							//JetPrev.driver.navigate().to(testData.AppURL);
							boolean blnWebaccesibility=JetPrev.fnComponentsWebaccesibility(testData);
							
							if(ReportStatus.blnElementStatus)
							{
							if(blnWebaccesibility)
							{
								extentLogs.pass("JetPrev  Webaccessibility ","Webaccessibility is succesfull on : " +" 'testData.AppURL'" );
								
							}
							else
							{
								extentLogs.fail("JetPrev Webaccessibility ","Webaccessibility is not performed on : " +" 'testData.AppURL'" );
							}
							}
							else
							{
								extentLogs.warning("JetPrev Component Webaccessibility ","Webaccessibility Component is absent on : " + testData.AppURL );
							}
							ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Webaccessibility", blnWebaccesibility, TestEngineWeb.strBrowserName);
							//JetPrev.driver.navigate().to(testData.AppURL);
							boolean blnwhitebtn=JetPrev.fnComponentwhitebtn(testData);
							
							if(ReportStatus.blnElementStatus)
							{
							if(blnwhitebtn)
							{
								extentLogs.pass("JetPrev Component whitebtn ","whitebtn Component is present on : " + testData.AppURL );
																
							}
							else
							{
								extentLogs.fail("JetPrev Component whitebtn ","whitebtn Component styles are not as expected : " + testData.AppURL );
							}
							}
							else
							{
								extentLogs.warning("JetPrev Component whitebtn ","whitebtn Component is absent on : " + testData.AppURL );
							}
							ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "Whitebtn", blnwhitebtn, TestEngineWeb.strBrowserName);
							//JetPrev.driver.navigate().to(testData.AppURL);
								
										
					
					boolean blnbread=JetPrev.fnbreadcrum(testData);
					Thread.sleep(3000);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blnbread)
					{
						extentLogs.pass("JetPrev Component BreadCrum ","BreadCrum Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component BreadCrum ","BreadCrum Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component BreadCrum ","BreadCrum Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "BreadCrum", blnbread, TestEngineWeb.strBrowserName);
					
					
					
					//boolean blncontainer=JetPrev.fnComponentNewInnerContainer(testData);
					//Thread.sleep(3000);
					//if(ReportStatus.blnElementStatus)
					//{
					
					//if(blncontainer)
					//{
					//	extentLogs.pass("JetPrev Component NewInnerContainer ","NewInnerContainer Component is present on : " + testData.AppURL );
					//}
					//else
					//{
					//	extentLogs.fail("JetPrev Component NewInnerContainer ","NewInnerContainer Component styles are not as expected : " + testData.AppURL );
					//}
					//}
					//else
					//{
					//	extentLogs.warning("JetPrev Component NewInnerContainer ","NewInnerContainer Component is absent on : " + testData.AppURL );
					//}
					//ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "NewInnerContainer", blncontainer, TestEngineWeb.strBrowserName);
					
					
					boolean blnold=JetPrev.fnComponentoldInnerContainer(testData);
					Thread.sleep(3000);
					if(ReportStatus.blnElementStatus)
					{
					
					if(blnold)
					{
						extentLogs.pass("JetPrev Component OldInnerContainer ","OldInnerContainer Component is present on : " + testData.AppURL );
					}
					else
					{
						extentLogs.fail("JetPrev Component OldInnerContainer ","OldInnerContainer Component styles are not as expected : " + testData.AppURL );
					}
					}
					else
					{
						extentLogs.warning("JetPrev Component OldInnerContainer ","OldInnerContainer Component is absent on : " + testData.AppURL );
					}
					ReportStatus.fnUpdateStatus(testData.URLID, testData.AppURL, "OldInnerContainer", blnold, TestEngineWeb.strBrowserName);
					
					
					
					
					
					*/
					
					
					ExtentManager.closeTest(strReportName);
					ReportStatus.fnUpdateStatus(testData.URLID,TestEngineWeb.strBrowserName);
				}
			}
		
		catch (Exception e) {
			testCaseFailureReason = "Failed to complete Jet Prev Web Login";
			String stackTrace = extentLogs.getStackTraceAsString("Test", testCaseFailureReason, e);
			extentLogs.fail("Jet Prev ", testCaseFailureReason + "Failed Reason : " + stackTrace);
			testCaseStatus = false;
		}
		TestCaseStatus(testCaseStatus, testCaseFailureReason);
	//	JetPrev.fnUpdateDefectDetails(TestRunStatus.fnReportStatus(1, objIssue));

		
		
	}
	
	private void fnGetIssueDetails()
	{
		objIssue.ASSIGNEE="nithin.bolishetti";
		objIssue.PROJECT="JPW";
		objIssue.SUMMARY="[Affiliate] BreadcrumPresentation component styles in chrome are not as expected";
		objIssue.DESCRIPTION="[Affiliate] Styles of BreadcrumPresentation component in chrome browser are not as expected in "+"testData.AppURL"+"URL";
		objIssue.PRIORITY="High";
	}

	
	public String fnAddReport(String strName,String strDesc)
	{
		String strReportName="";
		// code for extent reporting
		extentManager = new ExtentManager();
		extentManager.getTest(strName, "Description : " + strDesc);
		etest = ExtentManager.getTest();
		etest.assignCategory("Groups : " + CommonVariables.testNGGroupNames.toString());
		etest.assignAuthor("Developer : Cigniti Automation Team");
		//etest.log(ExtentLogName.INFO, "Info", "Executing Test Case : ***** " + this.methodName + " *****");
		CommonVariables.extentTest.set(etest);
		this.extentReporth = CommonVariables.extentReportPath.get();
		return strName;
	}
}

