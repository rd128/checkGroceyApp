package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSliderPage {
	
	GeneralUtilities gu=new GeneralUtilities();

	public ManageSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='List Sliders']")
	WebElement manageSliderLabel;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']")
	WebElement newButton;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelButton;
	
	public void clickNewButton() {
		gu.clickButton(newButton);
	}
	
	public String checkColorSaveButton() {
		return gu.getColorCssValue(saveButton);
	}
	
	public void clickCancelButton() {
		gu.clickButton(cancelButton);
	}
	
	public String getManageSliderLabel() {
		return gu.getElementText(manageSliderLabel);
	}
	
	public void clickOnNewButtonInManageSliderPage() {

		  LoginPage lp=new LoginPage(driver);
		  lp.enterusername("admin");
		  lp.enterPassword("admin"); 
		  lp.clickLoginbutton();
		  
		  HomePage hp=new HomePage(driver); 
		  hp.clickmanageSlider();	  
		  clickNewButton();
	}

}
