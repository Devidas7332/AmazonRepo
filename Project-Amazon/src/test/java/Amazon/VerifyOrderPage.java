package Amazon;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.HomePageClass;
import Pages.LoginPageClass;
import Pages.ReturnAndOrdersPageClass;

public class VerifyOrderPage {
	
	private WebDriver driver;
	private HomePageClass homePageClass;
	private LoginPageClass loginPageClass;
	private ReturnAndOrdersPageClass returnAndOrdersPageClass;
	
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
	void LaunchBrowser()
	{	
		homePageClass=new HomePageClass(driver );
		loginPageClass=new LoginPageClass(driver);
		returnAndOrdersPageClass = new ReturnAndOrdersPageClass (driver);	
	}
	@BeforeMethod
	void LoginToApplication()
	{
		driver.get("https://www.amazon.in/");
		
		homePageClass.clickOnaccAndsignIn();
	}
	@Test
	void VerifyLogin1()
	{
		loginPageClass.SendUserName("8552898167");
		loginPageClass.ClickOnContinue();
		loginPageClass.sendpass("123456789");
		loginPageClass.ClickOnSignin();
	}
	@Test
	void VerifyRetunAndOrders()
	{
		loginPageClass.SendUserName("8552898167");
		loginPageClass.ClickOnContinue();
		loginPageClass.sendpass("123456789");
		loginPageClass.ClickOnSignin();
		
		homePageClass.navigateToOrders();
		
		returnAndOrdersPageClass.clickOnBuyAgain();
		returnAndOrdersPageClass.clickOnCancalOrder();
	}
	@AfterMethod
	void LogoutFromApplication()
	{
		homePageClass.clickOnlogOut();
	}
	
	@AfterClass()
	void removePOM()
	{

		homePageClass=null;
		loginPageClass=null;
		returnAndOrdersPageClass = null;	
	}
	@AfterTest
	void Closed()
	{
		driver.quit();
	}

}
