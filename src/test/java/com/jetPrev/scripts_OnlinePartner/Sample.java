package com.jetPrev.scripts_OnlinePartner;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
/*		File fileIE = new File("Tool/IEDrivers/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", fileIE.getAbsolutePath());
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);*/
        
//        cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		try{
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
//		driver = InitializeWebDriver.driver
		
		driver.get("http://selenium4testing.com");
		
		
		Thread.sleep(5000);
		
		//driver.quit();
		} catch(Exception e){
			System.out.println(e);
		}
		
		
		

	}

}
