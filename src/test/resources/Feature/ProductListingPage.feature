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

  @Perpageitems
  Scenario: To verify Per page items display in product listing page
    When User mousehover on Earring option
    And User see the various catagory on screen
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
    And User select Shop by Material Gold and click on it
    And The product listing page is displayed
    Then User are able to count the per page item in plp

  @FilterBymaterialtype
  Scenario: To verify Filter By material type type on productlisting page
    When User click on pendants on landing page
    And User are able to filter by material type diamond
    Then User see the Currently Shopping by filter

  @FilterByMultiSelect
  Scenario: To verify Filter By material type  and shop for on productlisting page
    When User click on pendants on landing page
    And User are able to filter by material type  and shop for pendants as per choice
    Then User see the Currently Shopping by filter and clear all

  @MoreFilter
  Scenario: To verify MoreFiler functionality on productlisting page
    When User click on pendants on landing page
    And User able to click on more filter
    And User select the any combination of product as per there choice
    Then User are able to see the combination of product

  @ClearAll
  Scenario: To verify Clear all functionality on productlisting page
    When User click on pendants on landing page
    And User able to click on more filter
    And User select the any combination of product as per there choice
    Then User are able to ClearAll the filters

  @LoadMore
  Scenario: To verify LoadMore fuctionality on productlisting page
    When User click on pendants on landing page
    And User scrolldown to the bootom of the page
    Then User click on load more button

  @FilterByPrice
  Scenario: To verify Filter by price like low_to_high and high_to_low fuctionality on productlisting page
    When User click on treading on landing page
    And User opened with treading url "https://www.candere.com/trending/hot.html"
    And User click on filter by price criteria
    Then Size of filter by category should be 7

  @Expressdelivery
  Scenario: To verify the express delivery functionality on productlisting page
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

  @Metalcolourchange
  Scenario Outline: To verify Color changer functionality on productlisting page
    When User search for "<product>"
    And User scroll down
    And User select the any product
    Then User click on change background like gold and rosegold

    Examples: 
      | product |
      | ring    |

  @plpwishlisticon
  Scenario Outline: To verify Wishlist functionality on productlisting page
    When User search for "<product>"
    And User scroll down
    And User click on wishlist icon on plp
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    Then User successfully add this item into wishlist and click on wishlist icon

    Examples: 
      | product | name | emailid              | mobileno   |
      | ring    | QWsa | WxE122sa@candere.com | 8645451289 |

  @PLPvideobutton
  Scenario: To verify Preview video functionality on productlisting page
    When User mousehover on Earring option
    And User see the various catagory on screen
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
    And User select Shop by Material Gold and click on it
    And User click on video-product-button
    Then video-product-button is working as per excepted
