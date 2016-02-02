package com.ebfs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TshirtsPage {
	public WebDriver driver;
	
	By tshirtsPageTitle= By.xpath(".//*[@id='center_column']/h1/span[1]");
	
	
	public  TshirtsPage (WebDriver argdriver){
		driver= argdriver;
	}
	
	public String tshirtsPageTitle(){
		String title = driver.findElement(tshirtsPageTitle).getText();
		return title;
	}
	
	
	
}
