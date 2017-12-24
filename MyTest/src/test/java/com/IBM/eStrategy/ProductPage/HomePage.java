package com.IBM.eStrategy.ProductPage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.IBM.eStrategy.testBase.TestBase;

public class HomePage {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement SignIn;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement signOut;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement submitButton;
	
	//====================================================================================================================
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement createEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement subCreate;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement MrRadio;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement MsRadio;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement cust_firstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement cust_lastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailAdress;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement AccPassword;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement Address;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement zipcode;
	
	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement Register;
	
	//============================================
	
	
	public HomePage(WebDriver driver) {   // since this is Page factory we need to create constructor to initialise webelemnts This constructor will take webdriver as parameter
		                                  // it will initialise homepage elements using chrome driver as input
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToApplication(String emailAddress,String loginpassword) {
		
		SignIn.click();
		log.info("signIn button is clicked and the xpath is "+SignIn.toString());
		username.sendKeys(emailAddress);
		log.info("entered username and the xpath is "+username.toString());
		password.sendKeys(loginpassword);
		log.info("entered password and the xpath is "+password.toString());
		submitButton.click();
		log.info("submit button is clicked and the xpath is "+submitButton.toString());
		
		
	}
	
	public void loogingOut() {
		signOut.click();
		log.info("logged out from the application "+signOut.toString());
	 
	}
	
	public void RegisterNewAccount(String cremail,String fname,String lname,String email,String psw,String adr,String City,String State,String zpcode,String cntry,String num) {
		
		SignIn.click();
		log.info("signIn button is clicked and the xpath is "+SignIn.toString());
		createEmail.clear();
		createEmail.sendKeys(cremail);
		log.info("email entered is "+createEmail.toString());
		subCreate.click();
		log.info("create account button clicked");
		MrRadio.click();
		log.info("selected radio button "+MrRadio.toString());
		//MsRadio.click();
		//log.info("selected radio butoon "+MsRadio.toString());
		cust_firstName.sendKeys(fname);
		log.info("entered first name is "+firstName.toString());
		cust_lastName.sendKeys(lname);
		log.info("entered last name is "+lastName.toString());
		//emailAdress.sendKeys(email);
		//log.info("entered email address is "+emailAdress.toString());
		AccPassword.sendKeys(psw);
		log.info("entered email psw is "+AccPassword.toString());
		firstName.sendKeys(fname);
		log.info("firstname is "+firstName.toString());
		lastName.sendKeys(lname);
		log.info("last name is "+lastName.toString());
		Address.sendKeys(adr);
		log.info("address entered is "+Address.toString());
		city.sendKeys(City);
		log.info("city selected is "+city.toString());
		state.sendKeys(State);
		log.info("state selected is "+state.toString());
		zipcode.sendKeys(String.valueOf(zpcode));
		log.info("zipcode entered is "+zipcode.toString());
		country.sendKeys(cntry);
		log.info("country selected is "+country.toString());
		mobileNumber.sendKeys(String.valueOf(num));
		log.info("mobile number is "+mobileNumber.toString());
		Register.click();
		log.info("register button clicked");
		
	}
	
	public boolean verifyLogoutDisplay() {
		
		try {
			signOut.isDisplayed();
			log.info("logout is displayed and object is "+signOut.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void clickOnLogour() {		
		signOut.click();	
	}
}
