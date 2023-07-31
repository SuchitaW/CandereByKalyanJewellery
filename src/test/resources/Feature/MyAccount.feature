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

  @MyAccount
  Scenario Outline: User is able to Create Account into the application
    When User see Your Account and click on  SignUp  from home page
    When User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    And User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User click on my order
    And User see their account details and User validate all myaccountlink are clickable or not
    Then Below my account Links are displayed
      | My Orders           |
      | My Wish List        |
      | Address Book        |
      | Ekyc                |
      | Account Information |
      | Saved Cards         |
      | Change Password     |
      | My Wallet           |
      | Earn Rewards        |

    Examples: 
      | name    | emailid          | mobileno   |
      | RFGFHSD | QWEUSi@gmail.com | 9892378345 |

  @MyAccountmyWishList
  Scenario Outline: Validate My Account My WishList Functionality
    When User see Your Account and click on  SignUp  from home page
    When User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    And User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User click on my order
    And User click on my wishlist
    And User click on continue shopping
    And User add item to wishlist
    And User click on my wishlist
    And User click on move to bag
    Then User see the cart page

    Examples: 
      | name   | emailid         | mobileno   |
      | KQEWRX | FUWEt@gmail.com | 9245912454 |

  @MyAccountmyAddressBook
  Scenario Outline: Validate My Account Address Book Functionality
    When User see Your Account and click on  SignUp  from home page
    When User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Create Account
    And User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User click on my order
    And User click on Address Book
    And User fill all the details  "<LName>"  and  "<Streetaddress>" and "<Postalcode>" and "<PhoneNO>"
    And User click on save address
    Then User see the address page

    Examples: 
      | name | emailid         | mobileno   | LName | Streetaddress                                    | Postalcode | PhoneNO    |
      | UOOP | FAQWt@gmail.com | 9673401298 | Wadhe | Flat no 404, Raheja estate,kulupwadi,Borivali(E) |     400066 | 9002376823 |

  @MyAccountmyWallet
  Scenario Outline: Validate My Account My Wallet Functionality
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
    And Go back to my orders
    And User click on My Wallet
    Then User are able to see the Candere Wallet or Promotional Wallet amount are added or not

    Examples: 
      | product | name   | emailid        | mobileno   | lastname | mobile     | zip    | flat                                   | UPIId         |
      | ring    | lQWTTu | SFGO@gmail.com | 7345678122 | rane     | 9023458934 | 400068 | flat no 201,sanlkalp chsl dahisar east | anything@payu |

  #@MyAccountEarnReward
  #Scenario Outline: Validate My Account Earn Rewards Functionality
    #When User see Your Account and click on  SignUp  from home page
    #When User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    #And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    #And User click on Create Account
    #And User successfully redirected to "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    #And User click on my order
    #And User click on Earn Rewards
    #And User ans the following question select gender ,DOB,Aniversary date and click on next
    #And Ans the following ques and click on next
    #And Shop jewellery from my and click on next
    #And shop jewellery because of click on next
    #And Go to wallet and click on promowallet
    #Then User check the Customer Survey balance
#
    #Examples: 
      #| name  | emailid        | mobileno   |
      #| wewRX | tytt@gmail.com | 9456126789 |
