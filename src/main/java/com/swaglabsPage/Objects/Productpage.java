package com.swaglabsPage.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	
	WebDriver ldriver;
	
	public Productpage(WebDriver remotedriver) {
		remotedriver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	public static WebElement Addcart_backpack;
	
	
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
	public static WebElement remove_backpack;
	
	
	
    
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	public static WebElement Addcart_bikelight;
	
	@FindBy(className="shopping_cart_link")
	public static WebElement cart_element;
	
	public void Add_Backpack() {
		Addcart_backpack.click();
	}
	
	public void click_cart() {
		cart_element.click();
	}	
	

}
