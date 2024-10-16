package Amazon;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.CartDetailPage;
import Pages.HomePageClass;
import Pages.LoginPageClass;
import Pages.ProductPageClass;
import Pages.SearchResultspage;
import PopUpModule.RecoommendedAccessariesModule;


public class AmazonTestNGClass {
	
	private WebDriver driver;
	private HomePageClass homePageClass;
	private LoginPageClass loginPageClass;
	private SearchResultspage searchResultspage;
	private ProductPageClass productPageClass;
	private RecoommendedAccessariesModule recoommendedAccessariesModule;
	private CartDetailPage cartDetailPage;
	
	@Parameters("browser")
	@BeforeTest
	void LaunchBrowser(String expectedBrowser) {
	if(expectedBrowser.equals("Chrome"))
	{
		driver = new ChromeDriver();		
	}
	if(expectedBrowser.equals("FireFox"))
	{
		driver = new FirefoxDriver();	
	}
	if(expectedBrowser.equals("Edge"))
	{
		driver = new EdgeDriver();	
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	@BeforeClass
	void initializePOM()
	{
		homePageClass= new HomePageClass(driver);
		loginPageClass=new LoginPageClass(driver);
		searchResultspage=new SearchResultspage(driver);
		productPageClass = new ProductPageClass(driver);
		recoommendedAccessariesModule = new RecoommendedAccessariesModule(driver);
		cartDetailPage= new CartDetailPage(driver);	
	}
	@BeforeMethod 
	void LoginToAppplication()
	{
		driver.get("https://www.amazon.in/");

		homePageClass.clickOnaccAndsignIn();
		loginPageClass.SendUserName("8552898167");
		loginPageClass.ClickOnContinue();
		loginPageClass.sendpass("123456789");
		loginPageClass.ClickOnSignin();	
	}
	
	@Test 
	void VerifyTittle()
	{
		String actualURL= driver.getCurrentUrl();
		String expectedURL= "https://www.amazon.in/?ref_=nav_ya_signin";
		
		Assert.assertEquals(actualURL, expectedURL);
	}
	@Test
	void verifyAddToCart() throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.getTitle()	
		//homePageClass = new HomePageClass(driver);
		homePageClass.enterProductName("Mobile");
		Thread.sleep(3000);
		homePageClass.clickOnFirstProduct();
		homePageClass.clickOnSearchButton();
		
		searchResultspage.clickOnSelectItem();
		//Child browser ( Switch from main page to child page
		ArrayList<String> addr= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		Thread.sleep(5000);
		String expectedProductName= productPageClass.getProductName();
		String expectedProductPrice= productPageClass.getProductPrice();
		productPageClass.ClickOnAddtoCartButton();
		
		Thread.sleep(5000);
		recoommendedAccessariesModule.clickOnCartbutton();
		//Cart Page
		String actualProductname=cartDetailPage.getFirstProductName();
		String actualProductPrice=cartDetailPage.getfirstProductPrice();
		
		Assert.assertEquals(actualProductname, expectedProductName);
		Assert.assertEquals(actualProductPrice, expectedProductPrice);	
	}
		@AfterMethod
		void logOutFromApplication()
		{
			homePageClass.clickOnlogOut();
		}	
		@AfterClass
		void RemovePOM()
		{
			homePageClass= null;
			loginPageClass=null;
			searchResultspage=null;
			productPageClass = null;
			recoommendedAccessariesModule = null;
			cartDetailPage= null;	
			System.gc();
		}
		@AfterTest
		void closed()
		{
			driver.quit();
		}
		
	}

