package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class FooterSectionObjects {
	
	

	private static final Logger logger= LogManager.getLogger(FooterSectionObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Scenario scn;
	
//============= Locators for Footer section WebElements=====================================//

	private By twitterLink= By.xpath("//img[@alt='twitter_color_1']");
	private By twitterAcLink= By.xpath("//link[@href='https://twitter.com/i/flow/login']");
	private By facebookLink= By.xpath("//img[@alt='facebook_color_1']");
	private By facebookAcLink= By.xpath("//link[@href='https://www.facebook.com/canderejewellery']");
    private By DGRPLink= By.xpath("//a[@class='second'][normalize-space()='DGRP']");
	private By StartShopping= By.xpath("//div[@class='row_group mt_50_']//a[@class='dgrp_cta']");
	private By AboutOurCompany= By.xpath("//a[normalize-space()='About Our Company']");
	private By TermsandConditions= By.xpath("//a[normalize-space()='Terms and Conditions']");
	private By PrivacyPolicy = By.xpath("//a[@class='second'][normalize-space()='Privacy Policy']");
	private By FAQ = By.xpath("//a[normalize-space()='FAQ']");
	private By OffersTandCs= By.xpath("//a[normalize-space()='Offers T&Cs']");
	private By CustomerReviews = By.xpath("//a[normalize-space()='Customer Reviews']");
	private By DayReturns= By.xpath("//a[normalize-space()='15-Day Returns']");
	private By CancelandRefund= By.xpath("//a[normalize-space()='Cancel & Refund']");
	
	private By LifetimeExchange= By.xpath("//a[normalize-space()='Lifetime Exchange']");
	private By CertifiedJewellery= By.xpath("//a[normalize-space()='Certified Jewellery']");
	private By CandereWallet= By.xpath("//a[normalize-space()='Candere Wallet']");
	private By JewelleryInsurance= By.xpath("//a[normalize-space()='Jewellery Insurance']");
	private By ReferAndEarn= By.xpath("//a[normalize-space()='Refer And Earn']");
	private By DigiGold= By.xpath("//a[normalize-space()='DigiGold']");
	private By Lookbook= By.xpath("//a[normalize-space()='Lookbook']");
	private By StyleryBlog = By.xpath("//a[normalize-space()='Stylery Blog']");
	private By VideoGallery= By.xpath("//a[normalize-space()='Video Gallery']");
	private By OrderTracking= By.xpath("//a[contains(text(),'Order Tracking')]");
	private By VirtualTryOn= By.xpath("//a[contains(text(),'Virtual Try On')]");
	private By DiamondEducation= By.xpath("//a[normalize-space()='Diamond Education']");
	private By GemstoneEducation= By.xpath("//a[normalize-space()='Gemstone Education']");
	private By MetalEducation = By.xpath("//a[normalize-space()='Metal Education']");
	private By SizeGuide= By.xpath("//a[normalize-space()='Size Guide']");
	private By GoldRateGuide= By.xpath("//a[normalize-space()='Gold Rate Guide']");
	private By JewelleryCare= By.xpath("//a[normalize-space()='Jewellery Care']");
	private By FindExperienceCentre= By.xpath("//a[contains(text(),'Find Experience Centre')]");
	private By KalyanStoreLocator= By.xpath("//a[normalize-space()='Kalyan Store Locator']");
	private By KalyanJewellersWebsite= By.xpath("//a[normalize-space()='Kalyan Jewellers Website']");
	private By KalyanStores= By.xpath("//a[normalize-space()='Kalyan Stores']");
//	private By = By.xpath("");
//	private By = By.xpath("");
//============= Expected Results ==========================================================//

	String twitterPageTitle= "Log in to Twitter / X";
	String facebookPageTitle= "Candere by Kalyan Jewellers | Facebook";
	
	


//============= Constructor ===============================================================//
	public FooterSectionObjects(WebDriver driver,Scenario scn)
	{
		this.driver= driver;
		this.scn=scn;
	}
	
//============ 1. Method to set twitter link =================================================//
    public void setTwitterLink()
    {
    	WebElement twitterElement =driver.findElement(twitterLink);
    	
    	//Scroll till twitter link element available on screen using Javascript executor
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", twitterElement);
		Assert.assertEquals(true, twitterElement.isDisplayed());
    	logger.info("Validate the twitter link");
    }
    
//============ 2. Method to click the twitter link ===========================================//
    public void clickOnTwitterLink()
    {
    	WebElement twitterElement =driver.findElement(twitterLink);
    	twitterElement.click();
    	logger.info("Click the twitter link");
    	scn.log("Click the twitter link");
    }
    
//============ 3. Method to validate twitter account page ===================================//
    public void twitterAcPage()
    {

    	wait= new WebDriverWait(driver, 20);
    	boolean p =wait.until(ExpectedConditions.titleIs(twitterPageTitle));
    	Assert.assertEquals(true, p);
    	logger.info("Validate twitter account page with its title, title is: "+ twitterPageTitle);
    	scn.log("navigate to twitter account page, page title is: "+ twitterPageTitle);
    	
  
    }

    
    public void twitterAclinkValidation(String AcName)
    {
    	WebElement twitterAcLinkElement =driver.findElement(twitterAcLink);
    	
    	Assert.assertEquals(AcName, twitterAcLinkElement.getAttribute("href"));
    	logger.info("Validate twitter url is: "+twitterAcLinkElement.getAttribute("href"));
  scn.log("Validate twitter url  is: "+twitterAcLinkElement.getAttribute("href"));
    }

    
//=======================================================================================================================//
    

    
  //============ 1. Method to set facebook link =================================================//
    public void setFacebookLink()
    {
    	WebElement facebookElement =driver.findElement(facebookLink);
    	
    	//Scroll till twitter link element available on screen using Javascript executor
		js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", facebookElement);
		Assert.assertEquals(true, facebookElement.isDisplayed());
    	logger.info("Validate the facebook link");
    }
    
//============ 2. Method to click the facebook link ===========================================//
    public void clickOnFacebookLink()
    {
    	WebElement facebookElement =driver.findElement(facebookLink);
    	facebookElement.click();
    	logger.info("Click the facebook link");
    	scn.log("Click the facebook link");
    }
    
//============ 3. Method to validate facebook account page ===================================//
    public void facebookAcPage()
    {

    	wait= new WebDriverWait(driver, 20);
    	boolean p =wait.until(ExpectedConditions.titleIs(facebookPageTitle));
    	Assert.assertEquals(true, p);
    	logger.info("Validate facebook account page with its title, title is: "+ facebookPageTitle);
    	scn.log("navigate to facebook account page, page title is: "+ facebookPageTitle);
    }


    public void facebookAclinkValidation(String AcName)
    {
    	WebElement facebookAcLinkElement =driver.findElement(facebookAcLink);
    	
    	Assert.assertEquals(AcName, facebookAcLinkElement.getAttribute("href"));
    	logger.info("Validate facebook url is: "+facebookAcLinkElement.getAttribute("href"));
  scn.log("Validate facebook url  is: "+facebookAcLinkElement.getAttribute("href"));
    }
//=======================================================================================================================//
    
    public void validateElementPresentInFooterSection(String text1) throws Exception {
		boolean b=true;

		switch(text1.toLowerCase().trim()) {

		case "About Our Company":
			b = driver.findElement(AboutOurCompany).isDisplayed();
			break;
		case "Terms and Conditions":
			b = driver.findElement(TermsandConditions).isDisplayed();
			break;
		case "Privacy Policy":
			b = driver.findElement(PrivacyPolicy).isDisplayed();
			break;
		case "FAQ":
			b = driver.findElement(FAQ).isDisplayed();
			break;
		case "Offers T&Cs":
			b = driver.findElement(OffersTandCs).isDisplayed();
			break;
		case "Customer Reviews":
			b = driver.findElement(CustomerReviews).isDisplayed();
			break;
		
	case "15-Day Returns ":
			b = driver.findElement(DayReturns).isDisplayed();
			break;
	case "Cancel and Refund":
		b = driver.findElement(CancelandRefund).isDisplayed();
		break;	
		case "Life time Exchange":
			b = driver.findElement(LifetimeExchange).isDisplayed();
			break;
		case "DGRP":
			b = driver.findElement(DGRPLink).isDisplayed();
			break;
			
		case "Certified Jewellery":
			b = driver.findElement(CertifiedJewellery).isDisplayed();
			break;
			
		case "Jewellery Insurance":
			b = driver.findElement(JewelleryInsurance).isDisplayed();
			break;
			
		case "Refer And Earn":
			b = driver.findElement(ReferAndEarn).isDisplayed();
			break;
		case "DigiGold":
			b = driver.findElement(DigiGold).isDisplayed();
			break;	
			
		case "Lookbook":
			b = driver.findElement(Lookbook).isDisplayed();
			break;	
		case "Stylery Blog":
			b = driver.findElement(StyleryBlog).isDisplayed();
			break;	
		case "Video Gallery":
			b = driver.findElement(VideoGallery).isDisplayed();
			break;	
			
		case "Order Tracking":
			b = driver.findElement(OrderTracking).isDisplayed();
			break;
		case "Virtual Try On":
			b = driver.findElement(VirtualTryOn).isDisplayed();
			break;
		case "Diamond Education":
			b = driver.findElement(DiamondEducation).isDisplayed();
			break;
		case "Gemstone Education":
			b = driver.findElement(GemstoneEducation).isDisplayed();
			break;
		case "Metal Education":
			b = driver.findElement(MetalEducation).isDisplayed();
			break;
			
		case "Size Guide":
			b = driver.findElement(SizeGuide).isDisplayed();
			break;
		case "Gold Rate Guide":
			b = driver.findElement(GoldRateGuide).isDisplayed();
			break;
		case "Jewellery Care":
			b = driver.findElement(JewelleryCare).isDisplayed();
			break;
		case "Find Experience Centre":
			b = driver.findElement(FindExperienceCentre).isDisplayed();
			break;
		case "Kalyan Store Locator":
			b = driver.findElement(KalyanStoreLocator).isDisplayed();
			break;
		case "Kalyan Jewellers Website":
			b = driver.findElement(KalyanJewellersWebsite).isDisplayed();
			break;
		case "Kalyan Stores":
			b = driver.findElement(KalyanStores).isDisplayed();
			break;
			
		default:
			//logger.fatal("Footer Link Description is  present in the case. Please add link description first.");
			//throw new Exception("Footer Link Description is not present in the case. Please add link description first.");
		}

		if (b) {
			logger.info("Footer Link is displayed: " + text1);
			Assert.assertEquals("Footer Link displayed",true, b);
		}else {
			logger.fatal("Footer Link is not displayed: " + text1);
			Assert.fail("Footer Link is not displayed: " + text1);
		}	}

   
    public void clickOnDGRP()
    {
    	WebElement dgrpElement =driver.findElement(DGRPLink);
    	dgrpElement.click();
    	logger.info("Click the DGRP link");
    	scn.log("Click the DGRP link");
    } 
    
    
    public void clickOnStartShopping()
    {
    	
    	JavascriptExecutor sc=(JavascriptExecutor)driver;
    	sc.executeScript("window.scrollBy(0,250)", "");
    	WebElement startshoppingElement =driver.findElement(StartShopping);
    	startshoppingElement.click();
    	logger.info("Click on start shopping link");
    	scn.log("Click on start shopping link");
    } 
    
    public void scrollDowntoDGRP()
    {
    	
    	WebElement AboutUsElement = driver.findElement(By.xpath("//p[normalize-space()='ABOUT US']"));
        JavascriptExecutor js=((JavascriptExecutor) driver);


   	js.executeScript("arguments[0].scrollIntoView(true);", AboutUsElement);

   	logger.info("Scroll down to bottom of page");
	scn.log("Scroll down to bottom of page");
    } 
    
    
    
    public void ClickOnAboutOurCompany() {
		driver.findElement(AboutOurCompany).click();
		//logger.info("Clicked on About Our Company");
		
		//String actPageTitle= driver.getTitle();
//    	Assert.assertEquals(orderTrackingPageTitle, actPageTitle);
//        logger.info("Validate title of page, title is:" + actPageTitle);
//        scn.log("Title of the page is: "+ actPageTitle);
		
	}
		

    public void clickOnTermsandConditions()
    {
    	driver.findElement(TermsandConditions).click();
    	logger.info("Click on Terms and Conditions link");
    	scn.log("Click on Terms and Conditions link");
    }

    public void clickOnPrivacyPolicy()
    {
    	driver.findElement(PrivacyPolicy).click();
    	logger.info("Click on Privacy Policy link");
    	scn.log("Click on Privacy Policy link");
    }

    public void clickOnFAQ()
    {
    	driver.findElement(FAQ).click();
    	logger.info("Click on FAQ link");
    	scn.log("Click on FAQ link");
    }
    
    public void clickOnOffersTandCs()
    {
    	driver.findElement(OffersTandCs).click();
    	logger.info("Click on Offers TandCs link");
    	scn.log("Click on Offers TandCs link");
    } 
    
    public void clickOnCustomerReviews()
    {
    	driver.findElement(CustomerReviews).click();
    	logger.info("Click on CustomerReviews link");
    	scn.log("Click on CustomerReviews link");
    } 
    
    
    public void clickOnDayReturns()
    {
    	driver.findElement(DayReturns).click();
    	logger.info("Click on Day Returns link");
    	scn.log("Click on Day Returns link");
    } 
    
    public void clickOnCancelandRefund()
    {
    	driver.findElement(CancelandRefund).click();
    	logger.info("Click on Cancel and Refund link");
    	scn.log("Click on Cancel and Refund link");
    } 
    
    public void clickOnLifetimeExchange()
    {
    	driver.findElement(LifetimeExchange).click();
    	logger.info("Click on Lifetime Exchange link");
    	scn.log("Click on Lifetime Exchange link");
    } 
    
    public void clickOnCertifiedJewellery()
    {
    	driver.findElement(CertifiedJewellery).click();
    	logger.info("Click on Certified Jewellerys link");
    	scn.log("Click on Certified Jewellery link");
    } 
    
    public void clickOnJewelleryInsurance()
    {
    	driver.findElement(JewelleryInsurance).click();
    	logger.info("Click on Jewellery Insurance link");
    	scn.log("Click on Jewellery Insurance link");
    } 
    public void clickOnDigiGold()
    {
    	driver.findElement(DigiGold).click();
    	logger.info("Click on DigiGold link");
    	scn.log("Click on DigiGold link");
    } 
    public void clickOnLookbook()
    {
    	driver.findElement(Lookbook).click();
    	logger.info("Click on Lookbook link");
    	scn.log("Click on Lookbook link");
    } 
    public void clickOnStyleryBlog()
    {
    	driver.findElement(StyleryBlog).click();
    	logger.info("Click on StyleryBlog link");
    	scn.log("Click on StyleryBlog link");
    } 

    public void clickOnVideoGallery()
    {
    	driver.findElement(VideoGallery).click();
    	logger.info("Click on Video Gallery link");
    	scn.log("Click on Video Gallery link");
    } 
    public void clickOnOrderTracking()
    {
    	driver.findElement(OrderTracking).click();
    	logger.info("Click on Order Tracking link");
    	scn.log("Click on Order Tracking link");
    } 
    public void clickOnVirtualTryOn()
    {
    	driver.findElement(VirtualTryOn).click();
    	logger.info("Click on Virtual Try On link");
    	scn.log("Click on Virtual Try On link");
    } 

    public void clickOnCandereWallet()
    {
    	driver.findElement(CandereWallet).click();
    	logger.info("Click on Candere Wallet link");
    	scn.log("Click on Candere Wallet link");
    } 

    public void clickOnReferAndEarn()
    {
    	driver.findElement(ReferAndEarn).click();
    	logger.info("Click on Refer And Earn link");
    	scn.log("Click on Refer And Earn link");
    } 

    
    public void clickOnDiamondEducation()
    {
    	driver.findElement(DiamondEducation).click();
    	logger.info("Click on Diamond Education link");
    	scn.log("Click on Diamond Education link");
    } 
    public void clickOnGemstoneEducation()
    {
    	driver.findElement(GemstoneEducation).click();
    	logger.info("Click on Gemstone Education link");
    	scn.log("Click on Gemstone Education link");
    }  
    
    public void clickOnMetalEducation()
    {
    	driver.findElement(GemstoneEducation).click();
    	logger.info("Click on Metal Education link");
    	scn.log("Click on Metal Education link");
    }  
    
    public void clickOnSizeGuide()
    {
    	driver.findElement(SizeGuide).click();
    	logger.info("Click on Size Guide link");
    	scn.log("Click on Size Guide link");
    }  
    
    public void clickOnGoldRateGuide()
    {
    	driver.findElement(GoldRateGuide).click();
    	logger.info("Click on Gold Rate Guide link");
    	scn.log("Click on Gold Rate Guide link");
    }  
    public void clickOnJewelleryCare()
    {
    	driver.findElement(JewelleryCare).click();
    	logger.info("Click on Jewellery Care link");
    	scn.log("Click on Jewellery Care link");
    }  
    public void clickOnFindExperienceCentre()
    {
    	driver.findElement(FindExperienceCentre).click();
    	logger.info("Click on Find Experience Centre link");
    	scn.log("Click on Find Experience Centre link");
    }  
    
    public void clickOnKalyanStoreLocator()
    {
    	driver.findElement(KalyanStoreLocator).click();
    	logger.info("Click on Kalyan Store Locator link");
    	scn.log("Click on Kalyan Store Locator link");
    }  
    public void clickOnKalyanJewellersWebsite()
    {
    	driver.findElement(KalyanJewellersWebsite).click();
    	logger.info("Click on Kalyan Jewellers Website link");
    	scn.log("Click on Kalyan Jewellers Website link");
    }  
    public void clickOnKalyanStores()
    {
    	driver.findElement(KalyanStores).click();
    	logger.info("Click on Kalyan Stores link");
    	scn.log("Click on Kalyan Stores link");
    }  
    
    
}
        


 
    
    
    
    
    
    

        





