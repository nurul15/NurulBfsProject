package com.ebfs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomensPage {
	public WebDriver driver;
	
	By womenPageTitle = By.xpath(".//*[@id='center_column']/h1/span[1]");
	
	public WomensPage (WebDriver argdriver){
		driver= argdriver;
	}
	
	
	public String womenPageTitle (){
		String title = driver.findElement(womenPageTitle).getText();
		return title;
	}
	
}
