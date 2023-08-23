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

  @e2e
  Scenario Outline: Validate if User should be sign up in to check out the product
    When User search for the  "<product>"
    And choose to buy the first item in list
    And Add first product to the shopping cart
    And User click on Checkout Securely
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | name   | emailid               | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | ring    | rwerwe | adsaad123@candere.com | 7672339032 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  @e2eMultipleitems
  Scenario Outline: Validate the multiple items add functionality
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
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | product1 | name    | emailid               | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | RkQWgdF | uRYCSX123@candere.com | 8893445745 | rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |

  @e2eMultipleitemsedit
  Scenario Outline: Validate the multiple items add functionality
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User clicks on continue shopping
    And User search for "<product1>"
    And choose to buy the second item
    And Add this item to the cart
    And User click on Checkout Securely
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    And User click on edit order
    And User are able to remove the item on cart page
    And User are able to see the popup Do you want to remove this product from Cart ?
    And User clicks on OK buttton
    And User click on Checkout Securely
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | product1 | name  | emailid            | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | wedfd | zsc33u@candere.com | 8485012782 | rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |

  @e2eMultipleitemseditusinggoogle
  Scenario Outline: Validate the multiple items add functionality
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User clicks on continue shopping
    And User search for "<product1>"
    And choose to buy the second item
    And Add this item to the cart
    And User click on Checkout Securely
    And User click on Login Using Google
    And User enters Emailid or mobileno ,password and click on next button on checkout page
    And User click on edit order
    And User are able to remove the item on cart page
    And User are able to see the popup Do you want to remove this product from Cart ?
    And User clicks on OK buttton
    And User click on Checkout Securely
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | product1 | name    | emailid          | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | Dewtfqw | zscywu@gmail.com | 8456901278 | rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |

  @e2egooglelogin
  Scenario Outline: Validate if User should be sign up in to check out the product
    When User search for the  "<product>"
    And choose to buy the first item in list
    And Add first product to the shopping cart
    And User click on Checkout Securely
    And User click on Login Using Google
    And User enters Emailid or mobileno ,password and click on next button on checkout page
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | name   | emailid           | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | ring    | dftrtr | gngWEQv@gmail.com | 7589132432 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  @e2e2
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
    And User click on Checkout Securely
    And User click on Login Using Google
    And User enters Emailid or mobileno ,password and click on next button on checkout page
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | product1 | name   | emailid             | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | DDVCNw | ASWE12ywu@gmail.com | 8890129018 | rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |
