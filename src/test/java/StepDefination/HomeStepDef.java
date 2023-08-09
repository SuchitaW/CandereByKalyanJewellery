package StepDefination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPageObjects;
import PageObjects.FooterSectionObjects;
import PageObjects.HeaderSectionObjects;
import PageObjects.HomePageObjects;
import PageObjects.MyAccountSectionObjects;
import PageObjects.PaymentPageObjects;
import PageObjects.ProdductDescPageObjects;
import PageObjects.ProductListingPageObject;
import PageObjects.ShippingPageObject;
import PageObjects.SignUpPageObject;
import core.WebDriverFactory;
import io.cucumber.core.gherkin.Argument;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDef {
	
	
	private static final Logger logger = LogManager.getLogger(HomeStepDef.class);
	WebDriver driver;

	WebDriverWait wait;
	JavascriptExecutor js;
	Scenario scn;
	String base_url = "https://www.candere.com/  ";
	
	

//============== Declare object reference of pageObjects classes =============================//
	
	
	HomePageObjects homePageObject;
	FooterSectionObjects footerPageObject;
	SignUpPageObject signUpPageObject;
	HeaderSectionObjects headerObject;
	ProductListingPageObject productListingObject;
	ProdductDescPageObjects productDescObject;
	PaymentPageObjects paymentobject;
	ShippingPageObject shippingobject;
	MyAccountSectionObjects myaccountObject;
	
	CartPageObjects cartobject;
//====================== Before Hook =========================================================//	
	@Before
	public void setUp(Scenario scn)
	{
		this.scn=scn;

		//Get the desired browser to be invoked
		String browserName= WebDriverFactory.getBrowserName();
		driver=WebDriverFactory.getWebDriverForBrowser(browserName); 
		scn.log("Browser get invoked");

		//Initialize object of page objects classes 
		 homePageObject= new HomePageObjects(driver, scn);
	      footerPageObject=new FooterSectionObjects(driver, scn);
		 signUpPageObject= new SignUpPageObject(driver, scn);
		 headerObject= new HeaderSectionObjects(driver, scn);
		 productListingObject =new ProductListingPageObject(driver, scn);
		 productDescObject=new ProdductDescPageObjects(driver, scn);
		 myaccountObject=new MyAccountSectionObjects(driver,scn);
			paymentobject=new PaymentPageObjects(driver, scn);
	shippingobject=new ShippingPageObject(driver, scn);
	
	cartobject=new CartPageObjects(driver, scn);
	}

//====================== After Hook =========================================================//
	
	@After(order=2)
	//Capture screenshot if test case get failed
	public void captureScreenshot(Scenario scn)
	{
		if(scn.isFailed())
		{
			TakesScreenshot srnshot= ((TakesScreenshot)driver);
			byte [] data =srnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Name of failed step is: "+ scn.getName());
			scn.log("Attach a screenshot as step get failed");
		}
		else
		{
			scn.log("Test case get passed, no screenshot is captured");
		}
	}
	
	@After(order=1)
	//Quit the browser
	public void tearDown(Scenario scn)
	{
		WebDriverFactory.quitTheBrowser();
		scn.log("Browser is quit");
	}
	
	
	
	
//====================== Background ================================================//
	@Given("User navigate to URL and open the landing page")
	public void user_navigate_to_url_and_open_the_landing_page() {
		WebDriverFactory.navigateToURL(base_url);
	    }

//===================== Scenarios =================================================//

	@When("User is on landing page")
	public void user_is_on_landing_page() {
		logger.info("User is on landing page after navigating to base URL");
	    scn.log("User is on landing page after navigating to base URL");
	}
	@Then("Validate current URL of landing page with expected URL")
	public void validate_current_url_of_landing_page_with_expected_url() {
		 homePageObject.validatePageURL();
		 scn.log("Validate current URL is: "+ driver.getCurrentUrl());
	}
	
	@Then("Validate title of landing page with expected title as {string}")
	public void validate_title_of_landing_page_with_expected_title_as(String titleOfPage) {
		homePageObject.validatePageTitle(titleOfPage);
		scn.log("Validate page title is: "+ driver.getTitle());
	}
		
	@Then("User see the logo of application")
	public void user_see_the_logo_of_application() {
		homePageObject.displayLogo();
		scn.log("Display the application logo on landing page");
	}
	
	@When("fetch the height of logo")
	public void fetch_the_height_of_logo() {
		homePageObject.fetchLogoHeight();
	}

	@Then("Height of logo should be {string}")
	public void height_of_logo_should_be(String height) {
		homePageObject.logoHeightValid(height);
	}
		
	@When("fetch the width of logo")
	public void fetch_the_width_of_logo() {
		 
		homePageObject.fetchLogoWidth();
		
	}

	@Then("Width of logo should be {string}")
	public void width_of_logo_should_be(String width) {
		homePageObject.logoWidthValid(width);
	}
	
//============================@HomePageHeaderLinks===============================================================
	

@When("User validate all headerlink are clickable or not")
public void user_validate_all_headerlink_are_clickable_or_not() throws Exception {
	
	headerObject.ClickOnOrderTracking();
	 headerObject.ClickOnFindExperienceCenter();
	 headerObject.ClickOnContactUs();
	 headerObject.ClickOnBlog();
    driver.navigate().back();
    headerObject.ClickOnSearchButton();
    headerObject.ClickOnUser();
    headerObject.ClickOnWishlist();
    driver.navigate().back();
    headerObject.ClickOnBag();
     driver.navigate().back(); 
   
}

@Then("Below header Links are displayed")
public void below_header_links_are_displayed(List<String> list) throws Exception {
	for (int i=0;i<list.size();i++) {
		headerObject.validateElementPresentInHeaderSection(list.get(i));	
		
}}
//==========================OrderTracking=================================================

@When("User click on ordertracking")
public void user_click_on_ordertracking()  {

	headerObject.orderTrackingPage();

}

@When("User enter {string}  and  {string}")
public void user_enter_and(String orderid, String emailaddress)  {

	headerObject.validateOrderTracking(orderid, emailaddress);
	
}
@When("User click on request info")
public void user_click_on_request_info()  {
headerObject.validateOrderTrackingReqInfo();
homePageObject.capturePassScreenshot(scn);

}

@Then("User opened with order tracking url {string}")
public void user_opened_with_order_tracking_url(String Name) {
	headerObject.orderTrackinglinkValidation(Name);
}

//========================================@ProductCategoryList===============================


@When("User see the product category")
public void user_see_the_product_category() {
   homePageObject.setProdCategory();
}

@Then("Validate product category as per expected product category listed below")
public void validate_product_category_as_per_expected_product_category_listed_below(List<String> prodList1) {
    homePageObject.validateProdCategory(prodList1);


}

@Then("Size of product category should be {int}")
public void size_of_product_category_should_be(Integer prodCatCount) {
    homePageObject.sizeOfProdCategory(prodCatCount);
}

//===============================Signup&Spin!=======================================================

@When("User scroll down to Sign up & Spin!")
public void user_scroll_down_to_sign_up_spin() {
    homePageObject.validateScrollSignUpSpin();
}

@When("User click on Sign up & Spin button")
public void user_click_on_sign_up_spin_button() throws Exception {
    homePageObject.clickOnSignUpSpin();
    //Thread.sleep(7000);
}
@Then("User are able to see the Sign Up form")
public void user_are_able_to_see_the_sign_up_form() {
   homePageObject.validateSignUpandSpinPageTitle();
   
   homePageObject.capturePassScreenshot(scn);
}

//========================================ProductCategory====================


@When("User see the product category on the landing page")
public void user_see_the_product_category_on_the_landing_page() {

homePageObject.setProdCategoryList();
}
@When("Validate product category list as per expected product category listed below")
public void validate_product_category_list_as_per_expected_product_category_listed_below(List<String> prodList) {

homePageObject.validateProdCategorylist(prodList);
}
@When("User click on any product")
public void user_click_on_any_product() throws Exception {

homePageObject.clickOnAnyProdCategory();

Thread.sleep(3000);
}
@Then("The product list page is displayed")
public void the_product_list_page_is_displayed() {

homePageObject.validateProductListPageTitle();
}

@When("User scroll down to Show Me More")
public void user_scroll_down_to_show_me_more() throws Exception {

homePageObject.scrolldownShowMeMore();
}

@When("User click on show me more")
public void user_click_on_show_me_more() {
    homePageObject.clickOnShowMeMore();
}
@Then("User are able to see the more collection")
public void user_are_able_to_see_the_more_collection() {
   homePageObject.validateShowMeMorePageTitle();
}

//============================ProductCategory========================================================

@When("User mouseover to the Ring of the landing page of the application")
public void user_mouseover_to_the_ring_of_the_landing_page_of_the_application() {
	WebElement ring=driver.findElement(By.xpath("//a[@class='parent_'][normalize-space()='Rings']"));
	Actions act=new Actions(driver);
	act.moveToElement(ring).build().perform();
}

@When("User see view all designs link should be visible")
public void user_see_view_all_designs_link_should_be_visible() {
	WebElement viewdesigns= driver.findElement(By.xpath("//*[@id=\"store.links\"]/nav/div/div/div/div/ul/li[3]/div/div/div[2]/div/a"));
	viewdesigns.isDisplayed();
}
@When("User is able to see {int} sub categories")
public void user_is_able_to_see_sub_categories(int prodsubcatagory) {
	List<WebElement> prodMainCatListEle1 = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav[1]/div/div/div/div/ul/li[2]/div/div/div[1]/div/p"));
    Assert.assertEquals(prodsubcatagory,prodMainCatListEle1.size());

}

@Then("The categories having the option {string},{string},{string} and {string}")
public void the_categories_having_the_option_and(String subcategoryOneNameExp1, String subcategoryTwoNameExp1, String subcategoryThreeNameExp1,String subcategoryFourNameExp1) {
	List<WebElement> prodMainCatListEle1 = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav/div/div/div/div/ul/li[2]/div/div/div[1]/div/p"));

Assert.assertEquals(subcategoryOneNameExp1, prodMainCatListEle1.get(0).getText());
Assert.assertEquals(subcategoryTwoNameExp1, prodMainCatListEle1.get(1).getText());
Assert.assertEquals(subcategoryThreeNameExp1, prodMainCatListEle1.get(2).getText());
Assert.assertEquals(subcategoryFourNameExp1, prodMainCatListEle1.get(3).getText());

}


@Then("Under Shop by Style category below options are visible")
public void under_shop_by_style_category_below_options_are_visible(List<String> Shopbystylelist) {
	List<WebElement> Shopbystyle = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav[1]/div/div/div/div/ul/li[2]/div/div/div[1]/div[1]/a"));
	
	for (int i = 0; i <Shopbystylelist.size(); i++) {
		if (Shopbystylelist.get(i).equals(Shopbystyle .get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
		}
}
@Then("Under Shop by Material category below options are visible")
public void under_shop_by_material_category_below_options_are_visible(List<String> ShopbyMaterialList) {
	List<WebElement> ShopbyMaterial = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav[1]/div/div/div/div/ul/li[2]/div/div/div[1]/div[2]/a"));

	for(int i=0;i<ShopbyMaterialList.size();i++)
	{
		if(ShopbyMaterialList.get(i).equals(ShopbyMaterial .get(i).getText())) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
}
@Then("Under Shop for category below options are visible")
public void under_shop_for_category_below_options_are_visible(List<String> ShopforList) {
	List<WebElement> ShopFor = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav/div/div/div/div/ul/li[2]/div/div/div[1]/div[3]/a"));

	for(int i=0;i<ShopforList.size();i++) {
		if(ShopforList.get(i).equals(ShopFor.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
	
}
@Then("Under Shop By Occasion category below options are visible")
public void under_shop_by_occasion_category_below_options_are_visible(List<String> ShopforOccasionList) {
	List<WebElement> ShopByOccasion = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav[1]/div/div/div/div/ul/li[2]/div/div/div[1]/div[4]/a"));

	for(int i=0;i<ShopforOccasionList.size();i++) {
		if(ShopforOccasionList.get(i).equals(ShopByOccasion.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
	
}


//================================ProductCategoryOffers===============================================================

@When("User mouseover to the Offers of the landing page of the application")
	public void user_mouseover_to_the_offers_of_the_landing_page_of_the_application() throws Exception {
	   WebElement offers=driver.findElement(By.xpath("//a[normalize-space()='Offers']"));
	   Actions act=new Actions(driver);
	   act.moveToElement(offers).build().perform();


	}

	   @When("User are able to see all the offer product and click on any offer")
	   public void user_are_able_to_see_all_the_offer_product_and_click_on_any_offer() {
		   List<WebElement> offersprod = driver.findElements(By.xpath("//*[@id=\"store.links\"]/nav/div/div/div/div/ul/li[12]/div/div/div/div/a/img"));
		    homePageObject.capturePassScreenshot(scn);
		    offersprod.get(0).click();
			logger.info("Product offer");
		     scn.log("User see all the product offers");
	   }

	@Then("User successfully redirected to product list page {string}")
	public void user_successfully_redirected_to_product_list_page(String PLPPageTitle) {
		wait= new WebDriverWait(driver,20);
		
   boolean xyz = wait.until(ExpectedConditions.titleIs(PLPPageTitle));
       Assert.assertEquals(true, xyz);
   	logger.info("Validate title of offers page, so title is: "+ PLPPageTitle);
   	scn.log("Validate title of offers page, so title is: "+ PLPPageTitle);
	}

//=================================================@SubscribeNow====================================


@When("User scroldown to the botton of the landing page of the application")
public void user_scroldown_to_the_botton_of_the_landing_page_of_the_application() {
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,750)", "");
}

@When("User enters {string} and {string}")
public void user_enters_and(String emailid , String mobileno) {
	WebElement EmailId =driver.findElement(By.xpath("//input[@id='newsletter']"));
	EmailId.sendKeys(emailid);
	
	WebElement Mobileno =driver.findElement(By.xpath("//input[@id='mobile']"));
	Mobileno.sendKeys(mobileno);
}
@When("User is click on subscribe now")
public void user_is_click_on_subscribe_now() {
	WebElement Subscribenow =driver.findElement(By.xpath("//*[@id=\"newsletter-validate-detail\"]/div[2]/button/span"));
	Subscribenow.click();
}
@Then("Subscribe now message is displayed")
public void subscribe_now_message_is_displayed() throws Exception {
	
	Thread.sleep(3000);
    String exp = "Thank you for your subscription.";
    
    WebElement m = driver.findElement(By.xpath("//div[@class='newsletter-ajax-error']"));
    String act = m.getText();
    System.out.println(" Message is: "+ act);
    Assert.assertEquals(exp, act);
    logger.info("Validate Subscribe now, message is: "+ act);
scn.log("Navigate to Subscribe now , page message is: "+ act);
}

//=========================================@FooterLinksLists==============

@When("user scroldown to the botton of the landing page of the application")
public void user_scroldown_to_the_botton_of_the_landing_page_of_the_application1() throws InterruptedException {
	WebElement AboutUsElement = driver.findElement(By.xpath("//p[normalize-space()='ABOUT US']"));
     JavascriptExecutor js=((JavascriptExecutor) driver);


	js.executeScript("arguments[0].scrollIntoView(true);", AboutUsElement);

	Thread.sleep(5000);
}
@When("user is able to see {int} main options categories")
public void user_is_able_to_see_main_options_categories(int footerMainCatCount) {

	List<WebElement> footerMainCatListEle = driver.findElements(By.xpath("//div[@class='desktop_footer_link_item']//div[1]//nav[1]//p[1]"));
	Assert.assertEquals(footerMainCatCount, footerMainCatListEle.size());
}

@When("the categories having the option {string}, {string}, {string}, {string},{string} and {string}")
public void the_categories_having_the_option_and(String categoryOneNameExp, String categoryTwoNameExp, String categoryThreeNameExp, String categoryFourNameExp, String categoryFiveNameExp, String categorySixNameExp) {
	List<WebElement> footerMainCatListEle = driver.findElements(By.xpath("//div[@class='desktop_footer_link_item']//div[1]//nav[1]//p[1]"));
	Assert.assertEquals(categoryOneNameExp, footerMainCatListEle.get(0).getText());
	Assert.assertEquals(categoryTwoNameExp, footerMainCatListEle.get(1).getText());
	Assert.assertEquals(categoryThreeNameExp, footerMainCatListEle.get(2).getText());
	Assert.assertEquals(categoryFourNameExp, footerMainCatListEle.get(3).getText());
	Assert.assertEquals(categoryFiveNameExp, footerMainCatListEle.get(4).getText());
	Assert.assertEquals(categorySixNameExp, footerMainCatListEle.get(5).getText());
}




@Then("under ABOUT US category below options are visible")
public void under_about_us_category_below_options_are_visible(List<String> expectedAboutUsOptions) {
	List<WebElement> AboutUsOptionsActElement = driver.findElements(By.xpath("//div[@class='row_group flex_group']//div[1]//a"));

	for (int i = 0; i < expectedAboutUsOptions.size(); i++) {
		if (expectedAboutUsOptions.get(i).equals(AboutUsOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
}

@Then("under WHY CANDERE? category below options are visible")
public void under_why_candere_category_below_options_are_visible(List<String> expectedWHYCANDEROptions) {
	List<WebElement> WHYCANDEREOptionsActElement = driver.findElements(By.xpath("//div[@class='row_group flex_group']//div[2]//a"));

	for (int i = 0; i < expectedWHYCANDEROptions.size(); i++) {
		if (expectedWHYCANDEROptions.get(i).equals(WHYCANDEREOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

@Then("under EXPERIENCE CANDERE category below options are visible")
public void under_experience_candere_category_below_options_are_visible(List<String> expectedEXPERIENCECANDEREOptions) {
	List<WebElement> EXPERIENCECANDEREOptionsActElement = driver.findElements(By.xpath("//div[@class='row_group flex_group']//div[3]//a"));

	for (int i = 0; i < expectedEXPERIENCECANDEREOptions.size(); i++) {
		if (expectedEXPERIENCECANDEREOptions.get(i).equals(EXPERIENCECANDEREOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

@Then("under JEWELLERY GUIDES category below options are visible")
public void under_jewellery_guides_category_below_options_are_visible(List<String> expectedJEWELLERYGUIDESOptions) {

	List<WebElement> JEWELLERYGUIDESOptionsActElement = driver.findElements(By.xpath("//div[@class='row_group flex_group']//div[4]//a"));

	for (int i = 0; i < expectedJEWELLERYGUIDESOptions.size(); i++) {
		if (expectedJEWELLERYGUIDESOptions.get(i).equals(JEWELLERYGUIDESOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

@Then("under CONTACT US category below options are visible")
public void under_contact_us_category_below_options_are_visible(List<String> expectedCONTACTUSOptions) {
	List<WebElement> CONTACTUSOptionsActElement = driver.findElements(By.xpath("//div[@class='row_group flex_group']//div[5]//a"));

	for (int i = 0; i < expectedCONTACTUSOptions.size(); i++) {
		if (expectedCONTACTUSOptions.get(i).equals(CONTACTUSOptionsActElement.get(i).getText())) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}}

//===================================TwitterHandle================================================


@When("User click on twitter link")
public void user_click_on_twitter_link() {

footerPageObject.setTwitterLink();
footerPageObject.clickOnTwitterLink();
}

@When("navigate to twitter account page")
public void navigate_to_twitter_account_page() {
   footerPageObject.twitterAcPage();
}
@Then("User opened with twitter url {string}")
public void user_opened_with_twitter_url(String AcName) {
   footerPageObject.twitterAclinkValidation(AcName);
}

@When("User click on facebook link")
public void user_click_on_facebook_link() {
   footerPageObject.setFacebookLink();
   footerPageObject.clickOnFacebookLink();
}


@When("navigate to facebook account page")
public void navigate_to_facebook_account_page() {
    footerPageObject.facebookAcPage();
}
@Then("User opened with facebook url {string}")
public void user_opened_with_facebook_url(String AcName) {
   footerPageObject.facebookAclinkValidation(AcName);
}






//========================================@SignInPage=========================================================

@Given("User see Your Account button")
public void user_see_your_account_button() {
signUpPageObject.signInBtnValidation();

}

@When("User click on Your Account button")
public void user_click_on_your_account_button() throws Exception {
	Thread.sleep(3000);
signUpPageObject.clickOnUserIcon();
}
@Then("User is on Your Account page which have expected page title as {string}")
public void user_is_on_your_account_page_which_have_expected_page_title_as(String SignInPageTitle) {
   signUpPageObject.validateSignInPage(SignInPageTitle);
}


//=======================================@CreateAccount===============================

@When("User see Your Account and click on  SignUp  from home page")
public void user_see_your_account_and_click_on_sign_up_from_home_page() {
  signUpPageObject.clickOnUserIcon();
  signUpPageObject.clickOnSignUp();
  
}

@When("User redirected to create account page of the application where title us {string}")
public void user_redirected_to_create_account_page_of_the_application_where_title_us(String SignInPageTitle) {
  signUpPageObject.validateSignInPage(SignInPageTitle);
}

@When("User enters  {string}  and  {string} and {string}")
public void user_enters_and_and(String name, String emailid, String mobileno) {
WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='firstname']"));
nameInputFieldElement.sendKeys(name);

WebElement emailIdInputFieldElement = driver.findElement(By.xpath("//input[@id='popup-email_address']"));
emailIdInputFieldElement.sendKeys(emailid);

WebElement mobilenoInputFieldElement = driver.findElement(By.xpath("//input[@id='phone']"));
mobilenoInputFieldElement.sendKeys(mobileno);

}


@When("User click on Send Otp")
public void user_click_on_send_otp() {
	WebElement sendotp = driver.findElement(By.xpath("//button[@title='Send Otp']"));
	sendotp.click();
	scn.log("Otp send successful");
	logger.info("Otp send successful");

}


@When("User enter otp")
public void user_enter_otp() throws Exception {
	
	homePageObject.validateRegisterOTP();

}
@When("Click on Verify Otp & Register")
public void click_on_verify_otp_register() {
	WebElement verifyotp = driver.findElement(By.xpath("//div[@id='register_verifyotp']//button[@name='send']"));
	verifyotp.click();
}
@Then("User successfully redirected to {string}")
public void user_successfully_redirected_to(String SignInPageTitle) {

signUpPageObject.validateSignInPage(SignInPageTitle);
}

//==============================LogIn================================================


@When("User see Your Account and click on  Log In  from home page")
public void user_see_your_account_and_click_on_log_in_from_home_page() throws Exception {
	signUpPageObject.clickOnUserIcon();
	//Thread.sleep(3000);
	signUpPageObject.clickOnLogIn();
}


@When("User click on  Log In")
public void user_click_on_log_in() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}





@When("User enters {string}")
public void user_enters(String Emailidmobileno) {
	WebElement nameInputFieldElement = driver.findElement(By.xpath("//input[@id='email-login-one']"));
	nameInputFieldElement.sendKeys(Emailidmobileno);

}

@When("User click on continue button")
public void user_click_on_continue_button() throws InterruptedException {
	WebElement continueButtonElement = driver.findElement(By.xpath("//button[@id='send2-login-one']"));
	continueButtonElement.click();
	WebElement a=driver.findElement(By.xpath("//p[normalize-space()='OTP has been sent successfully.']"));  
	 String s = a.getText();
	 scn.log(s);
    System.out.println("Alert text is: " + s); 
    //Thread.sleep(10000);
}

@When("User enter otp manually and click on login")
public void user_enter_otp_manually_and_click_on_login() throws Exception {
 
	homePageObject.validateLoginOTP();
	
	homePageObject.clickOnSLogin();
	
	
}

@Then("User successfully redirected to homepage {string}")
public void user_successfully_redirected_to_homepage(String SignInPageTitle) throws Exception {
 
	signUpPageObject.validateSignInPage(SignInPageTitle);
     homePageObject.capturePassScreenshot(scn);

}

//============================= @LoginUsingGoogle=====================================


@When("User click on Login Using Google")
public void user_click_on_login_using_google() throws InterruptedException {
    signUpPageObject.clickOnLogInUsingGoogle();
    
    Thread.sleep(2000);
}



@When("User enters Emailid or mobileno ,password and click on next button")
public void user_enters_emailid_or_mobileno_password_and_click_on_next_button() throws Exception {
    

	Set<String> handles = driver.getWindowHandles(); // get all the open windows
	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
	String original1 = it.next();// gives the parent window id
	String childwindow = it.next();// gives the child window id

	driver.switchTo().window(childwindow); // switch to product Descp
	
	
	WebElement username= driver.findElement(By.xpath("//input[@id='identifierId']"));
	username.clear();
	username.sendKeys("suchita.tayde@candere.com");
	
	signUpPageObject.clickOnNext();
	
	  Thread.sleep(2000);
	WebElement p = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
	p.sendKeys("Suchita@11");
	
	WebElement b = driver
		      .findElement(By.xpath("//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']"));
		      b.click();
		      

		      Thread.sleep(5000);
}


@Then("User successfully redirected to homepage")
public void user_successfully_redirected_to_homepage() throws Exception {
	Thread.sleep(4000);
//signUpPageObject.validationtakescreenshot(scn);

}

@When("User enters Emailid or mobileno ,password and click on next button on checkout page")
public void user_enters_emailid_or_mobileno_password_and_click_on_next_button_on_checkout_page() throws Exception {

	String mainWindow=driver.getWindowHandle();
	// It returns no. of windows opened by WebDriver and will return Set of Strings
	Set<String> set =driver.getWindowHandles();
	// Using Iterator to iterate with in windows
	Iterator<String> itr= set.iterator();
	while(itr.hasNext()){
		String childWindow=itr.next();
	   	// Compare whether the main windows is not equal to child window. If not equal, we will close.
		if(!mainWindow.equals(childWindow))
		{
		driver.switchTo().window(childWindow);
		}
		}
		WebElement username= driver.findElement(By.xpath("//input[@id='identifierId']"));
		username.clear();
		username.sendKeys("suchita.tayde@candere.com");
		
		signUpPageObject.clickOnNext();
		
		  Thread.sleep(2000);
		WebElement p = driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
		p.sendKeys("Suchita@11");
		
		WebElement b1 = driver.findElement(By.xpath("//div[@id='passwordNext']//div[@class='VfPpkd-dgl2Hf-ppHlrf-sM5MNb']"));
			      b1.click();
			      
			      driver.switchTo().window(mainWindow);
			      //Thread.sleep(3000);
		}



//=============================Search===================================
@When("User doubleclick  in search box")
public void user_doubleclick_in_search_box() throws Exception {
WebElement search=driver.findElement(By.xpath("//input[@id='search']"));

   Actions act=new Actions(driver);

     act.doubleClick(search).build().perform();
      
}

@Then("User see the popular search box is appear")
public void user_see_the_popular_search_box_is_appear() {
   homePageObject.capturePassScreenshot(scn);
}

//================================================@Searchprod1===================================



@When("User navigated to the home application url")
public void user_navigated_to_the_home_application_url() {
	homePageObject.vaildateLandingPageTitle(base_url);
	
	//scn.log("User navigated to the landing page of the application");

}



@When("User Search for product on search bar {string}")
public void user_search_for_product_on_search_bar(String prodName) throws Exception {

  homePageObject.searchProduct(prodName);

    //Thread.sleep(3000);


}
@Then("Search Result page is displayed with title contains {string}")
public void search_result_page_is_displayed_with_title_contains(String prodNameInTitle1) {
    homePageObject.validateSearchResult(prodNameInTitle1);
    
    }

//================================ @productlistpage============================================


@When("User mousehover on Earring option")
public void user_mousehover_on_earring_option() {
	productListingObject.mouseOverValidation();
	 
}

@When("User see the various catagory on screen")
public void user_see_the_various_catagory_on_screen(List<String> subcategory) {
	
	productListingObject.subCategoryValidation(subcategory);
	
}

@When("User select Shop by Material Gold and click on it")
public void user_select_shop_by_material_gold_and_click_on_it() {
	WebElement subMenuOption = driver.findElement(By.xpath("//a[@href='https://www.candere.com/jewellery/gold-earrings.html']")); 
	subMenuOption.click();
	logger.info("Various types of gold earring is display");
	 scn.log("Various types of gold earring is display");
}
@Then("The product listing page is displayed")
public void the_product_list_page_is_displayed1() {
	
	productListingObject.productListingPageTitleValidation();
}


@Then("User are able to count the per page item in plp")
public void user_are_able_to_count_the_per_page_item_in_plp() {
    
	productListingObject.CountNoofProduct();
	
}

//===================================Morefilter==================================
@When("User click on pendants on landing page")
public void user_click_on_pendants_on_landing_page() throws Exception {
	  productListingObject.ClickOnPendant();
	   
}


@When("User able to click on more filter")
public void user_able_to_click_on_more_filter() {
	productListingObject.clickOnMoreFilter();
       
}

@When("User select the any combination of product as per there choice")
public void user_select_the_any_combination_of_product_as_per_there_choice() throws Exception {

	productListingObject.SelectCombinationOfMoreFilter();
	

}

@Then("User are able to see the combination of product")
public void user_are_able_to_see_the_combination_of_product() throws Exception {
	 WebElement apply=driver.findElement(By.xpath("//div[@class='filter_btn_ apply__']"));
      apply.click();
      Thread.sleep(3000);
    homePageObject.capturePassScreenshot(scn);
      Thread.sleep(3000);
}



@Then("User are able to ClearAll the filters")
public void user_are_able_to_clear_all_the_filters() {
	
	 WebElement clearAll=driver.findElement(By.xpath("//span[contains(text(),'Clear All')]"));
	 clearAll.click();
     
	 
   
}


//============================@plpLoadMore==============================================================

@When("User scrolldown to the bootom of the page")
public void user_scrolldown_to_the_bootom_of_the_page() throws Exception {

	
//	WebElement Loadmore11 = driver.findElement(By.xpath("(//div[@class='amscroll-load-button'])[1]"));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Loadmore11);
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,2500)", "");
	 
	 Thread.sleep(2000);
	 
	 JavascriptExecutor js2 = (JavascriptExecutor) driver;
	 js2.executeScript("window.scrollBy(0,-500)", "");




}

@Then("User click on load more button")
public void user_click_on_load_more_button() throws Exception {
	 
	Thread.sleep(3000);
	  WebElement Loadmore1 = driver.findElement(By.xpath("(//div[@class='amscroll-load-button'])[1]"));
	    
		Loadmore1.click();
		
		JavascriptExecutor js=((JavascriptExecutor) driver); 
		js.executeScript("window.scrollBy(0,500)","");
		Thread.sleep(6000);
		homePageObject.capturePassScreenshot(scn);
}

//================================================== @FilterBy================================
@When("User click on treading on landing page")
public void user_click_on_treading_on_landing_page() throws Exception {
	WebElement treading=driver.findElement(By.xpath("//*[@id=\"store.links\"]/nav[1]/div/div/div/div/ul/li[1]/a"));
	JavascriptExecutor tred = (JavascriptExecutor) driver;
	tred.executeScript("arguments[0].click();", treading);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,250)", "");
	   
	  Thread.sleep(3000);

}

@When("User click on filter by price criteria")
public void user_click_on_filter_by_price_criteria() throws Exception {
//	WebElement Relevance=driver.findElement(By.xpath("//*[@id='sorter']/li[1]/a/span"));
//	JavascriptExecutor rev = (JavascriptExecutor) driver;
//	rev.executeScript("arguments[0].click();", Relevance);
//	
	
	//Relevance.click();
	
	WebElement Lowtohigh=driver.findElement(By.xpath("//*[@id='sorter']/li[2]/a"));
	JavascriptExecutor low = (JavascriptExecutor) driver;
	low.executeScript("arguments[0].click();", Lowtohigh);
	Thread.sleep(2000);
	WebElement Hightolow=driver.findElement(By.xpath("//*[@id='sorter']/li[3]/a"));
	JavascriptExecutor high = (JavascriptExecutor) driver;
	high.executeScript("arguments[0].click();", Hightolow);
	Thread.sleep(2000);
}



@When("User opened with treading url {string}")
public void user_opened_with_treading_url(String url) throws Exception {
	
productListingObject.validationofTrandingUrl(url);

}


@Then("Size of filter by category should be {int}")
public void size_of_filter_by_category_should_be(int filtercount) {
	
	List <WebElement> filterbyList1 =driver.findElements(By.xpath("//dl[@id='narrow-by-list']/div/dt"));

	Assert.assertEquals(filtercount, filterbyList1.size());
	
    logger.info("validate the Size of filter by category, size is: "+ filterbyList1.size());
 	   scn.log("validate the Size of filter by category, size is: "+ filterbyList1.size());

}

//=========================================@plpexpressdelivery================================

@When("User click on express delivery")
public void user_click_on_express_delivery() throws Exception {

	productListingObject.clickOnexpressdelivery();
	

}



@Then("User are able to see the ship fast product listing page")
public void user_are_able_to_see_the_ship_fast_product_listing_page() {

	 homePageObject.capturePassScreenshot(scn);
}



//=========================================@plpwishlisticon================================

@When("User click on wishlist icon on plp")
public void user_click_on_wishlist_icon_on_plp() throws Exception {
	
	List<WebElement> wishlistprod = driver.findElements(By.xpath("//a[starts-with(@id,\"wish_\")]"));
	wishlistprod.get(0).click();
	Thread.sleep(3000);
//	wishlistprod.get(1).click();
//	Thread.sleep(5000);
	
//WebElement wishlisticon =driver.findElement(By.xpath("//a[@id='wish_44236']"));
//	wishlisticon.click();
//	Thread.sleep(5000);
}



@Then("User are able to see the login popup")
public void user_are_able_to_see_the_login_popup() {

homePageObject.capturePassScreenshot(scn);
}





//================================ @plpmetalcolourchange ==============================




@When("User scroll down")
public void user_scroll_down() {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,500)", "");


}


@When("User select the any product")
public void user_select_the_any_product() {
List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
	
firstProd.get(1).getText();

WebElement bg =driver.findElement(By.xpath("//*[@id='amasty-shopby-product-list']/div[2]/ol/li[3]/div[2]/div/div[1]/div/div[2]/div[2]/a[2]"));

Actions act=new Actions(driver);
act.moveToElement(bg).build().perform();
bg.click();

}

@Then("User click on change background like gold and rosegold")
public void user_click_on_change_background_like_gold_and_rosegold() throws Exception {
	WebElement bgcolour =driver.findElement(By.xpath("//*[@id='amasty-shopby-product-list']/div[2]/ol/li[3]/div[2]/div/div[1]/div/div[2]/div[2]/a[2]"));
	bgcolour.click();
	Thread.sleep(3000);
	homePageObject.capturePassScreenshot(scn);
}

//===================================================@plpFilterBySingleSelect=====================================


@When("User are able to filter by material type diamond")
public void user_are_able_to_filter_by_material_type_daiamond() throws Exception {

	
	productListingObject.FilterByMaterialType();
}


@Then("User see the Currently Shopping by filter")
public void user_see_the_currently_shopping_by_filter() throws Exception {
	Thread.sleep(5000);
homePageObject.capturePassScreenshot(scn);

WebElement clearall=driver.findElement(By.xpath("//*[@id='am-shopby-container']/ol/li[2]"));
clearall.click();

homePageObject.capturePassScreenshot(scn);

}

//=======================================@plpFilterByMultiSelect========================

@When("User are able to filter by material type  and shop for pendants as per choice")
public void user_are_able_to_filter_by_material_type_and_shop_for_pendants_as_per_choice() throws Exception {
productListingObject.FilterByMaterialType();

Thread.sleep(3000);

productListingObject.FilterByShopFor();
Thread.sleep(2000);

}

@Then("User see the Currently Shopping by filter and clear all")
public void user_see_the_currently_shopping_by_filter_and_clear_all() {
	WebElement clearall=driver.findElement(By.xpath("//*[@id='am-shopby-container']/ol/li[3]"));

	clearall.click();
	//Thread.sleep(2000);

	homePageObject.capturePassScreenshot(scn);
}

//===================================================PDP Page==============================================================

@When("User mousehover on Ring option")
public void user_mousehover_on_ring_option() {
    productDescObject.mouseOverringValidation();
}


@When("User see the various ringsubcatagory on screen")
public void user_see_the_various_ringsubcatagory_on_screen(List<String> ringsubcategory) {
    
	productDescObject.subCategoryringValidation(ringsubcategory);
	
}


@When("User select Shop by Material Diamond and click on it")
public void user_select_shop_by_material_diamond_and_click_on_it() {
	WebElement diamond = driver.findElement(By.xpath("//a[@href='https://www.candere.com/jewellery/diamond-rings.html'][normalize-space()='Diamond']")); 
	diamond.click();
	logger.info("Various types of diamond ring is display");
	 scn.log("Various types of diamond ring is display");
}
@When("Product listing page is displayed")
public void product_listing_page_is_displayed() {

productDescObject.productListPageTitleValidation();
}
@When("User click on any of the product")
public void user_click_on_any_of_the_product() {

	List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
	// But as this step asks click on any link, we can choose to click on Index 0 of
	// the list
	firstProd.get(2).click();
//firstProd.get(0).getText();

	logger.info("Product description page is display");
	scn.log("User clicked on a product");
}
@Then("Product Description is displayed in new tab")
public void product_description_is_displayed_in_new_tab() {
   productDescObject.productdescPageValidation();
   homePageObject.capturePassScreenshot(scn);
}

//===========================@pdpPagevideobutton===============================


@When("User mouse over on metal-video-thumbnail")
public void user_mouse_over_on_metal_video_thumbnail() throws Exception {
	
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,300)", "");
	
	WebElement ring=driver.findElement(By.xpath("//img[@class='metal-video-thumbnail']"));
	Actions act=new Actions(driver);
	act.moveToElement(ring).build().perform();
	
	Thread.sleep(1000);

}

@Then("User are able to see xzoom-thumbs slick-initialized slick-slider slick-vertical is working properly")
public void user_are_able_to_see_xzoom_thumbs_slick_initialized_slick_slider_slick_vertical_is_working_properly() throws Exception {


	WebElement next=driver.findElement(By.xpath("//button[@aria-disabled='false']"));
	next.click();
	//Thread.sleep(1000);
	
//	WebElement Previous=driver.findElement(By.xpath("//button[@class='slick-prev slick-arrow slick-disabled']"));
//	Previous.click();
	
	Thread.sleep(1000);
}


//=================================@pdpTryON=================================

@Then("User scroll down and check the functionality of TryON")
public void user_scroll_down_and_check_the_functionality_of_try_on() throws Exception {

	productDescObject.ClickOnTryON();
	homePageObject.capturePassScreenshot(scn);
	
}






//=================================@pdpPageNotifyMe=================================




@When("User click on any product type earring")
public void user_click_on_any_product_type_earring() {
	List<WebElement> firstProd = driver.findElements(By.xpath("//ol[@class=\"products list items product-items\"]//li//div"));
	firstProd.get(0).click();
	logger.info("Product description page is display");
	scn.log("User clicked on a product");
}

@When("User click on EXPLORE DGRP functionality")
public void user_click_on_explore_dgrp_functionality() {
	WebElement exploredgrp =driver.findElement(By.xpath("//span[@class='view_details show_priceBreakup explore_dgrp']"));
	exploredgrp.click();
}
@When("User checks the PLANS and TERMS & CONDITIONS")
public void user_checks_the_plans_and_terms_conditions() {
	WebElement plans =driver.findElement(By.xpath("//div[@class='grrp_tab_item']"));
	plans.click();
	
	homePageObject.capturePassScreenshot(scn);
	
}
@When("Close the EXPLORE DGRP window")
public void close_the_explore_dgrp_window() throws Exception {
	WebElement close =driver.findElement(By.xpath("//div[@id='popupcloseBTN']//img[@alt='close']"));
	close.click();
	
	Thread.sleep(2000);
}
@When("After that User click on Notify me when Price Drop")
public void after_that_user_click_on_notify_me_when_price_drop() throws Exception {
	WebElement NotifyMe =driver.findElement(By.xpath("//a[normalize-space()='Notify me']"));
	NotifyMe.click();
	Thread.sleep(2000);
}
@When("User enters  {string}  and  {string}")
public void user_enters_and1(String EmailId, String MobileNO) {
	WebElement Emailid =driver.findElement(By.xpath("//div[@class='input_group_ mb_25_']//input[@name='email']"));
	Emailid.sendKeys(EmailId);
	//Thread.sleep(3000);
	WebElement Mobile =driver.findElement(By.xpath("//input[@name='telephone']"));
	Mobile.sendKeys(MobileNO);
}
@When("User click on Notify me")
public void user_click_on_notify_me() {
	WebElement NotifyMe1 =driver.findElement(By.xpath("//a[@id='notifyme_submit']"));
	NotifyMe1.click();
}
@Then("User see the Thank U messagepopup and click on ok button")
public void user_see_the_thank_u_messagepopup_and_click_on_ok_button() {
    homePageObject.capturePassScreenshot(scn);
}

//===========================================@pdpPageViewDetails==============================================


@When("User click on View Details")
public void user_click_on_view_details() throws Exception {
	

productDescObject.ClickOnViewDetails();

}



//=====================================================

@When("User select the ring size")
public void user_select_the_ring_size() {
	
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,250)", "");
	
	WebElement ringsizedropdown =driver.findElement(By.xpath("//select[@id='mt_size']"));
	Select size=new Select(ringsizedropdown);
	size.selectByValue("25");

}

@When("User enters {string} and click on Check button")
public void user_enters_and_click_on_check_button(String pincode) throws Exception {
	WebElement pin = driver.findElement(By.xpath("//input[@id='eedpincode']"));
	pin.sendKeys(pincode);	
	WebElement checkbutton = driver.findElement(By.xpath("//input[@id='check-eed']"));
	checkbutton.click();
	Thread.sleep(3000);
}
@When("User see the Expected Delivery Date")
public void user_see_the_expected_delivery_date() {
	WebElement e=driver.findElement(By.xpath("//span[@class='productDeliveryDateMsg edd']"));  
	 String s1 = e.getText();
	 scn.log(s1);
    System.out.println("Alert text is: " + s1); 
  
}

@When("User click on add to cart and see the cart page")
public void user_click_on_add_to_cart_and_see_the_cart_page()  {
	WebElement addtocart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
	addtocart.click();
	
	String cartPageTitle= "Shopping Cart";
	WebDriverWait wait = new WebDriverWait(driver, 30);
	boolean p =wait.until(ExpectedConditions.titleIs(cartPageTitle));
	Assert.assertEquals(true, p);
	logger.info("Validate product list page with its title, title is: "+ cartPageTitle);
	scn.log("navigate to product list page , page title is: "+ cartPageTitle);

	scn.log("Add to cart button is displayed");
    logger.info("Add to cart button is displayed");
}

//================================




@Then("User are able to see the select the shipfast")
public void user_are_able_to_see_the_select_the_shipfast() throws Exception {
	
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,150)", "");
	WebElement shipfast = driver.findElement(By.xpath("//*[@id='fs_two_selections']/div[2]/div"));
	shipfast .click();
	Thread.sleep(3000);
	
}


//======================================= @pdpPageCustomization=================



@When("User scroll down and click on Customize this product")
public void user_scroll_down_and_click_on_customize_this_product() throws Exception {

	productDescObject.ClickOnCustomizeproduct();

}

@When("User are able to change the Metal Color,purity and quality")
public void user_are_able_to_change_the_metal_color_purity_and_quality() throws Exception {
   productDescObject.ChangeMetalcolourpurityqty();
}
@When("User scroll up and check price are getting updated")
public void user_scroll_up_and_check_price_are_getting_updated() throws InterruptedException {
	js= (JavascriptExecutor)driver;

	js.executeScript("window.scrollBy(0,-400)", "");
	
	Thread.sleep(3000);
	
	signUpPageObject.validationtakescreenshot(scn);
	
}


@When("User click on Price breakup link")
public void user_click_on_price_breakup_link() throws Exception {

productDescObject.ClickOnPriceBreakup();

//signUpPageObject.validationtakescreenshot(scn);

}

@When("User scroll down to view detail")
public void user_scroll_down_to_view_detail() throws Exception {
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,350)", "");
	
	Thread.sleep(3000);
	
signUpPageObject.validationtakescreenshot(scn);

}
@When("User click on Metal details and diamond Details")
public void user_click_on_metal_details_and_product_details() throws Exception {

	productDescObject.ClickOnMetaldetails();
	
	signUpPageObject.validationtakescreenshot(scn);
	
	productDescObject.ClickOnDiamonddetails();
	
	signUpPageObject.validationtakescreenshot(scn);
	
}
@Then("User go back to up")
public void user_go_back_to_up() throws Exception {
	WebElement back =driver.findElement(By.xpath("//a[@id='back-to-top']"));
	back.click();
	Thread.sleep(3000);
}




@When("User click on Speak and Chat with experts link")
public void user_click_on_speak_and_chat_with_experts_link() throws Exception {
	WebElement chat =driver.findElement(By.xpath("//a[@title='Chat with Experts']//span[@class='iconBlock']"));
	chat.click();
	Thread.sleep(3000);
}


@Then("User are able to see the Share on WhatsApp page")
public void user_are_able_to_see_the_share_on_whats_app_page() {
    signUpPageObject.validationtakescreenshot(scn);
}



@When("User click on add Engraveing")
public void user_click_on_add_engraveing() throws Exception {
   
	productDescObject.ClickOnAddEngraveing();
}

@When("User choose Choose a font")
public void user_choose_choose_a_font() {
	WebElement font =driver.findElement(By.xpath("//a[@class='engrave-style2 engrv']"));
	font.click();

}
@When("Enter Inner Engraving text as per your wish and click on save")
public void enter_inner_engraving_text_as_per_your_wish_and_click_on_save() {
	WebElement innertext =driver.findElement(By.xpath("//input[@placeholder='Enter Engraving Text']"));
	innertext .sendKeys("Shravani");
	

}
@Then("User are able to see the Engrave test added successfully")
public void user_are_able_to_see_the_engrave_test_added_successfully() throws Exception {
//	WebElement save =driver.findElement(By.xpath("//button[normalize-space()='Save']"));
//	save.click();
//	
Thread.sleep(3000);
	
	signUpPageObject.validationtakescreenshot(scn);

}






















//================================PDP Wishlist==============


@When("User click on wishlist icon login signup pop is open")
public void user_click_on_wishlist_icon_login_signup_pop_is_open() throws Exception {
	Thread.sleep(3000);
	WebElement wishlistpdp = driver.findElement(By.xpath("//a[@id='wish_1489']"));


	
	JavascriptExecutor w = (JavascriptExecutor) driver;
	w.executeScript("arguments[0].click();", wishlistpdp );
}


@When("User successfully add this item into wishlist and click on wishlist icon")
public void user_successfully_add_this_item_into_wishlist_and_click_on_wishlist_icon() throws Exception {
//

	Thread.sleep(10000);
	//headerObject.ClickOnWishlist();
	WebElement wishlisticon = driver.findElement(By.xpath("//div[@class='link_items link wishlist']/a"));
	JavascriptExecutor w1 = (JavascriptExecutor) driver;
	w1.executeScript("arguments[0].click();", wishlisticon );
	
	Thread.sleep(5000);
	
}
@Then("User are able to see the product successfully added to wishlist")
public void user_are_able_to_see_the_product_successfully_added_to_wishlist() {

signUpPageObject.validationtakescreenshot(scn);
}



//===========================cart===================================================


@When("On cart page user is able to change the product qty and and size")
public void on_cart_page_user_is_able_to_change_the_product_qty_and_and_size() throws Exception {

cartobject.SelectProdQtyandSize();

}



@Then("User are able to see the price updated when the size and quantity changes")
public void user_are_able_to_see_the_price_updated_when_the_size_and_quantity_changes() {
   signUpPageObject.validationtakescreenshot(scn);
}


@When("user click on checkout logIn pop is open")
public void user_click_on_checkout_log_in_pop_is_open() throws Exception {
	productDescObject.ClickOnCheckoutSecurely();
	homePageObject.capturePassScreenshot(scn);
}

//==================================================@cartPagecheckout2==============

@When("User search for {string}")
public void user_search_for(String prodName) throws Exception {
	homePageObject.searchProduct(prodName);
     Thread.sleep(3000);
}

@When("choose to buy the first item")
public void choose_to_buy_the_first_item() throws Exception {
	
cartobject.ChoosetheProduct();

}
@When("Add product to shopping cart")
public void add_product_to_shopping_cart() throws InterruptedException {

	
	productDescObject.ClickOnAddToCart();

}
@When("User clicks on continue shopping")
public void user_clicks_on_continue_shopping() throws Exception {

	cartobject.clickOnContinueShopping();
}
@When("User clicks on My shopping bag and view shopping bag")
public void user_clicks_on_my_shopping_bag_and_view_shopping_bag() throws Exception {

	
	cartobject.clickOnShoppingBag();

}
@When("Click on proceed to check out")
public void click_on_proceed_to_check_out() throws InterruptedException {

	productDescObject.ClickOnCheckoutSecurely();
	
}
@Then("User should be asked to login before checkout")
public void user_should_be_asked_to_login_before_checkout() throws Exception {


	cartobject.ValidateTitleOfCartPage();
	homePageObject.capturePassScreenshot(scn);

}
//=============================@cartPageRemove====================



@When("User are able to remove the item on cart page")
public void user_are_able_to_remove_the_item_on_cart_page() throws Exception {
	
	
	WebElement remove= driver.findElement(By.xpath("//a[@title='Remove item']"));
	remove.click();
	Thread.sleep(2000);
}


@When("User are able to see the popup Do you want to remove this product from Cart ?")
public void user_are_able_to_see_the_popup_do_you_want_to_remove_this_product_from_cart() {
	
	homePageObject.capturePassScreenshot(scn);
}
@When("User clicks on OK buttton")
public void user_clicks_on_ok_buttton() {

	WebElement ok= driver.findElement(By.xpath("//button[@class='action-primary action-accept']"));
	ok.click();
	
	
}
@Then("User are able to redirecting to checkout cart page with empty cart")
public void user_are_able_to_redirecting_to_checkout_cart_page_with_empty_cart() {

	
cartobject.ValidateTitleOfCartPage();

}


//=================================== @cartPageInsurance===========================


@When("User are able to remove the insurance on cart page")
public void user_are_able_to_remove_the_insurance_on_cart_page() throws Exception {
	
	cartobject.SelectInsurance();

}

@Then("User are able to see the warning message")
public void user_are_able_to_see_the_warning_message() {

    String exp = "There is a higher risk if the jewellery is not insured";
    //identify actual error message
    WebElement m = driver.findElement(By.xpath("//div[normalize-space()='There is a higher risk if the jewellery is not insured']"));
    String act = m.getText();
    System.out.println("Insurance message is: "+ act);
    //verify error message with Assertion
    Assert.assertEquals(exp, act);
	
    logger.info("Validate the insurance_msg : "+ act);
	scn.log("The insurance_msg is: "+ act);

}


//===========================@cartPagecheckoffers=================================


@When("User click on check offers on cart page")
public void user_click_on_check_offers_on_cart_page() throws Exception {
	cartobject.clickOnCheckOffer();
}



@Then("User are able to see the Apply Offer Voucher popup on cart page")
public void user_are_able_to_see_the_apply_offer_voucher_popup_on_cart_page() {
	homePageObject.capturePassScreenshot(scn);
}

//================================ @cartPageManuallycheckoffers=======================


@When("First we delete the coupon that already applied")
public void first_we_delete_the_coupon_that_already_applied() throws Exception {
	WebElement removecheckoffer= driver.findElement(By.xpath("//a[@class='remove-coupon-code']//*[name()='svg']"));
	removecheckoffer.click();
	
	Thread.sleep(3000);
}


@When("Enter the {string}")
public void enter_the(String couponcode) throws Exception {
	WebElement  Voucher= driver.findElement(By.xpath("//input[@id='coupon_codes']"));
	 Voucher.sendKeys(couponcode);
	 Thread.sleep(2000);
	
}
@When("Click on apply")
public void click_on_apply() throws Exception {
	cartobject.clickOnApplyCheckOffer();
}
@Then("User are able to see the coupon applied successfully on cart page")
public void user_are_able_to_see_the_coupon_applied_successfully_on_cart_page() {

	
	String expM = "Applied Successfully";
    
    WebElement C = driver.findElement(By.xpath("//*[@id='coupon-apply']/div/p/span[4]"));
    String act1 = C.getText();
    System.out.println("Error message is: "+ act1);
    //verify error message with Assertion
    Assert.assertEquals(expM, act1);
	
    logger.info("Validate the insurance_msg : "+ act1);
	scn.log("The insurance_msg is: "+ act1);

}


@When("choose to buy the second item")
public void choose_to_buy_the_second_item() throws Exception {
cartobject.ChoosetheSecondProduct();
	
}



@When("Add this item to the cart")
public void add_this_item_to_the_cart() throws Exception {
	
	js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,600)", "");
	

	productDescObject.ClickOnAddToCart();
}



@When("User Click on proceed to check out")
public void user_click_on_proceed_to_check_out() throws InterruptedException {

	productDescObject.ClickOnCheckoutSecurely();
}


@Then("User see product in cart")
public void user_see_product_in_cart() {
  homePageObject.capturePassScreenshot(scn);
}


//=============================================@addresspageAddnewaddress================================================

@When("Click on Add New button")
public void click_on_add_new_button() {

shippingobject.clickOnAddNew();
}


@When("Enter the new details {string}  and  {string} and {string} and {string}")
public void enter_the_new_details_and_and_and(String lastname11, String mobile11, String zip11, String flat11) throws Exception {

	shippingobject.AddNewAddressDetails(lastname11, mobile11, zip11, flat11);

}






@When("Click on SHIP TO SAME ADDRESS")
public void click_on_ship_to_same_address() throws Exception {
	
//	Thread.sleep(3000);	
shippingobject.clickOnShipToSameAddress();
	
}


@Then("Fill all details {string}  and  {string} and {string} and {string}  and  click on continue")
public void fill_all_details_and_and_and_and_click_on_continue(String lastname1, String mobile1, String zip1, String flat1) throws Exception {

	
	shippingobject.AddNewShippingAddress(lastname1, mobile1, zip1, flat1);
	
	shippingobject.clickOnContinue();
}

//=========================== @addresspageEditOrder============================

@When("User click on edit order")
public void user_click_on_edit_order() throws Exception {
	shippingobject.clickOnEditOrder();
	
	
}

//==============================@addresspageSHIPTONEARBYStore=====================================================


@When("Click on SHIP TO NEARBY CANDERE\\/KALYAN STORE")
public void click_on_ship_to_nearby_candere_kalyan_store() {
	
	shippingobject.clickOnShipToNearbyStore();
	
}



@When("User enter {string} and click on submit")
public void user_enter_and_click_on_submit(String pincode) {
	WebElement Pin =driver.findElement(By.xpath("//*[@id='shipping-custompostcode']"));
	Pin.sendKeys(pincode);
	
	WebElement submit =driver.findElement(By.xpath("//*[@id='shipping-pincode-submit']"));
	submit.click();
}
@When("User select the store address")
public void user_select_the_store_address() throws Exception {
	WebElement storeaddress =driver.findElement(By.xpath("//*[@id='store-locations']/ul/li[2]/div[2]/div/label"));
	storeaddress.click();
	
	Thread.sleep(5000);

}
@Then("User are able to see the shipping address change or not")
public void user_are_able_to_see_the_shipping_address_change_or_not() throws Exception {

	shippingobject.clickOnContinue();
	
}

//==================================================


@When("Click on Ship to this address checkbox")
public void click_on_ship_to_this_address_checkbox() {

	shippingobject.clickOnShipCheckbox();	
}

@When("User click on continue on shipping page")
public void user_click_on_continue_on_shipping_page() throws Exception {

shippingobject.clickOnContinue();
}
@Then("User are able to see the selected shipping address on payment page")
public void user_are_able_to_see_the_selected_shipping_address_on_payment_page() {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,500)", "");
	
	signUpPageObject.validationtakescreenshot(scn);
}



@Then("User are able to see the page redirected to the cart page")
public void user_are_able_to_see_the_page_redirected_to_the_cart_page() {

productDescObject.CartPageTitleValidation();

signUpPageObject.validationtakescreenshot(scn);
}





//======================================orderjourney -@e2esignupcheckout===========================


@When("User search for the  {string}")
public void user_search_for_the(String prodName) {
	homePageObject.searchProduct(prodName);
}


@When("choose to buy the first item in list")
public void choose_to_buy_the_first_item_in_list() throws Exception {
	List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
	// But as this step asks click on any link, we can choose to click on Index 0 of
	// the list
	firstProd.get(1).click();
	 Thread.sleep(3000);
	logger.info("Product description page is display");
	scn.log("User clicked on a product");
	
	Set<String> handles = driver.getWindowHandles(); // get all the open windows
	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
	String original = it.next();// gives the parent window id
	String prodDescp = it.next();// gives the child window id

	driver.switchTo().window(prodDescp);
}
@When("Add first product to the shopping cart")
public void add_first_product_to_the_shopping_cart() throws Exception {
	WebElement addtocart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
	addtocart.click();
	
	scn.log("Add to cart button is displayed");
logger.info("Add to cart button is displayed");
	Thread.sleep(10000);
}
@When("User click on Checkout Securely")
public void user_click_on_checkout_securely() throws Exception {

WebElement checkoutSecurely =new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Checkout Securely'])[1]")));

JavascriptExecutor js1 = (JavascriptExecutor) driver;
js1.executeScript("arguments[0].click();", checkoutSecurely );
scn.log("Checkout Securely button is displayed");
logger.info("Checkout Securely button is displayed");
	

}
@When("User are able to see the signup and login popup and click on signup")
public void user_are_able_to_see_the_signup_and_login_popup_and_click_on_signup() {
	WebElement  signupcheckout = driver.findElement(By.xpath("//span[normalize-space()='Sign up']"));
	 signupcheckout.click();
	 
}
@When("Shipping page is open then user fill all details {string}  and  {string} and {string} and {string}  and  click on continue")
public void shipping_page_is_open_then_user_fill_all_details_and_and_and_and_click_on_continue(String lastname, String mobile, String zip, String flat ) throws Exception {

shippingobject.AddNewShippingAddressDetails(lastname, mobile, zip, flat);

}
	

@When("Click on Add new")
public void click_on_add_new() {

	shippingobject.clickOnAddNew();

}



	
	

//=============UPI MODE===============================================
@When("User see the payment page and click on UPI")
public void user_see_the_payment_page_and_click_on_upi() throws Exception {

	shippingobject.clickOnContinue();
	
	Thread.sleep(8000);
	
	paymentobject.clickOnUPI();
	
}
@When("User enter {string} and click on placeorder")
public void user_enter_and_click_on_placeorder(String UPIId) throws Exception {
	WebElement UPIID = driver.findElement(By.xpath("//input[@id='vpa']"));
	UPIID.sendKeys(UPIId);
	
}
@Then("User see the cander Justpay page")
public void user_see_the_cander_justpay_page() throws Exception {

	paymentobject.clickOnPlaceorder();
	Thread.sleep(25000);
	homePageObject.capturePassScreenshot(scn);
}






//=====================================



@When("User click on product type Chain")
public void user_click_on_product_type_necklace() throws Exception {
	Thread.sleep(2000);
	WebElement chains = driver.findElement(By.xpath("//*[@id=\"store.links\"]/nav/div/div/div/div/ul/li[8]/a"));
	

	JavascriptExecutor chainprod = (JavascriptExecutor) driver;
	chainprod.executeScript("arguments[0].click();",chains  );
	//Thread.sleep(3000);

}


@When("User choose to buy the first item")
public void user_choose_to_buy_the_first_item() throws Exception {

	
	productListingObject.chooseToBuyProduct();
	
	
}
@When("Product Desc is displayed in new tab")
public void product_desc_is_displayed_in_new_tab() {
	
	productDescObject.switchToNewWindow();
	
}
@When("User click on add to cart")
public void user_click_on_add_to_cart() throws Exception {


	productDescObject.ClickOnAddToCart();
}
@When("User click on Checkout Securely button")
public void user_click_on_checkout_securely_button() {
	
	productDescObject.ClickOnCheckoutSecurely();
}
@When("User click on  continue and payment page is open")
public void user_click_on_continue_and_payment_page_is_open() throws Exception {
	shippingobject.clickOnContinue();
	Thread.sleep(8000);
}

//=================================CreditDebit MODE================================================ 

@When("Click on Checkout Securely")
public void click_on_checkout_securely() {

	
	productDescObject.ClickOnCheckoutSecurely();
		
}


@When("User select the payment method CreditDebit Card")
public void user_select_the_payment_method_credit_debit_card() throws Exception {

	
	
  shippingobject.clickOnContinue();
	
	Thread.sleep(8000);
	
	paymentobject.clickOnCreditDebitCard();
	
	
	
}
@When("User enter {string} and {string}  and  {string}  and  {string}  and  {string} click on placeorder")
public void user_enter_and_and_and_and_click_on_placeorder(String CardNumber, String NameOnCard, String CVV , String ExpiryYear,String ExpiryMonth ) {

	paymentobject.EnterCreditCartDetails(CardNumber, NameOnCard, CVV, ExpiryYear, ExpiryMonth);
	
	
	

	
	
}
@Then("User see the cander razorpay page")
public void user_see_the_cander_razorpay_page() throws Exception {
	WebElement Placeorder = driver.findElement(By.xpath("//div[@class='payment-method _active']//button[@type='submit']"));
	Placeorder.click();

	//paymentobject.clickOnPlaceorder();
	Thread.sleep(50000);
	homePageObject.capturePassScreenshot(scn);
	
	

}


@When("User mouseover to my account and click on my order")
public void user_mouseover_to_my_account_and_click_on_my_order() throws InterruptedException {
	
	Thread.sleep(3000);
	WebElement bg =driver.findElement(By.xpath("//div[@class='actions-custom']//img[@alt='user']"));
	Actions act=new Actions(driver);
	act.moveToElement(bg).build().perform();
	Thread.sleep(3000);
	WebElement myorder =driver.findElement(By.xpath("//span[normalize-space()='My Orders']"));
	myorder.click();
	
}




@When("Click on view details and scroll down")
public void click_on_view_details_and_scroll_down() throws Exception {
	WebElement viewdetails =driver.findElement(By.xpath("//a[normalize-space()='View Details']"));
	viewdetails.click();
	
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,450)", "");
	 
	
	
}
@Then("Go back to my orders")
public void go_back_to_my_orders() {
	WebElement gobackmyorder =driver.findElement(By.xpath("//span[normalize-space()='Back to My Orders']"));
	gobackmyorder.click();
	
	homePageObject.capturePassScreenshot(scn);
}


//========================Netabanking======================


@When("User see the payment page and click on NetBanking")
public void user_see_the_payment_page_and_click_on_net_banking() throws Exception {


shippingobject.clickOnContinue();
	
	Thread.sleep(8000);
	
	paymentobject.clickOnNetbanking();
	
}


@When("Select the bank as per there choice")
public void select_the_bank_as_per_there_choice() {

	paymentobject.SelectBankDropDown();
	

}
@Then("User click on place order and see the bank page")
public void user_click_on_place_order_and_see_the_bank_page() throws Exception {
	WebElement Placeorder = driver.findElement(By.xpath("//div[@class='payment-method _active']//button[@type='submit']"));
	Placeorder.click();
	
	Thread.sleep(15000);
	
	homePageObject.capturePassScreenshot(scn);
}


//===========================dgrp=========================



@When("User click on continue button on shipping page")
public void user_click_on_continue_button_on_shipping_page() throws Exception {

	//paymentobject.Scrollup();
	
paymentobject.clickOnContinue();

Thread.sleep(2000);
}




@When("User see the payment page and click on DGRP")
public void user_see_the_payment_page_and_click_on_dgrp() throws Exception {

	Thread.sleep(2000); 
	paymentobject.clickOnDGRP();
	
	//Thread.sleep(8000);
}


@When("Select the No. of installments in months")
public void select_the_no_of_installments_in_months() throws Exception {
	Thread.sleep(3000);
paymentobject.SelectNoOfInstallment();
Thread.sleep(3000);

paymentobject.Scrolldown();
Thread.sleep(2000);
paymentobject.clickOnPlaceorder();
Thread.sleep(3000);

}
@When("Clikc on accept DGRP Terms and Conditions and click on pay now")
public void clikc_on_accept_dgrp_terms_and_conditions_and_click_on_pay_now() throws Exception {
	Thread.sleep(2000);
	WebElement terms = driver.findElement(By.xpath("//*[@id='emi_terms-condition']/div[2]/div[1]/label/div/span"));
	terms.click();
	Thread.sleep(2000);
	WebElement paynow = driver.findElement(By.xpath("//div[@id='emi_terms-condition']//button[1]"));
	paynow.click();
	
}
@When("User select the payment method as UPI")
public void user_select_the_payment_method_as_upi() throws Exception {
	Thread.sleep(1000);
	 WebElement upi=driver.findElement(By.xpath("//div[@id='1000114']"));
	 upi.click();
	 Thread.sleep(1000);
	 WebElement upiid=driver.findElement(By.xpath("//input[@placeholder='Username@bankname']"));
	 upiid.sendKeys("anything@payu");
	 Thread.sleep(1000);
	 
}
@When("User click on pay now")
public void user_click_on_pay_now() throws Exception {
	Thread.sleep(2000);
	WebElement paynow1=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/div[1]"));
	paynow1.click();
	 
}


//=======================codpartial=====================


@When("User see the payment page and click on COD - Partia")
public void user_see_the_payment_page_and_click_on_cod_partia() throws Exception {
	Thread.sleep(5000);
paymentobject.clickOnCODPartial();
}


@When("User click on product type Mangalsutra")
public void user_click_on_product_type_Mangalsutra() {
	WebElement m = driver.findElement(By.xpath("//*[@id='store.links']/nav[1]/div/div/div/div/ul/li[7]/a"));
	m.click();

}


@When("Scroll down to the palce order")
public void scroll_down_to_the_palce_order() throws InterruptedException {
	
	Thread.sleep(2000);
	paymentobject.Scrolldown();
	
	WebElement Placeorder1 = driver.findElement(By.xpath("//*[@id='payment_form_']/div[2]/div/button"));
	Placeorder1.click();
	
	
	Thread.sleep(5000);

    
}
//====================================view wallet===================================


@When("User Click on view wallet")
public void user_click_on_view_wallet() {
   paymentobject.clickViewDetails();
}

@When("Enter the amount")
public void enter_the_amount() {

WebElement amount =driver.findElement(By.xpath("//input[@id='wallet_amount']"));
amount .sendKeys("200");
}
@When("User click on apply")
public void user_click_on_apply() throws Exception {
	WebElement apply=driver.findElement(By.xpath("//a[@id='apply-wallet-ajax']"));
	apply.click();
	
	Thread.sleep(4000);

}
@When("User are able to see the Wallet amount applied successfully and show in order summery")
public void user_are_able_to_see_the_wallet_amount_applied_successfully_and_show_in_order_summery() {
    signUpPageObject.validationtakescreenshot(scn);
}

@When("User click on payment method UPI")
public void user_click_on_payment_method_upi() throws Exception {
	Thread.sleep(2000);
	paymentobject.clickOnUPI();
}






@When("User scroll down and click on change address")
public void user_scroll_down_and_click_on_change_address() throws Exception {
	Thread.sleep(2000);
	paymentobject.Scrolldown();
	
	WebElement changeaddress = driver.findElement(By.xpath("//span[normalize-space()='change address']"));
	changeaddress.click();
	
	
	Thread.sleep(5000);;
}








//===================================================


@When("User select the any ring as per choice")
public void user_select_the_any_ring_as_per_choice() throws Exception {
	List<WebElement> firstProd = driver.findElements(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[2]/ol/li"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,350)", "");

	firstProd.get(2).click();
	
	Set<String> handles = driver.getWindowHandles(); // get all the open windows
	Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
	String original = it.next();// gives the parent window id
	String prodDescp = it.next();// gives the child window id

	driver.switchTo().window(prodDescp); // switch to product Descp
	 Thread.sleep(3000);
	
}

//================================@MyAccount===================================================




@When("User mouseover to user icon")
public void user_mouseover_to_user_icon() throws Exception {
	Thread.sleep(2000);
	WebElement icon1 =driver.findElement(By.xpath("//div[@class='actions-custom']//img[@alt='user']"));
	Actions act=new Actions(driver);
	act.moveToElement(icon1).build().perform();
	
	Thread.sleep(2000);
}





@When("User click on my order")
public void user_click_on_my_order() throws Exception {



	WebElement myorder =driver.findElement(By.xpath("//span[normalize-space()='My Orders']"));
	myorder.click();
	 
Thread.sleep(2000);

}


@When("User see their account details and User validate all myaccountlink are clickable or not")
public void user_see_their_account_details_and_user_validate_all_myaccountlink_are_clickable_or_not() throws Exception {

Thread.sleep(2000);
	
myaccountObject.ClickOnMyWishlist();
	
Thread.sleep(2000);
myaccountObject.ClickOnAddressBook();
Thread.sleep(2000);

myaccountObject.ClickOnEkyc();
Thread.sleep(2000);
myaccountObject.ClickOnAccountInformation();
Thread.sleep(2000);
myaccountObject.ClickOnSavedCards();
Thread.sleep(2000);
myaccountObject.ClickOnChangePassword();
Thread.sleep(2000);
myaccountObject.ClickOnReferAndEarn();
Thread.sleep(2000);
myaccountObject.ClickOnMyWallet();
Thread.sleep(2000);
myaccountObject.ClickOnDigiGold();
Thread.sleep(2000);
myaccountObject.ClickOnEarnRewards();

}
@Then("Below my account Links are displayed")
public void below_my_account_links_are_displayed(List<String> list) throws Exception {
	
	for (int i=0;i<list.size();i++) {
		
		myaccountObject.validateElementPresentInMyAccountSection(list.get(i));
		
     // myaccountObject.clickLogout();
	}
}
//==========================----

@When("User click on My Wallet")
public void user_click_on_my_wallet() throws Exception {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,350)", "");
	
	 Thread.sleep(1000);
myaccountObject.ClickOnMyWallet();
Thread.sleep(4000);
}



@Then("User are able to see the Candere Wallet or Promotional Wallet amount are added or not")
public void user_are_able_to_see_the_candere_wallet_or_promotional_wallet_amount_are_added_or_not() throws Exception {

myaccountObject.clickPromotionalWallet();

Thread.sleep(3000);

myaccountObject.clickCandereWallet();

Thread.sleep(3000);
}

//================================================= @MyAccountmyWishList======================================



@When("User click on my wishlist")
public void user_click_on_my_wishlist() throws Exception {
	myaccountObject.ClickOnMyWishlist();
	
	Thread.sleep(2000);
}


@When("User click on continue shopping")
public void user_click_on_continue_shopping() {
    myaccountObject.ClickOnContinousShopping();
}
@When("User add item to wishlist")
public void user_add_item_to_wishlist() throws Exception {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,350)", "");
	
	List<WebElement> wishlistprod = driver.findElements(By.xpath("//a[@title='Add to Wish List']"));
	wishlistprod.get(1).click();
	Thread.sleep(5000);

		logger.info("Add product to wishlist");
		scn.log("Add product to wishlist");
		
		
		WebElement wishlisticon= driver.findElement(By.xpath("//a[@class='wishlist-custom-icon customer-login-link']//*[name()='svg']"));
		wishlisticon.click();
		
		 Thread.sleep(3000);

}
@When("User click on My Order")
public void user_click_on_my_order1() throws Exception {
	Thread.sleep(3000);
	myaccountObject.clickMyOrder();
}
@When("User click on move to bag")
public void user_click_on_move_to_bag() throws Exception {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,250)", "");

	WebElement movetobag= driver.findElement(By.xpath("//button[@type='button'][normalize-space()='move to bag']"));
	
	movetobag.click();
	Thread.sleep(3000);
}
@Then("User see the cart page")
public void user_see_the_cart_page() {

	String cartPageTitle="Shopping Cart";
	String actPageTitle= driver.getTitle();
	Assert.assertEquals(cartPageTitle, actPageTitle);
    logger.info("Validate title of page, title is:" + actPageTitle);
    scn.log("Title of the page is: "+ actPageTitle);

}

//==============================@MyAccountmyAddressBook=========================================




@When("User click on Address Book")
public void user_click_on_address_book() {

myaccountObject.ClickOnAddressBook();
}




@When("User fill all the details  {string}  and  {string} and {string} and {string}")
public void user_fill_all_the_details_and_and_and(String LName, String Streetaddress, String Postalcode, String PhoneNO) throws Exception {

	
//Thread.sleep(4000);
	
	WebElement LastName =driver.findElement(By.xpath("//*[@id='form-validate']/div/div[2]/div[1]/div[2]/input"));
	LastName.sendKeys(LName);
	
	WebElement StreetA =driver.findElement(By.xpath("//*[@id='form-validate']/div/div[2]/div[3]/div/input"));
	StreetA.sendKeys(Streetaddress);
	
	WebElement PostalCode =driver.findElement(By.xpath("//*[@id='form-validate']/div/div[2]/div[5]/div[1]/input"));
	PostalCode .sendKeys(Postalcode);
	
	Thread.sleep(4000);
	
	WebElement phone =driver.findElement(By.xpath("//*[@id='form-validate']/div/div[2]/div[6]/div[2]/input"));
	phone .sendKeys(PhoneNO );
	
	
	Thread.sleep(3000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(350,0)", "");


	

}
@When("User click on save address")
public void user_click_on_save_address() {
	WebElement saveaddress =driver.findElement(By.xpath("//*[@id='form-validate']/div/button"));
	saveaddress .click();
	
}
@Then("User see the address page")
public void user_see_the_address_page() {

	
	
	String AddressPageTitle="Address Book";
	String actPageTitle= driver.getTitle();
	Assert.assertEquals(AddressPageTitle, actPageTitle);
    logger.info("Validate title of page, title is:" + actPageTitle);
    scn.log("Title of the page is: "+ actPageTitle);

}

//============================== @MyAccountEarnReward========================================================

@When("User click on Refer And Earn")
public void user_click_on_refer_and_earn() {
   myaccountObject.ClickOnReferAndEarn();
}


@When("User click on copy link and click on ok")
public void user_click_on_copy_link_and_click_on_ok() {
	WebElement copyurl=driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div[1]/div[7]/section[2]/div/ul/li[1]/div/div/button"));
	copyurl .click();
	
	driver.switchTo().alert().accept();

}
@When("User click on logout")
public void user_click_on_logout() throws Exception {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,350)", "");
	 
	 myaccountObject.clickLogout();
	 Thread.sleep(3000);


}
@When("User open new the referal link")
public void user_open_new_the_referal_link() {
	  String nwtb = Keys.chord(Keys.CONTROL,Keys.ENTER);
	  
	  String originalHandle = driver.getWindowHandle();
      for (String handle : driver.getWindowHandles()) {
          if (!handle.equals(originalHandle)) {
              driver.switchTo().window(handle);
          
          break;
          }}
	  driver .get("https://www.candere.com/referee?c=sel0BxIM");
	  
}
@When("User sign up from that referal link")
public void user_sign_up_from_that_referal_link() throws Exception {

	WebElement signup=driver.findElement(By.xpath("//a[@id='referee_signup']"));
	signup .click();
	

}
@Then("User successfully redirect to my account")
public void user_successfully_redirect_to_my_account() throws Exception {
	
	Thread.sleep(10000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,350)", "");

	signUpPageObject.validationtakescreenshot(scn);
	

}


//=============================editprofile===================================================================



@When("User click on edit profile")
public void user_click_on_edit_profile() {

myaccountObject.ClickOnEditProfile();
}

@When("User are able to redirect to account information page and enter the lastname and mobile no and select gender")
public void user_are_able_to_redirect_to_account_information_page_and_enter_the_lastname_and_mobile_no() {
	WebElement LN=driver.findElement(By.xpath("//input[@id='lastname']"));
	LN.clear();
	
	LN .sendKeys("Wadhe");
	WebElement MN=driver.findElement(By.xpath("//input[@id='mob_number']"));
	MN.clear();
	MN .sendKeys("9232098421");
	
	WebElement gender = driver.findElement(By.xpath("//select[@id='gender']"));
	Select option = new Select(gender);
	option.selectByVisibleText("Kids");

}
@When("Select the birth date and anniversary date and Click on save profile then")
public void select_the_birth_date_and_anniversary_date_and_click_on_save_profile_then() {

	
	
	WebElement birthmonth = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
	Select monthCombo = new Select(birthmonth);
	monthCombo.selectByVisibleText("May");

	WebElement year = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
	Select yearCombo = new Select(year);
	yearCombo.selectByVisibleText("2000");



	
	

}
@Then("User are able to save there details.")
public void user_are_able_to_save_there_details() throws Exception {

	WebElement saveprofile=driver.findElement(By.xpath("//*[@id='form-validate']/div/div[1]/button"));
	saveprofile.click();
	Thread.sleep(3000);
	
	myaccountObject.clickLogout();

}


}






























