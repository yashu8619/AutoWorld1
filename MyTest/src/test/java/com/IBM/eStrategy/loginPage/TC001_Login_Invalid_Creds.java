package com.IBM.eStrategy.loginPage;

import org.testng.annotations.Test;
import com.IBM.eStrategy.ProductPage.HomePage;
import com.IBM.eStrategy.testBase.TestBase;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;

public class TC001_Login_Invalid_Creds extends TestBase{
	
  public static final Logger log=Logger.getLogger(TestBase.class.getName());	
  HomePage home;
  //String emailAddress="yash01verma@gmail.com";
  //String password="welcome";	
  
  
  @DataProvider(name="loginData") 
  public String[][] getTestData() {
	  
	  String[][] testRecords = getData("Data.xlsx", "loginData");
	  return testRecords;	  
  }
	 
  @BeforeTest
  public void setUp() {  
  init();	  
  }
  
  @Test(dataProvider="loginData")
  public void loginToApplication(String emailAddress,String loginpassword,String runmode) {
  log.info("============= loginToApplication test started =============");
  if ( runmode.equalsIgnoreCase("n")) {
	  
	  throw new SkipException ("user marked run as no run");
  }
  home=new HomePage(driver);
  home.loginToApplication(emailAddress, loginpassword);  
  log.info("============ loginToApplication Test finished =============");
  boolean status=home.verifyLogoutDisplay();
  if(status) {  
	  home.verifyLogoutDisplay();
  }
  Assert.assertEquals(true, status);
  }
  
  @AfterTest
  public void closeBrowser() {
  log.info("Browser closed");
  driver.close();
  }
	  
	   
	  
  }
  
