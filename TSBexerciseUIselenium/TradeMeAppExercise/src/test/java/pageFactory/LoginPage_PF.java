package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
	
	WebDriver driver;
	
	@FindBy(id="Email")
	WebElement txt_usename;

	@FindBy(id="Password")
	WebElement txt_password;
	
	@FindBy(id="SignIn")
	WebElement button_login;
	
	@FindBy(xpath="(//a[contains(.,'My Trade Me')])[1]")
	WebElement click_link_MyTradeMe;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[4]/div[2]/div/ul/li")
	WebElement captcha_warning_message;
	
	@FindBy(xpath="//*[@id=\"Cancel\"]")
	WebElement cancel_link;
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[1]/h1")
	WebElement loggedIn_text;
	
	@FindBy(xpath="//*[@id=\"bodyElement\"]/div[1]/div/div[2]/div/div[2]/p")
	WebElement warning_message;
	
	@FindBy(xpath="//*[@id=\"bodyElement\"]/div[1]/div/div[2]/div/div[3]/h1")
	WebElement heading_text;
	
	@FindBy(xpath="//*[@id=\"bodyElement\"]/div[1]/div/div[2]/div/div[3]/p")
	WebElement info_text;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[1]/label")
	WebElement email_field_text;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[2]/label")
	WebElement password_field_text;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/p/a")
	WebElement link_text;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[3]/label/span")
	WebElement checkbox_text;
	
	@FindBy(xpath="//*[@id=\"recaptcha-anchor-label\"]")
	WebElement captcha_text;
	
	@FindBy(xpath="//*[@id=\"bodyElement\"]/div[1]/div/div[2]/div/p[1]/a")
	WebElement help_text;
	
	@FindBy(xpath="//*[@id=\"bodyElement\"]/div[1]/div/div[2]/div/p[2]")
	WebElement declaration_text;
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div/h1")
	WebElement page_heading_text;
	
	@FindBy(xpath="//*[@id=\"bodyElement\"]/div[1]/div/div[2]/div/div[3]/p/a")
	WebElement info_link_text;
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div/h1")
	WebElement create_accout_heading;
	
	@FindBy(xpath="/html/body/main/div[3]/div/div[2]/h1")
	WebElement logging_in_heading;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[1]/span")
	WebElement email_field_error_message;
	
	@FindBy(xpath="//*[@id=\"SignInForm\"]/fieldset/div[2]/span")
	WebElement password_field_error_message;
		
	
	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		txt_usename.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		button_login.click();
	}
	
	public void clickLinkMyTradeMe() {
		click_link_MyTradeMe.click();
	}

	
	public String captchaWarningMessage() {
		 return captcha_warning_message.getText();
	}

	public void clickCancelButton() {
		cancel_link.click();
	}
	
	public String see_LoggedIn_text() {
		 return loggedIn_text.getText();
	}
	
	public String warning_message() {
		 return warning_message.getText();
	}
	
	public String see_heading_text() {
		 return heading_text.getText();
	}
	
	public String see_info_text() {
		 return info_text.getText();
	}
	
	public String see_email_field_text() {
		 return email_field_text.getText();
	}
	
	public String see_password_field_text() {
		 return password_field_text.getText();
	}
	
	public String see_link_text() {
		return link_text.getText();
	}
	
	public String see_checkbox_text() {
		return checkbox_text.getText();
	}
	
	public String see_captcha_text() {
		return captcha_text.getText();
	}
	
	public String see_help_text() {
		return help_text.getText();
	}
	
	public String see_declaration_text() {
		return declaration_text.getText();
	}
	
	public void click_link_text() {
		 link_text.click();
	}
	
	public String see_page_heading_text() {
		return page_heading_text.getText();
	}
	
	public void click_info_link_text() {
		info_link_text.click();
	}
	
	public String see_create_accout_heading() {
		return create_accout_heading.getText();
	}
	
	public void click_help_text() {
		 help_text.click();
	}
	
	public String see_logging_in_heading() {
		return logging_in_heading.getText();
	}
	
	public String see_email_field_error_message() {
		return email_field_error_message.getText();
	}
	
	public String see_password_field_error_message() {
		return password_field_error_message.getText();
	}
}
