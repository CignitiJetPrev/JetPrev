package com.web.automation.testmanagement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.CustomFieldOption;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
public class JiraAPI {

	public String JIRA_URL;
	public String JIRA_USERID;
	public String JIRA_USER_PASSWORD;

	 BasicCredentials creds = new BasicCredentials("srikanth.salver@cigniti.com", "Passwor10d");
	// JiraClient jira = new JiraClient("https://jirashop.atlassian.net", creds);
	 JiraClient jira = new JiraClient("https://vernost.atlassian.net/projects/CIG/issues/?filter=allopenissues", creds);

	 public JiraClient createJiraConnection(JiraAPI objJIRA)
	 {
		 BasicCredentials creds = new BasicCredentials(objJIRA.JIRA_USERID, objJIRA.JIRA_USER_PASSWORD);
		 JiraClient jira = new JiraClient(objJIRA.JIRA_URL, creds);
		 return jira;
	 }

	 public static void main(String[] args) throws JiraException {
		// TODO Auto-generated method stub
		 BasicCredentials creds = new BasicCredentials("srikanth.salver@cigniti.com","Passwor10d");
		 JiraClient jira = new JiraClient("https://vernost.atlassian.net/", creds);
	    // Issue issue = jira.getIssue("AUT-2");
         /* Print the issue key. */
         //System.out.println(issue);
         //System.out.println(issue.getKey());
         //System.out.println(issue.getAssignee());
         Issue newIssue = jira.createIssue("CIG", "Bug")
        		 .field(Field.SUMMARY, "[Test]Jet Prev  is not working in Web")
        		 .field(Field.ASSIGNEE, "admin")
        		 .field(Field.DESCRIPTION, "Bug Created by the By  (Cigniti)")
        		 .field(Field.PRIORITY, "High")
        		 .execute();
       System.out.println(newIssue);
       System.out.println(newIssue.getKey());
       System.out.println(newIssue.getDescription());

	}

	 /*****************
	  * fnGetIssueDetails
	  * To the JIRA Bug Details
	  * @param objJIRA
	  * @param strIssueNo
	  * @return
	  * @Created By: Pankaj Kumar
	  * @throws JiraException
	  */

	 public static Issue fnGetIssueDetails(JiraAPI objJIRA,String strIssueNo) throws JiraException
	 {
		 Issue issue=null;
		 try
		 {
			 JiraAPI objJIRAClient=new JiraAPI();
			 issue=objJIRAClient.createJiraConnection(objJIRA).getIssue(strIssueNo);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return issue;
	 }

	 public static Issue fnCreateNewIssue(JiraAPI objJIRA,IssueDetails objField) throws JiraException
	 {
		 Issue newIssue=null;
		 try
		 {
			 JiraAPI objJIRAClient=new JiraAPI();
			 newIssue = objJIRAClient.createJiraConnection(objJIRA).createIssue(objField.PROJECT, "Bug")
	        		 .field(Field.SUMMARY, objField.SUMMARY)
	        		 .field(Field.ASSIGNEE, objField.ASSIGNEE)
	        		 .field(Field.DESCRIPTION, objField.DESCRIPTION)
	        		 .field(Field.PRIORITY, objField.PRIORITY)
	        		 .execute();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return newIssue;
	 }

	 public static void fnAddAttachment(JiraAPI objJIRA,String strIssueNo,String FilePath)
	 {
		 try
		 {
			 JiraAPI objJIRAClient=new JiraAPI();
			 Issue issue=objJIRAClient.createJiraConnection(objJIRA).getIssue(strIssueNo);
			 issue.addAttachment(new File(FilePath));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }

	 public static void fnDisplayJIRAISSSUE(Issue issue)
	 {
		 System.out.println("*********************************************************");
		 System.out.println("Issue Key :- " +issue.getKey());
		 System.out.println("Project Name :- " +issue.getProject());
		 System.out.println("Issue Description :- " +issue.getDescription());
		 System.out.println("Issue Summary :- " +issue.getSummary());
		 System.out.println("Issue Assigne :- " +issue.getAssignee());
		 System.out.println("Issue Priority :- " +issue.getPriority());
		 System.out.println("Issue Status :- " +issue.getStatus());
		 System.out.println("*********************************************************");
	 }
	 
	 public static Issue fnAddDefectInJira(IssueDetails issueDetails) throws JiraException
	 {
		 JiraAPI objJIRA=new JiraAPI();
		 objJIRA.JIRA_URL="https://vernost.atlassian.net/";
		 objJIRA.JIRA_USERID="srikanth.salver@cigniti.com";
		 objJIRA.JIRA_USER_PASSWORD="Passwor10d";
		 Issue newIssue=objJIRA.fnCreateNewIssue(objJIRA, issueDetails);
		 return newIssue;
	 }
}
