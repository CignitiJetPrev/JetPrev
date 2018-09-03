package com.web.automation.googledrive;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ReportStatus {
public static boolean blnStatus=true;
public static boolean blnElementStatus=true;
public static boolean blnOverall=true;



public static void fnUpdateResultStatus(String strBrowser,String strScriptName,String strBuildNo, String strSheetName) throws IOException, InterruptedException
{
	//Find the Row
	String spreadsheetId="1JbJZ2hjDwxDQ079VuvPdZjJrDrGTHR9NIUKdE2RnaWk";
	
	String range="";
	//Get the Row Number
	int intRowNo=GoogleDriveAPI.fnGetRowNo(strBrowser,strSheetName);				
	//Update Current Status
	String strStatus="";
	boolean blnStatus=ReportStatus.blnStatus;
	if(blnStatus)
	{
		strStatus="PASS";
	}
	else
	{
		strStatus="FAIL";
	}
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	LocalDate localDate = LocalDate.now();
	String strDate=dtf.format(localDate);
	Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String strTime=sdf.format(cal.getTime());
	//Update the Current Status
	String rangeStatus = strSheetName+"!G"+intRowNo+":G"+intRowNo;
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeStatus,strStatus);
	//Update Current Date
	String rangeCurrentDate = strSheetName+"!I"+intRowNo+":I"+intRowNo;
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeCurrentDate,strDate);
	//Update Current Time
	String rangeCurrentTime = strSheetName+"!J"+intRowNo+":J"+intRowNo;
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeCurrentTime,strTime);
	//Update Current Build No
	String rangeCurrentBuild = strSheetName+"!H"+intRowNo+":H"+intRowNo;
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeCurrentBuild,strBuildNo);
	if(strBuildNo.length()>0)
	{
	if(strStatus.equals("PASS"))
	{
		//Update Pass Count
		String rangePassCount = strSheetName+"!K"+intRowNo+":K"+intRowNo;
		//Get the current Count of Pass
		String strPassCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangePassCount);
		int CountPass=Integer.parseInt(strPassCount)+1;
		String strUpdatePassCount=String.valueOf(CountPass);
		GoogleDriveAPI.updateContentData(spreadsheetId,rangePassCount,strUpdatePassCount);
		//Update Last Pass Date
		String rangePassDate = strSheetName+"!L"+intRowNo+":L"+intRowNo;
		GoogleDriveAPI.updateContentData(spreadsheetId,rangePassDate,strDate);
		//Update Last Pass Time
		String rangePassTime = strSheetName+"!M"+intRowNo+":M"+intRowNo;
		GoogleDriveAPI.updateContentData(spreadsheetId,rangePassTime,strTime);
		//Update Last Pass Build
		String rangePassBuild = strSheetName+"!N"+intRowNo+":N"+intRowNo;
		GoogleDriveAPI.updateContentData(spreadsheetId,rangePassBuild,strBuildNo);
	}
	else
	{
		//Update Fail Count
		String rangeFailCount = strSheetName+"!O"+intRowNo+":O"+intRowNo;
		String strFailCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangeFailCount);
		int CountFail=Integer.parseInt(strFailCount)+1;
		String strUpdateFailCount=String.valueOf(CountFail);
		GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailCount,strUpdateFailCount);	
		//Update Last Fail Date
		String rangeFailDate = strSheetName+"!P"+intRowNo+":P"+intRowNo;
		GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailDate,strDate);
		//Update Last Fail Time
		String rangeFailTime = strSheetName+"!Q"+intRowNo+":Q"+intRowNo;
		GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailTime,strTime);
		//Update Last Fail Build
		String rangeFailBuild = strSheetName+"!R"+intRowNo+":R"+intRowNo;
		GoogleDriveAPI.updateContentData(spreadsheetId,rangeFailBuild,strBuildNo);
	}
	}
}





public static void fnUpdateResultStatustest() throws IOException, InterruptedException
{
	//Find the Row
	String spreadsheetId="1SULnMk5C6GEb0coZJYYAK8NEgPFBAfsVyQzYurMyyY8";
	String rangeStatus = "Test_Details_Chrome"+"!B2:B2";

	String strPassCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangeStatus);
	System.out.println(strPassCount);
	//GoogleDriveAPI.updateContentData(spreadsheetId,rangeStatus,"");

	
}

public static void fnUpdateStatus(String strURLID,String strBrowser) throws IOException, InterruptedException
{
	try {
	//Find the Row
	String spreadsheetId="1SULnMk5C6GEb0coZJYYAK8NEgPFBAfsVyQzYurMyyY8";
	strBrowser=fnGetBrowserName(strBrowser);
	String strSheetName="Test_Details_"+strBrowser;
	String range="";
	//Get the Row Number
	int intRowNo=GoogleDriveAPI.fnGetRowNo(strURLID,strSheetName);				
	//Update Current Status
	String rangeStatus = strSheetName+"!"+"D"+intRowNo+":"+"D"+intRowNo;
	String strStatus="";
	if(ReportStatus.blnOverall)
	{
		strStatus="PASS";
	}
	else
	{
		strStatus="FAIL";
	}
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeStatus,strStatus);	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	LocalDate localDate = LocalDate.now();
	String strDate=dtf.format(localDate);
	Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    String strTime=sdf.format(cal.getTime());
    String rangeStatusDate = strSheetName+"!"+"E"+intRowNo+":"+"E"+intRowNo;
    GoogleDriveAPI.updateContentData(spreadsheetId,rangeStatusDate,strDate);
    String rangeStatusTime = strSheetName+"!"+"F"+intRowNo+":"+"F"+intRowNo;
    GoogleDriveAPI.updateContentData(spreadsheetId,rangeStatusTime,strTime);
    ReportStatus.blnOverall=true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


public static void fnUpdateStatus(String strURLID,String strURL,String srComponent,boolean blnStatus,String strBrowser) throws IOException, InterruptedException
{
	try
	{
		//Find the Row
		String spreadsheetId="1SULnMk5C6GEb0coZJYYAK8NEgPFBAfsVyQzYurMyyY8";
		//String spreadsheetId = "1VOrG_QCJ2tG4LKF1iQfoJCfY9WY-dfW9CpNxbFaFDJM";
		strBrowser=fnGetBrowserName(strBrowser);
		String strSheetName="Test_Details_"+strBrowser;
		String range="";
		//Get the Row Number
		int intRowNo=GoogleDriveAPI.fnGetRowNo(strURLID,strSheetName);				
		//Update Current Status
		if(intRowNo==0)
		{
			intRowNo=fnAddNewNow(strURLID,strURL,strBrowser);
		}
		String strColumnName=fnGetColumnName(srComponent);
		String strStatus="";
		System.out.println("***************************************************************************************");
		
		System.out.println("ReportStatus.blnElementStatus  ==> " + ReportStatus.blnElementStatus );
		System.out.println("blnStatus  ==> " + blnStatus );
		
		System.out.println("***************************************************************************************");
		
		
		if(ReportStatus.blnElementStatus==false)
		{
			if(blnStatus==false)
			{
				strStatus="FAIL";
			}
			else
			{
				strStatus="Not Found";
			}
			
		}
		else
		{
			if(blnStatus==false)
			{
				strStatus="FAIL";
			}
			else if(blnStatus==true)
			{
			strStatus="PASS";
			}
		}
			String rangeStatus = strSheetName+"!"+strColumnName+intRowNo+":"+strColumnName+intRowNo;
			GoogleDriveAPI.updateContentData(spreadsheetId,rangeStatus,strStatus);	
			fnOverallStatus(blnStatus);
			ReportStatus.blnElementStatus=true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}


public static int fnAddNewNow(String strURLID,String strURL,String strBrowsername) throws IOException, InterruptedException
{
	//Find the Row
	String spreadsheetId="1SULnMk5C6GEb0coZJYYAK8NEgPFBAfsVyQzYurMyyY8";
	//String spreadsheetId="1VOrG_QCJ2tG4LKF1iQfoJCfY9WY-dfW9CpNxbFaFDJM";
	int intID=0;
	if(strBrowsername.toLowerCase().startsWith("ch"))
	{
		strBrowsername="Chrome";
		intID=4;
	}
	else if(strBrowsername.toLowerCase().startsWith("ie"))
	{
		strBrowsername="IE";
		intID=5;
	}
	else if(strBrowsername.toLowerCase().startsWith("f"))
	{
		strBrowsername="Firefox";
		intID=6;
	}
	String strSheetName="Test_Summary";
	//Update Pass Count
	String rangePassCount = strSheetName+"!D"+intID+":D"+intID;
	//Get the current Count of Pass
	String strPassCount=GoogleDriveAPI.fnGetData(spreadsheetId,rangePassCount);
	int CountPass=Integer.parseInt(strPassCount)+2;
	strSheetName="Test_Details_"+strBrowsername;
	String rangeID = strSheetName+"!A"+CountPass+":A"+CountPass;
	String strCounNo=String.valueOf(Integer.parseInt(strPassCount)+1);
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeID,strCounNo);	
	String rangeURLID = strSheetName+"!B"+CountPass+":B"+CountPass;
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeURLID,strURLID);	
	String rangeURL = strSheetName+"!C"+CountPass+":C"+CountPass;
	GoogleDriveAPI.updateContentData(spreadsheetId,rangeURL,strURL);	
	return CountPass;
}

public static String fnGetBrowserName(String strBrowser)
{
	String strNewBrowser="";
	if(strBrowser.contains("ch"))
	{
		strNewBrowser="Chrome";
	}
	else if(strBrowser.contains("ie"))
	{
		strNewBrowser="IE";
	}
	return strNewBrowser;
}



public static String fnGetColumnName(String strComponent)
{
	String strColumnName="";
	if(strComponent.toLowerCase().equals("calender"))
	{
		strColumnName="G";
	}
	else if(strComponent.toLowerCase().equals("checkboxinactive"))
	{
		strColumnName="H";
	}
	else if(strComponent.toLowerCase().equals("checkboxactive"))
	{
		strColumnName="I";
	}
	else if(strComponent.toLowerCase().equals("breadcrumpresentation"))
	{
		strColumnName="J";
	}
	else if(strComponent.toLowerCase().equals("commontable"))
	{
		strColumnName="K";
	}
		else if(strComponent.toLowerCase().equals("commontablecaption"))
	{
		strColumnName="L";
	}
	else if(strComponent.toLowerCase().equals("contentleveltab"))
	{
		strColumnName="M";
	}
	else if(strComponent.toLowerCase().equals("contentleveltabinactive"))
	{
		strColumnName="N";
	}
	else if(strComponent.toLowerCase().equals("countryicon"))
	{
		strColumnName="O";
	}
	else if(strComponent.toLowerCase().equals("expandcollapsetitle"))
	{
		strColumnName="P";
	}
	else if(strComponent.toLowerCase().equals("externallink"))
	{
		strColumnName="Q";
	}
	else if(strComponent.toLowerCase().equals("actionbuttonexternalurl"))
	{
		strColumnName="R";
	}
	else if(strComponent.toLowerCase().equals("h1"))
	{
		strColumnName="S";
	}
	else if(strComponent.toLowerCase().equals("h2"))
	{
		strColumnName="T";
	}
	else if(strComponent.toLowerCase().equals("h3"))
	{
		strColumnName="U";
	}
	else if(strComponent.toLowerCase().equals("helptext"))
	{
		strColumnName="V";
	}
	if(strComponent.toLowerCase().equals("iconnotification"))
	{
		strColumnName="W";
	}
	else if(strComponent.toLowerCase().equals("label"))
	{
		strColumnName="X";
	} 
	
	else if(strComponent.toLowerCase().equals("mandatoryicon"))
	{
		strColumnName="Y";
	}
	else if(strComponent.toLowerCase().equals("mfbutton"))
	{
		strColumnName="Z";
	} 
	
	else if(strComponent.toLowerCase().equals("oldformcontainer"))
	{
		strColumnName="AA";
	}
	else if(strComponent.toLowerCase().equals("p"))
	{
		strColumnName="AB";
	} 
	
	else if(strComponent.toLowerCase().equals("partnerbricka"))
	{
		strColumnName="AC";
	}
	else if(strComponent.toLowerCase().equals("partnerbrickonrhs"))
	{
		strColumnName="AD";
	} 
	
		else if(strComponent.toLowerCase().equals("partnerbricktypeone"))
	{
		strColumnName="AE";
	} 
		else if(strComponent.toLowerCase().equals("partnerbricktypetwo"))
	{
		strColumnName="AF";
	}
	else if(strComponent.toLowerCase().equals("partnerbricktypetwofooter"))
	{
		strColumnName="AG";
	} 
	else if(strComponent.toLowerCase().equals("passwordtext"))
	{
		strColumnName="AH";
	}
	else if(strComponent.toLowerCase().equals("pdfprint"))
	{
		strColumnName="AI";
	} 
	
	else if(strComponent.toLowerCase().equals("postloginnotification"))
	{
		strColumnName="AJ";
	}
	else if(strComponent.toLowerCase().equals("primarybutton"))
	{
		strColumnName="AK";
	} 
	else if(strComponent.toLowerCase().equals("radiobutton"))
	{
		strColumnName="AL";
	}
	else if(strComponent.toLowerCase().equals("secondarybutton"))
	{
		strColumnName="AM";
	} 
	else if(strComponent.toLowerCase().equals("secondlevelactive"))
	{
		strColumnName="AN";
	}
	else if(strComponent.toLowerCase().equals("secondlevelinactive"))
	{
		strColumnName="AO";
	} 
	else if(strComponent.toLowerCase().equals("table2"))
	{
		strColumnName="AP";
	}
	else if(strComponent.toLowerCase().equals("tabletwocaption"))
	{
		strColumnName="AQ";
	} 
	else if(strComponent.toLowerCase().equals("table4"))
	{
		strColumnName="AR";
	}
	else if(strComponent.toLowerCase().equals("tablefourcaption"))
	{
		strColumnName="AS";
	} 
	else if(strComponent.toLowerCase().equals("textfield"))
	{
		strColumnName="AT";
	}
	else if(strComponent.toLowerCase().equals("textfocus"))
	{
		strColumnName="AU";
	} 
	else if(strComponent.toLowerCase().equals("toasterpopup"))
	{
		strColumnName="AV";
	}
	else if(strComponent.toLowerCase().equals("webaccessibility"))
	{
		strColumnName="AW";
	} 
	else if(strComponent.toLowerCase().equals("whitebtn"))
	{
		strColumnName="AX";
	}
	else if(strComponent.toLowerCase().equals("breadcrum"))
	{
		strColumnName="AY";
	} 
	else if(strComponent.toLowerCase().equals("oldinnercontainer"))
	{
		strColumnName="AZ";
	} 
	
	
	return strColumnName;
	
}

public static void fnOverallStatus(boolean blnStatus)
{
	if(blnStatus==false)
	{
		ReportStatus.blnOverall=false;
	}
}

}
