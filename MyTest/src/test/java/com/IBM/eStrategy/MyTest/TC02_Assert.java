package com.IBM.eStrategy.MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_Assert {
	
	
  @Test
  public void TitleAssertion () {
	  
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\eclipse-workspace\\drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		String actual=driver.getTitle();
		
		System.out.println("actual title is "+actual);
		
		String expected="facebook";
		
		Assert.assertEquals(actual, expected);
			
		driver.close();
	  
	  
  }
}
