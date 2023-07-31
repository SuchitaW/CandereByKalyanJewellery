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

  # TC_SP_01- Verify the Billing Address Section functionality
  @BillingAddressSection
  Scenario Outline: Verify if user can enter the new billing address
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
    Then Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue

    Examples: 
      | product | product1 | name    | emailid             | mobileno   | lastname | mobile     | zip    | flat                                    | UPIId         |
      | Earring | ring     | dsdssda | were354@candere.com | 6789249056 | Rane     | 9023458934 | 400068 | flat no 701,sanlkalp chsl Borivali east | anything@payu |

  @Checkboxinbillingaddress
  Scenario Outline: Verify the Checkbox in billing address functionality
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User click on product type Chain
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
    And User click on Checkout Securely
    And Click on Ship to this address checkbox
    And User click on continue on shipping page
    Then User are able to see the selected shipping address on payment page

    Examples: 
      | Emailidmobileno           |
      | suchita.tayde@candere.com |

  @ShipToSameAddress
  Scenario Outline: Verify if Ship To Same address checkbox funtionality
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User Click on proceed to check out
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And Click on SHIP TO SAME ADDRESS
    And Fill all details "<lastname1>"  and  "<mobile1>" and "<zip1>" and "<flat1>"  and  click on continue
    Then User are able to see the selected shipping address on payment page

    Examples: 
      | product | name   | emailid            | mobileno   | lastname | mobile     | zip    | flat                                   | lastname1 | mobile1    | zip1   | flat1                                   | UPIId         |
      | Ring    | advfdt | rwe123@candere.com | 8356234678 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | More      | 9834909874 | 400089 | flat no 201,sanlkalp chsl borivali east | anything@payu |

  @ShipToNearByStore
  Scenario Outline: Verify if user can select the a shipping method like SHIP TO NEARBY CANDERE/KALYAN STORE
    When User search for "<product>"
    And choose to buy the first item
    And Add product to shopping cart
    And User Click on proceed to check out
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    And Shipping page is open then user fill all details "<lastname>"  and  "<mobile>" and "<zip>" and "<flat>"  and  click on continue
    And Click on SHIP TO NEARBY CANDERE/KALYAN STORE
    And User enter "<pincode>" and click on submit
    And User select the store address
    And User are able to see the shipping address change or not
    Then User are able to see the selected shipping address on payment page

    Examples: 
      | product | name     | emailid           | mobileno   | lastname | mobile     | zip    | flat                                   | pincode | UPIId         |
      | Chain   | rtwewRCW | BNVXt@candere.com | 8389456512 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east |  400066 | anything@payu |

  @AddNewAddress
  Scenario Outline: Verify the Add New address functionality
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailidmobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User click on product type Chain
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
    And User click on Checkout Securely
    And Click on Add New button
    And Enter the new details "<lastname11>"  and  "<mobile11>" and "<zip11>" and "<flat11>"
    And User click on continue on shipping page
    Then User are able to see the selected shipping address on payment page

    Examples: 
      | Emailidmobileno           | lastname11 | mobile11   | zip11  | flat11                                  |
      | suchita.tayde@candere.com | More       | 9834909874 | 400089 | flat no 201,sanlkalp chsl borivali east |

  @EditOrder
  Scenario Outline: Verify if user can EDIT ORDER the product from the cart
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
    And User click on edit order
    Then User are able to see the page redirected to the cart page

    Examples: 
      | product | product1 | name   | emailid             | mobileno   |
      | Earring | ring     | hddwee | rwexvvs@candere.com | 8893245219 |
