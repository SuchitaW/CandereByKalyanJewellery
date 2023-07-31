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

public class MyAccountSectionObjects {
	
	

	private static final Logger logger= LogManager.getLogger(MyAccountSectionObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Scenario scn;
	
	//============= Locators for MyAccount section WebElements=====================================
	private By user= By.xpath("//*[@id='header_container']/div/div[3]/div[3]/div[1]");
	
	private By MyOrder= By.xpath("//*[@id='account-divnks-block']/div/div[2]/a");
		private By myorder= By.xpath("//*[@id='block-collapsible-nav']/ul/li[1]");
		private By mywishlist= By.xpath("//*[@id='block-collapsible-nav']/ul/li[2]");
		private By addressbook= By.xpath("//*[@id='block-collapsible-nav']/ul/li[3]");
		private By ekyc= By.xpath("//*[@id='block-collapsible-nav']/ul/li[4]");
	    private By accountinfo = By.xpath("//*[@id='block-collapsible-nav']/ul/li[5]");;
	    private By savecards = By.xpath("//*[@id='block-collapsible-nav']/ul/li[6]");
	
         private By changepass =  By.xpath("//*[@id='block-collapsible-nav']/ul/li[7]");
	private By mywallet =  By.xpath("//*[@id='block-collapsible-nav']/ul/li[9]");
	private By earnrewards =  By.xpath("//*[@id='block-collapsible-nav']/ul/li[10]");
	private By referandearn =  By.xpath("//*[@id='block-collapsible-nav']/ul/li[8]");
	private By logout =  By.xpath("//*[@id='block-collapsible-nav']/ul/button");

	private By promowallet =  By.xpath("//li[@class='active']");
	private By canderewallet =  By.xpath("//li[@data-id='candere_wallet__']");
	 
	 
	//============= Expected Results ==========================================================//
	        String myOrderPageTitle= "My Orders";
			String myWishlistPageTitle= "My Wish List";
			String addressbookPageTitle="Add New Address";
			String accountinfoPageTitle="Account Information";
			String mywalletPageTitle= "My Orders";
			String earnRewardsPageTitle= "Earn Rewards";
	
	//============= Constructor ===============================================================//
		public MyAccountSectionObjects(WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		

		public void ClickOnUser() {
			driver.findElement(user).click();
			logger.info("Clicked on User");
		
			
		}
		
		
		
		public void ClickOnMyOrder() {
			driver.findElement(myorder).click();
			logger.info("Clicked on My Order");
			String actPageTitle= driver.getTitle();
	    	Assert.assertEquals(myOrderPageTitle, actPageTitle);
	        logger.info("Validate title of page, title is:" + actPageTitle);
	        scn.log("Title of the page is: "+ actPageTitle);
			
			
		}

	
		public void ClickOnMyWishlist() {
			driver.findElement(mywishlist).click();
			logger.info("Clicked on My WishList");
			
			String actPageTitle= driver.getTitle();
	    	Assert.assertEquals(myWishlistPageTitle, actPageTitle);
	        logger.info("Validate title of page, title is:" + actPageTitle);
	        scn.log("Title of the page is: "+ actPageTitle);
			
		}
			
		public void ClickOnEkyc() {
			driver.findElement(ekyc).click();
			logger.info("Clicked on Ekyc");
			
			
		}
			
		public void ClickOnAccountInformation() {
			driver.findElement(accountinfo).click();
			logger.info("Clicked on Account Information");
			
			String actPageTitle= driver.getTitle();
	    	Assert.assertEquals(accountinfoPageTitle, actPageTitle);
	        logger.info("Validate title of Contact Us page, title is:" + actPageTitle);
	        scn.log("Title of the page is: "+ actPageTitle);
		}
			
		public void ClickOnAddressBook() {
			driver.findElement(addressbook).click();
			logger.info("Clicked on Address Book");
			
			String actPageTitle= driver.getTitle();
	    	Assert.assertEquals(addressbookPageTitle, actPageTitle);
	        logger.info("Validate title of page, title is:" + actPageTitle);
	        scn.log("Title of the page is: "+ actPageTitle);
		}
			
		public void ClickOnSavedCards() {
			driver.findElement(savecards).click();
			logger.info("Clicked on My Account");
		}
		public void ClickOnReferAndEarn() {
			driver.findElement(referandearn).click();
			logger.info("Clicked on Refer And Earn");
		}
		
		public void ClickOnEarnRewards() {
			driver.findElement(earnrewards).click();
			logger.info("Clicked on Earn Rewards");
			
			String actPageTitle= driver.getTitle();
	    	Assert.assertEquals(earnRewardsPageTitle, actPageTitle);
	        logger.info("Validate title of page, title is:" + actPageTitle);
	        scn.log("Title of the page is: "+ actPageTitle);
			
		}
		
		
	
		public void ClickOnChangePassword() {
			driver.findElement(changepass).click();
			logger.info("Clicked on Change Password");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,350)", "");
		
		
		}	
			
			public void ClickOnMyWallet() {
				
				WebElement wallet =driver.findElement(mywallet);
				
				
				
				JavascriptExecutor net = (JavascriptExecutor) driver;
				net.executeScript("arguments[0].click();",wallet  );
				
				logger.info("Clicked on My Wallet");
				
								
			}

		
		
		public void validateElementPresentInMyAccountSection(String text) throws Exception {
			boolean b=true;

			switch(text.toLowerCase().trim()) {

			case "My Orders":
				b = driver.findElement(myorder).isDisplayed();
				break;
			case "My Wish List":
				b = driver.findElement(mywishlist).isDisplayed();
				break;
			case "Address Book":
				b = driver.findElement(addressbook).isDisplayed();
				break;
			case "Ekyc":
				b = driver.findElement(ekyc).isDisplayed();
				break;
			case "Account Information":
				b = driver.findElement(accountinfo).isDisplayed();
				break;
			case "Saved Cards":
				b = driver.findElement(savecards).isDisplayed();
				break;
			case "Change Password	":
				b = driver.findElement(changepass).isDisplayed();
				break;
				
			case "My Wallet":
				b = driver.findElement(mywallet).isDisplayed();
				break;
			case "Earn Rewards":
				b = driver.findElement(earnrewards).isDisplayed();
				break;
			default:
				//logger.fatal("Header Link Description is  present in the case. Please add link description first.");
				//throw new Exception("Header Link Description is not present in the case. Please add link description first.");
			}

			if (b) {
				logger.info("My Account Link is displayed: " + text);
				Assert.assertEquals("My Account Link displayed",true, b);
			}else {
				logger.fatal("My Account Link displayed: " + text);
				Assert.fail("My Account Link displayed: " + text);
			}	}

		
		
		
		
		
		public void clickMyOrder()
	    {
	    	
	    	WebElement myOrder =driver.findElement(MyOrder);
	    	
	    	wait= new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.elementToBeClickable(MyOrder));
	    	myOrder.click();
	    	logger.info("Click on the myOrder Button");
	    	scn.log("Click on the myOrder Button");
	    	
	    }
		
		
		public void clickLogout()
	    {
	    	
	    	WebElement LogOut =driver.findElement(logout);
	    	
	    	wait= new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.elementToBeClickable(logout));
	    	LogOut.click();
	    	logger.info("Click on the myOrder Button");
	    	scn.log("Click on the myOrder Button");
	    	
	    }
		
		
		public void clickPromotionalWallet()
	    {
	    	
	    	WebElement Promowallet =driver.findElement(promowallet);
	    	
	    	JavascriptExecutor j = (JavascriptExecutor) driver;
	    	j.executeScript("arguments[0].click();", Promowallet);

	    	//Promowallet.click();
	    	logger.info("Click on the Promowallet Button");
	    	scn.log("Click on the Promowallet Button");
	    	
	    }
		
		
		public void clickCandereWallet()
	    {
	    	
	    	WebElement Promowallet =driver.findElement(canderewallet);
	    	
	    	wait= new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.elementToBeClickable(canderewallet));
	    	Promowallet.click();
	    	logger.info("Click on the Canderewallet Button");
	    	scn.log("Click on the Canderewallet Button");
	    	
	    }
		
		
		public void ClickOnContinousShopping() {
			
			WebElement cont =driver.findElement(By.xpath("//*[@id='wishlist-view-form']/div[1]/a"));
			JavascriptExecutor net = (JavascriptExecutor) driver;
			net.executeScript("arguments[0].click();",cont  );
			
			logger.info("Clicked on Continue Shopping");
		}		
			
		
}
