package com.jetPrev.testObjects_Validation;

import org.openqa.selenium.By;

public class JetPrevPageLocators {

	//Home page
	public static By headerLogin = By.id("login_wrap");
	public static By txtLoginID = By.id("ctl01_jetno");
	public static By txtPassword = By.id("ctl01_password");
	public static By btnLogin = By.id("ctl01_loginbtnM");
	
    //Links under "Go Quickly to"
	public static By Goquicklyto = By.xpath(".//div[@class='swiper-slide']//a");
	public static By ElectronicandGaming = By.id("qPartCat_1");
	public static By FashionAccessories = By.id("qPartCat_2");
	public static By BooksMediaandMusic = By.id("qPartCat_3");
	public static By HomeandKitchen = By.id("qPartCat_4");
	public static By MobilesandAccessories = By.id("qPartCat_5");
	public static By Kids = By.id("qPartCat_6"); 
	public static By BabyCare = By.id("qPartCat_7");
	
	//Hovering the mouse pointer over the Categories 
    public static By AllCategoriesdropdown = By.id("search_dropdown");
    public static By Categories = By.xpath("//*[@id=\'menu\']"); 
    public static By Categorieswitharrow = By.xpath("//ul[@id='menu']/li/a//span[@class='arrow-img']/img");
	public static By BooksMedia = By.id("std_cat_3");
	public static By ElectronicsandGaming = By.id("std_cat_5");
	public static By FashionAccess= By.id("std_cat_6");
	public static By HealthFitness= By.id("std_cat_7");
	public static By HomeKitchen= By.id("std_cat_8");
	public static By HomeOfficeDecor= By.id("std_cat_9");
	public static By Kid= By.id("std_cat_10");
	public static By MensFashion= By.id("std_cat_11");
	public static By MobilesAccessories= By.id("std_cat_12");
	public static By MotorsAccessories= By.id("std_cat_13");
	public static By WomensFashion= By.id("std_cat_1");
	
	//Functionality of Home icon
	public static By AllCategoriesdrop = By.xpath("//*[@id=\'menu\']/.");
	public static By BabyCar=By.xpath("//*[@id='std_cat_2']/span[1][contains(text(),'Baby Care')]");
	public static By Searchbtn = By.xpath("//*[@id='search_btn']");
    public static By Homeiconbtn=By.xpath(".//*[@class='home_img']/img");
	public static By BabyCareResult = By.xpath(".//*[@id='category_msg']/p");
	public static By HomePagevalidationtext =By.xpath(".//*[text()='Go quickly to']");
	
	//Functionality of Browser Back Button 
	public static By fltprice = By.xpath("//*[@id='desktop_price']/label");
	public static By fltbrand = By.xpath("//*[@id='desktop_brand']/label");
	public static By applybtn = By.id("desktop_apply_btn");
	public static By applypage = By.id(".//p[@class='blue_txt']");
	public static By sports=By.xpath("//*[@id='std_cat_15']/span[@class=\'item-name\']");
	public static By Sportsscreen =By.xpath("//*[@class='blue_txt']");
	public static By ResultsText=By.xpath("//div[@id='category_msg']/p");
	
	//Functionality of Close Button 
	public static By Babyproduct = By.xpath("//li[@class='rp']//p[@id='rec_prod_lnk_1']"); 
	public static By Closebtn=By.xpath("//p[@id='rec_prod_lnk_1']/..//input[@value='Close']");
	
	//total results found
    public static By Product=By.xpath("//li[@class='rp']//p[@id='rec_prod_lnk_1']");
    public static By totalresultdisplayed = By.xpath("//p[text()='Found 63183 Results in Baby Care Categories']");
	
	//Baby Care Product
	public static By Firstcryp=By.xpath("(//label[contains(text(),'Firstcry')])[2]");
	public static By Bproduct=By.xpath("//div[@class='light_black smallText wb']");
	public static By BProductDetails =By.xpath("//*[@class='items']");
	public static By Pdetails=By.xpath("//*[@class='items']/p[@class='light_black productName']");
	public static By Seller=By.xpath("(//input[@name='submitButton' and @id='sellerInfo_'])[1]");
	public static By Cart = By.xpath("//*[@id='load_sellerinfo_16655172']/li[2]/p[1]/img/../following-sibling::p/a");
	public static By CnFirstcryGst = By.xpath("//a[@class='blue_txt_ continueAsGuest']");
	public static By AddCart = By.xpath("//div[@class='p_buy p_lft cp']");
	public static By Placeorder = By.xpath("//*[@id='Cart_PlaceOrder']/div[@class='ct_btn lft']");
	public static By firstcrymail = By.xpath("//*[@id='BillEmailAddress']");
	public static By ContinueasGuestLink = By.xpath("//*[@id='continueAsGuest_Firstcry']");
	public static By labelFirstProduct=By.xpath("//ul[@id='load_content']/li[1]/div/div[2]/div[1]");
	public static By labelSecondProduct=By.xpath("//ul[@id='load_content']/li[2]/div/div[2]/div[1]");
	
	//JetPrivelege HomePage Locators
	public static By shopbtn = By.xpath("//*[@class='txtItem txtItemshop']");
    public static By allcateg = By.xpath("//*[@id='ddlShopCategory']");
    public static By CategoryListtext=By.xpath("//*[@id='ddlShopCategory']/option");
    public static By womencate = By.xpath("//*[@id='ddlShopCategory']//option [@value='1']");
    public static By searchtxtbx = By.xpath("//*[@id='txtShopWhatLookForToDay']");
    public static By searchbtn = By.xpath("//*[@id='btnShopSearch']");
    
  //logout	
  	public static By arrow_down			= By.xpath("//a[@id='arrow_menu']");
  	public static By LogoutBtn			= By.linkText("Logout");
  	
  	//loginBtnPostLogin
  	public static By btnLoginPostLogin=By.xpath(".//*[@class='loginButtonPostLogin borRadius']");
  	
  //continue as guest link
	
  	public static By continueAsGuestLink = By.xpath("//a[@class='blue_txt_ continueAsGuest']");
  	
	//cart icon first product
	public static By imgCartFirstProduct=By.xpath("//div[@class='sellerList']//ul/li/p[2]/a/img");
	public static By imgCartSecondimg=By.xpath("//div[@class='sellerList']//ul/li[2]/p[2]/a/img");
    
	

	

}
