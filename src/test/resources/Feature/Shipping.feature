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
