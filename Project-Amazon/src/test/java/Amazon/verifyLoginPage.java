package Amazon;

import java.time.Duration;

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

import Pages.HomePageClass;
import Pages.LoginPageClass;

public class verifyLoginPage {
	
	private WebDriver driver;
	private HomePageClass homePageClass;
	private LoginPageClass loginPageClass;
	
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
	void InitializePOM()
	{	
		homePageClass= new HomePageClass(driver);
		loginPageClass=new LoginPageClass(driver);
	}
	@BeforeMethod
	void LoginIntoApplication()
	{
		driver.get("https://www.amazon.in/");
		homePageClass.clickOnaccAndsignIn();
	}
	@Test(groups={"Regression"})
	void VerifySuccessfullyLogin()
	{
		loginPageClass.SendUserName("8552898167");
		loginPageClass.ClickOnContinue();
		loginPageClass.sendpass("123456789");
		loginPageClass.ClickOnSignin();
		String actualUserName=homePageClass.getUserName();
		String expectedUserName="Hello, Devidas";
		Assert.assertEquals(actualUserName, expectedUserName);
		
	}
	@Test
	void verifysignInWithWrongPass()
	{
		loginPageClass.SendUserName("8552898167");
		loginPageClass.ClickOnContinue();
		loginPageClass.sendpass("9574621458");
		loginPageClass.ClickOnSignin();
		String actualMessage=loginPageClass.getHeaderErrorMessage();
		String expectedMessage="There was a problem";
		Assert.assertEquals(actualMessage, expectedMessage);
		String actualMessage1=loginPageClass.getErrorMessage();
		String expectedMessage1="Your password is incorrect";
		Assert.assertEquals(actualMessage1, expectedMessage1);
	}
	@AfterMethod
	void LogoutFromApllication() throws InterruptedException
	{
		Thread.sleep(5000);
		homePageClass.clickOnlogOut();
	}
	
	@AfterClass
	void RemovePOM()
	{
		homePageClass= null;
		loginPageClass=null;
		System.gc();
	}
	@AfterTest
	void Closed()
	{
		driver.quit();
	}
}
