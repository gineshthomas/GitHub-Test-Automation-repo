
Test scripts details:
**Test feature files are available in folder >> \TradeMeAppExercise\src\test\resources\Features
**StepDefinitions and Test Runner files are available in folder >> \TradeMeAppExercise\src\test\java\StepDef
**Page Factory elements are available in folder >> \TradeMeAppExercise\src\test\java\pageFactory

Test Execution details:
**Browser drivers for the browsers (Chrome/Firefox/Edge) are available in the folder >> \TradeMeAppExercise\src\test\resources\drivers
**Make sure that you keep corresponding driver for the browser version
** For test execution, open 'command prompt', point to path 'C:\TSBexerciseUIselenium\TradeMeAppExercise>', 
   first run command>>mvn clean test; then run command >>mvn verify -DskipTests; to generate cucumber reports in the folder>>mvn verify -DskipTests;
   Latest execution cucumber reports are available in the 'target' folder for reference (2 tests are failed due to the CAPTCHA issue while running)

Note:
1. Change BrowserName value accordingly for execution eg: 'Chrome' for chrome browser, 'Firefox' for firefox browser and 'Edge' for MS edge browser
2. CAPTCHA handling is not done. Possible solutions for this>> a) Manually do CAPTCHA by providing wait time in the scrips or b) sign up with 2captcha, capmonster cloud, 
   deathbycaptcha, etc. and follow their instructions. They will give you a token that you pass with the form. or c) disbale CAPTCHA in the test environment

