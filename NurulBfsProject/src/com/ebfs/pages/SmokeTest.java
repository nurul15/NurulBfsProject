package com.ebfs.pages;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SmokeTest {
	
	ExtentReports report;
	ExtentTest logger;

	WebDriver driver;
	
	
  @BeforeTest
  public void beforeTest() {
	  report = new ExtentReports("C:\\Users\\Aminn\\git\\FinalBfsProject\\NurulBfsProject\\pages.html", true);
  }
   @BeforeMethod
  public void openBrowser() {

	  driver = new FirefoxDriver();
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }

  
  @Test (enabled =false) //Test Case 1
  public void createInvalidEmail() {
	  logger = report.startTest("Invalid Email Account Creation");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Sign In Clicked");
	  homePage.clickSignIn();
	
	  SignInPage signInPage = new SignInPage(driver);
	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
	  logger.log(LogStatus.INFO,"Input Invalid Email");
	  signInPage.createNewAccount("nurul");
	  logger.log(LogStatus.INFO,"Display Invalid Email Error");
	  signInPage.invalidEmail();
	  logger.log(LogStatus.PASS, "Invalid Email  Entered & Verified ERROR ALERT");
  }
  
  @Test (enabled =false) //Test Case 2
  public void alreadyRegistered() {
	  logger = report.startTest("Already Registered Account");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Sign In Clicked");
	  homePage.clickSignIn();
	  
	  SignInPage signInPage = new SignInPage(driver);
	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
	  logger.log(LogStatus.INFO,"Input Registered Email");
	  signInPage.createNewAccount("rabbani@rabbani.com");
	  logger.log(LogStatus.INFO,"Display Registered Email Error");
	  signInPage.registeredEmail();
	  logger.log(LogStatus.PASS,"Registered Email ALERT verified");
	
  }
  
  @Test (enabled = true)//Test Case 3
  public void createNewAccount() {
	
	  logger = report.startTest("Create New Account");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Sign In Clicked");
	  homePage.clickSignIn();
	  
	  SignInPage signInPage = new SignInPage(driver);
	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
	  logger.log(LogStatus.INFO,"Input Valid Email");
	  signInPage.createNewAccount("13@gmail.com");
	  
	  AccountPage accountPage = new AccountPage (driver);
	  logger.log(LogStatus.INFO,"Verify Account Page Displayed");
	  Assert.assertEquals(accountPage.personalInfo(),"YOUR PERSONAL INFORMATION");
	  logger.log(LogStatus.INFO,"Filling Our Personal Info");
	  accountPage.fillOutInfo("Nurul","Amin","password");
	  logger.log(LogStatus.INFO,"Verifying Account Creation");
	  Assert.assertEquals(accountPage.verifyCreated(),"Your account has been created.");
	  logger.log(LogStatus.INFO,"Verifying Account Name");
	  Assert.assertEquals(accountPage.verifyName(),"Nurul Amin");
	  accountPage.updateLastName();
	  Assert.assertEquals(accountPage.verifyLastNameUpdate(),"Nurul Doe");
	  logger.log(LogStatus.PASS, "New Account Creation Success");
  }
  
  
  @AfterMethod
  public void closeBroser(ITestResult result) {
	  if (result.getStatus() == ITestResult.FAILURE) {
			//String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenshot_path = "C:\\Storage\\Report\\" + scrfile.getName();
			File tmp = new File(screenshot_path);
			try{
			FileUtils.copyFile(scrfile, tmp);
			}catch(Exception ex){
				System.out.println("Exception::");
			}
			System.out.println("Path:" + screenshot_path);
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);
		}

		report.endTest(logger);
		report.flush();

		driver.close();
  }

  @AfterTest
  public void afterTest() {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("C:\\Users\\Aminn\\git\\FinalBfsProject\\NurulBfsProject\\pages.html");
  }

}
