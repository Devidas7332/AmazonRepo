package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageClass {
	
	private WebDriver driver;
	private Actions act;
	
	
	@FindBy(xpath="(//span[@class='a-size-large product-title-word-break']")
	 private WebElement productName;
	 
	 @FindBy(xpath="(//span[@class='a-price-whole'])[10]")
	 private WebElement productPrice;
	 
	
	@FindBy(xpath="(//input[@id='add-to-cart-button'])[2]")
	private WebElement addcart;
	
	@FindBy(xpath="//input[@id='buy-now-button']")
	private WebElement buyNow;
 
	 @FindBy(xpath="//span[text()='Sign Out']")
	 private WebElement logout;
	 
	
	public ProductPageClass(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	 public String  getProductName()
	 {
		return productName.getText().trim();
	 }
	 public String getProductPrice()
	 {
		return productPrice.getText().trim();
	 }
	public void ClickOnAddtoCartButton()
	{
		addcart.click();	}
	
	public void ClickOnBuynow()
	{
		buyNow.click();
	}
	
}
