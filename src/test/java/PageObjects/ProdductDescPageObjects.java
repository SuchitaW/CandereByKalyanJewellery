package PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class ProdductDescPageObjects {

	


	private static final Logger logger= LogManager.getLogger(ProdductDescPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	//============= Locators for WebElements for SignIn activity =========================================//

		private By yourAccount= By.xpath("//div[@class='link_items actions-custom customer-links']");
		

	//============= Constructor ========================================================================//
		public ProdductDescPageObjects(WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		
	//=================== 1. Method to validate Mouse over=================================================//
		 public void mouseOverringValidation()
		    {
		    	WebElement ring=driver.findElement(By.xpath("//a[@class='parent_'][normalize-space()='Rings']"));
				Actions act=new Actions (driver);
				act.moveToElement(ring).perform();
				logger.info("Done Mouse hover on 'Ring' from Menu");
			    scn.log("Done Mouse hover on 'Ring' from Menu");
		    }
		    
		    public void subCategoryringValidation(List<String> ringsubcategory)
		    {
		    List<WebElement> subCategoryElement = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav[1]/div/div/div/div/ul/li[2]/div/div/div[1]/div/p"));

			for (int i = 0; i < ringsubcategory.size(); i++) {
				if (ringsubcategory.get(i).equals(subCategoryElement.get(i).getText())) {
					Assert.assertTrue(true);
				}
				else
				{
					Assert.fail();
				}
			}}
		    
		    public void productListPageTitleValidation()
		    {

		    	String productlistPageTitle= "Designer Diamond Rings @ Best Price - Candere by Kalyan Jewellers";
		    	WebDriverWait wait = new WebDriverWait(driver, 30);
		    	boolean p =wait.until(ExpectedConditions.titleIs(productlistPageTitle));
		    	Assert.assertEquals(true, p);
		    	logger.info("Validate product list page with its title, title is: "+ productlistPageTitle);
		    	scn.log("navigate to product list page , page title is: "+ productlistPageTitle);
		    
		    
		    }

		    
		    
		    
		    public void productdescPageValidation()
		    {

		    	Set<String> handles = driver.getWindowHandles(); // get all the open windows
		    	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
		    	String original = it.next();// gives the parent window id
		    	String prodDescp = it.next();// gives the child window id

		    	driver.switchTo().window(prodDescp); // switch to product Descp
		    	
		    	logger.info("Product description page is displayed");
		    	scn.log("Product description page is displayed");
		    
		    }

		    public void CartPageTitleValidation()
		    {

		    	String cartlistPageTitle= "Shopping Cart";
		    	WebDriverWait wait = new WebDriverWait(driver, 30);
		    	boolean p =wait.until(ExpectedConditions.titleIs(cartlistPageTitle));
		    	Assert.assertEquals(true, p);
		    	logger.info("Validate product list page with its title, title is: "+ cartlistPageTitle);
		    	scn.log("navigate to product list page , page title is: "+ cartlistPageTitle);
		    
		    
		    }
		    
		    public void switchToNewWindow()
		    {
		    
		    	Set<String> handles = driver.getWindowHandles(); // get all the open windows
		    	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
		    	String original = it.next();// gives the parent window id
		    	String prodDescp = it.next();// gives the child window id

		    	driver.switchTo().window(prodDescp);
		    	logger.info("Product description page is display");
		    	scn.log("User clicked on a product");
		    
			
		    }
		    
		    public void ClickOnAddToCart()
		    {
		    
		    	WebElement addtocart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		    	JavascriptExecutor add = (JavascriptExecutor) driver;
		    	add.executeScript("arguments[0].click();",addtocart  );
		    	
		    	scn.log("Add to cart button is displayed");
		    logger.info("Add to cart button is displayed");
		    
			
		    }
		    

		    public void ClickOnCheckoutSecurely()
		    {
		    
		    	WebElement checkoutSecurely =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Checkout Securely'])[1]")));

		    	JavascriptExecutor checkout = (JavascriptExecutor) driver;
		    	checkout.executeScript("arguments[0].click();", checkoutSecurely );
		    	scn.log("Checkout Securely button is displayed");
		    	logger.info("Checkout Securely button is displayed");
			
		    }
		    
		    public void ClickOnTryON() throws Exception
		    {
		    
		    	JavascriptExecutor js6= (JavascriptExecutor)driver;
		    	js6.executeScript("window.scrollBy(0,450)", "");
		    	
		    	WebElement tryOn=driver.findElement(By.xpath("//button[@id='product-MirrAR-Button']"));
		    	tryOn.click();
		    	
		    	Thread.sleep(20000);
		    	scn.log("Click on Try On");
		    	logger.info("Click on Try On");
			
		    }
		    
		    public void ClickOnCustomizeproduct () throws Exception
		    {
		    
		    	JavascriptExecutor js8= (JavascriptExecutor)driver;
		    	js8.executeScript("window.scrollBy(0,600)", "");
		    	
		    	WebElement customize = driver.findElement(By.xpath("//div[@class='customisation_toggle']"));
		    	customize .click();
		    	

		    	Thread.sleep(5000);
		    	scn.log("Click on Customize product");
		    	logger.info("Click on Customize product");
			
		    }
		    

		    public void ChangeMetalcolourpurityqty () throws Exception
		    {
		    
	    	WebElement metalcolor = driver.findElement(By.xpath("//div[@class='metal-option']//label[2]"));
	    	metalcolor .click();
	    	Thread.sleep(2000);
	    	WebElement metalpurity = driver.findElement(By.xpath("//label[@class='container purity_container active']"));
    	    metalpurity .click();
    	   Thread.sleep(2000);
	    	WebElement quality= driver.findElement(By.xpath("//label[@class='container clarity_container ']"));
	    	quality .click();
	    	Thread.sleep(2000);
	    	
	        scn.log("Change the Metal Colour, Purity and Quantity");
		    	logger.info("Change the Metal Colour, Purity and Quantity");
			
		    }


		    public void ClickOnMetaldetails() throws Exception
		    {
		   
		    	WebElement Metaldetails=driver.findElement(By.xpath("//div[@aria-controls='tab-metal']"));
		    	Metaldetails.click();
		    	
		    	scn.log("Click on METAL DETAILS");
		    	logger.info("Click on METAL DETAILS");
			
		    }
		    
		    public void ClickOnDiamonddetails() throws Exception
		    {
		   
		    	WebElement diamonddetails=driver.findElement(By.xpath("//div[@aria-controls='tab-diamond']"));
		    	diamonddetails.click();
		    	
		    	scn.log("Click on DIAMOND DETAILS");
		    	logger.info("Click on DIAMOND DETAILS");
			
		    }

		    public void ClickOnGemstonedetails() throws Exception
		    {
		   
		    	WebElement Gemstonedetails=driver.findElement(By.xpath("//div[@aria-controls='tab-gem-stone']"));
		    	Gemstonedetails.click();
		    	
		    	scn.log("Click on Gemstonedetails");
		    	logger.info("Click on Gemstonedetails");
			
		    }

			public void ClickOnPriceBreakup() throws Exception {
				// TODO Auto-generated method stub
				WebElement pricebreakup =driver.findElement(By.xpath("//a[@class='view_details_ pb__ price-breakup']"));
				pricebreakup.click();
				Thread.sleep(3000);
			}

			public void ClickOnViewDetails() throws Exception {
				WebElement viewdetails =driver.findElement(By.xpath("//a[normalize-space()='View Details']"));
				viewdetails.click();
				Thread.sleep(3000);
				
			}


			public void ClickOnAddEngraveing() throws Exception
		    {
		   
		    	WebElement addEngraveing=driver.findElement(By.xpath("//a[@class='view_details__ eng_popup engrave-tab']"));
		    	addEngraveing.click();
		   
		    	
		    	scn.log("Click on Add Engraveing");
		    	logger.info("Click on Add Engraveing");
			
		    }

			







}
	
	
	
	
	
	
	
	
	
	

