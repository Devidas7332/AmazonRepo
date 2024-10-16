package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {
	
	 @FindBy(xpath="//span[text()='Account & Lists']")
	 private WebElement accAndsignIn;
	 
	 @FindBy(xpath="//span[text()='Sign in']")
	 private WebElement signIn;
	 
	 @FindBy(xpath="//a[@id='nav-item-signout']//span[@class='nav-text']")
	 private WebElement logOutButton;
	 
	 @FindBy(xpath="//input[@id='twotabsearchtextbox']")
	 private WebElement searchTextBox;
	 
	 @FindBy(xpath="//input[@id='nav-search-submit-button']")
	 private WebElement searchButton;
	 
	 @FindBy(xpath="(//div[@id='nav-flyout-iss-anchor']//div[@role='button'])[1]")
	 private  WebElement suggestionOptions;
	 
	 @FindBy(xpath="(//div[@id='nav-tools'])//a/span[@class='nav-line-2']")
		private WebElement orders;
	 
	 @FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	 private WebElement USERNAME;
	 
	 private WebDriver driver;
	 private Actions act;
	 
	 public HomePageClass(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 this.driver=driver;
		 act= new Actions(driver);
	 }
	 
	 public void clickOnaccAndsignIn()
	 {
		 accAndsignIn.click();
	 }
	 
	 public void clickOnSignInbutton()
	 {
		 act.moveToElement(accAndsignIn).moveToElement(signIn).click().build().perform();
	 }
	 public void clickOnlogOut()
	 {
		 act.moveToElement(accAndsignIn).moveToElement(logOutButton).click().build().perform();
	 }
	 public void enterProductName(String productName)
	 {
		 searchTextBox.sendKeys(productName);
	 }
	 
	 public void clickOnSearchButton() throws InterruptedException
	 {
		 Thread.sleep(3000);
		 searchButton.click();
	 }
	 public void clickOnFirstProduct()
	 {
		 suggestionOptions.click();
	 }
	 public void navigateToOrders()
		{
			act.moveToElement(orders).click().build().perform();
		}
	 public String  getUserName()
	 {
		return  USERNAME.getText().trim();
	 }
	 
	
	
	 

}
