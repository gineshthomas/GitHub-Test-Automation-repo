Feature: To validate the process of listing an item under a general classification through the selling interface. 

# Note:
#1. Change BrowserName value accordingly for execution eg: 'Chrome' for chrome browser, 'Firefox' for firefox browser and 'Edge' for MS edge browser
#2. CAPTCHA handling is not done. Possible solutions for this>> a) Manually do CAPTCHA by providing wait time in the scrips or b) sign up with 2captcha, capmonster cloud, 
#   deathbycaptcha, etc. and follow their instructions. They will give you a token that you pass with the form. or c) disbale CAPTCHA in the test environments.
#3. Regardless of CAPTCHA issue, i have captured UI's past login for 'list a generic item' workflow.

  @tsb-trademe-test @list-item-test
  Scenario Outline: 1. To verify the process of listing an item under a general classification
    Given User select the <BrowserName> browser
    And User loads trademe 'List an Item' url in the selected browser
    And List an item page - I see the page text "List an item"
    
    And List an item page - I see the page text "General item"
    And List an item page - I see the page text "List for free - only pay when it sells*"  
      
    And List an item page - I see the page text "Car, motorbike or boat "
    And List an item page - I see the page text "Vehicles, or planes" 
    
    And List an item page - I see the page text "Property"     
    And List an item page - I see the page text "Sell, rent or lease your property" 
        
    And List an item page - I see the page text "Job"     
    And List an item page - I see the page text "Advertise a vacancy." 
       
    And List an item page - I see the page text "Flatmates wanted" 
    And List an item page - I see the page text "Find a flatmate"   
    
    And List an item page - I see the page text "Service"     
    And List an item page - I see the page text "Offer a service" 
        
    And List an item page - I see the page text "*Listing fees apply in pets, businesses for sale, and several other general categories."  
       
    When List an item page - I click the 'General item' link
    
    # Login page loaded - to login
    Then List an item page - I see the page text "Log in"
    When List an item page - User enters <Email> and <Password>
    And List an item page - User enter CAPTCHA and then click login button
    
    # What are you listing? 
    And List an item page - I see the page text "What are you listing?"
    
    And List an item page - I see the page text "Listing title"
    And List an item page - I enter listing title as "White T-shirt" 
    
    And List an item page - I see the page text "Category"
    Then List an item page - I click the 'Choose category' button
    And List an item page - I click the 'Clothing & Fashion' link
    And List an item page - I click the 'Men' link
    And List an item page - I click the 'Tops & shirts' link
    And List an item page - I see the page text "Tops & shirts"    
    And List an item page - I enter listing Subtitle as "cotton material" 
    
    Then List an item page - I click the 'Next' button
    
    # Item details page
    And List an item page - I see the page text "Item details"    
    And List an item page - I enter the Description as "Iam selling a White T-shirt"     
    And List an item page - I enter and select the Colour as "White"
    And List an item page - I enter and select the Brand as "adidas"
    And List an item page - I select size as "medium"
    Then List an item page - I click the 'Next' button
                    
    # Photos page
    And List an item page - I see the page text "Photos"         
    Then List an item page - I click the 'Next' button
    
    # Price & payment page
    And List an item page - I see the page text "Price & payment" 
    And List an item page - I enter Buy now price as "100"
    And List an item page - I enter Start price as "50"    
    Then List an item page - I click the 'Next' button  
    
    # Shipping & pick-up page
    And List an item page - I see the page text "Shipping & pick-up"  
    And List an item page - I see the page text "Select a pick-up option"            
    And List an item page - I click pick up option as 'Pick-up available' 
    And List an item page - I see the page text "Select a shipping option"      
    And List an item page - I click Shipping option as 'Free shipping within New Zealand' 
    Then List an item page - I click the 'Next' button        
    
    # Jazz up your listing page
    And List an item page - I see the page text "Jazz up your listing"   
    And List an item page - I see the page text "Optimise the closing time"
    And List an item page - I see the page text "Buyers are busiest on Trade Me around 8pm every day, except Saturday."
    And List an item page - I see the page text "Donate the difference"    
    And List an item page - I see the page text "Would you like to round up the success fee to the nearest dollar and donate the difference to one of our partners?" 
    And List an item page - I see the page text "Fee summary" 
    And List an item page - I see the page text "A success fee also applies if the auction meets reserve or is purchased via Buy Now."   
    And List an item page - I see the page text "Total fees" 
    And List an item page - I see the page text "No charge" 
    Then List an item page - I click the 'Start listing' button  
    
    # Auction detail page - verify the presense of UI texts in the page
    And List an item page - I see the page text "Auction detail"   
    And List an item page - I see the page text "(Only you can see this section)"     
    And List an item page - I see the page text "Watchlists" 
    And List an item page - I see the page text "Views" 
    And List an item page - I see the page text "Bids" 
    And List an item page - I see the page text "Start price" 
    And List an item page - I see the page text "$50.00" 
    And List an item page - I see the page text "Reserve price" 
    And List an item page - I see the page text "No reserve" 
    And List an item page - I see the page text "Buy Now" 
    And List an item page - I see the page text "$100.00" 
    And List an item page - I see the page text "Current Bid" 
    And List an item page - I see the page text "No bids" 
    And List an item page - I see the page text "Details" 
    And List an item page - I see the page text "Condition: New" 
    And List an item page - I see the page text "Colour:" 
    And List an item page - I see the page text "White" 
    And List an item page - I see the page text "Brand: adidas"                                 
    
    And List an item page - I see the page text "Description" 
    And List an item page - I see the page text "Iam selling a White T-shirt" 
    And List an item page - I see the page text "Shipping & pick-up options" 
    And List an item page - I see the page text "Destination & description" 
    And List an item page - I see the page text "Price" 
    And List an item page - I see the page text "Free shipping within New Zealand" 
    And List an item page - I see the page text "Free" 
    And List an item page - I see the page text "Pick-up available from Auckland City, Auckland" 
    And List an item page - I see the page text "Free" 
    And List an item page - I see the page text "Learn more about shipping & delivery options." 
    And List an item page - I see the page text "Payment Options" 
    And List an item page - I see the page text "Cash, NZ Bank Deposit" 
    And List an item page - I see the page text "Questions & Answers" 
    And List an item page - I see the page text "500 characters remaining" 
    And List an item page - I see the page text "Add seller comment " 
    And List an item page - I see the page text "Do not use this feature to bypass the auction process or for commercial purposes. Abuse may result in suspension of your account." 
    And List an item page - I see the page text "No questions have been asked!"      
    And List an item page - I see the page text "About the seller"  
    And List an item page - I see the page text "tsbtest"  
    And List an item page - I see the page text "Location"  
    And List an item page - I see the page text "Auckland City"  
    And List an item page - I see the page text "Member since"  
    And List an item page - I see the page text "Wednesday, 1 May 2024"  
    And List an item page - I see the page text "View seller's other listings"  
    And List an item page - I see the page text "Read our safe buying advice"                                                                                                                                 
   
    And User close the browser

    Examples: 
      | Email                  | Password | BrowserName | 
      | gineshthomas@gmail.com | test1234*|  Chrome     |

  @tsb-trademe-test @list-item-test
  Scenario Outline: 2. To verify the process of listing an item under a general classification - page error validations
    Given User select the <BrowserName> browser
    And User loads trademe 'List an Item' url in the selected browser
    And List an item page - I see the page text "List an item"
    
    And List an item page - I see the page text "General item"
    And List an item page - I see the page text "List for free - only pay when it sells*"  
      

    When List an item page - I click the 'General item' link
    
    # Login page loaded - to login
    Then List an item page - I see the page text "Log in"
    When List an item page - User enters <Email> and <Password>
    And List an item page - User enter CAPTCHA and then click login button
    
    # What are you listing? 
    And List an item page - I see the page text "What are you listing?"
    
    And List an item page - I see the page text "Listing title"
    
    And List an item page - I see the page text "Category"
    Then List an item page - I click the 'Choose category' button
    And List an item page - I click the 'Clothing & Fashion' link
    And List an item page - I click the 'Men' link
    And List an item page - I click the 'Tops & shirts' link
    And List an item page - I see the page text "Tops & shirts"    
    
    Then List an item page - I click the 'Next' button
    
    # Item details page
    And List an item page - I see the page text "Item details"    
    Then List an item page - I click the 'Next' button
                    
    # Photos page
    And List an item page - I see the page text "Photos"         
    Then List an item page - I click the 'Next' button
    
    # Price & payment page
    And List an item page - I see the page text "Price & payment"    
    Then List an item page - I click the 'Next' button  
    
    # Shipping & pick-up page
    And List an item page - I see the page text "Shipping & pick-up"  
    Then List an item page - I click the 'Next' button        
    
    # Jazz up your listing page
    And List an item page - I see the page text "Jazz up your listing"   
    And List an item page - I see the page text "You've missed some things:"
    And List an item page - I see the page text "Please select a pickup option."
    And List an item page - I see the page text "Please select a shipping option."
    And List an item page - I see the page text "Please enter a title"
    And List an item page - I see the page text "Please enter a price."
    And List an item page - I see the page text ""                                                                                                                                           
   
    And User close the browser

    Examples: 
      | Email                  | Password | BrowserName | 
      | gineshthomas@gmail.com | test1234*|  Chrome     |

      

      
      

      
     