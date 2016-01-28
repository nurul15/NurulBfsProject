package com.ebfs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	WebDriver driver;
	WebDriver Action;
	
	By createEmail = By.xpath("//*[@id='email_create']");
	By createAccountButton = By.xpath("//*[@id='SubmitCreate']");
	By loginEmail = By.xpath("//*[@id='email']");
	By loginPassword = By.xpath("//*[@id='passwd']");
	By loginButton = By.xpath("//*[@id='SubmitLogin']");
	By createAccountTitle = By.xpath("//*[@id='create-account_form']/h3");
	
	By invalidEmailAlert = By.xpath(".//*[@id='create_account_error']/ol/li");
	By alreadyRegistered = By.xpath(".//*[@id='create_account_error']/ol/li");
	
	public SignInPage(WebDriver argDriver) {
		driver = argDriver;
		
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
	
	public String invalidEmail() {
		String title = driver.findElement(invalidEmailAlert).getText();
		return title;
	}
	
	public String registeredEmail() {
		String title = driver.findElement(alreadyRegistered).getText();
		return title;
	}
	
	
	
}
