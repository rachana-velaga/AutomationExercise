package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class HomePage {

	WebDriver driver;
//	By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	By languageDropdown = By.id("language-select");
	By countryDropdown = By.id("country-select");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
		public void selectCountry() {
			Select drpCountry= new Select(driver.findElement(countryDropdown));

		}
		public void selectLanguage() {
		}

        public void clickSubmit() {
        }
}
