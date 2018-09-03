package com.jetPrev.testObjects_OnlinePartner;

import org.openqa.selenium.By;

public class JetPrevPageLocators {

	//Home page
	public static By headerLogin = By.cssSelector("#login_wrap");
	//public static By headerLogin = By.xpath("//li[@id='login_wrap']/div/a/div");
	public static By txtLoginID = By.cssSelector("#ctl01_jetno");
	public static By txtPassword = By.cssSelector("#ctl01_password");
	public static By btnLogin = By.xpath(".//*[@id='ctl01_loginbtnM']");
	
	//	Search tab
	public static By homeImg 			= By.xpath("//div[@class='search_block']/div[1]/a/img");
	public static By allCategoriesDD 	= By.xpath("//div[@id='search_dropdown']");
	public static By searchTextBox 		= By.xpath("//input[@id='search_item']");
	public static By searchBtn			= By.xpath("//button[@id='search_btn']");
	
	//	Login and Enrol
	public static By enrolLink			= By.xpath("//a[text()='Enrol']");
	
//  JetPrevledge logo
	public static By JetPrevLogo		= By.xpath("//a[@class='logo']");
	
	// icons
	public static By ourProgrammeIcon 			= By.xpath("//a[@class='About']");
	public static By earnJPMilesIcon 			= By.xpath("//a[@class='EMiles']");
	public static By useJPMilesIcon 			= By.xpath("//a[@class='UMiles']");
	public static By offersNDelasIcon			= By.xpath("//a[@class='Offer']");
	public static By bookNowIcon				= By.xpath("//a[@class='PNetwork']");
	
	//  goQuicklyTo links
	public static By electronicsAndGamingLink 			= By.xpath("//a[@data-name='Electronics and Gaming']");	
	public static By fashionAccessoriesLink 			= By.xpath("//a[@data-name='Fashion Accessories']");
	public static By booksMediaAndMusicLink 			= By.xpath("//a[@data-name='Books Media and Music']");
	public static By homeandKitchenLink					= By.xpath("//a[@data-name='Home and Kitchen']");
	public static By mobileAccessoriesLink				= By.xpath("//a[@data-name='Mobiles and Accessories']");
	public static By kidsLink							= By.xpath("//a[@data-name='Kids ']");
	public static By babyCareLink						= By.xpath("//a[@data-name='Baby Care']");
	//
	
	//	onlinePartners	
	public static By flipkart1			= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_1']");
	public static By amazon11				= By.id("logo_prt_lnk_2");
	public static By amazon1				= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_2']");
	public static By myntra1			= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_3']");
	public static By firstcry1			= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_4']");
	public static By bigbasket1			= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_5']");
	public static By urbanLadder1		= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_6']");
	public static By woohoo1				= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_7']");
	public static By tatacliq1			= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_8']");
	public static By happilyunmarried1	= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_9']");
	public static By lenskart1			= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_10']");
	public static By nykaa1				= By.xpath("//div[@id='sectionParent']//img[@id='logo_prt_lnk_11']");
	
	public static By flipkart			= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Flipkart']//img");
	public static By amazon				= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Amazon']//img");
	public static By myntra				= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Myntra']//img");
	public static By firstcry			= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Firstcry']//img");
	public static By bigbasket			= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Bigbasket']//img");
	public static By urbanLadder		= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Urban Ladder']//img");
	public static By woohoo				= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Woohoo']//img");
	public static By tatacliq			= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Tata Cliq']//img");
	public static By happilyunmarried	= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Happily Unmarried']//img");
	public static By lenskart			= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='Lenskart']//img");
	public static By nykaa				= By.xpath("//div[@id='sectionParent']/div[@class='smallBanner padding_vertical border_bottom']//div[@class='homeThumb']/a[@data-partnername='NYKAA']//img");
	
	
	// Earn JP Miles	
	public static By earnJPMiles = By.xpath("//p[@class='prod_desc blue_txt']");
	
	
	//View All link	
	public static By viewAllLink = By.linkText(" View All ");
	
	// Arrow Mark	
	public static By arrowMark			= By.xpath("//a[@id='next_slide1']/a");
	
	// OffersAndDeals	
	public static By offers1 			= By.xpath("//img[@id='home_offer_lnk_1']");
	
	//logout	
	public static By arrow_down			= By.xpath("//a[@id='arrow_menu']");
	public static By LogoutBtn			= By.linkText("Logout");
	
	//loginBtnPostLogin
	public static By btnLoginPostLogin=By.xpath(".//*[@class='loginButtonPostLogin borRadius']");
	
	//checkbox Partner
	public static By checkBoxFlipkartPartner=By.xpath("//div[@id='desktop_partner']/ul/li/label[contains(text(),'Flipkart')]/preceding-sibling::input");
	
	//apply button
	public static By btnApply=By.xpath("//button[@id='desktop_apply_btn']");
	
	//searched product
	public static By labelFirstProduct=By.xpath("//ul[@id='load_content']/li[1]/div/div[2]/div[1]");
	public static By labelSearchResultsFound=By.xpath("//div[@id='category_msg']/p");
	
	//cart icon first product
	public static By imgCartFirstProduct=By.xpath("//div[@class='sellerList'] //ul/li/p[2]/a/img");

}
