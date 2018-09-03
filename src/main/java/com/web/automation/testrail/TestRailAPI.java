package com.web.automation.testrail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.TestRail.CaseTypes;
import com.codepine.api.testrail.TestRail.Projects;
import com.codepine.api.testrail.model.Project;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.Suite;
import com.web.automation.accelerators.TestEngineWeb;
import com.codepine.api.testrail.model.Run;
public class TestRailAPI {

	public TestRail testRail;
	//private final static String endPoint = "https://cignitiautomation.testrail.net";
	//private final static String username = "automationcigniti@gmail.com";
	private final static String endPoint = "https://jetpri.testrail.io/";
	private final static String username = "rajdeep.datta@cigniti.com";
	private final static String password = "test@123";
	
	
	public TestRailAPI()
	{
		createTestRailInstance();
	}
	
	
	// **** Create getter and setter for project id and suite id. 
		// so that can be use further *********
		 private static int projectId;
		 private static int suiteId;
		 
		 public static int getProjectId() {
		    return projectId;
		 }
		 public void setProjectId(int projectId) {
		    this.projectId = projectId;
		 }
		 public static int getSuiteId() {
		    return suiteId;
		 }
		 public void setSuiteId(int suiteId) {
		    this.suiteId = suiteId;
		 }
	public TestRail createTestRailInstance() {
	 if (this.testRail == null) {
	     this.testRail = TestRail.builder(endPoint, username, password).build();
	   }
	   return this.testRail;
	 }
	public  void setProjectSuiteId(String projectName, String suiteName){
		 try{
		     Projects projects = testRail.projects();
		     List<Project> projectList = projects.list().execute();
		     int pid = 0;
		     int sid = 0;
		     for(Project project : projectList){
		        if(project.getName().equals(projectName)){
		           pid = project.getId();
		           setProjectId(pid);
		           System.out.println(pid);
		          break;
		       }
		    }
		   if(pid !=0){
			   List<Suite> suiteList = testRail.suites().list(pid).execute();
			
		      for(Suite s : suiteList){
		          String sName = s.getName();
		          if(sName.equals(suiteName))
		          {
		             sid = s.getId();
		             setSuiteId(sid);
		             System.out.println(sid);
		          }
		      }
		   }
		 }
		 catch(Exception e){
		      e.printStackTrace();
		   }
		 }
	
	// ******* Getter and setter for Run object **************
	public static Run run;
	public static Run getRun() {
	 return run;
	 }
	public void setRun(Run run) {
	 this.run = run;
	}

	// ***** Create Run Function *********
	public void createRun()  {
	    SimpleDateFormat format = new SimpleDateFormat("dd MMM yyy kk mm s");
	    Date date = new Date();
	    String dateString = format.format(date);
	    String runName = "JET_PREV_Automation_" + dateString;
	    try{
	       run = new Run();
	       run = testRail.runs().add(getProjectId(), run.setSuiteId(getSuiteId()).setName(runName).setIncludeAll(true)).execute();
	       setRun(run);
	    }
	    catch(Exception e){
	      e.printStackTrace();
	   }
	 }
	// **** below function help to add result for a test case 
	// with comment pass in function *********
	public  void addResult(String comment, int caseId){
	 try{
	    // if(null != testRail() ){
	     List customResultFields = TestEngineWeb.testStatus.objDemo.testRail.resultFields().list().execute();
	     TestEngineWeb.testStatus.objDemo.testRail.results().addForCase(getRun().getId(), caseId, new Result().setComment(comment), 
	        customResultFields).execute();
	    // }
	 }
	 catch(Exception e){
	     e.printStackTrace();
	  }
	}
	
	// ***** Close the current run ********
	public void closeRun(){
	 try{
	  //   testRail().runs().close(getRun().getId()).execute();
	   }
	 catch(Exception e){
	    e.printStackTrace();
	   }
	}
	// **** Function use to add final status with comment for a test case ***
	public void addStatusForCase(int statusId,int intCaseID){
		System.out.println("Entered in addStatusForCase method................");
	 try{
	     List customResultFields = TestEngineWeb.testStatus.objDemo.testRail.resultFields().list().execute();
	     TestEngineWeb.testStatus.objDemo.testRail.results().addForCase(getRun().getId(),intCaseID , new Result().setStatusId(statusId), customResultFields).execute();
	 }
	 catch(Exception e){
	     e.printStackTrace();
	 }
	}
	// **** This will add case id into current run
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	TestRunStatus testStatus=new TestRunStatus("ShopJetPrev","JetPrev_Functional");
	//	testStatus.
		TestRailAPI objDemo=new TestRailAPI();
		
		//createTestRailInstance();
		objDemo.setProjectSuiteId("Jet_Privilege","Smoke_TestCases");
		objDemo.createRun();
	//	int k=Integer.valueOf("C2");
	//	System.out.println(k);
		objDemo.addStatusForCase(1,2);
		
		//objDemo.addStatusForCase(5,2);
		//objDemo.addStatusForCase(2,3);
	}

	
	
}
