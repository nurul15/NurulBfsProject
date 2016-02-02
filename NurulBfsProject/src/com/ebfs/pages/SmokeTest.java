package com.ebfs.pages;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
   @Test (enabled = false)//*******1.1 BruteForce the power of choice..... Logo should be visible to all users.******
   public void bruteforceLogo(){
   }
   
   
  @Test (enabled= false)//1.2 Verify womenn Tab 
  public void womenOptionsTab (){
	  logger= report.startTest("Verifying Womens Tab");
	  HomePage homePage= new HomePage(driver);
	  logger.log(LogStatus.INFO,"Women Tab Clicked");
	  homePage.womenSection();
	  WomensPage womensPage = new WomensPage(driver);
	  logger.log(LogStatus.INFO,"Verify Womens Tab Opened");
	  Assert.assertEquals(womensPage.womenPageTitle(),"WOMEN ");
	  logger.log(LogStatus.PASS, "Women Section Present");
  }
  @Test (enabled= false)//1.2 Verify dresses Tab 
  public void dressesOptionsTab (){
	  logger= report.startTest("Verifying Dresses Tab");
	  HomePage homePage= new HomePage(driver);
	  logger.log(LogStatus.INFO,"Dresses Tab Clicked");
	  homePage.dressesSection();
	  DressesPage dressesPage = new DressesPage(driver);
	  logger.log(LogStatus.INFO,"Verify Dresses Tab Opened");
	  Assert.assertEquals(dressesPage.dressesPageTitle(), "DRESSES");
  }
  @Test (enabled= false)//1.2 Verify T-shirts Tab 
  public void tshirtsOptionsTab (){
	  logger= report.startTest("Verifying T-shirts Tab");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"T-shirts Tab Clicked");
	  homePage.tshirtsSection();
	  TshirtsPage tshirtsPage = new TshirtsPage(driver);
	  logger.log(LogStatus.INFO,"Verify T-shirts Tab Opened");
	  Assert.assertEquals(tshirtsPage.tshirtsPageTitle(), "T-SHIRTS");	  
  }
  @Test (enabled= false)//******1.2 Verify BruteForceTab ----DOES NOT CHANGE WINDOWS*********
  //**********STILL NEEDS WORK*********
  public void bruteforceOptionsTab (){
	  logger= report.startTest("Verifying BruteForce Tab");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"BruteForce Tab Clicked");
	  homePage.bruteforceSection();
	  
	  BruteForcePage bruteforcePage  = new BruteForcePage(driver);
	  logger.log(LogStatus.INFO,"Verify BruteForce Tab Opened");
	  Assert.assertEquals(bruteforcePage.bruteForcePageLogo(), true);
  }
  @Test (enabled = false) //1.3 Registered user should be able to Login from Home Page.
  public void logIn(){
	  logger= report.startTest("Verify Registered User Login");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Login Clicked");
	  homePage.clickSignIn();
	  SignInPage signInPage = new SignInPage(driver);
	  logger.log(LogStatus.INFO,"Input Valid Username & Pass");
	  signInPage.signIn("nurul@gmail.com","password");
	  AccountPage accountPage = new AccountPage(driver);
	  Assert.assertEquals(accountPage.verifyLogin(),"Welcome to your account. Here you can manage all of your personal information and orders.");
  }
  @Test (enabled = false) //1.4 Featured Products should be visible to Users
  public void featureProducts(){
	  logger= report.startTest("Feature Products Visibility");
	  HomePage homePage = new HomePage(driver);
	  Assert.assertEquals(homePage.featureProducts(), true);  
  }
  @Test (enabled = false) //  1.5 Checkout Cart should be visible to users with Empty.
  public void emptyCartVisible(){
	  logger= report.startTest("Empty Checkout Cart Visibility");
	  HomePage homePage = new HomePage(driver);
	  Assert.assertEquals(homePage.emptyVisibleCart(), "(empty)"); 
  }
  
  
  
  @Test (enabled = false)//*******1.6 User should be able to view the product details layer by clicking quick view link.******
  public void productQuickView(){
  }
  @Test (enabled = false)//*******1.7 User should be able to add the product to wish list from product details layer.******
  public void addWishList(){
  }
  
  
  
  
  @Test (enabled = false)//1.8 User should be able to view details order from My Account section.
  public void viewDetail(){
	  logger= report.startTest("View Accoiunt Detail Order");
	  HomePage homePage = new HomePage(driver);
	  homePage.clickSignIn();
	  SignInPage signInPage = new SignInPage(driver);
	  signInPage.signIn("nurul@gmail.com", "password");
	  AccountPage accountPage = new AccountPage(driver);
	  accountPage.detailOrder();
	  Assert.assertEquals(accountPage.detailHistory(), "ORDER HISTORY");
	  logger.log(LogStatus.PASS, "Users able to View Order Detail");
  }
  @Test (enabled = false) //1.9 Contact Us Link should be presented to the user.
  public void contactLink(){
	  logger= report.startTest("Verify Contact Link");
	  HomePage homePage = new HomePage(driver);
	  homePage.clickContactUs();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  ContactPage contactPage = new ContactPage(driver);
	  Assert.assertEquals(contactPage.contactPageTitle(), "CUSTOMER SERVICE - CONTACT US"); 
	  logger.log(LogStatus.PASS, "Contact Us Link Present");
  }
  @Test (enabled = false) //1.1.1 User should be able to filter result using popular or best seller link
  public void filterResults(){
	  logger= report.startTest("Filter by Bestseller or Popular");
	  HomePage homePage = new HomePage(driver);
	  homePage.clickBestSeller();
	  Assert.assertEquals(homePage.bestSeller(), true);
	  homePage.clickPopular();
	  Assert.assertEquals(homePage.popularSeller(), true);
	  logger.log(LogStatus.PASS, "Able to Filter by Popular or Bestseller");
  }
  @Test (enabled =false) //1.1.2 User should be subscribe/unsubscribe for Upcoming newsletter.
  //***MUST USE DIFFERENT EMAIL EACH TIME, CHANGE IT OVER AT HOMEPAGE UNDER "subNewsletter" METHOD***
  public void subscribeNewsletter(){
	  logger= report.startTest("Subscribing to NewsLetters");
	  HomePage homePage = new HomePage(driver);
	  homePage.subNewsletter();
	  Assert.assertEquals(homePage.subscribeVerify(), "Newsletter : You have successfully subscribed to this newsletter.");
	  logger.log(LogStatus.PASS, "Users able to Subscribe");
  }
 @Test (enabled =false)//1.1.3 User should be able to search for specific products by keyword.
 public void searchByKeyword(){
	 logger= report.startTest("Search By Keywords");
	 HomePage homePage = new HomePage(driver);
	 homePage.searchProducts();
	Assert.assertEquals(false, false);
	logger.log(LogStatus.PASS, "Able to Search By Keywords");
 }
 
 @Test (enabled =false)//1.1.4 User should be presented to follow us on Facebook link
 //***STILL NEEDS WORK***
 public void followOnFacebook(){
	 logger= report.startTest("Following on Fcaebook");
	 HomePage homePage = new HomePage(driver);
	 homePage.facebookFollow(); 
 }
 @Test (enabled = true)// 1.1.5 User should be able to register by clicking Login link
 public void registerNewAccount() {
	  logger = report.startTest("Register New Account");
	  HomePage homePage = new HomePage(driver);
	  logger.log(LogStatus.INFO,"Sign In Clicked");
	  homePage.clickSignIn();
	  SignInPage signInPage = new SignInPage(driver);
	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
	  logger.log(LogStatus.INFO,"Input Valid Email");
	  signInPage.createNewAccount("14@gmail.com");
	  AccountPage accountPage = new AccountPage (driver);
	  logger.log(LogStatus.INFO,"Verify Account Page Displayed");
	  Assert.assertEquals(accountPage.personalInfo(),"YOUR PERSONAL INFORMATION");
	  logger.log(LogStatus.INFO,"Filling Our Personal Info");
	  accountPage.fillOutInfo("Nurul","Amin","password");
	  logger.log(LogStatus.INFO,"Verifying Account Creation");
	  Assert.assertEquals(accountPage.verifyCreated(),"Your account has been created.");
	  logger.log(LogStatus.INFO,"Verifying Account Name");
	  Assert.assertEquals(accountPage.verifyName(),"Nurul Amin");
 }
  
//  @Test (enabled =false) //Test Case 1
//  public void createInvalidEmail() {
//	  logger = report.startTest("Invalid Email Account Creation");
//	  HomePage homePage = new HomePage(driver);
//	  logger.log(LogStatus.INFO,"Sign In Clicked");
//	  homePage.clickSignIn();
//	
//	  SignInPage signInPage = new SignInPage(driver);
//	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
//	  logger.log(LogStatus.INFO,"Input Invalid Email");
//	  signInPage.createNewAccount("nurul");
//	  logger.log(LogStatus.INFO,"Display Invalid Email Error");
//	  signInPage.invalidEmail();
//	  logger.log(LogStatus.PASS, "Invalid Email  Entered & Verified ERROR ALERT");
//  }
  
//  @Test (enabled =false) //Test Case 2
//  public void alreadyRegistered() {
//	  logger = report.startTest("Already Registered Account");
//	  HomePage homePage = new HomePage(driver);
//	  logger.log(LogStatus.INFO,"Sign In Clicked");
//	  homePage.clickSignIn();
//	  
//	  SignInPage signInPage = new SignInPage(driver);
//	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
//	  logger.log(LogStatus.INFO,"Input Registered Email");
//	  signInPage.createNewAccount("rabbani@rabbani.com");
//	  logger.log(LogStatus.INFO,"Display Registered Email Error");
//	  signInPage.registeredEmail();
//	  logger.log(LogStatus.PASS,"Registered Email ALERT verified");
//	
//  }
//  
//  @Test (enabled = false)//Test Case 3
//  public void createNewAccount() {
//	
//	  logger = report.startTest("Create New Account");
//	  HomePage homePage = new HomePage(driver);
//	  logger.log(LogStatus.INFO,"Sign In Clicked");
//	  homePage.clickSignIn();
//	  
//	  SignInPage signInPage = new SignInPage(driver);
//	  Assert.assertEquals(signInPage.createAccountTitle(), "CREATE AN ACCOUNT");
//	  logger.log(LogStatus.INFO,"Input Valid Email");
//	  signInPage.createNewAccount("13@gmail.com");
//	  
//	  AccountPage accountPage = new AccountPage (driver);
//	  logger.log(LogStatus.INFO,"Verify Account Page Displayed");
//	  Assert.assertEquals(accountPage.personalInfo(),"YOUR PERSONAL INFORMATION");
//	  logger.log(LogStatus.INFO,"Filling Our Personal Info");
//	  accountPage.fillOutInfo("Nurul","Amin","password");
//	  logger.log(LogStatus.INFO,"Verifying Account Creation");
//	  Assert.assertEquals(accountPage.verifyCreated(),"Your account has been created.");
//	  logger.log(LogStatus.INFO,"Verifying Account Name");
//	  Assert.assertEquals(accountPage.verifyName(),"Nurul Amin");
//	  accountPage.updateLastName();
//	  Assert.assertEquals(accountPage.verifyLastNameUpdate(),"Nurul Doe");
//	  logger.log(LogStatus.PASS, "New Account Creation Success");
//  }
  
  
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
		
//		driver.close();

		
  }

  @AfterTest
  public void afterTest() {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("C:\\Users\\Aminn\\git\\FinalBfsProject\\NurulBfsProject\\pages.html");
  }

}
