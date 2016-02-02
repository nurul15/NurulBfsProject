package com.ebfs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	WebDriver driver;
	WebDriver Action;
	

	By loginEmail = By.xpath("//*[@id='email']");
	By loginPassword = By.xpath("//*[@id='passwd']");
	By loginButton = By.xpath("//*[@id='SubmitLogin']");
	By createEmail = By.xpath("//*[@id='email_create']");
	By createAccountButton = By.xpath("//*[@id='SubmitCreate']");
	By createAccountTitle = By.xpath("//*[@id='create-account_form']/h3");
	
	public SignInPage(WebDriver argDriver) {
		driver = argDriver;
	}	
	public void signIn(String argEmail, String argPassword){
		driver.findElement(loginEmail).sendKeys(argEmail);
		driver.findElement(loginPassword).sendKeys(argPassword);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void createNewAccount(String argEmail) {
		driver.findElement(createEmail).sendKeys(argEmail);
		driver.findElement(createAccountButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	public String createAccountTitle(){
		String title = driver.findElement(createAccountTitle).getText();
		return title;
	}
			
}

	
	

