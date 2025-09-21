package com.toneop.care;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.toneop.care.genericUtility.BaseClassTest;
import com.toneop.care.objectUtility.HomePage;

public class HomePageTest extends BaseClassTest{
	
	
	@Test
	public void launchHomePage() {
		HomePage hp = new HomePage(driver);
		
		System.out.println(" homepage loads correctly without login");
		
	}
	@Test
	public void getUrl() {
		HomePage hp = new HomePage(driver);
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
	}
	
	@Test
	public void getTitle() {
		HomePage hp = new HomePage(driver);
		
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	// ==================================================================================================================================================================
	@Test
	public void verifyTooltipItemByEnteringProductOnSearchInput() {
		HomePage hp = new HomePage(driver);
		hp.getSearchIcon().click();
		hp.getSearchIcon().sendKeys("vitamin");
		List<WebElement> toolTipItems = hp.getSearchIconToolTipItem();
		toolTipItems.stream().forEach(item->System.out.println(item.getText()));
		
	}
	// ==================================================================================================================================================================
	@Test
	public void verifyWhatsAppLinkWorkOrNot() {
		HomePage hp = new HomePage(driver);
		String parentW = driver.getWindowHandle();
		hp.getWhatsAppIcon().click();
		Set<String> AllWindow = driver.getWindowHandles();
		for(String w:AllWindow) {
			
			if(!parentW.equals(w)) {
				driver.switchTo().window(w);
				System.out.println(driver.getTitle());
			}
		}
	}
	// ==================================================================================================================================================================
	@Test
	public void verifyCartIconWorkingOrNotAndPageIsOpenOrNot() {
		HomePage hp = new HomePage(driver);
		hp.getCartIcon().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));
		String pageName = driver.findElement(By.xpath("//h1")).getText();
//		System.out.println(pageName);
	}
	
	// ==================================================================================================================================================================
	@Test
	public void verifyProfileIconWorkingOrNotAndProfileModalIsOpenOrNot() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		HomePage hp = new HomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(hp.getProfileIcon()));
		hp.getProfileIcon().click();
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Welcome to Toneop care']"))));
		
		String welcomeMsg = driver.findElement(By.xpath("//div[text()='Welcome to Toneop care']")).getText();
		System.out.println(welcomeMsg);
		
	}
	// ==================================================================================================================================================================
	
	@Test
	public void verifyNavigationMenuListsIsVisiableAndClickble() {
		HomePage hp = new HomePage(driver);
		 List<WebElement> navMenu = hp.getNavMenu();
		 navMenu.stream().forEach(s->System.out.println(s.getText()+" : is visible "+ s.isEnabled()));
	}
	
	// ==================================================================================================================================================================
	
	@Test
	public void verifyBestsellersBannersPromotionsFeaturedProductsDisplayed() {
		HomePage hp = new HomePage(driver);
		List<WebElement> bestSellersProducts = hp.getBestSellersProduct();
		System.out.println("BestSeller Products Are Below");
		List<WebElement> dotButton = driver.findElements(By.xpath("//ul[@class='react-multi-carousel-dot-list ']/li"));
		for(WebElement b:dotButton) {
			b.click();
			bestSellersProducts.stream().forEach(bs->System.out.println(bs.getText()));
		}
		
	}

}
