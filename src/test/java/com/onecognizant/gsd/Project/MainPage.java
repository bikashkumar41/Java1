package com.onecognizant.gsd.Project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	String country = "Australia";
	By searchBar =By.id("oneC_searchAutoComplete");
	By searchClick=By.xpath("//div[@class='searchInputIcon']");
	By gsd = By.xpath("//div[@class='appsResultText' and text()='Live Support - GSD']");
	By item = By.xpath("//div[@class='p-1 flex-fill']");
	By appframe = By.id("appFrame");
	By parentFrame = By.xpath("//div[@id='divIFrame']");
	By frames = By.xpath("//iframe");
	By queriesbtn = By.xpath("//button[@id='FaqBtnMenu']");
	By queries = By.xpath("//li[@class='ApplabelColor']");
	By backbtn = By.xpath("//span[@class='back_Btn_txt']");
	By countryMenu = By.xpath("//a[@id='menu2']");
	By required = By.xpath("//a[text()='"+country+"']");
	By medi = By.xpath("//div[@class='col-md-12 application-tiles']");
//	By suggestQueries = By.xpath("//span[@class='botFaqList']");
	By suggestQueries = By.xpath("//ol[@id='botFaqOl']");
	By Ticket = By.xpath("//a[@class='connectMe gsdMe light-blue ']");
	//By tiles = By.xpath("(//div[@class='eachTileRow'])[3]/div");
	By tiles = By.xpath("//div[@class='p-1 flex-fill']");
	By messagebox = By.xpath("//textarea[@id='messageBox']");
	
	By StartTimebox1 = By.xpath("//input[@id='dur_start_h']");
	By StartTimebox2 = By.xpath("//input[@id='dur_start_m']");
	By EndTimebox1 = By.xpath("//input[@id='dur_end_h']");
	By EndTimebox2 = By.xpath("//input[@id='dur_end_m']");
	By submitBtn = By.xpath("//input[@aria-label='submit ticket']");
	
	public Point pointer;
	public Actions actions;
	
	public WebDriver driver;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void waitfor(Duration i, By element) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}
	
	public void searching() {
		driver.findElement(searchBar).sendKeys("gsd");
	}
	public void search_click() {
		driver.findElement(searchClick).click();
	}
	public void clickGsd() throws InterruptedException {
		Thread.sleep(3000);
		waitfor(Duration.ofSeconds(20),gsd);
		WebElement gsdsearchresult = driver.findElement(gsd);
		pointer = gsdsearchresult.getLocation();
		int a =gsdsearchresult.getSize().getWidth()/2;
		int b =gsdsearchresult.getSize().getHeight()/2;
//		System.out.println("locaton is "+pointer);
		actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(gsd), a, b).click().build().perform();

	}
	public void clickQueries() throws InterruptedException {
		waitfor(Duration.ofSeconds(20),parentFrame);
		WebElement pFrame = driver.findElement(parentFrame);
		WebElement sFrame = pFrame.findElement(By.xpath("//iframe[@id='appFrame']"));
		driver.switchTo().frame(sFrame);
		System.out.println("Switched");
		Thread.sleep(9000);
//		waitfor(Duration.ofSeconds(20),queriesbtn);
//		driver.findElement(queriesbtn).click();		
//		Thread.sleep(6000);
//		try {
//			driver.findElement(queries);
//		}
//		catch(Exception e) {
//			waitfor(Duration.ofSeconds(20),queriesbtn);
//			driver.findElement(queriesbtn).click();	
//		}
		
	}
	public void printQueries() {
		List<WebElement> allQueries = driver.findElements(queries);
		System.out.println("The count of queries are "+ allQueries.size());
		for(WebElement query : allQueries) {
			System.out.println(query.getText());
		}
	}
	
	public void backtotab() {
		driver.findElement(backbtn).click();
		
	}
	public void CountryDropDown() {
		waitfor(Duration.ofSeconds(20),countryMenu);
		driver.findElement(countryMenu).click();
	}
	public void SelectCountry() {
		waitfor(Duration.ofSeconds(20),required);
		driver.findElement(required).click();
	}
	
	public void clickQuery() {
		driver.findElement(queriesbtn).click();
		try {
			driver.findElement(queries);
		}
		catch(Exception e) {
			waitfor(Duration.ofSeconds(20),queriesbtn);
			driver.findElement(queriesbtn).click();	
		}
	}
	
	public void find_MediAssist() {
		//try {
		try {
			backtotab();
		}
		catch(Exception e) {
			
		}
		waitfor(Duration.ofSeconds(20),tiles);
		List<WebElement> list2 =driver.findElements(tiles);
		System.out.println(list2.size());
		for(int i =0;i<26;i++) {
			System.out.println(list2.get(i).getText());
			if(i==19) {
				WebElement mediassist = list2.get(i);
//				int c =mediassist.getSize().getWidth()/2;
//				int d =mediassist.getSize().getHeight()/2;
//				System.out.println("locaton is "+pointer);
//				actions = new Actions(driver);
				mediassist.click();
//				actions.moveToElement(mediassist, c, d).click().build().perform();
				System.out.println("clicked");
				break;
				}
		}
//		catch(Exception e) {
//			
//				waitfor(Duration.ofSeconds(20),tiles);
//				List<WebElement> list2 =driver.findElements(tiles);
//				System.out.println(list2.size());
//				for(int i =0;i<26;i++) {
//					System.out.println(list2.get(i).getText());
//					if(i==19) {
//						WebElement mediassist = list2.get(i);
////						int c =mediassist.getSize().getWidth()/2;
////						int d =mediassist.getSize().getHeight()/2;
////						System.out.println("locaton is "+pointer);
////						actions = new Actions(driver);
//						mediassist.click();
////						actions.moveToElement(mediassist, c, d).click().build().perform();
//						System.out.println("clicked");
//						break;
//					}
//				}
//				
//		}
		
			
		
	
	}
	
	public void findQuery() {
		waitfor(Duration.ofSeconds(20), suggestQueries);
//		List<WebElement> list3 =driver.findElements(suggestQueries);
//		for(WebElement l:list3) {
//			if(l.getText().equalsIgnoreCase("Who can avail the Master Health Checkup (MHC)?"))
//				l.click();
//			break;
//		}
//		List<WebElement> elements = driver.findElements(suggestQueries );
		WebElement element =driver.findElement(suggestQueries);
		
		int a = element.getSize().getWidth();
		int b = element.getSize().getHeight();
		Actions actions = new Actions(driver);
		actions.moveToElement(element, 50, b/3).click().build().perform();
		System.out.println("clicked");
//		driver.findElement(Ticket);
		
		
	
	
		
		
	}
	
	public void findTicket() throws InterruptedException {
		
		Actions actions = new Actions(driver);
		WebElement element3 =driver.findElement(backbtn);
		//actions.moveToElement(element3).build().perform();
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element3);
		
		
		//actions.moveByOffset(0, -100).build().perform();
		//actions.moveToElement(driver.findElement(Ticket)).build().perform();
		Thread.sleep(5000);
		
		driver.findElement(Ticket).click();
	}
	
	public void findsummary() {
		waitfor(Duration.ofSeconds(10), messagebox);
		driver.findElement(messagebox).sendKeys("How do i avail online consultations?");
	}
	public void findTime() {
		waitfor(Duration.ofSeconds(10),StartTimebox1);
		driver.findElement(StartTimebox1).sendKeys("9");
		driver.findElement(StartTimebox2).sendKeys("00");
		driver.findElement(EndTimebox1).sendKeys("7");
		driver.findElement(EndTimebox2).sendKeys("00");
	}
	
	public void findSubmit() {
		driver.findElement(submitBtn).click();
		
	}
	
	

}
