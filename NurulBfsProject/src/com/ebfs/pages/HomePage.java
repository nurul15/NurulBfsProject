package com.ebfs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	public WebDriver driver;

	By signInLink = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By womenTab = By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a");
	By dressesTab= By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a");
	By tshirtsTab= By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a");
	By bruteforceTab= By.xpath(".//*[@id='block_top_menu']/ul/li[4]/a");
	
	By featureItems = By.xpath(".//*[@id='homefeatured']");
	By emptyCart = By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a/span[5]");
	By userAccount= By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	By contactLink = By.xpath(".//*[@id='contact-link']/a");
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
		driver.findElement(bruteforceTab).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.switchTo().window("Welcome to the BruteForce!");
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
	public void subNewsletter(){//test email must be differ everytime you run code
		driver.findElement(newsLetterBox).sendKeys("4@email.com");
		driver.findElement(newsLetterButton).click();
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
		driver.findElement(facebookLink).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
}
