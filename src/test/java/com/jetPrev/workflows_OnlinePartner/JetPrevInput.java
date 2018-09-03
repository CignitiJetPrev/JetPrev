package com.jetPrev.workflows_OnlinePartner;

import java.io.IOException;

import com.web.automation.fileutils.ExcelReader;


public class JetPrevInput {
	public String UserName;
	public String Password;
	public String Section;
	public String SearchText;
	public String AmazonUserName;
	public String AmazonPassword;
	public String FlipkartUserName;
	public String FlipkartPassword;
	public String PartnerName;
	public String AdminUserName;
	public String AdminPassword;
	public String AdminPartnerName;
	
	
	public JetPrevInput getTestData(SheetDetails objSheet) throws IOException {
		JetPrevInput testData=new JetPrevInput();
		try {
			testData.UserName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "UserName");
			testData.Password=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Password");
			//testData.Section=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Section");
			testData.SearchText=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "SearchText");
			testData.AmazonUserName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AmazonUserName");
			testData.AmazonPassword=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AmazonPassword");
			testData.FlipkartUserName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "FlipkartUserName");
			testData.FlipkartPassword=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "FlipkartPassword");
			testData.PartnerName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PartnerName");
			testData.AdminUserName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AdminUserName");
			testData.AdminPassword=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AdminPassword");
			testData.AdminPartnerName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "AdminPartnerName");
			
			
		
		} catch (Exception e) {
		
		}
		return testData;
	}
	}
