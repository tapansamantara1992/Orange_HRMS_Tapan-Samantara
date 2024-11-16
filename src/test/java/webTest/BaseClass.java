package webTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import pages.*;



public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public DashboardPage dp;
	
	
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		lp=new LoginPage(driver);
		dp=new DashboardPage(driver);
		 
	}
	
	@BeforeClass
	public void pageSetup()
	{
		System.out.println("Login Test");
		lp.doLogin("Admin","admin123");
		
	}
	
}