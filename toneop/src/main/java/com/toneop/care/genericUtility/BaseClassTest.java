package com.toneop.care.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClassTest {
//	protected  WebDriver driver;
	
	public  WebDriver driver = null;
	@BeforeSuite
	public void startSuite() {
	    System.out.println("Starting test suite");
	}

	@AfterSuite
	public void endSuite() {
	    System.out.println("Suite execution completed");
	}

	
	@BeforeTest
	public void setupTest() {
	    System.out.println(" Application Test Strat");
	}

	@AfterTest
	public void tearDownTest() {
	    System.out.println("Application Test End");
	}

	
	@BeforeClass
	public void setupClass() {
	    System.out.println("Class Test Start");
	}

	@AfterClass
	public void tearDownClass() {
	    System.out.println("Class Test End");
	}

	
	@BeforeMethod
	public void launchApplication() {
	    System.out.println("Open The Application");
	    
	     // You can use WebDriverManager also
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds( 10));
		
		 // Launch ToneOp Care
		driver.get("https://toneop.care/");
	}

	@AfterMethod
	public void CloseApplication() {
	    System.out.println("Close The Application");
	    if (driver != null) {
            driver.quit();
        }
	}

}
