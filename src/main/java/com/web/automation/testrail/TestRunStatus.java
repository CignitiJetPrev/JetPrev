package com.web.automation.testrail;

import org.testng.Assert;

import com.web.automation.accelerators.TestEngineWeb;
import com.web.automation.googledrive.ReportStatus;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.slack.SlackApi;
import com.web.automation.slack.SlackMessage;
import com.web.automation.testmanagement.IssueDetails;
import com.web.automation.testmanagement.JiraAPI;

import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraException;

public class TestRunStatus {
	public TestRailAPI objDemo=null;
	public ExtentLogs extentLogs = new ExtentLogs();
	public TestRunStatus(String strProject,String strTestSuite)
	{
		 this.objDemo=new TestRailAPI();
		 this.objDemo.setProjectSuiteId(strProject,strTestSuite);
		 this.objDemo.createRun();
	}
	
	public static Issue fnReportStatus(int scriptID,IssueDetails issue) throws JiraException
	{
		Issue defect=null;
		String strStatus="untested";
		if(ReportStatus.blnStatus)
		{
			strStatus="pass";
		}
		else
		{
			strStatus="fail";
		}
		int intStatus=0;
		if(strStatus.toLowerCase().startsWith("pass"))
		{
			intStatus=1;
		}
		else if(strStatus.toLowerCase().startsWith("block"))
		{
			intStatus=2;
		}
		else if(strStatus.toLowerCase().startsWith("untes"))
		{
			intStatus=3;
		}
		else if(strStatus.toLowerCase().startsWith("retest"))
		{
			intStatus=4;
		}
		else if(strStatus.toLowerCase().startsWith("fail"))
		{
			intStatus=5;
		}
		TestEngineWeb.testStatus.objDemo.addStatusForCase(intStatus, scriptID);	
		if(strStatus.toLowerCase().startsWith("fail"))
		{
			defect=JiraAPI.fnAddDefectInJira(issue);	
			//fnUpdateSlackStatus(defect);
		}
		
		
		return defect;
	}
	
	public static boolean fnUpdateSlackStatus(Issue issue)
	{
		boolean status=true;
		try
		{
			SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
			if(issue!=null)
			{
				String strDetails="***********************FAIL******************************************";
				strDetails=strDetails + " \n " +"*************************************************************";
				strDetails=strDetails + "\n" + "Jet Prev Web Test Script Defect Details";
				strDetails=strDetails + "\n" + "Jira Defect ID : "+ issue.getKey();
				strDetails=strDetails + "\n" + "Jira Project Name :  " + issue.getProject().toString();
				strDetails=strDetails + "\n" + "Jira Defect Summary : "+ issue.getSummary();
				strDetails=strDetails + "\n" + "Jira Defect Description : "+ issue.getDescription();
				strDetails=strDetails + "\n" + "Jira Defect Assignee : "+ issue.getAssignee().toString();
				strDetails=strDetails + "\n" + "Jira Defect Priority : "+ issue.getPriority().toString();
				strDetails=strDetails + "\n" + "Jira Defect Status : "+ issue.getStatus().toString();
				strDetails=strDetails + " \n " +"*************************************************************";
				strDetails=strDetails + " \n " +"*************************************************************";
				api.call(new SlackMessage("#autodemo", "automationcigniti",strDetails ));
				
			}	
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;
	}
	
}
