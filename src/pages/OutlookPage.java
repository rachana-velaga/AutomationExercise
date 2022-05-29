package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.chrome.ChromeDriver;


public class OutlookPage {

	WebDriver driver;
	By userName = By.id("i0116");
	By password = By.id("i0118");
	By nextButton = By.id("idSIButton9");
	By loginButton = By.id("idSIButton9");
	By sendCodeButton = By.id("twoFactor-step1-next-button");
	By signInButton = By.className("internal sign-in-link");
	
	public OutlookPage(WebDriver driver){
		this.driver = driver;
	}

	//Click on Sign in button
	public void clickSignInButton(){
		driver.findElement(signInButton).click();
}

	//Set user name in textbox
	public void setUserName(String strUserName){
		driver.findElement(userName).sendKeys(strUserName);;
	}
	
	//Set password in password textbox
	public void setPassword(String strPassword){
		 driver.findElement(password).sendKeys(strPassword);
	}
	
	//Click on login button
	public void clickLogin(){
			driver.findElement(loginButton).click();
	}
	
	//Get the title of Login Page
	public String getLoginTitle(){
	 return	driver.findElement(titleText).getText();
	}
	//click on Send code
	public void clickSendCodeButton(){
		driver.findElement(sendCodeButton).click();
}

	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	public void connecToOutlook(String strUserName,String strPasword){

		
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();		
		
	}

	public void openOutlook() {
		driver= new ChromeDriver();
		driver.get("www.outlook.com");

		driver.waitForElement(signInButton).click();


	}

}
