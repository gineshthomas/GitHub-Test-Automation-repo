package pageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchComputersPage_PF {
	
	WebDriver driver;
	
	@FindBy(xpath="//h1[contains(.,'Computers')]")
	WebElement computers_heading_text;
	
	@FindBy(xpath="//input[(@placeholder ='Search within Computers')]")
	WebElement search_placeholder_text;
	
	@FindBy(xpath="(//input[(@name ='search')])[2]")
	WebElement txt_search;
	
	@FindBy(xpath="//button[(@type ='submit')]")
	WebElement button_search;
	
	@FindBy(xpath="//h3[contains(.,' Showing 1 result for')]")
	WebElement search_results_info_text;
	
	@FindBy(xpath="//a[contains(.,'Cables & adaptors')]")
	WebElement search_results_category_text;
	
	@FindBy(xpath="/html/body/tm-root/div[1]/main/div/ng-component/div/div/div/div/div/tm-search-results/div/div[2]/tg-row/tg-col[2]")
	WebElement search_results_value_text;
	
	@FindBy(xpath="//*[@class='tm-root__main']")
	WebElement search_page_text;
	
	@FindBy(xpath="(//span[contains(.,'Computers')])[1]")
	WebElement computers_link;
	
	
	public SearchComputersPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean see_computers_heading_text() {
		 return computers_heading_text.isDisplayed();
	}
	
	public void see_search_placeholder_text() {
		 search_placeholder_text.isDisplayed();
	}
	
	public void enterSearchInput(String text) {
		txt_search.sendKeys(text);
		txt_search.sendKeys(Keys.TAB);
		txt_search.sendKeys(Keys.TAB);
		
	}

	public void clickSearchButton() {
		button_search.click();
//		button_search.sendKeys(Keys.ENTER);
	}
	
	public String see_search_results_info_text() {
		 return search_results_info_text.getText();
	}
	
	public String see_search_results_category_text() {
		 return search_results_category_text.getText();
	}
	
	public String see_search_results_value_text() {
		 return search_results_value_text.getText();
	}
	
	public String see_search_page_text() {
		 return search_page_text.getText();
	}
	
	public void clickComputersLink() throws InterruptedException {
		Thread.sleep(2000);
		computers_link.click();
		Thread.sleep(1000);
		computers_link.click();
		Thread.sleep(2000);
	}
}
