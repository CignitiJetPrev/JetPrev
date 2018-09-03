package com.jetPrev.workflows_Validation;
import java.io.IOException;

import com.web.automation.fileutils.ExcelReader;


public class JetPrevInput {
	public String UserName;
	public String Password;
	public String PartnerName;
	public String SearchText;

	
	
	public JetPrevInput getTestData(SheetDetails objSheet) throws IOException {
		JetPrevInput testData=new JetPrevInput();
		try {
			testData.UserName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "UserName");
			testData.Password=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "Password");
			testData.PartnerName=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "PartnerName");
			testData.SearchText=ExcelReader.fn_GetCellData(objSheet.strSheetPath, objSheet.strSheetName, objSheet.intRowNo, "SearchText");
		
		} catch (Exception e) {
		
		}
		return testData;
	}
	}
