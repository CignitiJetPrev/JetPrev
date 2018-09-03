package com.web.automation.googledrive;

import java.io.File;

import org.testng.annotations.Test;

public class GDriveAPI {

	@Test
	public void fnGDrive()
	{
		// TODO Auto-generated method stub
		System.out.println("****************************************************");
		System.out.println("******** Google API Started to Connected ***********");
		System.out.println("****************************************************");
		String strRootFolderName="IOS_2_0_0_1";
		String strFileType=".ipa";
		String strPath="/Users/madanmohanpeddagouni/Documents/HOOQ/HOOQ_IOS/HOOQTV/ipa/ipaFromGoogleDrive/HOOQIPA.ipa";
		boolean blnDownload=GoogleDriveAPI.fnDownloadFileToLocal(strRootFolderName, strFileType, strPath);	
		System.out.println("****************************************************");
		
	}
	
}
