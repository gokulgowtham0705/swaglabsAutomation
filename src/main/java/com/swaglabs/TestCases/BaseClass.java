package com.swaglabs.TestCases;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.swaglabs.utilities.FileHandling;
import com.swaglabs.utilities.Readconfig;
import com.swaglabsPage.Objects.LoginPage;


import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass 
{
	Readconfig readconfig = new Readconfig();
	WebDriver driver;
	public static Logger logger;
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter reporter;
	public static ExtentTest testcase;


	String Baseurl = readconfig.getbaseurl();
	String Username = readconfig.getusername();
	String Password = readconfig.getpassword();

	

	@SuppressWarnings("deprecation")
	
	@BeforeTest
//	@Parameters("browser")
	public void install() 
	{
		
		logger =Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("log4j.properties");
		
		reporter = new ExtentSparkReporter("SwaglabsReports.html");
		extent.attachReporter(reporter);
		
		//D:\\Gokul\\Driver\\Newversion\\chromedriver.exe
		//D:\\Gokul\\Driver\\chromedriver_win32\\chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", "D:\\Gokul\\Driver\\Newversion\\chromedriver.exe");
	
		driver = new ChromeDriver(); 
		System.out.println("To check the commit happens");
		System.out.println("to intiate the commit");
		
//		switch(SearchEngine) {
//		case "Chrome":
//			
//			//System.setProperty("webdriver.chrome.driver", "D:\\Gokul\\Driver\\chromedriver_win32\\chromedriver.exe");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(); 
//		case "Edge":
//			
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver(); 
//			driver.navigate().to(Baseurl);
//		case "InternetExplorer":
//			
//			WebDriverManager.iedriver().setup();
//			//driver = new Driver();
//			driver.navigate().to(Baseurl);
//		default:
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(); 
//		}

		
//		//System.setProperty("webdriver.chrome.driver", "D:\\Gokul\\Driver\\chromedriver_win32\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(Baseurl);
		//PageFactory.initElements(driver, LoginPage.class);

	}

	public void implicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void teardown() 
	{
		driver.quit();
		extent.flush();

	}

	public void back() {
		driver.navigate().back();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void clearcrediatials() {
		LoginPage.username_element.clear();
		LoginPage.password_element.clear();
		boolean pass = LoginPage.password_element.isDisplayed();
		System.out.println("Passwod elemet is:" + pass);
	}	
  
	public void createTest(String TestCaseName) {
		testcase = extent.createTest(TestCaseName);
	}
	//Reads data from excel
	@DataProvider(name="crediatials")
	public String[][] getdata() throws IOException{
		String[][] exceldata = null;
		try {
			exceldata = FileHandling.readExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exceldata;

	}
//	@DataProvider(name="SwagLabs Crediantials")
	//	public Object[][] data() {
	//		
	//		return new Object[][] {
	//			{"standard_user","secret_sauce"},
	//			{"student1","secret_sauce"},
	//			{"student","secret_sauce"}
	//		};
	//	}

    public void error() {
	try {
		if (LoginPage.cart_element.isDisplayed()) {
			
			System.out.println("Trycatch Block");
			String ExpectedUrl =  "https://www.saucedemo.com/inventory.html";
			String ActualUrl=driver.getCurrentUrl();
			Assert.assertEquals(ActualUrl, ExpectedUrl);
//			testcase.log(Status.INFO, user+ "- Logged In Successfully");
//			logger.info(user+ "- Logged In Successfully");
			System.out.println(ActualUrl);

			driver.navigate().back();
		}
	}
	catch (NoSuchElementException e){
		System.out.println("catch Block");
		String warningmsg =  LoginPage.erromessage_element.getText();
//		testcase.log(Status.INFO,user+"- " + warningmsg);
//		logger.warn(user+"- " + warningmsg);
		driver.navigate().refresh();;

	}
    }

}
