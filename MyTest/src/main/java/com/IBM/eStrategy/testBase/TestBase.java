package com.IBM.eStrategy.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.IBM.eStrategy.excelReader.Excel_Reader;


public class TestBase {
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	String browser="chrome";
	String url="http://automationpractice.com/index.php";
	Excel_Reader excel;
	
	
	
	public void init() {
		// the below 2 methods are combined in a single method init()	
		
		selectBrowser(browser);
		getURL(url);
		String log4jpath="log4j.properties";
		PropertyConfigurator.configure(log4jpath);	
		
	}
	
	public void selectBrowser(String browser) {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\eclipse-workspace\\drivers\\chromedriver.exe");
			log.info("creating object of "+browser);
			driver=new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\IBM_ADMIN\\eclipse-workspace\\drivers\\firefoxdriver.exe");		
			log.info("creating object of "+browser);
			driver=new ChromeDriver();	

}
	}
		public void getURL(String url) {
		 driver.get(url);
		 log.info("navigated to  "+url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		}
		
		public String[][] getData(String sheetName,String ExcelName) {
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\IBM\\eStrategy\\data\\"+ExcelName;		
			excel=new Excel_Reader(path);
			String[][] data=excel.getDatafromSheet(sheetName, ExcelName);
			return data;
		}		
	}
		
