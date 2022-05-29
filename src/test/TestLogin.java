package test;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;
import javax.mail.Store;
import com.testing.framework.EmailUtils;

import jxl.Sheet;
import jxl.Workbook;
import pages.HomePage;
import pages.LoginPage;
import pages.OutlookPage;

public class TestLogin {

	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	OutlookPage op;
	String OTP;
	@BeforeTest
	public void setup(){
		driver = new ChromeDriver();
		driver.get("https://www.libreview.com/");
	}



	/**
	 * This test case will login in https://www.libreview.com/ 
	 */
	@Test
	public void test_Home_Page_Appear_Correct(){
		FileInputStream fi=new FileInputStream("C:\Users\rachana\OneDrive\Documents\Book2.xls");
		Workbook w=Workbook.getWorkbook(fi);
		Sheet s= w.getSheet(0);
		try
	  {
	  for (int i = 0; i < s.getRows(); i++)
	  {
	  //Read data from excel sheet
	  /*S1 contains Country 
	  S2 contains Language
	  S3 contains Username
	  S4 contains Password used for Libreview.com
	  S5 contains the Outlook password
	  */

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

//Opening Outlook.com and logging in using credentials
EmailUtils emailUtils = new EmailUtils();

Properties prop2 = new Properties();
prop2.load(new FileInputStream("C:\Users\rachana\eclipse-workspace\AutomationExercise\config\config2.properties");
Store connection= op.connecToOutlook(prop2);

List<String> emailText =emailUtils.getUnreadMessageByFromEmail(connection, "Inbox", "do-not-reply@libreview.io", "LibreView Verification Code");
	if (emaiText.size()<1)
		throw new Exception("No email received");
	else 
	{
		String regex = "[^\\d]+";
		String[] arrOTP = emailText.get(0).split(regex);

		OTP =arrOTP[1];

	}
	
	}
	
}
