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

//============= Expected Results ==========================================================//

	String twitterPageTitle= "Log in to Twitter / Twitter";
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
    

}
        


 
    
    
    
    
    
    

        





