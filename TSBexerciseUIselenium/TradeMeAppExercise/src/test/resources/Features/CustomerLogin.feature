Feature: To test the login functionalities of TradeMe application

# Note:
#1. Change BrowserName value accordingly for execution eg: 'Chrome' for chrome browser, 'Firefox' for firefox browser and 'Edge' for MS edge browser
#2. CAPTCHA handling is not done. Possible solutions for this>> a) Manually do CAPTCHA by providing wait time in the scrips or b) sign up with 2captcha, capmonster cloud, 
#   deathbycaptcha, etc. and follow their instructions. They will give you a token that you pass with the form. or c) disbale CAPTCHA in the test environment

  @tsb-trademe-test @login-test
  Scenario Outline: 1. To verify successfull and invalid login
    Given User select the <BrowserName> browser
    And User loads trademe home url in the selected browser
    And navigate to the login page
    When User enters <Email> and <Password>
    And User enter CAPTCHA and then click login button
    Then User is successfully logged-In
    And User close the browser

    Examples: 
      | Email                  | Password | BrowserName | 
      | gineshthomas@gmail.com | test1234*|  Chrome     |
      | invalid@email.comm     | 122325   |  Chrome     |

      
  @tsb-trademe-test @login-test   
  Scenario Outline: 2. To verify login page field validations
    Given User select the <BrowserName> browser
    And User loads trademe home url in the selected browser
    When navigate to the login page
    And Login page - I see the warning text "Warning! You're using the Sandbox environment."
    And Login page - I see the heading text "Log in"
    And Login page - I see the info text "New to Trade Me? Register now"
    And Login page - I see the email field text "Email"
    And Login page - I see the password field text "Password"
    And Login page - I see the link text "Forgotten password?"
    And Login page - I see the checkbox text "Remember me"
    And Login page - I see the captcha text "I'm not a robot"
    And Login page - I see the help text "Having trouble logging in?"
    And Login page - I see the declaration text "This site is protected by reCAPTCHA and the Google Privacy Policy and Terms of Service apply."
    When Login page - I click the link text "Forgotten password?"
    Then Login page - I see the forgot password page heading "Forgot your password?"
    When Login page - I click on browser back button
    And Login page - I see the heading text "Log in"
    When Login page - I click the info link "Register now"
    Then Login page - I see the create account page heading "Create a personal account"
    When Login page - I click on browser back button
    And Login page - I see the heading text "Log in"
    When Login page - I click the help link "Having trouble logging in?"
    Then Login page - I see the logging-in page heading "Logging in"
    And User close the browser

    Examples: 
      | BrowserName | 
      |  Chrome     |
    
   @tsb-trademe-test @login-test  
   Scenario Outline: 3. To verify login page field error validations
    Given User select the <BrowserName> browser
    And User loads trademe home url in the selected browser
    When navigate to the login page
    And Login page - I see the heading text "Log in"
    And Login page - I click the login submit button
    Then Login page - I see the email field error message "This field is required"
    And Login page - I see the password field error message "This field is required"
   
    And User close the browser

    Examples: 
      | BrowserName | 
      |  Chrome     |

      
      

      
      