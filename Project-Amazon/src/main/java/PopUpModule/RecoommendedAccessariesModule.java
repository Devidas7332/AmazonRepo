package PopUpModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoommendedAccessariesModule {
	private WebDriver driver;
	
	@FindBy(xpath="//span[@id='attach-sidesheet-view-cart-button']//input")
	private WebElement cartButton;
	
	public  RecoommendedAccessariesModule(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void clickOnCartbutton() 
	{
		cartButton.click();
	}

}
