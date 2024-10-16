package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	
	
		@FindBy(xpath="//input[@type='email']")
		private WebElement UserName;
		
		@FindBy(xpath="//input[@id='continue']")
		private WebElement Continue;
		
		@FindBy(xpath="//input[@id='ap_password']")
		private WebElement password;
		
		@FindBy(xpath="//input[@id='signInSubmit']")
		private WebElement signInButton;
		
		@FindBy(xpath="//h4[text()='There was a problem']")
		private WebElement ErrorHeader;
		
		@FindBy(xpath="//span[@class='a-list-item']")
		private WebElement ErrorMessage;
	
		private WebDriver driver;
		public LoginPageClass(WebDriver driver) {
			
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
		
		public void SendUserName(String userId) 
		
		{	
			UserName.sendKeys(userId);
		}
		public void ClickOnContinue()
		{
			Continue.click();
		}
		public void sendpass(String userPassword) 
		{
			password.sendKeys(userPassword);
		}
		public void ClickOnSignin()
		{
			signInButton .click();
		}
		public String getHeaderErrorMessage()
		{
			return ErrorHeader.getText().trim();
		}
		public String getErrorMessage()
		{
			return ErrorMessage.getText().trim();
		}
		
	
	}
