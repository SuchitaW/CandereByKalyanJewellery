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

  @Priceupdationonsize&qty
  Scenario: To verify the Price updation on size and quantity updates
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
    And User click on add to cart and see the cart page
    And On cart page user is able to change the product qty and and size
    Then User are able to see the price updated when the size and quantity changes

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
  @CheckoutSecurely
  Scenario Outline: To verify Checkout Securely button functionality and its redirection
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

  @Remove/Delete
  Scenario Outline: Validate the Remove / delete functionality  on cart
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

  @Insurance
  Scenario Outline: To Validate the insurance and remove insurance or not functionality on cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User are able to remove the insurance on cart page
    Then User are able to see the warning message

    Examples: 
      | product     |
      | Mangalsutra |

  @Checkoffers
  Scenario Outline: Validate the Check Offers functionality on cart page
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User click on check offers on cart page
    Then User are able to see the Apply Offer Voucher popup on cart page

    Examples: 
      | product |
      | Chains  |

  @Manuallycheckoffers
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
      | Chains  | GETNOW     |

  @MultipleitemsSelect
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
      | product | product1 |
      | Earring | Rings    |

  @Minicart
  Scenario Outline: User can delete the items in the mini cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User clicks on continue shopping
    And User search for "<product1>"
    And choose to buy the second item
    And Add this item to the cart
   And User clicks on continue shopping
    And User mouse over to the My shopping bag
    When User deletes an item from the mini bag  and click on ok
    Then Item should be delete and should not appear in the cart item list

    Examples: 
      | product | product1 |
      | Earring | Rings    |
      
      
        @Viewshoppingbag
  Scenario Outline: User can view the product in the mini cart
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User clicks on continue shopping
    And User search for "<product1>"
    And choose to buy the second item
    And Add this item to the cart
    And User clicks on continue shopping
    And User mouse over to the My shopping bag
    And User click on view shopping bag
    Then User are able to see the cart page

    Examples: 
      | product | product1 |
      | Earring | Rings    |
      
      
      @order
     Scenario Outline: Calculate order summary details for a single product
   When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    Then the order summary details should be calculated correctly
       Examples: 
      | product | product1 |
      | Earring | Rings    |
