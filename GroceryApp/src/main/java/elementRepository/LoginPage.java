package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	GeneralUtilities gu=new GeneralUtilities();
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//label[@for='remember']")
	WebElement remebermeCheckbox;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalideuserError;
	
	
	public void enterusername(String usernameValue) {
		gu.enterValue(username, usernameValue);
	
	}
	public void enterPassword(String passwordValue) {
		gu.enterValue(password, passwordValue);
	}
	public void clickLoginbutton() {
		gu.clickButton(loginButton);
	}
	
	public void clickRememberCheckBox() {
		gu.clickButton(remebermeCheckbox);
	}
	public Boolean clickRememberMeCheckBoxStatus() {
		
		return gu.checkBoxselected(remebermeCheckbox);
		
	}
	
	public String getInvalidUserErrorMessage() {
		System.out.println(invalideuserError.getText());
		return invalideuserError.getText();
	}

}
