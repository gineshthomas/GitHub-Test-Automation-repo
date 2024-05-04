Feature: To validate the Basic Search functionalities of Computers category in TradeMe application

# Note:
#1. Change BrowserName value accordingly for execution eg: 'Chrome' for chrome browser, 'Firefox' for firefox browser and 'Edge' for MS edge browser
#2. CAPTCHA handling is not done. Possible solutions for this>> a) Manually do CAPTCHA by providing wait time in the scrips or b) sign up with 2captcha, capmonster cloud, 
#   deathbycaptcha, etc. and follow their instructions. They will give you a token that you pass with the form. or c) disbale CAPTCHA in the test environment

  @tsb-trademe-test @computers-search-test
  Scenario Outline: 1. To verify Basic Search functionalities of Computers category
    Given User select the <BrowserName> browser
    And User loads trademe Computers category url in the selected browser
    And Computers search page - I see the heading text "Computers"
    And Computers search page - I see the Search placeholder text "Search within Computers"
    
    # Search for 'Cables & adaptors'
    When Computers search page - User enters "Cables & adaptors" in the Computers search field
    And Computers search page - I click the Search button
    Then Computers search page - I see the Search results info text "Showing 1 result for Cables & adaptors"
    And Computers search page - I see the results category text "Cables & adaptors (1)"
    And Computers search page - I see the search results value "test3"
    And Computers search page - I see the search results value "Wellington"
    And Computers search page - I see the search results value "Options available"
    And Computers search page - I see the search results value "Buy Now"
    And Computers search page - I see the search results value "$15.00"
    And TradeMe page - I see the page text "Save this search"
    And TradeMe page - I see the page text "Sort: Featured first"
    And TradeMe page - I see the page text "List"
    And TradeMe page - I see the page text "Gallery"
    
    # Search for 'Components'
    When Computers search page - I click the Computers navigate link
    When Computers search page - User enters "Components" in the Computers search field
    And Computers search page - I click the Search button
    Then TradeMe page - I see the page text "Showing 2 results for Components"
    And TradeMe page - I see the page text "Components (2)"
    And TradeMe page - I see the page text "Save this search"
    
    # Search for 'Computer furniture'
    When Computers search page - I click the Computers navigate link
    When Computers search page - User enters "Computer furniture" in the Computers search field
    And Computers search page - I click the Search button
    Then TradeMe page - I see the page text "Showing 1 result"
    And TradeMe page - I see the page text "Desks & tables (1)"
    And TradeMe page - I see the page text "Save this search"
    
    # Search for 'Desktops'
    When Computers search page - I click the Computers navigate link
    When Computers search page - User enters "Desktops" in the Computers search field
    And Computers search page - I click the Search button
    Then TradeMe page - I see the page text "Showing 3 results"
    And TradeMe page - I see the page text "LCD monitor (3)"
    And TradeMe page - I see the page text "Save this search"
    And User close the browser

    Examples: 
      | BrowserName | 
      |  Chrome     |

      

      
      

      
      