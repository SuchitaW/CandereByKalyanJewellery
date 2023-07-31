package PageObjects;

import java.util.List;

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

public class ProductListingPageObject {
	
	

	private static final Logger logger= LogManager.getLogger(ProductListingPageObject.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	//============= Locators for WebElements for SignIn activity =========================================//

		//private By yourAccount= By.xpath("//div[@class='link_items actions-custom customer-links']");
		

	//============= Constructor ========================================================================//
		public ProductListingPageObject(WebDriver driver,Scenario scn)
		{
			this.driver= driver;
			this.scn=scn;
		}
		
	//=================== 1. Method to validate Mouse over=================================================//
	    public void mouseOverValidation()
	    {
	    	WebElement earring=driver.findElement(By.xpath("//a[@class='parent_'][normalize-space()='Earrings']"));
			Actions act=new Actions (driver);
			act.moveToElement(earring).perform();
			logger.info("Done Mouse hover on 'Earring' from Menu");
		    scn.log("Done Mouse hover on 'Earring' from Menu");
	    }
	    
	    public void subCategoryValidation(List<String> subcategory)
	    {
	    List<WebElement> subCategoryElement = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav/div/div/div/div/ul/li[3]/div/div/div[1]/div/p"));

		for (int i = 0; i < subcategory.size(); i++) {
			if (subcategory.get(i).equals(subCategoryElement.get(i).getText())) {
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
		
		logger.info("Validate the product sub category with expected datatable");
		scn.log("Validate the product sub category with expected datatable");
	    
	    
	    }
	    
	    
	    public void productListingPageTitleValidation()
	    {

	    	String productlistPageTitle= "Latest Designs of Gold Earrings Online - Candere by Kalyan Jewellers";
	    	WebDriverWait wait = new WebDriverWait(driver, 30);
	    	boolean p =wait.until(ExpectedConditions.titleIs(productlistPageTitle));
	    	Assert.assertEquals(true, p);
	    	logger.info("Validate product list page with its title, title is: "+ productlistPageTitle);
	    	scn.log("navigate to product list page , page title is: "+ productlistPageTitle);
	    
	    
	    }

		
	    public void validationofTrandingUrl(String url)
	    {

	    	WebElement treadingAcLinkElement =driver.findElement(By.xpath("//link[@href=\"https://www.candere.com/trending/hot.html\"][1]"));
	    	
	    	Assert.assertEquals(url, treadingAcLinkElement.getAttribute("href"));
	    	logger.info("Validate treading url is: "+treadingAcLinkElement.getAttribute("href"));
	       scn.log("Validate treading url  is: "+treadingAcLinkElement.getAttribute("href"));
	    	
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,250)", "");
	      
	    }
	    
	    
	    

		public void clickOnexpressdelivery() {
			// TODO Auto-generated method stub
			WebElement expressdelivery =driver.findElement(By.xpath("//div[@class='select-filter-options ps_hide']"));
	    	////*[@id="filterTags"]/div
			
			////*[@id='narrow-by-list']/div[2]/dt
	    	JavascriptExecutor express = (JavascriptExecutor) driver;
	    	express.executeScript("arguments[0].click();", expressdelivery );
	    	scn.log("Express-Delivery button is displayed");
	    	logger.info("Express-Delivery button is displayed");
	    	
	    	WebElement expressdelivery11 =driver.findElement(By.xpath("//*[@id='filterTags']"));
//expressdelivery.click();
	    	JavascriptExecutor express1 = (JavascriptExecutor) driver;
	    	express1.executeScript("arguments[0].click();", expressdelivery11 );
	    
		}
	      
	    

		public void clickOnMoreFilter1() {
			// TODO Auto-generated method stub
			WebElement morefilter=driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[7]/dt")); 
			   JavascriptExecutor more = (JavascriptExecutor) driver;
			   more.executeScript("arguments[0].click();", morefilter);
	    	scn.log("MoreFilter button is displayed");
	    	logger.info("MoreFilter button is displayed");
	    	
	    	


	    
		}

		public void clickOnMoreFilter() {
			// TODO Auto-generated method stub
			WebElement morefilter=driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[7]/dt")); 
			   JavascriptExecutor more = (JavascriptExecutor) driver;
			   more.executeScript("arguments[0].click();", morefilter);
	    	scn.log("MoreFilter button is displayed");
	    	logger.info("MoreFilter button is displayed");
		}

		
		
		public void SelectCombinationOfMoreFilter() {
			
			WebElement price=driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[9]/div[2]/div/div[2]"));
			price.click();

     WebElement price1=driver.findElement(By.xpath("//*[@id='price']/form/ol/li[3]"));
	      price1.click();

			WebElement rating=driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[9]/div[2]/div/div[4]"));
			 rating.click();

			WebElement rating1=driver.findElement(By.xpath("//*[@id='rating']/form/ol/li[1]"));
			       rating1.click(); 
			       
			       WebElement shopfor=driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[9]/div[2]/div/div[6]"));
			       shopfor.click();

			WebElement shopfor1=driver.findElement(By.xpath("//*[@id='gender']/form/ol/li[4]"));
			shopfor1.click(); 

			
			WebDriverWait wait = new WebDriverWait(driver, 30);   
			
		}

		public void chooseToBuyProduct() {
			
			List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,350)", "");

			firstProd.get(0).click();
			 //Thread.sleep(3000);
		}

		
		
		
}   
	    
