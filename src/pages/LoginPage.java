package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	WebDriver driver;
	By userName = By.id("loginForm-email-input");
	By password = By.id("loginForm-password-input");
	By loginButton = By.id("loginForm-submit-button");
	By sendCodeButton = By.id("twoFactor-step1-next-button");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
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
	public void loginToLibreView(String strUserName,String strPasword){
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickLogin();		
		
	}
	
}
