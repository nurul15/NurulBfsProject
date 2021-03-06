package com.ebfs.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.TimesPanel;

public class HomePage {
	public WebDriver driver;
	WebDriver Action;
	

	By signInLink = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By homePageLogo = By.xpath(".//*[@id='header_logo']");
	By womenTab = By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a");
	By dressesTab= By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a");
	By tshirtsTab= By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
	By bruteforceTab= By.xpath(".//*[@id='block_top_menu']/ul/li[4]/a");
	
	By featureItems = By.xpath(".//*[@id='homefeatured']");
	By emptyCart = By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]");
	By userAccount= By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By contactLink = By.xpath(".//*[@id='contact-link']/a");
	
	By hoverLink=By.xpath(".//*[@id='homefeatured']/li[1]/div");
	By quickView=By.xpath(".//*[@id='homefeatured']/li[1]/div/div[1]/div/a[2]");
	
	By bestSellerLink = By.xpath(".//*[@id='home-page-tabs']/li[2]/a");
	By bestSellerBlock = By.xpath(".//*[@id='blockbestsellers']");
	By popularSellerLink = By.xpath(".//*[@id='home-page-tabs']/li[1]/a");
	By popularSellerBlock = By.xpath(".//*[@id='homefeatured']");
	By newsLetterBox = By.xpath(".//*[@id='newsletter-input']");
	By newsLetterButton = By.xpath(".//*[@id='newsletter_block_left']/div/form/div/button");
	By subVerifyTitle = By.xpath(".//*[@id='columns']/p");
	By searchBox = By.xpath(".//*[@id='search_query_top']");
	By searchButton = By.xpath(".//*[@id='searchbox']/button");
	By verifySearch = By.xpath(".//*[@id='center_column']/h1/span");
	By facebookLink = By.xpath(".//*[@id='social_block']/ul/li[1]");
	
	public HomePage(WebDriver argDriver){
		driver = argDriver;
	}
	
	public void clickSignIn(){
		driver.findElement(signInLink).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public boolean bruteForceLogo(){
		boolean title = driver.findElement(homePageLogo).isDisplayed();
		return title;
	}
	public void womenSection (){
		driver.findElement(womenTab).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void dressesSection (){
		driver.findElement(dressesTab).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void tshirtsSection (){
		driver.findElement(tshirtsTab).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void bruteforceSection (){
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(bruteforceTab).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		//driver.switchTo().window("Welcome to the BruteForce!") THIS DOES NOT WORK;
	}
	public boolean featureProducts(){
		boolean title = driver.findElement(featureItems).isDisplayed();
		return title;
	}
	public String emptyVisibleCart(){
		String title = driver.findElement(emptyCart).getText();
		return title;
	}
	public void clickMyAccount (){
		driver.findElement(userAccount).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void clickContactUs(){
		driver.findElement(contactLink).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void clickBestSeller(){
		driver.findElement(bestSellerLink).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	public boolean bestSeller(){
		boolean title = driver.findElement(bestSellerBlock).isDisplayed();
		return title;
	}
	public void clickPopular(){
		driver.findElement(popularSellerLink).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	public boolean popularSeller(){
		boolean title = driver.findElement(popularSellerBlock).isDisplayed();
		return title;
	}
	public void subNewsletter(String argEmail){//test email must be differ everytime you run code
		driver.findElement(newsLetterBox).sendKeys(argEmail);
		driver.findElement(newsLetterButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	public String subscribeVerify(){
		String title = driver.findElement(subVerifyTitle).getText();
		return title;
	}
	public void searchProducts (){
		driver.findElement(searchBox).sendKeys("t-shirt");
		driver.findElement(searchButton).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
//		driver.findElement(searchBox).clear();
//		driver.findElement(searchBox).sendKeys("dress");
//		driver.findElement(searchButton).click();	
	}
	public boolean searchVerify(){
		boolean title = driver.findElement(verifySearch).isDisplayed();
		return title;
	}
	public void facebookFollow(){
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(facebookLink).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);
		}
		// Close the new window, if that window no more required
		driver.close();
	}
	public void quickLink(){

		Actions action = new Actions(driver);

		
	
	

	}
	
}
