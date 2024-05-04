package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListAnItemPage_PF {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@class='tm-root__main']")
	WebElement search_page_text;
	
	@FindBy(xpath="//a[contains(.,'General item')]")
	WebElement general_list_link;
	
	@FindBy(xpath="//input[(@id ='Email')]")
	WebElement txt_usename;

	@FindBy(id="//input[(@id ='Password')]")
	WebElement txt_password;
	
	@FindBy(id="SignIn")
	WebElement button_login;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[4]/div[2]/div/ul/li")
	WebElement captcha_warning_message;
	
	@FindBy(xpath="//*[@id=\"Cancel\"]")
	WebElement cancel_link;
	
	@FindBy(xpath="//input[(@name ='title')]")
	WebElement list_title;
	
	@FindBy(xpath="//button[contains(.,'Choose category')]")
	WebElement chooseCategoryButton;
	
	@FindBy(xpath="//button[contains(.,'Clothing & Fashion')]")
	WebElement clothingFashionButton;
	
	@FindBy(xpath="//button[contains(.,'Men')]")
	WebElement menButton;
	
	@FindBy(xpath="//button[contains(.,'Tops & shirts')]")
	WebElement topShirtsButton;
	
	@FindBy(xpath="//input[(@name ='subtitle')]")
	WebElement list_sub_title;
	
	@FindBy(xpath="//button[contains(.,'Next')]")
	WebElement nextButton;
	
	@FindBy(xpath="//textarea[(@name ='description')]")
	WebElement list_description;
	
	@FindBy(xpath="(//input[(@name ='filter')])[1]")
	WebElement list_colour;
	
	@FindBy(xpath="//button[contains(.,'White')]")
	WebElement colourDropdownValue;
	
	@FindBy(xpath="(//input[(@name ='filter')])[2]")
	WebElement list_brand;
	
	@FindBy(xpath="//button[contains(.,'adidas')]")
	WebElement brandDropdownValue;
	
	
	@FindBy(xpath="//input[(@name ='buyNowPrice')]")
	WebElement buyNowPrice;
	
	@FindBy(xpath="//input[(@name ='startPrice')]")
	WebElement startPrice;
	
	@FindBy(xpath="//input[@id='tg-586']")
	WebElement pickUpButton;
	
	@FindBy(xpath="//input[@id='tg-590']")
	WebElement shippingButton;
	
	@FindBy(xpath="//button[contains(.,'Start listing')]")
	WebElement startListingButton;
	
	
	public ListAnItemPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String see_search_page_text() {
		 return search_page_text.getText();
	}
	
	public void clickGeneralListLink() throws InterruptedException {
		general_list_link.click();
	}
	
	public void listItemEnterUserName(String username) {
		txt_usename.sendKeys(username);
	}
	
	public void listItemEnterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void listItemClickLoginButton() {
		button_login.click();
	}
	
	public String listItemCaptchaWarningMessage() {
		 return captcha_warning_message.getText();
	}
	
	public void clickCancelButton() {
		cancel_link.click();
	}
	
	public void listItemTitle(String title) {
		list_title.sendKeys(title);
	}
	
	public void clickChooseCategoryButton() {
		chooseCategoryButton.click();
	}
	
	public void clickClothingFashionButton() {
		clothingFashionButton.click();
	}
	
	public void clickMenButton() {
		menButton.click();
	}
	
	public void clickTopsShirtsButton() {
		topShirtsButton.click();
	}
	
	public void listItemSubTitle(String title) {
		list_sub_title.sendKeys(title);
	}
	
	public void clickNextButton() {
		nextButton.click();
	}
	
	public void listItemDescription(String text) {
		list_description.sendKeys(text);
	}
	
	public void listItemColour(String text) {
		list_colour.sendKeys(text);
	}
	
	public void clickColourDropdownValue() {
		colourDropdownValue.click();
	}
	
	public void listItemBrand(String text) {
		list_brand.sendKeys(text);
	}
	
	public void clickBrandDropdownValue() {
		brandDropdownValue.click();
	}
	
	public void listItemBuyNowPrice(String price) {
		buyNowPrice.sendKeys(price);
	}
	
	public void listItemStartPrice(String price) {
		startPrice.sendKeys(price);
	}
	
	public void clickPickUpButton() {
		pickUpButton.click();
	}
	
	public void clickShippingButton() {
		shippingButton.click();
	}
	
	public void clickStartListingButton() {
		startListingButton.click();
	}
}
