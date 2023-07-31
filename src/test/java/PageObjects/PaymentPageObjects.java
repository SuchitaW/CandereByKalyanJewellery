package PageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class PaymentPageObjects {

	
	


	private static final Logger logger= LogManager.getLogger(PaymentPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	//============= Locators for WebElements for SignIn activity =========================================//

		//private By yourAccount= By.xpath("//div[@class='link_items actions-custom customer-links']");
		

	//============= Constructor ========================================================================//
		public PaymentPageObjects(WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		
	//=================== 1. Method to validate Mouse over=================================================//
		  
	
		
		public void clickOnDGRP()
		    {
			  WebElement dgrp =driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[3]"));
			  
			  JavascriptExecutor dg = (JavascriptExecutor) driver;
		    	dg.executeScript("arguments[0].click();", dgrp );
		    	
		    	//WebDriverWait wait = new WebDriverWait(driver, 50);
		    	scn.log("DGRP Payment Option is displayed");
		    	logger.info("DGRP Payment Option is displayed");
		    }
	
	
	
		public void clickOnNetbanking()
	    {
		  WebElement netbanking =driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[2]"));
	    	
	    	JavascriptExecutor net = (JavascriptExecutor) driver;
	    	net.executeScript("arguments[0].click();", netbanking );
	    	scn.log("Net Banking Payment Option is displayed");
	    	logger.info("Net Banking Payment Option is displayed");
	    }


		public void SelectBankDropDown()
	    {
			WebElement bankdropdown=driver.findElement(By.xpath("//select[@id='juspay_netbanking_payment_method']"));
			Select bank=new Select(bankdropdown);
			bank.selectByValue("NB_BOM");
	    	scn.log("Select the bank");
	    	logger.info("Select the bank");
	    }
		
		
		
		
		
	
		public void clickOnCreditDebitCard()
	    {
		  WebElement creditdebitCard=driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[1]"));
	    	
	    	JavascriptExecutor credit = (JavascriptExecutor) driver;
	    	credit.executeScript("arguments[0].click();", creditdebitCard );
	    	scn.log("Credit / Debit Card Payment Option is displayed");
	    	logger.info("Credit / Debit Card Payment Option is displayed");
	    }

		public void clickOnUPI()
	    {
		  WebElement upi=driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[4]"));
	    	
	    	JavascriptExecutor u = (JavascriptExecutor) driver;
	    	u.executeScript("arguments[0].click();", upi );
	    	scn.log("Credit / Debit Card Payment Option is displayed");
	    	logger.info("Credit / Debit Card Payment Option is displayed");
	    }

		public void clickOnCODPartial()
	    {
		  WebElement cod=driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[6]"));
	    	
	    	JavascriptExecutor c = (JavascriptExecutor) driver;
	    	c.executeScript("arguments[0].click();", cod );
	    	scn.log("COD - Partial Payment Option is displayed");
	    	logger.info("COD - Partial Payment Option is displayed");
	    }

		public void clickOnOthers()
	    {
		  WebElement others=driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[1]/div[5]"));
	    	
	    	JavascriptExecutor c = (JavascriptExecutor) driver;
	    	c.executeScript("arguments[0].click();", others );
	    	scn.log("Others Payment Option is displayed");
	    	logger.info("Others Payment Option is displayed");
	    }
		
		
	
		public void clickOnPlaceorder()
	    {
			WebElement Placeorder = driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[2]/div[3]/div/div[2]/div[9]/div/button"));
			//Placeorder.click()
	    	JavascriptExecutor P = (JavascriptExecutor) driver;
	    	P.executeScript("arguments[0].click();", Placeorder );
	    	//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    	scn.log("Clicked on placeorder");
	    	logger.info("Clicked on placeorder");
	    }
	
		
		public void SelectNoOfInstallment()
	    {
			WebElement installmentdrop = driver.findElement(By.xpath("//*[@id='payment_section_payment_page']/div[2]/div/div/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/div[1]/select"));
			Select select1=new Select(installmentdrop);
			select1.selectByValue("2");
			WebDriverWait wait = new WebDriverWait(driver, 50);
	    	scn.log("Select the No. of installments");
	    	logger.info("Select the No. of installments");
	    }
		
		public void clickOnContinue()
	    {
//			
			
			
			WebElement continue12 =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='action primary']")));


			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", continue12);
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 80);
	    	scn.log("Clicked on Continue Button");
	    	logger.info("Clicked on Continue Button");
	    }
	
		
		public void Scrollup()
	    {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,-650)", "");
	    	scn.log("Scroll Up");
	    	logger.info("Scroll Up");
	    }
		
		public void Scrolldown()
	    {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,450)", "");
	    	scn.log("Scroll Up");
	    	logger.info("Scroll Up");
	    }

		public void EnterCreditCartDetails(String CardNumber, String NameOnCard, String CVV , String ExpiryYear,String ExpiryMonth)
	    {
		
			WebElement cartname =driver.findElement(By.xpath("//*[@id='credit-card-section']/li[1]/div/div/div/iframe"));
			cartname.sendKeys(CardNumber);
			
			WebElement holdername =driver.findElement(By.xpath("//*[@id='credit-card-section']/li[2]/div/div/div/iframe"));
			holdername.sendKeys(NameOnCard);
			
			WebElement cvv =driver.findElement(By.xpath("//*[@id='credit-card-section']/li[3]/div/div[3]/div/div/div/iframe"));
			cvv .sendKeys(CVV );
			
			WebElement expiryyr =driver.findElement(By.xpath("//*[@id='credit-card-section']/li[3]/div/div[2]/div/div/div/iframe"));
			expiryyr.sendKeys(ExpiryYear );
			
			WebElement expirymonth =driver.findElement(By.xpath("//*[@id='credit-card-section']/li[3]/div/div[1]/div/div/div/iframe"));
			expirymonth .sendKeys(ExpiryMonth );
}
		
		
		
		
		public void clickViewDetails()
	    {
		  WebElement viewdetails=driver.findElement(By.xpath("//*[@id='viewwallet_display']/div/div/div"));
	    	
	    	JavascriptExecutor c = (JavascriptExecutor) driver;
	    	c.executeScript("arguments[0].click();", viewdetails );
	    	scn.log("Click on view details");
	    	logger.info("Click on view details");
	    }
		
		
		
		
}