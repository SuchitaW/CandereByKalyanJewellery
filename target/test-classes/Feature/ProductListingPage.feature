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
    And  User click on express delivery
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
    
    
    #@plpwishlisticon1
  #Scenario: User able to see wishlist icon on product listing page for existing user
    #And User are able to see the signup and login popup and click on signup
    #And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    #And User click on Create Account
    #And User click on product type Necklace
    #And Choose to add product to wishlist as per choice
    #And Click on wishlist icon
    #Then User are able to see the My Wish List in my account
    
    
    
    
     #@PLPvideobutton
  #Scenario: User able to see prodct type Earrings on landing page
    #When User mousehover on Earring option
    #And User see the various catagory on screen
      #| Shop by Style    |
      #| Shop by Material |
      #| Shop for         |
      #| Shop By Occasion |
    #And User select Shop by Material Gold and click on it
    #And User click on video-product-button
    #Then video-product-button is working as per excepted
