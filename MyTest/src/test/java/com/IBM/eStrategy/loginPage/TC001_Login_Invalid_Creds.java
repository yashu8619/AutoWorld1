package com.IBM.eStrategy.loginPage;

import org.testng.annotations.Test;
import com.IBM.eStrategy.ProductPage.HomePage;
import com.IBM.eStrategy.testBase.TestBase;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

public class TC001_Login_Invalid_Creds extends TestBase{
	
  public static final Logger log=Logger.getLogger(TestBase.class.getName());	
  HomePage home;
	
  
  @BeforeTest
  public void setUp() {
  
  init();
	  
  }
  
  @Test
  public void loginToApplication() {
  log.info("============= loginToApplication test started =============");
  home=new HomePage(driver);
  home.loginToApplication("yash01verma@gmail.com", "welcome");  
  log.info("============ loginToApplication Test finished =============");
  //Assert.assertEquals(driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li")).getText(), "Authentication failed.");
  
  }
  
  @AfterTest
  public void closeBrowser() {
  log.info("Browser closed");
  driver.close();
  }
	  
	   
	  
  }
  
