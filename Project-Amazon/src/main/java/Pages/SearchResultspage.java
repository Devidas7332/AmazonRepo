package Pages;




import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultspage {
	
	private WebDriver driver;
	  
	@FindBy(xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']")
	private WebElement selectFirstProduct;
	
	@FindBy(xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div//h2//a//span")
	private WebElement titleOfFirstItem;
	
	@FindBy(xpath="(//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//div//a//span)[14]")
	private WebElement priceOfFirstitem;
	
	@FindBy(xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-3']//button")
	private WebElement addToCart;
	
	
	public SearchResultspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void  clickInFirstItem()
	{
		selectFirstProduct.click();
	}
	
	public void clickOnSelectItem()
	{
		titleOfFirstItem.click();
	}
	public void clickOnPriceOfFirstItem()
	{
		priceOfFirstitem.click();
	}
	public void clickOnAddToCartButton()
	{
		addToCart.click();
	}
	
	
}

///////////////////////////////////////////////////////////////////

     // Amazon Test Class/////

//import java.awt.List;
//import java.time.Duration;
//import java.util.ArrayList;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import Pages.CartDetailPage;
//import Pages.HomePageClass;
//import Pages.LoginPageClass;
//import Pages.ProductPageClass;
//import Pages.SearchResultspage;
//import PopUpModule.RecoommendedAccessariesModule;
//
//public class TestClass {
//
//	
//	public static void main(String[] args) throws InterruptedException {
//		
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://www.amazon.in/");
//		
//		HomePageClass homePageClass= new HomePageClass(driver);
//		LoginPageClass loginPageClass=new LoginPageClass(driver);
//		loginPageClass.SendUserName("8552898167");
//		loginPageClass.ClickOnContinue();
//		loginPageClass.sendpass("123456789");
//		loginPageClass.ClickOnSignin();
//		Thread.sleep(20000);
//		
//		homePageClass = new HomePageClass(driver);
//		homePageClass.enterProductName("Mobile");
//		Thread.sleep(3000);
//		homePageClass.clickOnFirstProduct();
//		homePageClass.clickOnSearchButton();
//		
//		
//		SearchResultspage searchResultspage=new SearchResultspage(driver);
//		searchResultspage.clickOnSelectItem();
//		
//		//Child browser ( Switch from main page to child page
//		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(addr.get(1));
//		
//		ProductPageClass productPageClass = new ProductPageClass(driver);
//		String expectedProductName= productPageClass.getProductName();
//		String expectedProductPrice= productPageClass.getProductPrice();
//		productPageClass.ClickOnAddtoCartButton();
//		
//		Thread.sleep(5000);
//		RecoommendedAccessariesModule recoommendedAccessariesModule = new RecoommendedAccessariesModule(driver);
//		recoommendedAccessariesModule.clickOnCartbutton();
//		
//		//Cart Page
//		CartDetailPage cartDetailPage= new CartDetailPage(driver);
//		String actualProductname=cartDetailPage.getFirstProductName();
//		String actualProductPrice=cartDetailPage.getfirstProductPrice();
//		
//		if(expectedProductName.equals(actualProductname) && expectedProductPrice.equals(actualProductPrice))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
//	}
//}
//		
