package webTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import webTest.BaseClass;

public class LoginPageTest extends BaseClass
{
  
	  @Test(priority=1)
	  public void verifyTitle()
	  {
		 
		  String act=lp.getAppTitle();
		  Assert.assertTrue(act.contains("HRM"),"Error-Title not match");
		  System.out.println("Title match!");
	  }
	  
	  @Test(priority=2)
	  public void verifyLogin()
	  {
		 lp.doLogin("Admin","admin123");
	  }
	  
	  @Test(priority=3)
	  public void verifyCurrentUrl()
	  {
		  System.out.println(lp.getAppUrl());
	  }
  }
