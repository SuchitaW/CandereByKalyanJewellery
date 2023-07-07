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

  #Validation criteria : User should be logged in to check out the product
  @cartPagecheckout
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
    And User click on add to cart and see the cart page
    And On cart page user is able to change the product qty and and size
    Then user click on checkout logIn pop is open

    Examples: 
      | Pincode |
      |  400066 |

  #Product search and purchase from candere.com
  #User wants to search for Product and purchase from candere.com
  #Validation criteria : User should be logged in to check out the product
  @cartPagecheckout2
  Scenario Outline: Product Search and add to shopping cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User clicks on continue shopping
    And User clicks on My shopping bag and view shopping bag
    And Click on proceed to check out
    Then User should be asked to login before checkout

    Examples: 
      | product |
      | Earring |

  @cartPageRemove
  Scenario Outline: Validate the remove functionality on cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User are able to remove the item on cart page
    And User are able to see the popup Do you want to remove this product from Cart ?
    And User clicks on OK buttton
    Then User are able to redirecting to checkout cart page with empty cart

    Examples: 
      | product             |
      | Bangles & Bracelets |

  @cartPageInsurance
  Scenario Outline: Validate the insurance and remove insurance or not functionality on cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User are able to remove the insurance on cart page
    Then User are able to see the warning message

    Examples: 
      | product     |
      | Mangalsutra |

  @cartPagecheckoffers
  Scenario Outline: Validate the check offers functionality on cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User click on check offers on cart page
    Then User are able to see the Apply Offer Voucher popup on cart page

    Examples: 
      | product |
      | Chains  |

  @cartPageManuallycheckoffers
  Scenario Outline: Validate the manually check offers functionality on cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And First we delete the coupon that already applied
    And User click on check offers on cart page
    And Enter the "<couponcode>"
    And Click on apply
    Then User are able to see the coupon applied successfully on cart page

    Examples: 
      | product | couponcode |
      | Chains  | BLING   |

      
      @cartPagecheckoutmultipleitems
  Scenario Outline: Product Search and add to shopping cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User clicks on continue shopping
   And User search for "<product1>"
    And choose to buy the second item
   And Add this item to the cart
    And User Click on proceed to check out
    Then User see product in cart

    Examples: 
      
      
      | product |product1|
      | Earring |Rings|