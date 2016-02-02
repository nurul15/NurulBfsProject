package com.ebfs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
	public  WebDriver driver;
	
	By contactTitle = By.xpath(".//*[@id='center_column']/h1");
	
	public ContactPage (WebDriver argdriver) {
		driver= argdriver;
	}
	public String contactPageTitle(){
		String title = driver.findElement(contactTitle).getText();
		return title;
	}
	

}
