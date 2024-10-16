package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartDetailPage {
				// when there is many item present in cart it gets first item name 
	@FindBy(xpath="(//div[@data-item-index='1'])[1]//h4//span[@class='a-truncate-cut']")
	private WebElement firstProductName;
	
	@FindBy(xpath="((//div[@data-item-index='1'])[1]//div[@class='sc-item-price-block']//div/span)[3]")
	private WebElement firstProdcutPrice;
	
	private WebDriver driver;
	
	public CartDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	
	public String getFirstProductName() throws InterruptedException
	{
		Thread.sleep(5000);
		return firstProductName.getText().trim();	
	}
	
	public String getfirstProductPrice()
	{
		return firstProdcutPrice.getText().trim();
	}
}
