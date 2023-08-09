	package PageObjects;
	
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.junit.Assert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	import io.cucumber.java.Scenario;
	
	
	public class SignUpPageObject {
		
	
	
		private static final Logger logger= LogManager.getLogger(SignUpPageObject.class);
		WebDriver driver;
		WebDriverWait wait;
		Scenario scn;
		
		//============= Locators for WebElements for SignIn activity =========================================//
	
			private By yourAccount= By.xpath("//div[@class='link_items actions-custom customer-links']");
			private By logIn= By.id("customer-popup-sign-in");
			private By signUp= By.xpath("//div[@class='sign-in customer-login-link u_l_ico']//a[@id='customer-popup-registration']");
	
		//============= Constructor ========================================================================//
			public SignUpPageObject(WebDriver driver,Scenario scn)
			{
				this.driver= driver;
				this.scn=scn;
			}
			
		//============ 1. Method to validate SignIn Button =================================================//
		    public void signInBtnValidation()
		    {
		    	WebElement signIn =driver.findElement(yourAccount);
		    	Assert.assertEquals(true, signIn.isDisplayed());
		    	logger.info("Validate the User Icon ");
		    	scn.log("Validate the User Icon ");
		    }
		    
		//============ 2. Method to click on SignIn Button =================================================//
	
	
		    
		    public void clickOnUserIcon()
		    {
		    	
		    	WebElement UserAccount =driver.findElement(yourAccount);
		    	
		    	wait= new WebDriverWait(driver,50);
		    	wait.until(ExpectedConditions.elementToBeClickable(UserAccount));
		    	UserAccount.click();
		    	logger.info("Click on the User Icon");
		    	scn.log("Click on the User Icon");
		    	
		    }
		    
		    //==================================
		  
		    
		//============ 3. Method to validate SignIn page title =============================================//
		    public void validateSignInPage(String SignInPageTitle)
		    {
		    	wait= new WebDriverWait(driver,20);
		    	boolean xyz = wait.until(ExpectedConditions.titleIs(SignInPageTitle));
		        Assert.assertEquals(true, xyz);
		    	logger.info("Validate title of signIn page, so title is: "+ SignInPageTitle);
		    	scn.log("Validate title of signIn page, so title is: "+ SignInPageTitle);
		    }
	
			public void clickOnSignUp() {
		     WebElement signup =driver.findElement(signUp);
		    	
		    	wait= new WebDriverWait(driver,50);
		    	wait.until(ExpectedConditions.elementToBeClickable(signup));
		    	signup.click();
		    	logger.info("Click on the signUp Button");
		    	scn.log("Click on the signUp Button");
				
			}
			
		public void validationtakescreenshot(Scenario scn) {
			
			TakesScreenshot srnshot= ((TakesScreenshot)driver);
			byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Name of passed step is: "+ scn.getName());
			scn.log("Attach a screenshot as step get passed");	
		}
		
		public void clickOnLogIn() {
		     WebElement login =driver.findElement(logIn);
		    	
		    	wait= new WebDriverWait(driver,50);
		    	wait.until(ExpectedConditions.elementToBeClickable(login));
		    	login.click();
		    	logger.info("Click on the logIn Button");
		    	scn.log("Click on the logIn Button");
				
			}
		
	
	    	
	//==================================================================================================//
		
	public void clickOnLogInUsingGoogle() {
	     WebElement logingoogle =driver.findElement(By.xpath("//*[@id='customer-popup-login']/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]"));
	    	
	    	wait= new WebDriverWait(driver,50);
	    	wait.until(ExpectedConditions.elementToBeClickable(logingoogle));
	    	logingoogle.click();
	    	logger.info("Click on the LogInUsingGoogle Button");
	    	scn.log("Click on the LogInUsingGoogle Button");
			
		}
		
	
	
	public void clickOnNext() {
	     WebElement next =driver.findElement(By.xpath("//*[@id='identifierNext']"));
	    	
	    	wait= new WebDriverWait(driver,30);
	    	wait.until(ExpectedConditions.elementToBeClickable(next));
	    	next.click();
	    	logger.info("Click on the Next Button");
	    	scn.log("Click on the Next Button");
			
		}
		
	
	  
   
	
	
	}
