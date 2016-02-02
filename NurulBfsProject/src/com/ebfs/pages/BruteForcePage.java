package com.ebfs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BruteForcePage {
	public WebDriver driver;
	
	By bruteForceLogo = By.xpath(".//*[@id='s5_logo']");
	
	
	public BruteForcePage (WebDriver argdriver){
		driver= argdriver;
	}
	
	public boolean bruteForcePageLogo(){
		boolean title = driver.findElement(bruteForceLogo).isDisplayed();
		return title;
		
	}
	

	
	


}

