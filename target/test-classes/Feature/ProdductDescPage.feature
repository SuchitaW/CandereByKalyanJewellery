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

  @productdescpage
  Scenario: User able to see prodct type Earrings on landing page
    When User mousehover on Ring option
    And User see the various ringsubcatagory on screen
      | Shop by Style    |
      | Shop by Material |
      | Shop for         |
      | Shop By Occasion |
    And User select Shop by Material Diamond and click on it
    And Product listing page is displayed
    And User click on any of the product
    Then Product Description is displayed in new tab

  @PDPstripdetails
  Scenario Outline: To verify PDP strip details on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User mouse over on metal-video-thumbnail
    Then User are able to see xzoom-thumbs slick-initialized slick-slider slick-vertical is working properly
 Examples: 
      | product |
      | Rings   |
      
      
  @TryOnFunctionality
  Scenario Outline: To verify Try On functionality on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    Then User scroll down and check the functionality of TryON

    Examples: 
      | product |
      | Rings   |

  @CustomizeProduct
  Scenario Outline: To verify Customize product functionality on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User scroll down and click on Customize this product
    And User are able to change the Metal Color,purity and quality
    Then User scroll up and check price are getting updated

    Examples: 
      | product |
      | rings   |

  @ExploreDGRPlink
  Scenario Outline: To verify Explore DGRP link on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User click on EXPLORE DGRP functionality
    And User checks the PLANS and TERMS & CONDITIONS
    And Close the EXPLORE DGRP window
    And After that User click on Notify me when Price Drop
    And User enters  "<EmailId>"  and  "<MobileNO>"
    And User click on Notify me
    Then User see the Thank U messagepopup and click on ok button

    Examples: 
      | EmailId                    | MobileNO   | product |
      | suchitatayde1213@yahoo.com | 9748723791 | Ring    |

  @Pricebreakuplink
  Scenario Outline: To verify the  Price breakup link on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User click on Price breakup link
    And User scroll down to view detail
    Then User go back to up

    Examples: 
      | product  |
      | Pendants |

  @Metaldetails
  Scenario Outline: To verify the  Metal details ,gemstone details and diamond details checks on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User click on View Details
    And User scroll down to view detail
    And User click on Metal details and diamond Details
    Then User go back to up

    Examples: 
      | product |
      | Earring |

  @Engrave
  Scenario Outline: To verify the  Engrave functionality on product description page
    When User search for the  "<product>"
    And User select the any ring as per choice
    And User scroll down and click on Customize this product
    And User click on add Engraveing
    And User choose Choose a font
    And Enter Inner Engraving text as per your wish and click on save
    Then User are able to see the Engrave test added successfully

    Examples: 
      | product |
      | Ring    |

  @Viewdetailslink
  Scenario Outline: To verify the  View Details on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User click on View Details
    And User scroll down to view detail
    Then User go back to up

    Examples: 
      | product |
      | Ring    |

  @SpeakandChatlink
  Scenario Outline: To verify the Speak and Chat with experts links on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User click on View Details
    And User scroll down to view detail
    And User click on Speak and Chat with experts link
    Then User are able to see the Share on WhatsApp page

    Examples: 
      | product |
      | Ring    |

  @EDD&SizeDropdown
  Scenario Outline: To verify the Expected Delivery Dates and Size dropdown on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User select the ring size
    And User enters "<Pincode>" and click on Check button
    And User see the Expected Delivery Date
    Then User click on add to cart and see the cart page

    Examples: 
      | Pincode | product |
      |  400066 | Ring    |

  @ATCbutton 
  Scenario Outline: To verify the ATC button functionality on product description page
    When User search for the  "<product>"
    And choose to buy the first item in list
    And User select the ring size
    And User enters "<Pincode>" and click on Check button
    And User see the Expected Delivery Date
    Then  Add product to shopping cart

    Examples: 
      | Pincode | product |
      |  400066 |Rings    |

  # Wishlist functionality & Login / SignUp via wishlist
  @Wishlist
  Scenario Outline: To Verify Wishlist functionality & Login / SignUp via wishlist
    When User search for "<product>"
    And choose to buy the first item
    And User click on wishlist icon login signup pop is open
    And User are able to see the signup and login popup and click on signup
    And User enters  "<name>"  and  "<emailid>" and "<mobileno>"
    And User click on Send Otp
    And User enter otp
    And Click on Verify Otp & Register
    And User successfully add this item into wishlist and click on wishlist icon
    Then User are able to see the product successfully added to wishlist

    Examples: 
      | product | name   | emailid              | mobileno   |
      | Chain   | QWEWZD | WxERTEsa@candere.com | 8688991212 |
