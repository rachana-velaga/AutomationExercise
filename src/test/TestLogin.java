package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;
import pages.HomePage;
import pages.LoginPage;

public class TestLogin {

	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	
	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.libreview.com/");
	}



	/**
	 * This test case will login in https://www.libreview.com/
	 * Select Country and click Submit to continue
Country/Region of Residence: United States
Language: English
Type below username and password and click Log In to continue
Username: codechallengeadc@outlook.com
Password: P@ssword$12
On 2FA page, click button Send Code.
Verify button "Verify and Log in” should be disabled
Fetch verification code from outlook.com. 
Login to outlook with below credential to retrieve the 2FA code.
Username: codechallengeadc@outlook.com
P@ssword$1234
Enter code from the email to the page and click Verify and Log in
Verify page contains a button “Press to Begin Upload”
 
	 */
	@Test
	public void test_Home_Page_Appear_Correct(){
		FileInputStream fi=new FileInputStream("C:\\File\\Book2.xls");
		Workbook w=Workbook.getWorkbook(fi);
		Sheet s= w.getSheet(0);
		try
	  {
	  for (int i = 0; i < s.getRows(); i++)
	  {
	  //Read data from excel sheet
		  String s1 = s.getCell(0,i).getContents();
		  String s2 = s.getCell(1,i).getContents();
		  String s3 = s.getCell(2,i).getContents();
		  String s4 = s.getCell(3,i).getContents();
	
	  }    
	}
	catch(Exception e)
	{
	System.out.println(e);
	
	}
	//Create Homepage object
	hp = new HomePage(driver);
	// Select Country and Language
	hp.selectCountry(s1);
	// Select Language
	hp.selectLanguage(s2);
	hp.clickSubmit();
		
		//Create Login Page object
	lp = new LoginPage(driver);
	//Verify login page title
	String loginPageTitle = lp.getLoginTitle();
	Assert.assertTrue(loginPageTitle.toLowerCase().contains("libre view"));
	//login to application
	lp.loginToLibreView(s3, s4);
	//Click on Send code
	lp.clickSendCodeButton();


	
	
	
	}
	
}
