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

  ##############Login Related Test Cases #################
  Scenario Outline: 1. User is able to Sign up in the application
    When User see Your Account and click on  SignUp  from home page
    And User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enters  "<OTP>"
    And User click on Verify Otp & Register
    Then User is displayed with the message as "OTP is sent on number"
    
    
     Examples: 
      | name      | emailid                | mobileno   |
      | Rdfddweg  | Hfejhg@gmail.com       | 9945786760 |
      | hjgksfder | wewqqFkjdd3e@gmail.com | 9978376456 |
    
    
    #Negative Scenario, to check error messages thrown by application
     Scenario: 1. User is able to Sign up in the application
    When User see Your Account and click on  SignUp  from home page
    And User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enters  "<OTP>"
    And User click on Verify Otp & Register
    Then User gets error message as "Invalid Otp, Please try again"
    

  #Negative Scenario, to check error messages thrown by application
  Scenario Outline: 2. User receives an error message when tries to enter incorrect mobile number or email id in the Login pop up
    When User see Your Account and click on  Log In  from home page
    And User enters "<Emailid or mobileno>"
    And User click on continue button
    And User enter otp manually and click on login
    And User successfully redirected to homepage "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    Then User gets error message as "We cannot find an account with that Email Id/Mobile number."
    
    Examples: 
      | Emailid or mobileno    |
      | suchitatayde@gmail.com |


  #Negative Scenario, to check error messages thrown by application
  Scenario: 3. User receives an error message when tries to enter incorrect name in the Login pop up
    Given User navigates to the application url
    When User clicks on Login-in link at the top right corner of the application
    And User do not enter any name and phone number but clicks on Submit Button
    Then User gets error message as "Please enter a valid name !!"

  # Hint: Check the Max length of the Mobile field in the Then Step using Selenium get attribute method
  Scenario: 4. User is able to enter only 10 digits for Indian user in the Mobile Text box
    When User see Your Account and click on  SignUp  from home page
    And User redirected to create account page of the application where title us "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    Then User is able to enter only "10" digits in the Mobile text field

  ##############Search Related Test Cases #################
  Scenario: 5. User is able to search the Application
    Given User navigates to the application url
    When User enters "restaurants" in search text box
    And User clicks search button
    Then User is able to see search result related to "restaurants"

  # Hint: Use Fluent Wait to wait in the Then Step to wait for drop down to appear
  Scenario: 6. User is able to see the drop down when he keys in the text in the search box
    Given User navigates to the application url
    When User enters "resta" in search text box
    Then User is able to see the drop down under search text box with all the items with text "resta"

  