package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

private WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}

	//locator
	private By menu=By.xpath("//ul[@class='oxd-main-menu']//li//span");
	private By uname=By.xpath("(//input[contains(@class,'oxd-input')])[2]");
	private By userrole=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
	private By status=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
	private By empname=By.xpath("//input[@placeholder='Type for hints...']");
	private By searchbtn=By.xpath("//button[@type='submit']");
	private By resetbtn=By.xpath("//button[normalize-space()='Reset']");
	private By recordmsg=By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]");
	private By userROptions=By.xpath("//div[@role='listbox']//div[@role='option']");
	private By statustext=By.xpath("//div[@role='option']//span");
	//methods
	public void getMenu()
	{
		List<WebElement> list=driver.findElements(menu);
		
		System.out.println("Total menu options are: "+list.size());
		
		for(WebElement i:list)
		{
			System.out.println(i.getText());
			if(i.getText().contains("Admin"))
			{
				i.click();
				break;
			}
		}
		
		
	}
	
	public void searchEmpByUsername(String name)
	{
		System.out.println("Search Employee by UserName");
		driver.findElement(uname).sendKeys(name);
		
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(recordmsg).getText());
		
		driver.findElement(uname).clear();
	}
	
	public void searchEmpByUserRole(String role)
	{		System.out.println("Search Employee by UserRole");

		driver.findElement(userrole).click();
		List<WebElement> list=driver.findElements(userROptions);
		for(WebElement i:list)
		{
			if(i.getText().contains(role))
			{
				i.click();
				break;
			}
		}
		
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(recordmsg).getText());
		
		driver.navigate().refresh();
	}
	
	
	public void searchEmpByStatus(String stat)
	{
		System.out.println("Search Employee by Status");

		driver.findElement(status).click();
		List<WebElement> list=driver.findElements(statustext);
		for(WebElement i:list)
		{
			if(i.getText().contains(stat))
			{
				i.click();
				break;
			}
		}
		
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(recordmsg).getText());
		
	}
	
	
	
	
	
}

