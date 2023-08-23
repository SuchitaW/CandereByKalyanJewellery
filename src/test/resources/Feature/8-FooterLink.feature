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

  @FooterLinks
  Scenario: Validate footer links functionality
    When User validate all footerlink are clickable or not
    Then Below footer Links are displayed
      | About Our Company        |
      | Terms and Conditions     |
      | Privacy Policy           |
      | FAQ                      |
      | Offers T&Cs              |
      | Customer Reviews         |
      | 15-Day Returns           |
      | Cancel & Refund          |
      | Lifetime Exchange        |
      | DGRP                     |
      | Certified Jewellery      |
      | Candere Wallet           |
      | Jewellery Insurance      |
      | Refer And Earn           |
      | DigiGold                 |
      | Lookbook                 |
      | Stylery Blog             |
      | Video Gallery            |
      | Order Tracking           |
      | Virtual Try On           |
      | Diamond Education        |
      | Gemstone Education       |
      | Metal Education          |
      | Size Guide               |
      | Gold Rate Guide          |
      | Jewellery Care           |
      | Find Experience Centre   |
      | Kalyan Store Locator     |
      | Kalyan Jewellers Website |
      | Kalyan Stores            |

  @FooterLinksDGRP
  Scenario Outline: Validate  footer links DGRP on landing page
    When User scrolldown to the botton of the landing page of the application
    And User click on DGRP
    And User scroll down and click on start shopping
    And User choose to buy the first item
    And Product Desc is displayed in new tab
    And User click on add to cart
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
      | name  | emailid               | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | rwsee | artrzxe33@candere.com | 8973670372 | Rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |
