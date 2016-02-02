package com.ebfs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressesPage {
	public WebDriver driver;
	
	By dressesPageTitle= By.xpath(".//*[@id='center_column']/h1/span[1]");
	
	
	public DressesPage (WebDriver argdriver){
		driver= argdriver;
	}
	
	public String dressesPageTitle(){
		String title = driver.findElement(dressesPageTitle).getText();
		return title;
	}
	
	
}
