package com.IBM.eStrategy.createAccountPage;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.IBM.eStrategy.ProductPage.HomePage;
import com.IBM.eStrategy.testBase.TestBase;

public class TC002_NewAccount extends TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	HomePage home;
	
	String fname="jack";
	String lname="jill";
	String email="yash02verma@gmail.com";
	String psw="welcome121";
	String adr="i dont know address";
	String City="bangalore";
	String State="karnataka";
	String zpcode="00000";
	String cntry="india";
	String num="1212121212";
	String cremail="yash03verma@gmail.com";
		
	
	@BeforeTest
	public void setUp() {
		
		init();		
	}
	
	
	@Test
	public void registerNewAccount() {
		home=new HomePage(driver);
		home.RegisterNewAccount(cremail,fname, lname, email, psw, adr, City, State, zpcode, cntry, num);
	}
	
		
		@AfterTest() 
		public void endTest() {
			driver.quit();
		}		
		
	}
	

