package com.toneop.care.objectUtility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.toneop.care.genericUtility.BaseClassTest;

public class HomePage extends BaseClassTest{
	 WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	// ==================================================NAV BAR ALL ELEMENTS==========================================
	
	@FindBy(xpath = "//input[@id='SearchInput']")
	private WebElement searchIcon;
	public WebElement getWhatsAppIcon() {
		return whatsAppIcon;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	
	@FindBy(xpath = "//div[@class='bg-white p-4']")
	private List<WebElement> searchIconToolTipItem;
	public List<WebElement> getSearchIconToolTipItem() {
		return searchIconToolTipItem;
	}
	
	
	@FindBy(xpath = "//a[@href='/cart']/preceding-sibling::a")
	private WebElement whatsAppIcon;
	
	

	

	@FindBy(xpath = "//a[@href='/cart']")
	private WebElement cartIcon;
	
	@FindBy(xpath = "//div[@class='cursor-pointer']")
	private WebElement profileIcon;
	
	// ================================================================================================================
	@FindBy(xpath = "//a[@class='font-arial text-xs lg:text-sm text-[#424242] cursor-pointer py-2 mt-2 font-normal']")
	private List<WebElement> navMenu;

	public List<WebElement> getNavMenu() {
		return navMenu;
	}
	//================================================================================================================
	
	// ================================================================================================================
		@FindBy(xpath = "//h2[@id='bestseller']/following-sibling::div//li[@aria-hidden='false']//h3")
		private List<WebElement> bestSellersProduct;

		public List<WebElement> getBestSellersProduct() {
			return bestSellersProduct;
		}
		//================================================================================================================
	

}
