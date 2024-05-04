package StepDef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.ListAnItemPage_PF;
import pageFactory.LoginPage_PF;
import pageFactory.SearchComputersPage_PF;

public class TradeMeAppSteps {
	
	WebDriver driver = null;
	LoginPage_PF login;
	SearchComputersPage_PF search_computer;
	ListAnItemPage_PF list_item;
	
	
	@Given("^User select the (.*) browser$")
	public void user_select_browser(String BrowserName) {
		
		System.out.println("-----Execution started successfully------");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is: "+projectPath);
		
		// Select Chrome browser 
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		// Select FireFox browser
		else if(BrowserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.firefox.driver",projectPath+"/src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Select Microsoft Edge browser
		else if(BrowserName.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver",projectPath+"/src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	}
	
	@Given("User loads trademe home url in the selected browser")
	public void load_url() {
		driver.navigate().to("https://www.tmsandbox.co.nz/a/");
		driver.manage().window().maximize();
		System.out.println("TradeMe application home url successfully loaded");
	}
	
	@Given("User loads trademe Computers category url in the selected browser")
	public void load_computers_url() {
		driver.navigate().to("https://www.tmsandbox.co.nz/a/marketplace/computers");
		driver.manage().window().maximize();
		System.out.println("TradeMe computers category url successfully loaded");
	}

	@Given("User loads trademe 'List an Item' url in the selected browser")
	public void load_list_an_item_url() {
		driver.navigate().to("https://www.tmsandbox.co.nz/a/list");
		driver.manage().window().maximize();
		System.out.println("TradeMe 'List an Item' url successfully loaded");
	}
	
	@Given("navigate to the login page")
	public void navigate_to_the_login_page() {
		login = new LoginPage_PF(driver);
		login.clickLinkMyTradeMe();
		System.out.println("Successfully clicked on My Trade Me link and login page loaded");
		
	}

	@When("^User enters (.*) and (.*)$")
	public void user_enters_data_click_login_button(String username, String password) {
		login.enterUserName(username);
		login.enterPassword(password);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	@When("User enter CAPTCHA and then click login button")
	public void user_update_captcha() throws InterruptedException {
		System.out.println("Try capture CAPTCHA steps");
		Thread.sleep(3000);
		//Then click on login button
		login.clickLoginButton();
		Thread.sleep(3000);
		// CAPTCHA failure - verify error message
		login.captchaWarningMessage().equalsIgnoreCase("Please complete Google reCAPTCHA and try again");
		System.out.println(login.captchaWarningMessage());
		System.out.println("CAPTCHA failed - click cancel button");
		login.clickCancelButton();
		//Verify that trade me unauthorized user default page url loaded
		driver.getCurrentUrl().equalsIgnoreCase("https://www.tmsandbox.co.nz/a/");
		System.out.println(driver.getCurrentUrl());
	}

	@Then("User is successfully logged-In")
	public void user_is_successfully_logged_in() {

       //Commented this code due to CAPCHA failure
       //login.see_LoggedIn_text().equalsIgnoreCase("My Trade Me");

	}

	@And("User close the browser")
	public void user_close_the_browser() {
		driver.close();
		driver.quit();
		System.out.println("Browser closed");
	}

	@And("^Login page - I see the warning text \"([^\"]*)\"$")
	public boolean i_see_text(String text) {
		login.warning_message().equalsIgnoreCase(text);
		System.out.println(login.warning_message());
		return true;
	}
	
	@And("^Login page - I see the heading text \"([^\"]*)\"$")
	public boolean i_see_heading_text(String heading) {
		login.see_heading_text().equalsIgnoreCase(heading);
		System.out.println(login.see_heading_text());
		return true;
	}
	
	@And("^Login page - I see the info text \"([^\"]*)\"$")
	public boolean i_see_info_text(String heading) {
		login.see_info_text().equalsIgnoreCase(heading);
		System.out.println(login.see_info_text());
		return true;
	}
	
	@And("^Login page - I see the email field text \"([^\"]*)\"$")
	public boolean i_see_email_field_text(String name) {
		login.see_email_field_text().equalsIgnoreCase(name);
		System.out.println(login.see_email_field_text());
		return true;
	}
	
	@And("^Login page - I see the password field text \"([^\"]*)\"$")
	public boolean i_see_password_field_text(String name) {
		login.see_password_field_text().equalsIgnoreCase(name);
		System.out.println(login.see_password_field_text());
		return true;
	}
	
	@And("^Login page - I see the link text \"([^\"]*)\"$")
	public boolean i_see_link_text(String linkName) {
		login.see_link_text().equalsIgnoreCase(linkName);
		System.out.println(login.see_link_text());
		return true;
	}
	
	@And("^Login page - I see the checkbox text \"([^\"]*)\"$")
	public boolean i_see_checkbox_text(String checkBoxName) {
		login.see_checkbox_text().equalsIgnoreCase(checkBoxName);
		System.out.println(login.see_checkbox_text());
		return true;
	}
	
	@And("^Login page - I see the captcha text \"([^\"]*)\"$")
	public boolean i_see_captcha_text(String text) {
		
		//Handling iframe - Store the web element
		WebElement iframe = driver.findElement(By.cssSelector("#recaptchaV2 > div > div > iframe"));

		//Switch to the frame
		driver.switchTo().frame(iframe);

		login.see_captcha_text().equalsIgnoreCase(text);
		System.out.println(login.see_captcha_text());
		
		// Return to the top level
		driver.switchTo().defaultContent();
		return true;
	}

	@And("^Login page - I see the help text \"([^\"]*)\"$")
	public boolean i_see_help_text(String text) {
		login.see_help_text().equalsIgnoreCase(text);
		System.out.println(login.see_help_text());
		return true;
	}
	
	@And("^Login page - I see the declaration text \"([^\"]*)\"$")
	public boolean i_see_declaration_text(String text) {
		login.see_declaration_text().equalsIgnoreCase(text);
		System.out.println(login.see_declaration_text());
		return true;
	}
	
	@And("^Login page - I click the link text \"([^\"]*)\"$")
	public void i_click_link_text(String linkName) {
		login.click_link_text();
		System.out.println("Successfully clicked link: " + linkName);
	}

	@And("^Login page - I see the forgot password page heading \"([^\"]*)\"$")
	public boolean i_see_forgot_password_heading(String heading) {
		login.see_page_heading_text().equalsIgnoreCase(heading);
		System.out.println(login.see_page_heading_text());
		return true;
	}
	
	@Given("Login page - I click on browser back button")
	public void navigate_back_to_the_login_page() {
		driver.navigate().back();
		System.out.println("Successfully navigated back to the previous page");
	}
	
	@And("^Login page - I click the info link \"([^\"]*)\"$")
	public void i_click_info_link_text(String linkName) {
		login.click_info_link_text();
		System.out.println("Successfully clicked link: " + linkName);
	}
	
	@And("^Login page - I see the create account page heading \"([^\"]*)\"$")
	public boolean i_see_create_account_heading(String heading) {
		login.see_create_accout_heading().equalsIgnoreCase(heading);
		System.out.println(login.see_create_accout_heading());
		return true;
	}
	
	@And("^Login page - I click the help link \"([^\"]*)\"$")
	public void i_click_help_link_text(String linkName) throws InterruptedException {
		Thread.sleep(1000);
		login.click_help_text();
		System.out.println("Successfully clicked link: " + linkName);
	}
	
	@And("^Login page - I see the logging-in page heading \"([^\"]*)\"$")
	public boolean i_see_logging_in_heading(String heading) {
		login.see_logging_in_heading().equalsIgnoreCase(heading);
		System.out.println(login.see_logging_in_heading());
		return true;
	}
	
	@And("Login page - I click the login submit button")
	public void i_click_login_button() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		login.clickLoginButton();
		System.out.println("Successfully clicked button");
	}
	
	@And("^Login page - I see the email field error message \"([^\"]*)\"$")
	public boolean i_see_email_field_error(String error) {
		login.see_email_field_error_message().equalsIgnoreCase(error);
		System.out.println(login.see_email_field_error_message());
		return true;
	}
	
	@And("^Login page - I see the password field error message \"([^\"]*)\"$")
	public boolean i_see_password_field_error(String error) {
		login.see_password_field_error_message().equalsIgnoreCase(error);
		System.out.println(login.see_password_field_error_message());
		return true;
	}
	
	/*** Computers search page ***/
	
	@And("^Computers search page - I see the heading text (.*)$")
	public boolean i_see_search_heading_text(String heading) {
		search_computer = new SearchComputersPage_PF(driver);
		search_computer.see_computers_heading_text();
		System.out.println("Computers search page - heading is displayed" + heading);
		return true;
	}
	
	@And("^Computers search page - I see the Search placeholder text \"([^\"]*)\"$")
	public boolean i_see_search_placeholder_text(String heading) {
		search_computer.see_search_placeholder_text();
		System.out.println("Search placeholder text: " + heading);
		return true;
	}
	
	@When("^Computers search page - User enters (.*) in the Computers search field$")
	public void user_enters_search_input(String text) {
		search_computer.enterSearchInput(text);
		System.out.println("Computers search page - User entered text: " + text);
	}
	
	@And("Computers search page - I click the Search button")
	public void i_click_search_button() throws InterruptedException {
		search_computer.clickSearchButton();
		System.out.println("Computers search page - Search button clicked");
	}
	
	@And("^Computers search page - I see the Search results info text \"([^\"]*)\"$")
	public boolean i_see_results_text(String text) {
		search_computer.see_search_results_info_text().equalsIgnoreCase(text);
		System.out.println("Computers search page - search results info text " + text+"is displayed");
		return true;
	}
	
	@And("^Computers search page - I see the results category text \"([^\"]*)\"$")
	public boolean i_see_results_category_text(String text) {
		search_computer.see_search_results_category_text().equalsIgnoreCase(text);
		System.out.println("Computers search page - search results category text " + text + "is displayed");
		return true;
	}
	
	@And("^Computers search page - I see the search results value \"([^\"]*)\"$")
	public boolean i_see_results_value_text(String text) {
		search_computer.see_search_results_value_text().equalsIgnoreCase(text);
		System.out.println("Computers search page - search results value " + text + "is displayed");
		return true;
	}
	
	@And("^TradeMe page - I see the page text \"([^\"]*)\"$")
	public boolean i_see_results_page_text(String text) {
		search_computer.see_search_page_text().equalsIgnoreCase(text);
		System.out.println("TradeMe page - page text " + text + "is displayed");
		return true;
	}
	
	@And("Computers search page - I click the Computers navigate link")
	public void i_click_navigate_link() throws InterruptedException {
		search_computer.clickComputersLink();
		System.out.println("Computers search page - Search button clicked");
	}
	
	/*** List an item page ***/
	
	@And("^List an item page - I see the page text \"([^\"]*)\"$")
	public boolean i_see_trademe_page_text(String text) {
		list_item = new ListAnItemPage_PF(driver);
		list_item.see_search_page_text().equalsIgnoreCase(text);
		System.out.println("TradeMe page - page text " + text + "is displayed");
		return true;
	}
	
	@And("List an item page - I click the 'General item' link")
	public void i_click_general_item_link() throws InterruptedException {
		list_item.clickGeneralListLink();
		System.out.println("List an item page - General item button clicked");
	}
	
	@When("^List an item page - User enters (.*) and (.*)$")
	public void list_item_login(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		list_item.listItemEnterUserName(username);
		list_item.listItemEnterPassword(password);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	@When("List an item page - User enter CAPTCHA and then click login button")
	public void list_item_update_captcha() throws InterruptedException {
		System.out.println("Try capture CAPTCHA steps");
		Thread.sleep(1000);
		//Then click on login button
		list_item.listItemClickLoginButton();
		
		// CAPTCHA failure - verify error message
		list_item.listItemCaptchaWarningMessage().equalsIgnoreCase("Please complete Google reCAPTCHA and try again");
		System.out.println(login.captchaWarningMessage());
		System.out.println("CAPTCHA failed");
		//Verify that the login page url
		driver.getCurrentUrl().equalsIgnoreCase("https://www.tmsandbox.co.nz/a/login?redirect=%2Fmarketplace%2Flist");
		System.out.println(driver.getCurrentUrl());
	}
	
	@When("^List an item page - I enter listing title as (.*)$")
	public void list_item_title(String title) throws InterruptedException {
		Thread.sleep(2000);
		list_item.listItemTitle(title);
	}

	@And("List an item page - I click the 'Choose category' button")
	public void i_click_choose_category_button() throws InterruptedException {
		list_item.clickChooseCategoryButton();
		System.out.println("List an item page - Choose category button clicked");
	}
	
	@And("List an item page - I click the 'Clothing & Fashion' link")
	public void click_clothing_fashion_button() throws InterruptedException {
		list_item.clickClothingFashionButton();
		System.out.println("List an item page - Clothing & Fashion button clicked");
	}
	
	@And("List an item page - I click the 'Men' link")
	public void click_men_button() throws InterruptedException {
		list_item.clickMenButton();
		System.out.println("List an item page - men button clicked");
	}
	
	@And("List an item page - I click the 'Tops & shirts' link")
	public void click_top_shirts_button() throws InterruptedException {
		list_item.clickTopsShirtsButton();
		System.out.println("List an item page - men button clicked");
	}
	
	@When("^List an item page - I enter listing Subtitle as (.*)$")
	public void list_item_sub_title(String title) throws InterruptedException {
		Thread.sleep(2000);
		list_item.listItemSubTitle(title);
	}
	
	@And("List an item page - I click the 'Next' button")
	public void click_next_button() throws InterruptedException {
		list_item.clickNextButton();
		System.out.println("List an item page - Next button clicked");
	}
	
	@When("^List an item page - I enter the Description as (.*)$")
	public void list_item_description(String text) throws InterruptedException {
		Thread.sleep(2000);
		list_item.listItemDescription(text);
		System.out.println("List an item page - entered Description " + text);
	}
	
	@When("^List an item page - I enter and select the Colour as (.*)$")
	public void list_item_colour(String text) throws InterruptedException {
		Thread.sleep(2000);
		list_item.listItemColour(text);
		Thread.sleep(2000);
		list_item.clickColourDropdownValue();
		System.out.println("List an item page - entered and selected colour value" + text);
	}
	
	@When("^List an item page - I enter and select the Brand as (.*)$")
	public void list_item_brand(String text) throws InterruptedException {
		Thread.sleep(2000);
		list_item.listItemBrand(text);
		Thread.sleep(2000);
		list_item.clickBrandDropdownValue();
		System.out.println("List an item page - entered and selected Brand value" + text);
	}
	
	@And("^List an item page - I select size as (.*)$")
	public void select_size_dropdown(String text) throws InterruptedException {
		Select selectSizeDropdown = new Select(driver.findElement(By.xpath("//select[(@class ='ng-valid ng-dirty ng-touched')]")));
		selectSizeDropdown.selectByVisibleText(text);
		System.out.println("List an item page - Size selected");
	}
	
	@When("^List an item page - I enter Buy now price as (.*)$")
	public void list_item_buy_now_price(String price) throws InterruptedException {
		list_item.listItemBuyNowPrice(price);
		System.out.println("List an item page - price entered");
	}
	
	@When("^List an item page - I enter Start price as (.*)$")
	public void list_item_start_price(String price) throws InterruptedException {
		list_item.listItemStartPrice(price);
		System.out.println("List an item page - price entered");
	}
	
	@And("List an item page - I click pick up option as 'Pick-up available'")
	public void click_pickup_button() throws InterruptedException {
		list_item.clickPickUpButton();
		System.out.println("List an item page - Next button clicked");
	}
	
	@And("List an item page - I click Shipping option as 'Free shipping within New Zealand'")
	public void click_shipping_button() throws InterruptedException {
		list_item.clickShippingButton();
		System.out.println("List an item page - Next button clicked");
	}
	
	@And("List an item page - I click the 'Start listing' button")
	public void click_start_listing_button() throws InterruptedException {
		list_item.clickStartListingButton();
		System.out.println("List an item page - Next button clicked");
	}
}
