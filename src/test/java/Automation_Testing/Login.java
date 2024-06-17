package Automation_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login 
{
	static WebDriver driver;
	public static void main(String[] args) throws Exception 
	{
		driver = new ChromeDriver();
		 driver.get("http://uitestingplayground.com/");
		 driver.manage().window().maximize();
		 String title = driver.getTitle();
		 System.out.println("title:"+title);
		 driver.findElement(By.xpath("//a[normalize-space()='Resources']")).click();
		 WebElement elements = driver.findElement(By.linkText("devhints.io"));
		 elements.click();
	}

}
