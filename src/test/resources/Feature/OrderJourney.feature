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
      | product | name   | emailid           | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | ring    | dftrtr | gngWEQv@gmail.com | 7589132432 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  @e2eCheckoutSignUpcredit
  Scenario Outline: Validate if User should be sign up before check out the product
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
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
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
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
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
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
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
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    #And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    Then User see the cander Justpay page

    Examples: 
      | product | Emailidmobileno           | UPIId         |
      | earring | suchita.tayde@candere.com | anything@payu |

  @e2eCheckoutLoginCreditCart
  Scenario Outline: Validate if User should be login at the time of checkout
    When User search for the  "<product>"
    And choose to buy the first item in list
    And Add first product to the shopping cart
    And User click on Checkout Securely
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And Click on SHIP TO SAME ADDRESS
    And Click on Add new
    And Fill all details "<lastname1>"  and  "<mobile1>" and "<zip1>" and "<flat1>"  and  click on continue
    And User select the payment method CreditDebit Card
    And User enter "<CardNumber>" and "<NameOnCard>"  and  "<CVV>"  and  "<ExpiryYear>"  and  "<ExpiryMonth>" click on placeorder
    And User see the cander razorpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | product | Emailidmobileno           | lastname1 | mobile1    | zip1   | flat1                                  | CardNumber          | NameOnCard | CVV | ExpiryYear | ExpiryMonth |
      | earring | suchita.tayde@candere.com | rane      | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | 4111 1111 1111 1111 | testing    | 123 |         23 |          10 |

  @e2eLoginCheckoutUPI
  Scenario Outline: Validate if User should be login and then go to place the the order
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User click on product type Chain
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
    And User click on Checkout Securely
    And Click on SHIP TO NEARBY CANDERE/KALYAN STORE
    And User enter "<pincode>" and click on submit
    And User select the store address
    And User see the payment page and click on UPI
    And User enter "<UPIId>" and click on placeorder
    And User see the cander Justpay page
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | Emailidmobileno           | pincode | UPIId         | product |
      | suchita.tayde@candere.com |  400066 | anything@payu | Rings   |

  @e2eLoginCheckoutNetBanking
  Scenario Outline: Validate if User should be login and then check out the product
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User click on product type Chain
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
    And User click on Checkout Securely
    And Click on SHIP TO NEARBY CANDERE/KALYAN STORE
    And User enter "<pincode>" and click on submit
    And User select the store address
    And User see the payment page and click on NetBanking
    And Select the bank as per there choice
    Then User click on place order and see the bank page

    Examples: 
      | Emailidmobileno           | pincode |
      | suchita.tayde@candere.com |  400066 |

  @e2eLoginCheckoutDGRP
  Scenario Outline: Validate if User should be login and then check out the product
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User click on product type Chain
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
    And User click on Checkout Securely
    And Click on SHIP TO NEARBY CANDERE/KALYAN STORE
    And User enter "<pincode>" and click on submit
    And User select the store address
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And User click on continue button on shipping page
    And User see the payment page and click on DGRP
    And Select the No. of installments in months
    And Clikc on accept DGRP Terms and Conditions and click on pay now
    And User select the payment method as UPI
    And User click on pay now
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | Emailidmobileno | pincode | lastname | mobile     | zip    | flat                                    | UPIId         |
      |      1234444444 |  400066 | Shetty   | 9023458934 | 400066 | flat no 201,sanlkalp chsl Borivali east | anything@payu |

  @e2eLoginCheckoutCODPartial
  Scenario Outline: Validate if User should be login and then check out the product
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User click on product type Chain
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
    And User click on Checkout Securely
    And Click on SHIP TO NEARBY CANDERE/KALYAN STORE
    And User enter "<pincode>" and click on submit
    And User select the store address
    And User click on continue button on shipping page
    And User see the payment page and click on COD - Partia
    And Scroll down to the palce order
    And User select the payment method as UPI
    And User click on pay now
    And User mouseover to my account and click on my order
    And Click on view details and scroll down
    Then Go back to my orders

    Examples: 
      | Emailidmobileno           | pincode |
      | suchita.tayde@candere.com |  400066 |
