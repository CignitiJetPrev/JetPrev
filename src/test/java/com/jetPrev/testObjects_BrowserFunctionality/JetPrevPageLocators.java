package com.jetPrev.testObjects_BrowserFunctionality;

import org.openqa.selenium.By;

import com.jetPrev.workflows_BrowserFunctionality.JetPrevInput;

public class JetPrevPageLocators {

	 //Home page
     public static By headerLogin = By.id("login_wrap");
     public static By txtLoginID = By.id("ctl01_jetno");
	 public static By txtPassword = By.id("ctl01_password");
	 public static By btnLogin = By.id("ctl01_loginbtnM");
	
	  //Home page
	  public static By headersLogin = By.xpath(".//*[@class='btn btn-login']");
	  public static By category = By.id("qPartCat_3");
	  public static By item = By.xpath("//p[@id='rec_prod_lnk_2']");
	    
	  //test case 16 Retail Partners
	  public static By retailPartners = By.id("offline_prt_lnk_1");
	  //the below btn should be clicked on the popup
	  public static By proceedToLyfstyle = By.id("proceedBtn_offPrt_");
	  public static By mainHeader = By.xpath(".//*[@class='mainHeading']");
	  
	  //test case 17 Header
	 /* public static By ourProgram = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[1]/a");
	  public static By earnJpmiles = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[2]/a");
	  public static By useJpmiles = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[3]/a");
	  public static By offerDeals = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[4]/a");
	  public static By bookNow = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[5]/a");*/
	  
	  
	  public static By ourProgramBreadcrumb = By.xpath("//nav/ul/li/a[text()='Our Programme']");
	  
	  //test case Mobile Emulation
	  public static By logomain = By.xpath("//*[@id='includedHeader']/div/div/div/a[1]");
      public static By mobileOurprogram = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[1]/a");
      public static By ourprogramSubheading = By.xpath("//*[@id=\"ctl00\"]/div[3]/div/nav/ul/li[1]/div[2]/ul/li[1]/a");
      public static By ourprogramHeader = By.xpath("//*[@id='content']/div[1]/h1");
      public static By logoEarn = By.xpath("//*[@id='ctl00']/div[3]/div/div[2]/a[1]");
      public static By mobileEarnJPmile = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[2]/a");
      public static By mobileearnSubheading = By.xpath("//*[@id='ctl00']/div[3]/div/nav/ul/li[2]/div[2]/ul/li[1]/a");
      public static By earnjpmilesHeader = By.xpath("//*[@id='content']/div[1]/h1");
     // public static By logoUse = By.xpath("//*[@id='ctl00']/div[3]/div/div[2]/a[1]");
	  public static By mobileUsejpmiles = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[3]/a");
	  public static By mobileusejpmileSubheading = By.xpath("//*[@id='ctl00']/div[3]/div/nav/ul/li[3]/div[2]/ul/li[1]/a");
	  public static By usejpmilesHeader = By.xpath("//*[@id='content']/div[1]/h1");
	 // public static By logoOffer = By.xpath("//*[@id='includedHeader']/div/div/div/a[1]");
	  public static By mobileOffersanddeals = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[4]/a");
	  public static By offersanddealsHeader = By.xpath("//*[@id='content']/div[1]/h1");
	  public static By offeranddealSubheader = By.xpath("//*[@id='panel_3']/div[1]/a");
	 // public static By logoBook = By.xpath("//*[@id='includedHeader']/div/div/div/a[1]");
	  public static By mobilebooknow = By.xpath("//*[@id='includedHeader']/div/div/nav/ul/li[5]/a");
	  public static By booknowSubheading = By.xpath("//*[@id='ctl00']/div[3]/div/nav/ul/li[5]/div[2]/ul/li[1]/a");
	  public static By booknowHeader = By.xpath("//*[@id='content']/div[1]/h1");
	  
	  
	  // test case web access
	//  public static By aboutUs =  
	  
	  public static By bannerHome = By.xpath("//*[@id='bxslider']/li[1]/a");
	  public static By bannerHome1 = By.xpath("//*[@id='9_bannerStaticLnk10_ buy 1 get 1 free']");
	  public static By bannerHome2 = By.xpath("//*[@id='8_BannerStaticLnk18_Republic day sale bb']");
	  
	  
	  //test case Static banner
	  public static By staticBanner = By.id("9_BannerStaticLnk14_Lenskart");
	  //the below btn should be clicked on the popup
	  public static By proceedToLenskart = By.id("continueAsGuest_Lenskart");
	  public static By popUp = By.xpath("//*[@id='bx-close-inside-587176']");
	  public static By sunGlasses = By.xpath("//*[@title='Vincent Chase Sunglasses']");
	  public static By sunGlassitem = By.xpath("//*[@id='productimgover93877']");
	  public static By buyNowsunglasses = By.id("alone_add_button");
	  public static By proccedTocheckout = By.xpath("//*[@id='cartfooter']/a");
	  public static By close = By.xpath("//*[@id='mymodal4']/div/span");//*[@id="mymodal4"]/div/span
	  public static By radioButton = By.xpath("//*[@id='login:register' and @type='radio']");
	  //public static By email = By.xpath(".//*[@id='login-email' and @class='textinput inline-block required-entry validate-email inline-block validation-failed']");
	  public static By email = By.xpath("//*[@id='login-email']");
	  //public static By password = By.xpath("//*[@id='login-email' and @class='textinput inline-block required-entry validate-email inline-block validation-failed']");
	  public static By password = By.xpath("//*[@id='login-password']");
	  public static By continuee = By.xpath("//*[@id='login-form']/ul/li[1]/div[7]/button");
	  public static By fName = By.xpath(".//*[@id='shipping:firstname' and @class='input-field validate-no-html-tags required-entry validate-name']");
	  public static By lName = By.xpath(".//*[@id='shipping:lastname' and @class='input-field validate-no-html-tags required-entry validate-name']");
	  public static By moBile = By.xpath(".//*[@id='shipping:telephone' and @class='input-field small required-entry validate-phoneInd']");
	  public static By genderMale = By.xpath(".//*[@id='gender_male' and @name='shipping[gender]']");
	  public static By postalCode = By.xpath("//*[@id='shipping:postcode' and @name='shipping[postcode]']");
	  public static By addressLine1 = By.xpath(".//*[@id='shipping:street1' and @class='input-field validate-no-html-tags required-entry validate-alphanum-with-spacess']");
	  public static By addressLine2 = By.xpath(".//*[@id='shipping:street1' and @class='input-field validate-no-html-tags validate-alphanum-with-spacess']");
	  public static By cityDistrict = By.xpath(".//*[@id='shipping:city' and @class='input-field validate-no-html-tags small required-entry validate-alphanum-with-spaces']");
	  public static By stateDistrict = By.xpath(".//*[@id='shipping:region' and @class='input-field validate-no-html-tags small required-entry']");
	  public static By continu = By.xpath(".//*[@id='ContinueButton' and @class='ContinueButton pull-right']");
	  public static By cashOndelivery = By.id("tab_link_cod");//By.xpath("//*[@id='co-payment-form']/div/div/div[3]/div[3]/a");
	  public static By placeOrder = By.xpath("//*[@id='co-payment-form']/div/div/div[3]/div[3]/a");
	  public static By otp = By.xpath("//*[@id='otp']/span/img"); 
	  
	   //test case 21 all categories
	   public static By allcategories = By.id("menuDrop");
	   public static By electronicsGaming = By.xpath("//span[contains(text(), 'Electronics and Gaming')]");
	   public static By airCoolers = By.xpath("//span[contains(text(), 'Air Coolers and Conditioners')]");
	   public static By searchbtn = By.id("search_btn");
	   public static By drpdwn = By.xpath("//*[@id='wrapper']/section/div[1]/div/a/img");
	   public static By getText = By.xpath("//*[@id='category_msg']/p");
	   // public static By itemstwo = By.xpath("//*[@id='std_cat_5']/span[1]");
	   public static By cameraccessory = By.xpath("//span[contains(text(),'Camera Accessories')]");
	   //public static By srchbtn = By.id("search_btn");
	   //public static By dropdwn = By.xpath("//*[@id='search_dropdown']/span");
	   //public static By itemsthree = By.xpath("//*[@id='std_cat_5']/span[1]");
	   public static By audioplayers = By.xpath("//span[contains(text(),'Audio Players')]");
	   //public static By serchbtn = By.id("search_btn");
	   //public static By dropdown = By.xpath("//*[@id='search_dropdown']/span");
	   //public static By itemsfour = By.xpath("//*[@id='std_cat_5']/span[1]");
	   public static By camera = By.xpath("//span[contains(text(),'Cameras')]");
	   //public static By serchbutn = By.id("search_btn");
	   public static By desktop = By.xpath("//span[contains(text(),'Desktops')]");
	   public static By gaming = By.xpath("//span[contains(text(),'Gaming')]");
	   public static By homeEntertainment = By.xpath("//span[contains(text(),'Home Entertainment')]");
	   public static By laptops = By.xpath("//span[contains(text(),'Laptops')]");
	   public static By ovens = By.xpath("//span[contains(text(),'Microwave ovens')]");
	   public static By refrigerators = By.xpath("//span[contains(text(),'Refrigerator')]");
	   public static By tvVideoAccessories = By.xpath("//span[contains(text(), 'TV and Video Accessories')]");
	   public static By teleVision = By.xpath("//span[contains(text(), 'Television')]");
	   public static By washingMachine = By.xpath("//span[contains(text(),'Washing machine')]");
	   
	   //Test case 26 
	   // public static By boksandmedia = By.id("qPartCat_3");
	   public static By boksandmedia;
	   public static By frwd = By.xpath("//*[@id='1']");
	   public static By cmpletfrwrd = By.xpath("//*[@id='10396']");
	   public static By bckwrd = By.xpath("//*[@id='0']");
	   static {
		   boksandmedia = By.id("qPartCat_3");
	   }
	   
	   //Test case 25 Sort By
	   public static By booksandMedia = By.id("qPartCat_3");
	   public static By relevance = By.xpath("//*[@id='sortFilteSearchResult']/ul/li[2]/div/ul/li[1]");
	   public static By relevancetext = By.xpath("//*[@id='default_load']");
	   public static By highTolow = By.xpath("//*[@id='sortFilteSearchResult']/ul/li[2]/div/ul/li[2]");
	   ////*[@id="default_load"]
	   public static By lowTohigh = By.xpath("//*[@id='sortFilteSearchResult']/ul/li[2]/div/ul/li[3]");
	  ////*[@id="default_load"]
	   public static By jpMileslowtohigh = By.xpath("//*[@id='sortFilteSearchResult']/ul/li[2]/div/ul/li[4]");
	   ////*[@id="default_load"]
	   public static By jpMileshightolow = By.xpath("//*[@id='sortFilteSearchResult']/ul/li[2]/div/ul/li[5]");
	    ////*[@id="default_load"]
	   //public static By srchbtn = By.id("search_btn");
	   public static By sortBybutton = By.id("default_load");
	   public static By sortByresults = By.xpath("//*[@id='sortFilteSearchResult']/ul/li[2]/div/ul");
	   public static By next = By.xpath("//a[contains(text(), '>') and @id='1']");
	   public static By forward = By.xpath("//a[contains(text(), '>>')]");
	   public static By back = By.xpath("//*[@id='pagination']/li[2]");
	   public static By backward = By.xpath("//a[contains(text(), '<<') and @id='0'] ");
	 

	   //Test case 28 price page.
	   public static By allCategories = By.id("menuDrop");
	   public static By babyCare = By.xpath("//span[contains(text(), 'Baby Care')]");
	   public static By srchbtn = By.id("search_btn");
	   public static By range1 = By.xpath("(//input[@value='5000 - 7000']/following-sibling::label)[2]");
	   public static By range2 = By.xpath("//label[@for='price_5']");
	   public static By brand1 = By.xpath("//label[@for='brand_4']");
	   public static By brand2 = By.xpath("(//input[@value='Aeromax(132)']/following-sibling::label)[2]");
	   public static By pricePartner = By.xpath("//label[@for='prtNo_1']");
	   public static By priceApply = By.id("desktop_apply_btn");
	   public static By priceText = By.xpath("//*[@id='category_msg']/p");
	   
	     
	   
	   //Test case 13
	   public static By meNu = By.xpath(".//ul[@id='menu' and @class='dropdown']");
	   public static By quicklyMenu =By.xpath("//div[@class='top_quick_menu']"); //By.xpath("//*[@id='dashboard']/div[3]");
	   public static By menuItem = By.xpath("//*[@id='desktop_product_category']/ul/li/a[contains(text(), 'Eyewear(41548)')]");
	   public static By mynthra = By.xpath(".//label[@for='prtNo_3']");
	   public static By mynthraProduct = By.xpath("//*[@data-id='28484067']");
	   public static By mynthraCart = By.xpath("//*[@id='load_sellerinfo_28484067']/li/p[2]/a/img");
	   public static By myntraContinueasguest = By.id("continueAsGuest_Myntra"); 
	   
	   //Test case 14
	   public static By dropDown = By.xpath("//*[@id=\"search_dropdown\"]");
	   public static By bookMedia = By.xpath("//a[@id='std_cat_3']/span[1]");
	   public static By recomItem = By.xpath("//img[@id='rec_cat_lnk_1']");
	   public static By hoMe = By.xpath("//a[@class='home_img']");
	   public static By subitem = By.xpath("//input[@data-id='4378406' and @data-name='Indian Art and Culture(English, Paperback, Nitin Singhania)']");
	   public static By proceedFurther = By.xpath("//*[@id='load_sellerinfo_4378406']/li/p[2]/a/img");
	   public static By continueAsGuest = By.id("continueAsGuest_Flipkart");
	   public static By buyNw = By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK RpigiU' and @data-reactid='123']");
	   public static By placeOrdr = By.xpath("//span[contains(text(), 'Place Order')]");
	   
	   
	   //Test case 15
	   public static By product = By.xpath("//input[@data-id='16684705' and @data-name='Redmi Note 4 (Dark Grey, 64 GB)(With 4 GB RAM)']");
	   public static By caRt = By.xpath("//*[@id='load_sellerinfo_16684705']/li/p[2]/a/img");
	 
	   //Test case 34 Header branding guidelines
	   public static By headerLogo = By.xpath("//a[@aria-label='jet privilege logo (launches the homepage)']");
	   public static By countryShortName = By.xpath("//span[@id='countryShortName']");
	   public static By countryIcon = By.xpath("//a[@aria-label='select country']");
	   public static By guidedTour = By.xpath("//a[@class='cursorPointer']");
	   public static By searchIcon = By.xpath("//span[@class='search_icon icon icon-icon-search mobhide']");
	   public static By enrolLink = By.xpath("//div[@id='NewEnrolTopRHS']");
	   public static By loginStyles = By.xpath("//a[@class='loginButtonheader borRadius']");
	   public static By ourProgramNew = By.xpath("//a[@id ='menuItem_0']");
	   public static By ourprogramLink = By.xpath("//a[@href='/dontstopcollecting/dream-destination?q=oplink09122016']");
	   public static By earnJpMilesNew =By.xpath("//a[@id ='menuItem_1']");
	   public static By useJPMilesNew =By.xpath("//a[@id ='menuItem_2']");
	   public static By offersDealsNew =By.xpath("//a[@id ='menuItem_3']");
	   public static By bookNowNew =By.xpath("//a[@id ='menuItem_4']");
	   public static By aboutUs = By.id("aAboutUs");
	   
 }

