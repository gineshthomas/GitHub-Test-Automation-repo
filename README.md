UI TESTS:

Test scripts details:
** Tools used - Selenium/Cucumber/Maven/Java
** Created a user specific login in the TradeMe Sandbox application (Test user: gineshthomas@gmail.com)
**Test feature files are available in folder >> \TradeMeAppExercise\src\test\resources\Features
**StepDefinitions and Test Runner files are available in folder >> \TradeMeAppExercise\src\test\java\StepDef
**Page Factory elements are available in folder >> \TradeMeAppExercise\src\test\java\pageFactory
** Test details (below); 
   1. Customer Login Scenarios: - added 3 scenarios for the feature (CustomerLogin.feature) - one to test valid and invalid login functionalities; next to test login page UI validations and the final to verify page error validations.
   2. Basic Search Functionality: - added 1 scenario for the feature (SearchComputersBasic.feature)- Checks the search functionalities within 'Computers category' - validates functionalities and page UI validations
   3. Listing an Item: - Added 1 scenario for the feature (ListAnItemGeneral.feature) - Checks the workflow of Listing a generic item includiing pagewise validations.  

Test Execution details:
**Browser drivers for the browsers (Chrome/Firefox/Edge) are available in the folder >> \TradeMeAppExercise\src\test\resources\drivers
**Make sure that you keep corresponding driver for the browser version
** For test execution, open 'command prompt', point to path 'C:\TSBexerciseUIselenium\TradeMeAppExercise>', 
   first run command>>mvn clean test; then run command >>mvn verify -DskipTests; to generate cucumber reports in the folder>>mvn verify -DskipTests;
   Latest execution cucumber reports are available in the 'target' folder for reference (2 tests are failed due to the CAPTCHA issue while running)

Notes:
1. Change BrowserName value accordingly for execution eg: 'Chrome' for chrome browser, 'Firefox' for firefox browser and 'Edge' for MS edge browser
2. CAPTCHA handling is not done. Possible solutions for this>> a) Manually do CAPTCHA by providing wait time in the scrips or b) sign up with 2captcha, capmonster cloud, deathbycaptcha, etc. and follow their instructions. They will give you a token that you pass with the form. or c) disbale CAPTCHA in the test environment

API TESTS:

** Tools used - POSTMAN (Test user: gineshthomas@gmail.com)
** Refer the export file in the repository for tests >> https://github.com/gineshthomas/GitHub-Test-Automation-repo/blob/main/TSB-API-Exercise-Ginesh.postman_collection.json
** Test details:
    1. Retrieve Latest Listings: one GET request added to retrieve all latest listings - file: GET-LatestListings
    2. List an Item: 11 POST requests added for the examples given in page https://developer.trademe.co.nz/api-reference/selling-methods/list-an-item
    3. Authorisation details available in corresponding sections
   

