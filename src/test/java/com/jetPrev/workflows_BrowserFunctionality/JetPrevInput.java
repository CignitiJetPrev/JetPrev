package com.jetPrev.workflows_BrowserFunctionality;

import java.io.IOException;

import com.web.automation.fileutils.ExcelReader;


public class JetPrevInput {
	public String UserName;
	public String Password;
	public String Section;
	public String Email;
	public String Passwordnew; 
	public String FName;
    public String LName;
    public String Mobile;
    public String PostalCode;
    public String AddressLine1;
    public String AddressLine2;
	public String PartnerName;
	public String Categories;
	public String Sub1;
	public String Sub2;
	public String Sub3;
	public String Sub4;
	public String Sub5;
	public String Sub6;
	public String Sub7;
	public String Sub8;
	public String Sub9;
	public String Sub10;
	public String Sub11;
	public String Sub12;
	public String Sub13;
	public String Sub14;
	
	
	public String Username;
	public String PassWord;
	public String CVV;
	public String CardName;
	public String RequiredMiles;
	public String CardNumber;
	public String ExpiryCard;
	
	public String FirstName;
	public String MiddleName;
	public String LastName;
	public String MobileNumber;
	public String PasswordIn;
	public String ReEnterPassword;
	
	public String AddressLine;
	public String AddressLineii;
	public String AddressLine3;
	public String CompanyName;
	public String BusinessCategory;
	public String Designation;
	
	public String StateBusiness;
	public String CityBusiness;
	public String JobTitle;
	public String PostalCodebusiness;
	public String AddressLineBusiness;
	public String AddressLine2Business;
	
	public String AddressLine3Business;
	
	
	public String State;
	public String City;
	public String Year;
	public String Date;
	public String CountryOfResidence;
	public String Citizenship;
	public String CountryCode;
	public String Month;
	public String Title;
	public String EmailID;
	
	public String GiftMiles;
	public String GiftMilesTo;
	public String PersonaliseMessage;
	
	//****** FLYDETAILS ******//
	
    public String From;
	public String To;
	public String FlyDate;
	public String Adult;
	public String Child;
	public String Cabin;
	public String Salutation;
	public String BookingFirstName;
	public String BookingMiddleName;
	public String BookingLastName;
	public String MealPreference;
	
	public String UsernameSanity;
	public String PassWordSanity;
	
	
	//****** GMAILLOGIN ******//
	
	public String GmailUserId;
	public String GmailPassword;
	public String Calendar;
	public String AppURL;
	public String URLID;
	
	
	
	
	
	public JetPrevInput getTestData(SheetDetails objSheet) throws IOException {
		JetPrevInput testData=new JetPrevInput();
		try {
			testData.UserName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "UserName");
			testData.Password=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Password");
			testData.Section=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Section");
			testData.Email=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Email");
			testData.Passwordnew=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Passwordnew");
		    testData.FName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "FName");
		    testData.LName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "LName");
		    testData.Mobile=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Mobile");
		    testData.PostalCode=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PostalCode");
		    testData.AddressLine1=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLine1");
		    testData.AddressLine2=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLine2");
		    testData.PartnerName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PartnerName");
		    testData.Categories=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Categories");
		    testData.Sub1=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub1");
		    testData.Sub2=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub2");
		    testData.Sub3=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub3");
		    testData.Sub4=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub4");
		    testData.Sub5=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub5");
		    testData.Sub6=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub6");
		    testData.Sub7=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub7");
		    testData.Sub8=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub8");
		    testData.Sub9=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub9");
		    testData.Sub10=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub10");
		    testData.Sub11=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub11");
		    testData.Sub12=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub12");
		    testData.Sub13=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub13");
		    testData.Sub14=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Sub14");
		    testData.Username=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Username");
		    testData.PassWord=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PassWord");
		    testData.RequiredMiles=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "RequiredMiles");
		    testData.CardNumber=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CardNumber");
		    testData.ExpiryCard=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "ExpiryCard");
		    testData.CVV=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CVV");
		    testData.CardName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CardName");
			   
		    //*******************---------Enroll---------*****************//
		    
		    testData.Title=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Title");
		    testData.FirstName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "FirstName");
			testData.MiddleName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "MiddleName");
			testData.LastName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "LastName");
			testData.MobileNumber=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "MobileNumber");
			testData.PasswordIn=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PasswordIn");
		    testData.ReEnterPassword=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "ReEnterPassword");
		    testData.AddressLine=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLine");
		    testData.AddressLineii=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLineii");
		    testData.AddressLine3=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLine3");
		    testData.CompanyName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CompanyName");
		    testData.BusinessCategory=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "BusinessCategory");
		    testData.Designation=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Designation");
		    testData.StateBusiness=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "StateBusiness");
		    testData.CityBusiness=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CityBusiness");
		    testData.JobTitle=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "JobTitle");
		    testData.PostalCodebusiness=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PostalCodebusiness");
		    testData.AddressLineBusiness=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLineBusiness");
		    testData.AddressLine2Business=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLine2Business");
		    testData.AddressLine3Business=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AddressLine3Business");
		    testData.State=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "State");
		    testData.City=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "City");
		    testData.Year=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Year");
		    testData.Date=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Date");
		    testData.CountryOfResidence=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CountryOfResidence");
		    testData.Citizenship=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Citizenship");
		    testData.CountryCode=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "CountryCode");
		    testData.Month=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Month");
		    testData.EmailID=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "EmailID");
		    testData.GiftMiles=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "GiftMiles");
		    testData.GiftMilesTo=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "GiftMilesTo");
		    testData.PersonaliseMessage=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PersonaliseMessage");
		    
		    //************-------FLY DETAILS---------**********//
		    
		    testData.From=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "From");
		    testData.To=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "To");
		    testData.FlyDate=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "FlyDate");
		    testData.Adult=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Adult");
		    testData.Child=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Child");
		    testData.Cabin=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Cabin");
		    testData.Salutation=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Salutation");
		    testData.BookingFirstName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "BookingFirstName");
		    testData.BookingMiddleName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "BookingMiddleName");
		    testData.BookingLastName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "BookingLastName");
		    testData.MealPreference=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "MealPreference");    
		    
		    //****************--------GMAIL DETAILS---------****************//
		    		      
		    testData.GmailUserId=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "GmailUserId");
		    testData.GmailPassword=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "GmailPassword");    
		    
		    testData.UsernameSanity=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "UsernameSanity");
		    testData.PassWordSanity=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PassWordSanity"); 
		    testData.Calendar=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Calendar");
		    testData.AppURL=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AppURL");
		    testData.URLID=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "URLID");
		
		} catch (Exception e) {
		
		}
		return testData;
	}
	
	
	public JetPrevInput getTestDataComponents(SheetDetails objSheet) throws IOException {
		JetPrevInput testData=new JetPrevInput();
		try {
		    testData.AppURL=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AppURL");
		    testData.URLID=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "URLID");
		
		} catch (Exception e) {
		
		}
		return testData;
	}
	
	
	
	
	
	
	
	
	
	
	}
