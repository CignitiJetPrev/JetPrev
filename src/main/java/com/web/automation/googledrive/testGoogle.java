package com.web.automation.googledrive;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testGoogle {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*String strRootFolderName="IOS_2_0_0_1";
		String strFileType=".ipa";
		String strPath="/Users/madanmohanpeddagouni/Documents/HOOQ/HOOQ_IOS/HOOQTV/ipa/ipaFromGoogleDrive/HOOQIPA.ipa";
		//String strLocalPath="C:/Test/HOOQAPK.apk";
		boolean blnDownload=GoogleDriveAPI.fnDownloadFileToLocal(strRootFolderName, strFileType, strPath);
		System.out.println("************************************");
		System.out.println("File Download Status ==> " + blnDownload);
		System.out.println("************************************");*/
		/*GoogleDriveAPI.setValue("Data","G2","G","Pass");
		GoogleDriveAPI.setValue("Data","G3","G","Fail");
		GoogleDriveAPI.setValue("Data","G4","G","Warning");
		GoogleDriveAPI.setValue("Data","G5","G","Pass");
		GoogleDriveAPI.setValue("Data","G6","G","Fail");
		GoogleDriveAPI.setValue("Data","G7","G","Pass");
		GoogleDriveAPI.setValue("Data","G8","G","Pass");
		GoogleDriveAPI.setValue("Data","G9","G","Warning");
		GoogleDriveAPI.setValue("Data","G10","G","Pass");*/
		//GoogleDriveAPI.fnGetData();

		/*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016/11/16
		System.out.println("Update Done");*/
		//String strMobile=GoogleDriveAPI.fnGetAPITestMobileNo();
		//System.out.println(strMobile);
		//String strUpdate=GoogleDriveAPI.fnUpdateAPITestMobileNo();
		//System.out.println(strUpdate);
		//String strMobile1=GoogleDriveAPI.fnGetAPITestMobileNo();
		//System.out.println(strMobile1);
		//int strRow=GoogleDriveAPI.fnGetRowNo("Web-Chrome", "HOOQ_Web_Login_Email");
		//System.out.println(strRow);
		//int intRowNo=GoogleDriveAPI.fnGetRowNo("IOS-Mobile", "HOOQ_IOS_Mobile_ActiveUserBrowse");
		
		//System.out.println(intRowNo);
		ReportStatus.blnStatus=false;
		//ReportStatus.fnUpdateResultStatus("Web-Chrome", "HOOQ_Web_ActiveUser_AddingFavouriteMovies", "Build 432","Sanity_Test_IN");
		//ReportStatus.fnUpdateResultStatustest();
		ReportStatus.fnUpdateStatus("URL_ID_3", "https://www.google.com", "calendar", true, "Chrome");
		

	}

}
