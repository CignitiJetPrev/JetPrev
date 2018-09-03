package com.jetPrev.scripts_BrowserFunctionality;

import org.apache.poi.hslf.record.Sound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;


public class test {

	/*public static void main(String[] args) throws Exception {*/
		// TODO Auto-generated method stub

		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\E001888\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
			
			
			driver.get("http://doodlebluemobile.com/validus/validusdev/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/section[1]/nav/div/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//input[@id='Email_Id']")).sendKeys("nithin.bolishetti@yahoo.com");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test@123");*/
		
	
		
		

		 static String startdate;

		 static String enddate;

		 static Date date1 = null;

		 static Date date2 = null;

		 // public int daysdiff;

		 static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		 public static void main(String[] args) {

		  System.out.println("Enter Start Date: ");

		  Scanner scanner = new Scanner(System.in);

		  startdate = scanner.next();

		  System.out.println("Enter End Date: ");

		  // Scanner startdate = new Scanner(System.in);

		  enddate = scanner.next();
		  

		 

		  int j = totdays();

		  // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		  for (int i = 1; i <= j; i++) {

		   try {

		    // Parsing the String

		    date1 = dateFormat.parse(startdate + i);

		    date2 = dateFormat.parse(enddate);

		    SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");

		    System.out.println(simpleDateformat.format(date1));

		    // System.out.println(simpleDateformat.format(date2));

		   } catch (ParseException e) {

		    // TODO Auto-generated catch block

		    e.printStackTrace();

		   }
		  }

		 }

		 public static int totdays() {

		  Date now = new Date();

		  int daysdiff = 0;

		  try {

		   date1 = dateFormat.parse(startdate);

		   date2 = dateFormat.parse(enddate);

		  } catch (ParseException e1) {

		   // TODO Auto-generated catch block

		   e1.printStackTrace();

		  }

		  try {

		   long diff = date2.getTime() - date1.getTime();

	//	   long diffDays = diff / (24  60  60 * 1000) + 1;

		 //  daysdiff = (int) diffDays;

		   System.out.println("Total days are: " + daysdiff);

		  } catch (Exception e) {

		   e.getMessage();

		  }

		  return daysdiff;

		 }

		
	
	}


