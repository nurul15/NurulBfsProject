package com.ebfs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
	
	public WebDriver driver;
	
	By loginVerification = By.xpath(".//*[@id='center_column']/p");
	By detailOrderLink = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[2]/a/span");
	By orderHistoryTitle = By.xpath(".//*[@id='center_column']/h1");
	By personalInfoTitle = By.xpath(".//*[@id='account-creation_form']/div[1]/h3");
	By firstName= By.xpath(".//*[@id='customer_firstname']");
	By lastName= By.xpath(".//*[@id='customer_lastname']");
	By password= By.xpath(".//*[@id='passwd']");
	By dobDays= By.xpath(".//*[@id='days']");
	By dobMonths= By.xpath(".//*[@id='months']");
	By dobYears= By.xpath(".//*[@id='years']");
	By registerButton = By.xpath(".//*[@id='submitAccount']");
	
	By verifyCreate = By.xpath(".//*[@id='center_column']/p[1]");
	By verifyName = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");
//	By personalInfoLink = By.xpath(".//*[@id='center_column']/div/div[1]/ul/li[5]/a/span");
//	By updateLastName = By.xpath(".//*[@id='lastname']");
//	By updateInfoPass = By.xpath(".//*[@id='old_passwd']");
//	By saveButton = By.xpath(".//*[@id='center_column']/div/form/fieldset/div[11]/button");
//	By verifyNameUpdate = By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");
	
	public AccountPage (WebDriver argDriver){
		driver= argDriver;
	}
	
	public String verifyLogin() {
		String title = driver.findElement(loginVerification).getText();
		return title;
	}
	public void detailOrder(){
		driver.findElement(detailOrderLink).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public String detailHistory(){
		String title = driver.findElement(orderHistoryTitle).getText();
		return title;
	}

	public String personalInfo() {
		String title = driver.findElement(personalInfoTitle).getText();
		return title;
	}
	
	public void fillOutInfo(String argFirst,String argLast, String argPassword) {
		driver.findElement(firstName).sendKeys(argFirst);
		driver.findElement(lastName).sendKeys(argLast);
		driver.findElement(password).sendKeys(argPassword);
	
		Select dropdownDays = new Select(driver.findElement(dobDays));
		dropdownDays.selectByValue("15");
		Select dropdownMonths = new Select(driver.findElement(dobMonths));
		dropdownMonths.selectByIndex(11);
		Select dropdownYears = new Select(driver.findElement(dobYears));
		dropdownYears.selectByValue("1990");
		driver.findElement(registerButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public String verifyCreated (){
		String title = driver.findElement(verifyCreate).getText();
		return title;
	}
	public String verifyName(){
		String title = driver.findElement(verifyName).getText();
		return title;
	}
	
//	public void updateLastName(){
//		driver.findElement(personalInfoLink).click();
//		driver.findElement(updateLastName).clear();
//		String lastNameUpdate = "Doe";
//		driver.findElement(updateLastName).sendKeys(lastNameUpdate);
//		String updatePassReq = "password";
//		driver.findElement(updateInfoPass).sendKeys(updatePassReq);
//		driver.findElement(saveButton).click();
//	}
//	
	
//	

//	
//	public String verifyLastNameUpdate(){
//		String title = driver.findElement(verifyNameUpdate).getText();
//		return title;
//	}
//	
//	
	
	}

