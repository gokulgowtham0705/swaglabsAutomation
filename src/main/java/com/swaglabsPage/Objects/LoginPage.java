package com.swaglabsPage.Objects;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 
{
	static WebDriver ldriver;
	public LoginPage(WebDriver Remotedriver) 
	{
 	ldriver = Remotedriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	
	
//	By username_element = By.xpath("//*[@id=\"user-name\"]");
//	By password_element = By.id("password");
//  By submit_element = By.id("login-button");
    
	@FindBy(xpath="//*[@id=\"user-name\"]")   
	public static WebElement username_element;
    
    @FindBy(id="password")   
    public static  WebElement password_element;
    
    @FindBy(id="login-button")   
    public static  WebElement submit_element;
    
    @FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    public static  WebElement erromessage_element;
    
    @FindBy(id="react-burger-menu-btn")
    public static  WebElement menu_element;
    
    @FindBy(id="shopping_cart_container")
    public static WebElement cart_element;
    
    
    
    
//    public  void LogIn(String username, String pwd) throws InterruptedException 
//	{   
//		
//		LoginPage.username_element.sendKeys(username);
//		Thread.sleep(2000);
//		LoginPage.password_element.sendKeys(pwd); 
//		Thread.sleep(2000);
//		String user = LoginPage.username_element.getAttribute("value");
//		System.out.println("Name is " + user);
//		LoginPage.submit_element.click();
//		Thread.sleep(2000);
//		String ExpectedUrl =  "https://www.saucedemo.com/inventory.html";
//		String ActualUrl=driver.getCurrentUrl();
//		Assert.assertEquals(ActualUrl, ExpectedUrl);
//	}
		public void sendname(String Name) {
			username_element.sendKeys(Name);
		}
		public void sendpassword(String pass) {
			password_element.sendKeys(pass); 
		}
		public void click() {
	        submit_element.click();
		}
	
	

	
	
    
	
	
//	
//	public void setcrediatials(data[]) throws InterruptedException 
//	{    
//	
//		username_element.sendKeys(name);
//		password_element.sendKeys(pass);
//		String user = username_element.getAttribute("value");
//		System.out.println("Name is " + user);
//		submit_element.click();
//	}
	
//	public void submit() throws InterruptedException {
//		driver.findElement(submit_element).click();
//		
//	}

}
