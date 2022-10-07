package com.swaglabs.TestCases;

import java.util.NoSuchElementException;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.swaglabsPage.Objects.LoginPage;


public class TC_001 extends BaseClass {
	String data[];
	Boolean element;




	@Test(dataProvider ="crediatials",dataProviderClass= BaseClass.class)
	public void login(String data1, String data2) throws InterruptedException
	{
		//		  	createTest("Login");
		LoginPage lp = new LoginPage(driver);
		lp.sendname(data1);
		lp.sendpassword(data2);
		String user = LoginPage.username_element.getAttribute("value");
		System.out.println("Logged In as: "+ user);
		lp.click();
		//Boolean sys  =LoginPage.cart_element.isDisplayed();
		try {
			if (LoginPage.cart_element.isDisplayed()) {

				Boolean sys  =LoginPage.cart_element.isDisplayed();
				System.out.println(sys);
				//				String ExpectedUrl =  "https://www.saucedemo.com/inventory.html";
				//				String ActualUrl=driver.getCurrentUrl();
				//				Assert.assertEquals(ActualUrl, ExpectedUrl);
				//				testcase.log(Status.INFO, user+ "- Logged In Successfully");
				//				logger.info(user+ "- Logged In Successfully");
				//				System.out.println(ActualUrl);
				driver.navigate().back();
			}
			
		}
		catch(NoSuchElementException e){
			System.out.println("catch Block");
			//String warningmsg =  LoginPage.erromessage_element.getText();
			//testcase.log(Status.INFO,user+"- " + warningmsg);
			//logger.warn(user+"- " + warningmsg);
			driver.navigate().refresh();;

		}

	}
	//    @Ignore
	//    @Test
	//    @Parameters({"ValidUsername","ValidPassword"})
	//	public void login2(String data1, String Data2) throws InterruptedException {
	//    	data1 = "standard_user";
	//        Data2 = "secret_sauce";
	//    			
	//		LoginPage lp = new LoginPage(driver);
	//		lp.LogIn(data1,Data2);
	//		
	//	}








}
