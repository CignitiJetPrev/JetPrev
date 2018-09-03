package com.jetPrev.testObjects_BrowserFunctionality;

import org.openqa.selenium.By;

import com.jetPrev.workflows_BrowserFunctionality.JetPrevInput;

public class JetPrev_Smoke_Locators {

	public static By login = By.xpath("//*[@id=\"ctl00\"]/div[3]/div/div[2]/div[3]/div/ul[2]/li[2]/div/a");
	public static By username = By.id("ctl01_PanelSearchControl_LoginHeader_jetno");
	public static By password = By.id("ctl01_PanelSearchControl_LoginHeader_password");
	public static By loginButton = By.xpath("//input[@id='ctl01_PanelSearchControl_LoginHeader_loginbtn']");
	public static By properties = By.xpath("//div[@class='icon jp-icons-header-icon-hamburger']");
	public static By gotoHome = By.id("GotoHome");
	public static By earnJpMiles = By.id("menuItem_1");
	public static By buyJpMiles = By.linkText("Buy JPMiles");
	public static By jpmilesRequired = By.xpath("//input[@id = 'ctl02_txtJPMilesPurchaseJPMiles']");
	public static By voucherCode = By.xpath("//input[@id = 'ctl02_txtVoucherNo']");
	public static By voucherCodeApply = By.xpath("//input[@id = 'btnVoucherCodeApply']");
	public static By buyMiles = By.xpath("//input[@id = 'ctl02_btnBuy']");
	public static By buymilesSuccess = By.id("ctl02_pSuccessMsg");
	
	//******************************** Citrus Payment *************************************//
	
	public static By cardNumber = By.xpath("//input[@id = 'cardNumber']");
	public static By cardExp = By.xpath("//input[@id = 'cardExp']");
	public static By cardCvv = By.xpath("//input[@id = 'cardCvv']");
	public static By cardHolder = By.xpath("//input[@id = 'cardHolder']");
	public static By payNow = By.xpath("//button[@id = 'citrusCardPayButton']");
	public static By subMit = By.xpath("//input[@type= 'submit']");
	
	//*************************************************************************************//
	
	
	public static By successMsg = By.xpath("//div[@id='ctl02_dvSuccess']");
	public static By availableJpmiles = By.xpath("//span[@id='ctl02_lblAvailableJPMiles']"); 
	public static By msgPannel = By.id("UserMessagePanel");
	public static By balanceJpmiles = By.id("ctl01_PanelSearchControl_GlobalNotification_spJPMiles");
	public static By enroll = By.id("NewEnrolTopRHS");
	public static By title = By.xpath("//select[@id='ctl02_ddlsalutation']");
	public static By firstName = By.id("ctl02_txtFname");
	public static By middleName = By.id("ctl02_txtMname");
	public static By lastName = By.id("ctl02_txtLname");
	public static By dateOfBirth = By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']");
	public static By year = By.xpath("//select[@class='ui-datepicker-year']");
	public static By month = By.xpath("//select[@class='ui-datepicker-month']");
	//public static By date = By.xpath("//a[@class='ui-state-default']");
	public static By date = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a");
	public static By countryOfResidence = By.id("ctl02_ddlCOR");
	public static By citizenship = By.id("ctl02_ddlCitizen");
	public static By countryCode = By.xpath("//select[@id='ctl02_ddlCountryCode']");
	public static By mobileNumber = By.id("ctl02_txtMobileNumber");
	public static By mobilenumberError = By.xpath("//li[@class='InValidMobileNumber']");
	public static By emailId = By.id("ctl02_txtEmailAddr");
	public static By passwordin = By.id("ctl02_txtPassword");
	public static By reEnterPassword = By.id("ctl02_txtRePassword");
	public static By captcha = By.xpath("//div[@class='recaptcha-checkbox-checkmark']");
	public static By termsCondition = By.id("ctl02_chkTermsAndCondition");
	public static By continues = By.id("btnContinue");
	public static By reset = By.id("btnResetBasicProfile");
	public static By homeradioButton = By.id("lblhad");
	public static By businessradioButton = By.id("lblbad");
	public static By business = By.xpath("//*[@id='ctl02_PnlApps']/div[2]/section/div/div[7]/ul/li[2]/a");
	public static By state = By.id("ctl02_ddlStateHome");
	public static By city = By.id("ctl02_ddlCityHome");
	public static By postalCode = By.xpath("//input[@id='ctl02_txtPostcodeHome']");
	public static By addressLine = By.id("ctl02_txtAddr1Home");
	public static By addressLine2 = By.id("ctl02_txtAddr2Home");
	public static By addressLine3 = By.id("ctl02_txtAddr3Home");
	public static By enrollHome = By.id("ctl02_btnEnroll"); 
	public static By resetHome = By.id("btnRestContactInformation");
	public static By previousHome = By.id("btnPrevious");
	public static By companyName = By.id("ctl02_txtCompanyName");
	public static By businessCategory = By.xpath("//select[@id='ctl02_ddlBusinessCategory']");
	public static By designation = By.id("ctl02_ddlDesignation");
	public static By jobTitle = By.id("ctl02_txtJobTitle");
	public static By stateBusiness = By.id("ctl02_ddlStateBusiness");
	public static By cityBusiness = By.id("ctl02_ddlCityBusiness");
	public static By postalCodebusiness = By.xpath("//input[@id='ctl02_txtPostcodeBusiness']");
	public static By addressLineBusiness = By.id("ctl02_txtAddr1Business");
	public static By addressLine2Business = By.id("ctl02_txtAddr2Business");
	public static By addressLine3Business = By.id("ctl02_txtAddr3Business");
	public static By successmsg = By.xpath("//div[@class='successicon']");
	public static By successNumber = By.xpath("//div[@class='marginB20 marginT20 lineheight20']");
	public static By mandatoryFields = By.xpath("//*[@id=\"ctl02_PnlApps\"]/div[1]/div[3]/section/div/p");
	public static By totalAmountBuyJpmiles = By.xpath("//span[@id='ctl02_lblBuyCost']");
	

	public static By logindropdown = By.id("UserMessagePanel");
	public static By jpinfo = By.xpath("//*[@id=\"ctl00\"]/div[3]/div/div[2]/div[3]/div/ul[2]/li[1]/div/div[5]/div[3]/div");
	public static By logOut = By.xpath("//a[@id='logoutButton']");
	
	public static By useJpmiles = By.id("menuItem_2");
	public static By giftbyBuy = By.xpath("//label[@for='ctl02_rdBuy']");
	//public static By giftorTransfermiles = By.xpath("//a[@href='/use-jpmiles/gift-transfer-jpmiles' and @role='role']");
	public static By giftorTransfermiles = By.xpath("//*[@id=\"ctl00\"]/div[3]/div/nav/ul/li[3]/div[1]/div[2]/div[2]/ul/li[2]/a");
	public static By transfer = By.xpath("//label[@for='ctl02_rdTransfer']");
	public static By milestobeGifted = By.xpath("//input[@id='ctl02_txtJPMilesTransferJPMiles']");
	public static By giftAmount = By.xpath("//span[@class='inlineBlock']");
	public static By giftJpmilesto = By.xpath("//input[@id='ctl02_txtJPNumberTransferJPMiles']");
	public static By accountName = By.xpath("//span[@id='ctl02_lblReceipientsName']");
	public static By personaliseMessage = By.xpath("//textarea[@id='ctl02_taPersonalizeMessage']");
	public static By buy = By.xpath("//button[@id='btnBuy']");  
	public static By resetIntransfer = By.xpath("//input[@id='btnReset']");
	public static By transferSuccess = By.id("ctl02_dvSuccess");
	public static By balancefromJpmiles = By.id("ctl01_PanelSearchControl_GlobalNotification_spJPMiles");
	public static By transferError = By.xpath("//div[@id='ctl02_errorcontainer']");
	//public static By transferError = By.xpath("//*[@id=\"ctl02_vsTransferJPMiles\"]/ul/li");
	
	//********************* Redeem flow *********************//
	
	public static By redeemforAwardflight = By.xpath("//*[@id=\"ctl00\"]/div[3]/div/nav/ul/li[3]/div[1]/div[2]/div[1]/ul[1]/li/a");
	public static By redeemNow = By.xpath("//li[@displaytooltipmsg='You need to do 1 activity to attain the BluePlus tier and become eligible for redemption.']");
	public static By redeem = By.xpath("//*[@id=\"redeem\"]");
	public static By oneWay = By.xpath("//label[@class='jppl-sprites rd-btn' and@for='rdoRedeemFlyOneWay']");
	public static By from = By.xpath("//input[@id='txtRedeemFlyOriginAirportAutoSuggest']");
	public static By tO = By.xpath("//input[@id='txtRedeemFlyDestinationAirportAutoSuggest']");
	public static By flyDate = By.xpath("//*[@id=\"panel21\"]/div[2]/div[1]/button/span[2]");
	public static By adult = By.xpath("//select[@id='ctl02_ddlRedeemOnlineAdult']");
	public static By child = By.xpath("//select[@id='ctl02_ddlRedeemOnlineChildren']");
	public static By cabin = By.xpath("//select[@id='ctl02_ddlRedeemCabin']");
	public static By submit = By.xpath("//input[@id='ctl02_btnRedeemOnline']");
	public static By radioButton = By.xpath("//input[@id=\"00\"]");
	public static By continueFly = By.xpath("//button[@id=\"continue\"] ");
	public static By infoMessage = By.xpath("//*[@id=\"miles\"]/div/div/div[2]/p"); 	
	public static By bookingsalutation = By.xpath("//select[@id='salutation1']");
	public static By bookingFirstname = By.xpath("//input[@id='fname1']");
	public static By bookingMiddlename = By.xpath("//input[@id='mname1']");
	public static By bookingLastname = By.xpath("//input[@id='lname1']");
	public static By bookingMealpreference = By.xpath("//select[@id='meal-out-leg1']");
	public static By bookingSpecialrequest = By.xpath("//select[@id='SpecialReq1']");
	public static By bookingFrequentflyerdetails = By.xpath("//input[@id='FFN1']");
	public static By bookingAirlines = By.xpath("//select[@id='Airline1']");
	public static By bookingCheckboxIndianresident = By.xpath("//input[@id='GSTClaim1']");
	public static By bookingContinuetocontactdetails = By.xpath("//button[@id='next-button1']");
	public static By bookingPrimarycontactNumber = By.xpath("//input[@id='MobileNumber']");
	public static By bookingPrimaryphoneNumber = By.xpath("//input[@id='HomePhoneNumber']");
	public static By bookingPrimarydestinationphoneNumber = By.xpath("//input[@id='DestinationPhoneNumber']");
	public static By bookingPrimarysecondaryEmail = By.xpath("//input[@id='email2']");
	public static By bookingCorpCode = By.xpath("//input[@id='corpcode']");
	public static By bookingcontinueToextras = By.xpath("//button[@id='Continue']");
	public static By bookingExcessbaggage = By.xpath("//select[@id='baggage00']");
	public static By bookingTermsandCondition = By.xpath("//input[@id='TnC']");
	public static By bookingTeramsandInsurance = By.xpath("//input[@id='TnC-insurance']");
	public static By bookingContinuetoPay = By.xpath("//button[@id='btnContinuePayment']");
	
	public static By luxury = By.xpath("//*[@id=\"panel21\"]/div[2]/span/div/button/span[1]");
	
	//*********************EMAIL------GMAIL*********************//
	public static By gmailUserID = By.xpath("//input[@id='identifierId']");
	public static By gmailUserIDnext = By.xpath("//*[@id=\"identifierNext\"]/div[2]");
	public static By gmailPassword = By.xpath("//input[@name='password']");
	public static By gmailpasswordnext = By.xpath("//*[@id=\"passwordNext\"]/content/span");
	public static By subject = By.xpath("//table[@class='F cf zt']/tbody/tr/td[6]");
	public static By account = By.xpath("//a[@class='gb_b gb_ib gb_R']/span");
	public static By signOut = By.xpath("//a[@id='gb_71']");
	//Welcome to JetPrivilege!
	
	//*****************Footer************//
	public static By aboutUs = By.id("aAboutUs");
	public static By socialImpact = By.id("aSocialImpact");
	public static By contactUs = By.id("aContactUS");
	public static By faq = By.id("aFAQ");
	public static By pressRoom = By.id("aPressroom");
	public static By carrers = By.id("aCareers");
	public static By termsConditions = By.id("aTermsLink");
	public static By disclaimerPolicies = By.id("aDisclaimer");
	public static By siteMap = By.id("aSitemap");
	public static By india = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[2]/ul/li[1]/h3/span");
	public static By indiaMetrocities = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[2]/ul/li[1]/h3");
	public static By begaluruandInfo = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[2]/ul/li[1]/div");
	public static By unitedKingdom = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[3]/ul/li[1]/h3");
	public static By unitedKingdomNumber = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[3]/ul/li[1]");
	public static By uSa = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[3]/ul/li[2]/h3");
	public static By usaNumber = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[3]/ul/li[2]");
	public static By tollFree = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[1]/div[3]/ul/li[3]");
	public static By connectWithUs = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[2]/div[1]/div[1]/span[1]");
	public static By extraIconMargin = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[2]/div[1]/div[1]/span[2]");
	public static By indicatesThatsu = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[3]/div/div/span[2]");
	public static By copyRights = By.xpath("//*[@id=\"ctl00\"]/footer/div/div[3]/div/div/div/p");
	public static By indicatesthatUIconMargin = By.xpath("//*[@id='ctl00']/footer/div/div[3]/div/div/span[1]");
	public static By featuredOffer = By.xpath("//*[@id='ctl00']/footer/div/div[1]/div[4]/div/div");
	public static By imG = By.xpath("//*[@id='featuredFooterImage']/div[1]/img");
	public static By brickImgContainer = By.xpath("//*[@id='featuredFooterImage']/div[2]");
	public static By footerBackground = By.xpath("//*[@id='ctl00']/footer");
	public static By otherCities = By.xpath("//*[@id='ctl00']/footer/div/div[1]/div[2]/ul/li[2]/h3");
	public static By otherCitiesInfo = By.xpath("//*[@id='ctl00']/footer/div/div[1]/div[2]/ul/li[2]/div");
	public static By faceBook = By.xpath("//a[@class='jppl-sprites sm-icon social1']");
	public static By twitter = By.xpath("//a[@class='jppl-sprites sm-icon social2']");
	public static By youTube = By.xpath("//a[@class='jppl-sprites sm-icon social3']");
	public static By linkedIn = By.xpath("//a[@class='jppl-sprites sm-icon social4']");
	public static By pinInterest = By.xpath("//a[@class='jppl-sprites sm-icon social5']");
	public static By instaGram = By.xpath("//a[@class='jppl-sprites sm-icon social6']");
	public static By newImage = By.xpath("//li[@class='bricknewimg']");
	public static By featuredStar = By.xpath("//li[@class='brickFeatureimg']");
	
	
	//*****************Header*****************//
	
	public static By ourprogramIcons1= By.xpath("//*[@id='menuItem_0']/span");
	public static By earnJpmilesIcon1 = By.xpath("//*[@id='menuItem_1']/span");
	public static By useJpmilesIcon1 = By.xpath("//*[@id='menuItem_2']/span");
	public static By offersAndDealsIcon1 = By.xpath("//*[@id='menuItem_3']/span");
	public static By bookNowIcon1 = By.xpath("//*[@id='menuItem_4']/span");
	public static By searchExpanded1 = By.xpath("//input[@id='SiteSearch_searchInput']");
	public static By searchIcon = By.xpath("//button[@id='search-btn']");
	public static By headerSite1 = By.xpath("//div[@class='site-header']");
	public static By headerLogo1 = By.xpath("//a[@aria-label='jet privilege logo (launches the homepage)']");
	public static By countryShortName1 = By.xpath("//span[@id='countryShortName']");
	public static By countryIcon1 = By.xpath("//a[@aria-label='select country']");
	public static By guidedTour1 = By.xpath("//a[@class='cursorPointer']");
	public static By searchIcon1 = By.xpath("//span[@class='search_icon icon icon-icon-search mobhide']");
	public static By enrolLink1 = By.xpath("//div[@id='NewEnrolTopRHS']");
	public static By loginStyles1 = By.xpath("//a[@class='loginButtonheader borRadius']");
	public static By ourProgramNew1 = By.xpath("//a[@id ='menuItem_0']");
	public static By ourprogramLink1 = By.xpath("//a[@href='/dontstopcollecting/dream-destination?q=oplink09122016']");
	public static By earnJpMilesNew1 =By.xpath("//a[@id ='menuItem_1']");
	public static By useJPMilesNew1 =By.xpath("//a[@id ='menuItem_2']");
	public static By offersDealsNew1 =By.xpath("//a[@id ='menuItem_3']");
	public static By bookNowNew1 =By.xpath("//a[@id ='menuItem_4']");
	public static By headerbackGround = By.xpath("//div[@class='container clearfix']");
	public static By etihadLogo = By.xpath("//a[@class='etihadFooterLogo']");
	public static By jetFooterLogo = By.xpath("//a[@class='jetfooterLogo']");
	
	//*******************SANITY*************//
	public static By passwordCompliance = By.xpath("//*[@id=\"content\"]/div/h1");
	public static By PasswordComplianceDetails = By.id("ctl00_dvMsg");
	
	
	public static By officeEmail = By.id("i0116");
	public static By emailNext = By.id("idSIButton9");
	public static By officePassword = By.id("i0118");
	public static By signIn = By.id("idSIButton9");
	public static By staySignIn = By.id("idSIButton9");
	public static By staySignInNo = By.id("idBtn_Back");
	public static By outLook = By.xpath("//a[@id=\"ShellMail_link\"]");
	public static By other = By.xpath("//span[@id=\"_ariaId_25\"]");
	public static By allmails = By.xpath("//*[@id=\"primaryContainer\"]/div[4]/div/div[1]/div/div[4]/div[3]/div/div[2]/div/div/div/div[5]/div[3]/div[1]/div[3]/div[1]");
	
	
	public static By newPassword = By.xpath("//input[@id='txtNewPassword']");
	public static By confirmNewPassword = By.xpath("//input[@id='txtReNewPassword']");
	public static By submitPassword = By.xpath("//input[@id='ctl00_btnResetPwd']");
	public static By passwodSuccessmsg = By.xpath("//div[@id='ctl00_dvResponse']");
	
	public static By passwordLogin = By.xpath("//input[@id='ctl02_jetno']");
	public static By passwordLoginPassword = By.xpath("//input[@id='ctl02_password']");
	public static By passwordLoginBtn = By.xpath("//input[@id='ctl02_loginbtnM']");
	
	public static By partnerAwards = By.xpath("//*[@id=\"ctl00\"]/div[3]/div/nav/ul/li[3]/div[1]/div[2]/div[1]/ul[3]/li/a");
	public static By oneWaypartnerAwards = By.xpath("//label[@for='ctl02_rdoPartnerMilesOneWay']");
	public static By returnpartnerAwards = By.xpath("//*[@id=\"divTripTypeContainer\"]/div/div/div[2]/label[1]");
	public static By fromPartnerAwards = By.xpath("//input[@id='ctl02_autoSuggestOrigin']");
	public static By toPartnerAwards = By.xpath("//input[@id='ctl02_autoSuggestDestination']");
	public static By departDateOption1 = By.xpath("//*[@id=\"ctl02_divSegmentFields\"]/div[4]/div[1]/div[2]/div/button/span[2]");
	public static By dateOption2 = By.xpath("//*[@id=\"ctl02_divSegmentFields\"]/div[4]/div[2]/div[2]/div/button/span[2]");
	public static By returnDateoption1 = By.xpath("//*[@id=\"tripReturnContainer\"]/div[1]/div[2]/div/button/span[2]");
	public static By retunDateoption2 = By.xpath("//*[@id=\"tripReturnContainer\"]/div[2]/div[2]/div/button/span[2]");
	public static By adultPartnerAwards = By.xpath("//select[@id='ctl02_ddlAdultCount']");
	public static By childPartnerAwards = By.xpath("//select[@id='ctl02_ddlChildCount']");
	public static By cabinPartnerAwards = By.xpath("//select[@id='ctl02_ddlBookingClass']");
	public static By bookinReferencePartnerawards = By.xpath("//input[@id='ctl02_txtBookingReference']");
	public static By addSegment = By.xpath("//input[@id='ctl02_btnAddSegment']");
	public static By resetPartnerAwards = By.xpath("//input[@id='ResetSegment']");
	public static By editPartnerAwards = By.xpath("//a[@id=\"EditId1\"]");
	public static By deletePartnerAwards = By.xpath("//a[@id=\"DeleteId2\"]");
	public static By continuePartnerawards = By.xpath("//input[@id=\"btnContinue\"]");
	
	public static By partneawardError = By.id("PassengerFieldCountError");
	public static By partnerAwardsNotification = By.id("NotificationMsg");
	public static By editPassengerDetailsone = By.xpath("//*[@id=\"EditPassengerId1\"]/img");
	public static By partnerTandC = By.xpath("//input[@id='Chktnc']");
	public static By partnerSubmitRequest = By.id("btnSubmitRequest");
	public static By partnerUpdatePassenger = By.id("UpdatePassenger");
	public static By partnerSuccesfullmsg = By.xpath("//*[@id=\"notifySuccess\"]/div[1]/div/div[2]");
	public static By departYeardateoption1 = By.xpath("//select[@class='ui-datepicker-year']");
	public static By departMonthdateOption1 = By.xpath("//select[@class='ui-datepicker-month']");
	public static By departDateoption1 = By.xpath("//a[@class='ui-state-default']");
	public static By addSegmentTable = By.xpath("//*[@id=\"SegmentSection\"]/div[1]/table");
	public static By addPassengerdetails = By.xpath("//*[@id=\"passengerForm\"]/h2");
	public static By partnerAwardPassengername = By.xpath("//input[@id='NameOfPassenger']");
	public static By partnerAwardDateofBirth = By.xpath("//*[@id=\"passengerTable\"]/div[2]/div/div[2]/div/button/span[2]");
	public static By partnerAwardCitizen = By.xpath("//select[@id='Citizen']");
	public static By PartnerAwardpassportNumber = By.xpath("//input[@id='PassportNo']");
	public static By partnerAwardvalidUpto = By.xpath("//*[@id=\"passengerTable\"]/div[5]/div/div[2]/div/button/span[2]");
	public static By partnerAwardDateofIssue = By.xpath("//*[@id=\"passengerTable\"]/div[6]/div/div[2]/div/button/span[2]");
	public static By partnerAwardPlaceofissue = By.xpath("//input[@id='PlaceOfIssue']");
	public static By partnerAwardAddanotherPassenger = By.xpath("//input[@id='AddPassenger']");
	public static By addPassengerdetailstable = By.xpath("//*[@id=\"PassengerListSection\"]/div[2]/table");
	public static By calndr = By.xpath("//span[@class='jppl-sprites ui-icon-datepicker']");
	
	public static By calendarnew = By.xpath("//button[@class='ui-datepicker-trigger']");
	public static By calendar (int s) {
		return By.xpath("(//span[@class='jppl-sprites ui-icon-datepicker'])["+ s +"]");
		//return By.xpath("(//button[@class='ui-datepicker-trigger'])["+s+"]");
	} 
	
	public static By calendarmobile (int s) {
		return By.xpath("(//button[@class='ui-datepicker-trigger'])["+s+"]");
		
	} 
	public static By helpTextWait = By.xpath("//span[@class='helpText']");
	
	public static By helpTextmessage = By.xpath("//span[@class='helpmessages']");
	public static By helpText (int s) {
		return By.xpath("(//span[@class='helpText'])["+s+"]");
		}
		public static By continueBluebtn(int s) {
		return By.xpath("(//input[@class='btnblue'])["+s+"]");
		}
		public static By mandatoryField(int s) {
		return By.xpath("(//span[@class='errorText'])["+s+"]");
		}
		public static By checkbox(int s) {
		return By.xpath("(//input[@type='checkbox'])["+s+"]");
		}

	
	
	
 }

