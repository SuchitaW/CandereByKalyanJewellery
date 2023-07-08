# CandereByKalyanJewellery

# Concepts Covered in the Framework.

These are the items that would be covered in this framework. 

Maven Dependency mangement - # Completed

Maven command line to pass browser info - #Completed

Maven Surefire to run test cases in Parallel - #Completed

Log 4j Implementation - Completed

Cucumber Feature Files - Completed

Cucumber Runner Files -  Completed

Cucumber Step Defs -Completed

Cucumber After and Before Hooks to launch and close browsers - Completed

Cucumber Scenario Interface - Completed

Cucumber Scenario Outline - Completed

Cucumber Use Scenario interface to capture screenshot - Completed

Cucumber Datatables -  Completed

Cucumber Background -  Completed

Cucumber But and And - Pending

Basic Selenium Operations - Completed

Selenium Multi tab implementation -  Completed

Selenium Test case with Actions Class use case -Completed

Selenium Page object Model -  Completed

Selenium Screen shot capturing -  Completed

Selenium Selenium Grid for multi-browser and multi platform execution -Pending

Selenium Webtable Handling - Pending

Selenium Complex Scenario Handling - Completed



# Steps to Do

1. Project Set Up

Create Maven project

Add 5 dependencies in pom as mentioned below:

Cucumber-jvm

Cucumber-junit

Cucumber-pico-container(for dependency injection)

Junit 4 Library

Selenium Library


<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

  <modelVersion>4.0.0</modelVersion>
  
  
  <groupId>CandereByKalyanJewellers-Framework</groupId>
  
  
  <artifactId>CandereByKalyanJewellers-Framework</artifactId>
  
  
  <version>0.0.1-SNAPSHOT</version>
  
  <properties>
    
        <cucumber.version>6.6.1</cucumber.version>
        
        <maven.compiler.source>1.8</maven.compiler.source>
        
        <maven.compiler.target>1.8</maven.compiler.target>
        
        </properties>
        
 <dependencies>
   
        <dependency>

        
            <groupId>io.cucumber</groupId>
            
            <artifactId>cucumber-java</artifactId>
            
            <version>${cucumber.version}</version>
            
            <scope>test</scope>
            
        </dependency>
        
        <dependency>
        
            <groupId>io.cucumber</groupId>
            
            <artifactId>cucumber-junit</artifactId>
            
            <version>${cucumber.version}</version>
            
            <scope>test</scope>
            
        </dependency>
        
 <dependency>
            <groupId>io.cucumber</groupId>

            <artifactId>cucumber-picocontainer</artifactd>
            
            <version>${cucumber.version}</version>
            
            <scope>test</scope>
        
        </dependency>
        
<dependency>
            <groupId>junit</groupId>
  
            <artifactId>junit</artifactId>
            
            <version>4.12</version>
            
            <scope>test</scope>
            
        </dependency>
<dependency>
  
            <groupId>org.seleniumhq.selenium</groupId>
            
            <artifactId>selenium-java</artifactId>
            
            <version>3.141.59</version>
            
        </dependency>

        <dependency>
        
            <groupId>org.apache.logging.log4j</groupId>
            
            <artifactId>log4j-api</artifactId>
            
            <version>2.13.1</version>
            
        </dependency>
        
        <dependency>
        
            <groupId>org.apache.logging.log4j</groupId>
            
            <artifactId>log4j-core</artifactId>
            
            <version>2.13.1</version>
            
        </dependency>
        
     
        <dependency>
        
    <groupId>io.github.bonigarcia</groupId>
    
    <artifactId>webdrivermanager</artifactId>
    
    <version>5.3.2</version>

</dependency>


<dependency>
  
	<groupId>tech.grasshopper</groupId>
 
	<artifactId>extentreports-cucumber6-adapter</artifactId>
 
	<version>2.8.0</version>
 
	<scope>test</scope>
 
		</dependency>

		<dependency>
  
			<groupId>org.testng</groupId>
   
			<artifactId>testng</artifactId>
   
			<version>6.14.3</version>
   
			<scope>test</scope>
   
		</dependency>

  
   </dependencies>

</project>
 


2. Add Feature File

Create a new feature file under test->resources-features package.

Add new Healthcheck feature as below:


# HomePage.feature- 

@healthCheck

Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
  
    Given User navigate to URL and open the landing page

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL

  @LandingPageTitle
  
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
  
    When User is on landing page
    
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @DisplayLogo
  
  Scenario: User able to see logo of application on landing page
  
    When User is on landing page
    
    Then User see the logo of application

  @LogoHeight
  
  Scenario: Logo present on landing page with specific height dimension
  
    When fetch the height of logo
    
    Then Height of logo should be "53"

  @LogoWidth
  
  Scenario: Logo present on landing page with specific width dimension
  
    When fetch the width of logo
    
    Then Width of logo should be "240"

  @HomePageHeaderLinks
  
  Scenario: Validate Header links
  
    When User validate all headerlink are clickable or not
    
    Then Below header Links are displayed
    
      | Order Tracking         |
      | Candere logo           |
      | Find Experience Center |
      | Contact Us             |
      | Blog                   |
      | User                   |
      | Wishlist               |
      | Bag                    |
      | search text box        |

  @Ordertracking
  
  Scenario Outline: Validate Ordertracking is working as excepted
  
    When User click on ordertracking
    
    And User enter "<orderid>"  and  "<emailaddress>"
    
    And User click on request info
    
    Then User opened with order tracking url "https://www.candere.com/ordertracking/ordertracking/index"

    Examples: 
      | orderid    | emailaddress              |
      | 1000556321 | suchita.tayde@candere.com |
      | 1000556336 | mohit.gupta@candere.com   |

  @ProductCategoryList
  
  Scenario: User able to see product category on landing page
  
    When User see the product category
    
    Then Validate product category as per expected product category listed below
    
      | Trending            |
      | Rings               |
      | Earrings            |
      | Pendants            |
      | Necklace            |
      | Bangles & Bracelets |
      | Mangalsutra         |
      | Chains              |
      | Solitaires          |
      | Other Jewellery     |
      | Gifts               |
      | Offers              |
      
    And Size of product category should be 12

  @ProductSubcategory
  
  Scenario: Validate all product links on landing page of the application
  
    When User mouseover to the Ring of the landing page of the application
    
    And User see view all designs link should be visible
    
    And User is able to see 4 sub categories
    
    Then The categories having the option "Shop by Style","Shop by Material","Shop for" and "Shop By Occasion"
    
    And Under Shop by Style category below options are visible
    
      | Engagement   |
      | Solitaire    |
      | Couple Bands |
      | Casual       |
      | Eternity     |
      | Classic      |
      | Three Stone  |
      | Navratna     |
      | Religious    |
      
    And Under Shop by Material category below options are visible
    
      | Diamond        |
      | Gold           |
      | Platinum       |
      | Gemstone       |
      | Swarovski / CZ |
      | Silver + Gold  |
      
    And Under Shop for category below options are visible
    
      | Women |
      | Men   |
      | Kids  |
      
    And Under Shop By Occasion category below options are visible
    
      | Daily wear     |
      | Casual outings |
      | Festive        |
      | Anniversary    |
      | Wedding        |

  @ProductCategoryOffers
  
  Scenario: Validate all offers products on landing page of the application
  
    When User mouseover to the Offers of the landing page of the application
    
    And User are able to see all the offer product and click on any offer
    
    Then User successfully redirected to product list page "Buy Solitaire Diamond Jewellery Online in India | Designs @ Best Price | Candere by Kalyan Jewellers"

  @Signup&Spin!
  
  Scenario: User able to see Sign up & Spin! on landing page
  
    When User scroll down to Sign up & Spin!
    
    And User click on Sign up & Spin button
    
    Then User are able to see the Sign Up form
    

  @ProductCategory
  
  Scenario: User able to see product category list on landing page
  
    When User see the product category on the landing page
    
    And Validate product category list as per expected product category listed below
    
      | Stunning Rings       |
      | Classy Earrings      |
      | Stylish Mangalsutras |
      | Elegant Necklaces    |
      | Gorgeous Bracelets   |
      | Dainty Pendants      |
      | Statement Chains     |
      
    And User click on any product
    
    Then The product list page is displayed

  @ShowMeMore
  
  Scenario: User able to see Show Me More  on landing page
  
    When User scroll down to Show Me More
    
    And User click on show me more
    
    Then User are able to see the more collection
  

  @SubscribeNow
  
  Scenario Outline: Validate SubscribeNow Functionality
  
    When User scroldown to the botton of the landing page of the application
    
    And User enters "<emailid>" and "<mobileno>"
    
    And User is click on subscribe now
    
    Then Subscribe now message is displayed

    Examples: 
    
      | emailid             | mobileno   |
      | saydgfgd1@yahoo.com | 9033687878 |

  @FooterLinksLists
  
  Scenario: Validate all footer links on landing page of the application
  
    When user scroldown to the botton of the landing page of the application

    And user is able to see 6 main options categories
    
    And the categories having the option "ABOUT US", "WHY CANDERE?", "EXPERIENCE CANDERE", "JEWELLERY GUIDES","CONTACT US" and "FOLLOW US"
    
    Then under ABOUT US category below options are visible
    
      | About Our Company    |
      | Terms and Conditions |
      | Privacy Policy       |
      | FAQ                  |
      | Offers T&Cs          |
      | Customer Reviews     |
      
    And under WHY CANDERE? category below options are visible
    
      | WHY CANDERE?        |
      | 15-Day Returns      |
      | Cancel & Refund     |
      | Lifetime Exchange   |
      | DGRP                |
      | Certified Jewellery |
      | Candere Wallet      |
      | Jewellery Insurance |
      
    And under EXPERIENCE CANDERE category below options are visible
    
      | Lookbook       |
      | Stylery Blog   |
      | Video Gallery  |
      | Order Tracking |
      | Virtual Try On |
      
    And under JEWELLERY GUIDES category below options are visible
    
      | Diamond Education  |
      | Gemstone Education |
      | Metal Education    |
      | Size Guide         |
      | Gold Rate Guide    |
      | Jewellery Care     |
      
    And under CONTACT US category below options are visible
    
      | CONTACT US               |
      | support@candere.com      |
      | Find Experience Centre   |
      | Kalyan Store Locator     |
      | Kalyan Jewellers Website |
      | Kalyan Stores            |
      

  @TwitterHandle
  
  Scenario: Validate twitter social media handle
  
    When User click on twitter link
    
    And navigate to twitter account page
    
    Then User opened with twitter url "https://twitter.com/i/flow/login"


#   Login.Feature

@healthCheck

Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
  
    Given User navigate to URL and open the landing page

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL

  @LandingPageTitle
  
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
  
    When User is on landing page
    
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @Account
  
  Scenario: User click on Your Account icon and navigate to respective page
  
    Given User see Your Account button
    
    When User click on Your Account button
    
    Then User is on Your Account page which have expected page title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @CreateAccount
  
  Scenario Outline: User is able to Create Account into the application

    When User see Your Account and click on  SignUp  from home page
    
    When User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
   
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    
    Then User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

    Examples: 
      | name      | emailid                | mobileno   |
      | Rdfddweg  | Hfejhg@gmail.com       | 9945786760 |
      | hjgksfder | wewqqFkjdd3e@gmail.com | 9978376456 |

  @login
  
  Scenario Outline: User is able to login into the application
  
    When User see Your Account and click on  Log In  from home page
    
    And User enters "<Emailid or mobileno>"
    
    And User click on continue button
    
    And User enter otp manually and click on login
    
    Then User successfully redirected to homepage "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

    Examples: 
      | Emailid or mobileno    |
      | suchitatayde@gmail.com |

  @Search
  
  Scenario: Validate doubleclicksearch is working
  
    When User doubleclick  in search box
    
    Then User see the popular search box is appear
    

  @Searchprod1
  
  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
  
    When User navigated to the home application url
    
    And User Search for product on search bar "ring"
    
    Then Search Result page is displayed with title contains "Gold & Diamond Ring Designs for Men & Women - Candere by Kalyan Jewellers"
   
 @Wishlist
 
  Scenario Outline: Validate if a registered user is able to add item to wishlist and place an order.
  
   When User see Your Account and click on  Log In  from home page
   
    And User enters "<Emailid or mobileno>"
    
    And User click on continue button
    
    And User enter otp manually and click on login
    
    Then User successfully redirected to homepage "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    
    When User search for "<product>"
    
    And Choose to add product to wishlist
    
    And Click on wishlist icon
    
    And Move this item to bag

    And Click on proceed to check out
    
    Then User click on continue payment page is display

    Examples: 
    
      | Emailid or mobileno       | product |
      | suchita.tayde@candere.com | Necklace |


# ProductListingPage.feature

@healthCheck

Feature: E-Commerce website healthcheck


  Background: Navigation to the URL
  
    Given User navigate to URL and open the landing page

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL
    

  @LandingPageTitle
  
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
  
    When User is on landing page
    
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @productlistpage
  
  Scenario: User able to see prodct type Earrings on landing page
  
    When User mousehover on Earring option
    
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    Then The product listing page is displayed

  @plpFilterBySingleSelect
  
  Scenario: User able to see Filter By product type on productlisting page
  
    When User click on pendants on landing page
    
    And User are able to filter by product type pendants as per choice
    
    Then User see the Currently Shopping by filter
    

  @plpFilterByMultiSelect
  
  Scenario: User able to see Filter By material type  and shop for on productlisting page
  
    When User click on pendants on landing page
    
    And User are able to filter by material type  and shop for pendants as per choice
    
    Then User see the Currently Shopping by filter and clear all
    

  @plpMoreFilter
  
  Scenario: User able to see Filter By MoreFiler on productlisting page
  
    When User click on pendants on landing page
    
    And User able to click on more filter
    
    And User select the any combination of product as per there choice
    
    Then User are able to see the combination of product
    

  @plpMoreFilterClearAll
  
  Scenario: User able to see Filter By MoreFiler on productlisting page
  
    When User click on pendants on landing page
    
    And User able to click on more filter
    
    And User select the any combination of product as per there choice
    Then User are able to ClearAll the filters
    

  @plpLoadMore
  
  Scenario: User able to see LoadMore  on productlisting page
  
    When User click on pendants on landing page
    
    And User scrolldown to the bootom of the page
    
    Then User click on load more button
    

  @plpFilterBy
  
  Scenario: User able to see Filter By on productlisting page
  
    When User click on treading on landing page
    
    And User opened with treading url "https://www.candere.com/trending/hot.html"
    
    And User click on filter by price criteria
    
    Then Size of filter by category should be 7

  @plpexpressdelivery
  
  Scenario: User able to see express delivery on landing page
  
    When User mousehover on Earring option
    
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    And The product listing page is displayed
    
    And User click on express delivery
    
    Then User are able to see the ship fast product listing page

  @plpmetalcolourchange
  
  Scenario: User able to change metalcolour on landing page
  
    When User mousehover on Earring option
    
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    And User mouse over to background colour
    
    Then User click on change background like gold and rosegold

  @plpwishlisticon
  
  Scenario: User able to see wishlist icon on product listing page for new user
  
    When User mousehover on Earring option
    
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    And User click on wishlist icon on plp
    
    Then User are able to see the login popup

  @PLPvideobutton
  
  Scenario: User able to see prodct type Earrings on landing page

    When User mousehover on Earring option
    
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    And User click on video-product-button
    
    Then video-product-button is working as per excepted

# ProductDescPage.feature

@healthCheck

Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
    Given User navigate to URL and open the landing page

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL
    

  @LandingPageTitle
  
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
  
    When User is on landing page
    
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @productdescpage
  
  Scenario: User able to see prodct type Earrings on landing page
  
    When User mousehover on Ring option
    
    And User see the various ringsubcatagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Diamond and click on it
    
    And Product listing page is displayed
    
    And User click on any of the product
    
    Then Product Description is displayed in new tab

  @pdpslick-listdraggable
  
  Scenario: User able to see xzoom-thumbs slick-initialized slick-slider slick-vertical on listing page
  
    When User mousehover on Ring option
    
    And User see the various ringsubcatagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Diamond and click on it
    
    And Product listing page is displayed
    
    And User click on any of the product
    
    And Product Description is displayed in new tab
    
    And User mouse over on metal-video-thumbnail
    
    Then User are able to see xzoom-thumbs slick-initialized slick-slider slick-vertical is working properly

  @pdpTryOnFunctionality
  
  Scenario Outline: Validate the functionality of TryON on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    Then User scroll down and check the functionality of TryON

    Examples: 
      | product |
      | Rings   |

  @pdpPageCustomization
  
  Scenario Outline: Validate the functionality of Customize this product on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And User click on Customize this product and change the Metal Color,purity and quality
    
    And User click on quality or purity the price are getting updated
    
    And User scroll down to you may also like
    
    Then User are able  to click the previous button

    Examples: 
      | product |
      | rings   |


  @pdpPageNotifyMe
  
  Scenario Outline: Validate the functionality of TryON on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And User click on EXPLORE DGRP functionality
    
    And User checks the PLANS and TERMS & CONDITIONS
    
    And Close the EXPLORE DGRP window
    
    And After that User click on Notify me when Price Drop
    
    And User enters  "<EmailId>"  and  "<MobileNO>"
    
    And User click on Notify me
    
    Then User see the Thank U messagepopup and click on ok button
    

    Examples: 
      | EmailId                | MobileNO   | product |
      | suchitatayde@yahoo.com | 9078723790 | Ring    |


  @pdpPageNotifyMe1
  
  Scenario Outline: User able to see prodct type Earrings on landing page
  
    When User mousehover on Earring option

  
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    And The product listing page is displayed
    
    And User click on any product type earring
    
    And Product Description is displayed in new tab
    
    And User click on EXPLORE DGRP functionality
    
    And User checks the PLANS and TERMS & CONDITIONS
    
    And Close the EXPLORE DGRP window
    
    And After that User click on Notify me when Price Drop

    And User enters  "<EmailId>"  and  "<MobileNO>"
    
    And User click on Notify me
    
    Then User see the Thank U messagepopup and click on ok button

    Examples: 
      | EmailId                | MobileNO   |
      | suchitatayde@yahoo.com | 9078723790 |


  @pdpPageViewDetails
  
  Scenario Outline: Validate the functionality of View Details on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And User click on View Details
    
    And User scroll down to view detail
    
    And User click on Metal details and Product Details
    
    Then User go back to up

    Examples: 
      | product |
      | Ring    |

  @pdpringsize
  
  Scenario Outline: Validate the functionality of View Details on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And User select the ring size
    
    And User enters "<Pincode>" and click on Check button
    
    And User see the Expected Delivery Date
    
    Then User click on add to cart and see the cart page

    Examples: 
      | Pincode | product |
      |  400066 | Ring    |


  @pdpshipfast
  
  Scenario Outline: Validate the functionality of if product is ships fast on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And User select the ring size
    
    And User enters "<Pincode>" and click on Check button
    
    And User see the Expected Delivery Date
    
    Then User are able to see the select the shipfast

    Examples: 
      | Pincode | product |
      |  400066 | Ring    |

  @pdpPageViewDetails1
  
  Scenario: User able to see prodct type Earrings on landing page
  
    When User mousehover on Earring option
    
    And User see the various catagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Gold and click on it
    
    And The product listing page is displayed
    
    And User click on any product type earring
    
    And Product Description is displayed in new tab
    
    And User click on View Details
    
    And User scroll down to view detail
    
    And User click on Metal details and Product Details
    
    Then User go back to up

  @pdpringsize1
  
  Scenario Outline: User able to see prodct type Earrings on landing page
  
    When User mousehover on Ring option
    
    And User see the various ringsubcatagory on screen
    
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
      
    And User select Shop by Material Diamond and click on it
    
    And Product listing page is displayed
    
    And User click on any of the product
    
    And Product Description is displayed in new tab
    
    And User select the ring size
    
    And User enters "<Pincode>" and click on Check button
    
    And User see the Expected Delivery Date
    
    Then User click on add to cart and see the cart page
    

    Examples: 
      | Pincode |
      |  400066 |


# AddressPage.feature


@healthCheck
Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
  
    Given User navigate to URL and open the landing page
    

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL

  @LandingPageTitle
  
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
  
    When User is on landing page
    
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @addresspageMultipleitems
  
  Scenario Outline: Validate the billing address functionality on address page
  
    When User search for "<product>"
    
    And choose to buy the first item
    
    And Add product to shopping cart
    
    And User clicks on continue shopping
    
    And User search for "<product1>"
    
    And choose to buy the second item
    
    And Add this item to the cart
    
    And User Click on proceed to check out
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    
    And User click on Create Account
    
    Then Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue

    Examples: 
      | product | product1 | name    | emailid          | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | RERSDcv | YTRFvc@gmail.com | 8690123689 | rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |

  @addresspageAddnewaddress
  
  Scenario Outline: Validate the add new shipping address functionality on address page
  
    When User search for "<product>"
    
    And choose to buy the first item
    
    And Add product to shopping cart
    
    And User Click on proceed to check out
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And Click on SHIP TO SAME ADDRESS
    
    Then Fill all details "<lastname1>"  and  "<mobile1>" and "<zip1>" and "<flat1>"  and  click on continue

    Examples: 
      | product | name    | emailid          | mobileno   | lastname | mobile     | zip    | flat                                   | lastname1 | mobile1    | zip1   | flat1                                   | UPIId         |
      | Earring | UWEWSit | rGFGft@gmail.com | 8345127979 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | More      | 9834909874 | 400089 | flat no 201,sanlkalp chsl borivali east | anything@payu |

  @addresspageEditOrder
  
  Scenario Outline: Validate the  EDIT ORDER functionality on address page
  
    When User search for "<product>"
    
    And choose to buy the first item
    
    And Add product to shopping cart
    
    And User clicks on continue shopping
    
    And User search for "<product1>"
    
    And choose to buy the second item
    
    And Add this item to the cart
    
    And User Click on proceed to check out
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    
    And User click on edit order
    
    And User Click on proceed to check out
    
    Then Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    

    Examples: 
      | product | product1 | name     | emailid            | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | uREWRWCe | rqeRWERc@gmail.com | 8945123217 | rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |



# EndtoendOrderjournery.feature

@healthCheck
Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
  
    Given User navigate to URL and open the landing page
    

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL
    

  @LandingPageTitle
  
  Scenario: User naviaget to URL, User redirect to landing page with expected page title
  
    When User is on landing page
    
    Then Validate title of landing page with expected title as "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"

  @e2eCheckoutSignUpUPI
  
  Scenario Outline: Validate if User should be sign up in to check out the product
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And Add first product to the shopping cart
    
    And User click on Checkout Securely
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    
    And User click on Create Account
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And User see the payment page and click on UPI
    
    And User enter "<UPIId>" and click on placeorder
    
    And User see the cander razorpay page
    
    And User mouseover to my account and click on my order
    
    And Click on view details and scroll down
    
    Then Go back to my orders

    Examples: 
      | product | name  | emailid         | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | ring    | rerre | qrwcv@gmail.com | 7634357898 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  @e2eCheckoutSignUpcredit
  
  Scenario Outline: Validate if User should be sign up before check out the product
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And Add first product to the shopping cart
    
    And User click on Checkout Securely
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    
    And User click on Create Account
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And User select the payment method CreditDebit Card
    
    And User enter "<CardNumber>" and "<NameOnCard>"  and  "<CVV>"  and  "<ExpiryYear>"  and  "<ExpiryMonth>" click on placeorder
    
    And User see the cander razorpay page
    
    And User mouseover to my account and click on my order
    
    And Click on view details and scroll down
    
    Then Go back to my orders

    Examples: 
      | product  | name  | emailid             | mobileno   | lastname | mobile     | zip    | flat                                   | CardNumber          | NameOnCard | CVV | ExpiryYear | ExpiryMonth |
      | Necklace | hgfer | ugfgfGTRe@gmail.com | 9576735689 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | 4111 1111 1111 1111 | testing    | 123 |         23 |          10 |


  @e2eCheckoutSignUpNetBanking
  Scenario Outline: Validate if User should be sign up before check out the product
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And Add first product to the shopping cart
    
    And User click on Checkout Securely
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    
    And User click on Create Account
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And User see the payment page and click on NetBanking
    
    And Select the bank as per there choice
    
    Then User click on place order and see the bank page
    

    Examples: 
      | product | name    | emailid         | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | ring    | wTytxcf | ytrtt@gmail.com | 9674548954 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  @e2eSignupCheckoutcredit
  
  Scenario Outline: Validate if User should be sign up after check out the product
  
    When User see Your Account and click on  SignUp  from home page
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    
    And User click on product type Necklace
    
    And User choose to buy the first item
    
    And Product Desc is displayed in new tab
    
    And User click on add to cart
    
    And Click on Checkout Securely
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And User select the payment method CreditDebit Card
    
    And User enter "<CardNumber>" and "<NameOnCard>"  and  "<CVV>"  and  "<ExpiryYear>"  and  "<ExpiryMonth>" click on placeorder
    
    And User see the cander razorpay page
    
    And User mouseover to my account and click on my order
    
    And Click on view details and scroll down
    
    Then Go back to my orders

    Examples: 
      | name  | emailid          | mobileno   | lastname | mobile     | zip    | flat                                   | CardNumber          | NameOnCard | CVV | ExpiryYear | ExpiryMonth |
      | Rreux | EdfdFW@gmail.com | 9635446074 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | 4111 1111 1111 1111 | testing    | 123 |         23 |          10 |


  @e2eSignUpCheckoutUPI
  
  Scenario Outline: Validate if User should be sign up after check out the product
  
    When User see Your Account and click on  SignUp  from home page
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    
    And User click on Create Account
    
    And User click on treading on landing page
    
    And User select the any ring as per choice
    
    And Add first product to the shopping cart
    
    And User click on Checkout Securely
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And User see the payment page and click on UPI
    
    And User enter "<UPIId>" and click on placeorder

    And User see the cander razorpay page
    
    And User mouseover to my account and click on my order
    
    And Click on view details and scroll down
    
    Then Go back to my orders
    

    Examples: 
      | name     | emailid          | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | OHGFERRg | IUYVTf@gmail.com | 7534038923 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  #================================================================
  @e2eCheckoutLogin
  
  Scenario Outline: Validate if User should be sign up in to check out the product
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And Add first product to the shopping cart
    
    And User click on Checkout Securely
    
    And User are able to see the signup and login popup and click on signup
    
    And User enters "<Emailid or mobileno>"
    
    And User click on continue button
    
    And User enter otp manually and click on login
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    
    And User see the payment page and click on UPI
    
    And User enter "<UPIId>" and click on placeorder
    
    Then User see the cander Justpay page

    Examples: 
      | product | Emailid or mobileno       | lastname   | mobile | zip        | flat   | UPIId                                  |               |
      | ring    | suchita.tayde@candere.com | 8678451771 | rane   | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |


  @e2eLoginCheckout
  
  Scenario Outline: User is able to order single product with multiple quantity from the app
  
    When User see Your Account and click on  Log In  from home page
    
    And User enters "<Emailid or mobileno>"
    
    And User click on continue button
    
    And User enter otp manually and click on login

    And User click on Rings
    
    And Choose to buy the first item of the ring
    
    And Product Description is displayed in new tab
    
    And User select the ring size as per choice and check if size change the price also get updated or not
    
    And User enters "<Pincode>" and click on Check button
    
    And User see the Expected Delivery Date
    
    And Add product to shopping cart
    
    And On cart page user is able to change the product qty and and size
    
    And Shipping page is open then user click on continue
    
    And User see the payment page and click on UPI
    
    And User enter "<UPIId>" and click on placeorder
    
    Then User see the cander Justpay page
    

    Examples: 
      | Emailid or mobileno       | Pincode | UPIId         |
      | suchita.tayde@candere.com |  400068 | anything@payu |


  @e2eCheckoutLogin
  
  Scenario Outline: Validate if User should be sign up in to check out the product
  
    When User search for "<product>"
    
    And choose to buy the first item
    
    And Add product to shopping cart
    
    And Click on proceed to check out after ACT
    
    And user click on checkout signup pop is open
    
    And User see login page and new user click on  SignUp  from checkout
    
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    
    And User click on Create Account
    
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue

    And User see the payment page and click on UPI
    
    And User enter "<UPIId>" and click on placeorder
    
    Then User see the cander Justpay page
    

    Examples: 
      | product | name | emailid            | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | Earring | Shiv | shivrane@gmail.com | 9967345556 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |



3. Add Runner File

 package create package runners.
 
Add a Class and add Junit annotation @RunWith(Cucumbers.class

This annotation will instruct Junit to trigger the test cases using Cucumber class.

Add @CucumberOptions annotation on top of Junit Class file. Under this cucumber options we have to list the cucumber configurations.

Check Below file:

package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)

 
	@CucumberOptions(
			

			features={"src/test/resources/Feature/ProductListingPage.feature"},           //Path of Feature folder which hold feature file
   
	        glue={"StepDefination","HomeStepDef" }, // Path of StepDefinition file
         
	        tags= " @plpFilterBy", 
         
	        plugin = {"pretty",        
         
	            "html:target/html/htmlReport.html",
             
	            "json:target/json/jsonReport.json",
             
	            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
             
				      "timeline:test-output-thread/"
	            
			},
			
			monochrome=true,
   
			        publish= true,
           
			        dryRun=false
			
	)
	
	
	public class TestRunner {
		

}


 4. Generate Step Defs and Add in stepdefs package
  
Right click on the TestRunner.java file and click on Run

The run will fail with the below message and it will generate the method definition for you.

Copy this method definition from the console and paste it in the newly created java file.

Name this new package 'stepDefinations' 

Create New java file as HomeStepDefs.java under package: stepDefination


New Java Step Definition file will look like:

public class StepDefs {

    @Given("User opened browser")
    
    public void user_opened_browser() {
    
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
        
    }
    
    @Given("User navigated to the home application url")
    
    public void user_navigated_to_the_home_application_url() {
    
        // Write code here that turns the phrase above into concrete actions
        
        throw new io.cucumber.java.PendingException();
    }
    
    @When("User Search for product {string}")
    
    public void user_search_for_product(String string) {
    
        // Write code here that turns the phrase above into concrete actions
        
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("Search Result page is displayed")
    
    public void search_result_page_is_displayed() {
    
        // Write code here that turns the phrase above into concrete actions
        
        throw new io.cucumber.java.PendingException();
    }

}


5. Add Selenium Steps in Step Defs Java File


GO to Step Def file

Declare WebDriver at the top

Init WebDriver=chrome Driver under method user_opened_browser and similarly other selenium steps will go under respective methods.

Go to Test Runner file and change the dryRun=false

Run the code. Simple Right click and run.

Test will run and there will be a report link, open it. This will only work if you have publish=true in cucumber options under TestRunner.java file.

Go to /target/html/htmlreport.html; this also is a report cucumber generated.

Check in the reference branch as well as below. For exact working code select the right branch in git hub and navigate to the file.


Step Defs File will look like Below:

package StepDefination;

import java.util.Iterator;

import java.util.List;

import java.util.Set;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;


import PageObjects.FooterSectionObjects;

import PageObjects.HeaderSectionObjects;

import PageObjects.HomePageObjects;

import PageObjects.ProdductDescPageObjects;

import PageObjects.ProductListingPageObject;

import PageObjects.SignUpPageObject;

import core.WebDriverFactory;

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
	
	//HomePageObjects homePageObject;
 
	HomePageObjects homePageObject;
 
	FooterSectionObjects footerPageObject;
 
	SignUpPageObject signUpPageObject;
 
	HeaderSectionObjects headerObject;
 
	ProductListingPageObject productListingObject;
 
	ProdductDescPageObjects productDescObject;
 
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
	

6. Log 4j Impl for Logging

Add Log4 J 2 Depdendency in POM.

Add Log4j2.xml under test.resources package.

On top of each class create the statement with its class name.

Based on the info mentioned in the log4j2.xml configuration file, logs will be printed on the console as well as a new file will be created every time you run the framework.   

private static final Logger logger = LogManager.getLogger(TestCases_1.class)
. 
Make sure to replace the class name in above statement. 

For example, for class: "StepDefs.Java", then statement will look like: private static final Logger logger = LogManager.getLogger(StepDefs.class);

Logger statements can then be used in where in the class. To make things simple, you can chosse to write for all the information logs: Log.info("<info messages>").

And for any where you want to log errors, mention, Log.fatal or Log.error


 <dependency>
            <groupId>org.apache.logging.log4j</groupId>
   
            <artifactId>log4j-api</artifactId>
            
            <version>2.13.1</version>
            
        </dependency>
        
        <dependency>
        
            <groupId>org.apache.logging.log4j</groupId>
            
            <artifactId>log4j-core</artifactId>
            
            <version>2.13.1</version>
            
        </dependency>


7. Page Object Model:
 
Page Object Model is used to store all locators of the page in a single class file.

All the locators will be marked as private.

Declare WebDriver at the top.

Create a paramatrized constructor and pass driver object while creating page object model class object.

All the instance variables should be marked as private, including web driver and locators.

Create public methods to perform operations on these locators.

Create public methods to perform validations.

Check below example, for better understanding go to branch and check.

Page Object Model file:

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
      
	    	logger.info("Validate the signIn Button");
      
	    	scn.log("Validate the signIn Button");
	    }
	    
	//============ 2. Method to click on SignIn Button =================================================//
	    
	    public void clickOnSignInBtn()
	    {
	    	
	    	WebElement signIn =driver.findElement(yourAccount);
	    	
	    	wait= new WebDriverWait(driver,50);
      
	    	wait.until(ExpectedConditions.elementToBeClickable(signIn));
      
	    	signIn.click();
      
	    	logger.info("Click on the signIn Button");
      
	    	scn.log("Click on the signIn Button");
	    	
	    }

8.  Web Driver Manager Methods:


   Used Factory method to return driver to be executed against.
   
Driver can also be sent from mvn command line.

If no Browser is sent then chrome is the default Browser.

mvn command: mvn clean verify : this will run on chrome, since no browser is mentioned.

mvn command: mvn clean verify -Dbrowser=firefox : this will run on firefox

mvn command: mvn clean verify -Dbrowser=headless : this will run on headless browser, i.e. no browser will be opened and tests will be executed on a head less browser

Check the code here:


WebDriverFactory Class:

public class WebDriverFactory {

    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
    
    private static WebDriver driver=null;


    public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
        switch(browser.toLowerCase()){
        
            case "chrome":
            
                driver = new ChromeDriver();
                
                logger.info("Chrome Browser invoked");
                
                break;
                
            case "firefox":
            
                driver = new FirefoxDriver();
                
                logger.info("Firefox Browser invoked");
                
                break;
                
            case "headless":
            
                ChromeOptions options = new ChromeOptions();
                
                options.addArguments("headless");
                
                options.addArguments("window-size=1200x600");
                
                driver = new ChromeDriver(options);
                
                logger.info("Headless Chrome Browser invoked");
                
                break;
            default:
            
                logger.fatal("No such browser is implemented.Browser name sent: " + browser);
                
                throw new Exception("No such browser is implemented.Browser name sent: " + browser);
        }

        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        logger.info("Driver maximized and implicit time out set to 20 seconds");
        
        return driver;
    }

    public static void navigateToTheUrl(String url){
    
        driver.get(url);
        
        logger.info("Browser navigated to the url: " + url);
    }

    public static void quitDriver(){
    
        driver.quit();
        
        logger.info("Driver closed");
        
    }
    public static void switchBrowserToTab(){
    
        //As product description click will open new tab, we need to switch the driver to the new tab
        //If you do not switch, you can not access the new tab html elements
        //This is how you do it
        Set<String> handles = driver.getWindowHandles(); // get all the open windows
        logger.info("List of windows found: "+handles.size());
        logger.info("Windows handles: " + handles.toString());
        Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
        String original = it.next();//gives the parent window id
        String nextTab = it.next();//gives the child window id
        driver.switchTo().window(nextTab); // switch to product Descp
        logger.info("Switched to the new window/tab");
    }

    public static String getBrowserName(){
    
        String browserDefault = "chrome"; //Set by default
        
        String browserSentFromCmd = System.getProperty("browser");

        if (browserSentFromCmd==null){
        
            return browserDefault;
        }else{
            return browserSentFromCmd;
        }
    }

}
How to use:

    @Before
    
    public void setUp(Scenario scn) throws Exception {
    
        this.scn = scn; //Assign this to class variable, so that it can be used in all the step def methods

        //Get the browser name by default it is chrome
        
        String browserName = WebDriverFactory.getBrowserName();
        
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        
        logger.info("Browser invoked.");
      }


 9.    Screen shot capturing on test scenario failures

Screen shot capturing is a important part of test cases failure investigation.

When test cases fails, we need to give the evidence to the person who is investigating the report of the test execution.

There can be many screen shot capturing strategies. like:

Take one screen shot when test case end (pass or fail)

Take screen shot after each line of the scenario.

Take screen shot as soon as a step fails.

Usually taking screen shot when scenario/step fails is more resonable and commonly used strategy.

To implement it we will need to know at run time if the test is pass or fail.

If the test is pass we will choose not to take a screen shot.

If the test fails we will take the screenshot and attach it with the native report.

Then can be achieved in cucumber using 'Scenario' Object injected in @After method.

So we have added another After method (you can have many after methods) 

10.However we need to make sure, that this after method gets executed before above After method, otherwise browser will be closed by above after method and screen shot will not be captured. 11.To run this @After method first, we need to add the argument 'order' to this method's annotation.

Giving this method order as 2, means it will always execute first, and then giving order as 1 to the above after method.

Order number is the order in which this hook should run. Higher numbers are run first. The default order is 10000.

Now since we need to capture the screen shot only after a test is failed, we will put a if condition as check the failure using method 'isFailed'.

If test is failed it will take the screen shot and attach the screen shot with the report. For this s.attach method is used. (in old version, method name was embed)


Code Implementation:

  // Giving this method order as 2, so that quit happens after screen shot capture.
  @After(order=1)
  
  public void cleanUp(){
  
      WebDriverFactory.quitDriver();
      
      scn.log("Browser Closed");
  }

  @After(order=2) // this will execute first, higher the number, sooner it executes
  
  public void takeScreenShot(Scenario s) {
  
    if (s.isFailed()) {
    
        TakesScreenshot scrnShot = (TakesScreenshot)driver;
        
        byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
        
        scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        
    }else
    
    {
    
        scn.log("Test case is passed, no screen shot captured");
    }
  }



 10. Scenario Outline and examples Implementation
    
Scenario Outline is used to iterate same steps but with different data each time.

For example, we need to test the 'search' functionality but with different types of products.

In the below case, we have three product to search, but steps to do that search are same. 6 .In such cases, we will have to use scenario outline - Examples structure.

Examples are written in a tabular format.

Below example has only one column, but you can add multiple column, multiple row data.

For first iteration, "<product_name>" variable will be replaced with first value in the examples table.

Once first iteration is completed, the scenario will again start executing given statement and this time 2nd column value from examples will be picked.

It will continue to do this, until all the rows are executed.

Code Implementation!

Click to see code! 

@Ordertracking

  Scenario Outline: Validate Ordertracking is working as excepted
  
    When User click on ordertracking
    
    And User enter "<orderid>"  and  "<emailaddress>"
    
    And User click on request info
    
    Then User opened with order tracking url "https://www.candere.com/ordertracking/ordertracking/index"

    Examples: 
      | orderid    | emailaddress              |
      | 1000556321 | suchita.tayde@candere.com |
      | 1000556336 | mohit.gupta@candere.com   |

      
11.  Cucumber Background

1. Background in Cucumber is used to define a step or series of steps that are common to all the tests in the feature file.
  
2. It allows you to add some context to the scenarios for a feature where it is defined.

3. A Background is much like a scenario containing a number of steps.

4. But it runs before each and every scenario were for a feature in which it is defined.

4. In Our example, we have a Given statement which being repeated in all the Scenarios. i.e. User navigated to the Home application url

5. So We will move it up and write this statement at the top under Background.

@healthCheck

Feature: E-Commerce website healthcheck

  Background: Navigation to the URL
  
    Given User navigate to URL and open the landing page

  @URLRedirection
  
  Scenario: User naviaget to URL, User redirect to landing page with expected current URL
  
    When User is on landing page
    
    Then Validate current URL of landing page with expected URL

    @pdpringsize
    
  Scenario Outline: Validate the functionality of View Details on product description page
  
    When User search for the  "<product>"
    
    And choose to buy the first item in list
    
    And User select the ring size
    
    And User enters "<Pincode>" and click on Check button
    
    And User see the Expected Delivery Date
    
    Then User click on add to cart and see the cart page
    

    Examples: 
      | Pincode | product |
      |  400066 | Ring    |
      |  400066 | Earring  |
