package com.onecognizant.gsd.Project;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllTests {
	
	public String srcValue;
	public WebDriver driver;
	public JavascriptExecutor js;
	
	
	
	@BeforeTest
	public void driverSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		js = (JavascriptExecutor) driver;
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		options.addArguments("disable-notifications");
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	@Test
	public void MainPageTest() throws InterruptedException {
		
		driver.get("https://onecognizant.cognizant.com");
		
		MainPage mp = new MainPage(driver);
		mp.searching();
		mp.search_click();
		mp.clickGsd();
		mp.clickQueries();	
//		mp.printQueries();
//		mp.backtotab();
		mp.find_MediAssist();
		mp.findQuery();
		mp.findTicket();
		mp.findsummary();
		mp.findTime();
		//		mp.CountryDropDown();
//		mp.SelectCountry();
//		mp.clickQuery();
//		mp.printQueries();
		mp.findSubmit();
	}
	
}
	
	

	
		