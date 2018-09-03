package com.jetPrev.workflows_BrowserFunctionality;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JEditorPane;

import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amazonaws.services.simpleworkflow.flow.worker.SynchronousActivityTaskPoller;
import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.common.base.Optional;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.jetPrev.testObjects_BrowserFunctionality.JetPrevPageLocators;
import com.jetPrev.testObjects_BrowserFunctionality.JetPrev_Smoke_Locators;
import com.web.automation.accelerators.ActionsLibrary;
import com.web.automation.fileutils.ExcelReader;
import com.web.automation.googledrive.ReportStatus;
import com.web.automation.logs.ExtentLogs;
import com.web.automation.pages.BasePage;
import com.web.automation.utilities.ConfigManager;

import net.rcarz.jiraclient.Issue;


public class JetPrevWorkflowsMobile extends BasePage {
	public WebDriver driver=ActionsLibrary.driver;
	//public EventFiringWebDriver driver;
	public ExtentLogs extentLogs = new ExtentLogs();
	Optional<Long> timeoutInSecond = Optional.of(Long.parseLong("5"));

	public JetPrevWorkflowsMobile(WebDriver driver) {

		super(driver);

	}

	
	
	

public boolean fnComponentsWebaccesibility(JetPrevInput objData) throws Throwable {
	Boolean blnstatus = true;
	String str = null;
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("form"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			try {
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("id");
			System.out.println(str);
			if(str.contains("ctl00")){
				driver.findElement(By.xpath("//form[@id='"+str+"']")).click();
				int icounter=0;
				boolean flag=false;
				do {
					//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
					
					Actions a = new Actions(driver);
					a.sendKeys(Keys.TAB).build().perform();
					Thread.sleep(3000);
					String strClass=actionLib.getAttributeFromFocusedElement("class");
					String strClassAttribute="class";
					if(strClass.isEmpty()) {
						strClass=actionLib.getAttributeFromFocusedElement("id");
						 strClassAttribute="id";
					}
					if(strClass.isEmpty()) {
						strClass=actionLib.getAttributeFromFocusedElement("name");
						strClassAttribute="name";
					}
					if(!strClass.isEmpty()) {
					Thread.sleep(3000);
					flag=strClass.contains("back-to-top");
					
					Thread.sleep(3000);
					if(flag) {
						actionLib.validateCheckStyleAllComponents(driver.findElement(By.xpath("//*[@"+strClassAttribute+"='"+strClass+"']")), "WebaccessibiltyFocus");
						break;
						
					}else {
						icounter++;
					}
				actionLib.validateCheckStyleAllComponents(driver.findElement(By.xpath("//*[@"+strClassAttribute+"='"+strClass+"']")), "WebaccessibiltyFocus");
					}
				} while (icounter<63&&!flag);
			
			}
						}
			}
			catch(Exception e) {
				continue;
			}
		
 
		}
		
		//fnComponentLabel(objData);
		
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentTooltiptext(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			try {
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains("helpText")){
				
				Actions a = new Actions(driver);
				a.moveToElement(linkone.get(i)).build().perform();
			java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//span[@class='helpText']//span"));
			System.out.println(linktwo.size());
			for (int j = 0; j<linktwo.size(); j++)
	 		{
			//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
			actionLib.validateCheckStyleAllComponents(linktwo.get(j), "HelpTextMessageMobile");
			}
						}
			}
			}
			catch(Exception e) {
				continue;
			}
		
 
		}
		
		
		
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}






public boolean fnComponentHelptext(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			try {
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains("helpText")){
			//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
			actionLib.validateCheckStyleAllComponents(linkone.get(i), "HelpTextMobile");
			}
						}
			}
			catch(Exception e) {
				continue;
			}
		
 
		}
		
		
		
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentMandatory(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "errorText";
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains(str2)) {
				actionLib.validateCheckStyleAllComponents(linkone.get(i), "MandatoryFieldMobile");
			}
			else {
				extentLogs.info("JetPrev Component Mandatory ","Mandatory Component class : "+str2+" is not available on : " + objData.AppURL );
			     }
		     }
 		}
	}
		     catch(Exception e) {
		    	 e.printStackTrace();
		    	 blnstatus = false;
		    	 }
		    	 return blnstatus;
		    	 }


public boolean fnComponentCalendar(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "jppl-sprites ui-icon-datepicker";
	
	try {

		actionLib.OpenUrl(objData.AppURL);
		java.util.List<WebElement> linkone = driver.findElements(By.tagName("span"));
		System.out.println(linkone.size());
		for (int i = 0; i<linkone.size(); i++)
 		{
			
		     if(linkone.get(i).isDisplayed()) {
			str = linkone.get(i).getAttribute("class");
			System.out.println(str);
			if(str.contains(str2)) {
				String str1 = linkone.get(i).getText();
				System.out.println(str1);
			if(str1!=null) {
			extentLogs.info("Webaccessibility of calendar field  : "+str, "is displayed successfully.");
			}
			System.out.println(str);
			
				actionLib.validateCheckStyleAllComponents(linkone.get(i), "CalendarMobile");
			}else {
			extentLogs.info("JetPrev Component Calendar ","Calendar Component class : "+str2+"is not available on : " + objData.AppURL );
		     }}
 		}
	}
		     catch(Exception e) {
		    	 e.printStackTrace();
		    	 blnstatus = false;
		    	 }
		    	 return blnstatus;
		    	 }


public boolean fnComponentTextField(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str3 = "text";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[not(contains(@class,'_'))]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
    	 if(linktwo.get(i).isEnabled()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains(str3)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		String str1 = linktwo.get(i).getAttribute("aria-describedby");
		System.out.println(str1);
		if(str1!=null) {
		extentLogs.info("Webaccessibility of text field aria-describedby :"+str1, "is displayed successfully.");
		}
		String str2 = linktwo.get(i).getAttribute("aria-label");
		System.out.println(str2);
		if(str2!=null) {
		extentLogs.info("Webaccessibility of text field aria-label :"+str, "is displayed successfully.");
		}
	try {
		
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldMobile");
		/*Thread.sleep(4000);
		Actions a = new Actions(driver);
		 actionLib.HighlightWebElement(linktwo.get(i), 15);
		a.moveToElement(linktwo.get(i),1,1).build().perform();
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", linktwo.get(i));
		linktwo.get(i).clear();
		linktwo.get(i).click();
		linktwo.get(i).sendKeys("1");
		
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldType");*/
	} catch (Exception e) {
		// TODO Auto-generated catch block
		continue;
	}
	}
	else {
		extentLogs.info("JetPrev Component Textfield ","Textfield Component class : "+str3+"is not available on : " + objData.AppURL );
	     }
	
	}
    }
	}
	}
     
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTextFieldFocus(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str3 = "text";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[not(contains(@class,'_'))]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
    	 if(linktwo.get(i).isEnabled()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains(str3)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		String str1 = linktwo.get(i).getAttribute("aria-describedby");
		System.out.println(str1);
		if(str1!=null) {
		extentLogs.info("Webaccessibility of text field aria-describedby :"+str, "is displayed successfully.");
		}
		String str2 = linktwo.get(i).getAttribute("aria-label");
		System.out.println(str2);
		if(str2!=null) {
		extentLogs.info("Webaccessibility of text field aria-label :"+str, "is displayed successfully.");
		}
	try {
		
		/*actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextField");
		Thread.sleep(4000);*/
		Actions a = new Actions(driver);
		 actionLib.HighlightWebElement(linktwo.get(i), 5);
		a.moveToElement(linktwo.get(i),1,1).build().perform();
		/*JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", linktwo.get(i));*/
		linktwo.get(i).clear();
		/*linktwo.get(i).click();
		linktwo.get(i).sendKeys("1");
*/		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocusMobile");

		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		continue;
	}
	}else {
		extentLogs.info("JetPrev Component TextfieldFocus ","TextfieldFocus Component class : "+str3+"is not available on : " + objData.AppURL );
    }
	
	}
    }
	}
	}
     
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTextFieldFocusTyped(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str3 = "text";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[not(contains(@class,'_'))]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
    	 if(linktwo.get(i).isEnabled()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains("text")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		String str1 = linktwo.get(i).getAttribute("aria-describedby");
		System.out.println(str1);
		if(str1!=null) {
		extentLogs.info("Webaccessibility of text field aria-describedby :"+str, "is displayed successfully.");
		}
		String str2 = linktwo.get(i).getAttribute("aria-label");
		System.out.println(str2);
		if(str2!=null) {
		extentLogs.info("Webaccessibility of text field aria-label :"+str, "is displayed successfully.");
		}
	try {
		
		/*actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextField");
		Thread.sleep(4000);*/
		Actions a = new Actions(driver);
		 actionLib.HighlightWebElement(linktwo.get(i), 15);
		a.moveToElement(linktwo.get(i),1,1).build().perform();
		/*JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", linktwo.get(i));*/
		linktwo.get(i).clear();
		/*linktwo.get(i).click();
		linktwo.get(i).sendKeys("1");
*/		linktwo.get(i).sendKeys("abcd");
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocusTypedMobile");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		continue;
	}
	}else {
		extentLogs.info("JetPrev Component TextfieldFocustyped ","TextfieldFocustyped Component class : "+str3+"is not available on : " + objData.AppURL );
    }
	
	}
    }
	}
	}
     
	
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}





public boolean fnComponentCheckbox(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "checkbox";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains("checkbox")) {
		try {
						
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "CheckboxInactiveMobile");
				} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
	}
	else {
		extentLogs.info("JetPrev Component Checkbox Inactive ","checkbox Inactive Component class : "+str2+" is not available on : " + objData.AppURL );
	}
	}}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }




public boolean fnComponentCheckboxActive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "CheckboxActive";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains("checkbox")) {
		try {
			Actions a = new Actions(driver);
			 
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			try {
				a.click(linktwo.get(i)).build().perform();
				
				actionLib.validateCheckStyleAllComponents(linktwo.get(i), "CheckboxActiveMobile");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
	}
	else {
		extentLogs.info("JetPrev Component Checkbox active ","checkbox active Component class : "+str2+" is not available on : " + objData.AppURL );
	}
	}}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }



public boolean fnComponentRadioButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = "radio";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label[@for][1]"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	/*str = linktwo.get(i).getAttribute("type");
	System.out.println(str);*/
	/*if(str.contains("radio")) {*/
		try {
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "RadiobuttonInactiveMobile");
			Actions a = new Actions(driver);
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			//a.click(driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label[@for][1]")));
			//driver.findElement(By.xpath("//input[@type='"+str+"']")).click();
			
			linktwo.get(i).click();
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "RadiobuttonActiveMobile");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
	/*}*/
     }
     else{
  		extentLogs.info("JetPrev Component Radio ","Radio Component class : "+str+" is not available on : " + objData.AppURL );
      } 
	}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }



public boolean fnComponentPasswordText(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "password";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	
     if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("type");
	System.out.println(str);
	if(str.contains(str2)) {
		try {
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldMobile");
			//Actions a = new Actions(driver);
			//a.click(driver.findElement(By.xpath("//input[@type='"+str+"']")));
			//driver.findElement(By.xpath("//input[@type='"+str+"']")).click();
			Actions a = new Actions(driver);
			 actionLib.HighlightWebElement(linktwo.get(i), 15);
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			linktwo.get(i).clear();
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocusMobile");
			//driver.findElement(By.xpath("//input[@type='"+linktwo.get(i)+"']")).sendKeys("abcd");
			a.moveToElement(linktwo.get(i),1,1).build().perform();
			linktwo.get(i).sendKeys("abcd");
			actionLib.validateCheckStyleAllComponents(linktwo.get(i), "TextFieldFocusTypedMobile");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			continue;
		}
     }else{
 		extentLogs.info("JetPrev Component passwordtext ","passwordtext Component class : "+str2+" is not available on : " + objData.AppURL );
     }}}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }



public boolean fnComponentPrimaryButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "btnblue";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	

if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("class");
	System.out.println(str);
	if(str.contains(str2)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linktwo.get(i), "PrimaryButtonMobile");
	}
	else {
		extentLogs.info("JetPrev Component Primarybutton ","Primarybutton Component class : "+str2+" is not available on : " + objData.AppURL );
	}
	/*if(str.contains("btnStyle  SubmitFocus")) {
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "BlueButtontwo");
	}*/
	
}

}

}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }


public boolean fnComponentSecondaryButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "btnStyle  SubmitFocus";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linktwo = driver.findElements(By.tagName("input"));
System.out.println(linktwo.size());
for (int i = 0; i<linktwo.size(); i++)
	{
	

if(linktwo.get(i).isDisplayed()) {
	str = linktwo.get(i).getAttribute("class");
	System.out.println(str);
	/*if(str.contains("btnblue")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linktwo.get(i), "Bluebutton");
	}*/
	// str2= new String("btnStyle  SubmitFocus");
	if(str.contains(str2)) {
		actionLib.validateCheckStyleAllComponents(linktwo.get(i), "SecondaryButtonMobile");
	}
	
}
else {
	extentLogs.info("JetPrev Component SecondaryButton ","SecondaryButton Component class : "+str2+" is not available on : " + objData.AppURL );
}
	}}
     catch(Exception e) {
     e.printStackTrace();
     blnstatus = false;
     }
     return blnstatus;
     }


public boolean fnComponentLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("label"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("label");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("text")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "InputFieldMobile");
	}
	if(str.contains("checkbox")) {
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ButtonBlueMobile");
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentExternalLink(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "extImageIcon";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("span"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ExternalLinkMobile");
	}
	else {
		extentLogs.info("JetPrev Component ExternalLink ","ExternalLink Component class : "+str1+" is not available on : " + objData.AppURL );
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentPDFandPRINT(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 ="/iwov-resources/images/tnc/icon-pdf-new.png";
	String str2 = "/iwov-resources/images/tnc/print-icon.png";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("img"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("src");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PDFPrintMobile");
	}
	else {
		extentLogs.info("JetPrev Component PDF ","PDF Component class : "+str1+" is not available on : " + objData.AppURL );
	}
	if(str.contains(str2)){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PDFPrintMobile");
		}else {
			extentLogs.info("JetPrev Component Print ","Print Component class : "+str1+" is not available on : " + objData.AppURL );
		}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentCountryIcon(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "countryIcon";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "CountryIconMobile");
	}
	else {
		extentLogs.info("JetPrev Component CountryIcon ","CountryIcon Component class : "+str1+" is not available on : " + objData.AppURL );
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentoutsideButton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "formFooter";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OutsideButtonMobile");
	}
	else {
		extentLogs.info("JetPrev Component OutsideButton ","OutsideButton Component class : "+str1+" is not available on : " + objData.AppURL );
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




public boolean fnComponentActionButtonExternalURL(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "btnblue SubmitFocus extLinkBtn";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).click();
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Blue@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("input"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str2)){
	
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ActionButtonExternalURLMobile");
	}
	else {
		extentLogs.info("JetPrev Component ActionButtonExternalURL ","ActionButtonExternalURL Component class : "+str2+" is not available on : " + objData.AppURL );
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentwhitebtn(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "whiteBtn";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
				
		try {
			if(driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).click();
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Pass@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("input"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "WhiteBtnMobile");
	}
	else {
		extentLogs.info("JetPrev Component WhiteBtn ","WhiteBtn Component class : "+str1+" is not available on : " + objData.AppURL );
	}
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}







public boolean fnComponentoldFormLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("label"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("handHeldHide")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormLabelMobile");
	}
	if(str.contains("floating-label")){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormLabelMobile");
		}
	
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentoldFormLabelupdated(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "formLabel";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
    	 
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormLabelMobile");
	}
	else {
		extentLogs.info("JetPrev Component OldFormLabel ","OldFormLabel Component class : "+str1+" is not available on : " + objData.AppURL );
	}
	
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentNewFormLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//div[@class='formLabel']/label"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     /*if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formLabel")){*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewFormLabelMobile");
	}
	
     }
	/*}
	}
	}*/

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}









public boolean fnComponentExpandtitle(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str1 = "expandcollapsetitle accordian";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str1)){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ExpandTitleMobile");
	/*Actions a = new Actions(driver);
	a.moveToElement(linkthree.get(i)).build().perform();
	JavascriptExecutor ex = (JavascriptExecutor) driver;
	ex.executeScript("arguments[0].click();", linkthree.get(i));
	a.click(linkthree.get(i));
	Thread.sleep(2000);
	linkthree.get(i).click();
	Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(driver.findElement(By.xpath("//span[@class='openaccordian']")), "OpenTitle");
	*/
	}
	else {
		extentLogs.info("JetPrev Component ExpandTitle ","ExpandTitle Component class : "+str1+" is not available on : " + objData.AppURL );
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentTable2(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("trackerTable table")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Tabletrack2Mobile");	

	}
		
     }
	}
	}
String str1 = null;
java.util.List<WebElement> linkfour = driver.findElements(By.xpath("//table[@class='trackerTable table  ']//caption[1]"));
System.out.println(linkfour.size());
for (int i = 0; i<linkfour.size(); i++) {

			actionLib.validateCheckStyleAllComponents(linkfour.get(i), "Tablecaption2Mobile");
		}
	}


catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentCommonTable(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		try {
			if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Pass@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[3]")));
				Thread.sleep(6000);
				actionLib.OpenUrl(objData.AppURL);
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("table-bluepatch")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "CommonTableMobile");
		}     }
	}
	}
String str1 = null;
java.util.List<WebElement> linkfour = driver.findElements(By.xpath("//table[@class='trackerTable table  ']//caption[1]"));
System.out.println(linkfour.size());
for (int i = 0; i<linkfour.size(); i++) {

			actionLib.validateCheckStyleAllComponents(linkfour.get(i), "CommonTablecaptionMobile");
		}
	}


catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTable4(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("table"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("orangeBorderless")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.HighlightWebElement(linkthree.get(i), 3);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "Table4Mobile");
		}     }
	}
	}

String str1 = null;
java.util.List<WebElement> linkfour = driver.findElements(By.tagName("caption"));
System.out.println(linkfour.size());
for (int i = 0; i<linkfour.size(); i++) {
if(linkfour.get(i).isDisplayed()) {
	str1 = linkfour.get(i).getAttribute("class");
	System.out.println(str1);
	if(str!=null) {
		if(str1.contains("table caption")) {
			actionLib.validateCheckStyleAllComponents(linkfour.get(i), "Tablecaption4Mobile");
		}
	}
}
}

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}







public boolean fnComponentoldFormContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormContainerMobile");
		}
	if(str.contains("innerContainer")) {
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormInnerContainerMobile");
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}








/*public boolean fnComponentoldFormInnerContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("innerContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewInnerContainer");
	if(str.contains("formContainer")){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewFormContainer");
	}
		
     }
	}
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}*/



public boolean fnComponentNewFormContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewFormContainerMobile");
	if(str.contains("innerContainer")){
		//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewInnerContainerMobile");
	
	}
		
     }
	}
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentNewFormInnerContainer(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("innerContainer")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "NewInnerContainerMobile");
	
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentMFbutton(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).click();
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Pass@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				actionLib.OpenUrl(objData.AppURL);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("loginformbtn")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "MFButtonMobile");
	
	}
		
     }
	}
	}
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentP(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("p"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
/*	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("mainHeading")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
*/	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PMobile");
	
	}
	 
	   }
    
	     }

	

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentH1(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("h1"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("mainHeading")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "H1Mobile");
	
	}
	 }
	   }
    
	     }

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentH2(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("h2"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pageheading")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "H2Mobile");
	
	}

	
	 }
	   }
	     }

	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}







public boolean fnComponentH3(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		    actionLib.OpenUrl(objData.AppURL);
		    Thread.sleep(5000);
		
		    try {
		    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
					driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("100006395");
					Thread.sleep(4000);
					driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Pass@123");
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@id='ctl02_chkRemeberMe']")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[3]")));
					Thread.sleep(40000);
					actionLib.OpenUrl(objData.AppURL);
				
}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		   // actionLib.OpenUrl(objData.AppURL);
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("h3"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pwdPolicyHead")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "h3Mobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnbreadcrum(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
		Thread.sleep(3000);
	if(str.contains("breadcrum")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "BreadcrumMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnbreadcrumpresentation(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("role");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("presentation")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PresentationMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentSecondaryText(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("span"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("secondaryText")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SecondaryTextMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpostNotifications(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
			if(driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).click();
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Queen@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("postloginnotifications")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PostloginNotificationsMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentIconNotifications(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		

	    try {
	    	if(driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).click();
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_jetno']")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='frm__field LR' and @id='ctl03_password']")).sendKeys("Queen@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[contains(@id,'formLoginRemember')])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("//input[@class='signinButton btnblue' and @id='ctl03_loginbtn1']")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("span"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("icon icon-icon-notification")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "IconIconNotificationMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentOldformLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formTemplate")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormtemplateMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentNewformLabel(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("formTemplate")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "OldFormtemplateMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponenttabPopup(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
		Thread.sleep(3000);
	if(str.contains("tooltipmessages")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		//Thread.sleep(3000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "TooltipmessageMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentSuccessMessage(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("successBox")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SuccessMessage");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentErrorIcon(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("erroricon")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ErrorIcon");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentPinCount(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pin-cont")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PinCont");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




public boolean fnComponentPinNote(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pin-note")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "PinNote");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}






public boolean fnComponentThirdlevelTabActive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Pass@123");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[3]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='desktabs tablist']//li"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("pin-note")){*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ThirdLeveltabActiveMobile");
	
	}
	 }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentThirdLevelTabInactive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Test@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[3]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("ul"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("desktabs tablist")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ThirdLeveltabInactiveMobile");
	
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentContentLevelTab(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("100006395");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("Test@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='tabs tablist4 platinumChkBox bandp']//li"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("desklist active")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ContentLeveltabActiveMobile");
	
	}
	if(str.contains("desklist")){
		actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ContentLeveltabInActiveMobile");
	}
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentpartnerbricktypeOne(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("partnerDetailLink")){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbricktypeOneMobile");
	
	}
	
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentpartnerbrickA(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "detailsBtn";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("a"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("fr brickDetailsLink marginT2")){
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
		Actions a = new Actions(driver);
		a.moveToElement(linkthree.get(i), 1, 1).build().perform();
		a.click(linkthree.get(i)).build().perform();;
		linkthree.get(i).click();
		//linkthree.get(i).click();
		
		List<WebElement> linkfour = driver.findElements(By.xpath("//div[@class='partnerDetailsWrapper']//div//a"));
		System.out.println(linkfour.size());
	/*	String str1 = null;
		for(int j=0;j<linkfour.size();j++) {
			if(linkfour.get(j).isDisplayed()) {
			str1 = linkfour.get(i).getAttribute("class");
			if(str1!=null) {
			if(str1.contains(str2)) {*/
		
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbrickAMobile");
			}
			extentLogs.info("JetPrev Component partnerbrickA ","partnerbrickA Component class : "+str2+"is not available on : " + objData.AppURL );
	/*	}
			}
		}
	}
	*/
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpartnerbricktypeTwo(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "offerBrickContainer";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains(str2)){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbricktypeTwoMobile");
	
	}
	extentLogs.info("JetPrev Component partnerbricktypeTwo ","partnerbricktypeTwo Component class : "+str2+"is not available on : " + objData.AppURL );
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpartnerbricktypeTwoFooter(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "cardDetailCont";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbricktypeTwoFooterMobile");
	
	}
	extentLogs.info("JetPrev Component partnerbricktypeTwoFooter ","partnerbricktypeTwoFooter Component class : "+str2+"is not available on : " + objData.AppURL );
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentpartnerbrickonRHS(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 = "partnerDetailLink";
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("partnerDetailLink")){
		Thread.sleep(2000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbrickonRHSMobile");
	
	}
	extentLogs.info("JetPrev Component partnerbrickonRHS ","partnerbrickonRHS Component class : "+str2+ " is not available on : " + objData.AppURL );
	 }
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentpartnerbrickonRHSDetail(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(20000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.tagName("div"));
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		extentLogs.info("JetPrev Component partnerbrickonRHSDetail ","partnerbrickonRHSDetail Component class : "+str2+" is available on : " + objData.AppURL );
		Thread.sleep(1000);
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "partnerbrickonRHSDetailMobile");
	
	}else {
	extentLogs.info("JetPrev Component partnerbrickonRHSDetail ","partnerbrickonRHSDetail Component class : "+str2+" is not available on : " + objData.AppURL );
	} 
	}
	   }
	     }
	}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}



public boolean fnComponentSecondLevelInactive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[3]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='desktabs tablist']//li//a"));   //ul[@class='desktabs tablist']//li//a//span
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    		extentLogs.info("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SecondLevelInactiveMobile");
	
	}else {
	extentLogs.info("JetPrev Component SecondLevelInactive ","SecondLevelInactive Component class : "+str2+" is not available on : " + objData.AppURL );
	}
	 }
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}

public boolean fnComponentSecondLevelActive(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[3]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//ul[@class='desktabs tablist']//li//a//span"));   
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    	 extentLogs.info("JetPrev Component SecondLevelActive ","SecondLevelActive Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "SecondLevelActiveMobile");
	
	}else {
	extentLogs.info("JetPrev Component SecondLevelActive ","SecondLevelActive Component class : "+str2+" is not available on : " + objData.AppURL );
	} 
	}
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentTabPopupComponent(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		actionLib.OpenUrl(objData.AppURL);
		
		try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//li[@role='tooltip']"));   
System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	Actions a = new Actions(driver);
	a.moveToElement(linkthree.get(i)).build().perform();
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    	 extentLogs.info("JetPrev Component Tabpopup ","Tabpopup Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "TabpopupcomponentMobile");
	
	}else {
	extentLogs.info("JetPrev Component Tabpopup","Tabpopup Component class : "+str2+" is not available on : " + objData.AppURL );
	} 
	}
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean fnComponentToasterPopup(JetPrevInput objData) {
	Boolean blnstatus = true;
	String str = null;
	String str2 =  "cardDetailCont";
	
	try {
		//actionLib.OpenUrl(objData.AppURL);
		
		/*try {
	    	if(driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).isDisplayed()) {
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).click();
				driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[2]")).sendKeys("210135704");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@placeholder='Password'])[2]")).sendKeys("King@1234");
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				actionLib.javascriptClick(driver.findElement(By.xpath("(//input[@value='Login'])[2]")));
				Thread.sleep(5000);
				actionLib.OpenUrl(objData.AppURL);
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Thread.sleep(2000);
java.util.List<WebElement> linkthree = driver.findElements(By.xpath("//div[@class='popupcontent']"));   
//System.out.println(linkthree.size());
for (int i = 0; i<linkthree.size(); i++)
	{
	
     if(linkthree.get(i).isDisplayed()) {
	/*str = linkthree.get(i).getAttribute("class");
	System.out.println(str);
	if(str!=null) {
	if(str.contains("cardDetailCont")){
		Thread.sleep(1000);*/
	//System.out.println(new Select(linkone.get(i)).getOptions().get(i).getText());
    	 extentLogs.info("JetPrev Component ToasterPopup ","ToasterPopup Component class : "+str2+" is available on : " + objData.AppURL );
    	 Thread.sleep(2000);
	actionLib.validateCheckStyleAllComponents(linkthree.get(i), "ToasterPopupMobile");
	
	}else {
	extentLogs.info("JetPrev Component ToasterPopup ","ToasterPopup Component class : "+str2+" is not available on : " + objData.AppURL );
	} 
	}
	}
/*
	   }
	     }
	}
*/
catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}


public boolean pagination() {
	Boolean blnstatus = true;
	try {
		String str1 = "pagination paginationNavTop active";
		String str2 = "firstbk prev deactive";
		String str3 = "prevbk prev deactive";
		String str4 = "nextbk next";
		String str5 = "lastbk next";
		String str6 = "paginationPanel";
		String str7 = "page active";
		//driver.findElement(By.xpath("//div[@class='loader']")).click();
		actionLib.waitForElementPresent(By.xpath("(//div[@class='hideinmobile'])[2]"), 60);
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='hideinmobile'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='hideinmobile'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='Login ID'])[1]")).sendKeys("100010072");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Test@333");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		actionLib.javascriptClick(driver.findElement(By.xpath(" (//input[@value='Login'])[1]")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='UserMessagePanel']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='innerHeadingContainer']/span)[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Activity Details') and @id='']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='userChoice2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='jppl-sprites ui-icon-datepicker'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'1')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Select Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'4')])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='ctl03_btnView']")).click();
		
		java.util.List<WebElement> link = driver.findElements(By.tagName("div"));
		System.out.println(link.size());
		
		for (int i = 0; i < link.size(); i++) {
			
			if(link.get(i).isDisplayed()) {
			String	str = link.get(i).getAttribute("class");
				System.out.println(str);
				if(str.contains(str1)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Pagination"); 
					}
				if(str.contains(str2)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Firstbkprevdeactive");
					}
				if(str.contains(str3)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Prevbkprevdeactive");
					}
				if(str.contains(str4)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "Nextbknext");
					}
				if(str.contains(str5)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "LastbkNext");
					}
				if(str.contains(str6)) {
					actionLib.validateCheckStyleAllComponents(link.get(i), "PaginationPanel");
					}
			}
		}
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		
	for (int j = 0; j < links.size(); j++) {
			
			if(links.get(j).isDisplayed()) {
			String	str = links.get(j).getAttribute("class");
				System.out.println(str);
				if(str.contains(str2)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "Firstbkprevdeactive");
					}
				if(str.contains(str3)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "Prevbkprevdeactive");
					}
				if(str.contains(str4)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "Nextbknext");
					}
				if(str.contains(str5)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "LastbkNext");
					}
				if(str.contains(str7)) {
					actionLib.validateCheckStyleAllComponents(link.get(j), "PageActive");
					}
						}
		}
		
	}
	catch (Exception e) {
		e.printStackTrace();
		blnstatus = false;	
		
	}
	return blnstatus;
}



/***************************************
* Function Name :-fncomponentMandatoryMobile
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentMandatoryMobile(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
//driver.get("http://jppluat.jetprivilege.com/");
//driver.get("http://jppluat.jetprivilege.com/marketing/enrol");

//actionLib.JSClick(JetPrev_Smoke_Locators.enroll, "Click on enroll");
/*
if(driver.findElement(By.xpath("(//span[@class='errorText'])[2]")).isDisplayed()) {

	extentLogs.info("Mandatory component", " Mandatory icon is available");
*/
List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='errorText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");


}
/*}
else {
	extentLogs.info("Mandatory component", " Mandatory icon is not available");
	
	}*/
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}




/***************************************
* Function Name :-fncomponentMandatoryTablet
* Return Type:- boolean
* Date:-25-Jan-2018
* Author:-Nithin
* @throws Throwable 
*/
public boolean fncomponentMandatoryTablet(JetPrevInput objData) throws Throwable{
Boolean blnstatus = true;
try {


actionLib.OpenUrl(objData.AppURL);
List<WebElement> tagnames = driver.findElements(By.xpath("//span[@class='errorText']"));
System.out.println(tagnames.size());
for(int i=1;i<=tagnames.size();i++) {
actionLib.validateCheckStyle(JetPrev_Smoke_Locators.mandatoryField(i), "MandatoryField");


}
}

catch(Exception e) {
e.printStackTrace();
blnstatus = false;
}
return blnstatus;
}









private String GetElementAttribute(By countryCode) {
	// TODO Auto-generated method stub
	return null;
}



public void fnUpdateDefectDetails(Issue issue)
{
    if(issue!=null)
    {
        extentLogs.info("Shop Jet Prev Web Test Script ","Defect Details");
        extentLogs.pass("Jira Defect ID ", issue.getKey());
        extentLogs.pass("Jira Project Name ", issue.getProject().toString());
        extentLogs.pass("Jira Defect Summary ", issue.getSummary());
        extentLogs.pass("Jira Defect Description ", issue.getDescription());
        extentLogs.pass("Jira Defect Assignee ", issue.getAssignee().toString());
        extentLogs.pass("Jira Defect Priority ", issue.getPriority().toString());
        extentLogs.pass("Jira Defect Status ", issue.getStatus().toString());
    }
    if(ReportStatus.blnStatus==false)
    {
        try
        {
            int c=50/0;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }
}







//public void fnValidateBreadCrumbs(){
//	actionLib.validateCheckStyle(JetPrevPageLocators.ourProgramBreadcrumb,"ourProgramBreadcrumb");
//}
}





