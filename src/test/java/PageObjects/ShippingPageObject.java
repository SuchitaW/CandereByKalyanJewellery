package PageObjects;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class ShippingPageObject {
	
	


	private static final Logger logger= LogManager.getLogger(PaymentPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	//============= Locators for WebElements =========================================//

		//private By yourAccount= By.xpath("//div[@class='link_items actions-custom customer-links']");
		

	//============= Constructor ========================================================================//
		public ShippingPageObject(WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		
	//=================== 1. Method to validate Mouse over=================================================//
		  
	
		
		public void clickOnShipToSameAddress()
		    {
			JavascriptExecutor	js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1200)", "");
			WebElement newaddress = driver.findElement(By.xpath("//*[@id='checkout-step-shipping']/div[4]/div[1]/label"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", newaddress);
			//Thread.sleep(3000);
	     WebDriverWait wait = new WebDriverWait(driver, 30);
		    	scn.log("Click on SHIP TO SAME ADDRESS");
		    	logger.info("Click on SHIP TO SAME ADDRESS");
		    }
	

		public void clickOnShipToNearbyStore()
	    {

			JavascriptExecutor js2= (JavascriptExecutor)driver;
			js2.executeScript("window.scrollBy(0,1200)", "");
			
			WebElement shipNearBy =driver.findElement(By.xpath("//*[@id='shipping-nearby']"));
			shipNearBy.click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
	    	scn.log("Click on SHIP TO NEARBY STORE");
	    	logger.info("Click on SHIP TO NEARBY STORE");
	    }

		
		public void clickOnAddNew()
	    {

			WebElement addnew =driver.findElement(By.xpath("//*[@id='checkout-step-shipping']/div[3]/div[2]/a"));
			addnew .click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,650)", "");
	    	scn.log("Click on Add New button");
	    	logger.info("Click on Add New button ");
	    }
		
		

		public void AddNewShippingAddress(String lastname1, String mobile1, String zip1, String flat1) throws Exception
	    {

			WebElement Lastname1 =driver.findElement(By.xpath("//*[@id='shipping-new-address-form']/div[2]/div/input"));
			Lastname1.sendKeys(lastname1);
			//Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			WebElement MobileNumber1 =driver.findElement(By.xpath("//*[@id='shipping-new-address-form']/div[3]/div/input"));
			MobileNumber1.sendKeys(mobile1);
			
			WebElement ZipPostalCode1 =driver.findElement(By.xpath("//*[@id='shipping-new-address-form']/div[4]/div/input"));
			ZipPostalCode1 .sendKeys(zip1);
			
			Thread.sleep(4000);
		
			
			WebElement Flat1 =driver.findElement(By.xpath("//*[@id='shipping-new-address-form']/fieldset/div/div/div/input"));
			Flat1 .sendKeys(flat1 );
			
			
			//Thread.sleep(3000);
			
			JavascriptExecutor js4= (JavascriptExecutor)driver;
			js4.executeScript("window.scrollBy(0,-1000)", "");

            //WebDriverWait wait = new WebDriverWait(driver, 30);
	    	scn.log("Add new shipping address");
	    	logger.info("Add new shipping address");
	    }

		public void AddNewShippingAddressDetails(String lastname, String mobile, String zip, String flat) throws Exception
	    {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,50)", "");

			WebElement Lastname =driver.findElement(By.xpath("(//input[@name='lastname'])[1]"));
			Lastname.sendKeys(lastname);
			
			WebElement MobileNumber =driver.findElement(By.xpath("(//input[@name='telephone'])[1]"));
			MobileNumber.sendKeys(mobile);
			
			WebElement ZipPostalCode =driver.findElement(By.xpath("(//input[@name='postcode'])[1]"));
			ZipPostalCode .sendKeys(zip);
			
			Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			WebElement Flat =driver.findElement(By.xpath("(//input[@name='street[0]'])[1]"));
			Flat .sendKeys(flat );
			
			
			Thread.sleep(3000);
	    }
			
			
			
		public void clickOnEditOrder()
	    {

			WebElement edit =driver.findElement(By.xpath("//*[@id='opc-sidebar']/div[2]/div[1]/a"));
			edit.click();
            WebDriverWait wait = new WebDriverWait(driver, 40);
	    	scn.log("Click on EDIT ORDER");
	    	logger.info("Click on EDIT ORDER");
	    }
		
		public void clickOnContinue() throws Exception
	    {

			WebElement continue12 =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='action primary']")));


			JavascriptExecutor c = (JavascriptExecutor) driver;
			c.executeScript("arguments[0].click();", continue12);
			
			Thread.sleep(4000);
	    	scn.log("Click on Continue button");
	    	logger.info("Click on Continue button");
	    }

		
		public void clickOnShipCheckbox()
	    {

			WebElement addresscheckbox =driver.findElement(By.xpath("(//button[@type='button'])[7]"));
			addresscheckbox.click();


	    	scn.log("Click on Bill to This Address Checkbox");
	    	logger.info("Click on Bill to This Address Checkbox");
	    }
		
		public void AddNewAddressDetails(String lastname11, String mobile11, String zip11, String flat11) throws Exception
	    {
		
			Thread.sleep(3000);
			WebElement Lastname2 =driver.findElement(By.xpath("//*[@id='billing-new-address-form']/div[2]/div/input"));
			Lastname2.sendKeys(lastname11);
			
			WebElement MobileNumber2 =driver.findElement(By.xpath("//*[@id='billing-new-address-form']/div[3]/div/input"));
			MobileNumber2.sendKeys(mobile11);
			
			WebElement ZipPostalCode2 =driver.findElement(By.xpath("//*[@id='billing-new-address-form']/div[4]/div/input"));
			ZipPostalCode2 .sendKeys(zip11);
			
			Thread.sleep(4000);
			
			WebElement Flat2 =driver.findElement(By.xpath("//*[@id='billing-new-address-form']/fieldset/div/div/div/input"));
			Flat2 .sendKeys(flat11 );
			
			
			Thread.sleep(3000);
	    }
			
		
}
