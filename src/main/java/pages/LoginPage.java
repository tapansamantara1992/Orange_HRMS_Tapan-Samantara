package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

		//Encapsulation= data + function
		
			private WebDriver driver;
			
			//initialize driver
			public LoginPage(WebDriver driver)//Base class
			{
				this.driver=driver;
			}
			
			//by locator way
			private By uname=By.name("username");
			private By pass=By.name("password");
			private By btn=By.xpath("//button[@type='submit']");
			
			
			//method
			
			public void doLogin(String un,String psw)
			{
				driver.findElement(uname).sendKeys(un);
				driver.findElement(pass).sendKeys(psw);
				driver.findElement(btn).click();
			}
			
			public String getAppTitle()
			{
				return driver.getTitle();
			}
			
			
			public String getAppUrl()
			{
				return driver.getCurrentUrl();
			}
			
			
	}

