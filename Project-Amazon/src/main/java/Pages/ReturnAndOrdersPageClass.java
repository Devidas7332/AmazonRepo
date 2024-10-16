package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReturnAndOrdersPageClass {
	
//	@FindBy(xpath="(//div[@id='nav-tools'])//a/span[@class='nav-line-2']")
//	private WebElement orders;
	
	@FindBy(xpath="(//a[text()='Buy Again'])[2]")
	private WebElement buyAgain;
	
	@FindBy(xpath="//a[text()='Cancelled Orders']")
	private WebElement cancelledOrders;
	
	private WebDriver driver;
	private Actions act;
	public ReturnAndOrdersPageClass (WebDriver driver)
	{
		PageFactory.initElements(driver, this );
		this.driver=driver;
		act=new Actions(driver);
	}
	
//	public void navigateToOrders()
//	{
//		act.moveToElement(orders).click().build().perform();
//	}
	
	public void clickOnBuyAgain()
	{
		buyAgain.click();
	}
	public void clickOnCancalOrder()
	{
		cancelledOrders.click();
	}

}
