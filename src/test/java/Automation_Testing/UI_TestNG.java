package Automation_Testing;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class UI_TestNG 
{
  WebDriver driver;
	
  @Test(priority=1)
  public void validateLaunchOfTestPlayground() 
  {
	  driver = new ChromeDriver();
	  driver.get("http://uitestingplayground.com/");
	  driver.manage().window().maximize();
	  String title = driver.getTitle();
	  Assert.assertEquals(title, "UI Test Automatio Playgroun");
	  System.out.println("title:"+title);
  }
  
  @Test(priority=2,dependsOnMethods = {"validateLaunchOfTestPlayground"},invocationCount = 3)
  public void validateResources()
  {
	  driver.findElement(By.xpath("//a[normalize-space()='Resources']")).click();
	  Assert.assertEquals(driver.getTitle(), "Resources");
	  System.out.println("Resource title is verified");
  }
  
  @Test(priority=3,dependsOnMethods = {"validateLaunchOfTestPlayground","validateResources"})
  public void validateDevhints()
  {
	  WebElement elements = driver.findElement(By.linkText("devhints.io"));
	  elements.click();
	  Assert.assertEquals(driver.getTitle(), "Devhints — TL;DR for developer documentation");
	  System.out.println("Devhints title is verified");
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("beforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("afterMethod");
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.out.println("beforeClass");
  }

  @AfterClass
  public void afterClass() 
  {
	  System.out.println("afterClass");
	  driver.close();
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("beforeTest");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("afterTest");
  }

  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("beforeSuite");
  }

  @AfterSuite
  public void afterSuite() 
  {
	  System.out.println("afterSuite");  
  }

}
