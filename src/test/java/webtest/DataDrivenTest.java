package webtest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest 
{
  
	  public static WebDriver driver;
	  @Test(dataProvider ="Excel",dataProviderClass = CustomData.class)
	  public void testdatadriven(String username,String password) throws InterruptedException {
		  driver = new ChromeDriver();
		  //driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  
		  driver.findElement(By.name("username")).sendKeys(username);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
		    Thread.sleep(2000);
		    DataDrivenTest capstoneproject=new DataDrivenTest();
			   capstoneproject.captureScreenshot(capstoneproject);
			  
		    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login Fail");

		    System.out.println("Login Successfull");
			  
			//  driver.quit();
	
		 
	  }
	  
	  public void captureScreenshot(Object fileName)
		{
		  String timestamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir")+ "//Reports//ScreenshortHrms//"+"DataDrivenTest"+timestamp+".png");
			
			try {
				FileHandler.copy(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ScreenShot captured!");
		}
}