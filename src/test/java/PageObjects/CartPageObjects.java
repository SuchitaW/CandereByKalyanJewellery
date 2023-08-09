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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class CartPageObjects {
	
	
	
	

	private static final Logger logger= LogManager.getLogger(CartPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	//============= Locators for WebElements for SignIn activity =========================================//

		//private By yourAccount= By.xpath("//div[@class='link_items actions-custom customer-links']");
		

	//============= Constructor ========================================================================//
		public CartPageObjects(WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		
	//=================== 1. Method to validate Mouse over=================================================//
		  
	
		
		public void clickOnShoppingBag()
		    {
			WebElement minibag = driver.findElement(By.xpath("//div[@class='link_items minicart-wrapper']"));
			Actions act =new Actions(driver);
			act.moveToElement(minibag).build().perform();
			WebElement viewshoppingbag = driver.findElement(By.xpath("//a[@class='action viewcart']"));
			viewshoppingbag.click();
			logger.info("Clicked on shopping bag button");
		    	scn.log("Clicked on shopping bag button");


		    }
	
	
		public void SelectProdQtyandSize() throws Exception
	    {
			WebElement dropdownsize =driver.findElement(By.xpath("//select[@class='mt_size']"));
			Select select=new Select(dropdownsize);
			select.selectByValue("25");
			Thread.sleep(5000);
			WebElement dropdownqty =driver.findElement(By.xpath("//select[@class='qty custom-qty']"));
			Select select1=new Select(dropdownqty);
			select1.selectByValue("2");
			Thread.sleep(5000);
	    	scn.log("Change the product qty and size");
	    	logger.info("Change the product qty and size");
	    }
	
	
	
		public void SelectInsurance() throws Exception
	    {
			JavascriptExecutor js9= (JavascriptExecutor)driver;
			js9.executeScript("window.scrollBy(0,200)", "");
			
			WebElement checkboxinsurance= driver.findElement(By.xpath("//*[@id='insurance_checbox']"));
			//checkboxinsurance.click();
			
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", checkboxinsurance);

		           Thread.sleep(3000);
	    	scn.log("Check insurance ");
	    	logger.info("Check insurance");
	    }
	
		public void ValidateTitleOfCartPage()
	    {
			String checkOutPageTitle= "Shopping Cart";
			WebDriverWait wait = new WebDriverWait(driver, 50);
			boolean p =wait.until(ExpectedConditions.titleIs(checkOutPageTitle));
			Assert.assertEquals(true, p);
			logger.info("Validate checkout page with its title, title is: "+ checkOutPageTitle);
			scn.log("navigate to checkout page , page title is: "+ checkOutPageTitle);

	    }
		
		public void clickOnContinueShopping() throws Exception
	    {
			WebElement continueshopping = driver.findElement(By.xpath("//span[normalize-space()='Continue Shopping']"));
		JavascriptExecutor js=((JavascriptExecutor) driver);
	    js.executeScript("arguments[0].scrollIntoView(true);", continueshopping);
			continueshopping.click();
		
			Thread.sleep(5000);
			logger.info("Clicked on continue shopping button");
	    	scn.log("Clicked continue shopping button");


	    }


		public void ChoosetheProduct() throws Exception
	    {
			List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
			// But as this step asks click on any link, we can choose to click on Index 0 of
			// the list
			firstProd.get(0).click();
			 Thread.sleep(3000);
			 logger.info("Clicked on First product link");
			
			scn.log("Clicked on First product link");
			
			Set<String> handles = driver.getWindowHandles(); // get all the open windows
			Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
			String original = it.next();// gives the parent window id
			String prodDescp = it.next();// gives the child window id

			driver.switchTo().window(prodDescp); // switch to product Descp

		    logger.info("driver is switched back to prodDescp window");
			
	    }

		public void clickOnCheckOffer() throws Exception
	    {
			WebElement checkoffer= driver.findElement(By.xpath("//*[@id='coupon-link']/span"));
			checkoffer.click();
			
			Thread.sleep(3000);
			logger.info("Clicked on Check Offer");
	    	scn.log("Clicked on Check Offer");


	    }

		
		
		public void clickOnApplyCheckOffer() throws Exception
	    {
			WebElement  apply= driver.findElement(By.xpath("//button[@class='base_btn btn_md primary_btn']"));
			 apply.click();
			 Thread.sleep(2000);
			logger.info("Clicked on Apply Check Offer");
	    	scn.log("Clicked on Apply Check Offer");


	    }
		
		
		
		
		
		
		
		
		
		public void ChoosetheSecondProduct() throws Exception
	    {
			List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
			// But as this step asks click on any link, we can choose to click on Index 0 of
			// the list
			firstProd.get(1).click();
			 //Thread.sleep(3000);
			 logger.info("Clicked on First product link");
			
			scn.log("Clicked on First product link");
			
			Set<String> handles = driver.getWindowHandles(); // get all the open windows
			Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
			String original = it.next();// gives the parent window id
			String prodDescp = it.next();// gives the child window id
			String prodDescp1 = it.next();
			driver.switchTo().window(prodDescp1  ); // switch to product Descp

		   
		    logger.info("driver is switched back to prodDescp window");
			
	    }


}
